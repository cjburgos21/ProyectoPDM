package com.example.javier.proyectopdm.Pojos;

public class Productos {

    private int id;
    private String categoria;
    private String imagen;
    private String nombre;
    private float precio;
    private int __v;

    public Productos(String imagen, String nombre, float precio, String categoria, int id, int __v){

        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.id = id;
        this.__v = __v;

    }

    public String getImagen() {return imagen;}

    public String getNombre() {return nombre;}

    public float getPrecio() {return precio;}

    public String getCategoria() {return categoria;}

    public int getId() {return id;}

    public int get__v() {return __v;}

    public void setImagen(String imagen){this.imagen = imagen;}

    public void setNombre(String nombre){this.nombre = nombre;}

    public void setPrecio(float precio){this.precio = precio;}

    public void setCategoria(String categoria){this.categoria = categoria;}

    public void setId(int id){this.id = id;}

    public void set__v(int __v){this.__v = __v;}
}
