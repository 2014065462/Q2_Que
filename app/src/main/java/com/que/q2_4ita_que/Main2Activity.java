package com.que.q2_4ita_que;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    TextView subjects, comments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.setTitle(getResources().getString(R.string.activity2_name));
        this.setTitle("SUMMARY");
        subjects = findViewById(R.id.subjects);
        comments = findViewById(R.id.comments);
        FileInputStream reader = null;


        try {
            reader = openFileInput("data1.txt");
            int token;
            String temp = "";
            while ((token = reader.read()) != -1){
                temp = temp + ((char)token);
            }
            reader.close();
            try {
                String[] list = temp.split("_");
                String[] list2 =list[0].split(",");
                for(int i=0; i < list2.length; i++) {
                    subjects.append(list2[i] + "\n");
                }
            } catch (Exception e) {
                Log.d("error", "Empty");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader = openFileInput("data2.txt");
            int token;
            String temp = "";
            while ((token = reader.read()) != -1){
                temp = temp + ((char)token);
            }
            reader.close();
            try {
                String[] list = temp.split("_");
                comments.setText(list[0]);
            } catch (Exception e) {
                Log.d("error", "Empty");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Send(View v) {
            comments.getText().toString();
        Toast.makeText(this, "Request Sent...", Toast.LENGTH_LONG).show();
    }
    public void Previous(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
