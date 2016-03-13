package com.kite.joco.retrooldfileupload.rest;


import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit.RestAdapter;
import retrofit.converter.*;
import retrofit.converter.JacksonConverter;

/**
 * Created by Joco on 2015.11.21..
 */
public class OldFileService{
    private static OldFIleApi OLDFILE_API;
    private static final String ROOT="http://192.168.86.2:8080/NyomtServ1-1.0/webresources/com.mycompany.nyomtserv1.upload";
    //private static String ROOT="http://192.168.1.107:8080/NyomtServ-1.0/webresources/com.mycompany.nyomtserv1.upload";

    static {
        setupOldFileClient();
    }

    public static OldFIleApi get(){
        return OLDFILE_API;
    }

    private static void setupOldFileClient(){
        //Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        //RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ROOT).setConverter(new GsonConverter(gson)).build();

        //RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ROOT).setConverter(jacksonConverter).build();

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ROOT).setConverter(new JacksonConverter(new ObjectMapper())).build();



        OLDFILE_API = restAdapter.create(OldFIleApi.class);
    }
}

