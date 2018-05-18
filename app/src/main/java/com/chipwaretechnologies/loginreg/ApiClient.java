package com.chipwaretechnologies.loginreg;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by likit on 5/8/2018.
 */

public class ApiClient {

    public static final String BASE_URL ="http://10.0.2.2/registerloginapp/";
    public static Retrofit retrofit =null;

    public static Retrofit getApiClient(){

        if(retrofit==null)
        {
            retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
