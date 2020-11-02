package nl.firstact.RandomText2;
/**
 * Write a description of class MarkovRunner here.
 *
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunnerWithInterface {

    public static void main(String[] args) {
        MarkovRunnerWithInterface mr = new MarkovRunnerWithInterface();
        //mr.runMarkov();
        //mr.testHashMap();
        //mr.compareMethods();
        mr.runMarkov();
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println(markov);
        for (int k = 0; k < 3; k++) {
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed = 531;

//        MarkovZero mz = new MarkovZero();
//        runModel(mz, st, size, seed);
//
//        MarkovOne mOne = new MarkovOne();
//        runModel(mOne, st, size, seed);
//
//        MarkovModel mThree = new MarkovModel(6);
//        runModel(mThree, st, size, seed);
//
        EfficientMarkovModel mSix=new EfficientMarkovModel(5);
        runModel(mSix, st, size, seed);
//
//        MarkovFour mFour = new MarkovFour();
//        runModel(mFour, st, size, seed);

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
        EfficientMarkovModel emm = new EfficientMarkovModel(2);
        runModel(emm, "yes-this-is-a-thin-pretty-pink-thistle", 50, 42);
    }

    public void compareMethods() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 1000;
        int seed = 615;
        //long start = System.nanoTime();
        //MarkovModel mTwo = new MarkovModel(2);
        //runModel(mTwo, st, size, seed);
        //long pause = System.nanoTime();
        EfficientMarkovModel emm = new EfficientMarkovModel(5);
        runModel(emm, st, size, seed);
        //long end = System.nanoTime();
        //long dur1 = pause - start;
        //long dur2 = end - pause;
        //System.out.println("First : " + dur1);
        //System.out.println("Second: " + dur2);
    }
}

