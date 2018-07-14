package com.example.mariaadelaidameramiguens.taskapp.repositorio;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;

import java.util.List;

public interface UsuarioRepositorio {

    public boolean guardar(Usuario usuario);

    public boolean actualizar(Usuario usuario);

    public Usuario buscar(int id);

    public List<Usuario> buscarTecnicos();

    public Usuario buscar(String username);

    public boolean buscar(Usuario username);

}
