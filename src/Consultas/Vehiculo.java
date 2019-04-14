package Consultas;

import ConexionBaseDatos.Conexion;
import static Interfaz.Vehiculos.tblVehiculos;
import static Interfaz.Vehiculos.txtCapacidad;
import static Interfaz.Vehiculos.txtCilindros;
import static Interfaz.Vehiculos.txtColor;
import static Interfaz.Vehiculos.txtConductor;
import static Interfaz.Vehiculos.txtMarca;
import static Interfaz.Vehiculos.txtModelo;
import static Interfaz.Vehiculos.txtMotor;
import static Interfaz.Vehiculos.txtNumVehiculo;
import static Interfaz.Vehiculos.txtPlaca;

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

public class Vehiculo {
    DefaultTableModel modeloVehiculo;
    Connection con = null;
    Object datos[];
    String columnas[];
    
    public Vehiculo(){
        con = Conexion.ConnecrDb();
    }
    
    public DefaultTableModel verVehiculos(){//Método para enviar la lista de vehiculos
        int nC = 0;
        try{        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idVehiculo, Marca, Modelo, Color, Cilindros, Motor, Num_Placa, Capacidad, e.Nombres, e.Apellidos, e.Edad FROM Vehiculo v INNER JOIN Empleado e ON v.Conductor_ID = e.idEmpleado ORDER BY idVehiculo ASC;");
            ResultSetMetaData rsMeta=rs.getMetaData();
            nC=rsMeta.getColumnCount();
            datos = new Object[nC];//Número de columnas para rellenar las filas
            columnas = new String[nC];
            for(int i=1; i<=nC; i++){
                columnas[i-1]=rsMeta.getColumnName(i);
            }
            columnas[0] = "ID";
            columnas[6] = "Placa";
            modeloVehiculo = new DefaultTableModel(null, columnas){
            @Override
                public boolean isCellEditable (int fila, int columna) {
                    return false;
                }
            };
            while(rs.next()){
                for(int i=0; i<nC; i++){
                    datos[i] = rs.getObject(i+1);
                }
                modeloVehiculo.addRow(datos);
            }         
            rs.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        }  
        return modeloVehiculo;
    }
    
 
    public void insertarVehiculo(){            
        if (("".equals(txtNumVehiculo.getText()))||("".equals(txtMarca.getText()))||("".equals(txtModelo.getText()))||
            ("".equals(txtColor.getText()))||("".equals(txtCilindros.getText()))
            ||("".equals(txtMotor.getText()))||("".equals(txtPlaca.getText()))
            ||("".equals(txtCapacidad.getText()))||("".equals(txtConductor.getText()))){
            JOptionPane.showMessageDialog(null, "Hacen falta datos, por favor ingreselos");        
        }else{     
        try {
            PreparedStatement cliente = con.prepareStatement("call mydb.InsertarVehiculo(?,?,?,?,?,?,?,?,?)");
            cliente.setString(1, txtNumVehiculo.getText());
            cliente.setString(2, txtMarca.getText());
            cliente.setString(3, txtModelo.getText());
            cliente.setString(4, txtColor.getText());
            cliente.setString(5, txtCilindros.getText());
            cliente.setString(6, txtMotor.getText());
            cliente.setString(7, txtPlaca.getText());
            cliente.setString(8, txtCapacidad.getText());               
            cliente.setString(9, txtConductor.getText());            
            cliente.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Guardados"); 
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        }  
    }      
    public void actualizarVehiculo(){            
        if (("".equals(txtNumVehiculo.getText()))||("".equals(txtMarca.getText()))||("".equals(txtModelo.getText()))||
            ("".equals(txtColor.getText()))||("".equals(txtCilindros.getText()))
            ||("".equals(txtMotor.getText()))||("".equals(txtPlaca.getText()))
            ||("".equals(txtCapacidad.getText()))||("".equals(txtConductor.getText()))){
            JOptionPane.showMessageDialog(null, "Hacen falta datos, por favor ingreselos");        
        }else{     
        try {
            PreparedStatement cliente = con.prepareStatement("call mydb.ActualizarVehiculo(?,?,?,?,?,?,?,?,?)");
            cliente.setString(1, txtNumVehiculo.getText());
            cliente.setString(2, txtMarca.getText());
            cliente.setString(3, txtModelo.getText());
            cliente.setString(4, txtColor.getText());
            cliente.setString(5, txtCilindros.getText());
            cliente.setString(6, txtMotor.getText());
            cliente.setString(7, txtPlaca.getText());
            cliente.setString(8, txtCapacidad.getText());               
            cliente.setString(9, txtConductor.getText());            
            cliente.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Guardados"); 
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        }  
    }    
    
    public void eliminarVehiculo(){
        int fila = tblVehiculos.getSelectedRow();
        String valor = tblVehiculos.getValueAt(fila, 0).toString();
        if(fila>=0){
            try {
                PreparedStatement pps = con.prepareStatement("DELETE FROM vehiculo WHERE idVehiculo='"+valor+"'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Eliminar");                       
            } catch (SQLException ex) {
                Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }             
        }
    }
    
    public int numVehiculo(){
        int nV = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idVehiculo) AS id FROM Vehiculo");
            while(rs.next()){
                nV = rs.getInt("id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        if(nV==0){
            nV=1;
        }else{
            nV+=1;
        }
        return nV;
    }

}
