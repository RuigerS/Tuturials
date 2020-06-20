package eu.additude.zarchief.yahtzee;

import java.util.ArrayList;
import java.util.List;

public class Speler {
    private List<Worp> worpGeschiedenis;
    private ScoreFormulier scoreformulier;

    Speler(int nr) {
        scoreformulier = new ScoreFormulier(nr);
        worpGeschiedenis = new ArrayList<Worp>();
    }

    public void setWorp(Worp worp) {
        worpGeschiedenis.add(worp);
    }

    public void printScore() {
        scoreformulier.printScoreFormulier();
    }

    public boolean kiesScore(int keuze, Worp worp) {
        if (scoreformulier.getCategorie(keuze) >= 0) {
            return false;
        }
        return scoreformulier.setCategorie(keuze, worp);
    }
}
