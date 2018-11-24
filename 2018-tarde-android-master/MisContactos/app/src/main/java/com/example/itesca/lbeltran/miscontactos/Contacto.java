package com.example.itesca.lbeltran.miscontactos;

public class Contacto {
    private String nombre;
    private String email;
    private String telefono;
    private String grupo;
    private int foto;

    public Contacto(String nombre, String email, String telefono, String grupo, int foto) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.grupo = grupo;
        this.foto = foto;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
