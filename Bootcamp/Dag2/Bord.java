import java.io.*;

public class Bord {
    private String woordPresentatie;
    private int kansen;
    private char letterPoging[] = new char[26];
    
    public String getWoordPresentatie(){
        return woordPresentatie;
    }
    public void setWoordPresentatie(String nieuwePresentatie){
        this.woordPresentatie=nieuwePresentatie;
    }
    
    public int getKansen(){
        return kansen;
    }
    public void setKansen(int aantal){
        this.kansen+=aantal;
    }
    
    public char getLetterPoging(char i){
        return letterPoging[i];        
    }
    public void setLetterPoging(char invoer){
        letterPoging[invoer-97]=invoer;
    }

    public Bord(String geheimWoord) {
        kansen=10;
        woordPresentatie = "";
        for (int i = 0; i < geheimWoord.length(); i++) {
            woordPresentatie += "*";
        }
        // zet letterpogingen & kansen op nul
        for (int i = 0; i < letterPoging.length; i++) {
            letterPoging[i] = (char) (42);
        }

    }
}
