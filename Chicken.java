public class Chicken extends Creature {

    public Chicken(Level.Room n) {
        super(n);
    }

    @Override
    public void move() {
        randomMove();

    }
}