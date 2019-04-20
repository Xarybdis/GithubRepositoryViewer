package com.example.emrullah.githubrepoviewer;

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseWorks {


    Retrofit retrofit;
    JsonApiHolder jsonApiHolder;

    public Retrofit getRetrofit(Context context){

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }
}
