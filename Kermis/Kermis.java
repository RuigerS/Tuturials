package eu.additude.zarchief.Kermis;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Kermis {
    public static LocalTime lastUpdateTime;
    public static LocalTime tijd;
    static private boolean doorgaan;
    public static Attractie[] kermis;
    private static Kassa kassa;
    public static int drukte;

    public static void main(String[] args) {
        lastUpdateTime = LocalTime.now();
        tijd = LocalTime.of(14, 00);
        doorgaan = true;
        Scanner sc = new Scanner(System.in);
        String input = "";
        kermis = new Attractie[6];
        kermis[0] = new BotsAutos();
        kermis[1] = new Spin();
        kermis[2] = new SpiegelPaleis();
        kermis[3] = new SpookHuis();
        kermis[4] = new Hawaii();
        kermis[5] = new LadderKlimmen();
        kassa = new Kassa();
        System.out.println("De kermis gaat open");
        while (doorgaan) {
            kassa.verkoopKaartjes();
            kassa.berekenOmzet(kermis);
            System.out.println("\nHet is nu: " + tijd.format(DateTimeFormatter.ofPattern("HH:mm")) + ". Er zijn " + drukte + " potentiële klanten op de kermis.");
            for (Attractie attrTmp : kermis) {
                attrTmp.showHappeness();
            }
            System.out.println("\nGeef een getal (1-6) om een attractie te draaien, toon aantal verkochte kaartjes (k), toon omzet (o).\n(b) om de belasting te betalen, (m) om de monteur aan de slag te zetten. (q to end) ");
            input = sc.nextLine().toLowerCase();
            if (input.equals("") || input == null) {

            } else if (input.charAt(0) == 'q') {
                doorgaan = false;
            } else if (input.charAt(0) == 'k') {
                showKaartjes();
            } else if (input.charAt(0) == 'm') {
                roepMonteur();
            } else if (input.charAt(0) == 'b') {
                reserveringBelastingOverdragen();
            } else if (input.charAt(0) == 'o') {
                toonOmzet();
            } else if (input.charAt(0) >= '1' && input.charAt(0) <= '6') {
                kermis[(Integer.parseInt(input)) - 1].draai();
            }
        }
    }
static void showKaartjes(){
        kassa.verkoopKaartjes();
        int temp = 0;
        for (Attractie attrTmp : kermis) {
            temp += attrTmp.kaartjesAttractie;
            System.out.println(attrTmp.naamAttractie + " heeft " + attrTmp.kaartjesAttractie + " kaartjes verkocht.");
        }
        System.out.println("Totaal aantal kaartjes = " + temp);
    }
static void roepMonteur(){
    for (Attractie onderhoudCheck : kermis) {
        if (onderhoudCheck instanceof RisicoRijkeAttracties) {
            ((RisicoRijkeAttracties) onderhoudCheck).opstellingsKeuring();
        }
    }
}
static void reserveringBelastingOverdragen(){
    System.out.println("Belasingreservering wordt afgedragen: " + Attractie.reserveringBelasting);
    Attractie.reserveringBelasting = 0;
}
static void toonOmzet(){
    kassa.verkoopKaartjes();
    int temp = 0;
    for (Attractie attrTmp : kermis) {
        attrTmp.berekenNetto();
        temp += attrTmp.omzetAttractieNetto;
        System.out.println(attrTmp.naamAttractie + " heeft " + String.format("%.2f", (float) attrTmp.omzetAttractieNetto / (float) 100) + " netto omzet.");
    }
    System.out.println("Totale netto omzet = " + String.format("%.2f", (float) temp / (float) 100));
    kassa.setOmzetTotaalNetto(temp);
    System.out.println("Reservering kansspelbelasting " + String.format("%.2f", (float) Attractie.reserveringBelasting / (float) 100));
}
}
