package nl.firstact;

public class FindGenesMain {

    public static void main(String[] args) {
        DNASource src=new DNASource();
        System.out.println(findSimpleGene(src.dna1));
        
        System.out.println(findSimpleGene(src.dna3));
        
        System.out.println(findSimpleGene(src.dna4));
        testSimpleGene();
    }

    public static String findSimpleGene(String dna) {
        String udna = dna.toUpperCase();
        int indexStart = udna.indexOf("ATG");
        if (indexStart == -1) {
            return "No start ATG found";
        }
        int indexStop = udna.indexOf("TAA", indexStart);
        if (indexStop == -1) {
            return "No end TAA found";
        }
        String result = dna.substring(indexStart, indexStop + 3);
        if (result.length() % 3 == 0) {
            return result;
        } else {
            return "No genes % 3 found";
        }
    }

    public static void testSimpleGene() {
        String test1 = "TAATAATAATAATTAA";
        String test2 = "ATGATGATGATGATGATG";
        String test3 = "CCCCCACACTCTCGCGCG";
        String test4 = "ATGCCCCCACACTCTCGCGCGTAA";
        String test5 = "ATGCCCCACACTCTCGCGCGTAA";
        String test6 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println(findSimpleGene(test6));
        System.out.println(findSimpleGene(test1));
        System.out.println(findSimpleGene(test2));
        System.out.println(findSimpleGene(test3));
        System.out.println(findSimpleGene(test4));
        System.out.println(findSimpleGene(test5));
    }
}
