package com.example.mariaadelaidameramiguens.taskapp.repositorio.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Maria Mera on 16/6/2018.
 */

public class ConnexionDb extends SQLiteOpenHelper {
    private static final String LOG_TAG = "connextionDb";
    private static final String NOMBRE_DB = "taskapp.db";
    private static final int VERSION_BD = 1;


    public ConnexionDb(Context context) {
        super(context, NOMBRE_DB, null , VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_TAG,"creando la base de datos");
        db.execSQL(EstructuraDb.TABLA_CATEGORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //TODO: something for later
    }
}
