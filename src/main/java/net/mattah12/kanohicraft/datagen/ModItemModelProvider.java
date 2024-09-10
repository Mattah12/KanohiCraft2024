package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.mattah12.kanohicraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

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

        saplingItem(ModBlocks.VUATA_MACA_SAPLING);

        buttonItem(ModBlocks.VUATA_MACA_BUTTON, ModBlocks.VUATA_MACA_PLANKS);
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID,"block/" + item.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}