import java.util.Scanner;

public class RailFenceCipher_7 {

    // Encryption
    public static String encrypt(String text, int key) {

        text = text.replaceAll("\\s+", ""); // remove spaces
        boolean directionDown = false;

        char[][] rail = new char[key][text.length()];

        // fill matrix with newline
        for (int i = 0; i < key; i++)
            for (int j = 0; j < text.length(); j++)
                rail[i][j] = '\n';

        int row = 0, col = 0;

        for (int i = 0; i < text.length(); i++) {

            if (row == 0 || row == key - 1)
                directionDown = !directionDown;

            rail[row][col++] = text.charAt(i);

            row += directionDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < key; i++)
            for (int j = 0; j < text.length(); j++)
                if (rail[i][j] != '\n')
                    result.append(rail[i][j]);

        return result.toString();
    }

    // Decryption
    public static String decrypt(String cipher, int key) {

        boolean directionDown = false;
        char[][] rail = new char[key][cipher.length()];

        // mark zig-zag pattern
        for (int i = 0; i < key; i++)
            for (int j = 0; j < cipher.length(); j++)
                rail[i][j] = '\n';

        int row = 0, col = 0;

        for (int i = 0; i < cipher.length(); i++) {

            if (row == 0 || row == key - 1)
                directionDown = !directionDown;

            rail[row][col++] = '*';

            row += directionDown ? 1 : -1;
        }

        // fill cipher text
        int index = 0;
        for (int i = 0; i < key; i++)
            for (int j = 0; j < cipher.length(); j++)
                if (rail[i][j] == '*' && index < cipher.length())
                    rail[i][j] = cipher.charAt(index++);

        // read zig-zag
        StringBuilder result = new StringBuilder();

        row = 0;
        col = 0;
        directionDown = false;

        for (int i = 0; i < cipher.length(); i++) {

            if (row == 0 || row == key - 1)
                directionDown = !directionDown;

            result.append(rail[row][col++]);

            row += directionDown ? 1 : -1;
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the message: ");
        String message = sc.nextLine();
        System.out.println("Enter the key: ");
        int key = sc.nextInt();


        String encrypted = encrypt(message, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Original Message : " + message);
        System.out.println("Encrypted Message: " + encrypted);
        System.out.println("Decrypted Message: " + decrypted);
    }
}
