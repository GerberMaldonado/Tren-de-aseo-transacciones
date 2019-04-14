package Interfaz;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RedimensionarImg {
    public void escalarImagen(JButton btn, ImageIcon img){
        //se recibe la imagen en un Image
        Image imagen = img.getImage();
        //ahora se realiza la parte principal de este video que es adaptar el tamaño de la imagen a nuestro label
        Image nuevaimagen = imagen.getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH);
        //finalmente le adicinamos la imagen dentro del label
        btn.setIcon(new ImageIcon(nuevaimagen));
    }
    
    //Funcion para escalar imagen reduciendo un 5%
    public void escalarImagen2(JButton btn, ImageIcon img){
        //se recibe la imagen en un Image
        Image imagen = img.getImage();
        int ancho = btn.getWidth();
        int alto = btn.getHeight();
        ancho = (ancho*95)/100;
        alto = (alto*95)/100;
        //ahora se realiza la parte principal de este video que es adaptar el tamaño de la imagen a nuestro label
        Image nuevaimagen = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        //finalmente le adicinamos la imagen dentro del label
        btn.setIcon(new ImageIcon(nuevaimagen));
    }
}
