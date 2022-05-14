package com.example.news.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClent {

    private static Retrofit retrofit=null;
    public   static NewsAPI getInstance()
    {
        if(retrofit==null) {
             retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
       return retrofit.create(NewsAPI.class);
    }

}
