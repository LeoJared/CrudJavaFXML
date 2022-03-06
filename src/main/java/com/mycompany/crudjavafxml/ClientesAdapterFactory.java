/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjavafxml;

import java.util.ArrayList;
import com.pmp.dao.Cliente;

/**
 *
 * @author leona
 */
public class ClientesAdapterFactory {
    public static ArrayList<ClienteAdapter> obtenerdelArrayListProductos(ArrayList<Cliente> productos) {
        ArrayList<ClienteAdapter> productosAdaptados = new ArrayList();
        
        productos.forEach((producto) -> productosAdaptados.add(new ClienteAdapter(producto)));
        return productosAdaptados;
    }
}
