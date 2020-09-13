package nl.firstact;

import edu.duke.*;

public class FindGenesPart4 {
    public static void main(String[] args) {
        URLResource ur=new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for(String word:ur.words()){
            //process
            if(word.toLowerCase().indexOf("youtube.com")>-1){
                int startIndex=word.lastIndexOf('"',word.toLowerCase().indexOf("youtube.com"));
                int endIndex=word.indexOf('"',word.toLowerCase().indexOf("youtube.com"));
                System.out.println(word.substring(startIndex,endIndex+1));
                //System.out.println(word);
            }
        }
    }
}
