package com.rutgerspaans.part4;

import java.util.ArrayList;
import java.util.Comparator;

public class MovieRunnerSimularRatings {
    //String loadMovies="ratedmovies_short.csv";
    String loadMovies="ratedmoviesfull.csv";
    //String loadRates="ratings_short.csv";
    String loadRates="ratings.csv";

    public static void main(String[] args) {
        MovieRunnerSimularRatings mrsr=new MovieRunnerSimularRatings();
        //mrsr.printAverageRatings();
        //mrsr.printAverageRatingsByYearAfterAndGenre();
        //mrsr.printSimilarRatings();
        //mrsr.printSimilarRatingsByGenre();
        //mrsr.printSimilarRatingsByDirector();
        //mrsr.printSimilarRatingsByGenreAndMinutes();
        mrsr.printSimilarRatingsByYearsAfterAndMinutes();
    }

    public void printAverageRatings(){
        FourthRatings sr=new FourthRatings();
        RaterDatabase.initialize(loadRates);
        System.out.println("Read data for raters: "+RaterDatabase.size());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getAverageRatings(1);
        System.out.println("Aantal films met meer ratings dan: "+result.size());
        System.out.println("-------------------------------");
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+"  "+MovieDatabase.getTitle(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }
    public void printAverageRatingsByYearAfterAndGenre(){
        FourthRatings sr=new FourthRatings();
        RaterDatabase.initialize(loadRates);
        System.out.println("Read data for raters: "+RaterDatabase.size());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        AllFilters af=new AllFilters();
        af.addFilter(new YearAfterFilter(1990));
        af.addFilter(new GenreFilter("Drama"));
        ArrayList<String> filteredResult=MovieDatabase.filterBy(af);
        System.out.println("Found films by filter: "+filteredResult.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getAverageRatingsByFilter(1,af);
        System.out.println("Found films met genoeg ratings: "+result.size());
        System.out.println("-------------------------------");
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+" Year: "+MovieDatabase.getYear(rating.getItem())+"  "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println("      "+MovieDatabase.getGenres(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }
    public void printSimilarRatings(){
        FourthRatings sr=new FourthRatings();
        RaterDatabase.initialize(loadRates);
        System.out.println("Read data for raters: "+RaterDatabase.size());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getSimilarRatings("71",20,5);
        System.out.println("Aantal films met meer ratings dan: "+result.size());
        System.out.println("-------------------------------");
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+"  "+MovieDatabase.getTitle(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }
    public void printSimilarRatingsByGenre(){
        FourthRatings sr=new FourthRatings();
        RaterDatabase.initialize(loadRates);
        System.out.println("Read data for raters: "+RaterDatabase.size());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        GenreFilter gf=new GenreFilter("Mystery");
        ArrayList<String> filteredResult=MovieDatabase.filterBy(gf);
        System.out.println("Found films by genre: "+filteredResult.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getSimilarRatingsByFilter("964",20,5,gf);
        System.out.println("Found films met genoeg ratings: "+result.size());
        System.out.println("-------------------------------");
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+"  "+MovieDatabase.getTitle(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }
    public void printSimilarRatingsByDirector(){
        FourthRatings sr=new FourthRatings();
        RaterDatabase.initialize(loadRates);
        System.out.println("Read data for raters: "+RaterDatabase.size());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        DirectorsFilter gf=new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
        ArrayList<String> filteredResult=MovieDatabase.filterBy(gf);
        System.out.println("Found films by director: "+filteredResult.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getSimilarRatingsByFilter("120",10,2,gf);
        System.out.println("Found films met genoeg ratings: "+result.size());
        System.out.println("-------------------------------");
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+"  "+MovieDatabase.getTitle(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }
    public void printSimilarRatingsByGenreAndMinutes(){
        FourthRatings sr=new FourthRatings();
        RaterDatabase.initialize(loadRates);
        System.out.println("Read data for raters: "+RaterDatabase.size());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        AllFilters gf=new AllFilters();
        gf.addFilter(new GenreFilter("Drama"));
        gf.addFilter(new MinutesFilter(80,160));
        ArrayList<String> filteredResult=MovieDatabase.filterBy(gf);
        System.out.println("Found films by director: "+filteredResult.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getSimilarRatingsByFilter("168",10,3,gf);
        System.out.println("Found films met genoeg ratings: "+result.size());
        System.out.println("-------------------------------");
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+"  "+MovieDatabase.getTitle(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }
    public void printSimilarRatingsByYearsAfterAndMinutes(){
        FourthRatings sr=new FourthRatings();
        RaterDatabase.initialize(loadRates);
        System.out.println("Read data for raters: "+RaterDatabase.size());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        AllFilters gf=new AllFilters();
        gf.addFilter(new YearAfterFilter(1975));
        gf.addFilter(new MinutesFilter(70,200));
        ArrayList<String> filteredResult=MovieDatabase.filterBy(gf);
        System.out.println("Found films by director: "+filteredResult.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getSimilarRatingsByFilter("314",10,5,gf);
        System.out.println("Found films met genoeg ratings: "+result.size());
        System.out.println("-------------------------------");
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+"  "+MovieDatabase.getTitle(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }
}
