package com.careers.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JsonPlaceHolderSavedJob {

    @GET
    Call<List<Post>> getPost(@Url String url);

}