package com.example.mariaadelaidameramiguens.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.UsuarioRepositorio;

import java.util.ArrayList;
import java.util.List;

public class Usuariorepositoriodbimpl implements UsuarioRepositorio {

    private ConnexionDb connexionDb;
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_EMAIL = "email";
    private static final String CAMPO_CONTRASENA = "password";
    private static final String CAMPO_TIPOUSUARIO = "tipoUsuario";
    private static final String TABLA_USUARIO = "usuario";
    private static final String LOG_TAG = "UsuarioRepositorio";

    public Usuariorepositoriodbimpl(Context context) {
        connexionDb = new ConnexionDb(context);
    }

    @Override
    public boolean guardar(Usuario usuario) {

        if( buscar(usuario)) {
           // return false;
            return actualizar(usuario);
        }
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, usuario.getNombre());
        cv.put(CAMPO_EMAIL, usuario.getEmail());
        cv.put(CAMPO_CONTRASENA, usuario.getContrasena());
        cv.put(CAMPO_TIPOUSUARIO, usuario.getTipoUsuario().name());

        SQLiteDatabase db = connexionDb.getWritableDatabase();
        Long id = db.insert(TABLA_USUARIO, null, cv);

        db.close();

        if(id.intValue() > 0){
            usuario.setId(id.intValue());
            return true;
        }

        return false;
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, usuario.getNombre());
        cv.put(CAMPO_EMAIL, usuario.getEmail());
        cv.put(CAMPO_CONTRASENA, usuario.getContrasena());
        cv.put(CAMPO_TIPOUSUARIO, usuario.getTipoUsuario().name());

        SQLiteDatabase db = connexionDb.getWritableDatabase();
        int cantidad = db.update(TABLA_USUARIO, cv, "id == ?", new String[]{usuario.getId().toString()}); // El array de string son los parametros :)

        db.close();

        return cantidad > 0;

    }

    @Override
    public Usuario buscar(int id) {
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_ID, id);
        String[] columnas = {CAMPO_ID, CAMPO_NOMBRE,CAMPO_EMAIL,CAMPO_CONTRASENA, CAMPO_TIPOUSUARIO };

        SQLiteDatabase db = connexionDb.getReadableDatabase();

        //TODO: filter categorias por nombre (LIKE)
        Cursor cr = db.query(TABLA_USUARIO, columnas, CAMPO_ID + "=?", new String[]{ Integer.toString(id) }, null, null, null);
        int cantidadDeUsuarios = cr.getCount();
        db.close();
        Usuario usuario = new Usuario();

        if (cr != null){
            cr.moveToFirst();
            usuario.setId(cr.getInt(cr.getColumnIndex(CAMPO_ID)));
            usuario.setNombre(cr.getString(cr.getColumnIndex(CAMPO_NOMBRE)));
            usuario.setEmail(cr.getString(cr.getColumnIndex(CAMPO_EMAIL)));
            usuario.setEmail(cr.getString(cr.getColumnIndex(CAMPO_CONTRASENA)));
            usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(cr.getString(cr.getColumnIndex(CAMPO_TIPOUSUARIO))));
        }

        return usuario;
    }

    @Override
    public List<Usuario> buscarTecnicos() {
        List<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = connexionDb.getReadableDatabase();
        String[] columnas = {CAMPO_ID, CAMPO_NOMBRE,CAMPO_EMAIL,CAMPO_CONTRASENA, CAMPO_TIPOUSUARIO };

        //TODO: filter categorias por nombre (LIKE)
        Cursor cr = db.query(TABLA_USUARIO, columnas, CAMPO_TIPOUSUARIO + "=?", new String[]{ Usuario.TipoUsuario.TECNICO.name() }, null , null, null, null);

        cr.moveToFirst();

        while (!cr.isAfterLast()) {
        Usuario usuario = new Usuario();
        usuario.setId(cr.getInt(cr.getColumnIndex(CAMPO_ID)));
        usuario.setNombre(cr.getString(cr.getColumnIndex(CAMPO_NOMBRE)));
        usuario.setEmail(cr.getString(cr.getColumnIndex(CAMPO_EMAIL)));
        usuario.setContrasena(cr.getString(cr.getColumnIndex(CAMPO_CONTRASENA)));
        usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(cr.getString(cr.getColumnIndex(CAMPO_TIPOUSUARIO))));
            // agregamos la categoria a la lista.
            usuarios.add( usuario);
            cr.moveToNext();
        }
        cr.close();
        db.close();
        return usuarios;
    }

    @Override
    public Usuario buscar(String username) {
        return null;
    }

    public boolean buscar(Usuario usuario) {
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_EMAIL, usuario.getEmail());
        String[] columnas = {"id", CAMPO_NOMBRE,CAMPO_EMAIL };

        SQLiteDatabase db = connexionDb.getReadableDatabase();

        //TODO: filter categorias por nombre (LIKE)
        Cursor cr = db.query(TABLA_USUARIO, columnas, CAMPO_EMAIL + "=?", new String[]{ usuario.getEmail()}, null, null, null);
        int cantidadDeUsuarios = cr.getCount();
        db.close();

        return cantidadDeUsuarios > 0;
    }
}
