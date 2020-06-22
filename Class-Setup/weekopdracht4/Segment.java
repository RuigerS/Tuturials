package eu.additude.weekopdracht4;

class Segment {
    private int status;
    // SEGMENT TYPES:
    final static int TYPE_MASK = 0b0000_0000_0000_0000_0000_0000_0000_1111;
    final static int EMPTY_SPACE = 0b0000_0000_0000_0000_0000_0000_0000_0000;
    final static int PLANETOID = 0b0000_0000_0000_0000_0000_0000_0000_0001;
    final static int BASE = 0b0000_0000_0000_0000_0000_0000_0000_0010;
    final static int MINE = 0b0000_0000_0000_0000_0000_0000_0000_0100;
    final static int OUTPOST = 0b0000_0000_0000_0000_0000_0000_0000_1000;
    // OWNER:
    final static int PLAYER_MASK = 0b0000_0000_0000_0000_0000_0000_1111_0000;
    final static int HUMANOID = 0b0000_0000_0000_0000_0000_0000_0001_0000;
    final static int ANDROID1 = 0b0000_0000_0000_0000_0000_0000_0010_0000;
    final static int ANDROID2 = 0b0000_0000_0000_0000_0000_0000_0100_0000;
    final static int ANDROID3 = 0b0000_0000_0000_0000_0000_0000_1000_0000;


    Segment() {

        status = EMPTY_SPACE;
    }

    boolean isEmpty() {

        return (status == EMPTY_SPACE);
    }

    void setSegmentPlayer(int player) {
        status &=~PLAYER_MASK; //maak player info leeg
        switch (player) {
            case 1:
                status += HUMANOID;
                break;
            case 2:
                status += ANDROID1;
                break;
            case 3:
                status += ANDROID2;
                break;
            case 4:
                status += ANDROID3;
                break;
        }
    }

    void setSegmentType(int mask) {
        status &=~TYPE_MASK; //maak type info leeg
        status += mask;
    }

    @Override
    public String toString() {
        String returnMsg = "" + status + ": ";
        if (status == EMPTY_SPACE) returnMsg += "Doodse leegte en stilte ";
        else {
            if ((status & PLANETOID) > 0) returnMsg += "Niet ontgonnen Planetoid ";
            else if ((status & BASE) > 0) returnMsg += "Hoofdbasis ";
            else if ((status & MINE) > 0) returnMsg += "Mijn ";
            else if ((status & OUTPOST) > 0) returnMsg += "Voorpost ";
            else returnMsg += "Leeg ";
            if ((status & HUMANOID) > 0) returnMsg += "Humanoid";
            else if ((status & ANDROID1) > 0) returnMsg += "Bot1 ";
            else if ((status & ANDROID2) > 0) returnMsg += "Bot2 ";
            else if ((status & ANDROID3) > 0) returnMsg += "Bot3 ";
            else returnMsg += "Vrij";
        }
        return returnMsg;
    }
}
