package com.example.schoolanswer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.schoolanswer.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Main2answers extends AppCompatActivity implements View.OnClickListener {

    public static final String UserName = "UserName";
    public static final String Question = "Question";
    public static final String ImageId = "ImageId";

    private CircleImageView circleImageView;
    private TextView tv_username;
    private TextView tv_question;

    private ImageView fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_detail_content);
        fanhui = (ImageView) findViewById(R.id.ask_fanhui);
        fanhui.setOnClickListener(this);

        Intent intent = getIntent();
        String User_name = intent.getStringExtra(UserName);
        String question = intent.getStringExtra(Question);
        int imageId = intent.getIntExtra(ImageId,0);

        circleImageView = (CircleImageView) findViewById(R.id.iv_avatar);
        tv_username = (TextView) findViewById(R.id.tv_username);
        tv_question = (TextView) findViewById(R.id.tv_item_title);

        circleImageView.setImageResource(imageId);
        tv_username.setText(User_name);
        tv_question.setText(question);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ask_fanhui:
                finish();
                break;
        }
    }
}
