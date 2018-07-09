package com.example.mariaadelaidameramiguens.taskapp.repositorio;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;

import java.util.List;

public interface UsuarioRepositorio {

    boolean guardar(Usuario usuario);

    boolean actualizar(Usuario usuario);

    List<Usuario> buscar(String Name);

    Usuario buscar(int id);
}
