package com.tom.link;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AccountActivity extends AppCompatActivity {

    private String accountString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

    }

    public void but4(View view) {
        EditText etac = findViewById(R.id.edac);
        accountString = etac.getText().toString();
        if(!TextUtils.isEmpty(accountString)) {
            Intent password = new Intent(AccountActivity.this, PassWordActivity.class);
            SharedPreferences preferences = getSharedPreferences("test",MODE_PRIVATE);
            preferences.edit()
                    .putString("ACCOUNT",accountString)
                    .commit();
            startActivityForResult(password,0);
            setResult(RESULT_OK);
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
