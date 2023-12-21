package one.devos.nautical.terra_fishing;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import one.devos.nautical.terra_fishing.util.Registrar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static one.devos.nautical.terra_fishing.util.Registrar.SEXTANT;

public class TerraFishing implements ModInitializer {
	public static String MODID = "terra_fishing";
    public static final Logger LOGGER = LoggerFactory.getLogger("Terra Fishing");

	public static final ResourceKey<CreativeModeTab> ITEM_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(MODID, "discovery.tab"));
	public static final CreativeModeTab TERRA_FISHING_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(SEXTANT))
			.title(Component.translatable("itemGroup.terra_fishing.test_group"))
			.build();

	@Override
	public void onInitialize() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEM_GROUP, TERRA_FISHING_GROUP);
		Registrar.init();
		LOGGER.info("bobbing your bobbers");
	}
}