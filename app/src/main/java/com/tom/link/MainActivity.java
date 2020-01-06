package com.tom.link;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
boolean isNext = false;
    private String accountString;
    private String nameString;
    private EditText edpassword;
    private EditText edaccount;
    private EditText edname;
    private String passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edname = findViewById(R.id.name);
        edaccount = findViewById(R.id.account);
        edpassword = findViewById(R.id.password);
        nameString = edname.getText().toString();
        accountString = edaccount.getText().toString();
        passwordString = edpassword.getText().toString();

        Switch sw = findViewById(R.id.switch23);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.ggtext);
                text.setText(isNext?"GG":"大GG");
                String edname = getSharedPreferences("test",MODE_PRIVATE)
                        .getString("NAME","");
                String edaccount = getSharedPreferences("test",MODE_PRIVATE)
                        .getString("ACCOUNT","");
                String edpassword = getSharedPreferences("test",MODE_PRIVATE)
                        .getString("PASSWORD","");


            }
        });
    }

public void  but1(View view){
    if(!TextUtils.isEmpty(nameString) && !TextUtils.isEmpty(accountString) && !TextUtils.isEmpty(passwordString)) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("成功訊息")
                .setMessage("成功申請帳號")
                .setPositiveButton("OK",null)
                .show();
    }else{
        Intent intent = new Intent(MainActivity.this, NameActivity.class);
        startActivity(intent);
    }
}
public void  butc(View view){

if(TextUtils.isEmpty(nameString) && TextUtils.isEmpty(accountString) && TextUtils.isEmpty(passwordString))
    new AlertDialog.Builder(MainActivity.this)
            .setTitle("錯誤訊息")
            .setMessage("請申請帳號")
            .setPositiveButton("OK",null)
            .show();
    }
}
