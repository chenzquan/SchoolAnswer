package com.example.schoolanswer.adapter;

import android.util.Log;

import com.example.schoolanswer.db.DataBean;
import com.example.schoolanswer.db.News;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by 权 on 2018/3/28.
 */

public class handRequest {
    public static List<DataBean> handRequestNew(String JsonData, List<DataBean> newslist){
        Gson gson = new Gson();
//        List<News> newsList = gson.fromJson(str,new TypeToken<List<News>>(){}.getType());
//
//        for(News news : newsList){
//            Log.d("handRequest",news.getTitle());
//            Log.d("handRequest",news.getAuthor_name());
//            Log.d("handRequest",news.getDate());
//            Log.d("handRequest",news.getUrl());
//            Log.d("handRequest",news.getThumbnail_pic_s());
//        }

        News news = gson.fromJson(JsonData,News.class);
        for(int i=0; i<news.getResult().getData().size(); i++){
            newslist.add(news.getResult().getData().get(i));
//            Log.d("handRequest",news.getResult().getData().get(i).getTitle());
//            Log.d("handRequest",news.getResult().getData().get(i).getAuthor_name());
//            Log.d("handRequest",news.getResult().getData().get(i).getDate());
//            Log.d("handRequest",news.getResult().getData().get(i).getUrl());
//            Log.d("handRequest",news.getResult().getData().get(i).getThumbnail_pic_s());
        }

        return newslist;
    }
}
