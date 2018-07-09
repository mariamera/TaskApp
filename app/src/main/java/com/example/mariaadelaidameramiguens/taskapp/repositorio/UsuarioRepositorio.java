package com.example.mariaadelaidameramiguens.taskapp.repositorio;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;

public interface UsuarioRepositorio {

    boolean guardar(Usuario usuario);

    boolean actualizar(Usuario usuario);

    Usuario buscar(int id);
}
