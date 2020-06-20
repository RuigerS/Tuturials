package eu.additude.zarchief.los;

public class BomenBos {
    public static void main(String[] args) {
        // Opdracht: zet deze code om naar een ternary.
        // Uiteraard prima te testen door aantalBomen/oppvl te variëren
        int aantalBomen = 200;
        int oppervlakte = 500;
        String soortBos = "Geen Bos";
        if (aantalBomen > 20)
            if (aantalBomen > 100)
                if (oppervlakte > 100)
                    soortBos = "Groot Bos";
                else
                    soortBos = "Compact Bos";
            else
                soortBos = "Klein Bos";
        System.out.println("We zijn nu buiten het if statement!! " + soortBos);
        String N42 = aantalBomen>20? aantalBomen>100? oppervlakte>100? "Groot Bos":"Compact Bos":"Klein Bos":"Geen Bos";
        System.out.println("We zijn nu buiten het ternary statement!! " + N42);


    }
}

