package com.example.mariaadelaidameramiguens.taskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Categoria cat = new Categoria();
        cat.setDescripcion("Categoria 1");
        cat.setId(2);

        Log.i(LOG_TAG,cat.toString());
    }
}
