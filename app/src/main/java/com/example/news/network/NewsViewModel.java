package com.example.news.network;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.news.model.Article;
import com.example.news.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    private final MutableLiveData<List<Article>> mutableLiveData=new MutableLiveData();

    public LiveData<List<Article>> getNews()
    {
        RetrofitClent.getInstance().getnews().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                mutableLiveData.postValue(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
               // Toast.makeText(this, ""+t.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return mutableLiveData;
    }


}
