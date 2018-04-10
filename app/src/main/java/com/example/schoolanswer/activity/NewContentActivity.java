package com.example.schoolanswer.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.schoolanswer.R;
import com.tobiasrohloff.view.NestedScrollWebView;

public class NewContentActivity extends AppCompatActivity {

    public static final String TITLE = "TITLE";
    public static final String IMAGE = "IMAGE";
    public static final String URL = "URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_content);
        Intent intent = getIntent();
        String title = intent.getStringExtra(TITLE);
        String image = intent.getStringExtra(IMAGE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView NewImage = (ImageView) findViewById(R.id.iv_detail);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);

        }

        collapsingToolbarLayout.setTitle("新闻");
        TextView tv_title = (TextView) findViewById(R.id.tv_detail_title);
        Glide.with(this).load(image).into(NewImage);
        tv_title.setText(title);


        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) findViewById(R.id.webView);
        nestedScrollWebView.getSettings().setJavaScriptEnabled(true);
        nestedScrollWebView.setWebChromeClient(new WebChromeClient());
        String url = intent.getStringExtra(URL);
        nestedScrollWebView.loadUrl(url);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {  //设置返回键

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
