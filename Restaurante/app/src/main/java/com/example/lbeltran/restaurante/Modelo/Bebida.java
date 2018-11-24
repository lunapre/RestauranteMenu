package com.example.lbeltran.restaurante.Modelo;

public class Bebida {
    private String nombre;
    private int cantidad=0;
    private int foto;
    private double precio;

    public Bebida(String nombre, int foto, double precio) {
        this.nombre = nombre;
        this.foto = foto;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
