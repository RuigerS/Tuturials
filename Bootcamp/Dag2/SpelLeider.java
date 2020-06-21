import java.io.*;
import java.util.Random;


public class SpelLeider {
    private String geheimWoord;
    private String[] woorden = { "eendeei", "galgje", "poetsbeurt", "fietsbel", "sambal",
    "verzenden", "liquiditeitsvoorkeurtheorie", "overzichtelijkshalve", "jazz", "score",
    "etui", "cactus", "liquidatie", "oase", "junior", "curry", "acryl", "quinoa", "cavia",
    "uier", "giga", "ijstijd", "cacao", "stuk", "nihil", "zuivel", "quote", "sopraan", "dak",
    "kwik", "flirt", "twijg", "nieuw", "klacht", "cruciaal", "winnaar", "ontzeggen" };
    
    public void setGeheimWoord(){
        Random rand = new Random();
        geheimWoord = woorden[rand.nextInt(woorden.length)];
    }
    public int getGeheimWoord(){
        return geheimWoord.length();
    }

      
    public void SpelLeider(){
    }

}

