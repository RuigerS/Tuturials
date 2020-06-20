package eu.additude.zarchief.yahtzee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class YahtzeeSpel {
    private int aantalSpelers;
    private Speler[] speler;
    private List<Dobbelsteen> dobbelstenen;
    private Integer blokkeerArray;
    private Worp worp;
    private boolean spelDoorGaan;

    YahtzeeSpel(int spelers) {
        aantalSpelers = spelers;
        spelDoorGaan = true;
        speler = new Speler[aantalSpelers];
        for (int i = 0; i < spelers; i++) {
            speler[i] = new Speler(i + 1);
        }
        dobbelstenen = new ArrayList<Dobbelsteen>();
        worp = new Worp();
        Dobbelsteen dbs;
        for (int i = 0; i < 5; i++) {
            dbs = new Dobbelsteen();
            dbs.werpen();
            dobbelstenen.add(dbs);
        }
        spelen();
    }

    private void spelen() {
        for (int t = 0; t < 13; t++) {

            for (int i = 1; i <= aantalSpelers; i++) {
                werp1();
                speler[i - 1].printScore();
                showWorp1log(i);
                vastHouden();
                if (!spelDoorGaan) {
                    return;
                }
                for (int j = 1, k = 0; j < 17; j *= 2, k++) {
                    if ((blokkeerArray & j) == 0) {
                        dobbelstenen.get(k).werpen();
                        worp.items[k] = dobbelstenen.get(k).getOgen();
                    }
                }
                showWorp2log(i);
                speler[i - 1].printScore();
                keuzeScore(i - 1);
            }
        }
        //Spel voorbij
        for (int i = 1; i <= aantalSpelers; i++) {
            speler[i - 1].printScore();
        }
    }

    private void werp1() {
        int teller = 0;
        for (Dobbelsteen dbs : dobbelstenen) {
            dbs.werpen();
            worp.items[teller++] = dbs.getOgen();
        }
    }

    private void showWorp1log(int spelerAanDeBeurt) {
        System.out.println("Speler: " + spelerAanDeBeurt);
        System.out.println("WORP1");
        System.out.println("1 2 3 4 5");
        for (Dobbelsteen dbs : dobbelstenen) {
            System.out.print(dbs.getOgen() + " ");
        }
        System.out.println("");
    }

    private void showWorp2log(int spelerAanDeBeurt) {
        System.out.println("WORP2");
        System.out.println("1 2 3 4 5");
        for (Dobbelsteen dbs : dobbelstenen) {
            System.out.print(dbs.getOgen() + " ");
        }
        speler[(spelerAanDeBeurt - 1)].setWorp(worp);
        System.out.println("");
        System.out.println("");
    }

    private void vastHouden() {
        System.out.println("Welke posities wilt u vasthouden? 0 voor geen anders bv 124 (q=quit)");
        Scanner sc = new Scanner(System.in);
        String respons = sc.nextLine();
        if (respons.equals("")) {
            respons = "0";
        }
        if (respons.toLowerCase().charAt(0) == 'q') {
            spelDoorGaan = false;
            Yahtzee.endgame();
            return;
        }
        blokkeerArray = 0;
        for (int i = 0; i < respons.length(); i++) {
            blokkeerArray += convertDecBlokkade(Integer.parseInt(respons.substring(i, i + 1)));
        }
    }

    private int convertDecBlokkade(Integer toConvert) {
        int retValue = 1;
        for (int i = 0; i < toConvert; i++) {
            retValue *= 2;
        }
        return (retValue / 2);
    }

    private void keuzeScore(int spelerNR) {
        boolean validChoice = false;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Waar wil je de score noteren (1-13)? (q=quit)");
        while (!validChoice) {
            String respons = sc.nextLine();
            if (respons.equals("")) {
                respons = "0";
            }
            if (respons.toLowerCase().charAt(0) == 'q') {
                spelDoorGaan = false;
                Yahtzee.endgame();
                return;
            }
            choice = Integer.parseInt(respons);
            validChoice = speler[spelerNR].kiesScore(choice, worp);
        }
    }
}
