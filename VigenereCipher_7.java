import java.util.Scanner;

class VigenereCipher_7 {

    static String key;


    static String generateKey(String text) {
        text = text.toLowerCase().replaceAll(" ", "");
        String k = key.toLowerCase();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            res.append(k.charAt(i % k.length()));
        }
        return res.toString();
    }


    static String enc(String text) {
        text = text.toLowerCase().replaceAll(" ", "");
        String k = generateKey(text);
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int p = text.charAt(i) - 'a';
            int kk = k.charAt(i) - 'a';

            int c = (p + kk) % 26;
            res.append((char)(c + 'a'));
        }
        return res.toString();
    }


    static String dec(String text) {
        text = text.toLowerCase().replaceAll(" ", "");
        String k = generateKey(text);
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';
            int kk = k.charAt(i) - 'a';

            int p = (c - kk + 26) % 26;
            res.append((char)(p + 'a'));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key: ");
        key = sc.nextLine();

        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        String e = enc(msg);
        System.out.println("Encrypted: " + e);

        String d = dec(e);
        System.out.println("Decrypted: " + d);

        sc.close();
    }
}
