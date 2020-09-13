package nl.firstact;

import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public static void main(String[] args) {
        WordFrequencies wf=new WordFrequencies();
        wf.findUnique();
        System.out.println("Number of unique words: "+ wf.myWords.size());
        for (int i = 0; i < wf.myWords.size(); i++) {
            System.out.println((i+1)+" #"+wf.myFreqs.get(i)+" "+ wf.myWords.get(i));
        }
        int tmpMax= wf.findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: "+wf.myWords.get(tmpMax)+" "+wf.myFreqs.get(tmpMax));
    }

    public WordFrequencies() {
        myWords = new ArrayList<>();
        myFreqs = new ArrayList<>();
    }

    public void findUnique() {
        myFreqs.clear();
        myWords.clear();
        FileResource fr = new FileResource();
        for (String word : fr.words()) {
            int found = myWords.indexOf(word.toLowerCase());
            if (found == -1) {
                myWords.add(word.toLowerCase());
                myFreqs.add(1);
            } else {
                myFreqs.set(found, (myFreqs.get(found) + 1));
            }
        }
    }
    public int findIndexOfMax(){
        int idxLargest=0;
        int largest=0;
        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i)>largest){
                idxLargest=i;
                largest=myFreqs.get(i);
            }
        }
        return idxLargest;
    }
}
