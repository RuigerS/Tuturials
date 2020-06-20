package eu.additude.zarchief.blackjack;

public class Blackjack {
    static boolean stopPlay;
    static boolean stopGame;
    private static int saldo = 100;

    public static int inzetten() {
        saldo -= 10;
        return saldo;
    }

    public static int getSaldo() {
        return saldo;
    }

    public static void setSaldo(int winst) {
        saldo += winst;
    }

    public static void main(String[] args) {
        stopPlay = false;
        while (!stopPlay) { // start nieuw spel
            stopGame = false;
            Bank bank = new Bank();
            //check for blackjack
            while (!stopGame) { //Gameloop
                bank.playerTurn();
                if (!stopGame) {
                    bank.bankTurn();
                }
                if (!stopGame) {
                    bank.afronding();
                }
            }
        }
    }
}