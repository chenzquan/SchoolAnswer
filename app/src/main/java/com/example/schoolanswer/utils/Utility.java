package com.example.schoolanswer.utils;

import android.text.TextUtils;

import com.example.schoolanswer.User.UserAccount;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 权 on 2018/3/23.
 */

public class Utility {

    public static final int Success_signin = 0;  //注册成功

    public static final int SEARCH = 100; //查找失败
    public static final int EMAILDUPLICATE = 101; //号码重复

    public static final int NOTFOUND = 102; //用户不存在


    public static boolean handUserMessage(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONObject jsonObject  = new JSONObject(response);
                int Code = jsonObject.getInt("code");
                if(Code != 0) {
                    return false;
                }else if(Code == Success_signin){

                }
                else{
                    UserAccount User = new UserAccount();
                    JSONObject obj = jsonObject.getJSONObject("data");
                    User.setUid(obj.getInt("Uid"));
                    User.setAccount_number(obj.getString("moNum"));
                    User.setUserName(obj.getString("userName"));
                    User.setPassword(obj.getString("password"));
                    User.setProfilePhoto(obj.getString("profilePhoto"));
                    User.setSex(obj.getBoolean("sex"));
                    User.setIntegration(obj.getInt("integration"));
                    User.setDescription(obj.getString("description"));
                    User.save();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }else{
            return false;
        }
    }
}
