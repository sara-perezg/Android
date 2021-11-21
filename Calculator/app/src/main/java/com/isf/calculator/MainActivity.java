package com.isf.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.*;

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
    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
//        Guardamos el texto del display
        bundle.getString("displayText",display.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        restauramos el texto del display
        savedInstanceState.getString("displayText");
    }

    public void exit(View view){
        finish();
        System.exit(0);
    }
    private void updateText(String strToAdd){

        String oldStrng = display.getText().toString();
        //saving cursor user position so that he/she doesnt start typing at the beginning of the string
        int cursorPos = display.getSelectionStart();
        String leftString = oldStrng.substring(0,cursorPos);
        String rightString = oldStrng.substring(cursorPos);
        // if the users enters a value from the firt time to clear the txtView
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
        }
        else{
            // si el texto es distinto al inicial
            // si el usuario añade dos ceros
            if (getString(R.string.doubleZero).equals(strToAdd)){
                // incrementamos la posicion del cursor en una posicion adicional
                cursorPos++;
            }
            // in case the user moves the cursor we can keep the position
            display.setText(String.format("%s%s%s",leftString,strToAdd,rightString));
        }
            //when tying setting the cursor one position forwards, this is to the right
            display.setSelection(cursorPos + 1);
    }


    public void clearBTN(View view){
        // cuando borramos ponemos el texto de inicio
        display.setText(getString(R.string.display));
    }
    public void equalsBTN(View view){
        // usamos expresiones para el paquete de mxparser
        String userExp = display.getText().toString();
        //sustitumos los simbolos de dividir y multiplicar para que los detecte el metodo calculate
        userExp = userExp.replaceAll(getResources().getString(R.string.divide), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiply), "*");

//        convertimos en expresion el string modificado
        Expression exp = new Expression(userExp);
        // llamamos a metodo calculate para que parse la expresion y nos calcule el resultado
        String result = String.valueOf(exp.calculate());

        // enseñamos el resultado por el txtvire
        display.setText(result);
        //colocamos el cursor al final del texto
        display.setSelection(result.length());

    }

    public void backspaceBTN(View view){
        //current cursor position
        int cursorPos = display.getSelectionStart();
        int txtLen = display.getText().length();

        if (cursorPos != 0 && txtLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            // where the uses sets the cursor we want to delet one position (cursorPos - 1)
            // actually we are replacing it with nothing ""
            selection.replace(cursorPos-1, cursorPos, "");
            // we exchange the text of the display for the modified one
            display.setText(selection);
            // we need to set the cursor position to the one we stored minus one beacuse we deleted one
            display.setSelection(cursorPos - 1);
        }
    }

    public void infoActivity(View view){
        // al pulsar en el boton de informacion queremos que se inicie la actividad de InfoActivity
        // esta cargara el layout con la informacion de la aplicacion
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    // funciones onClick de los botones para añadir el texto al textView
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
    public void doubleZeroBTN(View view){
        updateText(this.getResources().getString(R.string.doubleZero));
    }
    public void pointBTN(View view){
        updateText(this.getResources().getString(R.string.point));
    }
    public void parenthesesBTN(View view){
        updateText(this.getResources().getString(R.string.parentheses));
    }
}