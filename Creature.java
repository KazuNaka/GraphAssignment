import java.util.ArrayList;
import java.util.HashMap;

public abstract class Creature {
    protected Level.Room currentroom;
    protected Level.Room currentPlayerRoom;
    protected Player p;
    protected String type;
    protected boolean isMoved = false;

    public String getType() {
        return type;
    }
    protected abstract void move();

    protected Level.Room getCurrentroom() {
        return currentroom;
    }

    protected void setCurrentroom(Level.Room n){
        currentroom = n;
    }

    protected void setCurrentPlayerRoom(Level.Room n) {
        currentPlayerRoom = n;
    }

    public Level.Room getCurrentPlayerRoom() {
        return currentPlayerRoom;
    }


    protected void randomMove() {
        HashMap<String, Level.Room> map = currentroom.getNeighbors();
        ArrayList<Level.Room> rooms = new ArrayList<Level.Room>(map.values());
        int temp = (int)(Math.random() * rooms.size());

        Level.Room next = rooms.get(temp);

        currentroom.removeCreature(this);
        setCurrentroom(next);
        currentroom.addCreature(this);
        isMoved = true;
    }


    public boolean getIsMoved() {
        return isMoved;
    }

    public  void setIsMovedToFalse() {
        isMoved = false;
    }
}
