package nl.firstact;

public class Part3 {
    public static void main(String[] args) {
       testing();
    }

    public static boolean twoOccurences(String stringa,String stringb){
        if(stringb.indexOf(stringa)>-1){
            if(stringb.indexOf(stringa,stringb.indexOf(stringa)+1)>-1){
                return true;
            }
        }
        return false;
    }

    public static String lastPart(String stringa,String stringb){
        int indexFound=stringb.indexOf(stringa);
        if(indexFound==-1){
            return stringb;
        }
        return stringb.substring(stringb.indexOf(stringa)+stringa.length());
    }


    public static void testing() {
        System.out.println(twoOccurences("by", "A story by Abby Long"));
        System.out.println(twoOccurences("a", "Banana"));
        System.out.println(twoOccurences("a", "aa"));
        System.out.println(twoOccurences("atg", "ctgatgta"));
        System.out.println(lastPart("by", "A story by Abby Long"));
        System.out.println(lastPart("a", "Banana"));
        System.out.println(lastPart("a", "aa"));
        System.out.println(lastPart("atg", "ctgatgta"));
        System.out.println(lastPart("zoo", "forest"));
    }
}
