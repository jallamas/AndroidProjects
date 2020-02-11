package org.jallamas.loginapp.retrofit;

import okhttp3.internal.concurrent.Task;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IServicio {

    @POST("/login")
    Call<Task> login(@Body Task task);

}
