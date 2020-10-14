package com.example.pdfuploadactivity.Json;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    //Get Job
    @GET("getpdf.php")
    Call<GetPdfResponse> searchJob(
            @Query("invoice_id") String invoice_id

    );
}
