package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.mattah12.kanohicraft.item.ModItems;
import net.mattah12.kanohicraft.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, KanohiCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.KANOKA)
                //.add(ModItems.BLACK_OPAL.get())
        ;tag(ModTags.Items.KANOHI)
                .add(ModItems.HAU.get())
        ;

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.VUATA_MACA_LOG.get().asItem())
                .add(ModBlocks.VUATA_MACA_WOOD.get().asItem())
                .add(ModBlocks.VUATA_MACA_STRIPPED_LOG.get().asItem())
                .add(ModBlocks.VUATA_MACA_STRIPPED_WOOD.get().asItem())
                .add(ModBlocks.VUATA_MACA_LOG_COVERED.get().asItem())
                .add(ModBlocks.VUATA_MACA_LOG_HALF_COVERED.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.VUATA_MACA_PLANKS.get().asItem());
    }
}