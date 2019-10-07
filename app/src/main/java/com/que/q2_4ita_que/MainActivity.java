package com.que.q2_4ita_que;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText comments;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(getResources().getString(R.string.activity_name));
        this.setTitle("SUBJECT REQUEST");
        c1 = findViewById(R.id.checkBox);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        c4 = findViewById(R.id.checkBox4);
        c5 = findViewById(R.id.checkBox5);
        c6 = findViewById(R.id.checkBox6);
        c7 = findViewById(R.id.checkBox7);
        c8 = findViewById(R.id.checkBox8);
        comments = findViewById(R.id.comments);
    }
    public void Next(View v) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    public void Save(View v){
        //CheckBox[] checkbox = {c1,c2,c3,c4,c5,c6,c7,c8};
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            if (c1.isChecked()){
                writer.write((c1.getText().toString() + "," ).getBytes());
            }
            if (c2.isChecked()){
                writer.write((c2.getText().toString() + "," ).getBytes());
            }
            if (c3.isChecked()){
                writer.write((c3.getText().toString() + "," ).getBytes());
            }
            if (c4.isChecked()){
                writer.write((c4.getText().toString() + "," ).getBytes());
            }
            if (c5.isChecked()){
                writer.write((c5.getText().toString() + "," ).getBytes());
            }
            if (c6.isChecked()){
                writer.write((c6.getText().toString() + "," ).getBytes());
            }
            if (c7.isChecked()){
                writer.write((c7.getText().toString() + "," ).getBytes());
            }
            if (c8.isChecked()){
                writer.write((c8.getText().toString() + "," ).getBytes());
            }
        } catch (FileNotFoundException e) {
            Log.d("lol", "File not found.");
            Toast.makeText(this, "File not found.", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.d("lol", "IO error");
            Toast.makeText(this, "IO Exception", Toast.LENGTH_LONG).show();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "IO error");
                Toast.makeText(this, "IO Exception", Toast.LENGTH_LONG).show();
            } catch (NullPointerException e) {
                Log.d("error", "Null Pointer Exception");
                Toast.makeText(this, "Null Pointer Exception", Toast.LENGTH_LONG).show();
            }
        }

        String comment = comments.getText().toString()+" ";
        FileOutputStream writer2 = null;
        try {
            writer2 = openFileOutput("data2.txt", MODE_PRIVATE);
            writer2.write(comment.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("lol", "File not found.");
            Toast.makeText(this, "File not found.", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.d("lol", "IO error");
            Toast.makeText(this, "IO Exception", Toast.LENGTH_LONG).show();
        } finally {
            try {
                writer2.close();
            } catch (IOException e) {
                Log.d("lol", "IO error");
                Toast.makeText(this, "IO Exception", Toast.LENGTH_LONG).show();
            }
        }
        Toast.makeText(this, "Data saved.", Toast.LENGTH_LONG).show();
    }
}
