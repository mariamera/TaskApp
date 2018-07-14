package com.example.mariaadelaidameramiguens.taskapp.repositorio.db;

/**
 * Created by MESCyT on 16/6/2018.
 */

public class EstructuraDb {

    public static final String TABLA_CATEGORIA = "CREATE TABLE IF NOT EXISTS  categoria ( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)";
    public static final String TABLA_USUARIO = "CREATE TABLE IF NOT EXISTS  usuario ( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, email TEXT, password TEXT, tipoUsuario TEXT)";

}