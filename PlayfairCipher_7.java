import java.util.*;

public class PlayfairCipher_7 {

    static Map<Character, Integer> charToPos = new HashMap<>();
    static Map<Integer, Character> posToChar = new HashMap<>();

    // Static initialization
    static {
        String key = "MONARCHY";
        buildMatrix(key);
    }

    // Build 1D key matrix
    static void buildMatrix(String key) {
        key = key.toUpperCase().replace("J", "I");

        boolean[] used = new boolean[26];
        int index = 0;

        for (char ch : key.toCharArray()) {
            if (ch < 'A' || ch > 'Z') continue;
            if (!used[ch - 'A']) {
                charToPos.put(ch, index);
                posToChar.put(index, ch);
                used[ch - 'A'] = true;
                index++;
            }
        }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (ch == 'J') continue;
            if (!used[ch - 'A']) {
                charToPos.put(ch, index);
                posToChar.put(index, ch);
                used[ch - 'A'] = true;
                index++;
            }
        }
    }

    // Prepare plaintext
    static String prepare(String text) {
        text = text.toUpperCase().replace("J", "I");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            sb.append(text.charAt(i));
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                sb.append('X');
            }
        }

        if (sb.length() % 2 != 0)
            sb.append('X');

        return sb.toString();
    }


    static String encrypt(String text) {
        text = prepare(text);
        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {

            int pos1 = charToPos.get(text.charAt(i));
            int pos2 = charToPos.get(text.charAt(i + 1));

            int r1 = pos1 / 5;   // quotient is for row
            int c1 = pos1 % 5;   // remainder is for column
            int r2 = pos2 / 5;
            int c2 = pos2 % 5;

            int newPos1, newPos2;

            // Same row
            if (r1 == r2) {
                newPos1 = r1 * 5 + (c1 + 1) % 5;
                newPos2 = r2 * 5 + (c2 + 1) % 5;
            }
            // Same column
            else if (c1 == c2) {
                newPos1 = ((r1 + 1) % 5) * 5 + c1;
                newPos2 = ((r2 + 1) % 5) * 5 + c2;
            }
            // Rectangle
            else {
                newPos1 = r1 * 5 + c2;
                newPos2 = r2 * 5 + c1;
            }

            cipher.append(posToChar.get(newPos1));
            cipher.append(posToChar.get(newPos2));
        }
        return cipher.toString();
    }


    static String decrypt(String text) {
        StringBuilder plain = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {

            int pos1 = charToPos.get(text.charAt(i));
            int pos2 = charToPos.get(text.charAt(i + 1));

            int r1 = pos1 / 5;
            int c1 = pos1 % 5;
            int r2 = pos2 / 5;
            int c2 = pos2 % 5;

            int newPos1, newPos2;

            // Same row
            if (r1 == r2) {
                newPos1 = r1 * 5 + (c1 + 4) % 5;
                newPos2 = r2 * 5 + (c2 + 4) % 5;
            }
            // Same column
            else if (c1 == c2) {
                newPos1 = ((r1 + 4) % 5) * 5 + c1;
                newPos2 = ((r2 + 4) % 5) * 5 + c2;
            }
            // Rectangle
            else {
                newPos1 = r1 * 5 + c2;
                newPos2 = r2 * 5 + c1;
            }

            plain.append(posToChar.get(newPos1));
            plain.append(posToChar.get(newPos2));
        }
        return plain.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text: ");
        String text = sc.nextLine();
        String cipher = encrypt(text);

        System.out.println("[Encrypted] " + cipher);
        System.out.println("[Decrypted] " + decrypt(cipher));
    }
}
