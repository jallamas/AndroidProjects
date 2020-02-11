package com.example.loginapi.retrofit;

import com.example.loginapi.retrofit.request.ReqLogin;
import com.example.loginapi.retrofit.response.ResponseAuth;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IServicio {

    @POST("login")
    Call<ResponseAuth> doLogin(@Body ReqLogin reqLogin);

}
