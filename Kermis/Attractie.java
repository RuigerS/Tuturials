package eu.additude.zarchief.Kermis;

public class Attractie {
    int nummerAttractie;
    String naamAttractie;
    int kaartjesAttractie;
    int prijsAttractie;
    int omzetAttractieNetto;
    int omzetAttractieBruto;
    int oppervlakteM2;
    int zitPlaatsen;
    int wachtenden;
    static int reserveringBelasting;

    Attractie() {
        omzetAttractieBruto = 0;
        omzetAttractieNetto = 0;
        kaartjesAttractie = 0;
        wachtenden = 0;
    }

    void berekenNetto() {
            omzetAttractieNetto += omzetAttractieBruto;
            omzetAttractieBruto = 0;
    }

    void showHappeness() {
        System.out.print(nummerAttractie + ": " + naamAttractie + ", " + wachtenden + " wachtenden  (zitplaatsen: " + zitPlaatsen);
        System.out.println("). ");
    }

    void draai() {
        System.out.print("De attractie draait: " + naamAttractie + ". ");
        if (wachtenden < zitPlaatsen) {
            System.out.println(wachtenden + " mensen met een kaartje worden bediend. Er is geen rij meer.");
            wachtenden = 0;
        } else {
            wachtenden -= zitPlaatsen;
            System.out.println(zitPlaatsen + " mensen met een kaartje worden bediend. Er staan nog " + wachtenden + " mensen in de rij.");
        }
    }

    void koopKaartje() {
        omzetAttractieBruto += prijsAttractie;
        kaartjesAttractie++;
        wachtenden++;
    }
}


