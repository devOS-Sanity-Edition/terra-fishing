package one.devos.nautical.terra_fishing.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import one.devos.nautical.terra_fishing.items.*;

import static one.devos.nautical.terra_fishing.TerraFishing.ITEM_GROUP;
import static one.devos.nautical.terra_fishing.TerraFishing.MODID;

public class Registar {
    // Items
    public static final Item SEXTANT = registerItem("sextant", new SextantItem(new FabricItemSettings().stacksTo(1)));
    public static final Item RADIO = registerItem("radio", new RadioItem(new FabricItemSettings().stacksTo(1)));
    public static final Item POCKET_GUIDE = registerItem("pocket_guide", new PocketGuideItem(new FabricItemSettings().stacksTo(1)));
    public static final Item FISH_FINDER = registerItem("fish_finder", new FishFinderItem(new FabricItemSettings().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item EARRING = registerItem("earring", new EarringTrinketItem(new FabricItemSettings().stacksTo(1)));
    public static final Item TACKLE_BOX = registerItem("tackle_box", new TackleBoxTrinketItem(new FabricItemSettings().stacksTo(1))); // legs/belt
//    public static final Item LAVA_HOOK; // fishing/hook
    public static final Item BOBBER = registerItem("bobber", new FishingBobberTrinketItem(new FabricItemSettings().stacksTo(1)));
    public static final Item GLOW_BOBBER = registerItem("glow_bobber", new GlowingFishingBobberTrinketItem(new FabricItemSettings().stacksTo(1).rarity(Rarity.UNCOMMON)));
//
//    public static final Item ANGLER_HAT;
//    public static final Item ANGLER_VEST;
//    public static final Item ANGLER_PANTS;
//    public static final Item ANGLER_WADERS;
//
//    public static final Item IRON_FISHING_ROD;
//    public static final Item GOLDEN_FISHING_ROD;
//    public static final Item NETHERITE_FISHING_ROD;
//
//    public static final Item GRASSHOPPERS;
//    public static final Item WORM;
//    public static final Item GOLDEN_WORM;
//    public static final Item TRUFFLE_WORM;
//    public static final Item JELLYFISH;
//    public static final Item APPRENTICE;
//    public static final Item JOURNEYMAN;
//    public static final Item MASTER;
//
//    public static final Item BOTTOMLESS_BUCKET;
//    public static final Block EMPTY_BOTTOMLESS_BUCKET;
    
//    // Blocks
//    public static final Block WOODEN_CRATE;
//    public static final Block IRON_CRATE;
//    public static final Block GOLDEN_CRATE;

    public static Item registerItem(String name, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> content.accept(item));
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, name), item);
    }

    public static void init() {}

}
