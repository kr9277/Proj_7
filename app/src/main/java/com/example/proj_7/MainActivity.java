package com.example.proj_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    Button btn1, btn2;
    private final String FILENAME = "rawtest.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        et = findViewById(R.id.et);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }
    public void show_read(View view){
        String fileName = FILENAME.substring(0, FILENAME.length()-4);
        int resourceId = this.getResources().getIdentifier(fileName, "raw", this.getPackageName());
        InputStream is = this.getResources().openRawResource(resourceId);
        InputStreamReader isR = new InputStreamReader(is);
        BufferedReader bR = new BufferedReader(isR);
        StringBuilder sB = new StringBuilder();
        try{
            String line = bR.readLine();
            while(line!=null){
                sB.append(line+'\n');
                line = bR.readLine();
            }
            bR.close();
            isR.close();
            is.close();
            tv.setText(sB.toString());
        }
        catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this, "Failed to save text file", Toast.LENGTH_SHORT).show();
        }
    }
    public void move_up(View view){
        if(et.getText()!=null){
            tv.setText(et.getText().toString());
        }
    }
}