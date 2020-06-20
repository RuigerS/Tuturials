package eu.additude.zarchief.blackjack;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> handOfCards;
    boolean dood;
    byte hasAce;
    boolean blackjack;
    int waarde;
    int waarde2;

    Hand() {
        handOfCards = new ArrayList<Card>();
        blackjack=false;
        hasAce=0;
        dood=false;
    }
    int bepaalWaardeHand() {
        waarde = 0;
        waarde2=0;
        for (Card i : handOfCards) {
            if (i.waardeKaart == 0 | i.waardeKaart == 10 | i.waardeKaart == 11 | i.waardeKaart == 12) {
                waarde += 10;
            } else if (i.waardeKaart == 1) {
                waarde += 11;
                hasAce++;
            } else waarde += i.waardeKaart;
        }
        if (hasAce>0){
            waarde2=waarde-10;
        }
        if ((handOfCards.size()==2)  && waarde==21){
            blackjack=true;
        }
        if(waarde>21){
            if (waarde2>21){
                dood=true;
                waarde=waarde2;
            }
            else if(hasAce<1){
                dood=true;
            }
            else if(waarde2>0){
                waarde=waarde2;
                waarde2=0;
            }
        }
        return waarde;
    }
}