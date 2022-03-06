/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjavafxml;
import com.pmp.dao.Cliente;
import java.util.HashSet;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
/**
 *
 * @author leona
 */
public class ClienteAdapter {

    /**
     * @return the nombreProducto
     */
    public SimpleStringProperty getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(SimpleStringProperty nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the descripcion
     */
    public SimpleStringProperty getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(SimpleStringProperty descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the categoria
     */
    public SimpleStringProperty getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(SimpleStringProperty categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the marca
     */
    public SimpleStringProperty getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(SimpleStringProperty marca) {
        this.marca = marca;
    }

    /**
     * @return the precio
     */
    public SimpleDoubleProperty getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(SimpleDoubleProperty precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidad
     */
    public SimpleDoubleProperty getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(SimpleDoubleProperty cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the estado
     */
    public SimpleStringProperty getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(SimpleStringProperty estado) {
        this.estado = estado;
    }

    /**
     * @return the id
     */
    public SimpleIntegerProperty getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(SimpleIntegerProperty id) {
        this.id = id;
    }
    
    private Cliente _cliente;
    
    public Cliente getProducto() {
        _cliente.setNombreProducto(nombreProducto.get());
        _cliente.setDescripcion(descripcion.get());
        _cliente.setCategoria(categoria.get());
        _cliente.setMarca(marca.get());
        _cliente.setPrecio(precio.get());
        _cliente.setCantidad(cantidad.get());
        _cliente.setEstado(estado.get());
        _cliente.setId(id.get());
        
        return this._cliente;
    }
    
    public ClienteAdapter() {
        this._cliente = new Cliente();
        nombreProducto = new SimpleStringProperty("");
        descripcion = new SimpleStringProperty("");
        categoria = new SimpleStringProperty("");
        marca = new SimpleStringProperty("");
        precio = new SimpleDoubleProperty(0);
        cantidad = new SimpleDoubleProperty(0);
        estado = new SimpleStringProperty("");
    }
    
    public ClienteAdapter(Cliente _producto) {
        this._cliente = _producto;
        nombreProducto = new SimpleStringProperty("");
        descripcion = new SimpleStringProperty("");
        categoria = new SimpleStringProperty("");
        marca = new SimpleStringProperty("");
        precio = new SimpleDoubleProperty(0);
        cantidad = new SimpleDoubleProperty(0);
        estado = new SimpleStringProperty("");
        id = new SimpleIntegerProperty(0);
        
        nombreProducto.set(_producto.getNombreProducto());
        descripcion.set(_cliente.getDescripcion());
        categoria.set(_cliente.getCategoria());
        marca.set(_cliente.getMarca());
        precio.set(_cliente.getPrecio());
        cantidad.set(_cliente.getCantidad());
        estado.set(_cliente.getEstado());
        id.set(_cliente.getId());
    }
    
    private SimpleStringProperty nombreProducto;
    private SimpleStringProperty descripcion;
    private SimpleStringProperty categoria;
    private SimpleStringProperty marca;
    private SimpleDoubleProperty precio;
    private SimpleDoubleProperty cantidad;
    private SimpleStringProperty estado;
    private SimpleIntegerProperty id;
}
