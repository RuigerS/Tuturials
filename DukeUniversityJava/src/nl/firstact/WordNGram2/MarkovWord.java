package nl.firstact.WordNGram2;

import java.util.ArrayList;
import java.util.Random;

public class MarkovWord implements IMarkovModel{
    private String[] myText;
    Random myRandom;
    int myOrder;

    public MarkovWord(int size) {
        myRandom = new Random();
        myOrder=size;
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram key=new WordGram(myText,index,myOrder);
        sb.append(key.toString()+" ");
        for(int k=myOrder; k < numWords; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                System.out.println("NOF");
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            //System.out.println("Before: "+key);
            key = key.shiftAdd(next);
            //System.out.println("Next: "+key);
        }

        return sb.toString().trim();
    }

    private int indexOf(String[] words, WordGram target, int start ){
        int found=-1;
        for (int i = start; i < words.length-target.length(); i++) {
            WordGram tmp=new WordGram(words,i,target.length());
            if(tmp.equals(target)){
                return i;
            }
        }
        return found;
    }

    private ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> follows = new ArrayList<String>();
        int index=indexOf(myText,kGram,0);
        while(index>-1){
            if(index< (myText.length-kGram.length())){
                follows.add(myText[index+ kGram.length()]);
            }
            index=indexOf(myText,kGram,index+1);
        }
        return follows;
    }

    @Override
    public String toString(){
        return "MarkovModel of order "+myOrder;
    }
}
