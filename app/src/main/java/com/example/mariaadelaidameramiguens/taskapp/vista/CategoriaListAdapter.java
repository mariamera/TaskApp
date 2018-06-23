package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;

import java.util.List;

/**
 * Created by Maria Mera on 23/6/2018.
 */

public class CategoriaListAdapter extends BaseAdapter {

    private Context context;
    private  List<Categoria> categorias;

    public CategoriaListAdapter(Context context, List<Categoria> categorias) {
        this.context = context;
        this.categorias = categorias;
    }

    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public Object getItem(int i) {
        return categorias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return categorias.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //TODO: validar si view no es nulo
        if ( view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.categoria_listview_row, null, true);
        }

        TextView lbCategoriaid = view.findViewById(R.id.lb_categoria_id);
        TextView lbCategoriaNombre= view.findViewById(R.id.lb_categoria_nombre);

        Categoria cat = categorias.get(i);

        lbCategoriaid.setText(cat.getId().toString());
        lbCategoriaNombre.setText(cat.getNombre());
        return view;
    }
}
