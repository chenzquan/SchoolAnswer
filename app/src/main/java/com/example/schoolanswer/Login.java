package com.example.schoolanswer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.example.schoolanswer.User.UserAccount;
import com.example.schoolanswer.utils.HttpUtil;
import com.example.schoolanswer.utils.JuheDemo;
import com.example.schoolanswer.utils.ShowToast;
import com.example.schoolanswer.utils.Tool;
import com.example.schoolanswer.utils.Utility;

import java.io.IOException;
import java.sql.Time;
import java.util.function.ToLongBiFunction;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.example.schoolanswer.R.layout.login;
import static com.example.schoolanswer.utils.JuheDemo.getRequest;


/**
 * Created by 权 on 2018/1/12.
 */

public class Login extends Fragment implements View.OnClickListener{

    private EditText loginInAccount;
    private EditText loginInPassword;
    private EditText verification_code;
    private Button get_verification_code;
    private Button login_in;
    private Button password_eye;
    private Boolean isOpen = false;


    private TimeCount time;


    private String account_number;
    private String password;
    private String verification_code_str;

    private int returnVerificationCode = 0;


    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg){
            switch (msg.what){
                case 0:
                    ShowToast.makeToast("注册超时",getContext());
                    break;
                case 1:
                    ShowToast.makeToast("注册成功",getContext());
                    getActivity().onBackPressed();
                    Intent intent = new Intent(getActivity(),MainActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    ShowToast.makeToast("注册失败",getContext());
                    break;
            }
        }
    };


//    public EventHandler eh; //事件接收器
  //  private TimeCount mTimeCount;//计时器

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(login,container,false);
        loginInAccount = (EditText) view.findViewById(R.id.login_in_account);
        loginInPassword = (EditText) view.findViewById(R.id.login_in_password);
        verification_code = (EditText) view.findViewById(R.id.verification_code);
        get_verification_code = (Button) view.findViewById(R.id.get_verification_code);
        login_in = (Button) view.findViewById(R.id.login_in);
        password_eye = (Button) view.findViewById(R.id.password_eye);

        get_verification_code.setOnClickListener(this);
        login_in.setOnClickListener(this);
        password_eye.setOnClickListener(this);

        time = new TimeCount(60000,1000);//设置获取验证码的时间



        loginInPassword.addTextChangedListener(new TextWatcher() {//用于密码的显示
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = loginInAccount.getText().toString().trim();


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_in:
                account_number = loginInAccount.getText().toString().trim();
                password = loginInPassword.getText().toString().trim();
                verification_code_str = verification_code.getText().toString().trim();

                if(!verification_code_str.equals(String.valueOf(returnVerificationCode))){
                    ShowToast.makeToast("验证码错误",getContext());
                }else{
                    if(Tool.judgeAccount(account_number,getActivity()) && Tool.juegePassword(password,getActivity())){
                        handler.sendEmptyMessage(1);
 //                       HttpUtil.RequestRegisteredOrLogin("http://0ee4eb9a.ngrok.io/add",account_number, password, new Callback() {
//                            @Override
//                            public void onFailure(Call call, IOException e) {
//                                e.printStackTrace();
//                                handler.sendEmptyMessage(0);
//                            }
//
//                            @Override
//                            public void onResponse(Call call, Response response) throws IOException {
//                                final String responseMessage = response.body().string();
//
//                                if(Utility.handUserMessage(responseMessage))
//                                {
//                                    handler.sendEmptyMessage(1);
//
//                                }else{
//                                    handler.sendEmptyMessage(2);
//
//                                }
//                            }
//                        });
                    }
                }

//
//                try {
//                    HttpUtil.sendOkHttpRequest("http://5e9bc93a.ngrok.io/add");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(getActivity(),MainActivity.class);
//                startActivity(intent);

                break;
            case R.id.get_verification_code:
                account_number = loginInAccount.getText().toString().trim();
                if(Tool.judgeAccount(account_number,getActivity())){
                    returnVerificationCode = JuheDemo.getRequest(account_number);
                    time.start();
                }
            break;
            case R.id.password_eye:
                if(isOpen){
                    isOpen = false;
                }else {
                    isOpen = true;
                }
                changePwdOpenOrClose(isOpen);
                break;
        }
    }


    private void changePwdOpenOrClose(boolean flag) {
// 第一次过来是false，密码不可见
        if (flag) {
// 密码可见
            // bt_pwd_eye.setBackgroundResource(R.drawable.password_open);
// 设置EditText的密码可见
            loginInPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
// 密码不接见
            //   bt_pwd_eye.setBackgroundResource(R.drawable.password_close);
// 设置EditText的密码隐藏
            loginInPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }


    class TimeCount extends CountDownTimer{  //实现按了获取验证码之后 60s计时
        public TimeCount(long millisInFuture,long countDownInterval){
            super(millisInFuture,countDownInterval);
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示
            get_verification_code.setText(millisUntilFinished /1000+"s");
            get_verification_code.setClickable(false);
            get_verification_code.setBackground(getResources().getDrawable(R.drawable.yellowdark));

        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onFinish() {
            get_verification_code.setText("获取验证码");
            get_verification_code.setClickable(true);
            get_verification_code.setBackground(getResources().getDrawable(R.drawable.yellow));
        }
    }






}
