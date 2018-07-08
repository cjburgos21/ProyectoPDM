package com.example.javier.proyectopdm.Pojos;

public class Factura {

    private int id;
    private String fecha;
    private Usuario usuario;
    private Carrito carrito;
    private Empleado empleado;
    private String estado;
    private int __v;


    public Factura(int i, String fecha, Usuario usuario, Empleado empleado, Carrito carrito, String estado, int __v) {
        this.id = id;
        this.fecha = fecha;
        this.usuario = usuario;
        this.empleado = empleado;
        this.carrito = carrito;
        this.estado = estado;
        this.__v = __v;
    }

    public int getId(){return id;}

    public String getFecha(){return fecha;}

    public Usuario getUsuario(){return usuario;}

    public Carrito getCarrito(){return  carrito;}

    public Empleado getEmpleado(){return empleado;}

    public String getEstado(){return estado;}

    public int get__v(){return __v;}

    public void setId(int id){
        this.id = id;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void setCarrito(Carrito carrito){
        this.carrito = carrito;
    }

    public void setEmpleado(Empleado empleado){
        this.empleado = empleado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public void set__v(int __v) {this.__v = __v;}
}
