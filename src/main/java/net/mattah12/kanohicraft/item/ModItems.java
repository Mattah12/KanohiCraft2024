package net.mattah12.kanohicraft.item;

import net.mattah12.kanohicraft.KanohiCraft;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KanohiCraft.MOD_ID);

    public static final DeferredItem<Item> HAU = ITEMS.registerSimpleItem("hau_icon");

    public static final DeferredItem<Item> LIGHTSTONE = ITEMS.registerSimpleItem("lightstone");
    public static final DeferredItem<Item> RAW_PROTODERMIS =
            ITEMS.registerItem("raw_protodermis", Item::new, new Item.Properties());
    public static final DeferredItem<Item> INGOT_PROTODERMIS = ITEMS.registerSimpleItem("protodermis_ingot");
    public static final DeferredItem<Item> NUGGET_PROTODERMIS = ITEMS.registerSimpleItem("protodermis_nugget");


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
