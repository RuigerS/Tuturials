package eu.additude.zarchief.yahtzee;

import java.util.Random;

public class Dobbelsteen {
    private int ogen;
    Random rand=new Random();
    int werpen(){
        ogen=rand.nextInt(6)+1;
        return ogen;
    }
    public int getOgen(){
        return ogen;
    }
}
