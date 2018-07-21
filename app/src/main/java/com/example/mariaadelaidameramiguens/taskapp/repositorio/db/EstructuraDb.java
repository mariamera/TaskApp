package com.example.mariaadelaidameramiguens.taskapp.repositorio.db;

/**
 * Created by MESCyT on 16/6/2018.
 */

public class EstructuraDb {

    public static final String TABLA_CATEGORIA = "CREATE TABLE IF NOT EXISTS  categoria ( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)";
    public static final String TABLA_USUARIO = "CREATE TABLE IF NOT EXISTS  usuario ( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, email TEXT, password TEXT, tipoUsuario TEXT)";
    public static final String TABLA_TAREA = "CREATE TABLE IF NOT EXISTS tarea ( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, descripcion TEXT,fecha NUMERIC NOT NULL,fecha_completado NUMERIC,estado TEXT NOT NULL DEFAULT 'PENDIENTE',usuario_creador_id INTEGER NOT NULL,usuario_asignado_id INTEGER NOT NULL, categoria_id INTEGER NOT NULL)";


}