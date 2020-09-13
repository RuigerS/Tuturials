package nl.firstact;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;
    private int min;
    private boolean tldr;

    public static void main(String[] args) {
        tester2();
    }

    public static void tester2() {
        CharactersInPlay cip = new CharactersInPlay();
        cip.findAllCharacters();
        cip.charactersWithNumParts(10, 15);
    }

    public static void tester1() {
        CharactersInPlay cip = new CharactersInPlay();
        cip.findAllCharacters();
        if (cip.names.size() > 10) {
            cip.tldr = true;
        }
        for (int i = 0; i < cip.names.size(); i++) {
            if (!cip.tldr || cip.counts.get(i) > cip.min)
                System.out.println(cip.names.get(i) + " " + cip.counts.get(i));
        }
    }

    public CharactersInPlay() {
        names = new ArrayList<>();
        counts = new ArrayList<>();
        min = 12;
        tldr = false;
    }

    public void update(String person) {
        int idx = names.indexOf(person);
        if (idx == -1) {
            names.add(person);
            counts.add(1);
        } else {
            counts.set(idx, counts.get(idx) + 1);
        }
    }

    public void findAllCharacters() {
        String lastCharacter = "Unknown";
        names.clear();
        counts.clear();
        FileResource fr = new FileResource();
        for (String line : fr.lines()) {
            line = line.trim();
            int idxPoint = line.indexOf('.');
            if (idxPoint > -1) {
                //count estafette overtakes
                if (line.substring(0, idxPoint).equals(line.substring(0, idxPoint).toUpperCase())) {
                    lastCharacter = line.substring(0, idxPoint);
                    //System.out.println("Ch found: " + line);
                    update(lastCharacter);
                }
            }
            /*
            //If lines said are to be counted!!
            while(!(idxPoint==-1)) {

                if (line.substring(0, idxPoint).equals(line.substring(0, idxPoint).toUpperCase())) {
                    lastCharacter = line.substring(0, idxPoint);
                    System.out.println("Ch found: "+line);
                    line = line.substring(idxPoint+1);
                    System.out.println("Ch removed: "+line);
                    idxPoint=line.indexOf('.');
                }else {
                    update(lastCharacter);
                    System.out.println("uitspraak: "+line);
                    line = line.substring(idxPoint+1);
                    System.out.println("Removed: "+line);
                    idxPoint = line.indexOf('.');
                }
            }*/
        }
    }

    public void charactersWithNumParts(int num1, int num2) {
        for (int i = 0; i < names.size(); i++) {
            if (counts.get(i) >= num1 && counts.get(i) <= num2) {
                System.out.println(names.get(i) + " :# " + counts.get(i));
            }
        }
    }
}
