import java.util.ArrayList;
import java.util.Scanner;

public class Main {
// Textworld 4

    public static void main(String[] args) {
        Level g = new Level();
        g.addNode("hall", "a long dark hallway");
        g.addNode("closet", "a dark, dark closet");
        g.addNode("dungeon", "dungeon that you can go in ");
        g.addNode("Wumpus House", "There are Wumpus");
        g.addNode("Chicken House", "There are chickens");
        g.addNode("PopStar House", "There are popstars");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");
        g.addUndirectedEdge("dungeon", "Wumpus House");
        g.addUndirectedEdge("dungeon", "Chicken House");
        g.addUndirectedEdge("Chicken House", "PopStar House");

        g.getNode("hall").addItem(new Item("apple", "fresh"));
        g.getNode("hall").addItem(new Item("orange", "fresh"));
        g.getNode("closet").addItem(new Item("hat", "---"));
        g.getNode("Chicken House").addCreature(new Chicken(g.getNode("Chicken House")));
        g.getNode("Wumpus House").addCreature(new Wumpus(g.getNode("Wumpus House")));
        g.getNode("PopStar House").addCreature(new PopStar(g.getNode("PopStar House")));



        Player p = new Player("bob", "---");
        p.setCurrentroom(g.getNode("hall"));
        Level.Room current = p.getCurrentroom();

        String response = "";
        Scanner s = new Scanner(System.in);

        ArrayList<Level.Room> roomsList;

        do{
            System.out.println("Commands: go <roomname>, look, add <roomname>, take <roomname>, drop <roomname>, quit");
            System.out.println("You are in the " + p.getCurrentroom().getName());
            System.out.println("What do you want to do? >");
            response = s.nextLine();

            Command command = parseCommand(response, p, g);
            command.execute();

            roomsList = g.getRooms();
            for (Level.Room rm : roomsList) {
                rm.moveAllCreatures();
            }

            for (Level.Room rm : roomsList) {
                rm.resetIsMoved();
            }


        }while(!response.equals("quit"));

        System.out.println("END");

    }


    public static Command parseCommand(String response, Player player, Level level) {
        String[] words = response.split(" ");
        String firstword = words[0];
        String secondWord = "";
        String newResponse = "";
        Scanner s = new Scanner(System.in);

        if(words.length >= 2)secondWord = words[1];


        if (firstword.equals("go")){
            return new Go(secondWord, player, level);
        } else if (firstword.equals("look")){
            return new Look(player);
        } else if (firstword.equals("add")) {
            return new Add(player, secondWord, level);
        }else if(firstword.equals("take")) {
            return new Take(player, secondWord);
        }else if (firstword.equals("drop")){
            return new Drop(player, secondWord);
        } else if (firstword.equals("quit")) {
            return new Quit(response);
        } else {
            System.out.println("You are in the " + player.getCurrentroom().getName());
            System.out.println("What do you want to do? >");
            newResponse = s.nextLine();
            return parseCommand(newResponse, player, level);
        }

    }


}