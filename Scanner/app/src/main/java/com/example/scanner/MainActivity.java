package com.example.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.client.android.Intents;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    Button btnScan;
    EditText txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btnScan);
        txtResultado = findViewById(R.id.txtResultado);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                // ISBN codes are always coded on EAN_13 format
                integrator.setDesiredBarcodeFormats(IntentIntegrator.EAN_13);
                integrator.setPrompt("Lector: OCP");
                // id = 0 camara trasera
                integrator.setCameraId(0);
                // cuando lea el codigo suena beep
                integrator.setBeepEnabled(true);
                // para que salga el lector en la imagen de la camra
                integrator.setBarcodeImageEnabled(true);
                // para que se pueda iniciar el integrator. Ya hemos abierto el esaneo
                integrator.initiateScan();
            }
        });
    }

    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if (result != null){
            //si hay resultado
            if (result.getContents() == null){
                //si cancelamos el proceso
                Toast.makeText(this,"Lectura cancelada", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,result.getContents(), Toast.LENGTH_LONG).show();
                txtResultado.setText(result.getContents());
            }

        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}