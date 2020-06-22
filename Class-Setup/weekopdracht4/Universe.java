package eu.additude.weekopdracht4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Universe {
    final static int HEIGHT_MAP = 10;
    final static int WIDTH_MAP = 10;
    final static int DEPTH_MAP = 10;
    final static int MAX_AFSTAND;
    final static int DENSITY = 40;
    private Segment[][][] map;
    List<Planetoid> planets = new ArrayList();

    static {
        MAX_AFSTAND = afstand(0, 0, 0, HEIGHT_MAP, WIDTH_MAP, DEPTH_MAP);
    }

    public Universe() {
        // create new maps
        map = new Segment[HEIGHT_MAP][WIDTH_MAP][DEPTH_MAP];
        for (int i = 0; i < HEIGHT_MAP; i++) {
            for (int j = 0; j < WIDTH_MAP; j++) {
                for (int k = 0; k < DEPTH_MAP; k++) {
                    map[i][j][k] = new Segment();
                }
            }
        }
        setBases();
        fillUniverse();
    }

    void setBases() {
        map[0][0][0].setSegmentPlayer(1);
        map[0][9][0].setSegmentPlayer(2);
        map[9][0][9].setSegmentPlayer(3);
        map[9][9][9].setSegmentPlayer(4);
        map[0][0][0].setSegmentType(Segment.BASE);
        map[0][9][0].setSegmentType(Segment.BASE);
        map[9][0][9].setSegmentType(Segment.BASE);
        map[9][9][9].setSegmentType(Segment.BASE);
    }

    void fillUniverse() {
        for (int i = 0; i < ((HEIGHT_MAP * WIDTH_MAP * DEPTH_MAP) / DENSITY); i++) {
            int x, y, z;
            Random random = new Random();
            x = random.nextInt(HEIGHT_MAP);
            y = random.nextInt(WIDTH_MAP);
            z = random.nextInt(DEPTH_MAP);
            while (!map[x][y][z].isEmpty()) {
                x = random.nextInt(HEIGHT_MAP);
                y = random.nextInt(WIDTH_MAP);
                z = random.nextInt(DEPTH_MAP);
            }
            map[x][y][z].setSegmentType(Segment.PLANETOID);
            planets.add(new Planetoid(x, y, z));
        }
    }

    static int afstand(int vanX, int vanY, int vanZ, int naarX, int naarY, int naarZ) {
        int temp = (vanX - naarX) * (vanX - naarX);
        temp += (vanY - naarY) * (vanY - naarY);
        temp += (vanZ - naarZ) * (vanZ - naarZ);
        temp = (int) ((Math.sqrt(temp)));
        return temp;
    }

    public Planetoid findClosestPlanet(int x, int y, int z) {
        int dichtbij1 = 0, dichtbij2 = 0, dichtbij3 = 0;
        int afstand1 = MAX_AFSTAND, afstand2 = MAX_AFSTAND, afstand3 = MAX_AFSTAND;
        for (Planetoid tmpPlanet : planets) {
            int tmpAfstand = afstand(x, y, z, tmpPlanet.getPosX(), tmpPlanet.getPosY(), tmpPlanet.getPosZ());
            if (tmpAfstand < afstand1) {
                afstand3 = afstand2;
                afstand2 = afstand1;
                afstand1 = tmpAfstand;
                dichtbij3 = dichtbij2;
                dichtbij2 = dichtbij1;
                dichtbij1 = planets.indexOf(tmpPlanet);
            } else if (tmpAfstand < afstand2) {
                afstand3 = afstand2;
                afstand2 = tmpAfstand;
                dichtbij3 = dichtbij2;
                dichtbij2 = planets.indexOf(tmpPlanet);
            } else if (tmpAfstand < afstand3) {
                afstand3 = tmpAfstand;
                dichtbij3 = planets.indexOf(tmpPlanet);
            }
        }
        return planets.get(dichtbij1);
    }
}

