package com.example.schoolanswer.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.schoolanswer.R;

public class Activity_answers extends AppCompatActivity implements View.OnClickListener {

    private ImageView fanhui_answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_answers);

        fanhui_answers = (ImageView) findViewById(R.id.fanhui_answers);
        fanhui_answers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fanhui_answers:
                finish();
                break;
        }
    }
}
