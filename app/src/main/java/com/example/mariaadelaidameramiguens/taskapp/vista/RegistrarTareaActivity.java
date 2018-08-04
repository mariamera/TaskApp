package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.DataHolder;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Tarea;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.CategoriaRepositorio;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.TareaRepositorio;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.UsuarioRepositorio;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.db.TareaRepositorioImp;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.db.Usuariorepositoriodbimpl;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.db.dbCategoriaRepositorioImp;

import java.util.List;
import java.util.Date;

public class RegistrarTareaActivity extends AppCompatActivity {
    private static final String LOG_TAG = "CategoriaActivity";
    private CategoriaRepositorio categoriaRepositorio;
    private UsuarioRepositorio usuarioRepositorio;
    private TareaRepositorio tareaRepositorio;
    private Categoria categorias;
    private Tarea tarea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_tarea);
        final Usuario currentUser = DataHolder.getInstance().getData();
        Button btnRegistrar = (Button) findViewById(R.id.btn_guardar);
        final Spinner drowp_down_categorias = (Spinner)findViewById(R.id.lista_categorias);
        final Spinner drowp_down_tecnicos = (Spinner)findViewById(R.id.lista_asignado);
        tareaRepositorio = new TareaRepositorioImp(this);

        /*Ensenar las Categorias */
        categoriaRepositorio = new dbCategoriaRepositorioImp(this);
        List<Categoria> categorias = categoriaRepositorio.buscar(null);
        drowp_down_categorias.setAdapter(new CategoriaListAdapter(this, categorias));
        final EditText descripcion = (EditText) findViewById(R.id.tarea_descripcion);

        /*Ensenar los Tecnicos */
        usuarioRepositorio = new Usuariorepositoriodbimpl(this);
        List<Usuario> tecnicos = usuarioRepositorio.buscarTecnicos();
        drowp_down_tecnicos.setAdapter(new TecnicoAdapter(this, tecnicos));

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Categoria cat =(Categoria) drowp_down_categorias.getSelectedItem();
                Usuario usr = (Usuario) drowp_down_tecnicos.getSelectedItem();
                Usuario usuarioAsig = usuarioRepositorio.buscar(currentUser.getId());
                Date date = new Date();
                tarea = new Tarea();
                Log.i(LOG_TAG,descripcion.getText().toString());
                tarea.setDescription(descripcion.getText().toString());
                tarea.setFecha(date);
                tarea.setUsuarioCreador(usuarioAsig);
                tarea.setCategoriaID(cat.getId());
                tarea.setUsuarioAsignado(usr);
                tarea.setNombre(currentUser.getNombre());
                tarea.setEstado(Tarea.TareaEstado.PENDIENTE);
                Log.i(LOG_TAG,tarea.toString());
                tareaRepositorio.guardar(tarea);

            }
        });
    }

}
