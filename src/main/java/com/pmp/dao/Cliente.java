/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

/**
 *
 * @author leona
 */
public class Cliente {

    /**
     * @return the _nombreProducto
     */
    public String getNombreProducto() {
        return _nombreProducto;
    }

    /**
     * @param _nombreProducto the _nombreProducto to set
     */
    public void setNombreProducto(String _nombreProducto) {
        this._nombreProducto = _nombreProducto;
    }

    /**
     * @return the _descripcion
     */
    public String getDescripcion() {
        return _descripcion;
    }

    /**
     * @param _descripcion the _descripcion to set
     */
    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    /**
     * @return the _categoria
     */
    public String getCategoria() {
        return _categoria;
    }

    /**
     * @param _categoria the _categoria to set
     */
    public void setCategoria(String _categoria) {
        this._categoria = _categoria;
    }

    /**
     * @return the _marca
     */
    public String getMarca() {
        return _marca;
    }

    /**
     * @param _marca the _marca to set
     */
    public void setMarca(String _marca) {
        this._marca = _marca;
    }

    /**
     * @return the _precio
     */
    public double getPrecio() {
        return _precio;
    }

    /**
     * @param _precio the _precio to set
     */
    public void setPrecio(double _precio) {
        this._precio = _precio;
    }

    /**
     * @return the _cantidad
     */
    public double getCantidad() {
        return _cantidad;
    }

    /**
     * @param _cantidad the _cantidad to set
     */
    public void setCantidad(double _cantidad) {
        this._cantidad = _cantidad;
    }

    /**
     * @return the _estado
     */
    public String getEstado() {
        return _estado;
    }

    /**
     * @param _estado the _estado to set
     */
    public void setEstado(String _estado) {
        this._estado = _estado;
    }

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }

    private String _nombreProducto;
    private String _descripcion;
    private String _categoria;
    private String _marca;
    private double _precio;
    private double _cantidad;
    private String _estado = "A";
    private int _id;
}

