package com.example.lbeltran.restaurante.Modelo;

import java.util.LinkedList;

public class Total {
    private double to;
    private int cantidad;
    private String producto;

    public Total(String producto,int cantidad,double to) {
        this.to = to;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
