import com.sun.media.jfxmedia.events.PlayerEvent;

import java.util.ArrayList;

public class Take implements Command {
    private Player player;
    private String itemName;
    private Item item = null;

    public Take(Player p, String name) {
        player = p;
        itemName = name;

    }
    @Override
    public void execute() {
        for (Item n : player.getCurrentroom().getItems()) {
            if(n.getName().equals(itemName)) item = n;
        }

        if(item == null) {
            System.out.println("This room does not have " + itemName);
        } else {
            player.addItem(item);
            player.getCurrentroom().removeItem(item.getName());
        }


        player.displayInventory();
        System.out.println(player.getCurrentroom().displayItemList());
    }
}