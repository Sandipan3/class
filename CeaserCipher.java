import java.util.*;

public class CeaserCipher {

    private static final Map<Integer,Character>  indexToChar = new HashMap<>();
    private static final Map<Character,Integer>  charToIndex = new HashMap<>();

    static {
        for(int i = 0 ; i < 26 ;i++ ){
            char ch = (char)('A' + i);
            charToIndex.put( ch , i );
            indexToChar.put(i ,ch);
        }
    }

    public static String encrypt(String message , int key){
        StringBuilder sb = new StringBuilder();
        key = key % 26;
        for(char ch : message.toCharArray()){
            sb.append( indexToChar.get((charToIndex.get(ch) + key) % 26) );
        }

        return sb.toString();
    }
    public static String decrypt(String message , int key){
        StringBuilder sb = new StringBuilder();
        key = key % 26;
        for(char ch : message.toCharArray()){
            sb.append(indexToChar.get((charToIndex.get(ch) - key ) % 26));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message:");
        String  message = sc.nextLine().toUpperCase();
        System.out.println("Enter the key:");
        int key = sc.nextInt();

        String encrypted = CeaserCipher.encrypt(message,key);
        Collections.sort();
        System.out.println("[Encrypted Message] " + encrypted );
        System.out.println("[Decrypted Message] " + CeaserCipher.decrypt(encrypted,key) );
    }
}
