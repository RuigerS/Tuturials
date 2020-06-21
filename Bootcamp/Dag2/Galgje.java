import java.io.*;
import java.util.Scanner;
import java.util.Random;


public class Galgje {
    static Scanner sc = new Scanner(System.in);
    static String input;
    static Bord bord;
    static boolean klaar;
    static String[] woorden = { "eendeei", "galgje", "poetsbeurt", "fietsbel", "sambal",
"verzenden", "liquiditeitsvoorkeurtheorie", "overzichtelijkshalve", "jazz", "score",
"etui", "cactus", "liquidatie", "oase", "junior", "curry", "acryl", "quinoa", "cavia",
"uier", "giga", "ijstijd", "cacao", "stuk", "nihil", "zuivel", "quote", "sopraan", "dak",
"kwik", "flirt", "twijg", "nieuw", "klacht", "cruciaal", "winnaar", "ontzeggen" };
    static Random rand = new Random();
    static String geheimWoord;
    
    public static void main(String[] args) {
        initialiseer();
        while (!klaar) {
            // begin beurt
            presenteer();
            // Scan input
            System.out.print("Welke letter wil je hebben: ");
            input = sc.nextLine();
            input = input.toLowerCase();
            // verwerk input
            verwerk();
            // check gewonnen?
            klaar = true; // niet fail-safe 
            for (int i = 0; i < geheimWoord.length(); i++) {
                if (bord.getLetterPoging((char)(geheimWoord.charAt(i) - 97)) == '*') {
                    klaar = false;
                }
            }
            if (klaar) {
                System.out.println("Gefeliciteerd!!! Het woord was " + geheimWoord + "!!!");
            } else if (bord.getKansen() < 1) {
                System.out.println("Helaas, de kansen zijn op...\n\nHet woord was " + geheimWoord + ".");
                klaar = true;
            }
        }
    }

    public static void initialiseer() {
        // Initialisatie nieuw spel
        klaar = false;
        // kies nieuw woord
        geheimWoord = woorden[rand.nextInt(woorden.length)];
        bord = new Bord(geheimWoord);
        
    }

    public static void presenteer() {
        // print status
        String woordPresentatie = ""; 
       for (int i = 0; i < geheimWoord.length(); i++) {
        woordPresentatie += (char) (bord.getLetterPoging((char)(geheimWoord.charAt(i) - 97)));
       }
       bord.setWoordPresentatie(woordPresentatie);
        System.out.println("\n\nHet te raden woord: " + bord.getWoordPresentatie());
        System.out.println("Aantal resterende kansen: " + bord.getKansen());
        System.out.print("Gepoogde letters: ");
        boolean gevonden = false;
        for (int i = 0; i<26;i++) {
            if (bord.getLetterPoging((char)i) > (char)42) {
                gevonden = true;
                System.out.print(bord.getLetterPoging((char)i));
            }
        }
        if (!gevonden) {
            System.out.println("Geen");
        } else {
            System.out.println(" ");
        }
    }

    public static void verwerk() {
        // verwerk input
        bord.setKansen(-1);
        if (input.charAt(0) < 97 || input.charAt(0) > 122) {
            System.out.println("De invoer " + input.charAt(0) + " is geen letter van a-z. Kans kwijt.");
        } else {
            if (bord.getLetterPoging((char)(input.charAt(0) - 97)) == '*') {
                // nieuwe letter opgegeven
                bord.setLetterPoging((char)(input.charAt(0)));
                // Als letter er in zat extra kans!!
                boolean gevonden = false;
                for (int i = 0; i < geheimWoord.length(); i++) {
                    if (geheimWoord.charAt(i) == input.charAt(0)) {
                        gevonden = true;
                    }
                }
                if (gevonden) {
                    System.out.println(input.charAt(0) + " is gevonden!");
                    bord.setKansen(1);
                } else {
                    System.out.println(input.charAt(0) + " zit er niet in...");
                }
            } else {
                System.out.println("De letter " + input.charAt(0) + " was al geraden. Kans kwijt.");
            }
        }
    }

}