package eu.additude.weekopdracht4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLoop {
    private boolean gameStop;
    public Universe universe = new Universe();
    private List<Player> players = new ArrayList();
    Scanner sc = new Scanner(System.in);


    public GameLoop() {
        gameStop = false;
    }

    public void start() {
        players.add(new Humanoid(0, 0, 0, "Human"));
        players.add(new Android(0, 9, 0, "Android 1"));
        players.add(new Android(9, 0, 9, "Android 2"));
        players.add(new Android(9, 9, 9, "Android 3"));
        gameLoopLoop();
    }

    public void gameLoopLoop() {
        while (!gameStop) {
            //welcome to the loop
            //wat gaan we hier doen
            //print info
            System.out.println(players.get(0));
            //make choice of action
            System.out.println("Let's communicate: (q) quit, (e) explore");
            doAction(sc.next().toLowerCase().charAt(0));
            //update the action
        }
    }

    public void doAction(char key) {
        switch (key) {
            case 'q':
                setGameStop(true);
                break;
            case 'e':
                players.get(0).setAction("explore");
                break;

        }
    }

    public boolean isGameStop() {
        return gameStop;
    }

    public void setGameStop(boolean gameStop) {
        this.gameStop = gameStop;
    }

}
