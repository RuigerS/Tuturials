package nl.firstact;

public class FindGenesPart5 {
    public static void main(String[] args) {
        DNASource src = new DNASource();
        System.out.println(findStopCodon(src.dna1, 0, "TAA"));
        System.out.println(findStopCodon(src.dna1
        , 10, "TGA"));
        System.out.println(findGene(src.dna1
        ));
        findGenes(src.dna1
        );
        
        System.out.println(findStopCodon(src.dna3, 0, "TGA"));
        System.out.println(findStopCodon(src.dna3, 10, "TAA"));
        System.out.println(findGene(src.dna3));
        findGenes(src.dna3);
        
        System.out.println(findStopCodon(src.dna4, 0, "TAA"));
        System.out.println(findStopCodon(src.dna4, 10, "TGA"));
        System.out.println(findGene(src.dna4));
        findGenes(src.dna4);
        testSimpleGene();
    }

    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
        String udna = dna.toUpperCase();
        String uStopCodon = stopCodon.toUpperCase();
        int foundIndex = startIndex;
        boolean eostr = false;
        while (!eostr) {
            foundIndex = udna.indexOf(uStopCodon, startIndex);
            if (foundIndex == -1) {
                eostr = true;
            } else if ((foundIndex - startIndex) % 3 == 0) {
                return foundIndex;
            } else {
                startIndex = foundIndex + 1;
            }
        }
        //return dna.length();
        return -1;
    }

    public static String findGene(String dna) {
        int start = -1;
        int taa = -1;
        int tag = -1;
        int tga = -1;
        start = findStopCodon(dna, 0, "atg");
        if (start == -1) {
            return "";
        }
        taa = findStopCodon(dna, start, "taa");
        tag = findStopCodon(dna, start, "tag");
        tga = findStopCodon(dna, start, "tga");
        if (taa < tag && taa < tga && taa != -1) {
            return dna.substring(start, taa + 3);
        } else if (tag < taa && tag < tga && tag != -1) {
            return dna.substring(start, tag + 3);
        } else if (tga < tag && tga < taa && tga != -1) {
            return dna.substring(start, tga + 3);
        } else {
            return "";
        }
    }

    public static void findGenes(String dna) {
        boolean eostr = false;
        int start = 0;
        int taa = -1;
        int tag = -1;
        int tga = -1;
        while (!eostr) {
            start = findStopCodon(dna, start, "atg");
            if (start == -1) {
                eostr=true;
                System.out.println("That's all...\n");
                break;
            }
            taa = findStopCodon(dna, start, "taa");
            tag = findStopCodon(dna, start, "tag");
            tga = findStopCodon(dna, start, "tga");
            if (taa < tag && taa < tga && taa != -1) {
                System.out.println(dna.substring(start, taa + 3));
                start=taa;
                taa=-1;tag=-1;tga=-1;
            } else if (tag < taa && tag < tga && tag != -1) {
                System.out.println(dna.substring(start, tag + 3));
                start=tag;
                taa=-1;tag=-1;tga=-1;
            } else if (tga < tag && tga < taa && tga != -1) {
                System.out.println(dna.substring(start, tga + 3));
                start=tga;
                taa=-1;tag=-1;tga=-1;
            } else {
                System.out.println("That's all...\n");
                eostr=true;
            }
        }
    }

    public static void testSimpleGene() {
        String test1 = "TAATAATAATAATTAA";
        String test2 = "ATGATGATGATGATGATG";
        String test3 = "CCCCCACACTCTCGCGCG";
        String test4 = "ATGCCCCCACACTCTCGCGCGTAA";
        String test5 = "ATGCCCCACACTCTCGCGCGTAA";
        System.out.println(findStopCodon(test1, 0, "taa"));
        System.out.println(findStopCodon(test2, 0, "taa"));
        System.out.println(findStopCodon(test3, 0, "taa"));
        System.out.println(findStopCodon(test4, 0, "taa"));
        System.out.println(findStopCodon(test5, 0, "taa"));
        String test6 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println(findStopCodon(test6, 0, "taa"));

    }
}
