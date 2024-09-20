package net.mattah12.kanohicraft.util;

import net.mattah12.kanohicraft.KanohiCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_PROTODERMIS_TOOL = createTag("incorrect_for_protodermis_tool");
        public static final TagKey<Block> NEEDS_PROTODERMIS_TOOL = createTag("needs_protodermis_tool");

        public static final TagKey<Block> PAXEL_MINEABLE = createTag("mineable/paxel");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID, name));
        }
    }
//comment
    public static class Items {
        public static final TagKey<Item> KANOKA = createTag("kanoka");
        public static final TagKey<Item> KANOHI = createTag("kanohi");
        public static final TagKey<Item> VUATA_MACA_LOGS = createTag("vuata_maca_logs");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(KanohiCraft.MOD_ID, name));
        }
    }
}