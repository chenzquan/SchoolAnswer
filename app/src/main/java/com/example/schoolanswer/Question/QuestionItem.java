package com.example.schoolanswer.Question;



/**
 * Created by 权 on 2018/3/26.
 */

public class QuestionItem {
    private int imageId;
    private String UserName;

    private String Question;
    private String pinglun;

    public QuestionItem(int imageId,String UserName,String Question,String pinglun){
        this.imageId = imageId;
        this.UserName = UserName;
        this.Question = Question;
        this.pinglun = pinglun;
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }



    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getPinglun() {
        return pinglun;
    }

    public void setPinglun(String pinglun) {
        this.pinglun = pinglun;
    }
}
