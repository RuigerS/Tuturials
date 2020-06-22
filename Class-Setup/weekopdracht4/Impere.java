package eu.additude.weekopdracht4;

public class Impere {
    public static GameLoop gameLoop;
    public static void main(String[] args) {
        //gamestart
        gameLoop = new GameLoop();
        gameLoop.start();
    }
}
