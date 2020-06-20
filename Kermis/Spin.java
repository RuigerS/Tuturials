package eu.additude.zarchief.Kermis;

class Spin extends RisicoRijkeAttracties implements GokAttractie {
    Spin() {
        nummerAttractie = 2;
        naamAttractie = "Spin";
        prijsAttractie = 225;
        zitPlaatsen = 16;
        draailimiet=0;
    }

    @Override
    void opstellingsKeuring() {
        //check all things and repair
        draailimiet=5;
        System.out.println("De Spin is gekeurd en mag weer 5 keer draaien.");
    }

    public void berekenNetto() {
        int reservering = berekenReservering(omzetAttractieBruto);
        omzetAttractieNetto += omzetAttractieBruto - reservering;
        reserveringBelasting += reservering;
        omzetAttractieBruto = 0;
    }
}
