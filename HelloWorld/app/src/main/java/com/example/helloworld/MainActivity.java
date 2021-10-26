package com.example.helloworld;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity{

    // Es llamado cuando la actividad es invocada por primera vez
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Ejemplo","Estoy en onCreate");
    }

    // Sucede a onCreate, la actividad se hace visible para el usuario pero todavia no se puede
    // interactuar con ella
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ejemplo", "Estoy en onStart");
    }

    // se llama cuando el usuario puede interactuar con la actividad. Precede a onPause
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ejemplo", "Estoy en onResume");
    }

    // Cuando la actividad esta en segundo plano se llama a este metodo. Sigue siendo visible para
    // el usuario
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ejemplo", "Estoy en onPause");
    }

    // deja de ser visible al usuario. Podemos utilizar onRestart para que vuelva a estar en primer
    // plano o podemos utilizar onDestroy si queremos que finalice
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ejemplo", "Estoy en onStop");
    }

    // Cuando esta en segundo plano y no es visible para el usuario y queremos que vuelva al primer plano.
    // Siempre es seguido de un onStart
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ejemplo", "Estoy en onRestart");
    }

    // Cuando queremos terminar la actividad. La actividad es destruidad y eliminada de la memoria
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ejemplo", "Estoy en onDestroy");
    }
}