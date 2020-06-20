package eu.additude.zarchief.Kermis;

abstract class RisicoRijkeAttracties extends Attractie {
    int draailimiet;

    abstract void opstellingsKeuring();

    void draai() {
        try {
            veiligheidVoorAlles();
        } catch (OnderhoudException e) {
            System.out.println("Exception: Verplicht onderhoud nodig!!!");
            return;
        }
        draailimiet--;
        System.out.print("De attractie draait: " + naamAttractie + ". ");
        if (wachtenden < zitPlaatsen) {
            System.out.println(wachtenden + " mensen met een kaartje worden bediend. Er is geen rij meer.");
            wachtenden = 0;
        } else {
            wachtenden -= zitPlaatsen;
            System.out.println(zitPlaatsen + " mensen met een kaartje worden bediend. Er staan nog " + wachtenden + " mensen in de rij.");
        }
        System.out.println("Let op: nog " + draailimiet + " keer voor verplicht onderhoud.");

    }

    boolean veiligheidVoorAlles() throws OnderhoudException {
        if (draailimiet <= 0) {
            throw new OnderhoudException("Verplicht onderhoud nodig.");
        }
        return true;
    }

    class OnderhoudException extends Exception {
        public OnderhoudException(String message) {
            super(message);
        }
    }
}
