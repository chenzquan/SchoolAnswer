package com.example.schoolanswer.utils;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * Created by 权 on 2018/3/20.
 */

public class Tool {
    public static boolean isNumberic(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }


    public static boolean judgeAccount(String str, Context context){

        boolean ok = true;

        if(TextUtils.isEmpty(str)){
            ShowToast.makeToast("请输入手机号码",context);
            ok = false;
        }else if (str.length()!=11){
            ShowToast.makeToast("请输入正确的手机号码",context);
            ok = false;
        }else if(!Tool.isNumberic(str)) {
            ShowToast.makeToast("请输入正确的手机号码", context);
            ok = false;
        }
        return ok;
    }


    public static boolean juegePassword(String str,Context context)
    {
        boolean ok = true;
        if(TextUtils.isEmpty(str)){
            ShowToast.makeToast("请输入密码",context);
            ok = false;
        }else if(str.indexOf(" ")!=-1){
            ShowToast.makeToast("存在非法字符",context);
            ok = false;
        }
        return ok;
    }






}
