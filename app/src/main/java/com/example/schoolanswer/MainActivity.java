package com.example.schoolanswer;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.example.schoolanswer.fragment.FragmentController;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private static final int HomePage = 0;
    private static final int MessagePage = 1;
    private static final int AskPage = 2;
    private static final int SchoolPage = 3;
    private static final int MePage = 4;


    private RadioGroup rg_tab;
    private ImageView iv_add;
    private FragmentController controller;


  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_signed);
       *//* Intent intent = new Intent(this,LoginAndSigned.class);
        startActivity(intent);*//*
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


//

        controller = FragmentController.getInstance(this, R.id.fl_content);
        controller.showFragment(HomePage);

        initView();
    }

    private void initView() {
        rg_tab = (RadioGroup) findViewById(R.id.rg_tab);
    //    iv_add = (ImageView) findViewById(R.id.iv_add);

        rg_tab.setOnCheckedChangeListener(this);
    //    iv_add.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                controller.showFragment(HomePage);
                break;
            case R.id.rb_meassage:
                controller.showFragment(MessagePage);
                break;
            case R.id.rb_school:
                controller.showFragment(SchoolPage);
                break;
            case R.id.rb_user:
                controller.showFragment(MePage);
                break;
            case R.id.rb_wen:
                controller.showFragment(AskPage);
                break;

            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {

    }





}
