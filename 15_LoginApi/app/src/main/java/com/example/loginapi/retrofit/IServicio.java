package com.example.loginapi.retrofit;

import com.example.loginapi.retrofit.request.ReqLogin;
import com.example.loginapi.retrofit.request.ReqRegister;
import com.example.loginapi.retrofit.response.ResponseAuth;
import com.example.loginapi.retrofit.response.ResponseRegister;
import com.example.loginapi.retrofit.response.ResponseTask;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface IServicio {

    @POST("login")
    Call<ResponseAuth> doLogin(@Body ReqLogin reqLogin);

    @POST("register")
    Call<ResponseRegister> doRegister(@Body ReqRegister reqRegister);

    @Multipart
    @POST("register")
    Call<ResponseRegister> doRegister(@Part MultipartBody.Part avatar,
                                  @Part("usuario") RequestBody email,
                                  @Part("username") RequestBody username,
                                  @Part("password") RequestBody password,
                                  @Part("password2") RequestBody password2);

}
