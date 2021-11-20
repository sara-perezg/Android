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
    }

    public void zeroBTN(View view){
        updateText("@string/zero");
    }
    public void oneBTN(View view){
        updateText("@string/one");
    }
    public void twoBTN(View view){
        updateText("@string/two");
    }
    public void threeBTN(View view){
        updateText("@string/three");
    }
    public void fourBTN(View view){
        updateText("@string/four");
    }
    public void fiveBTN(View view){
        updateText("@string/five");
    }
    public void sixBTN(View view){
        updateText("@string/six");
    }
    public void sevenBTN(View view){
        updateText("@string/seven");
    }
    public void eightBTN(View view){
        updateText("@string/eight");
    }
    public void nineBTN(View view){
        updateText("@string/nine");
    }
    public void clearBTN(View view){
        updateText("@string/clear");
    }
    public void exponentBTN(View view){
        updateText("@string/exponent");
    }
    public void parenthesesBTN(View view){
        updateText("@string/parenthese");
    }
    public void divideBTN(View view){
        updateText("@string/divide");
    }
    public void multiplyBTN(View view){
        updateText("@string/multiply");
    }
    public void addBTN(View view){
        updateText("@string/add");
    }
    public void subtractBTN(View view){
        updateText("@string/subtract");
    }
    public void plusMinusBTN(View view){
        updateText("@string/plusMinus");
    }
    public void pointBTN(View view){
        updateText("@string/point");
    }
    public void equalsBTN(View view){
        updateText("@string/equals");
    }
    public void backspaceBTN(View view){
        updateText("@string/backspace");
    }
}