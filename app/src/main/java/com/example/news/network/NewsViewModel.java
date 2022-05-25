package com.example.news.network;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.news.model.Article;
import com.example.news.model.News;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    private final MutableLiveData<List<Article>> mutableLiveData=new MutableLiveData();

    private static final String TAG = "NewsViewModel";
public   static final CompositeDisposable  compositeDisposable =new CompositeDisposable();


    public LiveData<List<Article>> getNews()
    {
        ArrayList <String>kind=new ArrayList<>();
        kind.add("Sports");
        kind.add("Technology");

        Date date=new Date();
   String day=date.getDate()+"-";
   String month=date.getMonth()+"-";
   String year= "2022";//" "+date.getYear();

        String today=day+month+year;
        Log.i(TAG, "getNews: date  format date is"+today);
        RetrofitClent.getInstance().getNewsByQuery(kind.get(1),today,today,"w").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<News>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(News value) {
mutableLiveData.postValue(value.getArticles());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: "+e.getLocalizedMessage());
                    }
                });
//        RetrofitClent.getInstance().getNewsByQuery(kind.get(0).toString(),s,s,"w")
//                .subscribeOn(Schedulers.io())
//                .observeOn(.mainThread())
//                .subscribe(new SingleObserver<News>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(@NonNull News news) {
//                        mutableLiveData.postValue(news.getArticles());
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.i(TAG, "onError: "+e.getLocalizedMessage());
//                    }
//                });
//        RetrofitClent.getInstance().getnews().enqueue(new Callback<News>() {
//            @Override
//            public void onResponse(Call<News> call, Response<News> response) {
//                mutableLiveData.postValue(response.body().getArticles());
//            }
//
//            @Override
//            public void onFailure(Call<News> call, Throwable t) {
//               // Toast.makeText(this, ""+t.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
        return mutableLiveData;
    }


}
