package com.que.q2_4ita_que;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText comment;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comment = findViewById(R.id.editText2);
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

    }
    public void Next(View v) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    public void Save(View v){
        CheckBox[] checkbox = {c1,c2,c3,c4,c5,c6,c7,c8};

        StringBuffer data = new StringBuffer();
        for (CheckBox chkbx: checkbox){
            if (chkbx.isChecked()){
                data.append(chkbx.getText().toString() + ",");
            }
        } data.append("COMMENT:" + comment.getText().toString());

        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(data.toString().getBytes());
            Log.d("lol",data.toString());
            Toast.makeText(this, "Data saved.", Toast.LENGTH_LONG).show();
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
    }
}
