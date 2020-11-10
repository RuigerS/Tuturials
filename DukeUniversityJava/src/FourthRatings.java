import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FourthRatings {
    public double getAverageByID(String id, int minimalRaters) {
        int numberOfRaters = 0;
        double totalScore = 0;
        for (Rater rater : RaterDatabase.getRaters()) {
            double score = rater.getRating(id);
            if (score > -1) {
                numberOfRaters += 1;
                totalScore += score;
            }
        }
        if (numberOfRaters < minimalRaters) {
            return 0.0;
        } else {
            return totalScore / numberOfRaters;
        }
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> result = new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for (String movie : movies) {
            double score = getAverageByID(movie, minimalRaters);
            if (score > 0.0) {
                result.add(new Rating(movie, score));
            }
        }
        return result;
    }

    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria) {
        ArrayList<Rating> result = new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for (String movie : movies) {
            double score = getAverageByID(movie, minimalRaters);
            if (score > 0.0) {
                result.add(new Rating(movie, score));
            }
        }
        return result;
    }

    private double dotProduct(Rater me, Rater r) {
        ArrayList<String> findItems = me.getItemsRated();
        double dotP = 0;
        double myItemScore;
        double rItemScore;
        for (String findItem : findItems) {
            if (r.hasRating(findItem)) {
                rItemScore = r.getRating(findItem);
                myItemScore = me.getRating(findItem);
                dotP += (myItemScore - 5) * (rItemScore - 5);
            }
        }
        return dotP;
    }

    private ArrayList<Rating> getSimilarities(String id) {
        ArrayList<Rating> list = new ArrayList<>();
        Rater me = RaterDatabase.getRater(id);
        for (Rater r : RaterDatabase.getRaters()) {
            double dotP = dotProduct(me, r);
            if (!(r.getID().equals(id)) && dotP > 0) {
                list.add(new Rating(r.getID(), dotP));
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        //System.out.println(list);
        return list;
    }

    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters) {
        ArrayList<Rating> similarRaters = getSimilarities(id);
        ArrayList<Rating> movieRatings = new ArrayList<>();
        for (String movie : MovieDatabase.filterBy(new TrueFilter())) {
            double totScoreCurrentMovie = 0;
            double aantalRaters = 0;
            for (int i = 0; i < numSimilarRaters; i++) {
                Rater rater = RaterDatabase.getRater(similarRaters.get(i).getItem());
                if (rater.hasRating(movie)) {
                    aantalRaters += 1;
                    totScoreCurrentMovie += rater.getRating(movie) * similarRaters.get(i).getValue();
                }
            }
            if (aantalRaters >= minimalRaters) {
                movieRatings.add(new Rating(movie, totScoreCurrentMovie / aantalRaters));
            }
        }
        Collections.sort(movieRatings, Collections.reverseOrder());
        return movieRatings;
    }

    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria) {
        ArrayList<Rating> similarRaters = getSimilarities(id);
        ArrayList<Rating> movieRatings = new ArrayList<>();
        for (String movie : MovieDatabase.filterBy(filterCriteria)){
            double totScoreCurrentMovie = 0;
            double aantalRaters = 0;
            for (int i = 0; i < numSimilarRaters; i++) {
                Rater rater = RaterDatabase.getRater(similarRaters.get(i).getItem());
                if (rater.hasRating(movie)) {
                    aantalRaters += 1;
                    totScoreCurrentMovie += rater.getRating(movie) * similarRaters.get(i).getValue();
                }
            }
            if (aantalRaters >= minimalRaters) {
                movieRatings.add(new Rating(movie, totScoreCurrentMovie / aantalRaters));
            }
        }
        Collections.sort(movieRatings, Collections.reverseOrder());
        System.out.println(movieRatings);
        return movieRatings;
    }

}
