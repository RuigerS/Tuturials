package nl.firstact.WordNGram1;

/**
 * Write a description of class MarkovWordOne here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;

    public static void main(String[] args) {
        MarkovWordTwo mo=new MarkovWordTwo();
        mo.testIndexOf();
        mo.setTraining("this is just a test yes this is a simple test");
        mo.getFollows("this","is");
        mo.getFollows("just","a");
    }

    public MarkovWordTwo() {
        myRandom = new Random();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-2);  // random word to start with
        String key1 = myText[index];
        String key2 = myText[index+1];
        sb.append(key1);
        sb.append(" ");
        sb.append(key2);
        sb.append(" ");
        for(int k=0; k < numWords-2; k++){
            ArrayList<String> follows = getFollows(key1,key2);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1=key2;
            key2 = next;
        }

        return sb.toString().trim();
    }
    private int indexOf(String[] words, String target1,String target2, int start ){
        int found=-1;
        for (int i = start; i < words.length-1; i++) {
            if(words[i].equals(target1)&&words[i+1].equals(target2)){
                return i;
            }
        }
        return found;
    }

    private void testIndexOf(){
        String[] testText="this is just a test yes this is a simple test".split("\\s+");
        System.out.println("this is: "+indexOf(testText,"this","is",0));
        System.out.println("just a: "+indexOf(testText,"just","a",3));
    }

    private ArrayList<String> getFollows(String key1,String key2) {
        ArrayList<String> follows = new ArrayList<String>();
//		for (int i = 0; i < myText.length; i++) {
//			if(myText[i].equals(key)){
//				if(i>=myText.length-1){
//					follows.add("EOA");
//				}else{
//					follows.add(myText[i+1]);
//				}
//			}
//		}
        int index=indexOf(myText,key1,key2,0);
        while(index>-1){
            if(index< myText.length-2){
                follows.add(myText[index+2]);
            }
//            else{
//                follows.add("EOA");
//            }
            index=indexOf(myText,key1,key2,index+1);
        }
        //System.out.println(key1+" "+key2+": "+follows);
        return follows;
    }

}