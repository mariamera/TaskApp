package com.example.mariaadelaidameramiguens.taskapp.repositorio;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;

import java.util.List;

/**
 * Created by Maria Mera on 16/6/2018.
 */

public interface CategoriaRepositorio {

    boolean guardar(Categoria categoria);

    boolean actualizar(Categoria categoria);

    Categoria buscar(int id);

    List<Categoria> buscar(String Name);

}
