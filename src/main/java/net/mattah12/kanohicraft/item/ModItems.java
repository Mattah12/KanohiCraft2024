package net.mattah12.kanohicraft.item;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.mattah12.kanohicraft.item.custom.VuataMacaItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KanohiCraft.MOD_ID);

    public static final DeferredItem<Item> HAU = ITEMS.registerSimpleItem("hau_icon");

    public static final DeferredItem<Item> LIGHTSTONE = ITEMS.registerSimpleItem("lightstone");

    public static final DeferredItem<Item> BULA_BERRY = ITEMS.registerItem("bula_berry", Item::new, new Item.Properties()
            .food(ModFoodProperties.BULA_BERRY));
    public static final DeferredItem<Item> VUATA_MACA = ITEMS.registerItem("vuata_maca", properties -> new VuataMacaItem(properties, 1000, 1F),
            new Item.Properties().food(VuataMacaItem.VUATA_MACA));


    public static final DeferredItem<StandingAndWallBlockItem> LIGHTSTONE_TORCH_ITEM = ITEMS.register("item_lightstone_torch",
            () -> new StandingAndWallBlockItem(ModBlocks.LIGHTSTONE_TORCH_BLOCK.get(), ModBlocks.WALL_LIGHTSTONE_TORCH.get(),
                    new Item.Properties(), Direction.DOWN));
    public static final DeferredItem<Item> LIGHTSTONE_REFINED_TORCH_ITEM = ITEMS.register("item_lightstone_refined_torch",
            ()-> new StandingAndWallBlockItem(ModBlocks.LIGHTSTONE_REFINED_TORCH_BLOCK.get(), ModBlocks.WALL_LIGHTSTONE_REFINED_TORCH.get(),
                    new Item.Properties(), Direction.DOWN));

    public static final DeferredItem<Item> RAW_PROTODERMIS =
            ITEMS.registerItem("raw_protodermis", Item::new, new Item.Properties());
    public static final DeferredItem<Item> INGOT_PROTODERMIS = ITEMS.registerSimpleItem("protodermis_ingot");
    public static final DeferredItem<Item> NUGGET_PROTODERMIS = ITEMS.registerSimpleItem("protodermis_nugget");


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
