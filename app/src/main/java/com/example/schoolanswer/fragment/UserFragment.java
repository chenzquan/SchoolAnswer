package com.example.schoolanswer.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolanswer.BaseFragment;
import com.example.schoolanswer.R;
import com.example.schoolanswer.activity.Activity_answers;
import com.example.schoolanswer.activity.Activity_collection;
import com.example.schoolanswer.activity.Activity_question;
import com.example.schoolanswer.activity.Activity_userinfo;

import static android.app.Activity.RESULT_OK;


public class UserFragment extends BaseFragment implements View.OnClickListener {
	
	private View view;
    private LinearLayout user_layout;
	private LinearLayout question_layout;
    private LinearLayout answers_layout;
    private LinearLayout collection_layout;
    private TextView user_name;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = View.inflate(activity, R.layout.frag_user, null);

        user_layout = (LinearLayout) view.findViewById(R.id.ll_userinfo);
        user_layout.setOnClickListener(this);

		question_layout = (LinearLayout) view.findViewById(R.id.user_ask_layout);
		question_layout.setOnClickListener(this);

        answers_layout = (LinearLayout) view.findViewById(R.id.user_answer_layout);
        answers_layout.setOnClickListener(this);

        collection_layout = (LinearLayout) view.findViewById(R.id.user_collection_layout);
        collection_layout.setOnClickListener(this);

        user_name = (TextView) view.findViewById(R.id.tv_subhead);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());//从SharedPreferences中读取数据
        String username = prefs.getString("user_name",null);
        if(username!=null)
            user_name.setText(username);

		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
            case R.id.ll_userinfo:
                Intent user2userinfo = new Intent(activity, Activity_userinfo.class);
                startActivityForResult(user2userinfo,Activity_userinfo.RETURN_USERNAME);
              //  startActivity(user2userinfo);
                break;
			case R.id.user_ask_layout:
				Intent user2question = new Intent(activity, Activity_question.class);
                startActivity(user2question);
                break;
            case R.id.user_answer_layout:
                Intent user2answers = new Intent(activity, Activity_answers.class);
                startActivity(user2answers);
                break;
            case R.id.user_collection_layout:
                Intent user2collection = new Intent(activity, Activity_collection.class);
                startActivity(user2collection);
                break;

            default:
                break;
		}
	}

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==Activity_userinfo.RETURN_USERNAME && resultCode==RESULT_OK){
            String name = data.getStringExtra(String.valueOf(Activity_userinfo.RETURN_USERNAME));
            user_name.setText(name);
        }
    }
}
