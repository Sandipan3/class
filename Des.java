import java.util.*;

public class SimpleDES {

    // Initial Permutation table
    static int[] IP = {
        58,50,42,34,26,18,10,2,
        60,52,44,36,28,20,12,4,
        62,54,46,38,30,22,14,6,
        64,56,48,40,32,24,16,8,
        57,49,41,33,25,17,9,1,
        59,51,43,35,27,19,11,3,
        61,53,45,37,29,21,13,5,
        63,55,47,39,31,23,15,7
    };

    // Final Permutation
    static int[] FP = {
        40,8,48,16,56,24,64,32,
        39,7,47,15,55,23,63,31,
        38,6,46,14,54,22,62,30,
        37,5,45,13,53,21,61,29,
        36,4,44,12,52,20,60,28,
        35,3,43,11,51,19,59,27,
        34,2,42,10,50,18,58,26,
        33,1,41,9,49,17,57,25
    };

    // Simple permutation function
    static String permute(String input, int[] table) {
        StringBuilder output = new StringBuilder();
        for(int i : table) {
            output.append(input.charAt(i-1));
        }
        return output.toString();
    }

    // XOR operation
    static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for(int i=0;i<a.length();i++) {
            result.append(a.charAt(i) == b.charAt(i) ? "0" : "1");
        }
        return result.toString();
    }

    // Simple round function (simplified for lab)
    static String roundFunction(String right, String key) {
        return xor(right, key.substring(0, right.length()));
    }

    public static String encrypt(String plaintext, String key) {

        // Initial permutation
        String permuted = permute(plaintext, IP);

        String left = permuted.substring(0,32);
        String right = permuted.substring(32);

        // 16 rounds
        for(int i=0;i<16;i++) {

            String temp = right;

            String f = roundFunction(right, key);

            right = xor(left, f);

            left = temp;
        }

        String combined = right + left;

        // Final permutation
        return permute(combined, FP);
    }

    public static void main(String[] args) {

        String plaintext =
        "0001001000110100010101100111100010011010101111001101111011110001";

        String key =
        "0001001100110100010101110111100110011011101111001101111111110001";

        String ciphertext = encrypt(plaintext, key);

        System.out.println("Ciphertext: " + ciphertext);
    }
}
