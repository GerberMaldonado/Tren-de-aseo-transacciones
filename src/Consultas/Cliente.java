package Consultas;

import ConexionBaseDatos.Conexion;
import Interfaz.Clientes;
import static Interfaz.Clientes.tablaClientes;
//para poder utilizar las datos de los jtext
import static Interfaz.Clientes.txtNumCliente;
import static Interfaz.Clientes.txtNombres;
import static Interfaz.Clientes.txtDpi;
import static Interfaz.Clientes.txtApellidos;
import static Interfaz.Clientes.txtAldea;
import static Interfaz.Clientes.txtBoleto;
import static Interfaz.Clientes.txtTelefono;
import static Interfaz.Clientes.txtMunicipio;
import static Interfaz.Clientes.txtDireccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cliente {
    
    DefaultTableModel modeloMCliente;
    Connection con = null;
    Object datos[];
    String columnas[];
    public Cliente() throws SQLException{//Constructor
        con = Conexion.ConnecrDb();
        con.setAutoCommit(false);
    }
    
    public DefaultTableModel verClientes(){//Método para enviar la lista de clientes
        int nC = 0;
        try{        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCliente, Nombres, Apellidos, CUI, Direccion, Municipio, al.Aldea, cas.Caserio FROM Cliente c LEFT JOIN Caserio cas ON c.Caserio_ID = cas.idCaserio LEFT JOIN Aldea al ON c.Aldea_idAldea = al.idAldea ORDER BY idCliente ASC");
            ResultSetMetaData rsMeta=rs.getMetaData();
            nC=rsMeta.getColumnCount();
            datos = new Object[nC];//Número de columnas para rellenar las filas
            columnas = new String[nC];
            for(int i=1; i<=nC; i++){
                columnas[i-1]=rsMeta.getColumnName(i);
            }
            columnas[0] = "No.";
            columnas[4] = "Dirección";
            modeloMCliente = new DefaultTableModel(null, columnas){
            @Override
                public boolean isCellEditable (int fila, int columna) {
                    return false;
                }
            };
            while(rs.next()){
                for(int i=0; i<nC; i++){
                    datos[i] = rs.getObject(i+1);
                }
                modeloMCliente.addRow(datos);
            }         
            rs.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        }  
        return modeloMCliente;
    }
    
    public DefaultTableModel verCDpi(String cadBuscar){//Búscar cliente por dpi
        con = Conexion.ConnecrDb();
        try{        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCliente, Nombres, Apellidos, CUI, Direccion, Municipio, al.Aldea, cas.Caserio FROM Cliente c LEFT JOIN Caserio cas ON c.Caserio_ID = cas.idCaserio LEFT JOIN Aldea al ON c.Aldea_idAldea = al.idAldea WHERE CUI LIKE '"+cadBuscar+"%'");
            while(rs.next()){
                for(int i=0; i<modeloMCliente.getColumnCount(); i++){
                    datos[i] = rs.getObject(i+1);
                }
                modeloMCliente.addRow(datos);
            }           
            rs.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        } 
        return modeloMCliente;
    }
    
    public DefaultTableModel verCNombre(String cadBuscar){//Búscar cliente por nombre
        con = Conexion.ConnecrDb();
        try{        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCliente, Nombres, Apellidos, CUI, Direccion, Municipio, al.Aldea, cas.Caserio FROM Cliente c LEFT JOIN Caserio cas ON c.Caserio_ID = cas.idCaserio LEFT JOIN Aldea al ON c.Aldea_idAldea = al.idAldea WHERE Nombres LIKE '"+cadBuscar+"%'");
            while(rs.next()){
                for(int i=0; i<modeloMCliente.getColumnCount(); i++){
                    datos[i] = rs.getObject(i+1);
                }
                modeloMCliente.addRow(datos);
            }           
            rs.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        } 
        return modeloMCliente;
    }
    
    public DefaultTableModel verCApellido(String cadBuscar){//Búscar cliente por apellido
        con = Conexion.ConnecrDb();
        try{        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCliente, Nombres, Apellidos, CUI, Direccion, Municipio, al.Aldea, cas.Caserio FROM Cliente c LEFT JOIN Caserio cas ON c.Caserio_ID = cas.idCaserio LEFT JOIN Aldea al ON c.Aldea_idAldea = al.idAldea WHERE Apellidos LIKE '"+cadBuscar+"%'");
            while(rs.next()){
                for(int i=0; i<modeloMCliente.getColumnCount(); i++){
                    datos[i] = rs.getObject(i+1);
                }
                modeloMCliente.addRow(datos);
            }           
            rs.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        } 
        return modeloMCliente;
    }
    
    public void limpiarTabla(){
        while (modeloMCliente.getRowCount() > 0){
            modeloMCliente.removeRow(0);
        }
    }
    
    //Insertar datos a la base de datos
    public void insertarCliente() throws SQLException{            
        if (("".equals(txtNumCliente.getText()))||("".equals(txtDpi.getText()))||("".equals(txtNombres.getText()))||
            ("".equals(txtApellidos.getText()))||("".equals(txtMunicipio.getText()))
            ||("".equals(txtAldea.getText()))||
            ("".equals(txtDireccion.getText()))||("".equals(txtTelefono.getText()))||("".equals(txtBoleto.getText()))){
            JOptionPane.showMessageDialog(null, "Hacen falta datos, por favor ingreselos");        
        }else{     
            
            final String CLIENTE = "INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?,null,?)";
            PreparedStatement cliente = null;

            try {
                cliente = con.prepareStatement(CLIENTE);            
                cliente.setString(1, txtNumCliente.getText());
                cliente.setString(2, txtNombres.getText());
                cliente.setString(3, txtApellidos.getText());
                cliente.setString(4, txtMunicipio.getText());
                cliente.setString(5, txtDireccion.getText());
                cliente.setString(6, txtTelefono.getText());
                cliente.setString(7, txtDpi.getText());
                cliente.setString(8, txtBoleto.getText());               
                cliente.setString(9, txtAldea.getText());            
                cliente.executeUpdate();
                con.commit();
                JOptionPane.showMessageDialog(null, "Datos Guardados"); 
            } catch (SQLException e) {
                con.rollback();
                JOptionPane.showMessageDialog(null, "Erro al guardar datos");
                e.printStackTrace();
                //Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (cliente != null){
                    cliente.close();
                }
            }
                
        }  
    }
    
    public void eliminarCliente() throws SQLException{
        int fila = tablaClientes.getSelectedRow();
        String valor = tablaClientes.getValueAt(fila, 0).toString();
        if(fila>=0){
            
            final String CLIENTE = "DELETE FROM cliente WHERE idCliente='"+valor+"'";
            PreparedStatement pps = null;
            
            try {
                pps = con.prepareStatement(CLIENTE);
                pps.executeUpdate();
                con.commit();
                JOptionPane.showMessageDialog(null, "Datos Eliminar");                       
            } catch (SQLException ex) {
                con.rollback();
                //Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if(pps != null){
                    pps.close();                
                }
            }         
        }
    }
    
    public void ActualizarCliente() throws SQLException{
        if (("".equals(txtNumCliente.getText()))||("".equals(txtDpi.getText()))||("".equals(txtNombres.getText()))||
            ("".equals(txtApellidos.getText()))||("".equals(txtMunicipio.getText()))
            ||("".equals(txtAldea.getText()))||
            ("".equals(txtDireccion.getText()))||("".equals(txtTelefono.getText()))||("".equals(txtBoleto.getText()))){
            JOptionPane.showMessageDialog(null, "Hacen falta datos, por favor ingreselos");        
        }else{    
            
            final String CLIENTE = "call mydb.ActualizarCliente(?,?,?,?,?,?,?,?,null,?)";
            PreparedStatement cliente = null;    
        
            try {
                cliente = con.prepareStatement(CLIENTE);
                cliente.setString(1, txtNumCliente.getText());
                cliente.setString(2, txtNombres.getText());
                cliente.setString(3, txtApellidos.getText());
                cliente.setString(4, txtMunicipio.getText());
                cliente.setString(5, txtDireccion.getText());
                cliente.setString(6, txtTelefono.getText());
                cliente.setString(7, txtDpi.getText());
                cliente.setString(8, txtBoleto.getText());   
                cliente.setString(9, txtAldea.getText());            
                cliente.executeUpdate();
                con.commit();
                JOptionPane.showMessageDialog(null, "Datos Actualizados"); 
            } catch (SQLException ex) {
                con.rollback();
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if(cliente != null){
                    cliente.close();
                }
            }                
        }
    }
    public int ultimoID(){
        int idC = 0;
        try{        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idCliente) AS id FROM Cliente");
            modeloMCliente = new DefaultTableModel(null, columnas){
            @Override
                public boolean isCellEditable (int fila, int columna) {
                    return false;
                }
            };
            while(rs.next()){
                idC= rs.getInt("id");
            }         
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        } 
        return idC;
    }
}
