package com.example.schoolanswer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolanswer.BaseFragment;
import com.example.schoolanswer.Question.QuestionItem;
import com.example.schoolanswer.Question.QuestionLab;
import com.example.schoolanswer.R;
import com.example.schoolanswer.activity.Main2answers;
import com.example.schoolanswer.adapter.QuestionAdapter;
import com.example.schoolanswer.utils.TitleBuilder;

import org.w3c.dom.Text;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.schoolanswer.R.id.fanhui;
import static com.example.schoolanswer.R.id.news_list;


public class HomeFragment extends BaseFragment  {


	private View view;


	private RecyclerView Question_list;

	private QuestionAdapter questionAdapter;

	private SwipeRefreshLayout swipeRefresh;

	private List<QuestionItem> mquestionItem;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = View.inflate(activity, R.layout.frag_home, null);



		swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
		swipeRefresh.setColorSchemeResources(R.color.black);
		swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
			@Override
			public void onRefresh() {
				refreshQuestion();
			}
		});


		Question_list = (RecyclerView) view.findViewById(R.id.question_list);
		Question_list.setLayoutManager(new LinearLayoutManager(getActivity()));

		updateUI();
		return view;
	}

	private void updateUI(){
		QuestionLab questionLab = QuestionLab.get(getActivity());
		mquestionItem = questionLab.getmQuestionItem();
		questionAdapter = new QuestionAdapter(mquestionItem);
		Question_list.setAdapter(questionAdapter);

	}

	private void refreshQuestion(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				Collections.shuffle(mquestionItem);
				questionAdapter.notifyDataSetChanged();
				swipeRefresh.setRefreshing(false);
			}
		}).start();
	}




}



