package com.example.schoolanswer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.schoolanswer.R;
import com.example.schoolanswer.activity.NewContentActivity;
import com.example.schoolanswer.db.DataBean;

import java.util.List;

/**
 * Created by 权 on 2018/3/28.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{


    private Context context;
    private List<DataBean> NewsItem;


    public NewsAdapter(List<DataBean> NewsItem){
        this.NewsItem = NewsItem;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private AppCompatImageView appCompatImageView;
        private TextView title;
        private TextView author_name;
        private TextView date;


        public NewsViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            appCompatImageView = (AppCompatImageView) itemView.findViewById(R.id.iv_item_image);
            title = (TextView) itemView.findViewById(R.id.tv_item_title);
            author_name = (TextView) itemView.findViewById(R.id.tv_item_who);
            date = (TextView) itemView.findViewById(R.id.tv_item_time);
        }
    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context==null){
            context = parent.getContext();
        }

        View view = LayoutInflater.from(context).inflate(R.layout.new_item,parent,false);
        final NewsViewHolder newsViewHolder = new NewsViewHolder(view);

        newsViewHolder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = newsViewHolder.getAdapterPosition();
                DataBean news = NewsItem.get(position);
                Intent intent = new Intent(context, NewContentActivity.class);
                intent.putExtra(NewContentActivity.TITLE,news.getTitle());
                intent.putExtra(NewContentActivity.IMAGE,news.getThumbnail_pic_s());
                intent.putExtra(NewContentActivity.URL,news.getUrl());
                context.startActivity(intent);
            }
        });


        return newsViewHolder;

    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        DataBean news = NewsItem.get(position);
        Glide.with(context).load(news.getThumbnail_pic_s()).into(holder.appCompatImageView);
        holder.title.setText(news.getTitle());
        holder.author_name.setText(news.getAuthor_name());
        holder.date.setText(news.getDate().split(" ")[0]);
    }

    @Override
    public int getItemCount() {
        return NewsItem.size();
    }

}
