package nl.firstact;
/**
 * Find N-closest quakes
 * 
 * @author Duke Software/Learn to Program
 * @version 1.0, November 2015
 */

import java.util.*;

public class ClosestQuakes {
    public static void main(String[] args) {
    ClosestQuakes cq=new ClosestQuakes();
    cq.findClosestQuakes();
    }

    public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany) {
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        // TO DO
        if(howMany>=quakeData.size()){
            howMany=quakeData.size();
        }
        for (int i = 0; i < howMany; i++) {
            QuakeEntry closestEntry=quakeData.get(0);
            double closestValue=-1.0;
            for (QuakeEntry entry:quakeData) {
                if(entry.getLocation().distanceTo(current)<closestValue || closestValue<0){
                    closestValue=entry.getLocation().distanceTo(current);
                    closestEntry=entry;
                }
            }
            ret.add(closestEntry);
            quakeData.remove(closestEntry);
        }
        return ret;
    }

    public void findClosestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());

        Location jakarta  = new Location(-6.211,106.845);

        ArrayList<QuakeEntry> close = getClosest(list,jakarta,3);
        for(int k=0; k < close.size(); k++){
            QuakeEntry entry = close.get(k);
            double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            System.out.printf("%4.2f\t %s\n", distanceInMeters/1000,entry);
        }
        System.out.println("number found: "+close.size());
    }
    
}
