package eu.additude.zarchief.blackjack;
import java.util.Random;
import java.util.ArrayList;

public class StackOfCards {
    ArrayList<Card> stackOfCards = new ArrayList<Card>();
    Random rand = new Random();

    StackOfCards() {
        System.out.println("Een nieuw kaartspel maken");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                stackOfCards.add(i * j + j, new Card(j, i));
            }
        }
    }
    void printDeStack() {
        int teller = 1;
        for (Card i : stackOfCards) {
            i.printCard();
            System.out.print(", ");
            if (teller >= 8) {
                System.out.println(" ");
                teller = 0;
            }
            teller++;
        }
        System.out.print("\n");
    }
    void kaartSpelSchudden(int aantalKeerSchudden, int aantalKeerPikeren) {
        Card shuffleCard = new Card('a', 0);
        System.out.println("De kaarten worden " + aantalKeerPikeren + " keer gepikeerd (couperen; cut)...");
        for (int i = 0; i < aantalKeerPikeren; i++) {
            int pikeerPunt = rand.nextInt(42) + 5;
            for (int j = 0; j < pikeerPunt; j++) {
                shuffleCard = stackOfCards.get(51);
                stackOfCards.remove(51);
                stackOfCards.add(0, shuffleCard);
            }
        }
        System.out.println("De kaarten worden " + aantalKeerSchudden + " keer gewassen (schudden; riffle shuffle)...");
        for (int i = 0; i < aantalKeerSchudden; i++) {
            for (int j = 0; j < 51; j += 2) {
                shuffleCard = stackOfCards.get(j);
                stackOfCards.remove(j);
                stackOfCards.add(0, shuffleCard);
            }
        }
    }
    Card pakNieuweKaart(){
        Card card;
        card=stackOfCards.get(0);
        stackOfCards.remove(0);
        return card;
    }
}