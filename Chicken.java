public class Chicken extends Creature {

    public Chicken(Level.Room n) {
        type = "Chicken";
        setCurrentroom(n);
    }

    @Override
    public void move() {
        randomMove();

    }
}