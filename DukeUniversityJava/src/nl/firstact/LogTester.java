package nl.firstact;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;


public class LogTester
{
    public static void main(String[] args) {
        LogTester test=new LogTester();
        //test.testLogEntry();
        //test.testLogAnalyzer();
        //test.testUniqueIP();
        //test.testPrintHigherThan(400);
        //test.testUniqueIPVisitsOnDay("Sep 24");
        //test.testUniqueIPVisitsOnDay("Sep 30");
        //test.testCountUniqueIPsInRange(400,499);
        //test.testCountUniqueIPsInRange(300,399);
        //test.testIPsMostVisits();
        //test.testMostNumberVisitsByIP();
        //test.testIPsForDays();
        //test.testDayWithMostIPVisits();
        test.testIPsWithMostVisitsOnDay();
    }
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        System.out.println(le.getDate());
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
        System.out.println(le.getDate());

    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }
    public void testUniqueIP(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la.countUniqueIPs());
    }
    public void testPrintHigherThan(int num){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(num);
    }
    public void testUniqueIPVisitsOnDay(String someday){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la.uniqueIPVisitsOnDay(someday).size());
    }
    public void testCountUniqueIPsInRange(int low,int high){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la.countUniqueIPsInRange(low,high));
    }
    public void testCountVisitsPerIP(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countVisitsPerIP());
    }
    public void testMostNumberVisitsByIP(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la.mostNumberVisitsByIP(la.countVisitsPerIP()));
    }
    public void testIPsMostVisits(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la.iPsMostVisits(la.countVisitsPerIP()));
    }
    public void testIPsForDays(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la.iPsForDays());
    }
    public void testDayWithMostIPVisits(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la.dayWithMostIPVisits(la.iPsForDays()));
    }
    public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la.iPsWithMostVisitsOnDay(la.iPsForDays(),"Sep 30"));
    }
}
