package com.tom.link;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class PassWordActivity extends AppCompatActivity {

    private String passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word);
    }

    public void but5(View view) {
        EditText etpa = findViewById(R.id.edpa);
        passwordString = etpa.getText().toString();
        if(!TextUtils.isEmpty(passwordString)){
//            Intent result = new Intent(PassWordActivity.this, MainActivity.class);
            SharedPreferences preferences = getSharedPreferences("test",MODE_PRIVATE);
            preferences.edit()
                    .putString("PASSWORD",passwordString)
                    .commit();
//            startActivity(intent);
            finish();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("錯誤訊息")
                    .setMessage("請輸入密碼")
                    .setPositiveButton("再輸入一次",null)
                    .show();
        }

    }
}
