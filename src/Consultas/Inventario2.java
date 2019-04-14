package Consultas;

import ConexionBaseDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventario2 {
    DefaultTableModel mInv;
    Connection con = null;
    Object datos[];
    String columnas[];
    public Inventario2(){
        con = Conexion.ConnecrDb();
    }
    
    public DefaultTableModel verInventario(){//Método para enviar la lista de clientes
        int nC = 0;
        try{        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT *FROM producto order by Tipo;");
            ResultSetMetaData rsMeta=rs.getMetaData();
            nC=rsMeta.getColumnCount();
            datos = new Object[nC];//Número de columnas para rellenar las filas
            columnas = new String[nC];
            for(int i=1; i<=nC; i++){
                columnas[i-1]=rsMeta.getColumnName(i);
            }
            columnas[0] = "No.";
            columnas[2] = "Descripción";
            mInv = new DefaultTableModel(null, columnas){
            @Override
                public boolean isCellEditable (int fila, int columna) {
                    return false;
                }
            };
            while(rs.next()){
                for(int i=0; i<nC; i++){
                    datos[i] = rs.getObject(i+1);
                }
                mInv.addRow(datos);
            }         
            rs.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        }  
        return mInv;
    }
    public void agregarInv(String id, String tipo, String descrip, String exis){
        try{        
            PreparedStatement inv = con.prepareStatement("INSERT INTO Producto VALUES(?,?,?,?)");
            inv.setString(1, id);
            inv.setString(2, tipo);
            inv.setString(3, descrip);
            inv.setString(4, exis);
            JOptionPane.showMessageDialog(null, "Datos Guardados");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        } 
    }
    
    public int ultimoID(){
        int idProd = 0;
        try{        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idProducto) AS id FROM Producto");
            mInv = new DefaultTableModel(null, columnas){
            @Override
                public boolean isCellEditable (int fila, int columna) {
                    return false;
                }
            };
            while(rs.next()){
                idProd = rs.getInt("id");
            }         
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        } 
        return idProd;
    }
}
