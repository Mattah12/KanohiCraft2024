package net.mattah12.kanohicraft.item;

import net.mattah12.kanohicraft.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier PROTODERMIS = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_PROTODERMIS_TOOL,
            500, 6f, 2.5f, 15,
            () -> Ingredient.of(ModItems.INGOT_PROTODERMIS.get()));
}
