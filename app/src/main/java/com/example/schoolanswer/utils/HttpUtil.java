package com.example.schoolanswer.utils;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.R.attr.type;
import static android.R.string.ok;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by 权 on 2018/3/19.
 */

public class HttpUtil {


    public static final int SignIn = 0;
    public static  final int Login = 1;

    public static void RequestRegisteredOrLogin(final String adress,final String moNum, final String password,okhttp3.Callback callback){

        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("moNum",moNum)
                .add("password",password)
                .build();

        Request request = new Request.Builder()
                .url(adress)
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(callback);

    }

    public static void RequestNew(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();

        client.newCall(request).enqueue(callback);
    }









}
