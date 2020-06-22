package eu.additude.weekopdracht4;

public class Spaceship implements Miner, Fighter, Defender, Learner {
    private String typeSpaceship;
    private int defensiveHP; //damage to other flyers
    private int hullStrengthHP; //HP this flyer
    private int mineCapacity; // storageroom & production
    private int speed; // fly with speed
    private int fightHP; // damage to planetoid, conquering
    private int location;
    private byte playerOwned;

    private Spaceship() {
     }

    Spaceship createNewSpaceship(byte player, int location, String typeSpaceship) {
        Spaceship spaceship = new Spaceship();
        spaceship.typeSpaceship = typeSpaceship;
        spaceship.location = location;
        spaceship.playerOwned = player;
        spaceship.setSettingsSpaceship(spaceship);
        return spaceship;
    }

    public void mine() {

    }

    public void fight() {

    }

    public void defend() {

    }

    public void learn() {

    }
    public void setSettingsSpaceship(Spaceship spaceship){
        switch (spaceship.typeSpaceship){
            case "Miner":
                spaceship.defensiveHP=2;
                spaceship.hullStrengthHP=5000;
                spaceship.fightHP=2;
                spaceship.mineCapacity=2500;
                spaceship.speed=10;
                break;
            case "Defender":
                spaceship.defensiveHP=10;
                spaceship.hullStrengthHP=1000;
                spaceship.fightHP=10;
                spaceship.mineCapacity=250;
                spaceship.speed=50;
                break;
            case "Fighter":
                spaceship.defensiveHP=100;
                spaceship.hullStrengthHP=100;
                spaceship.fightHP=100;
                spaceship.mineCapacity=25;
                spaceship.speed=100;
                break;

        }
    }
}
