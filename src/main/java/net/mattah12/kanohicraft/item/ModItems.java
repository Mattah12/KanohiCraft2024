package net.mattah12.kanohicraft.item;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.mattah12.kanohicraft.item.custom.HammerItem;
import net.mattah12.kanohicraft.item.custom.PaxelItem;
import net.mattah12.kanohicraft.item.custom.VuataMacaItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
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

    public static final DeferredItem<Item> PROTODERMIS_SWORD = ITEMS.register("protodermis_sword",
            () -> new SwordItem(ModToolTiers.PROTODERMIS,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.PROTODERMIS, 3, -2.4f))));
    public static final DeferredItem<Item> PROTODERMIS_PICKAXE = ITEMS.register("protodermis_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PROTODERMIS,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.PROTODERMIS, 1, -2.8f))));
    public static final DeferredItem<Item> PROTODERMIS_SHOVEL = ITEMS.register("protodermis_shovel",
            () -> new ShovelItem(ModToolTiers.PROTODERMIS,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.PROTODERMIS, 1.5f, -3f))));
    public static final DeferredItem<Item> PROTODERMIS_AXE = ITEMS.register("protodermis_axe",
            () -> new AxeItem(ModToolTiers.PROTODERMIS,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.PROTODERMIS, 6, -3.2f))));
    public static final DeferredItem<Item> PROTODERMIS_HOE = ITEMS.register("protodermis_hoe",
            () -> new HoeItem(ModToolTiers.PROTODERMIS,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.PROTODERMIS, 0, -3.0f))));

    public static final DeferredItem<Item> PROTODERMIS_PAXEL = ITEMS.register("protodermis_paxel",
            () -> new PaxelItem(ModToolTiers.PROTODERMIS,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.PROTODERMIS, 4, -2.8f))));
    public static final DeferredItem<Item> PROTODERMIS_HAMMER = ITEMS.register("protodermis_hammer",
            () -> new HammerItem(ModToolTiers.PROTODERMIS,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.PROTODERMIS, 8, -3.2f))));


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
