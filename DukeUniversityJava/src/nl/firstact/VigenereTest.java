package nl.firstact;

import java.util.*;

import edu.duke.*;

public class VigenereTest {

    public static void main(String[] args) {
        //testSliceString();
        //testTryKeyLength();
        testBreakVigenere();
        //testReadDictionary();
        //testCountWords();
        //testBreakForLanguage();
        //testMostCommonCharIn();
    }

    public static void testSliceString() {
        VigenereBreaker vb = new VigenereBreaker();
        System.out.println(vb.sliceString("abcdefghijklm", 0, 3).equals("adgjm"));
        System.out.println(vb.sliceString("abcdefghijklm", 1, 3).equals("behk"));
        System.out.println(vb.sliceString("abcdefghijklm", 2, 3).equals("cfil"));
        System.out.println(vb.sliceString("abcdefghijklm", 0, 4).equals("aeim"));
        System.out.println(vb.sliceString("abcdefghijklm", 1, 4).equals("bfj"));
        System.out.println(vb.sliceString("abcdefghijklm", 2, 4).equals("cgk"));
        System.out.println(vb.sliceString("abcdefghijklm", 3, 4).equals("dhl"));
        System.out.println(vb.sliceString("abcdefghijklm", 0, 5).equals("afk"));
        System.out.println(vb.sliceString("abcdefghijklm", 1, 5).equals("bgl"));
        System.out.println(vb.sliceString("abcdefghijklm", 2, 5).equals("chm"));
        System.out.println(vb.sliceString("abcdefghijklm", 3, 5).equals("di"));
        System.out.println(vb.sliceString("abcdefghijklm", 4, 5).equals("ej"));
    }

    public static void testTryKeyLength() {
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource("VigenereTestData/secretmessage2.txt");
        String message = fr.asString();
        System.out.println(Arrays.toString(vb.tryKeyLength(message, 4, 'e')));
    }
    public static void testBreakVigenere(){
        VigenereBreaker vb=new VigenereBreaker();
        vb.breakVigenere();
    }
    public static void testReadDictionary(){
        VigenereBreaker vb=new VigenereBreaker();
        FileResource fr = new FileResource("dictionaries/English");
        System.out.println(vb.readDictionary(fr));
    }
    public static void testCountWords(){
        VigenereBreaker vb=new VigenereBreaker();
        FileResource dict = new FileResource("dictionaries/English");
        FileResource fr = new FileResource("VigenereTestData/athens.txt");
        String message = fr.asString();
        System.out.println(vb.countWords(message,vb.readDictionary(dict)));
    }
    public static void testBreakForLanguage(){
        VigenereBreaker vb=new VigenereBreaker();
        FileResource dict = new FileResource("dictionaries/English");
        FileResource fr = new FileResource("VigenereTestData/athens_keyflute.txt");
        String message = fr.asString();
        System.out.println(vb.breakForLanguage(message,vb.readDictionary(dict)));
    }
//    public static void testBreakForLanguage38(){
//        VigenereBreaker vb=new VigenereBreaker();
//        FileResource dict = new FileResource("dictionaries/English");
//        FileResource fr = new FileResource("VigenereTestData/secretmessage2.txt");
//        String message = fr.asString();
//        System.out.println(vb.breakForLanguage38(message,vb.readDictionary(dict)));
//    }
    public static void testMostCommonCharIn(){
        VigenereBreaker vb=new VigenereBreaker();
        FileResource dict = new FileResource("dictionaries/English");
        System.out.println(vb.mostCommonCharIn(vb.readDictionary(dict)));
    }
}
