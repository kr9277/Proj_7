package com.example.proj_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Credits_Activity extends AppCompatActivity {
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
    }
}