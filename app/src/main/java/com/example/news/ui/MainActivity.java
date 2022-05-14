package com.example.news.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.news.R;
import com.example.news.databinding.ActivityMainBinding;
import com.example.news.model.News;
import com.example.news.model.NewsAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
        ActivityMainBinding binding ;
        private static final String TAG = "MainActivity";
        private   Adaptor adaptor;
        private  RecyclerView recyclerView ;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        recyclerView=findViewById(R.id.main_recycler_view);

        Retrofit  retrofit=new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//this part concatenate  two link base url and end point //
        NewsAPI newsAPI=retrofit.create(NewsAPI.class);
// call to server and retuen data //
        newsAPI.getnews().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if( response.isSuccessful()&&response.body()!=null)
                {
                    News news=response.body();
                    Log.i(TAG, "onResponse: "+news.getArticles().get(2).getUrlToImage());
                    adaptor=new Adaptor(news.getArticles());
                    recyclerView.setAdapter(adaptor);



                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
            String error = t.getLocalizedMessage().toString();
                Toast.makeText(MainActivity.this, " the failure because  :"+error, Toast.LENGTH_SHORT).show();
            }
        });

    }
}