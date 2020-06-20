package eu.additude.zarchief.los;

public class Zwembaden {
    static int aantalbaden=6;
    public static void main(String[] args) {
        int aantalbaden=7;
        System.out.println(Zwembaden.aantalbaden+ " "+ aantalbaden);
        Zwembad merwestein = new Zwembad();
        Zwembad dompelaar = new Zwembad();
        merwestein.naamBad="Merwestein";
        dompelaar.naamBad="Dompelaar";
        System.out.println(merwestein.naamBad);
        System.out.println(dompelaar.naamBad);
        System.out.println(merwestein);
        System.out.println(dompelaar);
        Zwembad zwemBadDrie = merwestein;
        zwemBadDrie.naamBad = "Zwembad drie";
        System.out.println(merwestein.naamBad);
        boolean b1=true;
        boolean b2=false;
        System.out.println(b1 ^ b2);
    }
}

class Zwembad{
    String naamBad;
    }

