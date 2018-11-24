package com.example.naty6.listaconbasedatos;

public class Contacto {
    private static int id0=0;
    private int id=0;
    private String nombre;
    private String email;
    private String telefono;

    public Contacto( String nombre, String email, String telefono) {
        //this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public static int getId0() {
        return id0;
    }

    public static void setId0(int id0) {
        Contacto.id0 = id0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

