package com.kite.joco.retrooldfileupload.rest;

import java.util.Date;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;

/**
 * Created by Joco on 2015.11.21..
 */
public interface OldFIleApi {

    @Multipart
    @POST("/com.joco.nyomtserv2.sajatservices/upload")
    void upload(@Part("file") TypedFile file,
                Callback<String> cb);

    @GET("/datumos/{date}")
    void datumkuld(@Body Date date, Callback<String> cb);

}
