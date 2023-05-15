package com.example.homexpress.entidades;

public class Producto {
    private int id_producto, cant_producto;
    private String nombre_prod;
    private int precio_prod;

    //Constructor vacío
    public Producto() {
    }
    //Constructor con argumentos
    public Producto(int id_producto, int cant_producto, String nombre_prod, int precio_prod) {
        this.id_producto = id_producto;
        this.cant_producto = cant_producto;
        this.nombre_prod = nombre_prod;
        this.precio_prod = precio_prod;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCant_producto() {
        return cant_producto;
    }

    public void setCant_producto(int cant_producto) {
        this.cant_producto = cant_producto;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public double getPrecio_prod() {
        return precio_prod;
    }

    public void setPrecio_prod(int precio_prod) {
        this.precio_prod = precio_prod;
    }


}
