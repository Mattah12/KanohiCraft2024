package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
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
        blockItem(ModBlocks.VUATA_MACA_STAIRS);
        blockItem(ModBlocks.VUATA_MACA_SLAB);
        blockItem(ModBlocks.VUATA_MACA_PRESSURE_PLATE);
        blockItem(ModBlocks.VUATA_MACA_FENCE_GATE);

        blockItem(ModBlocks.VUATA_MACA_TRAPDOOR, "_bottom");

        blockWithItem(ModBlocks.VUATA_MACA_PLANKS);

        leavesBlock(ModBlocks.VUATA_MACA_LEAVES);

        saplingBlock(ModBlocks.VUATA_MACA_SAPLING);

        stairsBlock(((StairBlock) ModBlocks.VUATA_MACA_STAIRS.get()), blockTexture(ModBlocks.VUATA_MACA_PLANKS.get()));

        slabBlock(((SlabBlock) ModBlocks.VUATA_MACA_SLAB.get()), blockTexture(ModBlocks.VUATA_MACA_PLANKS.get()), blockTexture(ModBlocks.VUATA_MACA_PLANKS.get()));

        pressurePlateBlock(((PressurePlateBlock) ModBlocks.VUATA_MACA_PRESSURE_PLATE.get()), blockTexture(ModBlocks.VUATA_MACA_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.VUATA_MACA_BUTTON.get()), blockTexture(ModBlocks.VUATA_MACA_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.VUATA_MACA_FENCE.get()), blockTexture(ModBlocks.VUATA_MACA_PLANKS.get()));

        fenceGateBlock(((FenceGateBlock) ModBlocks.VUATA_MACA_FENCE_GATE.get()), blockTexture(ModBlocks.VUATA_MACA_PLANKS.get()));

        wallBlock(((WallBlock) ModBlocks.VUATA_MACA_WALL.get()), blockTexture(ModBlocks.VUATA_MACA_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.VUATA_MACA_DOOR.get()), modLoc("block/vuata_maca_door_bottom"),
                modLoc("block/vuata_maca_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.VUATA_MACA_TRAPDOOR.get()),
                modLoc("block/vuata_maca_trapdoor"), true, "cutout");



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