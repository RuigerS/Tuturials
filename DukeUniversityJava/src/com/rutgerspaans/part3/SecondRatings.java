package com.rutgerspaans.part3;
/**
 * Write a description of SecondRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;

    public SecondRatings() {
        // default constructor
        this("data/ratedmoviesfull.csv", "data/ratings.csv");
    }

    public SecondRatings(String moviefile, String ratingsfile) {
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(moviefile);
        myRaters = fr.loadRaters(ratingsfile);

    }

    public int getMovieSize() {
        return myMovies.size();
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
        for (Movie movie:myMovies) {
            double score=getAverageByID(movie.getID(),minimalRaters);
            if(score>0.0){
                result.add(new Rating(movie.getID(),score));
            }
        }
        return result;
    }
    public String getTitle(String id){
        for (Movie movie:myMovies) {
            if(id.equals(movie.getID())){
                return movie.getTitle();
            }
        }
        return "NO SUCH ID";
    }
    public String getID(String title){
        for (Movie movie:myMovies) {
            if(title.equals(movie.getTitle())){
                return movie.getID();
            }
        }
        return "NO SUCH TITLE";
    }

}
