package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.block.ModBlocks;
import net.mattah12.kanohicraft.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
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

        this.add(ModBlocks.VUATA_MACA_LEAVES.get(),
                block -> createLeavesAndFruitDrops(ModBlocks.VUATA_MACA_LEAVES.get(), ModBlocks.VUATA_MACA_SAPLING.get(), ModItems.VUATA_MACA.get(), 0.3F));
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
        this.add(ModBlocks.VUATA_MACA_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.VUATA_MACA_SLAB.get()));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }


    protected LootTable.Builder createLeavesAndFruitDrops(Block leavesBlock, Block saplingBlock, Item fruitItem, float... dropChances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(
                                LootItem.lootTableItem(saplingBlock).when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), dropChances))
                                        .apply(ApplyExplosionDecay.explosionDecay())
                        )
                ).withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(
                                LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.2F, 0.5F)))
                                        .apply(ApplyExplosionDecay.explosionDecay()).when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), dropChances))
                        )
                ).withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(
                                LootItem.lootTableItem(fruitItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(leavesBlock)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                        )
                                )));
    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }



}

