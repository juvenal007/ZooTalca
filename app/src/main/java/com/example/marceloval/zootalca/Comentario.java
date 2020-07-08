package com.example.marceloval.zootalca;


public class Comentario {

    public int id;
    public String nombre;
    public String comentario;

    public Comentario(){

    }

    public Comentario(int id, String nombre, String comentario) {
        this.id = id;
        this.nombre = nombre;
        this.comentario = comentario;
    }

    public Comentario(String nombre, String comentario) {
        this.nombre = nombre;
        this.comentario = comentario;
    }
}
