package nl.firstact.RandomText1;
/**
 * Write a description of class MarkovOne here.
 *
 * @author Duke Software
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovOne {
    private String myText;
    private Random myRandom;

    public MarkovOne() {
        myRandom = new Random();
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
        int index = myRandom.nextInt(myText.length()-1);
        String key=myText.substring(index,index+1);
        sb.append(key);
        for (int k = 1; k < numChars; k++) {
            arrl=getFollows(sb.substring(k-1,k));
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

