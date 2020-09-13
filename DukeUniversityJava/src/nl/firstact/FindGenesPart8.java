package nl.firstact;

import edu.duke.StorageResource;

public class FindGenesPart8 {
    public static void main(String[] args) {
        DNASource src=new DNASource();
//        System.out.println(findStopCodon(src.dna1, 0, "TAA"));
//        System.out.println(findStopCodon(src.dna1, 10, "TGA"));
//        System.out.println(findGene(src.dna1));
//        findGenes(src.dna1);
        
//        System.out.println(findStopCodon(src.dna3, 0, "TGA"));
//        System.out.println(findStopCodon(src.dna3, 10, "TAA"));
//        System.out.println(findGene(src.dna3));
//        findGenes(src.dna3);
        String one="nonCodingDNAxxxMyGeneATGmyGenexTAAxxGeneATGTAACATGTAAATGCendTAATAAnonCodingDNAxTAGxTGA";
        String dna13genes = "oneAtGMyGeneOneAATGGGGTAATGATAGAACCCGGYGGGGTAGGGCTGCCCATGendOneTAAnonCodingDnaTAGTGAZZZtaaTwoATGMyGeneTwoCATGGGGTAATGATAGCCatgCCCFalseStartTAATGATGendTwoTAGnonCodingDNATAACCCThreeATGMyGeneThreeATGGGGTAATGATAGATGccendThreeTAAnonCodingDNAccTAAfalsecccFourATGMyGeneFourATGGGGTAATGATAGCendFourTAGnonCodingdnaFiveAtgMyGeneFiveATGGGGTAATGATAGCendFiveTGAnonCodingdnaSixATGmyGeneSixATATGGGGTAATGATAGAendSixTAAnoncodingdnaSevenATGMyGeneSevenCcATGGGGTAATGATAGendSeventaAnoncodingdnaEightATGmyGeneEightATGGGGTAATGATAGGGendEighttaAnoncodingdnaCcccWrongtgaCtaaCtagCCcgNineATgmyGeneNineATGGGGTAATGATAGTaaAendNineTAAnonCodingDnaCcccTenATGmyGeneTenGATGGGGTAATGATAGCCHasFakeATGFAKEatgcendTentaanonCodingDnaCtagCtganonCodingDnaxxxElevenATGmyGeneElevenCATGGGGTAATGATAGTAAxxGeneATGTAACATGTAAATGCendElevenTAAnonCodingDnaxTAGxtgaTwelveATGmyGeneTwelveCATGGGGTAATGATAGCTheLastGeneIsATGTAGendTwelvetgaATGTAG";
        findGenes(one);
//        findGenes(src.dna13genes);
//        System.out.println("Next");
       
//        System.out.println(findStopCodon(src.dna4, 0, "TAA"));
//        System.out.println(findStopCodon(src.dna4, 10, "TGA"));
//        System.out.println(findGene(src.dna4));
//        findGenes(src.dna4);
        
//        testSimpleGene();
//        System.out.println("Hiero:");
//        System.out.println(howMany("tga",src.dna1));
//        System.out.println(howMany("taa",src.dna1));
//        System.out.println(howMany("tag",src.dna1));
//        System.out.println(howMany("atg",src.dna1));
//        System.out.println("Hieros:");
//        System.out.println(getGenes(src.dna1));
//        System.out.println(getGenes(src.dna3));
//        System.out.println(getGenes(src.dna4));
//        System.out.println(cgRatio("ATGCCATAG"));
//        System.out.println(countCTG(src.dna3));
//       processGenes(getGenes(dna13genes));
        processGenes(getGenes(src.dnatest));
        System.out.println("How many genes: "+countGenes(dna13genes));
//        System.out.println("How many genes: "+countGenes(src.dnatest));
//        System.out.print("How many genes 2: ");
        findGenes(src.dnatest);
    //    System.out.println(((double) 500)/src.dna1.length());
    //    System.out.println((double) (500 / src.dna1.length()));
        System.out.println(countCTG(src.dnatest));
    }

