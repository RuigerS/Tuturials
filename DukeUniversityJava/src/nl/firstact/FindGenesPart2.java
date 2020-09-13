package nl.firstact;

public class FindGenesPart2 {
    public static void main(String[] args) {
        DNASource src=new DNASource();
        
        System.out.println(findSimpleGene(src.dna1,0,src.dna1.length()-1));
        System.out.println(findSimpleGene(src.dna1,10,50));
        
        System.out.println(findSimpleGene(src.dna3,0,src.dna3.length()-1));
        System.out.println(findSimpleGene(src.dna3,10,50));
        
        System.out.println(findSimpleGene(src.dna4,0,src.dna4.length()-1));
        System.out.println(findSimpleGene(src.dna4,10,50));
        testSimpleGene();
    }

    public static String findSimpleGene(String dna,int startCodon,int stopCodon) {
        String udna = dna.toUpperCase().substring(startCodon,stopCodon);
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
        System.out.println(findSimpleGene(test1,0,test1.length()));
        System.out.println(findSimpleGene(test2,0,test2.length()));
        System.out.println(findSimpleGene(test3,0,test3.length()));
        System.out.println(findSimpleGene(test4,0,test4.length()));
        System.out.println(findSimpleGene(test5,0,test5.length()));
        String test6 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println(findSimpleGene(test6,0,test5.length()));

    }
}
