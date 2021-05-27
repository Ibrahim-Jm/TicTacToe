package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Button> fields=new ArrayList<Button>();
    int counter=2;
    String playerName=null;
    boolean isDone=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fields.add(findViewById(R.id.button1));
        fields.add(findViewById(R.id.button2));
        fields.add(findViewById(R.id.button3));
        fields.add(findViewById(R.id.button4));
        fields.add(findViewById(R.id.button5));
        fields.add(findViewById(R.id.button6));
        fields.add(findViewById(R.id.button7));
        fields.add(findViewById(R.id.button8));
        fields.add(findViewById(R.id.button9));

    }
    public void connect(View v){
            Intent i=new Intent(this,BluetoothConnect.class);
            startActivity(i);
    }
    public void enterName(View V){
        TextView i=findViewById(R.id.enteredName);
        playerName=i.getText().toString();
    }
    public void goHeighestScores(View v){
        Intent i=new Intent(this,HighestScore.class);
        i.putExtra("Name", playerName);
        startActivity(i);


    }
    public void reset(View v){
        TextView T=findViewById(R.id.textView);
        isDone=false;
        for (int i=0;i<9;i++){
            T.setText("Not yet");
            fields.get(i).setBackgroundColor(0xFF3333cc);
            fields.get(i).setTextColor(0xFFffffff);
            String w=String.valueOf(i+1);
            fields.get(i).setText(w);
            fields.get(i).setEnabled(true);
        }
    }
    public void press(View v){
        if(!isDone) {
            counter++;
            Button b = (Button) v;
            v.setEnabled(false);
            if (counter % 2 == 0) {
                b.setText("X");
                b.setBackgroundColor(0xFF0d9e3d);
                b.setTextColor(-100);
            } else {
                b.setText("O");
                b.setBackgroundColor(0xFF9e0d3d);
                b.setTextColor(-100);
            }
            checkDraw();
            checkVertical();
            checkHorizontal();
            checkDiagonalfirst();
            checkDiagonalsecond();

        }
    }
    public void checkVertical(){
        for (int i =0;i<9;i++){
            int secondNum=i+3;
            int thirdNum=i+6;
            if(secondNum>8){
                secondNum-=9;
            }
            if(thirdNum>8){
                thirdNum-=9;
            }
            if ((!fields.get(i).isEnabled()&&(fields.get(i).getText()=="X"))&&(!fields.get(secondNum).isEnabled()&&(fields.get(secondNum).getText()=="X"))&&(!fields.get(thirdNum).isEnabled()&&(fields.get(thirdNum).getText()=="X"))){
                xWin();
            }
            if ((!fields.get(i).isEnabled()&&(fields.get(i).getText()=="O"))&&(!fields.get(secondNum).isEnabled()&&(fields.get(secondNum).getText()=="O"))&&(!fields.get(thirdNum).isEnabled()&&(fields.get(thirdNum).getText()=="O"))){
                oWin();
            }

        }
    }
    public void checkHorizontal(){
        for (int i =0;i<9;i++){
            if (i==0||i==3||i==6) {
                int secondNum = i + 1;
                int thirdNum = i + 2;
                if ((!fields.get(i).isEnabled()&&(fields.get(i).getText()=="X"))&&(!fields.get(secondNum).isEnabled()&&(fields.get(secondNum).getText()=="X"))&&(!fields.get(thirdNum).isEnabled()&&(fields.get(thirdNum).getText()=="X"))){
                    xWin();
                }
                if ((!fields.get(i).isEnabled()&&(fields.get(i).getText()=="O"))&&(!fields.get(secondNum).isEnabled()&&(fields.get(secondNum).getText()=="O"))&&(!fields.get(thirdNum).isEnabled()&&(fields.get(thirdNum).getText()=="O"))){
                    oWin();
                }
            }
        }
    }
    public void checkDiagonalfirst(){
        for (int i =0;i<9;i++){
            if (i==0) {
                int secondNum = i + 4;
                int thirdNum = i + 8;
                if(thirdNum>8){
                    thirdNum-=9;
                }
                if ((!fields.get(i).isEnabled()&&(fields.get(i).getText()=="X"))&&(!fields.get(secondNum).isEnabled()&&(fields.get(secondNum).getText()=="X"))&&(!fields.get(thirdNum).isEnabled()&&(fields.get(thirdNum).getText()=="X"))){
                    xWin();
                }
                if ((!fields.get(i).isEnabled()&&(fields.get(i).getText()=="O"))&&(!fields.get(secondNum).isEnabled()&&(fields.get(secondNum).getText()=="O"))&&(!fields.get(thirdNum).isEnabled()&&(fields.get(thirdNum).getText()=="O"))){
                    oWin();
                }
            }
        }
    }
    public void checkDiagonalsecond(){
        for (int i =0;i<9;i++){
            if (i==2) {
                int secondNum = i + 2;
                int thirdNum = i + 4;
                if(thirdNum>8){
                    thirdNum-=9;
                }
                if ((!fields.get(i).isEnabled()&&(fields.get(i).getText()=="X"))&&(!fields.get(secondNum).isEnabled()&&(fields.get(secondNum).getText()=="X"))&&(!fields.get(thirdNum).isEnabled()&&(fields.get(thirdNum).getText()=="X"))){
                    xWin();
                }
                if ((!fields.get(i).isEnabled()&&(fields.get(i).getText()=="O"))&&(!fields.get(secondNum).isEnabled()&&(fields.get(secondNum).getText()=="O"))&&(!fields.get(thirdNum).isEnabled()&&(fields.get(thirdNum).getText()=="O"))){
                    oWin();
                }
            }
        }
    }
    public void checkDraw(){
        int counter=0;
        for (int i =0;i<9;i++){
            if (!fields.get(i).isEnabled()){
                counter++;
        }}
        if (counter==9){
            draw();
        }
    }

    public void xWin(){
        TextView T=findViewById(R.id.textView);
        T.setText("X win");
        isDone=true;
    }
    public void oWin(){
        TextView T=findViewById(R.id.textView);
        T.setText("O win");
        isDone=true;
    }
    public void draw(){
        TextView T=findViewById(R.id.textView);
        T.setText("Draw");
        isDone=true;
    }
}