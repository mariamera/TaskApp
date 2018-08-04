package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.DataHolder;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Tarea;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.UsuarioRepositorio;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.db.Usuariorepositoriodbimpl;

import java.util.List;

/**
 * Created by MESCyT on 21/7/2018.
 */

public class TareaListAdapter extends BaseAdapter {
    private Context context;
    private List<Tarea> tareas;
    private UsuarioRepositorio usuarioRepositorio;
    final Usuario currentUser = DataHolder.getInstance().getData();
    private static final String LOG_TAG = "TareaListAdapter";

    public TareaListAdapter(Context context, List<Tarea> tareas) {
        this.context = context;
        this.tareas = tareas;
    }

    @Override
    public int getCount() {
        return tareas.size();
    }

    @Override
    public Object getItem(int i) {
         return tareas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return tareas.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //TODO: validar si view no es nulo
        if ( view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.tarea_listview_row, null, true);
        }

        TextView tareaDescipcion = view.findViewById(R.id.tarea_description);
        TextView tareaFecha= view.findViewById(R.id.tarea_fecha);
        TextView usuarioCreador= view.findViewById(R.id.tarea_usuario_creador);
        TextView categoria= view.findViewById(R.id.tarea_categoria);
        TextView proceso= view.findViewById(R.id.tarea_proceso);
        TextView by = view.findViewById(R.id.tarea_by);
        Tarea tar = tareas.get(i);

        Log.i(LOG_TAG,tar.toString());

        if (currentUser.getTipoUsuario() == Usuario.TipoUsuario.NORMAL ){
            by.setText("Asignado A:");
            usuarioCreador.setText(tar.getUsuarioAsignado().getNombre() );
        }

        if (currentUser.getTipoUsuario() == Usuario.TipoUsuario.TECNICO ){
            by.setText("By:");
            usuarioCreador.setText(tar.getUsuarioCreador().getNombre() );
        }

        tareaDescipcion.setText(tar.getDescription());
        tareaFecha.setText(tar.getFecha().toString());
        categoria.setText(Integer.toString(tar.getCategoriaID()));

        if(tar.getEstado() != null) {
            Log.i(LOG_TAG,"STATE NOT NULL");

            proceso.setText(tar.getEstado().name());
        }

        return view;
    }


}

