package com.example.schoolanswer.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolanswer.BaseFragment;
import com.example.schoolanswer.R;
import com.example.schoolanswer.utils.TitleBuilder;


public class SchoolFragment extends BaseFragment {

	private View view;
	private TextView titlebar_tv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = View.inflate(activity, R.layout.frag_message, null);
		/*new TitleBuilder(view)
				.setTitleText("消息")
				.setLeftText("LEFT")
				.setLeftOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Toast.makeText(activity,"click~",Toast.LENGTH_SHORT).show();
					}
				});*/

		return view;
	}

}
