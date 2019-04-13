import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
//TextWorld 4

public class Level {
    //    private List<Room> nodes;
    private HashMap<String, Room> nodes;


    public Level() {
        nodes = new HashMap<String, Room>();
    }


    public void addNode(String name, String description) {
        nodes.put(name, new Room(name, description));
    }

    public void addDirectedEdge(String name1, String name2) {
        Room n1, n2;
        n1 = nodes.get(name1);
        n2 = nodes.get(name2);

        if(n1 == null || n2 == null) System.out.println("Cannot Add edge");
        else n1.addNeighbors(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        addDirectedEdge(name1, name2);
        addDirectedEdge(name2, name1);
    }

    public Room getNode(String name) {
        return nodes.get(name);
    }

    public ArrayList<Room> getRooms() {
        HashMap<String, Level.Room> map = nodes;
        ArrayList<Level.Room> rooms = new ArrayList<Level.Room>(map.values());

        return rooms;
    }

    public class Room {
        private String name;
        private String description;
        private HashMap<String, Room> neighbors;
        private ArrayList<Item> items;
        private ArrayList<Creature> creatures;


        public void setDescription(String description) {
            this.description = description;

        }

        private Room(String name, String description) {
            neighbors = new HashMap<String, Room>();
            this.name = name;
            this.description = description;
            items = new ArrayList<Item>();
            creatures = new ArrayList<Creature>();
        }
        public ArrayList<Item> getItems() {
            return items;
        }

        public String displayItemList() {
            String itemlist = "Items in this room : ";
            for (Item n : items) {
                itemlist += n.getName() + ", ";
            }

            return itemlist;
        }

        public void addItem(Item n) {
            items.add(n);
        }

        public void removeItem(String name) {
            boolean isRemoved = false;
            Item removeItem = null;
            Iterator<Item> iterator;

            for (iterator = items.iterator(); iterator.hasNext(); ) {
                removeItem = iterator.next();
                if(removeItem.getName().equals(name)) {
                    iterator.remove();
                    isRemoved = true;
                }
            }

            if(isRemoved == true) {
                System.out.println(name + " is removed from the room");
            } else {
                System.out.println("No item called " + name + " in this room");
            }

        }

        public void addNeighbors(Room n) {
            neighbors.put(n.getName(), n);
        }

        public String getName() {
            return name;
        }

        public Room getNeighbor(String name) {
            return neighbors.get(name);
        }

        public HashMap<String, Room> getNeighbors() {
            return neighbors;
        }

        public String getNeighborNames() {
            String NeighborList = "";
            for(String n : neighbors.keySet()) {
                NeighborList = NeighborList + " " + n;
            }
            return NeighborList;
        }


        public void addCreature(Creature c) {
            creatures.add(c);
        }

        public  void removeCreature(Creature c) {
            Creature creature = null;
            Iterator<Creature> iter;

            for (iter = creatures.iterator(); iter.hasNext(); ) {
                creature = iter.next();
                if(creature.getType().equals(c.getType())) {
                    iter.remove();
                }
            }
        }

        public void destroyCreature(Creature c) {
            creatures.remove(c);
        }

        public ArrayList<Creature> getCreatures() {
            return creatures;
        }



        public void moveAllCreatures() {
            for(Creature c: creatures) {
                if(c.getIsMoved() == false ) {
                    c.move();
                }
            }
        }

        public String displayCreatures() {
            String creatureList = "Creatures : ";
            for (Creature c : creatures) {
                creatureList += c.getType() + ", ";
            }

            return creatureList;
        }

        public void resetIsMoved() {
            for (Creature c: creatures) {
                c.setIsMovedToFalse();
            }
        }
    }
}