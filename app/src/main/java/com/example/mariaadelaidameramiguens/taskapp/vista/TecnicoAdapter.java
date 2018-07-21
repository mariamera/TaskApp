package com.example.mariaadelaidameramiguens.taskapp.vista;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mariaadelaidameramiguens.taskapp.R;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;

import java.util.List;

/**
 * Created by MESCyT on 21/7/2018.
 */

public class TecnicoAdapter extends BaseAdapter{
    private Context context;
    private List<Usuario> usuarios;

    public TecnicoAdapter(Context context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }
    @Override
    public int getCount() {
       return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) { return usuarios.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //TODO: validar si view no es nulo
        if ( view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.tecnico_listview_row, null, true);
        }

        TextView lbltenicoNombre = view.findViewById(R.id.username_lbl);

        Usuario usuario = usuarios.get(i);

        lbltenicoNombre.setText(usuario.getNombre());
        return view;
    }
}
