package com.careers.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JsonPlaceHoldeEmpty {
    @GET
    Call<List<PostEmployer>> getPost(@Url String url);

}
