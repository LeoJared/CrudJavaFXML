/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;

/**
 *
 * @author leona
 */
public class Clientes {
    private Connection _conexion = null;
    
    public Clientes() {
        _conexion = Conexion.getConexion();
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS clientes"
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " nombreProducto TEXT NOT NULL,"
                + " descripcion TEXT NOT NULL,"
                + " categoria TEXT NOT NULL,"
                + " marca TEXT NOT NULL,"
                + " precio DECIMAL(10,2) NOT NULL,"
                + " cantidad DECIMAL(10,2) NOT NULL,"
                + " estado TEXT NOT NULL);";
        
        try {
            Statement comando = _conexion.createStatement();
            int resultado = comando.executeUpdate(sqlCreateTable);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<Cliente> obtenerClientes() {
        try {
            ArrayList clientes = new ArrayList<Cliente>();
            Statement comandoSQL = _conexion.createStatement();
            ResultSet registroTabla = comandoSQL.executeQuery("SELECT * FROM clientes;");
            
            while (registroTabla.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(registroTabla.getInt("id"));
                cliente.setNombreProducto(registroTabla.getString("nombreProducto"));
                cliente.setDescripcion(registroTabla.getString("descripcion"));
                cliente.setCategoria(registroTabla.getString("categoria"));
                cliente.setMarca(registroTabla.getString("marca"));
                cliente.setPrecio(registroTabla.getDouble("precio"));
                cliente.setCantidad(registroTabla.getDouble("cantidad"));
                cliente.setEstado(registroTabla.getString("estado"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<Cliente>();
        }
    }
    
    public Cliente obtenerCliente (int id) {
        try {
            PreparedStatement comandoSQL = _conexion.prepareStatement("SELECT * FROM productos where id = ?;");
            comandoSQL.setInt(1, id);
            ResultSet registroTabla = comandoSQL.executeQuery();
            Cliente cliente = new Cliente();
            
            while (registroTabla.next()) {
                cliente.setId(registroTabla.getInt("id"));
                cliente.setNombreProducto(registroTabla.getString("nombreProducto"));
                cliente.setDescripcion(registroTabla.getString("descripcion"));
                cliente.setCategoria(registroTabla.getString("categoria"));
                cliente.setMarca(registroTabla.getString("marca"));
                cliente.setPrecio(registroTabla.getDouble("precio"));
                cliente.setCantidad(registroTabla.getDouble("cantidad"));
                cliente.setEstado(registroTabla.getString("estado"));
                break;
            }
            return cliente;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public int agregarCliente(Cliente nuevoCliente) {
        try {
            String insertarSQL = "INSERT INTO clientes (nombreProducto, descripcion, categoria, marca, precio, cantidad, estado) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement comandoSQL = _conexion.prepareStatement(insertarSQL);
            
            comandoSQL.setString(1, nuevoCliente.getNombreProducto());
            comandoSQL.setString(2, nuevoCliente.getDescripcion());
            comandoSQL.setString(3, nuevoCliente.getCategoria());
            comandoSQL.setString(4, nuevoCliente.getMarca());
            comandoSQL.setDouble(5, nuevoCliente.getPrecio());
            comandoSQL.setDouble(6, nuevoCliente.getCantidad());
            comandoSQL.setString(7, nuevoCliente.getEstado());
            
            int registrosAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return registrosAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int actualizarCliente (Cliente updateCliente) {
        try {
            String actualizarSQL = "UPDATE clientes SET nombreProducto=?, descripcion=?, categoria=?, marca=?, precio=?, cantidad=?, estado=? where id=?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(actualizarSQL);
            
            comandoSQL.setString(1, updateCliente.getNombreProducto());
            comandoSQL.setString(2, updateCliente.getDescripcion());
            comandoSQL.setString(3, updateCliente.getCategoria());
            comandoSQL.setString(4, updateCliente.getMarca());
            comandoSQL.setDouble(5, updateCliente.getPrecio());
            comandoSQL.setDouble(6, updateCliente.getCantidad());
            comandoSQL.setString(7, updateCliente.getEstado());
            comandoSQL.setInt(8, updateCliente.getId());
            
            int registrosAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return registrosAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int deleteCliente (int id) {
        try {
            String eliminarSQL = "DELETE FROM clientes where id=?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(eliminarSQL);
            
            comandoSQL.setInt(1, id);
            
            int registrosAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return registrosAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}

