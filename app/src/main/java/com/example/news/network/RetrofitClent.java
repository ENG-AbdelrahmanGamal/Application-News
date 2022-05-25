package com.example.news.network;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClent {

    private static Retrofit retrofit=null;
    public   static NewsAPI getInstance()
    {
        if(retrofit==null) {
             retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                     .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        }
       return retrofit.create(NewsAPI.class);
    }

}
