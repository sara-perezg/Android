package com.example.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scanner.interfaces.OpenLibraryAPI;
import com.example.scanner.models.OpenLibrary;
import com.google.zxing.client.android.Intents;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String baseURLAPI = "http://openlibrary.org/";
    Button btnScan;
    EditText txtResultado;
    EditText txtTitle;
    String isbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btnScan);
        txtResultado = findViewById(R.id.txtResultado);


        //cuando el usuario clicke el boton scan iniciamos nuestros integrator que leera el codigo
       /* btnScan.setOnClickListener(new View.OnClickListener() {
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
        });*/
    }

    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if (result != null){
            //si hay resultado
            if (result.getContents() == null){
                //si cancelamos el proceso
                Toast.makeText(this,"Lectura cancelada", Toast.LENGTH_LONG).show();
            }else{
                // si hemos leido correctamente le codigo de barras lo mostramos
                Toast.makeText(this,result.getContents(), Toast.LENGTH_LONG).show();
                isbn = result.getContents();
                txtResultado.setText(isbn);
            }
        }else {
            // si no hay resultado
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void launchIntegrator(View view){
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

    public void find(String isbn){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURLAPI)
                .addConverterFactory(GsonConverterFactory.create()).build();

        OpenLibraryAPI openLibraryAPI = retrofit.create(OpenLibraryAPI.class);
        Call<OpenLibrary> call = openLibraryAPI.find(isbn);
        // hacemos la llamada de manera asincrona
        call.enqueue(new Callback<OpenLibrary>() {
            @Override
            public void onResponse(Call<OpenLibrary> call, Response<OpenLibrary> response) {
                // si hay respuesta por parte del servidor
                try {
                    //si el isbn es correcto
                    if(response.isSuccessful()){
                        OpenLibrary openLibrary = response.body();
                        Toast.makeText(MainActivity.this, openLibrary.docs.get(0).getTitle(), Toast.LENGTH_LONG);
                        txtTitle.setText(openLibrary.docs.get(0).getTitle());
                    }
                }catch (Exception e){
                    // si el isbn no es correcto
                    Toast.makeText(MainActivity.this, "Error el isbn no se ha encontrado", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<OpenLibrary> call, Throwable t) {
                // si hay un problema de conexion
                Toast.makeText(MainActivity.this, "Error de conexion", Toast.LENGTH_LONG);
            }
        });
    }

    public void findTitle(View view){

        Toast.makeText(MainActivity.this, "estas cliclando", Toast.LENGTH_LONG);
        find(isbn);
    }
}