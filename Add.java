import java.util.Scanner;

public class Add implements Command {
    private String roomname;
    private String description;
    private Player player;
    private Level level;
    public Add(Player p, String rmname, Level g) {
        roomname = rmname;
        level = g;
        player = p;
    }
    @Override
    public void execute() {
        String description = "";
        Scanner d = new Scanner(System.in);
        System.out.println("Give description of your room >");
        description = d.nextLine();
        level.addNode(roomname, description);
        level.addUndirectedEdge(player.getCurrentroom().getName(), roomname);
    }
}