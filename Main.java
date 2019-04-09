import java.util.Scanner;

public class Main {
// Textworld 4

    public static void main(String[] args) {
        Level g = new Level();
        g.addNode("hall", "a long dark hallway");
        g.addNode("closet", "a dark, dark closet");
        g.addNode("dungeon", "dungeon that you can go in ");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");

        g.getNode("hall").addItem(new Item("apple", "fresh"));
        g.getNode("closet").addItem(new Item("hat", "---"));

//        Level.Room current = g.getNode("hall");
        Player p = new Player("bob", "---");
        p.setCurrentroom(g.getNode("hall"));
        Level.Room current = p.getCurrentroom();

        g.getNode("closet").addCreature(new Chicken(g.getNode("closet")));

        String response = "";
        Scanner s = new Scanner(System.in);

        System.out.println("Commands: go <roomname>, look, add <roomname>, take <roomname>, drop <roomname>, quit");

        do{

            System.out.println("You are in the " + p.getCurrentroom().getName());
            System.out.println("What do you want to do? >");
            response = s.nextLine();
            String[] words = response.split(" ");
            String firstword = words[0];


            if (firstword.equals("go")){
                String destination = words[1];
                p.setCurrentroom(g.getNode(destination));
            } else if (firstword.equals("look")){
                System.out.println("Neighbors :" + p.getCurrentroom().getNeighborNames());
                p.getCurrentroom().displayItemList();
            } else if (firstword.equals("add")) {
                String destination = words[1];
                String description = "";
                Scanner d = new Scanner(System.in);
                System.out.println("Give description of your room >");
                description = d.nextLine();
                g.addNode(destination, description);
                g.addUndirectedEdge(current.getName(), destination);
            }else if(firstword.equals("take")) {
                for (Item n : p.getCurrentroom().getItems()) {
                    if(n.getName().equals(words[1])) {
                        p.addItem(n);
                        p.getCurrentroom().removeItem(n.getName());
                    }
                }
                p.addItem(p.getCurrentroom().getItems().get(0));
                p.getCurrentroom().removeItem(words[1]);
            }else if (firstword.equals("drop")){
                p.getCurrentroom().addItem(p.removeItem(words[1]));
            } else if (firstword.equals("quit")) {
                response = "quit";
            } else {
                System.out.println("Could not define the command, Commands: go <roomname>, look, add <roomname>, take <roomname>, drop <roomname>, quit");
            }

        }while(!response.equals("quit"));

    }


}