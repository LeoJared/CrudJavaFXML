/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author leona
 */
public class Conexion {
    private static Connection _conexion = null;
    private Conexion() {
    
    }
    public static Connection getConexion(){
        try {
            if (_conexion == null) {
                Class.forName("org.sqlite.JDBC");
                _conexion = DriverManager.getConnection("jdbc:sqlite:Inventario.db");
            }
            return _conexion;
            
        } catch ( Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            return null;
        }
    }
}
