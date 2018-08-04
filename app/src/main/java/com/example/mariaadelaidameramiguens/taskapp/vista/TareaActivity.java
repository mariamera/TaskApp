package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.DataHolder;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Tarea;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.TareaRepositorio;

public class TareaActivity extends AppCompatActivity {
    private static final String LOG_TAG = "TareaActivity";
    private TareaRepositorio tareaRepositorio;
    private Tarea tar;
    final Usuario currentUser = DataHolder.getInstance().getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea);

        TextView catgoriaText = findViewById(R.id.categoriatxt);
        TextView tareaFecha= findViewById(R.id.datelbl);
        TextView usuarioAsignado = findViewById(R.id.asigntxt);
        TextView estado= findViewById(R.id.estadotxt);
        TextView descripcion = findViewById(R.id.descripciontxt);
        TextView by = findViewById(R.id.asignLbl);
        Bundle paraBundle = getIntent().getExtras(); // parametros del intento

        if( paraBundle != null && paraBundle.containsKey("tarea")) {
            tar = (Tarea) paraBundle.getSerializable("tarea");

            if (currentUser.getTipoUsuario() == Usuario.TipoUsuario.NORMAL ){
                by.setText("Asignado A:");
                usuarioAsignado.setText(tar.getUsuarioAsignado().getNombre() );
            }
            descripcion.setText(tar.getDescription());
            tareaFecha.setText(tar.getFecha().toString());
            catgoriaText.setText(Integer.toString(tar.getCategoriaID()));

            if(tar.getEstado() != null) {
                Log.i(LOG_TAG,"STATE NOT NULL");

                estado.setText(tar.getEstado().name());
            }
        }
    }

}
