package one.devos.nautical.terra_fishing.items;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class FishingBobberTrinketItem extends TrinketItem {
    public FishingBobberTrinketItem(Properties settings) {
        super(settings);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getModifiers(ItemStack itemStack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(itemStack, slot, entity, uuid);
        modifiers.put(Attributes.LUCK, new AttributeModifier(uuid, "terra_fishing:fishing_luck", 5.0, AttributeModifier.Operation.ADDITION));
        return modifiers;
    }
}
