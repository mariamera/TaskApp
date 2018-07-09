package com.example.mariaadelaidameramiguens.taskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.mariaadelaidameramiguens.taskapp.vista.CategoriaActivity;
import com.example.mariaadelaidameramiguens.taskapp.vista.CategoriaListaActivity;
import com.example.mariaadelaidameramiguens.taskapp.vista.LogInActivity;
import com.example.mariaadelaidameramiguens.taskapp.vista.RegistrarActivity;

import static com.example.mariaadelaidameramiguens.taskapp.R.layout.activity_log_in;
import static com.example.mariaadelaidameramiguens.taskapp.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_log_in);

        Button btnRegistrar = findViewById(R.id.regisBtn);

//        Button btnCategoria = findViewById(R.id.btnCategoria);
//
//        btnCategoria.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, RegistrarActivity.class);
//                startActivity(intent);
//            }
//        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, RegistrarActivity.class);
                startActivity(intent);
            }
        });
    }
}
