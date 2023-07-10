package com.careers.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface JsonPlaceHolderSavedJob {

    @GET
    Call<List<PostSavedJob>> getPost(@Url String url);

    @GET
    Call<PostJobDetail> getPostjobDetail(@Url String url);


    @POST("/savedjobs")
    Call<Saved_Job_post>savedJob(@Body Saved_Job_post post);



//    @GET("/jobseekersavedjobs?email={user}")
//    Call<List<PostSavedJob>> getPost(@Path("user") String user);

}
