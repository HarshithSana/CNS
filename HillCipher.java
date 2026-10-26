import java.util.Scanner;

public class HillCipher {

    static int[][] key = {
        {3, 3},
        {2, 5}
    };

    // Encryption
    static String encrypt(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");

        if (text.length() % 2 != 0)
            text += "X";

        String result = "";

        for (int i = 0; i < text.length(); i += 2) {
            int a = text.charAt(i) - 'A';
            int b = text.charAt(i + 1) - 'A';

            int x = (key[0][0] * a + key[0][1] * b) % 26;
            int y = (key[1][0] * a + key[1][1] * b) % 26;

            result += (char) (x + 'A');
            result += (char) (y + 'A');
        }

        return result;
    }

    // Decryption
    static String decrypt(String text) {
        int a = key[0][0];
        int b = key[0][1];
        int c = key[1][0];
        int d = key[1][1];

        int determinant = (a * d - b * c) % 26;

        if (determinant < 0)
            determinant += 26;

        int inverseDet = 0;

        for (int i = 1; i < 26; i++) {
            if ((determinant * i) % 26 == 1) {
                inverseDet = i;
                break;
            }
        }

        int[][] inverseKey = {
            {(d * inverseDet) % 26, (-b * inverseDet + 26) % 26},
            {(-c * inverseDet + 26) % 26, (a * inverseDet) % 26}
        };

        String result = "";

        for (int i = 0; i < text.length(); i += 2) {
            int x = text.charAt(i) - 'A';
            int y = text.charAt(i + 1) - 'A';

            int p = (inverseKey[0][0] * x +
                     inverseKey[0][1] * y) % 26;

            int q = (inverseKey[1][0] * x +
                     inverseKey[1][1] * y) % 26;

            result += (char) (p + 'A');
            result += (char) (q + 'A');
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
// Enter the message: HELP
// Original Text: HELP
// Encrypted Text: HIAT
// Decrypted Text: HELP