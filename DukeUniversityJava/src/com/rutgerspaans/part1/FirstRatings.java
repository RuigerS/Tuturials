package com.rutgerspaans.part1;

import edu.duke.*;

import java.util.*;

import org.apache.commons.csv.*;

public class FirstRatings {
    public static void main(String[] args) {
        FirstRatings fr = new FirstRatings();
        //fr.testLoadMovies();
        fr.testLoadRates();
    }

    public ArrayList<Movie> loadMovies(String filename) {
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        ArrayList<Movie> result = new ArrayList<>();
        for (CSVRecord movie : parser) {
            result.add(new Movie(movie.get("id"), movie.get("title"), movie.get("year"), movie.get("genre"), movie.get("director"), movie.get("country"), movie.get("poster"), Integer.parseInt(movie.get("minutes").trim())));
        }
        return result;
    }

    public ArrayList<Rater> loadRaters(String filename) {
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        ArrayList<Rater> result = new ArrayList<>();
        for (CSVRecord rater : parser) {
            boolean lookingFor = true;
            String nextEntry = rater.get("rater_id");
            for (Rater raterArrayList : result) {
                if (raterArrayList.getID().equals(nextEntry)) {
                    raterArrayList.addRating(rater.get("movie_id"), Double.parseDouble(rater.get("rating")));
                    lookingFor = false;
                }
            }
            if (lookingFor) {
                result.add(new Rater(rater.get("rater_id")));
                result.get(result.size() - 1).addRating(rater.get("movie_id"), Double.parseDouble(rater.get("rating")));
            }
        }
        return result;
    }

    public void testLoadMovies() {
        //ArrayList<Movie> testMovies = loadMovies("data/ratedmovies_short.csv");
        ArrayList<Movie> testMovies = loadMovies("data/ratedmoviesfull.csv");
        //ArrayList<Movie> testMovies =loadMovies("data/ratedmoviesfull.csv");
        System.out.println("Total number of movies: " + testMovies.size());
//        for (Movie movie:testMovies) {
//            System.out.println(movie);
//        }
        int numberOfComedyGenre = 0;
        int longerThan150Minutes = 0;
        HashMap<String, Integer> directorsMovies = new HashMap<>();
        for (Movie movie : testMovies) {
            if (movie.getGenres().contains("Comedy")) {
                numberOfComedyGenre += 1;
            }
            if (movie.getMinutes() > 150) {
                longerThan150Minutes += 1;
            }
            String[] directorsMovie = movie.getDirector().split(", ");
            for (String director : directorsMovie) {
                directorsMovies.put(director, directorsMovies.getOrDefault(director, 0) + 1);
            }
        }
        System.out.println("number of comedy genre movies: " + numberOfComedyGenre);
        System.out.println("number of movies longer than 150 mins: " + longerThan150Minutes);
        int mostMovies = 0;
        for (Map.Entry<String, Integer> entry : directorsMovies.entrySet()) {
            if (entry.getValue() > mostMovies) {
                mostMovies = entry.getValue();
            }
        }
        for (Map.Entry<String, Integer> entry : directorsMovies.entrySet()) {
            if (entry.getValue() > mostMovies) {
                mostMovies = entry.getValue();
            }
        }
        System.out.println("Most movies by one director: " + mostMovies);
        for (Map.Entry<String, Integer> entry : directorsMovies.entrySet()) {
            if (entry.getValue() == mostMovies) {
                System.out.println("Director directed most movies: " + entry.getKey());
            }
        }
    }

    public void testLoadRates() {
        //ArrayList<Rater> testRates = loadRaters("data/ratings_short.csv");
        ArrayList<Rater> testRates =loadRaters("data/ratings.csv");
        System.out.println("Total number of raters: " + testRates.size());
//        for(Rater rater:testRates){
//            System.out.println("Rater ID: "+rater.getID() + " gave "+rater.numRatings()+" ratings.");
//            for(String ratedMovie:rater.getItemsRated()){
//                System.out.println("Movie: "+ratedMovie+"  rating: "+rater.getRating(ratedMovie));
//            }
//        }
        System.out.println("-------------------------------");
        String findRaterID = "193";
        int maxRates = 0;
        for (Rater rater : testRates) {
            if (rater.getID().equals(findRaterID)) {
                System.out.println("Rater " + findRaterID + " rated " + rater.numRatings() + " movies");
            }
            if (rater.numRatings() > maxRates) {
                maxRates = rater.numRatings();
            }
        }
        System.out.println("-------------------------------");
        int aantalMaxRatingsPerRater = 0;
        ArrayList<String> whoIsIt=new ArrayList<>();
        for (Rater rater : testRates) {
            if (rater.numRatings() == maxRates) {
                aantalMaxRatingsPerRater += 1;
                whoIsIt.add(rater.getID());
            }
        }
        System.out.println("Maximum ratings per rater: "+maxRates);
        System.out.println("Number of raters with maximum ratings: "+aantalMaxRatingsPerRater);
        System.out.println("Who those raters are: "+whoIsIt);
        System.out.println("-------------------------------");
        String movieToFind="1798709";
        int aantalRaters=0;
        for(Rater rater:testRates){
            if(rater.getRating(movieToFind)>-1){
                //System.out.println("Movie "+ movieToFind+" was rated by "+rater.getID());
                aantalRaters+=1;
            }
        }
        System.out.println("Aantal raters for movie "+movieToFind+" is "+aantalRaters);
        System.out.println("-------------------------------");
        ArrayList<String> moviesRated=new ArrayList<>();
        for (Rater rater:testRates) {
            for(String movieID:rater.getItemsRated()){
                if(!moviesRated.contains(movieID)){
                    moviesRated.add(movieID);
                }
            }
        }
        System.out.println("Aantal movies rated: "+moviesRated.size());
    }
}
