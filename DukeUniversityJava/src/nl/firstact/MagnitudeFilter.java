package nl.firstact;

public class MagnitudeFilter implements Filter {
    private double minMag;
    private double maxMag;
    private String name="Magnitude";

    public MagnitudeFilter(double minMag, double maxMag){
        this.minMag=minMag;
        this.maxMag=maxMag;
    }
    public MagnitudeFilter(double minMag, double maxMag,String name){
        this.minMag=minMag;
        this.maxMag=maxMag;
        this.name=name;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        if(qe.getMagnitude()>=minMag&&qe.getMagnitude()<=maxMag){
            return true;
        }
        return false;
    }
    @Override
    public String getName() {
        return name;
    }


    public double getMaxMag() {
        return maxMag;
    }
    public double getMinMag() {
        return minMag;
    }
    public void setMaxMag(double maxMag) {
        this.maxMag = maxMag;
    }
    public void setMinMag(double minMag) {
        this.minMag = minMag;
    }
}
