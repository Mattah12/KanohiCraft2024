package net.mattah12.kanohicraft.worldgen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> VUATA_MACA_PLACED_KEY = registerKey("vuata_maca_placed");

    public static final ResourceKey<PlacedFeature> PROTODERMIS_ORE_PLACED_KEY = registerKey("protodermis_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_PROTODERMIS_ORE_PLACED_KEY = registerKey("nether_protodermis_ore_placed");
    public static final ResourceKey<PlacedFeature> END_PROTODERMIS_ORE_PLACED_KEY = registerKey("end_protodermis_ore_placed");

    public static final ResourceKey<PlacedFeature> LIGHTSTONE_ORE_PLACED_KEY = registerKey("lightstone_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, VUATA_MACA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VUATA_MACA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.5f, 2),
                        ModBlocks.VUATA_MACA_SAPLING.get()));

        register(context, PROTODERMIS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_PROTODERMIS_ORE_KEY),
                ModOrePlacements.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(40))));
        register(context, NETHER_PROTODERMIS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_PROTODERMIS_ORE_KEY),
                ModOrePlacements.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(40))));
        register(context, END_PROTODERMIS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_PROTODERMIS_ORE_KEY),
                ModOrePlacements.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(40))));


        register(context, LIGHTSTONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_LIGHTSTONE_ORE_KEY),
                ModOrePlacements.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(70))));
}
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID, name));
    }
    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

