import java.util.ArrayList;
import java.util.HashMap;

public class Wumpus extends Creature {

    public Wumpus(Level.Room n) {
        type = "Wumpus";
        setCurrentroom(n);
    }
    @Override
    protected void move() {
        HashMap<String, Level.Room> map = currentroom.getNeighbors();
        ArrayList<Level.Room> rooms = new ArrayList<Level.Room>(map.values());

        if(rooms.contains(currentPlayerRoom)) {
            System.out.println("Wumpus is close!");
            rooms.remove(currentPlayerRoom);
            int temp = (int)(Math.random() * rooms.size());

            Level.Room next = rooms.get(temp);

            currentroom.removeCreature(this);
            setCurrentroom(next);
            currentroom.addCreature(this);
            isMoved = true;

        } else {
            randomMove();
        }

    }

}