package com.rutgerspaans.part3;
/**
 * Write a description of SecondRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class ThirdRatings {
    private ArrayList<Rater> myRaters;

    public ThirdRatings() {
        this("ratings.csv");
    }

    public ThirdRatings(String ratingsfile) {
        FirstRatings fr = new FirstRatings();
        myRaters = fr.loadRaters("data/"+ratingsfile);

    }

    public int getRaterSize(){
        return myRaters.size();
    }

    public double getAverageByID(String id,int minimalRaters){
        int numberOfRaters=0;
        double totalScore=0;
        for(Rater rater:myRaters){
            double score=rater.getRating(id);
            if(score>-1){
                numberOfRaters+=1;
                totalScore+=score;
            }
        }
        if(numberOfRaters<minimalRaters) {
            return 0.0;
        }else{
            return totalScore/numberOfRaters;
        }
    }
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> result=new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for (String movie:movies) {
            double score=getAverageByID(movie,minimalRaters);
            if(score>0.0){
                result.add(new Rating(movie,score));
            }
        }
        return result;
    }
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria){
        ArrayList<Rating> result=new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for (String movie:movies) {
            double score=getAverageByID(movie,minimalRaters);
            if(score>0.0){
                result.add(new Rating(movie,score));
            }
        }
        return result;
    }

}
