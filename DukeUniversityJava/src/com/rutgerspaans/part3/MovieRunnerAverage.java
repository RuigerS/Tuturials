package com.rutgerspaans.part3;

import java.util.ArrayList;
import java.util.Comparator;

public class MovieRunnerAverage {
    //String loadMovies="data/ratedmovies_short.csv";
    String loadMovies="data/ratedmoviesfull.csv";
    //String loadRates="data/ratings_short.csv";
    String loadRates="data/ratings.csv";
    public static void main(String[] args) {
        MovieRunnerAverage mr=new MovieRunnerAverage();
        mr.printAverageRatings();
        mr.getAverageRatingsOneMovie();
    }

    public void printAverageRatings(){
        SecondRatings sr=new SecondRatings(loadMovies,loadRates);
        System.out.println("Aantal films: "+sr.getMovieSize());
        System.out.println("Aantal raters: "+sr.getRaterSize());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getAverageRatings(12);
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        System.out.println("Aantal films met meer ratings dan: "+result.size());
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+"  "+sr.getTitle(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }

    public void getAverageRatingsOneMovie(){
        SecondRatings sr=new SecondRatings(loadMovies,loadRates);
        //String movieTitle="The Godfather";
        //String movieTitle="The Maze Runner";
        String movieTitle="Vacation";
        String id=sr.getID(movieTitle);
        System.out.println("The average for "+movieTitle+ " (ID: "+id+") is "+sr.getAverageByID(id,1));
    }

}
