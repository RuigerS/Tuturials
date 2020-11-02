package nl.firstact.WordNGram1;
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;

	public static void main(String[] args) {
		MarkovWordOne mo=new MarkovWordOne();
		mo.testIndexOf();
		mo.setTraining("this is just a test yes this is a simple test");
		mo.getFollows("test");
		mo.getFollows("is");
	}
    
    public MarkovWordOne() {
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
		int index = myRandom.nextInt(myText.length-1);  // random word to start with
		String key = myText[index];
		sb.append(key);
		sb.append(" ");
		for(int k=0; k < numWords-1; k++){
		    ArrayList<String> follows = getFollows(key);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key = next;
		}
		
		return sb.toString().trim();
	}
	private int indexOf(String[] words, String target, int start ){
    	int found=-1;
		for (int i = start; i < words.length; i++) {
			if(words[i].equals(target)){
				return i;
			}
		}
		return found;
	}

	private void testIndexOf(){
    	String[] testText="this is just a test yes this is a simple test".split("\\s+");
		System.out.println("this,0: "+indexOf(testText,"this",0));
		System.out.println("this,3: "+indexOf(testText,"this",3));
		System.out.println("frog,0: "+indexOf(testText,"frog",0));
		System.out.println("frog,5: "+indexOf(testText,"frog",5));
		System.out.println("simple,2: "+indexOf(testText,"simple",2));
		System.out.println("test,5: "+indexOf(testText,"test",5));
	}
	
	private ArrayList<String> getFollows(String key) {
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
		int index=indexOf(myText,key,0);
		while(index>-1){
			if(index< myText.length-1){
				follows.add(myText[index+1]);
			}
//			else{
//				follows.add("EOA");
//			}
			index=indexOf(myText,key,index+1);
		}
		//System.out.println(key+": "+follows);
	    return follows;
    }

}
