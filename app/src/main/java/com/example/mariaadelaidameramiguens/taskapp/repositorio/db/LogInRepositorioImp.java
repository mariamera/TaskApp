package com.example.mariaadelaidameramiguens.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.LogInRepositorio;

public class LogInRepositorioImp implements LogInRepositorio{

    private ConnexionDb connexionDb;
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_EMAIL = "email";
    private static final String CAMPO_CONTRASENA = "password";
    private static final String CAMPO_TIPOUSUARIO = "tipoUsuario";
    private static final String TABLA_USUARIO = "usuario";
    private static final String LOG_TAG = "LogInRepositorio";

    //    public Usuariorepositoriodbimpl(Context context) {
    //        connexionDb = new ConnexionDb(context);
    //    }
    public LogInRepositorioImp(Context context) {
        connexionDb = new ConnexionDb(context);
    }
    @Override
    public Usuario logIn(String usuario, String contrasena) {
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_EMAIL, usuario);
        cv.put(CAMPO_CONTRASENA, contrasena);
        String[] columnas = {"id", CAMPO_NOMBRE,CAMPO_EMAIL,CAMPO_CONTRASENA, CAMPO_TIPOUSUARIO };

        SQLiteDatabase db = connexionDb.getReadableDatabase();

        //TODO: filter categorias por nombre (LIKE)
       Cursor cr = db.query(TABLA_USUARIO, columnas, CAMPO_EMAIL  + "=?" + " AND " + CAMPO_CONTRASENA + "=?" , new String[]{ usuario, contrasena }, null, null, null);
        Usuario usuario1 = new Usuario();
        cr.moveToFirst();

        if (cr.getCount() == 1){
            usuario1.setId(cr.getInt(cr.getColumnIndex(CAMPO_ID)));
            usuario1.setNombre(cr.getString(cr.getColumnIndex(CAMPO_NOMBRE)));
            usuario1.setEmail(cr.getString(cr.getColumnIndex(CAMPO_EMAIL)));
            usuario1.setEmail(cr.getString(cr.getColumnIndex(CAMPO_CONTRASENA)));
            usuario1.setTipoUsuario(Usuario.TipoUsuario.valueOf(cr.getString(cr.getColumnIndex(CAMPO_TIPOUSUARIO))));
        }
        db.close();

        return usuario1;

    }
}
