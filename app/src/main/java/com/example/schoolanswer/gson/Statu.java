package com.example.schoolanswer.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 权 on 2018/3/19.
 */

public class Statu {

    @SerializedName("error_code")
    public int error_code;

    public Statu(){
        this.error_code = 1;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
