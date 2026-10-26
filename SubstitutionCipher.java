import java.util.Scanner;

public class SubstitutionCipher {

    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String key       = "QWERTYUIOPASDFGHJKLZXCVBNM";

    public static String encrypt(String text) {
        String result = "";

        for (char ch : text.toUpperCase().toCharArray()) {
            int index = alphabet.indexOf(ch);

            if (index != -1)
                result += key.charAt(index);
            else
                result += ch;
        }

        return result;
    }

    public static String decrypt(String text) {
        String result = "";

        for (char ch : text.toUpperCase().toCharArray()) {
            int index = key.indexOf(ch);

            if (index != -1)
                result += alphabet.charAt(index);
            else
                result += ch;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String message = sc.nextLine();

        String encrypted = encrypt(message);
        String decrypted = decrypt(encrypted);

        System.out.println("Original Text: " + message);
        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}

// Example Output
// Enter the message: HELLO
// Original Text: HELLO
// Encrypted Text: ITSSG
// Decrypted Text: HELLO