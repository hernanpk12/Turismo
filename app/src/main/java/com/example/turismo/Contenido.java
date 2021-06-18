package com.example.turismo;

import java.io.Serializable;

public class Contenido implements Serializable {

    String titulo, nombreArticulo, lugarArticulo, precioArituculo, descripcionArticulo,foto;

    public Contenido(String titulo, String nombreArticulo, String lugarArticulo, String precioArituculo, String descripcionArticulo, String foto) {
        this.titulo = titulo;
        this.nombreArticulo = nombreArticulo;
        this.lugarArticulo = lugarArticulo;
        this.precioArituculo = precioArituculo;
        this.descripcionArticulo = descripcionArticulo;
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getLugarArticulo() {
        return lugarArticulo;
    }

    public void setLugarArticulo(String lugarArticulo) {
        this.lugarArticulo = lugarArticulo;
    }

    public String getPrecioArituculo() {
        return precioArituculo;
    }

    public void setPrecioArituculo(String precioArituculo) {
        this.precioArituculo = precioArituculo;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}