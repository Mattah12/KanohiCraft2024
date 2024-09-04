package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
    }
}