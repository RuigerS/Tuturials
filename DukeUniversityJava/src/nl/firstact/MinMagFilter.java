package nl.firstact;

/**
 * Write a description of class MinMaxFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinMagFilter implements Filter
{
    private double magMin;
    private String name="MinMag";

    public MinMagFilter(double magMin) {
        this.magMin = magMin;
    }
    public MinMagFilter(double magMin,String name){
        this.magMin = magMin;
        this.name=name;
    }

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    }

    @Override
    public String getName() {
        return name;
    }



}
