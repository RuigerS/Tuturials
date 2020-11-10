package com.rutgerspaans.part3;

import java.util.ArrayList;
import java.util.Comparator;

public class MovieRunnerWithFilters {
    //String loadMovies="ratedmovies_short.csv";
    String loadMovies="ratedmoviesfull.csv";
    //String loadRates="ratings_short.csv";
    String loadRates="ratings.csv";

    public static void main(String[] args) {
        MovieRunnerWithFilters mrf=new MovieRunnerWithFilters();
        //mrf.printAverageRatings();
        //mrf.printAverageRatingsByYear();
        //mrf.printAverageRatingsByGenre();
        //mrf.printAverageRatingsByMinutes();
        //mrf.printAverageRatingsByDirector();
        //mrf.printAverageRatingsByYearAfterAndGenre();
        mrf.printAverageRatingsByDirectorsAndMinutes();
    }

    public void printAverageRatings(){
        ThirdRatings sr=new ThirdRatings(loadRates);
        System.out.println("Read data for raters: "+sr.getRaterSize());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getAverageRatings(35);
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
    public void printAverageRatingsByYear(){
        ThirdRatings sr=new ThirdRatings(loadRates);
        System.out.println("Read data for raters: "+sr.getRaterSize());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        YearAfterFilter yaf=new YearAfterFilter(2000);
        ArrayList<String> filteredResult=MovieDatabase.filterBy(yaf);
        System.out.println("Found films by year: "+filteredResult.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getAverageRatingsByFilter(20,yaf);
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
    public void printAverageRatingsByGenre(){
        ThirdRatings sr=new ThirdRatings(loadRates);
        System.out.println("Read data for raters: "+sr.getRaterSize());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        GenreFilter gf=new GenreFilter("Comedy");
        ArrayList<String> filteredResult=MovieDatabase.filterBy(gf);
        System.out.println("Found films by genre: "+filteredResult.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getAverageRatingsByFilter(20,gf);
        System.out.println("Found films met genoeg ratings: "+result.size());
        System.out.println("-------------------------------");
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+"  "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println("      "+MovieDatabase.getGenres(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }
    public void printAverageRatingsByMinutes(){
        ThirdRatings sr=new ThirdRatings(loadRates);
        System.out.println("Read data for raters: "+sr.getRaterSize());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        MinutesFilter mf =new MinutesFilter(105,135);
        ArrayList<String> filteredResult=MovieDatabase.filterBy(mf);
        System.out.println("Found films by duration: "+filteredResult.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getAverageRatingsByFilter(5,mf);
        System.out.println("Found films met genoeg ratings: "+result.size());
        System.out.println("-------------------------------");
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+" Time: "+MovieDatabase.getMinutes(rating.getItem())+"  "+MovieDatabase.getTitle(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }
    public void printAverageRatingsByDirector(){
        ThirdRatings sr=new ThirdRatings(loadRates);
        System.out.println("Read data for raters: "+sr.getRaterSize());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        DirectorsFilter df =new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
        ArrayList<String> filteredResult=MovieDatabase.filterBy(df);
        System.out.println("Found films by director: "+filteredResult.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getAverageRatingsByFilter(4,df);
        System.out.println("Found films met genoeg ratings: "+result.size());
        System.out.println("-------------------------------");
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+"  "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println("      "+MovieDatabase.getDirector(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }
    public void printAverageRatingsByYearAfterAndGenre(){
        ThirdRatings sr=new ThirdRatings(loadRates);
        System.out.println("Read data for raters: "+sr.getRaterSize());
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
        ArrayList<Rating> result=sr.getAverageRatingsByFilter(8,af);
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
    public void printAverageRatingsByDirectorsAndMinutes(){
        ThirdRatings sr=new ThirdRatings(loadRates);
        System.out.println("Read data for raters: "+sr.getRaterSize());
        System.out.println("-------------------------------");
        MovieDatabase.initialize(loadMovies);
        System.out.println("Read data for films: "+MovieDatabase.size());
        System.out.println("-------------------------------");
        AllFilters af=new AllFilters();
        af.addFilter(new MinutesFilter(90,180));
        af.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
        ArrayList<String> filteredResult=MovieDatabase.filterBy(af);
        System.out.println("Found films by filter: "+filteredResult.size());
        System.out.println("-------------------------------");
        //find all movies with at least x number of ratings
        ArrayList<Rating> result=sr.getAverageRatingsByFilter(3,af);
        System.out.println("Found films met genoeg ratings: "+result.size());
        System.out.println("-------------------------------");
        // sort on score
        result.sort(Comparator.comparingDouble(Rating::getValue));
        // add code to print a list of movies + average ratings
        for(Rating rating:result){
            System.out.println(" "+rating.getValue()+" Time: "+MovieDatabase.getMinutes(rating.getItem())+"  "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println("      "+MovieDatabase.getDirector(rating.getItem()));
        }
        System.out.println("-------------------------------");
    }
}
