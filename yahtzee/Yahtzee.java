package eu.additude.zarchief.yahtzee;

import java.util.Scanner;

public class Yahtzee {
    private static boolean stop = false;

    public static void main(String[] args) {
        while (!stop) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welkom bij Yahtzee!");
            System.out.println("Hoeveel spelers wil je starten? 1-4, q=quit");
            String respons = sc.nextLine();
            if (respons.charAt(0) == 'q') {
                break;
            }
            if (respons.charAt(0) == '1' | respons.charAt(0) == '2' | respons.charAt(0) == '3' | respons.charAt(0) == '4') {
                YahtzeeSpel yahtzeeSpel = new YahtzeeSpel(respons.charAt(0) - 48);
                continue;
            }
            System.out.println("Jammer, best moeilijk, snap ik");
        }
    }

    public static void endgame() {
        stop = true;
    }
}
