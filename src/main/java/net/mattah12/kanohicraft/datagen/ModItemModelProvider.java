package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.mattah12.kanohicraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KanohiCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BULA_BERRY.get());
        basicItem(ModItems.VUATA_MACA.get());
        basicItem(ModItems.HAU.get());
        basicItem(ModItems.LIGHTSTONE.get());
        basicItem(ModItems.INGOT_PROTODERMIS.get());
        basicItem(ModItems.NUGGET_PROTODERMIS.get());
        basicItem(ModItems.RAW_PROTODERMIS.get());
        basicItem(ModBlocks.VUATA_MACA_DOOR.asItem());

        saplingItem(ModBlocks.VUATA_MACA_SAPLING);

        buttonItem(ModBlocks.VUATA_MACA_BUTTON, ModBlocks.VUATA_MACA_PLANKS);

        fenceItem(ModBlocks.VUATA_MACA_FENCE, ModBlocks.VUATA_MACA_PLANKS);

        wallItem(ModBlocks.VUATA_MACA_WALL, ModBlocks.VUATA_MACA_PLANKS);

        handheldItem(ModItems.PROTODERMIS_SWORD);
        handheldItem(ModItems.PROTODERMIS_PICKAXE);
        handheldItem(ModItems.PROTODERMIS_SHOVEL);
        handheldItem(ModItems.PROTODERMIS_AXE);
        handheldItem(ModItems.PROTODERMIS_HOE);
        handheldItem(ModItems.PROTODERMIS_PAXEL);
        handheldItem(ModItems.PROTODERMIS_HAMMER);


    }

    //Helper methods
    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID, "block/" + item.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID,"item/" + item.getId().getPath()));
    }
}