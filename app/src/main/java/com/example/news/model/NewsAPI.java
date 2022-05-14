package com.example.news.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsAPI {

@GET("v2/everything?q=sam&from=2022-05-10&to=2022-05-13&sortBy=popularity&apiKey=5deda0267f2249a78a48ea54974074ea")
    Call<News>getnews();


@GET("v2/everything?apiKey=5deda0267f2249a78a48ea54974074ea")
    Call<News>getNewsByQuery(@Query("q") String q ,@Query("from") String from ,@Query("to") String to ,@Query("sortBy") String sort);

@GET("v2/{kind}?q=oppo&from=2022-05-10&to=2022-05-10&sortBy=popularity&apiKey=5deda0267f2249a78a48ea54974074ea")
Call <News>getNewsBySort(@Path("kind") String everything );
}
