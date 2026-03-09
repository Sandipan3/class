import java.util.*;

public class HillCipher_7 {

    // Convert key string to 3x3 matrix
    static int[][] getKeyMatrix(String key) {
        int[][] keyMatrix = new int[3][3];
        key = key.toLowerCase().replaceAll("[^a-z]", "");

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyMatrix[i][j] = key.charAt(k++) - 'a';
            }
        }
        return keyMatrix;
    }

    // Multiply matrix with vector
    static int[] multiplyMatrix(int[][] matrix, int[] vector) {
        int[] result = new int[3];

        for (int i = 0; i < 3; i++) {
            result[i] = 0;
            for (int j = 0; j < 3; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
            result[i] = (result[i] % 26 + 26) % 26;
        }
        return result;
    }

    // Find determinant of 3x3 matrix
    static int determinant(int[][] m) {
        int det = m[0][0] * (m[1][1]*m[2][2] - m[1][2]*m[2][1])
                - m[0][1] * (m[1][0]*m[2][2] - m[1][2]*m[2][0])
                + m[0][2] * (m[1][0]*m[2][1] - m[1][1]*m[2][0]);

        return (det % 26 + 26) % 26;
    }

    // Modular inverse of determinant
    static int modInverse(int det) {
        det = (det % 26 + 26) % 26;
        for (int i = 1; i < 26; i++) {
            if ((det * i) % 26 == 1)
                return i;
        }
        throw new ArithmeticException("Key is not invertible!");
    }

    // Get inverse matrix mod 26
    static int[][] inverseMatrix(int[][] m) {
        int det = determinant(m);
        int invDet = modInverse(det);

        int[][] adj = new int[3][3];

        adj[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]);
        adj[0][1] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        adj[0][2] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]);

        adj[1][0] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]);
        adj[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]);
        adj[1][2] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);

        adj[2][0] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]);
        adj[2][1] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);
        adj[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]);

        // transpose + mod
        int[][] inverse = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverse[i][j] = (adj[j][i] * invDet) % 26;
                inverse[i][j] = (inverse[i][j] + 26) % 26;
            }
        }

        return inverse;
    }

    // Encrypt function
    static String encrypt(String text, int[][] keyMatrix) {
        text = text.toLowerCase().replaceAll("[^a-z]", "");

        while (text.length() % 3 != 0) {
            text += 'x';
        }

        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < text.length(); i += 3) {
            int[] vector = {
                    text.charAt(i) - 'a',
                    text.charAt(i+1) - 'a',
                    text.charAt(i+2) - 'a'
            };

            int[] result = multiplyMatrix(keyMatrix, vector);

            for (int val : result) {
                cipher.append((char)(val + 'a'));
            }
        }

        return cipher.toString();
    }

    // Decrypt function
    static String decrypt(String cipher, int[][] keyMatrix) {
        int[][] inverse = inverseMatrix(keyMatrix);

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < cipher.length(); i += 3) {
            int[] vector = {
                    cipher.charAt(i) - 'a',
                    cipher.charAt(i+1) - 'a',
                    cipher.charAt(i+2) - 'a'
            };

            int[] result = multiplyMatrix(inverse, vector);

            for (int val : result) {
                text.append((char)(val + 'a'));
            }
        }

        return text.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the key: ");
        String key = sc.nextLine();

        System.out.println("Enter the message: ");
        String message = sc.nextLine();

        int[][] keyMatrix = getKeyMatrix(key);

        String encrypted = encrypt(message, keyMatrix);
        String decrypted = decrypt(encrypted, keyMatrix);

        System.out.println("Original Message : " + message);
        System.out.println("Encrypted Message: " + encrypted);
        System.out.println("Decrypted Message: " + decrypted);
    }
}
