package com.careers.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderJobcatagory {
    @GET("/jobCategories")
    Call<List<PostCatagory>> getPostCatagory();
}
