package eu.additude.zarchief.Kermis;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

class Kassa {
    private int omzetTotaalNetto;
    private int omzetTotaalBruto;

    void setOmzetTotaalNetto(int omzetTotaalNetto){
        this.omzetTotaalNetto=omzetTotaalNetto;
    }

    void berekenOmzet(Attractie[] arr) {
        omzetTotaalNetto = 0;
        omzetTotaalBruto = 0;
        for (Attractie attr : arr) {
            omzetTotaalNetto += attr.omzetAttractieNetto;
            omzetTotaalBruto += attr.omzetAttractieBruto;
        }
    }
    void verkoopKaartjes() {
        LocalTime nu = LocalTime.now();
        Duration interval = Duration.between(Kermis.lastUpdateTime, nu);
        Kermis.lastUpdateTime = nu;
        long tijdVerstreken = interval.getSeconds();
        //pas de tijd aan
        Kermis.tijd = Kermis.tijd.plusMinutes(tijdVerstreken);
        //aantal kaartjes verkopen
        Random rand = new Random();
        Kermis.drukte = 0;
        if (Kermis.tijd.getHour() < 19 & Kermis.tijd.getHour() > 13) {
            Kermis.drukte = (Kermis.tijd.getHour() - 13) * 60;
        } else if (Kermis.tijd.getHour() < 22 & Kermis.tijd.getHour() > 13) {
            Kermis.drukte = 360;
        } else {
            Kermis.drukte = 0;
        }
        for (int i = 0; i < ((Kermis.drukte * tijdVerstreken) / 100); i++) {
            Kermis.kermis[rand.nextInt(6)].koopKaartje();
        }

    }
}
