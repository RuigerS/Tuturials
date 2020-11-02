package nl.firstact;
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        QuakeSortInPlace qsip=new QuakeSortInPlace();
        qsip.testSort();
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData,int numSorted){
        for (int i = 0; i < (quakeData.size()-numSorted-1); i++) {
            if(quakeData.get(i).getMagnitude()>quakeData.get(i+1).getMagnitude()){
                QuakeEntry qeTmp= quakeData.get(i);
                quakeData.set(i,quakeData.get(i+1));
                quakeData.set(i+1,qeTmp);
            }
        }
    }
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes){
        for (int i = 0; i < quakes.size()-1; i++) {
            if(quakes.get(i).getMagnitude()>quakes.get(i+1).getMagnitude()){
                return false;
            }
        }
        return true;
    }
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
        for (int i = 0; i < (in.size()-1); i++) {
            if(checkInSortedOrder(in)){
                System.out.println("Rock'n'rolling: "+i+" keren de sort doorlopen");
                break;
            }
            onePassBubbleSort(in,i);
        }
    }

    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        for (int i = 0; i < (in.size()-1); i++) {
            onePassBubbleSort(in,i);
        }
    }

    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int index){
        QuakeEntry qeTmp=quakeData.get(index);
        for (int i = index+1; i < quakeData.size(); i++) {
            if(qeTmp.getDepth()<quakeData.get(i).getDepth()){
                qeTmp=quakeData.get(i);
            }
        }
        return quakeData.indexOf(qeTmp);
    }

    public void sortByLargestDepth(ArrayList<QuakeEntry> in){
        //for (int i = 0; i < in.size(); i++) {
        for (int i = 0; i < 50; i++) {
            int tmpIndex=getLargestDepth(in,i);
            QuakeEntry qeTmp=in.get(i);
            in.set(i,in.get(tmpIndex));
            in.set(tmpIndex,qeTmp);
        }
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in) {

        for (int i=0; i< in.size(); i++) {
            if(checkInSortedOrder(in)){
                System.out.println("Rock'n'rolling: "+i+" keren de sort doorlopen");
                break;
            }
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        //String source = "data/earthquakeDataSampleSix1.atom";
        //String source = "data/earthquakeDataSampleSix2.atom";
        //String source = "data/nov20quakedata.atom";
        //String source = "data/earthQuakeDataDec6sample1.atom";
        //String source = "data/earthQuakeDataDec6sample2.atom";
        String source = "data/earthQuakeDataWeekDec6sample2.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        sortByMagnitudeWithBubbleSortWithCheck(list);
        //sortByMagnitudeWithCheck(list);
        for (QuakeEntry qe: list) {
            System.out.println(qe);
        } 
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
}
