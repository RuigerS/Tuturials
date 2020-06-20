package eu.additude.zarchief.blackjack;

import java.util.Scanner;

public class Speler {
    Hand kaartenInHand;
    boolean gepast = false;
    boolean gedubbeltje = false;
    Scanner inputKB = new Scanner(System.in);
    String input;

    Speler() {
        kaartenInHand = new Hand();
    }
    char getInput(int question) {
        boolean validResponse = false;
        System.out.print("Wat wil je: ");
        if ((question & 0b00001) > 0) {
            System.out.print("k = kaart, ");
        }
        if ((question & 0b00010) > 0) {
            System.out.print("p = passen, ");
        }
        if ((question & 0b00100) > 0) {
            System.out.print("n = nieuw, ");
        }
//        if ((question & 0b01000) > 0) {
//            System.out.print("s = splitsen, ");
//        }
        if ((question & 0b10000) > 0) {
            System.out.print("d = dubbelen, ");
        }
        System.out.print("q = stoppen: ");
        while (!validResponse) {
            input = inputKB.nextLine();
            input = input.toLowerCase();
            if (input.charAt(0) == 'k' && (question & 0b0001) > 0 || input.charAt(0) == 'p' && (question & 0b0010) > 0 ||
                    input.charAt(0) == 'n' && (question & 0b0100) > 0 || input.charAt(0) == 'd' && (question & 0b10000) > 0 ||
                    input.charAt(0) == 'q') {
                validResponse = true;
            } else System.out.print("Ik snap dat het lastig is, probeer het nog eens.");
        }
        System.out.println("\n");
        return input.charAt(0);
    }
}