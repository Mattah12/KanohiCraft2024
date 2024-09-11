package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.block.ModBlocks;
import net.mattah12.kanohicraft.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PROTODERMIS_BLOCK.get());
        dropSelf(ModBlocks.LIGHTSTONE_REFINED_WOOD_LAMP.get());
        dropSelf(ModBlocks.LIGHTSTONE_REFINED_STONE_LAMP.get());
        dropSelf(ModBlocks.LIGHTSTONE_WOOD_LAMP.get());
        dropSelf(ModBlocks.LIGHTSTONE_STONE_LAMP.get());
        dropSelf(ModBlocks.LIGHTSTONE_WOOD_LAMP.get());
        dropSelf(ModBlocks.LIGHTSTONE_STONE_LAMP.get());
        dropSelf(ModBlocks.LIGHTSTONE_TORCH_BLOCK.get());
        dropSelf(ModBlocks.LIGHTSTONE_REFINED_TORCH_BLOCK.get());
        dropSelf(ModBlocks.WALL_LIGHTSTONE_TORCH.get());
        dropSelf(ModBlocks.WALL_LIGHTSTONE_REFINED_TORCH.get());

        dropSelf(ModBlocks.VUATA_MACA_LOG.get());
        dropSelf(ModBlocks.VUATA_MACA_LOG_COVERED.get());
        dropSelf(ModBlocks.VUATA_MACA_LOG_HALF_COVERED.get());
        dropSelf(ModBlocks.VUATA_MACA_WOOD.get());
        dropSelf(ModBlocks.VUATA_MACA_STRIPPED_LOG.get());
        dropSelf(ModBlocks.VUATA_MACA_STRIPPED_WOOD.get());
        dropSelf(ModBlocks.VUATA_MACA_PLANKS.get());
        dropSelf(ModBlocks.VUATA_MACA_SAPLING.get());
        dropSelf(ModBlocks.VUATA_MACA_STAIRS.get());
        dropSelf(ModBlocks.VUATA_MACA_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.VUATA_MACA_BUTTON.get());
        dropSelf(ModBlocks.VUATA_MACA_FENCE.get());
        dropSelf(ModBlocks.VUATA_MACA_FENCE_GATE.get());
        dropSelf(ModBlocks.VUATA_MACA_WALL.get());
        dropSelf(ModBlocks.VUATA_MACA_TRAPDOOR.get());

        this.add(ModBlocks.VUATA_MACA_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.VUATA_MACA_SLAB.get()));
        this.add(ModBlocks.VUATA_MACA_DOOR.get(),
                block -> createDoorTable(ModBlocks.VUATA_MACA_DOOR.get()));

        this.add(ModBlocks.VUATA_MACA_LEAVES.get(),
                block -> createLeavesDrops(block, ModBlocks.VUATA_MACA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
                createMultipleOreDrops(ModBlocks.VUATA_MACA_LEAVES.get(), ModItems.VUATA_MACA.get(), 0, 2);
        this.add(ModBlocks.LIGHTSTONE_ORE.get(),
                block -> createOreDrop(ModBlocks.LIGHTSTONE_ORE.get(), ModItems.LIGHTSTONE.get()));
        this.add(ModBlocks.LIGHTSTONE_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.LIGHTSTONE_DEEPSLATE_ORE.get(), ModItems.LIGHTSTONE.get()));
        this.add(ModBlocks.PROTODERMIS_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.PROTODERMIS_ORE.get(), ModItems.RAW_PROTODERMIS.get(), 2, 5));
        this.add(ModBlocks.PROTODERMIS_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.PROTODERMIS_DEEPSLATE_ORE.get(), ModItems.RAW_PROTODERMIS.get(), 3, 5));
        this.add(ModBlocks.PROTODERMIS_NETHER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.PROTODERMIS_NETHER_ORE.get(), ModItems.RAW_PROTODERMIS.get(), 1, 7));
        this.add(ModBlocks.PROTODERMIS_END_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.PROTODERMIS_END_ORE.get(), ModItems.RAW_PROTODERMIS.get(), 3, 6));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

