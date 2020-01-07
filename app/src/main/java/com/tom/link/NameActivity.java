package com.tom.link;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    private String nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
    }

    public void but3(View view) {
        EditText etna = findViewById(R.id.edna);
        nameString = etna.getText().toString();
if(!TextUtils.isEmpty(nameString)){
    Intent account = new Intent(NameActivity.this, AccountActivity.class);
    SharedPreferences preferences = getSharedPreferences("test",MODE_PRIVATE);
    preferences.edit()
            .putString("NAME",nameString)
            .commit();
    startActivityForResult(account,0);
    setResult(RESULT_OK);
    finish();

}else {
    new AlertDialog.Builder(this)
            .setTitle("錯誤訊息")
            .setMessage("請輸入姓名")
            .setPositiveButton("再輸入一次",null)
            .show();

}

    }
}
