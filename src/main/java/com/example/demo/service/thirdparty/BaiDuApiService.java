package com.example.demo.service.thirdparty;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BaiDuApiService {

    @GET("/")
    Call<ResponseBody> homePage();

}