    public static void processGenes(StorageResource sr){
        int count60 = 0;
        int countRatio=0;
        int longest=0;
        for(String str:sr.data()){
            if(str.length()>60){
                System.out.println(str);
                count60++;
            }
            if(cgRatio(str)>0.35){
                System.out.println(str+"  "+cgRatio(str));
                countRatio++;
            }
            if(str.length()>longest){
                longest=str.length();
            }
        }
        System.out.println("No of strings >60 length: "+count60);
        System.out.println("No of strings >0.35 ratio: "+countRatio);
        System.out.println("Longest length: "+longest);
        System.out.println("items: "+sr.size());
    }

    public static double cgRatio(String dna){
        int noOfcg=-2;
        int start=0;
        while(start>-1){
            start=dna.toUpperCase().indexOf('G',start);
            if(start>0)start++;
            noOfcg++;
        }
        start=0;
        while(start>-1){
            start=dna.toUpperCase().indexOf('C',start);
            if(start>0)start++;
            noOfcg++;
        }
        return (double) noOfcg/dna.length();
    }
    public static int countCTG(String dna){
        int no=-1;
        int start=0;
        while(start>-1){
            start=dna.toUpperCase().indexOf("CTG",start);
            if(start>0)start++;
            no++;
        }
        return no;
    }

    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
        String udna = dna.toUpperCase();
        String uStopCodon = stopCodon.toUpperCase();
        int foundIndex = startIndex;
        int position=startIndex;
        boolean eostr = false;
        while (!eostr) {
//            System.out.println(position);
            foundIndex = udna.indexOf(uStopCodon, position);
            if (foundIndex == -1) {
                eostr = true;
            } else if ((foundIndex - startIndex) % 3 == 0) {
//                System.out.println("found"+foundIndex);
                return foundIndex;
            } else {
                position = foundIndex+1;
            }
        }
        //return dna.length();
        return -1;
    }

//    public static int howMany(String a, String b){
//        int count= 0;
//        int pos=0;
//        boolean eostr=false;
//        String ua=a.toUpperCase();
//        String ub=b.toUpperCase();
//        while(!eostr){
//            pos=ub.indexOf(ua,pos);
//            if(pos==-1){
//                return count;
//            }
//            else{
//                count++;
//                pos++;
//            }
//        }
//        return count;
//    }

