package android.salesianostriana.com.a03_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface GitHubService {

    @Headers("Cache-Control: max-age=86400")
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);


}
