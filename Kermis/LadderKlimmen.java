package eu.additude.zarchief.Kermis;

class LadderKlimmen extends Attractie implements GokAttractie {
    LadderKlimmen() {
        nummerAttractie = 6;
        naamAttractie = "Ladderklimmen";
        prijsAttractie = 500;
        zitPlaatsen = 4;
    }

    public void berekenNetto() {
        int reservering = berekenReservering(omzetAttractieBruto);
        omzetAttractieNetto += omzetAttractieBruto - reservering;
        reserveringBelasting += reservering;
        omzetAttractieBruto = 0;
    }
}
