package one.devos.nautical.terra_fishing.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static net.minecraft.world.entity.ai.attributes.Attributes.LUCK;

public class PocketGuideItem extends Item {
    public PocketGuideItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        player.displayClientMessage(Component.literal("Fishing Luck: " + player.getAttributeValue(LUCK)), true);
        return InteractionResultHolder.success(itemStack);
    }
}
