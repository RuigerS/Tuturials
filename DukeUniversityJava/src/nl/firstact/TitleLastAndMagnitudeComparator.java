package nl.firstact;

import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry qe1,QuakeEntry qe2){
        if(qe1.getInfo().substring(qe1.getInfo().lastIndexOf(' ')).compareTo(qe2.getInfo().substring(qe2.getInfo().lastIndexOf(' ')))==0){
            return Double.compare(qe1.getMagnitude(),qe2.getMagnitude());
        }
        return qe1.getInfo().substring(qe1.getInfo().lastIndexOf(' ')).compareTo(qe2.getInfo().substring(qe2.getInfo().lastIndexOf(' ')));
    }
}