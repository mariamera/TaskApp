package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.CategoriaRepositorio;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.db.dbCategoriaRepositorioImp;

import java.util.List;

public class CategoriaListaActivity extends AppCompatActivity {

    private CategoriaRepositorio categoriaRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_lista);

        categoriaRepositorio = new dbCategoriaRepositorioImp(this);
        List<Categoria> categorias = categoriaRepositorio.buscar(null);

        ListView catListview = (ListView) findViewById(R.id.categoria_listview);
        catListview.setAdapter(new CategoriaListAdapter(this, categorias));

        catListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Categoria cat = (Categoria) adapterView.getItemAtPosition(i);

                Intent regCatIntent = new Intent(CategoriaListaActivity.this, CategoriaActivity.class);
                regCatIntent.putExtra("categoria", cat); // pasar parametros para un activity.
                startActivity(regCatIntent);
            }

        });
    }
}
