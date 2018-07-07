package com.example.mariaadelaidameramiguens.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.CategoriaRepositorio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria Mera on 16/6/2018.
 */

public class dbCategoriaRepositorioImp implements CategoriaRepositorio {

    private ConnexionDb connexionDb;
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String TABLA_CATEGORIA = "categoria";

    public dbCategoriaRepositorioImp(Context context) {
        connexionDb = new ConnexionDb(context);
    }

    @Override
    public boolean guardar(Categoria categoria){

        if( categoria.getId() != null && categoria.getId() > 0) {
            return actualizar(categoria);
        }
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, categoria.getNombre());

        SQLiteDatabase db = connexionDb.getWritableDatabase();
        Long id = db.insert(TABLA_CATEGORIA, null, cv);

        db.close();

        if(id.intValue() > 0){
            categoria.setId(id.intValue());
            return true;
        }

        return false;
    }

    @Override
    public boolean actualizar(Categoria categoria){
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, categoria.getNombre());

        SQLiteDatabase db = connexionDb.getWritableDatabase();
        int cantidad = db.update(TABLA_CATEGORIA, cv, "id == ?", new String[]{categoria.getId().toString()}); // El array de string son los parametros :)

        db.close();

        return cantidad > 0;
    }

    @Override
    public Categoria buscar(int id){
        return null;
    }
    @Override
    public List<Categoria> buscar(String buscar){
        List<Categoria> categorias = new ArrayList<>();
        SQLiteDatabase db = connexionDb.getReadableDatabase();
        String[] columnas = {"id", CAMPO_NOMBRE};

        //TODO: filter categorias por nombre (LIKE)
        Cursor cr = db.query(TABLA_CATEGORIA, columnas, null, null , null, null, null);
        cr.moveToFirst();

        while (!cr.isAfterLast()) {
            int id = cr.getInt(cr.getColumnIndex("id"));
            String nombre = cr.getString(cr.getColumnIndex(CAMPO_NOMBRE) );

            // agregamos la categoria a la lista.
            categorias.add( new Categoria(id,nombre));
            cr.moveToNext();
        }
        cr.close();
        db.close();
        return categorias;
    }
}

