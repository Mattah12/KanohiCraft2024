package net.mattah12.kanohicraft.block;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(KanohiCraft.MOD_ID);


    public static final DeferredBlock<Block> PROTODERMIS_BLOCK = registerBlock("protodermis_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> PROTODERMIS_ORE = registerBlock("protodermis_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,5),
                     BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> PROTODERMIS_DEEPSLATE_ORE = registerBlock("protodermis_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,5),
                     BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> PROTODERMIS_NETHER_ORE = registerBlock("protodermis_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(1,7),
                     BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> PROTODERMIS_END_ORE = registerBlock("protodermis_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),
                     BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> LIGHTSTONE_ORE = registerBlock("lightstone_ore",
            () -> new DropExperienceBlock(UniformInt.of(1,3),
                     BlockBehaviour.Properties.of().strength(3f)
                             .noOcclusion()
                             .lightLevel(s ->10)
                             .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> LIGHTSTONE_DEEPSLATE_ORE = registerBlock("lightstone_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,3),
                     BlockBehaviour.Properties.of().strength(3f)
                             .noOcclusion()
                             .lightLevel(s ->10)
                             .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> LIGHTSTONE_WOOD_LAMP = registerBlock("lightstone_wood_lamp",
            () -> new Block (BlockBehaviour.Properties.of().strength(3f)
                    .noOcclusion()
                    .lightLevel(s ->15)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> LIGHTSTONE_STONE_LAMP = registerBlock("lightstone_stone_lamp",
            () -> new Block (BlockBehaviour.Properties.of().strength(3f)
                    .noOcclusion()
                    .lightLevel(s ->15)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> LIGHTSTONE_REFINED_WOOD_LAMP = registerBlock("lightstone_refined_wood_lamp",
            () -> new Block (BlockBehaviour.Properties.of().strength(3f)
                    .noOcclusion()
                    .lightLevel(s ->15)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> LIGHTSTONE_REFINED_STONE_LAMP = registerBlock("lightstone_refined_stone_lamp",
            () -> new Block (BlockBehaviour.Properties.of().strength(3f)
                    .noOcclusion()
                    .lightLevel(s ->15)
                    .requiresCorrectToolForDrops()));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
