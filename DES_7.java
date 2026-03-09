import javax.crypto.*;
import javax.crypto.spec.*;

public class DES_7 {

    static byte[] encrypt(String msg, String key) throws Exception {
        Cipher c = Cipher.getInstance("DES");
        SecretKeySpec k = new SecretKeySpec(key.getBytes(), "DES");
        c.init(Cipher.ENCRYPT_MODE, k);
        return c.doFinal(msg.getBytes());
    }

    static String decrypt(byte[] data, String key) throws Exception {
        Cipher c = Cipher.getInstance("DES");
        SecretKeySpec k = new SecretKeySpec(key.getBytes(), "DES");
        c.init(Cipher.DECRYPT_MODE, k);
        return new String(c.doFinal(data));
    }

    public static void main(String[] args) throws Exception {

        String text = "Hello";
        String key = "12345678";

        byte[] enc = encrypt(text, key);
        System.out.println("Encrypted: " + enc);

        String dec = decrypt(enc, key);
        System.out.println("Decrypted: " + dec);
    }
}