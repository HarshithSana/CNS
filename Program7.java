import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Program7{

    public static void main(String[] args) throws Exception {

        // Create your own key
        String key = "MySecretKey";

        // Text to encrypt
        String text = "Hello world";

        // Create secret key
        SecretKeySpec secretKey =
                new SecretKeySpec(key.getBytes(), "Blowfish");

        // Create Blowfish cipher
        Cipher cipher = Cipher.getInstance("Blowfish");

        // Encryption
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(text.getBytes());

        String encryptedText =
                Base64.getEncoder().encodeToString(encryptedBytes);

        System.out.println("Original Text: " + text);
        System.out.println("Key: " + key);
        System.out.println("Encrypted Text: " + encryptedText);
    }
}