package com.careers.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {

    @GET("/jobs")
    Call<List<Post>> getPost();

}
