package nl.firstact;

import java.util.*;

public class LargestQuakes {
    public static void main(String[] args) {
        LargestQuakes cq=new LargestQuakes();
        cq.findLargestQuakes();
    }

    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        // TO DO
        if(howMany>=quakeData.size()){
            howMany=quakeData.size();
        }
        for (int i = 0; i < howMany; i++) {
            int index=indexOfLargest(quakeData);
            ret.add(quakeData.get(index));
            quakeData.remove(index);
        }
        return ret;
    }
    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        if (data.size() > 0) {
            QuakeEntry largestEntry = data.get(0);
            for (int i = 1; i < data.size(); i++) {
                if(data.get(i).getMagnitude()>largestEntry.getMagnitude()){
                    largestEntry=data.get(i);
                }
            }
            return data.indexOf(largestEntry);
        }
        return -1;
    }

    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());
        ArrayList<QuakeEntry> large = getLargest(list,50);
        for(int k=0; k < large.size(); k++){
            QuakeEntry entry = large.get(k);
            System.out.println(entry);
        }
        System.out.println("number found: "+large.size());
    }

}
