package net.mattah12.kanohicraft.block;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.custom.ModFlammableRotatedPillarBlock;
import net.mattah12.kanohicraft.item.ModItems;
import net.mattah12.kanohicraft.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(KanohiCraft.MOD_ID);


    //PROTODERMIS
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


    //LIGHTSTONE
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

    public static final DeferredBlock<TorchBlock> LIGHTSTONE_TORCH_BLOCK = registerBlock("lightstone_torch",
            () -> new TorchBlock(ParticleTypes.GLOW,
                    BlockBehaviour.Properties.of()
                            .noOcclusion()
                            .lightLevel(s ->15)
                            .instabreak()));
    public static final DeferredBlock<TorchBlock> LIGHTSTONE_REFINED_TORCH_BLOCK = registerBlock("lightstone_refined_torch",
            () -> new TorchBlock (ParticleTypes.GLOW,
                    BlockBehaviour.Properties.of()
                            .noOcclusion()
                            .lightLevel(s ->15)
                            .instabreak()));
    public static final DeferredBlock<WallTorchBlock> WALL_LIGHTSTONE_TORCH = registerBlock("wall_lightstone_torch",
            () -> new WallTorchBlock (ParticleTypes.GLOW,
                    BlockBehaviour.Properties.of()
                            .noOcclusion()
                            .lightLevel(s ->15)
                            .instabreak()));
    public static final DeferredBlock<WallTorchBlock> WALL_LIGHTSTONE_REFINED_TORCH = registerBlock("wall_lightstone_refined_torch",
            () -> new WallTorchBlock (ParticleTypes.GLOW,
                    BlockBehaviour.Properties.of()
                            .noOcclusion()
                            .lightLevel(s ->15)
                            .instabreak()));

    //VUATA MACA
    public static final DeferredBlock<Block> VUATA_MACA_LOG = registerBlock("vuata_maca_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> VUATA_MACA_LOG_COVERED = registerBlock("vuata_maca_log_covered",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> VUATA_MACA_LOG_HALF_COVERED = registerBlock("vuata_maca_log_half_covered",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> VUATA_MACA_WOOD = registerBlock("vuata_maca_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> VUATA_MACA_STRIPPED_LOG = registerBlock("vuata_maca_stripped_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> VUATA_MACA_STRIPPED_WOOD = registerBlock("vuata_maca_stripped_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> VUATA_MACA_PLANKS = registerBlock("vuata_maca_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 2;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 1;
                }
            });

    public static final DeferredBlock<Block> VUATA_MACA_LEAVES = registerBlock("vuata_maca_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
                    .lightLevel(s ->15)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return false;
                }
            });


    public static final DeferredBlock<Block> VUATA_MACA_SAPLING = registerBlock("vuata_maca_sapling",
            () -> new SaplingBlock(ModTreeGrowers.VUATA_MACA,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> VUATA_MACA_STAIRS = registerBlock("vuata_maca_stairs",
            () -> new StairBlock(ModBlocks.VUATA_MACA_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> VUATA_MACA_SLAB = registerBlock("vuata_maca_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> VUATA_MACA_PRESSURE_PLATE = registerBlock("vuata_maca_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<Block> VUATA_MACA_BUTTON = registerBlock("vuata_maca_button",
            () -> new ButtonBlock(BlockSetType.OAK, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)
                    .noCollission()));




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
