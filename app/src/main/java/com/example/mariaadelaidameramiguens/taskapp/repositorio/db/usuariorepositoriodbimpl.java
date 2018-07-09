package com.example.mariaadelaidameramiguens.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Usuario;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.UsuarioRepositorio;

public class usuariorepositoriodbimpl implements UsuarioRepositorio {

    private ConnexionDb connexionDb;
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String CAMPO_EMAIL = "email";
    private static final String CAMPO_CONTRASENA = "password";
    private static final String CAMPO_TIPOUSUARIO = "tipoUsuario";
    private static final String TABLA_USUARIO = "usuario";

    public usuariorepositoriodbimpl(Context context) {
        connexionDb = new ConnexionDb(context);
    }

    @Override
    public boolean guardar(Usuario usuario) {
//        if( buscar(usuario)) {
//            return false;
//        }
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
        return false;
    }

    @Override
    public Usuario buscar(int id) {
        return null;
    }

    public boolean buscar(Usuario usuario) {
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_EMAIL, usuario.getNombre());

        SQLiteDatabase db = connexionDb.getWritableDatabase();
        int cantidad = db.update(TABLA_USUARIO, cv, "email == ?", new String[]{usuario.getNombre().toString()}); //Check if email already Exist

        db.close();

        return cantidad > 0;
    }
}
