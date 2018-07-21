package com.example.mariaadelaidameramiguens.taskapp.entitdades;

/**
 * Created by MESCyT on 21/7/2018.
 */
import android.app.Application;

public class DataHolder{
    private Usuario usuario;
    public Usuario getData() {return usuario;}
    public void setData(Usuario usuario) {this.usuario = usuario;}

    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() {return holder;}
}