package net.mattah12.kanohicraft.worldgen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_VUATA_MACA = registerKey("add_tree_vuata_maca");

    public static final ResourceKey<BiomeModifier> ADD_PROTODERMIS_ORE = registerKey("add_protodermis_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_PROTODERMIS_ORE = registerKey("add_nether_protodermis_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_PROTODERMIS_ORE = registerKey("add_end_protodermis_ore");

    public static final ResourceKey<BiomeModifier> ADD_LIGHTSTONE_ORE = registerKey("add_lightstone_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);



        context.register(ADD_TREE_VUATA_MACA, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST), biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.VUATA_MACA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_PROTODERMIS_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PROTODERMIS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_PROTODERMIS_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_PROTODERMIS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_PROTODERMIS_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_PROTODERMIS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_LIGHTSTONE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LIGHTSTONE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID, name));
    }


}
