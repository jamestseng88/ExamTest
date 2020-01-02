package com.tom.link;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
    }

    public void but3(View view) {
        Intent intent = new Intent(NameActivity.this, AccountActivity.class);
        startActivity(intent);
    }
}
