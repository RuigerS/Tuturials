package nl.firstact.RandomText2;

/**
 * Write a description of class MarkovOne here.
 *
 * @author Duke Software
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovModel extends AbstractMarkovModel{


    public MarkovModel(int numCharsKey) {
        myRandom = new Random();
        this.numCharsKey=numCharsKey;
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


}


