package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.mattah12.kanohicraft.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> PROTODERMIS_SMELTABLES = List.of(ModItems.RAW_PROTODERMIS,
                ModBlocks.PROTODERMIS_ORE, ModBlocks.PROTODERMIS_DEEPSLATE_ORE, ModBlocks.PROTODERMIS_END_ORE, ModBlocks.PROTODERMIS_NETHER_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PROTODERMIS_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.INGOT_PROTODERMIS.get())
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INGOT_PROTODERMIS.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.NUGGET_PROTODERMIS.get())
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput,"kanohicraft:protodermis_ingot1");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIGHTSTONE_TORCH_ITEM.get())
                .pattern("A")
                .pattern("B")
                .define('A', ModItems.LIGHTSTONE.get())
                .define('B', Items.STICK)
                .unlockedBy("has_lightstone", has(ModItems.LIGHTSTONE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIGHTSTONE_REFINED_TORCH_ITEM.get())
                .pattern("A")
                .pattern("B")
                .define('B', ModItems.LIGHTSTONE.get())
                .define('A', ModItems.NUGGET_PROTODERMIS.get())
                .unlockedBy("has_protodermis_ingot", has(ModItems.LIGHTSTONE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHTSTONE_WOOD_LAMP.get())
                .pattern("A A")
                .pattern(" B ")
                .pattern("A A")
                .define('B', ModItems.LIGHTSTONE_TORCH_ITEM.get())
                .define('A', Blocks.OAK_PLANKS)
                .unlockedBy("has_lightstone_torch", has(ModItems.LIGHTSTONE_TORCH_ITEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHTSTONE_STONE_LAMP.get())
                .pattern("A A")
                .pattern(" B ")
                .pattern("A A")
                .define('B', ModItems.LIGHTSTONE_TORCH_ITEM.get())
                .define('A', Blocks.STONE)
                .unlockedBy("has_lightstone_torch", has(ModItems.LIGHTSTONE_TORCH_ITEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHTSTONE_REFINED_WOOD_LAMP.get())
                .pattern("A A")
                .pattern(" B ")
                .pattern("A A")
                .define('B', ModItems.LIGHTSTONE_REFINED_TORCH_ITEM.get())
                .define('A', Blocks.OAK_PLANKS)
                .unlockedBy("has_refined_lightstone_torch", has(ModItems.LIGHTSTONE_REFINED_TORCH_ITEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHTSTONE_REFINED_STONE_LAMP.get())
                .pattern("A A")
                .pattern(" B ")
                .pattern("A A")
                .define('B', ModItems.LIGHTSTONE_REFINED_TORCH_ITEM.get())
                .define('A', Blocks.STONE)
                .unlockedBy("has_refined_lightstone_torch", has(ModItems.LIGHTSTONE_REFINED_TORCH_ITEM.get())).save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NUGGET_PROTODERMIS.get(), 9)
                .requires(ModItems.INGOT_PROTODERMIS.get())
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.INGOT_PROTODERMIS.get(), 9)
                .requires(ModBlocks.PROTODERMIS_BLOCK.get())
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput, "kanohicraft:protodermis_ingot2");


        oreSmelting(pRecipeOutput, PROTODERMIS_SMELTABLES, RecipeCategory.MISC, ModItems.INGOT_PROTODERMIS.get(), 0.25f, 200, "protodermis_ingot");
        oreBlasting(pRecipeOutput, PROTODERMIS_SMELTABLES, RecipeCategory.MISC, ModItems.INGOT_PROTODERMIS.get(), 0.25f, 100, "protodermis_ingot");

        stairBuilder(ModBlocks.VUATA_MACA_STAIRS.get(), Ingredient.of(ModBlocks.VUATA_MACA_PLANKS.get())).group("vuata_maca")
                .unlockedBy("has_vuata_maca_log", has(ModBlocks.VUATA_MACA_LOG.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VUATA_MACA_SLAB.get(), ModBlocks.VUATA_MACA_PLANKS.get());


    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, KanohiCraft.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}