public class Test1 {
    public static void main(String[] args) {
        System.out.println(mystery("kjhfddjkshfjk;sdhfljhasdfhasdjkf"));
        System.out.println(mystery("kjThftddjkshfjk;sdhfljhasdfhasdjkf"));
        System.out.println(mystery("kjhftddTtjkshfjkT;sdhfljhasdfhasdjktf"));
        System.out.println(mystery("kjhfddjkshfjk;sdhfljhasdfhasdjkf"));
        System.out.println(mystery("kTkf"));
        System.out.println(mystery("kTTTkf"));
        System.out.println(mystery("kTTTTTTTTkf"));
    }
    public static String mystery(String dna) {
        int pos = dna.indexOf("T");
        int count = 0;
        int startPos = 0;
        String newDna = "";
        if (pos == -1) {
            return dna;
        }
        while (count < 3) {
            count += 1;
            newDna = newDna + dna.substring(startPos,pos);
            startPos = pos+1;
            pos = dna.indexOf("T", startPos);
            if (pos == -1) {
                break;
            }
        }
        newDna = newDna + dna.substring(startPos);
        return newDna;
    }
}
