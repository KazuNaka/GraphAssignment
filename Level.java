import java.util.ArrayList;
import java.util.HashMap;
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

        if(n1 == null || n2 == null) System.out.println("Cannot add edge");
        else n1.addNeighbors(n2);

    }

    public void addUndirectedEdge(String name1, String name2) {
        addDirectedEdge(name1, name2);
        addDirectedEdge(name2, name1);
    }

    public Room getNode(String name) {
        return nodes.get(name);
    }

    public class Room {
        private String name;
        private String description;
        private HashMap<String, Room> neighbors;
        private ArrayList<Item> items;
        private ArrayList<Creature> creatures;


        public void setDescription(String description) {
            this.description = description;
            creatures = new ArrayList<Creature>();
        }

        private Room(String name, String description) {
            neighbors = new HashMap<String, Room>();
            this.name = name;
            this.description = description;
            items = new ArrayList<Item>();
        }
        public ArrayList<Item> getItems() {
            return items;
        }

        public void displayItemList() {
            System.out.print("Items : ");
            for (Item n : items) {
                System.out.print(n.getName() + ", ");
            }
        }

        public void addItem(Item n) {
            items.add(n);
        }

        public Item removeItem(String name) {
            Item removeItem = null;
            for (Item n : items) {
                if (n.getName().equals(name)){
                    removeItem = n;
                    items.remove(n);
                }
            }
            return removeItem;
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

        public boolean removeCreature(Creature c) {
            return creatures.remove(c);
        }

        public ArrayList<Creature> getCreatures() {
            return creatures;
        }

        public Creature getGetCreature(int i) {
            return creatures.get(i);
        }
    }
}