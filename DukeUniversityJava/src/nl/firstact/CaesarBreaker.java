package nl.firstact;

import edu.duke.FileResource;

public class CaesarBreaker {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        testDecrypt();
    }

    public static void testDecrypt() {
        FileResource fr = new FileResource();
        String message = fr.asString();
//        int key=3;
        System.out.println("Begin string: "+message);
//        String encrypted = CaesarCipher.encrypt(message, key);
//        System.out.println("Encrypted string: "+encrypted);
//        String decrypted = decrypt(encrypted, getKey(encrypted));
//        System.out.println("Decrypted string: "+decrypted);
//        System.out.println(halfOfString("Qbkm Zgis",0));
//        System.out.println(halfOfString("Qbkm Zgis",1));
//        decryptTwoKeys(message);
        //  decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko");
    }


//    public static String decrypt(String s, int key) {
//        return CaesarCipher.encrypt(s, 26 - key);
//    }






}
