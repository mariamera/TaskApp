package com.example.mariaadelaidameramiguens.taskapp.vista;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;

import java.util.List;

/**
 * Created by MESCyT on 23/6/2018.
 */

public class CategoriaListAdapter extends BaseAdapter {

    private Activity activity;
    private  List<Categoria> categorias;

    public CategoriaListAdapter(Activity activity, List<Categoria> categorias) {
        this.activity = activity;
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
        //TODO
        return null;
    }
}
