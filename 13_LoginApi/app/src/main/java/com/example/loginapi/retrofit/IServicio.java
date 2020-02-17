package com.example.loginapi.retrofit;

import com.example.loginapi.retrofit.request.ReqLogin;
import com.example.loginapi.retrofit.request.ReqRegister;
import com.example.loginapi.retrofit.response.ResponseAuth;
import com.example.loginapi.retrofit.response.ResponseRegister;
import com.example.loginapi.retrofit.response.ResponseTask;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IServicio {

    @POST("login")
    Call<ResponseAuth> doLogin(@Body ReqLogin reqLogin);

    @POST("register")
    Call<ResponseRegister> doRegister(@Body ReqRegister reqRegister);

    @GET("tasks/")
    Call<ResponseTask> getTasks();

}
