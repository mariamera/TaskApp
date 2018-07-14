package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.mariaadelaidameramiguens.taskapp.MainActivity;
import com.example.mariaadelaidameramiguens.taskapp.R;

public class LogInActivity extends AppCompatActivity {
    private static final String LOG_TAG = LogInActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Button btnRegistrar = findViewById(R.id.regisBtn);
        Button btnLogIn = findViewById(R.id.iniciarBtn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LogInActivity.this, CategoriaListaActivity.class);
                startActivity(intent1);
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LogInActivity.this, RegistrarActivity.class);
                startActivity(intent);
            }
        });


    }
}
