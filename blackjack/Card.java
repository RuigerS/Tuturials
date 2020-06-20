package eu.additude.zarchief.blackjack;

public class Card {
    int waardeKaart;
    char kleurKaart;
    char[] kaartKleuren = {'S', 'H', 'R', 'K'};

    Card(int waardeKaart, int kleurKaart) {
        this.waardeKaart = waardeKaart;
        this.kleurKaart = kaartKleuren[kleurKaart];
    }
    void printCard() {
        switch (kleurKaart){
            case 'K':
                System.out.print("Klaver ");
                break;
            case 'H':
                System.out.print("Harten ");
                break;
            case 'R':
                System.out.print("Ruiten ");
                break;
            case 'S':
                System.out.print("Schoppen ");
                break;
        }
        switch (waardeKaart) {
            case 0:
                System.out.print("10");
                break;
            case 1:
                System.out.print("Aas");
                break;
            case 10:
                System.out.print("Boer");
                break;
            case 11:
                System.out.print("Vrouw");
                break;
            case 12:
                System.out.print("Heer");
                break;
            default:
                System.out.print(waardeKaart);
        }
    }
}
