package com.isf.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);
        display.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
    }


    public void zeroBTN(View view){}
    public void oneBTN(View view){}
    public void twoBTN(View view){}
    public void threeBTN(View view){}
    public void fourBTN(View view){}
    public void fiveBTN(View view){}
    public void sixBTN(View view){}
    public void sevenBTN(View view){}
    public void eightBTN(View view){}
    public void nineBTN(View view){}
    public void clearBTN(View view){}
    public void exponentBTN(View view){}
    public void parenthesesBTN(View view){}
    public void divideBTN(View view){}
    public void multiplyBTN(View view){}
    public void minusBTN(View view){}
    public void addBTN(View view){}
    public void subtractBTN(View view){}
    public void plusMinusBTN(View view){}
    public void pointBTN(View view){}
    public void equalsBTN(View view){}
    public void backspaceBTN(View view){}
}