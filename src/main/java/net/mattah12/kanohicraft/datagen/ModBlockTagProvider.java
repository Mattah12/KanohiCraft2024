package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
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
    }
}
