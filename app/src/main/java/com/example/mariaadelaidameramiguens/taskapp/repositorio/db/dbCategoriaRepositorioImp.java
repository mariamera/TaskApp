package com.example.mariaadelaidameramiguens.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.CategoriaRepositorio;

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
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, categoria.getDescripcion());

        SQLiteDatabase db = connexionDb.getWritableDatabase();
        Long id = db.insert(TABLA_CATEGORIA, null, cv);

        if(id.intValue() > 0){
            categoria.setId(id.intValue());
            return true;
        }

        return false;
    }

    @Override
    public boolean actualizar(Categoria categoria){
        return false;
    }

    @Override
    public Categoria buscar(int id){
        return null;
    }
    @Override
    public List<Categoria> buscar(String Name){
        return null;
    }
}

