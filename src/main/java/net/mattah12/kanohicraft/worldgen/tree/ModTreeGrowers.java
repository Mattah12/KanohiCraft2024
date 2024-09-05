package net.mattah12.kanohicraft.worldgen.tree;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower VUATA_MACA = new TreeGrower(KanohiCraft.MOD_ID + ":vuata_maca",
            Optional.empty(), Optional.of(ModConfiguredFeatures.VUATA_MACA_KEY), Optional.empty());
}
