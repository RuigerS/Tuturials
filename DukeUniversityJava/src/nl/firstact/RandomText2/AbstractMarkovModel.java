package nl.firstact.RandomText2;
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int numCharsKey;

    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    abstract public String getRandomText(int numChars);

    protected ArrayList<String> getFollows(String key) {
        ArrayList result = new ArrayList();
        int idx = myText.indexOf(key);
        while (idx >-1 && idx<myText.length()-key.length()) {
            result.add(myText.substring(idx+key.length(),idx+key.length()+1));
            idx=myText.indexOf(key,idx+1);
        }
        return result;
    }

    @Override
    public String toString(){
        return "MarkovModel of order "+numCharsKey;
    }

}
