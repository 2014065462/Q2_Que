package com.que.q2_4ita_que;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.setTitle(getResources().getString(R.string.activity2_name));
        this.setTitle("SUMMARY");
    }
    public void Send(View v) {
        Toast.makeText(this, "Request Sent...", Toast.LENGTH_LONG).show();
    }
    public void Previous(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
