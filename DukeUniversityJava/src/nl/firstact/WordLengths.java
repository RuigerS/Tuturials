package nl.firstact;

import edu.duke.FileResource;

public class WordLengths {
    public static void main(String[] args) {
        testCountWordLengths();
    }

    public static void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.println(counts[i] + " words of length " + i);
            }
        }
        System.out.println(indexOfMax(counts));
    }

    public static void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            int count = word.length();
            if (!Character.isLetter(word.charAt(0))) {
                count--;
            }
            if (!Character.isLetter(word.charAt(word.length() - 1))) {
                count--;
            }
            if (count >= counts.length) {
                count = counts.length - 1;
            }
            if(count>0)counts[count]++;
        }
    }
    public static int indexOfMax(int[] counts){
        int highest=0;
        for (int i = 0; i < counts.length-1; i++) {
            if(counts[i]>counts[highest]){
                highest=i;
            }
        }
        return highest;
    }
}
