package com.tom.link;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
boolean isNext = false;

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
public void  but1(View view){
    Intent intent = new Intent(MainActivity.this, NameActivity.class);
    startActivity(intent);
}
}
