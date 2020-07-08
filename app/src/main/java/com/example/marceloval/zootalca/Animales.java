package com.example.marceloval.zootalca;

public class Animales {

    public int id;
    public String nombre;
    public int imagen1;
    public int imagen2;
    public int imagen3;
    public String descripcion;

    public Animales(){

    }

    public Animales(int id, String nombre, int imagen1, int imagen2, int imagen3, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        this.descripcion = descripcion;
    }

    public Animales(String nombre, int imagen1, int imagen2, int imagen3, String descripcion) {
        this.nombre = nombre;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        this.descripcion = descripcion;
    }

}
