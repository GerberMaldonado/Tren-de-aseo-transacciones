package Consultas;

import ConexionBaseDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Pagos {
    Connection con = null;
    public Pagos() throws SQLException{
        con = Conexion.ConnecrDb();
        
    }
    public float mensual(){
        float men=0;
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Monto FROM TipoPago WHERE Tipo='Mensualidad'");
            if(rs.next()){
                men = rs.getFloat("Monto");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return men;
    }
    public float inscripcion(){
        float insc=0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Monto FROM TipoPago WHERE Tipo='Inscripcion'");
            if(rs.next()){
                insc = rs.getFloat("Monto");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return insc;
    }
    
    public boolean pagoCorriente(String cliente){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Monto FROM TipoPago WHERE Tipo='Inscripcion'");
            if(rs.next()){
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return true;
    }
    
    public int idCli(String dpi){
        int id=0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCliente FROM mydb.cliente WHERE CUI='"+dpi+"'");
            if(rs.next()){
                id = rs.getInt("idCliente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return id;
    }
    
    public void pagarIns(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10) throws SQLException{
        
        
        int num = numPago_total();
        con.setAutoCommit(false);
        float cant = cantidad();
                
        final String PAGO = "INSERT INTO mydb.pago VALUES(?,?,?,?,?,?,?,?,?,?)"; 
        final String TOTAL_PAGO = "INSERT INTO mydb.total_pago VALUES(?,?,?)";
        PreparedStatement inv = null, pag = null;        
        
        try{        
            inv = con.prepareStatement(PAGO);
            inv.setString(1, s1);
            inv.setString(2, s2);
            inv.setString(3, s3);
            inv.setString(4, s4);
            inv.setString(5, s5);
            inv.setString(6, s6);
            inv.setString(7, s7);
            inv.setString(8, s8);
            inv.setString(9, s9);
            inv.setString(10, s10);
            inv.executeUpdate();
            
            pag = con.prepareStatement(TOTAL_PAGO);
            pag.setInt(1, num);
            pag.setFloat(2, cant);
            pag.setString(3, "Sumatoria");
            pag.executeUpdate();
            
            con.commit();
            JOptionPane.showMessageDialog(null, "Datos Guardados");
                                   
        }catch(SQLException e){
            con.rollback();
            JOptionPane.showMessageDialog(null, e);      
        } finally{
            if(inv != null){
                inv.close();
            }
            if(pag != null){
                pag.close();
            }
        }
    }
    
    public int numPago(){
        int nPago = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idPago) AS id FROM Pago");
            while(rs.next()){
                nPago = rs.getInt("id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        if(nPago==0){
            nPago=1;
        }else{
            nPago+=1;
        }
        return nPago;
    }
    
    public int numPago_total(){
        int nPago = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idtotal_pago) AS id FROM total_pago");
            while(rs.next()){
                nPago = rs.getInt("id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        if(nPago==0){
            nPago=1;
        }else{
            nPago+=1;
        }
        return nPago;
    }
        
    public float cantidad(){
        int cantidad = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(cantidad) AS cant FROM total_pago");
            while(rs.next()){
                cantidad = rs.getInt("cant");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        if(cantidad==0){
            JOptionPane.showMessageDialog(null, "No hay datos");
            cantidad+=25;
        }else{
            cantidad+=25;
        }
        return cantidad;
    }
}
