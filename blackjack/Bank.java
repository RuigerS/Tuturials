package eu.additude.zarchief.blackjack;

import java.io.FileNotFoundException;
import java.util.Random;

public class Bank {
    Random rand;
    StackOfCards kaartspel;
    Hand bankHand;
    Speler speler;

    public Bank() {
        rand = new Random();
        kaartspel = new StackOfCards();
        kaartspel.kaartSpelSchudden(rand.nextInt(24) + 8, rand.nextInt(3) + 1);
        kaartspel.printDeStack();
        System.out.println("\n");
        speler = new Speler();
        deelKaart(speler.kaartenInHand);
        deelKaart(speler.kaartenInHand);
        speler.kaartenInHand.bepaalWaardeHand();
        bankHand = new Hand();
        deelKaart(bankHand);
        deelKaart(bankHand);
        bankHand.bepaalWaardeHand();
        Blackjack.inzetten();
        System.out.println("Je inzet is $10. Je saldo is nu $" + Blackjack.getSaldo());
        checkForBlackjack();
    }
    void toonStatus() {
        System.out.print("\nDe bank toont 1 open kaart: ");
        Card card = bankHand.handOfCards.get(1);
        card.printCard();
        System.out.println("\nJe hebt zelf de volgende kaarten:");
        for (Card i : speler.kaartenInHand.handOfCards) {
            i.printCard();
            System.out.print("  ");
        }
        System.out.print("\nDe waarde hiervan is: ");
        speler.kaartenInHand.bepaalWaardeHand();
        if (speler.kaartenInHand.waarde2 > 0) {
            if(speler.kaartenInHand.waarde2<22) {
                System.out.print(speler.kaartenInHand.waarde2 + " of ");
            }
        }
        System.out.println(speler.kaartenInHand.waarde);
    }
    void checkForBlackjack() {
        if ((bankHand.blackjack) && (speler.kaartenInHand.blackjack)) {
            System.out.print("\nDe bank toont 1 open kaart: ");
            bankHand.handOfCards.get(1).printCard();
            System.out.println("\nJe hebt zelf de volgende kaarten:");
            for (Card i : speler.kaartenInHand.handOfCards) {
                i.printCard();
                System.out.print("  ");
            }
            System.out.print("\nDe waarde hiervan is: ");
            System.out.println(speler.kaartenInHand.bepaalWaardeHand());
            System.out.print(" BLACKJACK!!\nDe bank controleert haar hand: ");
            bankHand.handOfCards.get(0).printCard();
            System.out.println("!\nDe bank heeft ook BLACKJACK! gelijkspel; je krijgt je inzet terug ($10), nieuw saldo: $");
            Blackjack.setSaldo(10);
            System.out.println(Blackjack.getSaldo());
            Blackjack.stopGame = true;
            switch (speler.getInput(0b0100)) {
                case 'q':
                    Blackjack.stopPlay = true;
                    System.out.println("Zwaaizwaai");
                    break;
                default:
                    break;
            }
        } else if (bankHand.blackjack) {
            System.out.print("\nDe bank toont 1 open kaart: ");
            bankHand.handOfCards.get(1).printCard();
            System.out.println("\nJe hebt zelf de volgende kaarten:");
            for (Card i : speler.kaartenInHand.handOfCards) {
                i.printCard();
                System.out.print("  ");
            }
            System.out.print("\nDe waarde hiervan is: ");
            System.out.println(speler.kaartenInHand.bepaalWaardeHand());
            System.out.print("\nDe bank controleert haar hand: ");
            bankHand.handOfCards.get(0).printCard();
            System.out.println("!\nDe bank wint door Blackjack! Je verliest je inzet");
            Blackjack.stopGame = true;
            switch (speler.getInput(0b0100)) {
                case 'q':
                    Blackjack.stopPlay = true;
                    System.out.println("Zwaaizwaai");
                    break;
                default:
                    break;
            }
        } else if (speler.kaartenInHand.blackjack) {
            System.out.print("\nDe bank toont 1 open kaart: ");
            bankHand.handOfCards.get(1).printCard();
            System.out.println("\nJe hebt zelf de volgende kaarten:");
            for (Card i : speler.kaartenInHand.handOfCards) {
                i.printCard();
                System.out.print("  ");
            }
            System.out.print("\nBlackjack! Je wint 2,5 keer je inzet: $25, nieuw saldo: $");
            Blackjack.setSaldo(25);
            System.out.println(Blackjack.getSaldo());
            Blackjack.stopGame = true;
            switch (speler.getInput(0b0100)) {
                case 'q':
                    Blackjack.stopPlay = true;
                    System.out.println("Zwaaizwaai");
                    break;
                default:
                    break;
            }
        }
    }
    void deelKaart(Hand hand) {
        hand.handOfCards.add(kaartspel.pakNieuweKaart());
    }
    void playerTurn() {
        boolean playerKlaar = false;
        while (!playerKlaar) {
            toonStatus();
            if (speler.kaartenInHand.dood) {
                System.out.println("Je bent dood. Je bent je inzet kwijt.");
                playerKlaar = true;
                Blackjack.stopGame = true;
                afronding();
            } else {
                char userSaysWhat;
                if(speler.kaartenInHand.handOfCards.size()<3 && Blackjack.getSaldo()>=10){
                    userSaysWhat=speler.getInput(0b10111);
                }else{
                    userSaysWhat=speler.getInput(0b00111);
                }
                switch (userSaysWhat) {
                    case 'q':
                        Blackjack.stopGame = true;
                        Blackjack.stopPlay = true;
                        playerKlaar = true;
                        System.out.println("Zwaai zwaai.");
                        break;
                    case 'k':
                        deelKaart(speler.kaartenInHand);
                        System.out.println("Je krijgt een extra kaart van de bank.");
                        break;
                    case 'p':
                        speler.gepast = true;
                        playerKlaar = true;
                        System.out.println("Je hebt gepast.");
                        break;
                    case 'd':
                        System.out.println("Dubbelen: je krijgt nog één extra kaart van de bank, en je verdubbelt je inzet.");
                        deelKaart(speler.kaartenInHand);
                        Blackjack.inzetten();
                        System.out.println("Je extra inzet is $10. Je saldo is nu $" + Blackjack.getSaldo());
                        speler.gedubbeltje=true;
                        speler.gepast = true;
                        playerKlaar = true;
                        System.out.println("Je hebt nu de volgende drie kaarten:");
                        for (Card i : speler.kaartenInHand.handOfCards) {
                            i.printCard();
                            System.out.print("  ");
                        }
                        System.out.print("\nDe waarde hiervan is: ");
                        System.out.println(speler.kaartenInHand.bepaalWaardeHand());
                        System.out.println("Je hebt gedubbeld en gepast.");
                        break;
                    case 'n':
                        Blackjack.stopGame = true;
                        playerKlaar = true;
                        System.out.println("Opnieuw delen.");
                        break;
                    default:
                        break;
                }
            }
        }
    }
    void bankTurn() {
        System.out.print("De bank heeft: ");
        for (Card i : bankHand.handOfCards) {
            i.printCard();
            System.out.print("  ");
        }
        System.out.println("\nWaarde: " + bankHand.bepaalWaardeHand());
        //asks cards while waarde < 17
        while (bankHand.bepaalWaardeHand() < 17) {
            deelKaart(bankHand);
            System.out.print("Verplichte kaart voor de bank (want minder dan 17). De bank heeft nu: ");
            for (Card i : bankHand.handOfCards) {
                i.printCard();
                System.out.print("  ");
            }
            System.out.println("\nWaarde: " + bankHand.bepaalWaardeHand());
        }

    }
    void afronding() {
        if (speler.kaartenInHand.dood) {
            System.out.println(" ");
        } else if (bankHand.dood) {
            System.out.print("\nBank verliest (dood); je krijgt 2 keer je inzet: $20, nieuw saldo: $");
            Blackjack.setSaldo(20);
            System.out.println(Blackjack.getSaldo());
            if(speler.gedubbeltje){
                System.out.print("en omdat je gedubbeld hebt: $20 extra, nieuw saldo: $");
                Blackjack.setSaldo(20);
                System.out.println(Blackjack.getSaldo());
            }
        } else if (bankHand.bepaalWaardeHand() < speler.kaartenInHand.bepaalWaardeHand()) {
            System.out.print("\nBank verliest op punten; je krijgt 2 keer je inzet: $20, nieuw saldo: $");
            Blackjack.setSaldo(20);
            System.out.println(Blackjack.getSaldo());
            if(speler.gedubbeltje){
                System.out.print("en omdat je gedubbeld hebt: $20 extra, nieuw saldo: $");
                Blackjack.setSaldo(20);
                System.out.println(Blackjack.getSaldo());
            }
        } else if (bankHand.bepaalWaardeHand() > speler.kaartenInHand.bepaalWaardeHand()) {
            System.out.println("\nBank wint op punten; je verliest je inzet. ");
        } else if (bankHand.bepaalWaardeHand() == speler.kaartenInHand.bepaalWaardeHand()) {
            System.out.print("\nBank en speler evenveel punten: stand-off, je krijgt je inzet terug ($10), je nieuwe saldo is $");
            Blackjack.setSaldo(10);
            System.out.println(Blackjack.getSaldo());
            if(speler.gedubbeltje){
                System.out.print("en omdat je gedubbeld hebt: $10 extra, nieuw saldo: $");
                Blackjack.setSaldo(10);
                System.out.println(Blackjack.getSaldo());
            }

        }
        Blackjack.stopGame = true;
        if (Blackjack.getSaldo() < 10) {
            System.out.println("Je saldo is $" + Blackjack.getSaldo() + ", en dat is te weinig voor nog een potje. Zwaai zwaai.");
            Blackjack.stopPlay = true;
        } else
            switch (speler.getInput(0b0100)) {
                case 'q':
                    Blackjack.stopPlay = true;
                    System.out.println("Zwaaizwaai");
                    break;
                default:
                    break;
            }
    }
}