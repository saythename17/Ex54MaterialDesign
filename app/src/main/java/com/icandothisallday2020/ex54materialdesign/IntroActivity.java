package com.icandothisallday2020.ex54materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        //Intro 화면을 4초만 띄우고 4초후 MainActivity 자동 실행
        handler.sendEmptyMessageDelayed(0,4000);
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            //4초후 실행됨
            Intent intent=new Intent(IntroActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
