package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

        blockWithItem(ModBlocks.LIGHTSTONE_STONE_LAMP);
        blockWithItem(ModBlocks.LIGHTSTONE_WOOD_LAMP);
        blockWithItem(ModBlocks.LIGHTSTONE_REFINED_STONE_LAMP);
        blockWithItem(ModBlocks.LIGHTSTONE_REFINED_WOOD_LAMP);

        logBlock(((RotatedPillarBlock) ModBlocks.VUATA_MACA_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.VUATA_MACA_WOOD.get()),
                blockTexture(ModBlocks.VUATA_MACA_LOG.get()), blockTexture(ModBlocks.VUATA_MACA_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.VUATA_MACA_LOG_COVERED.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.VUATA_MACA_LOG_HALF_COVERED.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.VUATA_MACA_STRIPPED_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.VUATA_MACA_STRIPPED_WOOD.get()),
                blockTexture(ModBlocks.VUATA_MACA_STRIPPED_LOG.get()), blockTexture(ModBlocks.VUATA_MACA_STRIPPED_LOG.get()));

        blockItem(ModBlocks.VUATA_MACA_LOG);
        blockItem(ModBlocks.VUATA_MACA_LOG_COVERED );
        blockItem(ModBlocks.VUATA_MACA_LOG_HALF_COVERED);
        blockItem(ModBlocks.VUATA_MACA_WOOD);
        blockItem(ModBlocks.VUATA_MACA_STRIPPED_LOG);
        blockItem(ModBlocks.VUATA_MACA_STRIPPED_WOOD);

        blockWithItem(ModBlocks.VUATA_MACA_PLANKS);

        leavesBlock(ModBlocks.VUATA_MACA_LEAVES);
        saplingBlock(ModBlocks.VUATA_MACA_SAPLING);




    }
    private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    private void saplingBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlock(deferredBlock.get(), models().cross(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), blockTexture(deferredBlock.get())).renderType("cutout"));
    }
    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("kanohicraft:block/" + deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("kanohicraft:block/" + deferredBlock.getId().getPath() + appendix));
    }
}