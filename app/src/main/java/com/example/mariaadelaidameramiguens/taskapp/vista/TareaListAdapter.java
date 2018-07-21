package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Tarea;

import java.util.List;

/**
 * Created by MESCyT on 21/7/2018.
 */

public class TareaListAdapter extends BaseAdapter {
    private Context context;
    private List<Tarea> tareas;

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

        Tarea tar = tareas.get(i);

        tareaDescipcion.setText(tar.getDescription());
        tareaFecha.setText((CharSequence) tar.getFecha());
        usuarioCreador.setText(tar.getUsuarioCreador());
        categoria.setText(tar.getCategoriaID());
        proceso.setText(tar.getEstado().name());
        return view;
    }
    }

