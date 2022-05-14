package com.example.news.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.news.R;
import com.example.news.databinding.ActivityMainBinding;
import com.example.news.model.Article;
import com.example.news.adaptor.Adaptor;
import com.example.news.network.NewsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


        private static final String TAG = "MainActivity";
        private  ActivityMainBinding binding ;
        private Adaptor adaptor;
        private  RecyclerView recyclerView ;
        private  NewsViewModel newsViewModel;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
    newsViewModel=new ViewModelProvider(this).get(NewsViewModel.class);
    recyclerView=findViewById(R.id.main_recycler_view);

   newsViewModel.getNews();
   newsViewModel.mutableLiveData.observe(this, new Observer<List<Article>>() {
    @Override
    public void onChanged(List<Article> articles) {
        adaptor=new Adaptor(articles);
        recyclerView.setAdapter(adaptor);

    }
});

    }
}