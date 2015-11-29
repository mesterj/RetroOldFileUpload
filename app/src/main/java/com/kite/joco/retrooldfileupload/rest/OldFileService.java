package com.kite.joco.retrooldfileupload.rest;

import retrofit.RestAdapter;

/**
 * Created by Joco on 2015.11.21..
 */
public class OldFileService{
    private static OldFIleApi OLDFILE_API;
    private static String ROOT="http://192.168.1.107:8080/NyomtServ2-1.0/webresources";

    static {
        setupOldFileClient();
    }

    public static OldFIleApi get(){
        return OLDFILE_API;
    }

    private static void setupOldFileClient(){
        //Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        //RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ROOT).setConverter(new GsonConverter(gson)).build();

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ROOT).build();



        OLDFILE_API = restAdapter.create(OldFIleApi.class);
    }
}

