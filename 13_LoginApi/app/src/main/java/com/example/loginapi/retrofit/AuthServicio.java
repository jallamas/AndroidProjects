package com.example.loginapi.retrofit;

import com.example.loginapi.retrofit.request.ReqNewTask;
import com.example.loginapi.retrofit.response.ResponseTask;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AuthServicio {

    @GET("tasks")
    Call<List<ResponseTask>> getTasks();

    @POST("tasks")
    Call<ResponseTask> newTask(@Body ReqNewTask reqNewTask);
}
