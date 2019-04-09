import java.util.ArrayList;
import java.util.HashMap;

public class PopStar extends Creature {

    public PopStar(Level.Room n ) {
        super(n);
    }
    @Override
    protected void move() {
        HashMap<String, Level.Room> map = currentroom.getNeighbors();
        ArrayList<Level.Room> rooms = new ArrayList<Level.Room>(map.values());

        if(rooms.contains(currentPlayerRoom)) {
            Level.Room next = currentPlayerRoom;

            currentroom.removeCreature(this);
            setCurrentroom(next);
            currentroom.addCreature(this);

        } else {
            randomMove();
        }

    }
}
