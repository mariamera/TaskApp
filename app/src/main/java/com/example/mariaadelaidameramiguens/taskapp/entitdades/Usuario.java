package com.example.mariaadelaidameramiguens.taskapp.entitdades;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MESCyT on 7/7/2018.
 */

public class Usuario implements Serializable {

    public enum TipoUsuario {
        TECNICO,
        NORMAL
    }
    private Integer id;
    private String nombre;
    private String email;
    private String contrasena;

    public Usuario(Integer id, String nombre, String email, String contrasena, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario() {}

    private  TipoUsuario tipoUsuario;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", contrasena='").append(contrasena).append('\'');
        sb.append(", tipoUsuario=").append(tipoUsuario);
        sb.append('}');
        return sb.toString();
    }

    public static boolean validarContrasena(String contrasenaUna,String contrasenaDos) {
        return new String(contrasenaUna).equals(contrasenaDos);
    }
}
