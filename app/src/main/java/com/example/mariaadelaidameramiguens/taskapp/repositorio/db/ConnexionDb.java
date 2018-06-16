package com.example.mariaadelaidameramiguens.taskapp.repositorio.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maria Mera on 16/6/2018.
 */

public class ConnexionDb extends SQLiteOpenHelper {

    private static final String NOMBRE_DB = "taskapp.db";
    private static final int VERSION_BD = 1;


    public ConnexionDb(Context context) {
        super(context, NOMBRE_DB, null , VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
