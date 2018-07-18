package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;

public class UsuarioActivity extends AppCompatActivity {
    private Usuario usuario;
    private static final String LOG_TAG = UsuarioActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        Bundle paraBundle = getIntent().getExtras(); // parametros del intento
        TextView txtNombre = (TextView) findViewById(R.id.txtNombre);

        if( paraBundle != null && paraBundle.containsKey("usuario")) {
            //            categoria = (Categoria) paraBundle.getSerializable("categoria");mar
            usuario = (Usuario) paraBundle.getSerializable("usuario");
            Log.i(LOG_TAG,usuario.toString());

            txtNombre.setText("BIENVENIDO/A " + usuario.getNombre().toUpperCase());
           // btnGuardar.setText("Actualizar");
        }
    }
}
