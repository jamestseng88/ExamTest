package com.tom.link;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class PassWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word);
    }

    public void but5(View view) {
        EditText etpa = findViewById(R.id.edpa);
        String passwordString = etpa.getText().toString();
        if(!TextUtils.isEmpty(passwordString)){
            Intent intent = new Intent(PassWordActivity.this, MainActivity.class);
            startActivity(intent);
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("錯誤訊息")
                    .setMessage("請輸入密碼")
                    .setPositiveButton("再輸入一次",null)
                    .show();
        }

    }
}