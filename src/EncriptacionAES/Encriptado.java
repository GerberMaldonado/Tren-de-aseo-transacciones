package encriptacionaes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

public class Encriptado {
    //Algoritmo AES con Cifrado por bloques CBC de 128 bits
    // Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
    private final static String alg = "AES";
    // Definición del modo de cifrado a utilizar
    private final static String cI = "AES/CBC/PKCS5Padding";
 
    /**
     * Función de tipo String que recibe una llave (key), un vector de inicialización (iv)
     * y el texto que se desea cifrar
     * @param llave la llave en tipo String a utilizar
     * @param vi el vector de inicialización a utilizar
     * @param texto el texto sin cifrar a encriptar
     * @return el texto cifrado en modo String
     * @throws Exception puede devolver excepciones de los siguientes tipos: NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException
     */
    public static String encripta(String llave, String vi, String texto) throws Exception {
            Cipher cifrar = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(llave.getBytes(), alg);
            IvParameterSpec viParameterSpec = new IvParameterSpec(vi.getBytes());
            cifrar.init(Cipher.ENCRYPT_MODE, skeySpec, viParameterSpec);
            byte[] encriptado = cifrar.doFinal(texto.getBytes());
            return new String(encodeBase64(encriptado));
    }
 
    /**
     * Función de tipo String que recibe una llave (key), un vector de inicialización (iv)
     * y el texto que se desea descifrar
     * @param llave la llave en tipo String a utilizar
     * @param vi el vector de inicialización a utilizar
     * @param encriptado el texto cifrado en modo String
     * @return el texto desencriptado en modo String
     * @throws Exception puede devolver excepciones de los siguientes tipos: NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException
     */
    public static String desencripta(String llave, String vi, String encriptado) throws Exception {
            Cipher cifrar = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(llave.getBytes(), alg);
            IvParameterSpec viParameterSpec = new IvParameterSpec(vi.getBytes());
            byte[] enc = decodeBase64(encriptado);
            cifrar.init(Cipher.DECRYPT_MODE, skeySpec, viParameterSpec);
            byte[] desencriptado = cifrar.doFinal(enc);
            return new String(desencriptado);
    }
}
