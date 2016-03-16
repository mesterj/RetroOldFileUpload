package com.kite.joco.retrooldfileupload.rest;

import com.kite.joco.retrooldfileupload.entity.Ember;


import com.squareup.okhttp.ResponseBody;

import java.util.Date;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;

/**
 * Created by Joco on 2015.11.21..
 */
public interface OldFIleApi {

    @Multipart
    @POST("/upload")
    void upload(@Part("file") TypedFile file,Callback<String> cb);

    @Multipart
    @POST("/upload")
    void uploadnew(@Part("file") TypedFile file,Callback<Response> cb);

    @GET("/datumos/{date}")
    void datumkuld(@Body Date date, Callback<String> cb);

    @Headers( "Content-Type: application/json" )
    @POST("/jsonreq")
    void sendEmber( @Body Ember e, Callback<String> cb);
}