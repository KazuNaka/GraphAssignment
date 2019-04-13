public class Drop implements Command {
    private Player player;
    private String itemName;
    private Item item;

    public Drop(Player p, String name){
        player = p;
        itemName = name;
    }

    @Override
    public void execute() {
        if(player.getItems().contains(player.getItem(itemName))) {
            player.getCurrentroom().addItem(player.removeItem(itemName));
            player.destroyItem(itemName);
        } else {
            System.out.println("You do not have item called " + itemName);
        }

        player.displayInventory();
        System.out.println(player.getCurrentroom().displayItemList());
    }
}