//    public static String findGene(String dna) {
//        int start = -1;
//        int taa = -1;
//        int tag = -1;
//        int tga = -1;
//        System.out.println("ATG");
//        start = findStopCodon(dna, 0, "atg");
//        if (start == -1) {
//            return "";
//        }
//        System.out.println("value:"+start);
//        System.out.println("TAA");
//        taa = findStopCodon(dna, start, "taa");
//        System.out.println("value:"+taa);
//        System.out.println("TAG");
//        tag = findStopCodon(dna, start, "tag");
//        System.out.println("value:"+tag);
//        System.out.println("TGA");
//        tga = findStopCodon(dna, start, "tga");
//        System.out.println("value:"+tga);
//        if ((tag==-1||taa < tag) && (tga==-1||taa < tga) && (taa != -1)) {
//            return dna.substring(start, taa + 3);
//        } else if ((taa==-1||tag < taa) && (tga==-1||tag < tga) && (tag != -1)) {
//            return dna.substring(start, tag + 3);
//        } else if ((tag==-1||tga < tag) && (taa==-1||tga < taa) && (tga != -1)) {
//            return dna.substring(start, tga + 3);
//        } else {
//            return "";
//        }
//    }

    public static void findGenes(String dna) {
        boolean eostr = false;
        int count=0;
        int start = 0;
        int taa = -1;
        int tag = -1;
        int tga = -1;
        while (!eostr) {
            start = dna.toUpperCase().indexOf("ATG", start);
            if (start == -1) {
                eostr=true;
                System.out.println("That's all...\n" + count);
                break;
            }
            taa = findStopCodon(dna, start, "taa");
            tag = findStopCodon(dna, start, "tag");
            tga = findStopCodon(dna, start, "tga");
            if ((tag==-1||taa < tag) && (tga==-1||taa < tga) && (taa != -1)) {
                printDNA(dna.substring(start, taa + 3));
                start=taa+3;count++;
                taa=-1;tag=-1;tga=-1;
            } else if ((taa==-1||tag < taa) && (tga==-1||tag < tga) && (tag != -1)) {
                printDNA(dna.substring(start, tag + 3));
                start=tag+3;count++;
                taa=-1;tag=-1;tga=-1;
            } else if ((tag==-1||tga < tag) && (taa==-1||tga < taa) && (tga != -1)) {
                printDNA(dna.substring(start, tga + 3));
                start=tga+3;count++;
                taa=-1;tag=-1;tga=-1;
            } else {
                System.out.println("That's all...\n" + count);
                eostr=true;
            }
        }
    }
    public static void printDNA(String dna){
        for (int i = 0; i < dna.length(); i+=3) {
            System.out.print(""+dna.charAt(i)+dna.charAt(i+1)+dna.charAt(i+2)+" ");
        }
        System.out.println("");
    }
    public static StorageResource getGenes(String dna) {
        StorageResource sr=new StorageResource();
        boolean eostr = false;
        int start = 0;
        int taa = -1;
        int tag = -1;
        int tga = -1;
        while (!eostr) {
            start = dna.toUpperCase().indexOf("ATG", start);
            if (start == -1) {
                eostr=true;
                System.out.println("That's all...\n");
                break;
            }
            taa = findStopCodon(dna, start, "taa");
            tag = findStopCodon(dna, start, "tag");
            tga = findStopCodon(dna, start, "tga");
            if ((tag==-1||taa < tag) && (tga==-1||taa < tga) && (taa != -1)) {
                sr.add(dna.substring(start, taa + 3));
                start=taa+3;
                taa=-1;tag=-1;tga=-1;
            } else if ((taa==-1||tag < taa) && (tga==-1||tag < tga) && (tag != -1)) {
                sr.add(dna.substring(start, tag + 3));
                start=tag+3;
                taa=-1;tag=-1;tga=-1;
            } else if ((tag==-1||tga < tag) && (taa==-1||tga < taa) && (tga != -1)) {
                sr.add(dna.substring(start, tga + 3));
                start=tga+3;
                taa=-1;tag=-1;tga=-1;
            } else {
                eostr=true;
            }
        }
        return sr;
    }
    public static int countGenes(String dna) {
        boolean eostr = false;
        int count=0;
        int start = 0;
        int taa = -1;
        int tag = -1;
        int tga = -1;
        while (!eostr) {
            start = dna.toUpperCase().indexOf("ATG", start);
            if (start == -1) {
                eostr=true;
                System.out.println("That's all...\n");
                break;
            }
            taa = findStopCodon(dna, start, "taa");
            tag = findStopCodon(dna, start, "tag");
            tga = findStopCodon(dna, start, "tga");
            if ((tag==-1||taa < tag) && (tga==-1||taa < tga) && (taa != -1)) {
                start=taa;
                taa=-1;tag=-1;tga=-1;
                count++;
            } else if ((taa==-1||tag < taa) && (tga==-1||tag < tga) && (tag != -1)) {
                start=tag;
                taa=-1;tag=-1;tga=-1;
                count++;
            } else if ((tag==-1||tga < tag) && (taa==-1||tga < taa) && (tga != -1)) {
                start=tga;
                taa=-1;tag=-1;tga=-1;
                count++;
            } else {
                eostr=true;
            }
        }
        return count;
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
