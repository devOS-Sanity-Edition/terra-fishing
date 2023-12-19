package one.devos.nautical.terra_fishing.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static net.minecraft.world.entity.ai.attributes.Attributes.LUCK;

public class FishFinderItem extends Item {
    public FishFinderItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        player.displayClientMessage(Component.literal("Fishing Luck: " + player.getAttributeValue(LUCK) + " | " + getWeather(level) + " | " + getMoonPhase(level) + " | " + getPlayerCoords(player)), true);
        return InteractionResultHolder.success(itemStack);
    }

    private String getWeather(Level level) {
        String clearOrRainOrThunder = "Clear";
        if(level.isRaining()) clearOrRainOrThunder = "Raining";
        if (level.isThundering()) clearOrRainOrThunder = "Thundering";
        return clearOrRainOrThunder;
    }

    private String getMoonPhase(Level level) {
        int phase = level.getMoonPhase();
        switch(phase) {
            case 0:
                return "Full Moon (0)";
            case 1:
                return "Waning Gibbous (1)";
            case 2:
                return "Last Quarter (2)";
            case 3:
                return "Waning Crescent (3)";
            case 4:
                return "New Moon (4)";
            case 5:
                return "Waxing Crescent (5)";
            case 6:
                return "First Quarter (6)";
            case 7:
                return "Waxing Gibbous (7)";
            default:
                return "Unknown Moon Phase";
        }
    }

    private String getPlayerCoords(Player player) {
        int playerX = (int) player.getX();
        int playerZ = (int) player.getZ();
        return "X: " + playerX + ", Z: " + playerZ;
    }

}
