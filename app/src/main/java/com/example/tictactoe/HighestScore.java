package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighestScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);
        Intent i=getIntent();
        String name=i.getStringExtra("Name");
        TextView NameDisplay=findViewById(R.id.name);
        NameDisplay.setText(name);
    }
    public void goHome(View v){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}