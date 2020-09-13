package nl.firstact;

import edu.duke.FileResource;

import java.util.HashMap;
import java.util.Map;

public class CodonCount {
    private HashMap<String, Integer> hashF;
//    private int hashFrame;

    public CodonCount(int start) {
        hashF = new HashMap<>();
//        hashFrame = start;
    }

    public static void main(String[] args) {
        CodonCount[] cc = new CodonCount[3];
        FileResource fr = new FileResource();
        String message = fr.asString().toUpperCase().trim();
        for (int i = 0; i < 3; i++) {
            cc[i]=new CodonCount(i);
            cc[i].buildCodonMap(i, message);
            System.out.println("Reading frame: "+i+ " with unique codons: "+cc[i].hashF.size() );
            System.out.println("Most common codon: "+cc[i].getMostCommonCodon()+" with count "+cc[i].hashF.get(cc[i].getMostCommonCodon()));
            cc[i].printCodonCounts(7,7);
            System.out.println("");

        }
    }

    public void buildCodonMap(int start, String dna) {
        hashF.clear();
        for (int i = start; i < dna.length() - 2; i += 3) {
            String subDna = dna.substring(i, i + 3);
            hashF.putIfAbsent(subDna, 0);
            hashF.put(subDna, hashF.get(subDna) + 1);
        }
    }

    public String getMostCommonCodon() {
        int largestCount = 0;
        String mostCommonCodon = "";
        for (Map.Entry<String, Integer> entry : hashF.entrySet()) {
            if (entry.getValue() > largestCount) {
                largestCount = entry.getValue();
                mostCommonCodon = entry.getKey();
            }
        }
        return mostCommonCodon;
    }

    public void printCodonCounts(int start, int end) {
        for (Map.Entry<String, Integer> entry : hashF.entrySet()) {
            if (entry.getValue() >= start && entry.getValue() <= end) {
                System.out.print(entry.getKey());
                System.out.println(" " + entry.getValue());
            }
        }
    }
}
