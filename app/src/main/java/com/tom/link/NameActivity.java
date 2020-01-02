package com.tom.link;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
    }

    public void but3(View view) {
        EditText etna = findViewById(R.id.edna);
        String nameString = etna.getText().toString();
if(!TextUtils.isEmpty(nameString)){
    Intent intent = new Intent(NameActivity.this, AccountActivity.class);
    startActivity(intent);
}else {
    new AlertDialog.Builder(this)
            .setTitle("錯誤訊息")
            .setMessage("請輸入姓名")
            .setPositiveButton("再輸入一次",null)
            .show();

}

    }
}
