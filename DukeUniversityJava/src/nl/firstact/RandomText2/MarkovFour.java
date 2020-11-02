package nl.firstact.RandomText2;
/**
 * Write a description of class MarkovOne here.
 *
 * @author Duke Software
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovFour extends AbstractMarkovModel{

    public MarkovFour() {
        myRandom = new Random();
        numCharsKey=4;
    }



    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrl;
        int index = myRandom.nextInt(myText.length()-4);
        String key=myText.substring(index,index+4);
        sb.append(key);
        for (int k = 4; k < numChars; k++) {
            arrl=getFollows(sb.substring(k-4,k));
            int next = myRandom.nextInt(arrl.size());
            sb.append(arrl.get(next));
        }

        return sb.toString();
    }


}

