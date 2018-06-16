package com.example.mariaadelaidameramiguens.taskapp.repositorio.db;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.CategoriaRepositorio;

import java.util.List;

/**
 * Created by Maria Mera on 16/6/2018.
 */

public class dbCategoriaRepositorioImp implements CategoriaRepositorio {

    @Override
    public boolean guardar(Categoria categoria){
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

