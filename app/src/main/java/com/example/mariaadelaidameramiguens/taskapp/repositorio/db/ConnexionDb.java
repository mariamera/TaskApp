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
    private static final int DATABASE_VERSION = 2;


    public ConnexionDb(Context context) {
        super(context, NOMBRE_DB, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_TAG,"creando la base de datos");
        db.execSQL(EstructuraDb.TABLA_CATEGORIA);
        db.execSQL(EstructuraDb.TABLA_USUARIO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            //db.execSQL("ALTER TABLE foo ADD COLUMN new_column INTEGER DEFAULT 0");
            onCreate(db);
        }
    }
}
