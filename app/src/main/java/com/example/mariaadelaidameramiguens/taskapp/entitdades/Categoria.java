package com.example.mariaadelaidameramiguens.taskapp.entitdades;

/**
 * Created by MESCyT on 9/6/2018.
 */

public class Categoria {
    private int id;
    private String nombre;

    public Categoria() {
    }

    public Categoria(int id) {
        this.id = id;
    }

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public Categoria setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", descripcion='" + nombre + '\'' +
                '}';
    }
}
