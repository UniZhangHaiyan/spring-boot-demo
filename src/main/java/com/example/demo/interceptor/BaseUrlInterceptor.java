package com.example.demo.interceptor;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @ClassName BaseUrlInterceptor
 * @Description baseUrl切换拦截器
 * @Author zhanghaiyan
 * @Date 2021/8/1
 * @Modifier
 */
public class BaseUrlInterceptor implements Interceptor {
    private static final String BASE_URL = "baseUrl";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        String newUrl = originalRequest.header(BASE_URL);
        if (StringUtils.isEmpty(newUrl)) {
            return chain.proceed(originalRequest);
        }
        HttpUrl parseHttpUrl = HttpUrl.parse(originalRequest.header(BASE_URL));
        Request.Builder builder = originalRequest.newBuilder();
        HttpUrl newHttpUrl = originalRequest.url().newBuilder()
                .scheme(parseHttpUrl.scheme())
                .host(parseHttpUrl.host())
                .port(parseHttpUrl.port())
                .build();
        builder.removeHeader(BASE_URL);
        Request newRequest = builder.url(newHttpUrl).build();
        return chain.proceed(newRequest);
    }
}
