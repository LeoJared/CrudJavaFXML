package com.mycompany.crudjavafxml;

import com.pmp.dao.Cliente;
import com.pmp.dao.Clientes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController implements Initializable{
    int contador = 0;
    
    enum FormMode {
        INSERTAR,
        ACTUALIZAR,
        ELIMINAR,
        MOSTRAR
    }
    
    @FXML
    private TableView tblProductos;
    @FXML
    private TableColumn clmProducto;
    @FXML
    private TableColumn clmCategoria;
    @FXML
    private TableColumn clmPrecio;
    @FXML
    private TableColumn clmCantidad;
    @FXML
    private TableColumn clmEstado;
    
    private ObservableList<ClienteAdapter> listaProductos;
    private Clientes modeloProductos;
    
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnMostrar;
    @FXML
    private Button btnEliminar;
    
    FormMode mode;
    
    private void recargarDatos() {
        listaProductos = FXCollections.observableArrayList(ClientesAdapterFactory.obtenerdelArrayListProductos(modeloProductos.obtenerClientes()));
        
        this.tblProductos.getItems().clear();
        this.tblProductos.getItems().addAll(listaProductos);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modeloProductos = new Clientes();
        
        this.clmProducto.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("nombreProducto"));
        this.clmCategoria.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("cantidad"));
        this.clmPrecio.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("precio"));
        this.clmCantidad.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("cantidad"));
        this.clmEstado.setCellValueFactory(new PropertyValueFactory<ClienteAdapter, String>("estado"));
        
        recargarDatos();
    }
    
    private Cliente cargarProductoForm(Cliente cliente) throws IOException {
        try {
            FXMLLoader win = App.getFXMLLoader("productoform");
            Parent winObject = win.load();
            ClienteformController productosWin = (ClienteformController) win.getController();
            productosWin.setProductoObject(cliente);
            productosWin.setMode(mode.name());
            App.loadFXMLModal(winObject);
            
            if (productosWin.esConfirmarAccion()) {
                return productosWin.getProductoObject();
            }          
            return null;
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
    }

    @FXML
    private void btnNuevo_click(ActionEvent event) {
        try {
            mode = FormMode.INSERTAR;
            Cliente infoForm = cargarProductoForm(new Cliente());
            
            if (infoForm != null) {
                modeloProductos.agregarCliente(infoForm);
                recargarDatos();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    @FXML
    private void btnEditar_click(ActionEvent event) {
        try {
            mode = FormMode.ACTUALIZAR;
            Cliente infoForm = cargarProductoForm(((ClienteAdapter)tblProductos.getSelectionModel().getSelectedItem()).getProducto());
            
            if (infoForm != null) {
                modeloProductos.actualizarCliente(infoForm);
                recargarDatos();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    @FXML
    private void btnMostrar_click(ActionEvent event) {
        try {
            mode = FormMode.MOSTRAR;
            Cliente infoForm = cargarProductoForm(((ClienteAdapter)tblProductos.getSelectionModel().getSelectedItem()).getProducto());
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    @FXML
    private void btnEliminar_click(ActionEvent event) {
        try {
            mode = FormMode.ELIMINAR;
            Cliente infoForm = cargarProductoForm(((ClienteAdapter)tblProductos.getSelectionModel().getSelectedItem()).getProducto());
            
            if (infoForm != null) {
                modeloProductos.deleteCliente(infoForm.getId());
                recargarDatos();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
