package com.example.mariaadelaidameramiguens.taskapp.entitdades;

/**
 * Created by MESCyT on 9/6/2018.
 */

public class Categoria {
    private int id;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
