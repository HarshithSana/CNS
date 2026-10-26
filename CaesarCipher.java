import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + key) % 26 + 'A');
            } 
            else if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + key) % 26 + 'a');
            }

            result.append(ch);
        }

        return result.toString();
    }

    public static String decrypt(String text, int key) {
        return encrypt(text, 26 - key);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String message = sc.nextLine();

        System.out.print("Enter the key: ");
        int key = sc.nextInt();

        String encrypted = encrypt(message, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Original Text: " + message);
        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}

// Example Output
// Enter the message: HELLO
// Enter the key: 3
// Original Text: HELLO
// Encrypted Text: KHOOR
// Decrypted Text: HELLO