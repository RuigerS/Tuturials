package nl.firstact;

import edu.duke.FileResource;

public class testCaesasCipherTwo {
    public static void main(String[] args) {
        FileResource fr = new FileResource();
        String message = fr.asString();

        System.out.println(breakCaesarCipherTwo(message));
    }
    public static void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipherTwo cct = new CaesarCipherTwo(17,3);
        String encrypted=cct.encrypt(message);
        System.out.println(encrypted);
        String decrypted=cct.decrypt(encrypted);
        System.out.println(decrypted);
        System.out.println(breakCaesarCipherTwo(encrypted));
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
    public static String halfOfString(String message, int start) {
        String result = "";
        for (int i = start; i < message.length(); i += 2) {
            result += message.charAt(i);
        }
        return result;
    }
    public static String breakCaesarCipherTwo(String s){
        String part1=halfOfString(s,0);
        String part2=halfOfString(s,1);
        int key1=getKey(part1);
        int key2=getKey(part2);
        System.out.println(key1);
        System.out.println(key2);
        CaesarCipherTwo ccTwo=new CaesarCipherTwo(key1,key2);
        String broke = ccTwo.decrypt(s);
        return broke;
    }

}
