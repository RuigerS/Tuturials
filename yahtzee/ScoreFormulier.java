package eu.additude.zarchief.yahtzee;

public class ScoreFormulier {
    private int[] categorie;
    private int spelerNR;

    ScoreFormulier(int nr) {
        categorie = new int[16];
        for (int i = 0; i < categorie.length; i++) {
            categorie[i] = -1;
        }
        spelerNR = nr;
    }

    public int getCategorie(int catNR) {
        return categorie[catNR];
    }

    public boolean setCategorie(int catNR, Worp worp) {
        int score = 0;
        boolean validScore = false;
        int[] verdeling = new int[7];
        switch (catNR) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                for (int i = 0; i < 5; i++) {
                    if (worp.items[i] == catNR) {
                        score += catNR;
                    }
                }
                categorie[catNR] = score;
                return true;
            case 7:
                for (int i = 0; i < 5; i++) {
                    verdeling[worp.items[i]]++;
                    score += worp.items[i];
                }
                for (int i = 1; i < 7; i++) {
                    if (verdeling[i] >= 3) {
                        validScore = true;
                    }
                }
                if (!validScore) {
                    score = 0;
                }
                categorie[catNR] = score;
                return true;
            case 8: //4oak
                for (int i = 0; i < 5; i++) {
                    verdeling[worp.items[i]]++;
                    score += worp.items[i];
                }
                for (int i = 1; i < 7; i++) {
                    if (verdeling[i] >= 4) {
                        validScore = true;
                    }
                }
                if (!validScore) {
                    score = 0;
                }
                categorie[catNR] = score;
                return true;
            case 9: //full house 25
                boolean threeScore = false;
                boolean twoScore = false;
                for (int i = 0; i < 5; i++) {
                    verdeling[worp.items[i]]++;
                }
                for (int i = 1; i < 7; i++) {
                    if (verdeling[i] == 3) {
                        threeScore = true;
                    }
                    if (verdeling[i] == 2) {
                        twoScore = true;
                    }
                }
                if (threeScore && twoScore) {
                    score = 25;
                }
                categorie[catNR] = score;
                return true;
            case 10: //kl straat 30
                for (int i = 0; i < 5; i++) {
                    verdeling[worp.items[i]]++;
                }
                if ((verdeling[1] > 0 && verdeling[2] > 0 && verdeling[3] > 0 && verdeling[4] > 0) ||
                        (verdeling[2] > 0 && verdeling[3] > 0 && verdeling[4] > 0 && verdeling[5] > 0) ||
                        (verdeling[3] > 0 && verdeling[4] > 0 && verdeling[5] > 0 && verdeling[6] > 0)) {
                    score = 30;
                }
                categorie[catNR] = score;
                return true;
            case 11: //gr straat 40
                for (int i = 0; i < 5; i++) {
                    verdeling[worp.items[i]]++;
                }
                if ((verdeling[1] > 0 && verdeling[2] > 0 && verdeling[3] > 0 && verdeling[4] > 0 && verdeling[5] > 0) ||
                        (verdeling[2] > 0 && verdeling[3] > 0 && verdeling[4] > 0 && verdeling[5] > 0 && verdeling[6] > 0)) {
                    score = 40;
                }
                categorie[catNR] = score;
                return true;
            case 12: //kans  punten
                for (int i = 0; i < 5; i++) {
                    score += worp.items[i];
                }
                categorie[catNR] = score;
                return true;
            case 13: //yahtzee
                for (int i = 0; i < 5; i++) {
                    verdeling[worp.items[i]]++;
                }
                for (int i = 1; i < 7; i++) {
                    if (verdeling[i] >= 5) {
                        validScore = true;
                    }
                    if (validScore) {
                        score = 50;
                    }
                    categorie[catNR] = score;
                    return true;
                }
        }
        return false;
    }

    public void printScoreFormulier() {
        System.out.print("Score  speler " + spelerNR);
        categorie[14] = 0;
        categorie[15] = 0;
        System.out.printf("%10s", "\n1-en [1]: ");
        if (categorie[1] >= 0) {
            System.out.printf("%5s ", categorie[1]);
            categorie[14] += categorie[1];
        } else {
            System.out.printf("%5s ", "-");
        }
        System.out.printf("%16s", "3 ofa kind [7]: ");
        if (categorie[7] >= 0) {
            System.out.printf("%5s %n", categorie[7]);
            categorie[15] += categorie[7];
        } else {
            System.out.printf("%5s %n", "-");
        }


        System.out.printf("%10s", "2-en [2]: ");
        if (categorie[2] >= 0) {
            System.out.printf("%5s ", categorie[2]);
            categorie[14] += categorie[2];
        } else {
            System.out.printf("%5s ", "-");
        }
        System.out.printf("%16s", "4 ofa kind [8]: ");
        if (categorie[8] >= 0) {
            System.out.printf("%5s %n", categorie[8]);
            categorie[15] += categorie[8];
        } else {
            System.out.printf("%5s %n", "-");
        }

        System.out.printf("%10s", "3-en [3]: ");
        if (categorie[3] >= 0) {
            System.out.printf("%5s ", categorie[3]);
            categorie[14] += categorie[3];
        } else {
            System.out.printf("%5s ", "-");
        }
        System.out.printf("%16s", "Full house [9]: ");
        if (categorie[9] >= 0) {
            System.out.printf("%5s %n", categorie[9]);
            categorie[15] += categorie[9];
        } else {
            System.out.printf("%5s %n", "-");
        }

        System.out.printf("%10s", "4-en [4]: ");
        if (categorie[4] >= 0) {
            System.out.printf("%5s ", categorie[4]);
            categorie[14] += categorie[4];
        } else {
            System.out.printf("%5s ", "-");
        }
        System.out.printf("%16s", "Kl straat [10]: ");
        if (categorie[10] >= 0) {
            System.out.printf("%5s %n", categorie[10]);
            categorie[15] += categorie[10];
        } else {
            System.out.printf("%5s %n", "-");
        }

        System.out.printf("%10s", "5-en [5]: ");
        if (categorie[5] >= 0) {
            System.out.printf("%5s ", categorie[5]);
            categorie[14] += categorie[5];
        } else {
            System.out.printf("%5s ", "-");
        }
        System.out.printf("%16s", "Gr straat [11]: ");
        if (categorie[11] >= 0) {
            System.out.printf("%5s %n", categorie[11]);
            categorie[15] += categorie[11];
        } else {
            System.out.printf("%5s %n", "-");
        }

        System.out.printf("%10s", "6-en [6]: ");
        if (categorie[6] >= 0) {
            System.out.printf("%5s ", categorie[6]);
            categorie[14] += categorie[6];
        } else {
            System.out.printf("%5s ", "-");
        }
        System.out.printf("%16s", "Kans [12]: ");
        if (categorie[12] >= 0) {
            System.out.printf("%5s %n", categorie[12]);
            categorie[15] += categorie[12];
        } else {
            System.out.printf("%5s %n", "-");
        }

        System.out.printf("%10s", "kolom: ");
        System.out.printf("%5s ", categorie[14]);
        System.out.printf("%16s", "Yahtzee [13]: ");
        if (categorie[13] >= 0) {
            System.out.printf("%5s %n", categorie[13]);
            categorie[15] += categorie[13];
        } else {
            System.out.printf("%5s %n", "-");
        }

        System.out.printf("%10s", "bonus: ");
        System.out.printf("%5s ", categorie[14] > 63 ? 35 : 0);
        System.out.printf("%16s", "bonus: ");
        if (categorie[0] < 0) {
            categorie[0] = 0;
        }
        System.out.printf("%5s %n", categorie[0]);
        categorie[15] += categorie[0];

        System.out.printf("%10s", "totaal 1: ");
        categorie[14] += (categorie[14] > 63 ? 35 : 0);
        System.out.printf("%5s ", categorie[14]);
        System.out.printf("%16s", "totaal 2: ");
        System.out.printf("%5s %n", categorie[15]);

        System.out.printf("%10s", " ");
        System.out.printf("%5s ", " ");
        System.out.printf("%16s", "Totaal score: ");
        System.out.printf("%5s ", categorie[14] + categorie[15]);
        System.out.println("\n");
    }

}
