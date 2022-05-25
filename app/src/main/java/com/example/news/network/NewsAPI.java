package com.example.news.network;

import com.example.news.model.News;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsAPI {

@GET("v2/everything?q=sam&from=2022-05-20&to=2022-05-20&sortBy=popularity&apiKey=5deda0267f2249a78a48ea54974074ea")
Observable<News> getnews();


@GET("v2/everything?apiKey=5deda0267f2249a78a48ea54974074ea")
Single<News> getNewsByQuery(@Query("q") String q , @Query("from") String from , @Query("to") String to , @Query("sortBy") String sort);

@GET("v2/{kind}?q=oppo&from=2022-05-15&to=2022-05-20&sortBy=popularity&apiKey=5deda0267f2249a78a48ea54974074ea")
Call <News>getNewsBySort(@Path("kind") String everything );
}
