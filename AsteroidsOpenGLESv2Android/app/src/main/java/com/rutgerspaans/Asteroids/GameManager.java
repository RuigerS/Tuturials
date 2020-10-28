package com.rutgerspaans.Asteroids;

public class GameManager {
    int mapWidth;
    int mapHeight;
    private boolean playing=false;

    SpaceShip ship;

    Border border;

    Star[] stars;
    int numStars;

    Bullet [] bullets;
    int numBullets;

    Asteroid [] asteroids;
    int numAsteroids;
    int numAsteroidsRemaining;
    int baseNumAsteroids;
    int levelNumber;

    int screenWidth;
    int screenHeight;

    int metresToShowX;
    int metresToShowY;

    TallyIcon[] tallyIcons;
    int numLives;
    LifeIcon[] lifeIcons;

    public GameManager(int screenWidth, int screenHeight){
        this.screenWidth=screenWidth;
        this.screenHeight=screenHeight;
        mapWidth=600;
        mapHeight=600;
        metresToShowX=390;
        metresToShowY=220;
        numStars = 200;
        numBullets = 20;
        // For all our asteroids
        asteroids = new Asteroid[500];
        lifeIcons = new LifeIcon[50];
        tallyIcons = new TallyIcon[500];
        baseNumAsteroids = 10;
        levelNumber = 1;
        numLives = 3;
    }
    public void switchPlayingStatus(){
        playing=!playing;
    }

    public boolean isPlaying() {
        return playing;
    }
}
