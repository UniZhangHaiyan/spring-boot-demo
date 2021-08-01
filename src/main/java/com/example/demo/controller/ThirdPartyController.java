package com.example.demo.controller;

import com.example.demo.service.thirdparty.BaiDuApiService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * @ClassName RetrofitController
 * @Description 三方请求类
 * @Author zhanghaiyan
 * @Date 2021/8/1
 * @Modifier
 */
@RestController
public class ThirdPartyController {
    @Autowired
    private Retrofit retrofit;

    @GET("/getBaiDu")
    public String getBaiDu() {
        BaiDuApiService baiDuApiService = retrofit.create(BaiDuApiService.class);
        Call<ResponseBody> call = baiDuApiService.homePage();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                System.out.println("error !");
            }
        });
        return "";
    }
}
