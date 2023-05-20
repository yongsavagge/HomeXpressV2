package com.example.homexpress.entidades;

public class Producto {
    private String txtnombre;
    private int numCant;
    private int numPrecio;

    //Constructor vacío
    public Producto() {
    }
    //Constructor con argumentos


    public Producto(String txtnombre, int numCant, int numPrecio) {
        this.txtnombre = txtnombre;
        this.numCant = numCant;
        this.numPrecio = numPrecio;
    }

    public String getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(String txtnombre) {
        this.txtnombre = txtnombre;
    }

    public int getNumCant() {
        return numCant;
    }

    public void setNumCant(int numCant) {
        this.numCant = numCant;
    }

    public int getNumPrecio() {
        return numPrecio;
    }

    public void setNumPrecio(int numPrecio) {
        this.numPrecio = numPrecio;
    }
}
