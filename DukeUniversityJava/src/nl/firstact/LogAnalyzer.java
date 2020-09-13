package nl.firstact;
/**
 * Write a description of class LogAnalyzer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

import edu.duke.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<>();
    }

    public void readFile(String filename) {
        // complete method
        FileResource resource = new FileResource(filename);
        for (String line : resource.lines()) {
            records.add(LogWebLogParser.parseEntry(line));
        }
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

    public int countUniqueIPs() {
        ArrayList<String> counter = new ArrayList<>();
        for (LogEntry le : records) {
            if (!counter.contains(le.getIpAddress())) {
                counter.add(le.getIpAddress());
            }
        }
        return counter.size();
    }

    public void printAllHigherThanNum(int num) {
        for (LogEntry le : records) {
            if (le.getStatusCode() > num) {
                System.out.println(le);
            }
        }
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        //someday: "Mmm 99", e.g. "Dec 14" or "Apr 22"
        ArrayList<String> counter = new ArrayList<>();
        for (LogEntry le : records) {
            if (le.getAccessTime().toString().indexOf(someday) > -1) {
                if (!counter.contains(le.getIpAddress())) {
                    counter.add(le.getIpAddress());
                }
            }
        }
        return counter;
    }

    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> counter = new ArrayList<>();
        for (LogEntry le : records) {
            if (le.getStatusCode() >= low && le.getStatusCode() <= high) {
                if (!counter.contains(le.getIpAddress())) {
                    counter.add(le.getIpAddress());
                }
            }
        }
        return counter.size();
    }

    public HashMap<String, Integer> countVisitsPerIP() {
         HashMap<String,Integer> map=new HashMap();
         for(LogEntry le:records){
             map.putIfAbsent(le.getIpAddress(),0);
             map.put(le.getIpAddress(),map.get(le.getIpAddress())+1);
         }
         return map;
    }
    public int mostNumberVisitsByIP(HashMap<String,Integer> map){
        int count=0;
        for(Integer i:map.values()){
            if(i>count){
                count=i;
            }
        }
        return count;
    }
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> map){
        ArrayList<String> ips = new ArrayList<>();
        int count=mostNumberVisitsByIP(map);
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()==count){
                ips.add(entry.getKey());
            }
        }
        return ips;
    }
    public HashMap<String,ArrayList<String>> iPsForDays(){
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for (LogEntry le : records) {
            map.putIfAbsent(le.getDate(),new ArrayList<>());
            map.get(le.getDate()).add(le.getIpAddress());
        }
        return map;
    }
    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> map){
        int max=0;
        String day="";
        for(Map.Entry<String,ArrayList<String>> entry:map.entrySet()){
            if(entry.getValue().size()>max){
                max=entry.getValue().size();
                day= entry.getKey();
            }
        }
        return day;
    }
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> map,String day){
        ArrayList<String> ips = new ArrayList<>();
        HashMap<String,Integer> tmp=new HashMap<>(); //IP+aantal
        for(Map.Entry<String,ArrayList<String>> entry:map.entrySet()) {
            if(entry.getKey().equals(day)){
                for(String s:entry.getValue()) {
                    tmp.putIfAbsent(s, 0);
                    tmp.put(s, tmp.get(s) + 1);
                }
            }
        }
        int max=0;
        for(Map.Entry<String,Integer> entry:tmp.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
            }
        }
        for(Map.Entry<String,Integer> entry:tmp.entrySet()){
            if(entry.getValue()==max){
                ips.add(entry.getKey());
            }
        }
        return ips;
    }
}
