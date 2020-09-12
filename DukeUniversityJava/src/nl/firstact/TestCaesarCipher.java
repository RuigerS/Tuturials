package nl.firstact;

import edu.duke.FileResource;

public class TestCaesarCipher {
    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher(15);
        System.out.println(cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
    }

    public static void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted=cc.encrypt(message);
        System.out.println(encrypted);
        String decrypted=cc.decrypt(encrypted);
        System.out.println(decrypted);
        System.out.println(breakCaesarCipher(encrypted));
    }

    public static String breakCaesarCipher(String s){
        int key=getKey(s);
        CaesarCipher cc=new CaesarCipher(key);
        String broke = cc.decrypt(s);
        return broke;
    }

    public static int[] countLetters(String s) {
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        int[] index = new int[30];
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (Character.isLetter(ch)) {
                index[alphabet.indexOf(ch) + 1]++;
            }
        }
        return index;
    }

    public static int getKey(String message) {
        int key = WordLengths.indexOfMax(countLetters(message)) - 5;
        if (key < 0) {
            key += 26;
        }
        return key;
    }
}
