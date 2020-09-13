package nl.firstact;

import edu.duke.*;
import org.apache.commons.csv.*;

public class CSVCountryExportMain {

    public static void main(String[] args) {
        // write your code here
        tester();
    }

    public static void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "Gold","diamonds");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "Gold"));
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
