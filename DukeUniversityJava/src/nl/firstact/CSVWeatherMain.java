package nl.firstact;

import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class CSVWeatherMain {

    public static void main(String[] args) {
        // write your code here
        testweather();
        //testexports();
    }


    public static void testweather() {
        //coldest hour in file
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csvR = coldestHourINFile(parser);
        System.out.println(csvR.get("TemperatureF"));
        //file with coldest temp
//        System.out.println(fileWithColdestTemperature());
        //lowest humidity in file
//        FileResource fr = new FileResource();
//        CSVParser parser = fr.getCSVParser();
//        CSVRecord csvR = lowestHumidityINFile(parser);
//        System.out.println("Lowest humidity was " + csvR.get("Humidity") + " at " + csvR.get("DateUTC"));
        //lowest humidity inm many files
//        lowestHumidityInManyFiles();
        //average temp in file
//        FileResource fr = new FileResource();
//        CSVParser parser = fr.getCSVParser();
//        double avgTemp = averageTemperatureInFile(parser);
//        System.out.println("Average temperature in file is " + avgTemp);
        //average temp with humidity greater
//        FileResource fr = new FileResource();
//        CSVParser parser = fr.getCSVParser();
//        double avgTemp = averageTemperatureWithHighHumidityInFile(parser,80);
//        if(avgTemp<-101010) {
//            System.out.println("No temperatures with that humidity");
//        }else {
//            System.out.println("Average temperature when high humidity is " + avgTemp);
//        }
    }

    public static CSVRecord coldestHourINFile(CSVParser parser) {
        CSVRecord coldestHour = null;
        double temp;
        double coldest = 0;
        for (CSVRecord record : parser) {
            temp = Double.parseDouble(record.get("TemperatureF"));
            if (coldestHour == null) {
                coldestHour = record;
                coldest = temp;
            } else if (temp > -200 && temp < 200 && temp < coldest) {
                coldestHour = record;
                coldest = temp;
            }
        }
        return coldestHour;
    }

    public static String fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        double coldest = 0;
        double thisColdest = 0;
        String coldFile = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            if (coldFile == null) {
                coldFile = f.getName();
                CSVParser parser = fr.getCSVParser();
                coldest = Double.parseDouble(coldestHourINFile(parser).get("TemperatureF"));
                thisColdest = coldest;
            } else {
                CSVParser parser = fr.getCSVParser();
                thisColdest = Double.parseDouble(coldestHourINFile(parser).get("TemperatureF"));
                if (coldest > thisColdest) {
                    coldFile = f.getName();
                    coldest = thisColdest;
                }
            }
            //System.out.println(f.getName() + ": " + thisColdest);
        }
        return coldFile;
    }

    public static CSVRecord lowestHumidityINFile(CSVParser parser) {
        CSVRecord lowHumidityHour = null;
        double humid;
        double lowestH = 0;
        for (CSVRecord record : parser) {
            if (record.get("Humidity").indexOf('N') < 0) {
                humid = Double.parseDouble(record.get("Humidity"));
                if (lowHumidityHour == null) {
                    lowHumidityHour = record;
                    lowestH = humid;
                } else if (humid > -200 && humid < 200 && humid < lowestH) {
                    lowHumidityHour = record;
                    lowestH = humid;
                }
            }
        }
        return lowHumidityHour;
    }

    public static void lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        double lowest = 0;
        double thisLowest = 0;
        String lowFile = null;
        String varDateUTC=null;
        CSVRecord csvR=null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            csvR=lowestHumidityINFile(parser);
            if (lowFile == null) {
                lowFile = f.getName();
                lowest = Double.parseDouble(csvR.get("Humidity"));
                thisLowest = lowest;
                varDateUTC=csvR.get("DateUTC");
            } else {
                thisLowest = Double.parseDouble(csvR.get("Humidity"));
                if (lowest > thisLowest) {
                    lowFile = f.getName();
                    lowest = thisLowest;
                    varDateUTC=csvR.get("DateUTC");
                }
            }
        }
        System.out.println("Lowest humidity was "+lowest+" at "+varDateUTC);
    }

    public static double averageTemperatureInFile(CSVParser parser) {
        double totalTemp=0;
        double currTemp;
        int aantal=0;
        for (CSVRecord record : parser) {
            currTemp = Double.parseDouble(record.get("TemperatureF"));
            if (currTemp > -200 && currTemp < 200) {
                totalTemp+=currTemp;
                aantal++;
            }
        }
        return totalTemp/aantal;
    }
    public static double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double totalTemp=0;
        double currTemp;
        double currHum;
        int aantal=0;
        for (CSVRecord record : parser) {
            currTemp = Double.parseDouble(record.get("TemperatureF"));
            currHum=Double.parseDouble(record.get("Humidity"));
            if (currTemp > -200 && currTemp < 200 && (currHum>=value)) {
                totalTemp+=currTemp;
                aantal++;
            }
        }
        if (aantal==0)return -10101010;
        return totalTemp/aantal;
    }


    public static void testexports() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, "Nauru"));
        //parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "cotton","flowers");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "cocoa"));
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");

    }

    public static String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            if (record.get("Country").equals(country)) {
                return country += ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
            }
        }
        return "Not found";
    }

    public static void listExportersTwoProducts(CSVParser parser, String item1, String item2) {
        for (CSVRecord record : parser) {
            if ((record.get("Exports").indexOf(item1.toLowerCase())>=0)&&(record.get("Exports").indexOf(item2.toLowerCase())>=0)) {
                System.out.println(record.get("Country"));
            }
        }
    }

    public static int numberOfExporters(CSVParser parser, String item) {
        int aantal=0;
        for (CSVRecord record : parser) {
            if (record.get("Exports").indexOf(item.toLowerCase())>=0) {
                aantal++;
            }
        }
        return aantal;
    }

    public static void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            if (record.get("Value (dollars)").length()>amount.length()) {
                System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));

            }
        }
    }


}
