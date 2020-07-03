package com.icandothisallday2020.ex54materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    TextInputLayout inputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.iv);
        //간편하게 Network 에서 이미지 불러와 세팅
        //Glide Library
        Glide.with(this).load(R.drawable.dog).into(iv);
        //해상도가 너무 높은 이미지를 가져와도 ERROR 나지 않고
        //자동으로 줄여줌-앱이 다운되지않아 GOOD
        //.gif 도 가능
        inputLayout=findViewById(R.id.layout_et);
        inputLayout.setCounterEnabled(true);
        inputLayout.setCounterMaxLength(10);
        //EditText 의 InputType 이 password 일 때
        inputLayout.setPasswordVisibilityToggleEnabled(true);
        TextInputEditText et=findViewById(R.id.et);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().contains("#")){//앱의 입력문자 유효성 검사
                    inputLayout.setError("특수문자 사용금지");
                }else inputLayout.setError(null);
                if(s.length()==0) inputLayout.clearFocus();//<=> requestFocus()
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

}
