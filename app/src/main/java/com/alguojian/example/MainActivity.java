package com.alguojian.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alguojian.titlebar.TitleBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.alguojian.example.R.layout.activity_main);

        TitleBar viewById = findViewById(com.alguojian.example.R.id.titleBaraaa);

        viewById.setRightClickListener(() -> {

            Toast.makeText(this, "asd", Toast.LENGTH_SHORT).show();

        });

    }
}
