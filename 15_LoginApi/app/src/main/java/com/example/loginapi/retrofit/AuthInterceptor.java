package com.example.loginapi.retrofit;

import com.example.loginapi.common.Constantes;
import com.example.loginapi.common.SharedPreferencesManager;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        String token = SharedPreferencesManager.getStringValue(Constantes.PREF_TOKEN);
        Request request = chain.request().newBuilder().addHeader("Authorization","Bearer " + token).build();
        return chain.proceed(request);
    }
}
