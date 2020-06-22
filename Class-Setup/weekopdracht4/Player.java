package eu.additude.weekopdracht4;

public class Player {

    private int locationX = 0;
    private int locationY = 0;
    private int locationZ = 0;
    private String action = "";
    private String naam = "";

    public Player() {
        this(0, 0, 0, "Nemo Nobody");
    }

    public Player(int x, int y, int z, String str) {
        setLocation(x, y, z);
        naam = str;
    }

    public void setLocation(int x, int y, int z) {
        locationX = x;
        locationY = y;
        locationZ = z;
    }

    public String toString() {
        return ("Hi, ik ben " + naam + " op: x:" + locationX + " y:" + locationY + " z:" + locationZ + " ");
    }

    public void setAction(String action) {
        this.action = action;
        switch (action) {
            case "explore":
                explore();
                break;
        }
    }

    void explore() {
        Planetoid dichtbij = Impere.gameLoop.universe.findClosestPlanet(locationX, locationY, locationZ);
        System.out.println("found planet: x" + dichtbij.getPosX() + " y" + dichtbij.getPosY() + " z" + dichtbij.getPosZ());
        int afstand = Universe.afstand(locationX, locationY, locationZ, dichtbij.getPosX(), dichtbij.getPosY(), dichtbij.getPosZ());
        System.out.println("Afstand:" + afstand);
        if (afstand < 1) {
            System.out.println("Landen");
            locationX = dichtbij.getPosX();
            locationY = dichtbij.getPosY();
            locationZ = dichtbij.getPosZ();
            setAction("Terraformen");
        } else {
            locationX += Math.round(((dichtbij.getPosX() - locationX) + 0.1) / afstand);
            locationY += Math.round(((dichtbij.getPosY() - locationY) + 0.1) / afstand);
            locationZ += Math.round(((dichtbij.getPosZ() - locationZ) + 0.1) / afstand);
            System.out.println("Reizen");
        }
    }
}
