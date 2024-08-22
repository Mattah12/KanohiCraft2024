package net.mattah12.kanohicraft.item;

import net.mattah12.kanohicraft.KanohiCraft;
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

                        pOutput.accept(ModItems.RAW_PROTODERMIS);
                        pOutput.accept(ModItems.NUGGET_PROTODERMIS);
                        pOutput.accept(ModItems.INGOT_PROTODERMIS);
                        pOutput.accept(ModItems.LIGHTSTONE);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
