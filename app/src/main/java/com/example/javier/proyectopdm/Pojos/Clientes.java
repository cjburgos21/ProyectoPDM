package com.example.javier.proyectopdm.Pojos;

public class Clientes {

    int id;
    String nombre;

    public Clientes(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId(){return id;}

    public String getNombre() {return nombre;}

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}
