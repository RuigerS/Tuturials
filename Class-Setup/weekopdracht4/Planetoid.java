package eu.additude.weekopdracht4;

public class Planetoid {
    private String name;
    private int posX;
    private int posY;
    private int posZ;

    public Planetoid(int x, int y, int z){
        posX=x;
        posY=y;
        posZ=z;
    }
    public Planetoid(){

    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosZ() {
        return posZ;
    }
}
