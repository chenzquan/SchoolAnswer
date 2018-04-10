package com.example.schoolanswer.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 权 on 2018/3/20.
 */

public class ShowToast {
    public static void makeToast(String message, Context context){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

}
