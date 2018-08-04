package com.example.mariaadelaidameramiguens.taskapp.entitdades;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MESCyT on 7/7/2018.
 */

public class Tarea implements Serializable {

    public enum TareaEstado {
        PENDIENTE,
        EN_PROCESO,
        TERMINADO
    }

    private Integer id;
    private String nombre;
    private String description;
    private Date fecha;
    private Date fechaTerminada;
    TareaEstado estado;
    Usuario usuarioCreador;
    Usuario usuarioAsignado;
    int categoriaID;

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaTerminada() {
        return fechaTerminada;
    }

    public void setFechaTerminada(Date fechaTerminada) {
        this.fechaTerminada = fechaTerminada;
    }

    public TareaEstado getEstado() {
        return estado;
    }

    public void setEstado(TareaEstado estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Usuario getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Tarea{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", fecha=").append(fecha);
        sb.append(", fechaTerminada=").append(fechaTerminada);
        sb.append(", estado=").append(estado);
        sb.append(", usuarioCreador=").append(usuarioCreador);
        sb.append(", usuarioAsignado=").append(usuarioAsignado);
        sb.append('}');
        return sb.toString();
    }
}
