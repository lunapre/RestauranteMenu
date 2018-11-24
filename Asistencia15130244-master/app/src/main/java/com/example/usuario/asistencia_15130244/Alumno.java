package com.example.usuario.asistencia_15130244;

public class Alumno {
    int foto;
    String nombre;
    String matricula;
    int asistencia;

    public Alumno(int foto,String nombre,String matricula,int asistencia){
        this.foto=foto;
        this.nombre=nombre;
        this.matricula=matricula;
        this.asistencia=asistencia;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }
}
