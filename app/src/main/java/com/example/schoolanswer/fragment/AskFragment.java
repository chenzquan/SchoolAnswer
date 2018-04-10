package com.example.schoolanswer.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolanswer.BaseFragment;
import com.example.schoolanswer.R;
import com.example.schoolanswer.utils.ShowToast;
import com.example.schoolanswer.utils.TitleBuilder;
import com.example.schoolanswer.utils.Utility;

/**
 * Created by 权 on 2018/3/6.
 */

public class AskFragment extends BaseFragment implements View.OnClickListener{
    private View view;
    private TextView titlebar_tv;

    private Button tijiao;
    private EditText question;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = View.inflate(activity, R.layout.frag_ask, null);


        tijiao = (Button) view.findViewById(R.id.tijiao);
        question = (EditText) view.findViewById(R.id.question);

        tijiao.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tijiao){
            String str_question = question.getText().toString();
            if (!TextUtils.isEmpty(str_question)){
                ShowToast.makeToast("问题提交成功,请等待审核",getActivity());
            }else{
                ShowToast.makeToast("请填写问题",getContext());
            }
        }
    }
}
