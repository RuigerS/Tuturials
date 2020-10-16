package nl.firstact;

import java.util.*;
//import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[]args){
        EarthQuakeClient eqc=new EarthQuakeClient();
        //eqc.bigQuakes(5.0);
        //eqc.closeToMe(1_000_000);//meters
        //eqc.quakesOfDepth(-4000.0,-2000.0);
        //eqc.quakesByPhrase("any","Can");
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for (QuakeEntry qe:quakeData) {
            if (qe.getMagnitude()>magMin){
                answer.add(qe);
            }
        }
        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for (QuakeEntry entry:quakeData) {
            if(entry.getLocation().distanceTo(from)<distMax){
                answer.add(entry);
            }
        }
        return answer;
    }

    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth) {
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for (QuakeEntry entry:quakeData) {
            if(entry.getDepth()>minDepth & entry.getDepth()<maxDepth){
                answer.add(entry);
            }
        }
        return answer;
    }

    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase){
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        switch (where) {
            case "start":
            for (QuakeEntry entry : quakeData) {
                if (entry.getInfo().startsWith(phrase)) {
                    answer.add(entry);
                }
            }
            break;
            case "any":
            for (QuakeEntry entry : quakeData) {
                if (entry.getInfo().contains(phrase)) {
                    answer.add(entry);
                }
            }
            break;
            case "end":
            for (QuakeEntry entry : quakeData) {
                if (entry.getInfo().endsWith(phrase)) {
                    answer.add(entry);
                }
            }
        }
        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

    public void bigQuakes(double magMin) {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> magMins=filterByMagnitude(list,magMin);
        for (QuakeEntry entry:magMins) {
            System.out.println(entry);
        }
        System.out.println("Found "+magMins.size()+" quakes that match that criteria");
    }

    public void closeToMe(double distMax){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
        //Location city =  new Location(38.17, -118.82);
        ArrayList<QuakeEntry> distMaxs=filterByDistanceFrom(list, distMax, city);
        for (QuakeEntry entry:distMaxs) {
            System.out.println(entry);
        }
        System.out.println("Found "+distMaxs.size()+" quakes that match that criteria");
    }

    public void quakesOfDepth(double minDepth, double maxDepth) {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> depths=filterByDepth(list,minDepth,maxDepth);
        for (QuakeEntry entry:depths) {
            System.out.println(entry);
        }
        System.out.println("Found "+depths.size()+" quakes that match that criteria");
    }

    public void quakesByPhrase(String where, String phrase) {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> phrases=filterByPhrase(list,where,phrase);
        for (QuakeEntry entry:phrases) {
            System.out.println(entry);
        }
        System.out.println("Found "+phrases.size()+" quakes that match that criteria");
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
