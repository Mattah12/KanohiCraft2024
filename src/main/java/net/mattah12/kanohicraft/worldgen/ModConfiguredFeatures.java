package net.mattah12.kanohicraft.worldgen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> VUATA_MACA_KEY = registerKey("vuata_maca");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PROTODERMIS_ORE_KEY = registerKey("protodermis_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_PROTODERMIS_ORE_KEY = registerKey("nether_protodermis_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_PROTODERMIS_ORE_KEY = registerKey("end_protodermis_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_LIGHTSTONE_ORE_KEY = registerKey("lightstone_ore");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, VUATA_MACA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.VUATA_MACA_LOG.get()),
                new ForkingTrunkPlacer(4, 5, 3),
                BlockStateProvider.simple(ModBlocks.VUATA_MACA_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 1),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldProtodermisOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.PROTODERMIS_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.PROTODERMIS_DEEPSLATE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldLightstoneOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.LIGHTSTONE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.LIGHTSTONE_DEEPSLATE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_PROTODERMIS_ORE_KEY, Feature.ORE, new OreConfiguration(overworldProtodermisOres, 7));
        register(context, NETHER_PROTODERMIS_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.PROTODERMIS_NETHER_ORE.get().defaultBlockState(), 7));
        register(context, END_PROTODERMIS_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.PROTODERMIS_NETHER_ORE.get().defaultBlockState(), 7));


        register(context, OVERWORLD_LIGHTSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldProtodermisOres, 3));


    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID, name));
    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}