package com.example.mariaadelaidameramiguens.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mariaadelaidameramiguens.taskapp.entitdades.Categoria;
import com.example.mariaadelaidameramiguens.taskapp.entitdades.Tarea;
import com.example.mariaadelaidameramiguens.taskapp.repositorio.TareaRepositorio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MESCyT on 21/7/2018.
 */

public class TareaRepositorioImp implements TareaRepositorio{
    private ConnexionDb connexionDb;
    private static final String CAMPO_DESCRIPCION = "descripcion";
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_FECHA = "fecha";
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String CAMPO_FECHA_COMPLETADO = "fecha_completado";
    private static final String CAMPO_ESTADO = "estado";
    private static final String CAMPO_USUARIO_CREADOR_ID = "usuario_creador_id";
    private static final String CAMPO_USUARIO_ASIGNADO_ID = "usuario_asignado_id";
    private static final String CAMPO_CATEGORIA_ID = "categoria_id";
    private static final String TABLA_TAREA = "tarea";
    private static final String LOG_TAG = "LogInRepositorio";

    public TareaRepositorioImp(Context context) {
        connexionDb = new ConnexionDb(context);
    }

    @Override
    public boolean guardar(Tarea tarea) {

        ContentValues cv = new ContentValues();
        cv.put(CAMPO_DESCRIPCION, tarea.getDescription());
        cv.put(CAMPO_FECHA, String.valueOf(tarea.getFecha()));
        cv.put(CAMPO_FECHA_COMPLETADO, String.valueOf(tarea.getFechaTerminada()));
//        cv.put(CAMPO_ESTADO, tarea.getEstado().name());
        cv.put(CAMPO_NOMBRE, tarea.getNombre());
        cv.put(CAMPO_CATEGORIA_ID, tarea.getCategoriaID());
        cv.put(CAMPO_USUARIO_CREADOR_ID, tarea.getUsuarioCreador());
        cv.put(CAMPO_USUARIO_ASIGNADO_ID, tarea.getUsuarioAsignado());

        SQLiteDatabase db = connexionDb.getWritableDatabase();
        Long id = db.insert(TABLA_TAREA, null, cv);

        db.close();

        if(id.intValue() > 0){
            tarea.setId(id.intValue());
            return true;
        }

        return false;
    }

    @Override
    public boolean actualizar(Tarea tarea) {
        return false;
    }

    @Override
    public Tarea buscar(int id) {
        return null;
    }

    @Override
    public List<Tarea> buscarTareas() {

        List<Tarea> listaTareas = new ArrayList<>();
        SQLiteDatabase db = connexionDb.getReadableDatabase();
        String[] columnas = {CAMPO_ID, CAMPO_DESCRIPCION, CAMPO_NOMBRE,CAMPO_FECHA , CAMPO_FECHA_COMPLETADO , CAMPO_ESTADO ,CAMPO_USUARIO_CREADOR_ID, CAMPO_USUARIO_ASIGNADO_ID,CAMPO_CATEGORIA_ID  };

        //TODO: filter categorias por nombre (LIKE)
        Cursor cr = db.query(TABLA_TAREA, columnas, null, null , null, null, null);
        cr.moveToFirst();

        while (!cr.isAfterLast()) {
            Tarea tarea = new Tarea();
            tarea.setId(cr.getInt(cr.getColumnIndex(CAMPO_ID)));
            tarea.setNombre(cr.getString(cr.getColumnIndex(CAMPO_NOMBRE)));
            tarea.setDescription(cr.getString(cr.getColumnIndex(CAMPO_DESCRIPCION)));
            tarea.setFecha(cr.getString(cr.getColumnIndex(CAMPO_FECHA)));

            // agregamos la categoria a la lista.
            listaTareas.add( tarea);
            cr.moveToNext();
        }
        cr.close();
        return listaTareas;
    }

    @Override
    public boolean buscar(Tarea id) {
        return false;
    }
}
