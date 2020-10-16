package nl.firstact;

public class DistanceFilter implements Filter{
    private Location location;
    private double maxDistance;
    private String name="Distance";

    public DistanceFilter(Location location, double maxDistance){
        this.location=location;
        this.maxDistance=maxDistance;
    }
    public DistanceFilter(Location location, double maxDistance,String name){
        this.location=location;
        this.maxDistance=maxDistance;
        this.name=name;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        if(qe.getLocation().distanceTo(location)<=maxDistance){
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
    public double getMaxDistance() {
        return maxDistance;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }
}
