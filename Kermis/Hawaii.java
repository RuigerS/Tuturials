package eu.additude.zarchief.Kermis;

class Hawaii extends RisicoRijkeAttracties {
    Hawaii() {
        nummerAttractie = 5;
        naamAttractie = "Hawaii";
        prijsAttractie = 290;
        zitPlaatsen = 12;
        draailimiet=0;
    }
    @Override
    void opstellingsKeuring() {
        //check all things and repair
        draailimiet=10;
        System.out.println("De Hawaii is gekeurd en mag weer 10 keer draaien.");
    }
}
