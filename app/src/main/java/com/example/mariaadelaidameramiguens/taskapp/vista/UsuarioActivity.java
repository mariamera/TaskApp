package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.DataHolder;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Tarea;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.CategoriaRepositorio;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.TareaRepositorio;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.db.TareaRepositorioImp;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.db.dbCategoriaRepositorioImp;

import java.util.List;

public class UsuarioActivity extends AppCompatActivity {
    private Usuario usuario;
    private static final String LOG_TAG = UsuarioActivity.class.getName();
    private TareaRepositorio tareaRepositorio;
    final Usuario currentUser = DataHolder.getInstance().getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        tareaRepositorio = new TareaRepositorioImp(this);
        Bundle paraBundle = getIntent().getExtras(); // parametros del intento
        Button listoBtn = findViewById(R.id.tecnicoBotton);

//        listoBtn.setVisibility(View.VISIBLE);
        if( paraBundle != null && paraBundle.containsKey("usuario")) {
            usuario = (Usuario) paraBundle.getSerializable("usuario");
            DataHolder.getInstance().setData(usuario);
            List<Tarea> tareas = tareaRepositorio.buscarTareasPorTecnicos(currentUser);

            if(tareas!= null) {
                ListView catListview = (ListView) findViewById(R.id.categoria_listview);
                catListview.setAdapter(new TareaListAdapter(this, tareas));

                catListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        Tarea t = (Tarea) adapterView.getItemAtPosition(i);

                        Intent regTareaIntent = new Intent(UsuarioActivity.this, TareaActivity.class);
                        regTareaIntent.putExtra("tarea", t );
                        startActivity(regTareaIntent);
                    }

                });
            }
        }
    }
}
