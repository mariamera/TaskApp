package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;

public class CategoriaActivity extends AppCompatActivity {
    private static final String LOG_TAG = "CategoriaActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        final EditText txtNombre = (EditText) findViewById(R.id.txtNombreCategoria);
        Button btnGuardar = (Button) findViewById(R.id.btnGuardarCategoria);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Categoria categoria = new Categoria();
                categoria.setDescripcion(txtNombre.getText().toString());
                Log.i(LOG_TAG, categoria.toString());
                //Todo: guardar categoria en la base de datos
                //Todo: 1 = si Existe Actualizarla, 2- si no agregarla
            }
        });
    }
}
