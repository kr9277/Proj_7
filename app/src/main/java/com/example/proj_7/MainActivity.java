package com.example.proj_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
/** @author Created by karin on 2/11/2023.
 * @version 1.0
 * @since 5/11/2023
 *On this Activity, there are two buttons, an edit text and a Text view, and a context menu which contains 2 options, stay on this screen or move to the credits screen.
 */

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    Button btn1, btn2;
    private final String FILENAME = "rawtest.txt"; //The full file name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        et = findViewById(R.id.et);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }
    /**
     * onCreateOptionsMenu method
     * <p> Creating the options menu
     * </p>
     *
     * @param menu the Menu object to pass to the inflater
     * @return true
     */
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.tafrit, menu);
        return true;
    }
    /**
     * onOptionsItemSelected method
     * <p> Reacting the options menu
     * </p>
     *
     * @param item the MenuItem object that triggered by the listener
     * @return super.onOptionsItemSelected(item)
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        String str = item.getTitle().toString();
        if(str.equals("Credits Activity")){
            Intent intent = new Intent(this, Credits_Activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * move_up method
     * <p> Reacting the first button
     * </p>
     *
     * @param view the view that triggered the method
     * The method is showing the input from the edit text in the text view
     */
    public void move_up(View view){
        if(et.getText()!=null){
            tv.setText(et.getText().toString());
        }
    }
    /**
     * show_read method
     * <p> Reacting the second button
     * </p>
     *
     * @param view the view that triggered the method
     * The method is reading the text from the text file & display
     */
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
}