public class Go implements Command {
    private String destination;
    private Player player;
    private Level level;

    public Go(String n, Player p, Level l) {
        destination = n;
        player = p;
        level = l;
    }
    @Override
    public void execute() {
        player.setCurrentroom(level.getNode(destination));
    }
}