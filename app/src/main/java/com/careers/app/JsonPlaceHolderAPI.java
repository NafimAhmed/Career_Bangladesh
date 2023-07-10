package com.careers.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface JsonPlaceHolderAPI {

    @GET("/jobs")
    Call<List<Post>> getPost();


    @GET
    Call<jovSeekerDetail> getjobSeekerDetail(@Url String url);

    @GET
    Call<jovSeekerExpDetail> getjobSeekerExpDetail(@Url String url);


    @GET
    Call<JovSeekerEdu> getjobSeekerEduDetail(@Url String url);




    @POST("/jobSeekersPersonal")
    Call<JobseekerPersonal_detail>savedPersonalDetail(@Body JobseekerPersonal_detail post);

    @POST("/applications")
    Call<Apply_Job>ApplyAJob(@Body Apply_Job post);

    @POST("/jobs")
    Call<Post_job>PostAJob(@Body Post_job post);


    @POST("/users")
    Call<Reg_API>Registration(@Body Reg_API post);


    @POST("/jobSeekersAcademics")
    Call<JobSeekerAcademicdetail>savedAcademicDetail(@Body JobSeekerAcademicdetail post);

    @POST("/jobSeekersExperiences")
    Call<JobSeekerExp>savedExpDetail(@Body JobSeekerExp post);






}
