package Interfaz;

import java.awt.Color;
import ConexionBaseDatos.Conexion;
import com.sun.awt.AWTUtilities;
import com.sun.glass.events.KeyEvent;
import encriptacionaes.Encriptado;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    int x,y;
    int xx;
    int xy;
    String ID;
    String pass=null, passDesenc=null;
    int IntID;
    String usuario;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Principal pantalla;
    String PASS_CRYPTO;
    String llave = "92AE31A79FEEB2A3"; //llave
    String vi = "0123456789ABCDEF"; // vector de inicialización
    
    public Login() {     
        initComponents();
        iniciar();
        //updateEnc();
    }

    private void iniciar(){
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        AWTUtilities.setWindowShape(this, forma);
        con = Conexion.ConnecrDb();
        this.txtUsuario.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblOlvidar = new javax.swing.JLabel();
        lblImgUser = new javax.swing.JLabel();
        lblImgContra = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblContra = new javax.swing.JLabel();
        txtContra = new javax.swing.JPasswordField();
        panelLogo = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingreso");
        setName("FrameLogin"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        panelFondo.setBackground(new java.awt.Color(48, 57, 74));
        panelFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        panelFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelFondoMouseDragged(evt);
            }
        });
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContenido.setBackground(new java.awt.Color(48, 57, 74));

        txtUsuario.setBackground(new java.awt.Color(48, 57, 74));
        txtUsuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setBorder(null);
        txtUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUsuario.setSelectionColor(new java.awt.Color(48, 134, 149));
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario");

        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/02.icono_entrar_off.png"))); // NOI18N
        btnEntrar.setBorder(null);
        btnEntrar.setBorderPainted(false);
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/02.icono_entrar_on.png"))); // NOI18N
        btnEntrar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/02.icono_entrar_on.png"))); // NOI18N
        btnEntrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/02.icono_entrar_on.png"))); // NOI18N
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        lblOlvidar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblOlvidar.setForeground(new java.awt.Color(255, 255, 255));
        lblOlvidar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOlvidar.setText("Olvidó su usuario?");
        lblOlvidar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOlvidarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOlvidarMouseExited(evt);
            }
        });

        lblImgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/03.icono_usuario2.png"))); // NOI18N

        lblImgContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/04.icono_contra.png"))); // NOI18N

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        lblContra.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblContra.setForeground(new java.awt.Color(255, 255, 255));
        lblContra.setText("Contraseña");

        txtContra.setBackground(new java.awt.Color(48, 57, 74));
        txtContra.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtContra.setForeground(new java.awt.Color(255, 255, 255));
        txtContra.setBorder(null);
        txtContra.setCaretColor(new java.awt.Color(255, 255, 255));
        txtContra.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtContra.setSelectionColor(new java.awt.Color(48, 134, 149));
        txtContra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraFocusLost(evt);
            }
        });
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelContenidoLayout = new javax.swing.GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenidoLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario)
                            .addGroup(panelContenidoLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblImgUser)
                                .addGap(18, 18, 18)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContra)
                            .addGroup(panelContenidoLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblImgContra)
                                .addGap(18, 18, 18)
                                .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelContenidoLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(lblOlvidar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelContenidoLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnEntrar)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenidoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblUsuario)
                .addGap(12, 12, 12)
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgUser)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblContra)
                .addGap(6, 6, 6)
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgContra)
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblOlvidar)
                .addGap(34, 34, 34)
                .addComponent(btnEntrar)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelFondo.add(panelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 127, -1, -1));

        panelLogo.setBackground(new java.awt.Color(48, 57, 74));
        panelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelLogoMousePressed(evt);
            }
        });

        lblUser.setBackground(new java.awt.Color(48, 57, 74));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/01.icono_usuario2.png"))); // NOI18N
        lblUser.setToolTipText("");
        lblUser.setOpaque(true);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCerrarLogin.png"))); // NOI18N
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCerrarLogin2.png"))); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(84, 84, 84)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelFondo.add(panelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 342, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblOlvidarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOlvidarMouseEntered
        this.lblOlvidar.setForeground(new Color(197,109,45));
    }//GEN-LAST:event_lblOlvidarMouseEntered

    private void lblOlvidarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOlvidarMouseExited
        this.lblOlvidar.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_lblOlvidarMouseExited

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        char tecla = evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            this.btnEntrar.doClick();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
        char tecla = evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
            this.btnEntrar.doClick();
        }
    }//GEN-LAST:event_txtContraKeyTyped

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        ingresarDatos();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        this.txtUsuario.setBackground(new Color(58, 68, 85));
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        this.txtUsuario.setBackground(new Color(48,57,74));
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtContraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraFocusGained
        this.txtContra.setBackground(new Color(58, 68, 85));
    }//GEN-LAST:event_txtContraFocusGained

    private void txtContraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraFocusLost
        this.txtContra.setBackground(new Color(48,57,74));
    }//GEN-LAST:event_txtContraFocusLost

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void panelLogoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLogoMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_panelLogoMousePressed

    private void panelFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFondoMouseDragged
        int x1 = evt.getXOnScreen();
        int y1 = evt.getYOnScreen();
        
        this.setLocation(x1 - xx, y1 - xy);
    }//GEN-LAST:event_panelFondoMouseDragged
   
    private void ingresarDatos(){
        String sql ="SELECT *FROM Usuario WHERE Usuario = ? AND Contraseña = ?";
        try{        
            pst = con.prepareStatement(sql);
            pst.setString(1, txtUsuario.getText());
            pst.setString(2, Encriptado.encripta(llave, vi, txtContra.getText()));            
            rs=pst.executeQuery();           
            if (rs.next()){
                ID = rs.getString("idUsuario");
                IntID = Integer.parseInt(ID);
                usuario = rs.getString("Usuario");
                pass = rs.getString("Contraseña");
                passDesenc = Encriptado.desencripta(llave, vi,pass);
                JOptionPane.showMessageDialog(null, "Usuario y contraseña correctos");
                pantalla = new Principal(usuario);
                pantalla.setLocationRelativeTo(null);
                pantalla.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos");
                this.txtUsuario.setText("");
                this.txtContra.setText("");
                this.txtUsuario.requestFocus();
            }
            rs.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);      
        }     
    }
    
    private void updateEnc(){
        String passw= null;
        try{        
            PreparedStatement pst2 = con.prepareStatement("SELECT Contraseña FROM Usuario WHERE idUsuario = "+1);
            ResultSet rs2=pst2.executeQuery();         
            if (rs2.next()){
                passw = rs2.getString("Contraseña");
            }
            rs2.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);      
        }     
        try {//Encriptar contraseña
            passw = Encriptado.encripta(llave, vi, passw);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try{//Actualizar contraseña
            PreparedStatement pst3 = con.prepareStatement("UPDATE Usuario SET Contraseña = '"+passw+"' WHERE idUsuario = "+1);
            pst3.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblContra;
    private javax.swing.JLabel lblImgContra;
    private javax.swing.JLabel lblImgUser;
    private javax.swing.JLabel lblOlvidar;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
