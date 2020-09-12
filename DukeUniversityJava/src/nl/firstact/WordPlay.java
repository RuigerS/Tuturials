package nl.firstact;

public class WordPlay {

    public static void main(String[] args) {
	//test
        System.out.println(isVowel('F'));
        System.out.println(isVowel('a'));
        System.out.println(replaceVowels("Hello World",'*'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));

    }
    public static boolean isVowel(Character ch){
        return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' ||
                ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U';
    }
    public static String replaceVowels(String phrase, char ch){
        StringBuilder sb=new StringBuilder(phrase);
        for (int i = 0; i < sb.length(); i++) {
            if(isVowel(sb.charAt(i))){
                sb.setCharAt(i,ch);
            }
        }
        return sb.toString();
    }
    public static String emphasize(String phrase,Character ch){
        StringBuilder sb=new StringBuilder(phrase);
        for (int i = 0; i < sb.length(); i++) {
            if((Character.toLowerCase(sb.charAt(i)))==(Character.toLowerCase(ch))){
                if((i+1)%2==0){
                    sb.setCharAt(i,'+');
                }else{
                    sb.setCharAt(i,'*');
                }
            }
        }
        return sb.toString();
    }
}
