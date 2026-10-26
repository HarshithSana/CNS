import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class Rijndael {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String message = sc.nextLine();

        // Generate AES key
        KeyGenerator keyGenerator =
                KeyGenerator.getInstance("AES");

        keyGenerator.init(128);

        SecretKey key = keyGenerator.generateKey();

        // Create AES cipher
        Cipher cipher = Cipher.getInstance("AES");

        // Encryption
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted =
                cipher.doFinal(message.getBytes());

        String encryptedText =
                Base64.getEncoder().encodeToString(encrypted);

        System.out.println("Original Text: " + message);
        System.out.println("Encrypted Text: " + encryptedText);

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decrypted =
                cipher.doFinal(encrypted);

        System.out.println("Decrypted Text: " +
                new String(decrypted));

        sc.close();
    }
}