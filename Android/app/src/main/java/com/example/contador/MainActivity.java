package com.example.contador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int contador = 0;
    TextView textView;

    // iniciamos la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView); //inicializamos nuestra variable textView
    }

    // metodo que aumenta en uno la varibale contadar cada vez que es llamada y actualiza el texto
    // de textView
    public void pulso(View view){
        contador++;
        textView.setText(String.valueOf(contador));
    }

    // guardamos nuestra variable contador
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contador",contador);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // recuperamos el valor de la varibale contador y se la asiganmos de nuevo
        contador = savedInstanceState.getInt("contador");
        // actualizamos el texto
        textView.setText(String.valueOf(contador));
    }
}