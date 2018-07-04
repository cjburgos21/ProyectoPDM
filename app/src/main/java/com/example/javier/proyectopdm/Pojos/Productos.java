package com.example.javier.proyectopdm.Pojos;

public class Productos {

    private int id;
    private String categoria;
    private String imagen;
    private String nombre;
    private boolean precio;

    public Productos(String imagen, String nombre, boolean precio, String categoria, int id){

        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.id = id;

    }

    public String getImagen() {return imagen;}

    public String getNombre() {return nombre;}

    public boolean getPrecio() {return precio;}

    public String getCategoria() {return categoria;}

    public int getId() {return id;}

    public void setImagen(String imagen){this.imagen = imagen;}

    public void setNombre(String nombre){this.nombre = nombre;}

    public void setPrecio(boolean precio){this.precio = precio;}

    public void setCategoria(String categoria){this.categoria = categoria;}

    public void setId(int id){this.id = id;}

}
