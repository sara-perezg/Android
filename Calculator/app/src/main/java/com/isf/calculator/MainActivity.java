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
        //escondemos el teclado
        display.setShowSoftInputOnFocus(false);
        //borramos el texto que esta por default cuadno el usaurio clicka en el disply
        display.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText(" ");
                }
            }
        });
    }

    private void updateText(String strToAdd){

        String oldStrng = display.getText().toString();
        //saving cursor user position so that he/she doesnt start typing at the beginning of the string
        int cursorPos = display.getSelectionStart();
        String leftString = oldStrng.substring(0,cursorPos);
        String rightString = oldStrng.substring(cursorPos);
        display.setText(String.format("%s%s%s",leftString,strToAdd,rightString));
//        display
    }

    public void zeroBTN(View view){
        updateText(this.getResources().getString(R.string.zero));
    }
    public void oneBTN(View view){
        updateText(this.getResources().getString(R.string.one));
    }
    public void twoBTN(View view){
        updateText(this.getResources().getString(R.string.two));
    }
    public void threeBTN(View view){
        updateText(this.getResources().getString(R.string.three));
    }
    public void fourBTN(View view){
        updateText(this.getResources().getString(R.string.four));
    }
    public void fiveBTN(View view){
        updateText(this.getResources().getString(R.string.five));
    }
    public void sixBTN(View view){
        updateText(this.getResources().getString(R.string.six));
    }
    public void sevenBTN(View view){
        updateText(this.getResources().getString(R.string.seven));
    }
    public void eightBTN(View view){
        updateText(this.getResources().getString(R.string.eight));
    }
    public void nineBTN(View view){
        updateText(this.getResources().getString(R.string.nine));
    }
    public void exponentBTN(View view){
        updateText(this.getResources().getString(R.string.exponent));
    }
    public void parenthesesBTN(View view){
        updateText(this.getResources().getString(R.string.parentheses));
    }
    public void divideBTN(View view){
        updateText(this.getResources().getString(R.string.divide));
    }
    public void multiplyBTN(View view){
        updateText(this.getResources().getString(R.string.multiply));
    }
    public void addBTN(View view){
        updateText(this.getResources().getString(R.string.add));
    }
    public void subtractBTN(View view){
        updateText(this.getResources().getString(R.string.subtract));
    }
    public void plusMinusBTN(View view){
        updateText(this.getResources().getString(R.string.plusMinus));
    }
    public void pointBTN(View view){
        updateText(this.getResources().getString(R.string.point));
    }
    public void clearBTN(View view){
        display.setText("");
    }
    public void equalsBTN(View view){
    }
    public void backspaceBTN(View view){
    }
}