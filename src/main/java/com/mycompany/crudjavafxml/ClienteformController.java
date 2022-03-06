/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjavafxml;

import com.pmp.dao.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author leona
 */
public class ClienteformController implements Initializable {

    @FXML
    private TextField txtNombreProducto;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtCategoria;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtCantidad;
    @FXML
    private RadioButton rdbEstadoActivo;
    @FXML
    private ToggleGroup estado;
    @FXML
    private RadioButton rdbEstadoInactivo;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    
    private boolean confirmarAccion = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnConfirmar_click(ActionEvent event) {
        this.confirmarAccion = true;
        App.closeModal(event);
    }

    @FXML
    private void btnCancelar_click(ActionEvent event) {
        this.confirmarAccion = false;
        App.closeModal(event);
    }
    
    private Cliente _cliente;
    
    public void setProductoObject(Cliente producto) {
        _cliente = producto;
        refreshUX();
    }
    
    private void refreshUX() {
        txtNombreProducto.setText(_cliente.getNombreProducto());
        txtDescripcion.setText(_cliente.getDescripcion());
        txtCategoria.setText(_cliente.getCategoria());
        txtMarca.setText(_cliente.getMarca());
        txtPrecio.setText(Double.toString(_cliente.getPrecio()));
        txtCantidad.setText(Double.toString(_cliente.getCantidad()));
        
        boolean estadoEsA = _cliente.getEstado().equals("A");
        
        rdbEstadoActivo.setSelected(estadoEsA);
        rdbEstadoInactivo.setSelected(!estadoEsA);
    }
    
    public void setMode(String mode) {
        switch (mode) {
            case "INSERTAR":
            case "ACTUALIZAR":                
                break;
            case "ELIMINAR", "MOSTRAR":
                txtNombreProducto.setEditable(false);
                txtDescripcion.setEditable(false);
                txtCategoria.setEditable(false);
                txtMarca.setEditable(false);
                txtPrecio.setEditable(false);
                txtCantidad.setEditable(false);
                
                rdbEstadoActivo.setDisable(true);
                rdbEstadoInactivo.setDisable(true);
                
                if (mode == "MOSTRAR")
                    btnConfirmar.setVisible(false);
                break;
        }
    }
    
    public Cliente getProductoObject() {
        refreshObjFromUx();
        return _cliente;
    }
    
    public void refreshObjFromUx() {
        _cliente.setNombreProducto(txtNombreProducto.getText());
        _cliente.setDescripcion(txtDescripcion.getText());
        _cliente.setCategoria(txtCategoria.getText());
        _cliente.setMarca(txtMarca.getText());
        _cliente.setPrecio(Double.parseDouble(txtPrecio.getText()));
        _cliente.setCantidad(Double.parseDouble(txtCantidad.getText()));
        
        _cliente.setEstado(rdbEstadoActivo.isSelected()?"A":"I");
    }
    
    public boolean esConfirmarAccion() {
        return confirmarAccion;
    }   
}
