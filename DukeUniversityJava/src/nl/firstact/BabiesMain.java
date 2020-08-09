package nl.firstact;

import edu.duke.*;

import org.apache.commons.csv.*;
import java.io.File;

public class BabiesMain {

    public static void main(String[] args) {
        // write your code here
        //FileResource fr = new FileResource();
        //totalBirths(fr);
        // System.out.println(getRank(1971, "Frank", "M"));
        // System.out.println(getRank(2012, "Mason", "F"));
        // System.out.println(getName(1982, 450, "M"));
        // System.out.println(getName(2012, 2, "F"));
        // whatIsNameInYear("Owen", 1974, 2014, "M");
        //System.out.println(yearOfHighestRank("Mich", "M"));
        //System.out.println(getAverageRank("Robert", "M"));
        //System.out.println(getAverageRank("Jacob", "M"));
        System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }

    public static void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int aantalBoyNames = 0;
        int aantalGirlNames = 0;
        int aantalNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            aantalNames += 1;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                aantalBoyNames += 1;
            } else {
                totalGirls += numBorn;
                aantalGirlNames += 1;
            }
        }
        System.out.println("Total births: " + totalBirths);
        System.out.println("Total girls: " + totalGirls);
        System.out.println("Total boys: " + totalBoys);
        System.out.println("Total boy names: " + aantalBoyNames);
        System.out.println("Total girl names: " + aantalGirlNames);
        System.out.println("Total names: " + aantalNames);
    }

    public static int getRank(int year, String name, String gender) {
        String tmpFileName=".\\us_babynames\\us_babynames_by_year\\yob"+year+".csv";
        //String tmpFileName = ".\\us_babynames\\us_babynames_test\\yob" + year + "short.csv";
        int regel = 1;
        int found = -1;
        FileResource fr = new FileResource(tmpFileName);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                if (rec.get(0).equals(name)) {
                    found = regel;
                }
                regel++;
            }
        }
        return found;
    }

    public static String getName(int year, int rank, String gender) {
        String tmpFileName=".\\us_babynames\\us_babynames_by_year\\yob"+year+".csv";
        //String tmpFileName = ".\\us_babynames\\us_babynames_test\\yob" + year + "short.csv";
        int regel = 1;
        String found = "NO NAME";
        FileResource fr = new FileResource(tmpFileName);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                if (regel == rank) {
                    found = rec.get(0);
                }
                regel++;
            }
        }
        return found;
    }

    public static void whatIsNameInYear(String name, int year, int newYear, String gender) {
        // get the current rank
        int rankerd = getRank(year, name, gender);
        // find rank in newYear
        System.out.println(getName(newYear, rankerd, gender));
        // print result
    }

    public static int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int highestRank = 100001;
        String yearHighest = "-1";
        for (File f : dr.selectedFiles()) {
            int regel = 1;
            int found = -1;
            FileResource fr = new FileResource(f);
            for (CSVRecord rec : fr.getCSVParser(false)) {
                if (rec.get(1).equals(gender)) {
                    if (rec.get(0).equals(name)) {
                        found = regel;
                    }
                    regel++;
                }
            }
            if (found>-1 && found < highestRank) {
                highestRank = found;
                yearHighest = f.getName();
            }
        }
        if(yearHighest.equals("-1")){
            return -1;
        }
        return Integer.parseInt(yearHighest.substring(3, 7));
    }

    public static double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        double total = 0.0;
        int aantal = 0;
        for (File f : dr.selectedFiles()) {
            int regel = 1;
            int found = -1;
            FileResource fr = new FileResource(f);
            for (CSVRecord rec : fr.getCSVParser(false)) {
                if (rec.get(1).equals(gender)) {
                    if (rec.get(0).equals(name)) {
                        found = regel;
                    }
                    regel++;
                }
            }
            if (found >= 0) {
                aantal += 1;
                total += found;
            }
        }
        if (aantal == 0) {
            return -1.0;
        }
        return (total / aantal);
    }

    public static int getTotalBirthsRankedHigher(int year, String name, String gender){
        int rankerd=getRank(year, name, gender);
        String tmpFileName=".\\us_babynames\\us_babynames_by_year\\yob"+year+".csv";
        //String tmpFileName = ".\\us_babynames\\us_babynames_test\\yob" + year + "short.csv";
        int regel = 1;
        int total=0;
        FileResource fr = new FileResource(tmpFileName);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                if(rankerd>regel){
                total+=Integer.parseInt(rec.get(2));
                }
                regel++;
            }
        }
        return total;
    }
}
