package one.devos.nautical.terra_fishing.items;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

import java.util.ArrayList;
import java.util.UUID;

public class AnglerArmorItem extends ArmorItem {
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    public AnglerArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
        Multimap<Attribute, AttributeModifier> map = Multimaps.newMultimap(Maps.newLinkedHashMap(), ArrayList::new);
        UUID uuid = ARMOR_MODIFIER_UUID_PER_TYPE.get(type);
        map.put(Attributes.LUCK, new AttributeModifier(uuid, "terra_fishing:fishing_luck", 2.5, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = map;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        defaultModifiers.putAll(super.getDefaultAttributeModifiers(slot));
        return slot == this.type.getSlot() ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
    }
}
