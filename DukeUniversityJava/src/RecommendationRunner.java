import java.util.ArrayList;
import java.util.Collections;

public class RecommendationRunner implements Recommender {
    String loadMovies = "ratedmoviesfull.csv";
    String loadRates = "ratings.csv";
    ArrayList<String> movies;

    public static void main(String[] args) {
        RecommendationRunner rr=new RecommendationRunner();
        rr.getItemsToRate();
        rr.printRecommendationsFor("65");
    }
    @Override
    public ArrayList<String> getItemsToRate() {
        FourthRatings sr = new FourthRatings();
        MovieDatabase.initialize(loadMovies);
        RaterDatabase.initialize(loadRates);
        movies = new ArrayList<>();
        ArrayList<Rating> result = sr.getAverageRatings(20);
        Collections.sort(result, Collections.reverseOrder());
        for (int i = 0; i < 12; i++) {
            movies.add(result.get(i).getItem());
        }
        return movies;
    }


    @Override
    public void printRecommendationsFor(String webRaterID) {
        FourthRatings sr = new FourthRatings();
        Rater thisGuy = RaterDatabase.getRater(webRaterID);
        ArrayList<String> listRecommended = thisGuy.getItemsRated();
        while (listRecommended.size() > 12) {
            double lowestScore = 10;
            String lowestMovie = "";
            String  doubleMovie="";
            for (String movie : listRecommended) {
                if (lowestScore >= thisGuy.getRating(movie)) {
                    lowestScore = thisGuy.getRating(movie);
                    lowestMovie = movie;
                }
                if(movies.contains(movie)){
                    doubleMovie=movie;
                }
            }
            if(doubleMovie.equals("")){
                listRecommended.remove(lowestMovie);
            }
            else{
                listRecommended.remove(doubleMovie);
            }
        }
        if (listRecommended.isEmpty()) {
            System.out.println("<table><tr><td>No recommendations found</td></tr></table>");
        } else {
            System.out.println("<table>");
            for (int i = 0; i < listRecommended.size(); i++) {
                if (i % 4 == 0) {
                    System.out.println("<tr>");
                }
                System.out.println("<td><img src=\"" + MovieDatabase.getPoster(listRecommended.get(i)) + "\"><br>" + MovieDatabase.getTitle(listRecommended.get(i)) + "</td>");
                if (i % 4 == 3) {
                    System.out.println("</tr>");
                }
            }
            if (listRecommended.size() % 4 != 0) {
                for (int i = 0; i < 4 - listRecommended.size() % 4; i++) {
                    System.out.println("<td> &nbsp; </td>");
                }
                System.out.println("</tr>");
            }
            System.out.println("</table>");
        }
    }
}
