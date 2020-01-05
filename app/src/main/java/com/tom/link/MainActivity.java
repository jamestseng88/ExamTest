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
EditText edname = findViewById(R.id.name);
EditText edaccount = findViewById(R.id.account);
EditText edpassword =findViewById(R.id.password);
String nameString = edname.getText().toString();
String accountString = edaccount.getText().toString();
String passwordString = edpassword.getText().toString();
    private static final int REQUEST_CODE_REGISTER = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch sw = findViewById(R.id.switch23);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.ggtext);
                text.setText(isNext?"GG":"大GG");
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQUEST_CODE_REGISTER){
            if (resultCode==RESULT_OK){
                edname.setText(getSharedPreferences("test", MODE_PRIVATE)
                        .getString("name", ""));
                edaccount.setText(getSharedPreferences("test", MODE_PRIVATE)
                        .getString("account", ""));
                edpassword.setText( getSharedPreferences("test", MODE_PRIVATE)
                        .getString("password", ""));
            }
        }
    }
public void  but1(View view){
    if(!TextUtils.isEmpty(nameString) && !TextUtils.isEmpty(accountString) && !TextUtils.isEmpty(passwordString)) {

    }else{
        Intent intent = new Intent(MainActivity.this, NameActivity.class);
        startActivityForResult(intent,REQUEST_CODE_REGISTER);
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
