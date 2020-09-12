package nl.firstact;

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int key;

    public CaesarCipher(int key){
        alphabet="abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        this.key=key;
    }

    public String encrypt(String input){
        StringBuilder sb=new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            if(Character.isLetter(sb.charAt(i))){
                if(Character.isUpperCase(sb.charAt(i))){
                    sb.setCharAt(i,Character.toUpperCase(shiftedAlphabet.charAt(alphabet.indexOf(Character.toLowerCase(sb.charAt(i))))));
                }else{
                    sb.setCharAt(i,shiftedAlphabet.charAt(alphabet.indexOf(Character.toLowerCase(sb.charAt(i)))));
                }
            }
        }
        return sb.toString();
    }

    public String decrypt(String s) {
        CaesarCipher cc= new CaesarCipher(26-key);
        return cc.encrypt(s);
    }
}
