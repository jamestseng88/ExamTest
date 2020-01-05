package com.tom.link;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void but4(View view) {
        EditText etac = findViewById(R.id.edac);
        String accountString = etac.getText().toString();
        if(!TextUtils.isEmpty(accountString)) {
            String accountString1 = etac.getText().toString();
            SharedPreferences preferences = getSharedPreferences("test",MODE_PRIVATE);
            preferences.edit()
                    .putString("account",accountString1)
                    .commit();
            Intent intent = new Intent(AccountActivity.this, PassWordActivity.class);
            startActivity(intent);
            finish();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("錯誤訊息")
                    .setMessage("請輸入帳號")
                    .setPositiveButton("再輸入一次",null)
                    .show();
        }
    }
}
