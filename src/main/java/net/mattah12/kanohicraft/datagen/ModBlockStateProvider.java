package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, KanohiCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PROTODERMIS_BLOCK);

        blockWithItem(ModBlocks.PROTODERMIS_ORE);
        blockWithItem(ModBlocks.PROTODERMIS_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.PROTODERMIS_NETHER_ORE);
        blockWithItem(ModBlocks.PROTODERMIS_END_ORE);

        blockWithItem(ModBlocks.LIGHTSTONE_ORE);
        blockWithItem(ModBlocks.LIGHTSTONE_DEEPSLATE_ORE );
        blockWithItem(ModBlocks.LIGHTSTONE_STONE_LAMP);
        blockWithItem(ModBlocks.LIGHTSTONE_WOOD_LAMP);
        blockWithItem(ModBlocks.LIGHTSTONE_REFINED_STONE_LAMP);
        blockWithItem(ModBlocks.LIGHTSTONE_REFINED_WOOD_LAMP);


    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}