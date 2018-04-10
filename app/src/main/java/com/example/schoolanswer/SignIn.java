package com.example.schoolanswer;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.schoolanswer.utils.HttpUtil;
import com.example.schoolanswer.utils.ShowToast;
import com.example.schoolanswer.utils.Tool;
import com.example.schoolanswer.utils.Utility;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 权 on 2018/1/12.
 */

public class SignIn extends Fragment implements View.OnClickListener {

    private EditText mobileNumber;
    private EditText signInPassword;
    private Button sign_in_button;

    private String moNum;
    private String password;

    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg){
            switch (msg.what){
                case 0:
                    ShowToast.makeToast("登录超时",getContext());
                    break;
                case 1:
                    ShowToast.makeToast("登录成功",getContext());
                    getActivity().onBackPressed();
                    Intent intent = new Intent(getActivity(),MainActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    ShowToast.makeToast("登录失败",getContext());
                    break;
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sign_in, container, false);

        mobileNumber = (EditText) view.findViewById(R.id.account);
        signInPassword = (EditText) view.findViewById(R.id.password);
        sign_in_button = (Button) view.findViewById(R.id.sign_in);
        signInPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());//设置将密码隐藏

        sign_in_button.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.sign_in){

            moNum = mobileNumber.getText().toString().trim();
            password = signInPassword.getText().toString().trim();

            if (Tool.judgeAccount(moNum,getContext()) && Tool.juegePassword(password,getContext())){
                handler.sendEmptyMessage(1);
//                HttpUtil.RequestRegisteredOrLogin("http://localhost:8080/login", moNum, password, new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        e.printStackTrace();
//                        handler.sendEmptyMessage(0);
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        final String responseMessage = response.body().string();
//
//                        if(Utility.handUserMessage(responseMessage))
//                        {
//                            handler.sendEmptyMessage(1);
//
//                        }else{
//                            handler.sendEmptyMessage(2);
//
//                        }
//                    }
//                });
            }

            getActivity().onBackPressed();//销毁当前的fragment
            Intent intent = new Intent(getActivity(),MainActivity.class);
            startActivity(intent);
        }
    }
}
