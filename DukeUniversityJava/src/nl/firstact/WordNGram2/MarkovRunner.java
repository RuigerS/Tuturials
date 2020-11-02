package nl.firstact.WordNGram2;
/**
 * Write a description of class MarkovRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunner {
    public static void main(String[] args) {
        MarkovRunner mr = new MarkovRunner();
        //mr.runMarkovWord();
        //mr.testHashMap();
        mr.compareMethods();
    }

    public void runModel(IMarkovModel markov, String text, int size) {
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for (int k = 0; k < 3; k++) {
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for (int k = 0; k < 3; k++) {
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //MarkovWordOne markovWord = new MarkovWordOne();
        //runModel(markovWord, st, 200);
    }

    public void runMarkovWord() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWord markovWord = new MarkovWord(5);
        markovWord.setRandom(844);
        runModel(markovWord, st, 200);
    }

    private void printOut(String s) {
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for (int k = 0; k < words.length; k++) {
            System.out.print(words[k] + " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

    public void testHashMap() {
        String st = "this is a test yes this is really a test yes a test this is wow";
        EfficientMarkovWord emw = new EfficientMarkovWord(2);
        runModel(emw, st, 50, 42);
    }

    public void compareMethods() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int order=2;
        int random=65;
        int size=100;
        MarkovWord markovWord = new MarkovWord(order);
        EfficientMarkovWord emw = new EfficientMarkovWord(order);
        long start = System.nanoTime();
        runModel(markovWord, st, size,random);
        long pause = System.nanoTime();
        runModel(emw, st, size, random);
        long end = System.nanoTime();
        long dur1 = pause - start;
        long dur2 = end - pause;
        System.out.println("First : " + dur1);
        System.out.println("Second: " + dur2);
    }
}
