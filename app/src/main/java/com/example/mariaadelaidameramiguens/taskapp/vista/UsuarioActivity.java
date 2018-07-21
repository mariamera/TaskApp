package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.CategoriaRepositorio;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.db.dbCategoriaRepositorioImp;

import java.util.List;

public class UsuarioActivity extends AppCompatActivity {
    private Usuario usuario;
    private static final String LOG_TAG = UsuarioActivity.class.getName();
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        Bundle paraBundle = getIntent().getExtras(); // parametros del intento
        TextView txtNombre = (TextView) findViewById(R.id.txtNombre);
        ListView catListview = (ListView) findViewById(R.id.categoria_listview);

        if( paraBundle != null && paraBundle.containsKey("usuario")) {
            usuario = (Usuario) paraBundle.getSerializable("usuario");
            Log.i(LOG_TAG,usuario.toString());
            categoriaRepositorio = new dbCategoriaRepositorioImp(this);
            List<Categoria> categorias = categoriaRepositorio.buscar(null);

            txtNombre.setText("BIENVENIDO/A " + usuario.getNombre().toUpperCase());
            catListview.setAdapter(new CategoriaListAdapter(this, categorias));

            catListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    Categoria cat = (Categoria) adapterView.getItemAtPosition(i);

                    Intent regCatIntent = new Intent(UsuarioActivity.this, CategoriaActivity.class);
                    regCatIntent.putExtra("categoria", cat); // pasar parametros para un activity.
                    startActivity(regCatIntent);
                }

            });
        }
    }
}
