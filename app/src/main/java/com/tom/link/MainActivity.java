package com.tom.link;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private static final int RCL = 10;
    boolean isNext = false;
    private String accountString;
    private String nameString;
    private EditText edpassword;
    private EditText edaccount;
    private EditText edname;
    private String passwordString;
    private Button signup;
    private Button signin;


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
        signup = findViewById(R.id.on);
        signin = findViewById(R.id.in);
        Switch sw = findViewById(R.id.switch23);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    signup.setVisibility(View.VISIBLE);
                    signin.setVisibility(View.GONE);
                }else {
                    signin.setVisibility(View.VISIBLE);
                    signup.setVisibility(View.GONE);
                }
            }
        });

//                isNext = isChecked;
//                TextView text = findViewById(R.id.ggtext);
//                text.setText(isNext?"GG":"大GG");

    }


    public void  but_on(View view){
        if(!TextUtils.isEmpty(nameString) && !TextUtils.isEmpty(accountString) && !TextUtils.isEmpty(passwordString)) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("成功訊息")
                    .setMessage("成功申請帳號")
                    .setPositiveButton("OK",null)
                    .show();
        }else{
            Intent intent = new Intent(MainActivity.this, NameActivity.class);
            startActivityForResult(intent,RCL);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode==RCL){
            if(resultCode==RESULT_OK){
                edname.setText(getSharedPreferences("test",MODE_PRIVATE)
                        .getString("NAME",""));
                edaccount.setText(getSharedPreferences("test",MODE_PRIVATE)
                        .getString("ACCOUNT",""));
                edpassword.setText(getSharedPreferences("test",MODE_PRIVATE)
                        .getString("PASSWORD",""));
            }else {
                finish();
            }
        }

    }
    public void  but_in(View view){

    }


public void  butcc(View view){

if(TextUtils.isEmpty(nameString) && TextUtils.isEmpty(accountString) && TextUtils.isEmpty(passwordString))
    new AlertDialog.Builder(MainActivity.this)
            .setTitle("錯誤訊息")
            .setMessage("請申請帳號")
            .setPositiveButton("OK",null)
            .show();
    }
}


