package org.jallamas.themoviedbseries.retrofit;

import org.jallamas.themoviedbseries.response.ResponsePopular;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface SeriesService {

    @GET("popular")
    Call<ResponsePopular> getPopulares(@Body ReqLogin reqLogin);

}
