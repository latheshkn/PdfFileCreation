package com.example.pdfuploadactivity.Json;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    //Get Job
    @GET("search_job.php")
    Call<JobResponse> searchJob(
            @Query("skill") String skills,
            @Query("location") String location
    );
}
