package com.example.news.adaptor;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.R;
import com.example.news.databinding.ItemNewsBinding;
import com.example.news.model.Article;

import java.util.List;

public class Adaptor extends RecyclerView.Adapter<Adaptor.NewsViewHolder>{

    List <Article>list ;

    public Adaptor(List<Article> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



   return  new NewsViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
   ,R.layout.item_news,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.binding.setArticle(list.get(position));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }




     class NewsViewHolder extends RecyclerView.ViewHolder{
      ItemNewsBinding binding;

        public NewsViewHolder(@NonNull  ItemNewsBinding binding) {
            super(binding.getRoot());
          this.binding=binding;
        }
    }

}
