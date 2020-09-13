package nl.firstact;

import edu.duke.*;

import java.util.*;

public class GladLib {
    HashMap<String, ArrayList<String>> map;
    private ArrayList<String> usedWords;
    private String[] labels = {"adjective", "noun", "color", "country", "name", "animal", "timeframe", "fruit", "verb"};
    private boolean[] labelUsed = new boolean[labels.length];

    private Random myRandom;

//    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public static void main(String[] args) {
        GladLib gl = new GladLib();
        gl.makeStory();

    }

    public GladLib() {
        map = new HashMap<>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        usedWords = new ArrayList<>();
    }

    public GladLib(String source) {
        map = new HashMap<>();
        initializeFromSource(source);
        myRandom = new Random();
        usedWords = new ArrayList<>();
    }

    private void initializeFromSource(String source) {
        for (String s : labels) {
            ArrayList<String> list = readIt(source + "/" + s + ".txt");
            map.put(s, list);
        }
    }

    private String randomFrom(ArrayList<String> source) {
        int index = myRandom.nextInt(source.size());
        while (usedWords.contains(source.get(index))) {
            index = myRandom.nextInt(source.size());
        }
        usedWords.add(source.get(index));
        return source.get(index);
    }

    private String getSubstitute(String label) {
        if (label.equals("number")) {
            return "" + myRandom.nextInt(50) + 5;
        } else {
            for (int i = 0; i < labels.length; i++) {
                if (label.equals(labels[i])) {
                    labelUsed[i] = true;
                }
            }
            return randomFrom(map.get(label));
        }
    }

    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if (first == -1 || last == -1) {
            return w;
        }
        String prefix = w.substring(0, first);
        String suffix = w.substring(last + 1);
        String sub = getSubstitute(w.substring(first + 1, last));
        return prefix + sub + suffix;
    }

    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for (String w : s.split("\\s+")) {
            if (charsWritten + w.length() > lineWidth) {
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }

    public void makeStory() {
        usedWords.clear();
        for (int i = 0; i < labelUsed.length; i++) {
            labelUsed[i] = false;
        }
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\n\nUsed words: " + usedWords.size());
        System.out.println("Total words to choose from: " + totalWordsInMap());
        totalWordsConsidered();
    }

    public int totalWordsInMap() {
        int total = 0;
        for (String entry : map.keySet()) {
            total += map.get(entry).size();
        }
        return total;
    }

    public void totalWordsConsidered() {
        int total = 0;
        for (int i = 0; i < labels.length; i++) {
            if (labelUsed[i]) {
                total += map.get(labels[i]).size();
            }
        }
        System.out.println("Total considered: " + total);
    }
}
