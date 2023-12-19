package one.devos.nautical.terra_fishing.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SextantItem extends Item {
    public SextantItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        player.displayClientMessage(Component.literal(getPlayerCoords(player)), true);
        return InteractionResultHolder.success(itemStack);
    }

    private String getPlayerCoords(Player player) {
        int playerX = roundToNearest50((int) player.getX());
        int playerZ = roundToNearest50((int) player.getZ());
        String roundedXY = "X: " + playerX + ", Z: " + playerZ;
        return "By the stars, you are close to " + roundedXY;
    }

    private int roundToNearest50(int num) {
        if (num%50 < 25) {
            return num - (num%50);
        }
        else if (num%50 > 25) {
            return num + (50 - (num%50));
        }
        else {
            return num + 25;
        }
    }
}
