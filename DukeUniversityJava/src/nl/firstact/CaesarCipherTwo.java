package nl.firstact;

public class CaesarCipherTwo {
//    private String alphabet;
//    private String shiftedAlphabet1;
//    private int key1;
//    private String shiftedAlphabet2;
//    private int key2;
    CaesarCipher cc1;
    CaesarCipher cc2;

    public CaesarCipherTwo(int key1,int key2){
//        alphabet="abcdefghijklmnopqrstuvwxyz";
//        shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
//        this.key1=key1;
//        shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
//        this.key2=key2;
        cc1=new CaesarCipher(key1);
        cc2=new CaesarCipher(key2);
    }

    public String encrypt(String input){
        String even=cc1.encrypt(input);
        String uneven=cc2.encrypt(input);
        StringBuilder sb=new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            if(i%2==0){
                sb.setCharAt(i,even.charAt(i));
            }else{
                sb.setCharAt(i,uneven.charAt(i));
            }
        }
        return sb.toString();
    }

    public String halfOfString(String message, int start) {
        String result = "";
        for (int i = start; i < message.length(); i += 2) {
            result += message.charAt(i);
        }
        return result;
    }

    public String decrypt(String encrypted) {
        String part1 = halfOfString(encrypted, 0);
        String part2 = halfOfString(encrypted, 1);
        part1 = cc1.decrypt(part1);
        part2 = cc2.decrypt(part2);
        String result = "";
        for (int i = 0; i < encrypted.length(); i++) {
            if (i % 2 == 0) {
                result += part1.charAt(i / 2);
            }
            if (i % 2 == 1) {
                result += part2.charAt(i / 2);
            }
        }
        return result;
    }
}
