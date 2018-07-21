package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Tarea;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.TareaRepositorio;

import java.util.List;

public class UsuarioNormalActivity extends AppCompatActivity {

    private TareaRepositorio tareaRepositorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_normal);
        Button registarTarea = findViewById(R.id.btn_crear_tarea);

        List<Tarea> tareas = tareaRepositorio.buscarTareas();
        ListView catListview = (ListView) findViewById(R.id.categoria_listview);
        catListview.setAdapter(new TareaListAdapter(this, tareas));

        registarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UsuarioNormalActivity.this, RegistrarTareaActivity.class);
                startActivity(intent);
            }
        });
    }
}
