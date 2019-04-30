package ConexionBaseDatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Conexion {      
    private Connection con;
    private String error = "NO";   
    
    public Connection getConn() {
        return con;
    }

    public void setConn(Connection conn) {
        this.con = conn;
    }
    
    public static Connection ConnecrDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useSSL=false", "root", "root");
            return con;
        } catch (ClassNotFoundException | SQLException ex){        
            JOptionPane.showMessageDialog(null, "No se conecto");
            return null;        
        }
    }  
    
    public final void ConnecrDb1(String cad, String u, String p) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://" + cad, u, p);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error de Coneccion " + ex.getLocalizedMessage()+"\nError Nro : "+ex.getErrorCode());
        }
    }
    public void DesConectar() {
        this.con = null;
    }
    public String getError() {
        return error;
    }
    public Connection getConexion() {
        return con;
    }
}
