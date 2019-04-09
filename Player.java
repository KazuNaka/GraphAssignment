import java.util.ArrayList;

public class Player {
    private String name, description;
    private ArrayList<Item> items;
    private Level.Room currentroom;

    public Player(String n, String d) {
        name = n;
        description = d;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String name) {
        for (Item i : items) {
            if(name.equals(i.getName())) {
                items.remove(i);
                return i;
            }
        }
        return null;
    }

    public boolean destroyItem (String name) {
        for (Item i : items) {
            if(name.equals(i.getName())) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public void displayInventory() {
        System.out.print("Items : ");
        for (Item item: items) {
            System.out.print(item.getName() + ", ");
        }
    }

    public Level.Room getCurrentroom(){
        return currentroom;
    }

    public void setCurrentroom(Level.Room newroom) {
        currentroom = newroom;
    }

    public boolean movetoRooom(String name) {
        if(currentroom.getNeighbor(name).getName().equals(name)) {
            currentroom = currentroom.getNeighbor(name);
            return true;
        }
        else return false;
    }
}