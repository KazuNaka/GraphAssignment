public class Look implements Command {
    private Player player;

    public Look(Player p) {
        player = p;
    }
    @Override
    public void execute() {
        System.out.println("Neighbors :" + player.getCurrentroom().getNeighborNames() + ", ");
        System.out.println(player.getCurrentroom().displayItemList());
        System.out.println(player.getCurrentroom().displayCreatures());
    }
}