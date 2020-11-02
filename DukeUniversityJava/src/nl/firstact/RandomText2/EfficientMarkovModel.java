package nl.firstact.RandomText2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovModel extends AbstractMarkovModel {
    private HashMap<String, ArrayList> builtMap = new HashMap<>();


    public EfficientMarkovModel(int numCharsKey) {
        myRandom = new Random();
        this.numCharsKey = numCharsKey;
    }


    public void setTraining(String s) {
        myText = s.trim();
        buildMap();
    }

    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder((String) builtMap.keySet().toArray()[myRandom.nextInt(builtMap.size())]);
        for (int k = numCharsKey; k < numChars; k++) {
            ArrayList arrl = builtMap.get(sb.substring(k - numCharsKey, k));
            //System.out.println(arrl);
            if(arrl.size()==0){break;}
            int next = myRandom.nextInt(arrl.size());
            sb.append(arrl.get(next));
        }

        return sb.toString();
    }

    public void buildMap() {
        String key;
        //ArrayList<String> arrl;
        if (myText != null) {
            for (int i = 0; i <= myText.length() - numCharsKey; i++) {
                key = myText.substring(i, i + numCharsKey);
                if(!builtMap.containsKey(key)) {
                    builtMap.put(key, getFollows(key));
                }
            }
        }
        printHashMapInfo();
    }
    public void printHashMapInfo(){
        //System.out.println(builtMap);
        System.out.println("Number of keys: "+builtMap.size());
        int biggest=0;
        for (String key:builtMap.keySet()) {
            if(builtMap.get(key).size()>biggest){biggest=builtMap.get(key).size();}
        }
        System.out.println("Size of largest ArrayList: "+biggest);
        for (String key:builtMap.keySet()) {
            if(builtMap.get(key).size()==biggest){
                System.out.println(key+" "+builtMap.get(key));
            }
        }
    }

}
