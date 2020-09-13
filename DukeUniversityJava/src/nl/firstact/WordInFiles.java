package nl.firstact;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordInFiles {
    private HashMap<String, ArrayList<String>> map;

    public WordInFiles() {
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        WordInFiles wif=new WordInFiles();
        wif.buildWordMapFile();
 //       System.out.println("Maxnumber: "+wif.maxNumber());
 //       System.out.println("WordsInNumFiles 4: "+wif.wordsInNumFiles(4).size());
 //       System.out.println("WordsInNumFiles 2: "+wif.wordsInNumFiles(2));
        wif.printFilesIn("tree");
    }

    public void addWordsFromFile(File f) {
        FileResource fr = new FileResource(f);
        for (String word : fr.words()) {
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            if (!map.get(word).contains(f.getName())) {
                map.get(word).add(f.getName());
            }
        }
    }

    public void buildWordMapFile() {
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
    }
    public int maxNumber(){
        int maxNr=0;
        for(ArrayList<String> arr:map.values()){
            if(arr.size()>maxNr){
                maxNr=arr.size();
            }
        }
        return maxNr;
    }
    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> arrL=new ArrayList<>();
        for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
            if(entry.getValue().size()==number){
                arrL.add(entry.getKey());
            }
        }
        return arrL;
    }
    public void printFilesIn(String word){
        ArrayList<String> arrL=map.get(word);
        for (String s:arrL) {
            System.out.println(s);
        }
    }
}
