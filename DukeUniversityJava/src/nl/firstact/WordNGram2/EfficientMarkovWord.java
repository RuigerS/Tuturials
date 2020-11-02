package nl.firstact.WordNGram2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovWord implements IMarkovModel {
    private String[] myText;
    Random myRandom;
    int myOrder;
    private HashMap<WordGram, ArrayList<String>> builtMap;

    public EfficientMarkovWord(int size) {
        myRandom = new Random();
        myOrder = size;
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text) {
        myText = text.split("\\s+");
        buildMap();
    }

    public String getRandomText(int numWords) {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length - myOrder);  // random word to start with
        WordGram key = new WordGram(myText, index, myOrder);
        sb.append(key.toString() + " ");
        for (int k = myOrder; k < numWords; k++) {
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                System.out.println("NOF");
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = key.shiftAdd(next);
        }

        return sb.toString().trim();
    }

    private int indexOf(String[] words, WordGram target, int start) {
        int found = -1;
        for (int i = start; i < words.length - target.length(); i++) {
            WordGram tmp = new WordGram(words, i, target.length());
            if (tmp.equals(target)) {
                return i;
            }
        }
        return found;
    }

    private ArrayList<String> getFollows(WordGram kGram) {
        return builtMap.get(kGram);
    }

    @Override
    public String toString() {
        return "MarkovModel of order " + myOrder;
    }

    public void buildMap() {
        System.out.println("Start buildMap");
        builtMap = new HashMap<>();
        ArrayList<String> follows;
        WordGram tmpWG;
        for (int i = 0; i <= myText.length - myOrder; i++) {
            follows = new ArrayList<String>();
            tmpWG = new WordGram(myText, i, myOrder);
            if (i == myText.length - myOrder) {
                follows = new ArrayList<String>();
            } else if (!builtMap.containsKey(tmpWG)) {
                follows = new ArrayList<String>();
                follows.add(myText[i + myOrder]);
            } else {
                follows = builtMap.get(tmpWG);
                follows.add(myText[i + myOrder]);
            }
            builtMap.put(tmpWG, follows);
        }
        printHashMap();
        System.out.println("End buildMap");
    }

    public void printHashMap() {
        //System.out.println(builtMap);
        System.out.println("Number of keys: " + builtMap.size());
        int biggest = 0;
        for (WordGram key : builtMap.keySet()) {
            if (builtMap.get(key).size() > biggest) {
                biggest = builtMap.get(key).size();
            }
        }
        System.out.println("Size of largest ArrayList: " + biggest);
        for (WordGram key : builtMap.keySet()) {
            if (builtMap.get(key).size() == biggest) {
                System.out.println(key + " " + builtMap.get(key));
            }
        }
    }
}
