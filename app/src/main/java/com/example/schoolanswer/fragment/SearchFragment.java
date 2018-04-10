package com.example.schoolanswer.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.schoolanswer.BaseFragment;
import com.example.schoolanswer.R;
import com.example.schoolanswer.adapter.NewsAdapter;
import com.example.schoolanswer.adapter.handRequest;
import com.example.schoolanswer.db.DataBean;
import com.example.schoolanswer.db.News;
import com.example.schoolanswer.utils.HttpUtil;
import com.example.schoolanswer.utils.ShowToast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.R.attr.type;
import static android.os.Build.VERSION_CODES.N;


public class SearchFragment extends BaseFragment {
	
	private View view;

	private RecyclerView recyclerView;

	private static List<DataBean> newslist = new ArrayList<DataBean>();

	private NewsAdapter newsAdapter;

	private SwipeRefreshLayout swipeRefresh_new;

	private String [] typeNews = {"shehui","guonei","guoji","yule","tiyu","junshi","keji","caijing","shishang","top"};

    private static int i=0;//用于数第几个类型

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = View.inflate(activity, R.layout.frag_new, null);

		recyclerView = (RecyclerView) view.findViewById(R.id.news_list);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());//从SharedPreferences中读取数据
        String NewsString = prefs.getString("News",null);  //

        if(NewsString!=null){
            newslist = new ArrayList<DataBean>();
            newslist = handRequest.handRequestNew(NewsString,newslist);
            showUI();
        }else{
            ReturnJsonData("top");
        }

		swipeRefresh_new = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
		swipeRefresh_new.setColorSchemeResources(R.color.black);
		swipeRefresh_new.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {

				String type = typeNews[i];
				i = (i+1)%typeNews.length;

				lodeMore(type);
				newsAdapter.notifyDataSetChanged();
				swipeRefresh_new.setRefreshing(false);
			}
		});
//
//		swipeRefresh_new = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
//		swipeRefresh_new.setColorSchemeResources(R.color.black);
//		swipeRefresh_new.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
//			@Override
//			public void onRefresh() {
//
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                      //  newslist.clear();
//                        ReturnJsonData(typeNews[i]);
//                        i = (i+1)%typeNews.length;
//                        newsAdapter.notifyDataSetChanged();
//                        swipeRefresh_new.setRefreshing(false);
//                    }
//                }).start();
//			}
//		});


		return view;
	}


	public void ReturnJsonData(String type){
        String url = "http://v.juhe.cn/toutiao/index?type=" + type + "&key=6be6d6fbfabd3ea4e9475c0c68a63928";

		HttpUtil.RequestNew(url, new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
				new Thread(new Runnable() {
					@Override
					public void run() {
						ShowToast.makeToast("加载信息失败",getActivity());
					}
				});
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String JsonData = response.body().string();
			//	newslist = new ArrayList<DataBean>();
				newslist = handRequest.handRequestNew(JsonData,newslist);


                if (newslist.size()!=0){
                    SharedPreferences.Editor editor = PreferenceManager
                            .getDefaultSharedPreferences(getContext()).edit();
                    editor.putString("News",JsonData);
                    editor.apply();
                    showUI();
                }else{
                    ShowToast.makeToast("加载信息失败",getContext());
                }
			}
		});
	}

	public void showUI(){
		newsAdapter = new NewsAdapter(newslist);
		recyclerView.setAdapter(newsAdapter);
	}


	public void lodeMore(String type){
		String url = "http://v.juhe.cn/toutiao/index?type=" + type + "&key=6be6d6fbfabd3ea4e9475c0c68a63928";

		HttpUtil.RequestNew(url, new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String JsonData = response.body().string();
				List<DataBean> templist = new ArrayList<DataBean>();
				templist = handRequest.handRequestNew(JsonData,templist);
				newslist.addAll(0,templist);
			}
		});

	}
	
}


