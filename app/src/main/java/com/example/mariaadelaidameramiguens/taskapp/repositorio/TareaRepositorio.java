package com.example.mariaadelaidameramiguens.taskapp.repositorio;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Tarea;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;

import java.util.List;

/**
 * Created by MESCyT on 21/7/2018.
 */

public interface TareaRepositorio {

    public boolean guardar(Tarea tarea);

    public boolean actualizar(Tarea tarea);

    public Tarea buscar(int id);

    public List<Tarea> buscarTareas();

    public List<Tarea> buscarTareas(Usuario usuario);

    public boolean buscar(Tarea id);
}
