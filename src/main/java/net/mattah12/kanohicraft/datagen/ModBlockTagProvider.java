package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.mattah12.kanohicraft.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, KanohiCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PROTODERMIS_BLOCK.get())
                .add(ModBlocks.PROTODERMIS_ORE.get())
                .add(ModBlocks.PROTODERMIS_DEEPSLATE_ORE.get())
                .add(ModBlocks.PROTODERMIS_NETHER_ORE.get())
                .add(ModBlocks.PROTODERMIS_END_ORE.get())

                .add(ModBlocks.LIGHTSTONE_ORE.get())
                .add(ModBlocks.LIGHTSTONE_DEEPSLATE_ORE.get())

                .add(ModBlocks.LIGHTSTONE_STONE_LAMP.get())
                .add(ModBlocks.LIGHTSTONE_WOOD_LAMP.get())
                .add(ModBlocks.LIGHTSTONE_REFINED_STONE_LAMP.get())
                .add(ModBlocks.LIGHTSTONE_REFINED_WOOD_LAMP.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PROTODERMIS_BLOCK.get())
                .add(ModBlocks.PROTODERMIS_ORE.get())
                .add(ModBlocks.PROTODERMIS_DEEPSLATE_ORE.get())
                .add(ModBlocks.PROTODERMIS_NETHER_ORE.get())
                .add(ModBlocks.PROTODERMIS_END_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.LIGHTSTONE_ORE.get())
                .add(ModBlocks.LIGHTSTONE_DEEPSLATE_ORE.get())

                .add(ModBlocks.LIGHTSTONE_STONE_LAMP.get())
                .add(ModBlocks.LIGHTSTONE_WOOD_LAMP.get())
                .add(ModBlocks.LIGHTSTONE_REFINED_STONE_LAMP.get())
                .add(ModBlocks.LIGHTSTONE_REFINED_WOOD_LAMP.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.VUATA_MACA_LOG.get())
                .add(ModBlocks.VUATA_MACA_LOG_HALF_COVERED.get())
                .add(ModBlocks.VUATA_MACA_LOG_COVERED.get())
                .add(ModBlocks.VUATA_MACA_WOOD.get())
                .add(ModBlocks.VUATA_MACA_STRIPPED_LOG.get());

        tag(BlockTags.FENCES).add(ModBlocks.VUATA_MACA_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.VUATA_MACA_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.VUATA_MACA_WALL.get());

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL);
    }
}
