package Consultas;

import ConexionBaseDatos.Conexion;
import static Interfaz.Empleados.tblEmpleados;

import static Interfaz.Empleados.txtNumEmp;
import static Interfaz.Empleados.txtApellidos;
import static Interfaz.Empleados.txtCargo;
import static Interfaz.Empleados.txtDir;
import static Interfaz.Empleados.txtEdad;
import static Interfaz.Empleados.txtDpi;
import static Interfaz.Empleados.txtNombres;
import static Interfaz.Empleados.txtGen;
import static Interfaz.Empleados.txtTel;
import static Interfaz.Empleados.txtFecha;
import static Interfaz.Empleados.txtNit;

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

public class Empleado {
    DefaultTableModel modeloEmp;
    Connection con = null;
    Object datos[];
    String columnas[];
    public Empleado(){
        con = Conexion.ConnecrDb();
    }
    public DefaultTableModel verEmpleados(){//Método para enviar la lista de clientes
        int nC = 0;
        try{        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idEmpleado, Nombres, Apellidos, Direccion, Telefono, CUI, NIT, FechaNac, Edad, Genero, Cargo FROM Empleado INNER JOIN Cargo ON Empleado.Cargo_idCargo = Cargo.idCargo;");
            ResultSetMetaData rsMeta=rs.getMetaData();
            nC=rsMeta.getColumnCount();
            datos = new Object[nC];//Número de columnas para rellenar las filas
            columnas = new String[nC];
            for(int i=1; i<=nC; i++){
                columnas[i-1]=rsMeta.getColumnName(i);
            }
            columnas[0] = "No.";
            columnas[3] = "Dirección";
            columnas[4] = "Teléfono";            
            columnas[7] = "F. Nacimiento";
            columnas[9] = "Género";
            modeloEmp = new DefaultTableModel(null, columnas){
            @Override
                public boolean isCellEditable (int fila, int columna) {
                    return false;
                }
            };
            while(rs.next()){
                for(int i=0; i<nC; i++){
                    datos[i] = rs.getObject(i+1);
                }
                modeloEmp.addRow(datos);
            }         
            rs.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        }  
        return modeloEmp;
    }
    public void limpiarTabla(){
        while (modeloEmp.getRowCount() > 0){
            modeloEmp.removeRow(0);
        }
    }
    
    public void insertarEmpleado(){            
        if (("".equals(txtNumEmp.getText()))||("".equals(txtDpi.getText()))||("".equals(txtNombres.getText()))||
            ("".equals(txtApellidos.getText()))||("".equals(txtGen.getText()))||("".equals(txtCargo.getText()))||            
            ("".equals(txtDir.getText()))||("".equals(txtTel.getText()))||("".equals(txtEdad.getText()))
            ||("".equals(txtFecha.getText()))||("".equals(txtNit.getText()))    ){
            JOptionPane.showMessageDialog(null, "Hacen falta datos, por favor ingreselos");        
        }else{     
        try {
            PreparedStatement empleado = con.prepareStatement("call mydb.InsertarEmpleado(?,?,?,?,?,?,?,?,?,?,?)");
            empleado.setString(1, txtNumEmp.getText());
            empleado.setString(2, txtNombres.getText());
            empleado.setString(3, txtApellidos.getText());
            empleado.setString(4, txtDir.getText());
            empleado.setString(5, txtTel.getText());
            empleado.setString(6, txtDpi.getText());
            empleado.setString(7, txtNit.getText());
            empleado.setString(8, txtFecha.getText());               
            empleado.setString(9, txtEdad.getText());
            empleado.setString(10, txtGen.getText());            
            empleado.setString(11, txtCargo.getText());
            empleado.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Guardados"); 
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        }  
    }
    
    public void eliminarEmpleados(){
        int fila = tblEmpleados.getSelectedRow();
        String valor = tblEmpleados.getValueAt(fila, 0).toString();
        if(fila>=0){
            try {
                PreparedStatement pps = con.prepareStatement("DELETE FROM empleado WHERE idEmpleado='"+valor+"'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Eliminar");                       
            } catch (SQLException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }             
        }
    }
    
    public void ActualizarCliente(){
        if (("".equals(txtNumEmp.getText()))||("".equals(txtDpi.getText()))||("".equals(txtNombres.getText()))||
            ("".equals(txtApellidos.getText()))||("".equals(txtGen.getText()))||("".equals(txtCargo.getText()))||            
            ("".equals(txtDir.getText()))||("".equals(txtTel.getText()))||("".equals(txtEdad.getText()))
            ||("".equals(txtFecha.getText()))||("".equals(txtNit.getText()))    ){
            JOptionPane.showMessageDialog(null, "Hacen falta datos, por favor ingreselos");        
        }else{     
        try {
            PreparedStatement empleado = con.prepareStatement("call mydb.ActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?)");
            empleado.setString(1, txtNumEmp.getText());
            empleado.setString(2, txtNombres.getText());
            empleado.setString(3, txtApellidos.getText());
            empleado.setString(4, txtDir.getText());
            empleado.setString(5, txtTel.getText());
            empleado.setString(6, txtDpi.getText());
            empleado.setString(7, txtNit.getText());
            empleado.setString(8, txtFecha.getText());               
            empleado.setString(9, txtEdad.getText());
            empleado.setString(10, txtGen.getText());            
            empleado.setString(11, txtCargo.getText());
            empleado.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados"); 
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public int ultimoID(){
        int idE = 0;
        try{        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idEmpleado) AS id FROM Empleado");
            modeloEmp = new DefaultTableModel(null, columnas){
            @Override
                public boolean isCellEditable (int fila, int columna) {
                    return false;
                }
            };
            while(rs.next()){
                idE= rs.getInt("id");
            }         
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        } 
        return idE;
    }
}
