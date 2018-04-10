package com.example.schoolanswer.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.bumptech.glide.Glide;
import com.example.schoolanswer.MyApplication;
import com.example.schoolanswer.Personal.person;
import com.example.schoolanswer.R;
import com.example.schoolanswer.utils.ShowToast;
import com.example.schoolanswer.utils.Tool;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.schoolanswer.R.id.fanhui;
import static com.example.schoolanswer.R.id.female;
import static com.example.schoolanswer.R.id.male;
import static com.example.schoolanswer.R.id.swipe_refresh;
import static com.example.schoolanswer.R.id.user_content;
import static com.example.schoolanswer.R.id.user_name;

public class Activity_userinfo extends AppCompatActivity implements View.OnClickListener {

    private ImageView fanhui;
    private CircleImageView headImage;

    public static final int CHOOSE_PHOTO = 1;
    public static final int RETURN_USERNAME = 2;


    private EditText user_name;
    private EditText user_account;
    private EditText user_content;
    private EditText interest;
    private Button baochun;
    private RadioGroup rg;

    private static int sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_information);
        fanhui = (ImageView) findViewById(R.id.fanhui);
        fanhui.setOnClickListener(this);

        headImage = (CircleImageView) findViewById(R.id.information_pic);
        headImage.setOnClickListener(this);

        user_name = (EditText) findViewById(R.id.user_name);
        user_account = (EditText) findViewById(R.id.user_account);
        user_content = (EditText) findViewById(R.id.user_content);
        interest = (EditText) findViewById(R.id.user_area);
        baochun = (Button) findViewById(R.id.baocun);
        baochun.setOnClickListener(this);
        rg = (RadioGroup) findViewById(R.id.user_sex);
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.male:
                        sex = 0;
                        break;
                    case female:
                        sex = 1;
                        break;
                }
            }
        });

        RadioButton male = (RadioButton) findViewById(R.id.male);
        RadioButton female = (RadioButton) findViewById(R.id.female);


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);//从SharedPreferences中读取数据
        String username = prefs.getString("user_name",null);
        String useraccount = prefs.getString("user_account",null);
        String usercontent = prefs.getString("user_content",null);
        String userinterest = prefs.getString("interest",null);
        int user_sex = prefs.getInt("sex",0);

        if(username!=null){
            user_name.setText(username);
        }

        if(useraccount!=null){
            user_account.setText(useraccount);
        }

        if(usercontent!=null){
            user_content.setText(usercontent);
        }

        if(userinterest!=null){
            interest.setText(userinterest);
        }

        if (user_sex==0){
            male.setChecked(true);
            female.setChecked(false);
        }else{

            male.setChecked(false);
            female.setChecked(true);
        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fanhui:
                finish();
                break;
            case R.id.information_pic:
                if(ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }else{
                    openAlbum();
                }

                break;
            case R.id.baocun:
                user_name.setText(user_name.getText().toString());
                user_account.setText(user_account.getText().toString());
                user_content.setText(user_content.getText().toString());
                interest.setText(interest.getText().toString());


                SharedPreferences.Editor editor = PreferenceManager
                        .getDefaultSharedPreferences(this).edit();
                editor.putString("user_name",user_name.getText().toString());
                editor.putString("user_account",user_account.getText().toString());
                editor.putString("user_content",user_content.getText().toString());
                editor.putString("interest",interest.getText().toString());
                editor.putInt("sex",sex);
                editor.apply();
                Intent data = new Intent();
                data.putExtra(String.valueOf(RETURN_USERNAME),user_name.getText().toString());
                setResult(RESULT_OK,data);
                finish();
                break;
//            case R.id.male:
//                sex = 0;
//                break;
//            case R.id.female:
//                sex = 1;
//                break;
        }
    }






    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    openAlbum();
                }else{
                    ShowToast.makeToast("You denied the permission",this);
                }
                break;
            default:
        }
    }


    private void openAlbum(){
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode){
            case CHOOSE_PHOTO:
                if(resultCode==RESULT_OK){
                    if(Build.VERSION.SDK_INT>=19){
                        handleImageOnkitKat(data);
                    }
                    else{
                        handleImageBeforeKitKat(data);
                    }
                }

                break;
        }
    }

    @TargetApi(19)
    private void handleImageOnkitKat(Intent data){
        String imagePath = null;

        Uri uri = data.getData();
        if(DocumentsContract.isDocumentUri(this,uri)){
            String docId = DocumentsContract.getDocumentId(uri);

            if("com.android.providers.media.documents".equals(uri.getAuthority())){
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            }else if("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),
                        Long.valueOf(docId));
                imagePath = getImagePath(contentUri,null);
            }
        }else if("content".equalsIgnoreCase(uri.getScheme())){
            imagePath = getImagePath(uri,null);
        }else if("file".equalsIgnoreCase(uri.getScheme())){
            imagePath = uri.getPath();
        }

        displayImage(imagePath);

    }


    private void handleImageBeforeKitKat(Intent data){
        Uri uri = data.getData();
        String imagePath = getImagePath(uri,null);
        displayImage(imagePath);

    }





    public String getImagePath(Uri uri,String selection){
        String path = null;

        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);

        if(cursor!=null){
            if(cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }

        return path;
    }


    private void displayImage(String imagePath){
        if(imagePath != null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
//            headImage.setImageBitmap(bitmap);
            Glide.with(this).load(bitmap).into(headImage);
        }else{
            ShowToast.makeToast("failed to get image",this);

        }
    }

}
