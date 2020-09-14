package nl.firstact;

import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder tmp=new StringBuilder("");
        for (int i = whichSlice; i < message.length(); i+=totalSlices) {
            tmp.append(message.charAt(i));
        }
        return tmp.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        VigenereCaesarCracker cc=new VigenereCaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++) {
            String tmp=sliceString(encrypted,i,klength);
            key[i]=cc.getKey(tmp);
        }
        return key;
    }
    public void breakVigenere () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        HashMap<String, HashSet<String>> languages=new HashMap<>();
        languages.put("Danish",readDictionary(new FileResource("dictionaries/Danish")));
        languages.put("Dutch",readDictionary(new FileResource("dictionaries/Dutch")));
        languages.put("English",readDictionary(new FileResource("dictionaries/English")));
        languages.put("French",readDictionary(new FileResource("dictionaries/French")));
        languages.put("German",readDictionary(new FileResource("dictionaries/German")));
        languages.put("Italian",readDictionary(new FileResource("dictionaries/Italian")));
        languages.put("Portuguese",readDictionary(new FileResource("dictionaries/Portuguese")));
        languages.put("Spanish",readDictionary(new FileResource("dictionaries/Spanish")));
        breakForAllLangs(message,languages);
    }
    public void breakVigenereSecond () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        FileResource dict = new FileResource("dictionaries/English");
        System.out.println(breakForLanguage(message,readDictionary(dict)));
    }
    public void breakVigenereFirst () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int[] keys=tryKeyLength(message,4,'e');
        VigenereCipher vc=new VigenereCipher(keys);
        System.out.println(vc.decrypt(message));
    }
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dict=new HashSet<>();
        for (String line : fr.lines()) {
            line=line.toLowerCase();
            dict.add(line);
        }
        return dict;
    }
    public int countWords(String message,HashSet dict){
        int count=0;
        message=message.toLowerCase();
        String[] words=message.split("\\W+");
        for (String s:words) {
            if(dict.contains(s)){
                count++;
            }
        }
        return count;
    }
    public String breakForLanguage(String encrypted,HashSet<String> dict){
        int most=0;
        int idx=0;
        char mostcommonchar=mostCommonCharIn(dict);
        for (int i = 1; i < 101; i++) {
            int[] keys=tryKeyLength(encrypted,i,mostcommonchar);
            VigenereCipher vc=new VigenereCipher(keys);
            if(countWords(vc.decrypt(encrypted),dict)>most){
                most=countWords(vc.decrypt(encrypted),dict);
                idx=i;
            }
        }
        System.out.println("Keylength "+idx);
        int[] keys=tryKeyLength(encrypted,idx,mostcommonchar);
        VigenereCipher vc=new VigenereCipher(keys);
        String solutie= vc.decrypt(encrypted);
        System.out.println("Aantal woorden: "+countWords(solutie,dict));
        return solutie;
    }
//    public String breakForLanguage38(String encrypted,HashSet<String> dict){
//        System.out.println("Keylength 38");
//        int[] keys=tryKeyLength(encrypted,38,'e');
//        VigenereCipher vc=new VigenereCipher(keys);
//        String solutie= vc.decrypt(encrypted);
//        System.out.println("Aantal woorden: "+countWords(solutie,dict));
//        return solutie;
//    }
    public char mostCommonCharIn(HashSet<String> dict){
        HashMap<Character,Integer> chars=new HashMap<>();
        for (String s:dict) {
            for (int i = 0; i < s.length(); i++) {
                if(Character.isLetter(s.charAt(i))) {
                    chars.putIfAbsent(s.charAt(i), 0);
                    chars.put(s.charAt(i), chars.get(s.charAt(i)) + 1);
                }
            }
        }
        char tmp=' ';
        int max=0;
        for (Map.Entry<Character, Integer> entry:chars.entrySet()) {
            if(entry.getValue()>max){
                max=entry.getValue();
                tmp=entry.getKey();
            }
        }
        return tmp;
    }
    public void breakForAllLangs(String encrypted,HashMap<String, HashSet<String>> languages){
        String bestLanguage="";
        int mostAantal=0;
        String bestSolution="";
        String lastLanguage="";
        int lastAantal=0;
        String lastSolution="";

        for (Map.Entry<String,HashSet<String>> entry:languages.entrySet()) {
            System.out.println(entry.getKey());
            lastSolution=breakForLanguage(encrypted,entry.getValue());
            lastAantal=countWords(lastSolution,entry.getValue());
            lastLanguage= entry.getKey();
            if(lastAantal>mostAantal){
                mostAantal=lastAantal;
                bestSolution=lastSolution;
                bestLanguage=lastLanguage;
            }
        }
        System.out.println("\nBest language: "+bestLanguage);
        System.out.println("Aantal treffers: "+mostAantal);


        System.out.println("Tekst:");
        System.out.println(bestSolution);
    }
}
