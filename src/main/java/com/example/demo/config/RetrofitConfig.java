package com.example.demo.config;

import com.example.demo.interceptor.BaseUrlInterceptor;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RetrofitConfig
 * @Description retrofit 配置
 * @Author zhanghaiyan
 * @Date 2021/8/1
 * @Modifier
 */
@Configuration
public class RetrofitConfig extends BaseUrlManager{

    @Bean
    public BaseUrlInterceptor baseUrlInterceptor() {
        return new BaseUrlInterceptor();
    }

    @Bean
    public OkHttpClient okHttpClient() {
        //连接池
        ConnectionPool connectionPool = new ConnectionPool(200, 5, TimeUnit.MINUTES);
        //日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectionPool(connectionPool)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .addInterceptor(baseUrlInterceptor())//baseUrl切换拦截器
                .addNetworkInterceptor(httpLoggingInterceptor);
        return builder.build();
    }

    @Bean
    public Retrofit retrofit () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrlManager.DEFAULT_URL)
                .client(okHttpClient())
                .addConverterFactory(nullOnEmptyConverterFactory())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit;
    }

    @Bean
    public NullOnEmptyConverterFactory nullOnEmptyConverterFactory() {
        return new NullOnEmptyConverterFactory();
    }

    /**
     * 处理空的响应
     */
    @Configuration
    public class NullOnEmptyConverterFactory extends Converter.Factory {
        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
            return (Converter<ResponseBody, Object>) body -> {
                if (body.contentLength() == 0) return null;
                return delegate.convert(body);
            };
        }
    }
}
