package net.mattah12.kanohicraft.item;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab>CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KanohiCraft.MOD_ID);

    public static final Supplier<CreativeModeTab> KANOHICRAFT =
            CREATIVE_MODE_TABS.register("kanohicraft_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.kanohicraft.kanohicraft_tab"))
                    .icon(() -> new ItemStack(ModItems.HAU.get()))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.HAU);
                        pOutput.accept(ModItems.VUATA_MACA);


                        pOutput.accept(ModItems.BULA_BERRY);

                        pOutput.accept(ModItems.RAW_PROTODERMIS);
                        pOutput.accept(ModItems.NUGGET_PROTODERMIS);
                        pOutput.accept(ModItems.INGOT_PROTODERMIS);
                        pOutput.accept(ModItems.LIGHTSTONE);
                        pOutput.accept(ModItems.LIGHTSTONE_TORCH_ITEM);
                        pOutput.accept(ModItems.LIGHTSTONE_REFINED_TORCH_ITEM);

                        pOutput.accept(ModBlocks.PROTODERMIS_ORE);
                        pOutput.accept(ModBlocks.PROTODERMIS_DEEPSLATE_ORE);
                        pOutput.accept(ModBlocks.PROTODERMIS_NETHER_ORE);
                        pOutput.accept(ModBlocks.PROTODERMIS_END_ORE);
                        pOutput.accept(ModBlocks.LIGHTSTONE_ORE);
                        pOutput.accept(ModBlocks.LIGHTSTONE_DEEPSLATE_ORE);


                        pOutput.accept(ModBlocks.LIGHTSTONE_WOOD_LAMP);
                        pOutput.accept(ModBlocks.LIGHTSTONE_REFINED_WOOD_LAMP);
                        pOutput.accept(ModBlocks.LIGHTSTONE_STONE_LAMP);
                        pOutput.accept(ModBlocks.LIGHTSTONE_REFINED_STONE_LAMP);

                        pOutput.accept(ModBlocks.PROTODERMIS_BLOCK);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
