package nl.firstact.RandomText1;

/**
 * Write a description of class MarkovOne here.
 *
 * @author Duke Software
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovModel {
    private String myText;
    private Random myRandom;
    private int numCharsKey;

    public MarkovModel(int numCharsKey) {
        myRandom = new Random();
        this.numCharsKey=numCharsKey;
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String s) {
        myText = s.trim();
    }

    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrl;
        int index = myRandom.nextInt(myText.length()-numCharsKey);
        String key=myText.substring(index,index+numCharsKey);
        sb.append(key);
        for (int k = numCharsKey; k < numChars; k++) {
            arrl=getFollows(sb.substring(k-numCharsKey,k));
            int next = myRandom.nextInt(arrl.size());
            sb.append(arrl.get(next));
        }

        return sb.toString();
    }

    public ArrayList<String> getFollows(String key) {
        ArrayList result = new ArrayList();
        int idx = myText.indexOf(key);
        while (idx >-1 && idx<myText.length()-key.length()) {
            result.add(myText.substring(idx+key.length(),idx+key.length()+1));
            idx=myText.indexOf(key,idx+key.length());
        }
        return result;
    }
}


