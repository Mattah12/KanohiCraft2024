package net.mattah12.kanohicraft.datagen;

import net.mattah12.kanohicraft.KanohiCraft;
import net.mattah12.kanohicraft.block.ModBlocks;
import net.mattah12.kanohicraft.item.ModItems;
import net.mattah12.kanohicraft.util.ModTags;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PROTODERMIS_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('B', Items.STICK)
                .define('A', ModItems.INGOT_PROTODERMIS)
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PROTODERMIS_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('B', Items.STICK)
                .define('A', ModItems.INGOT_PROTODERMIS)
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PROTODERMIS_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('B', Items.STICK)
                .define('A', ModItems.INGOT_PROTODERMIS)
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PROTODERMIS_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('B', Items.STICK)
                .define('A', ModItems.INGOT_PROTODERMIS)
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PROTODERMIS_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('B', Items.STICK)
                .define('A', ModItems.INGOT_PROTODERMIS)
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PROTODERMIS_PAXEL.get())
                .pattern("ABC")
                .pattern(" D ")
                .pattern(" D ")
                .define('D', Items.STICK)
                .define('A', ModItems.PROTODERMIS_AXE)
                .define('B', ModItems.PROTODERMIS_PICKAXE)
                .define('C', ModItems.PROTODERMIS_SHOVEL)
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PROTODERMIS_HAMMER.get())
                .pattern("ADA")
                .pattern(" D ")
                .pattern(" D ")
                .define('D', Items.STICK)
                .define('A', ModBlocks.PROTODERMIS_BLOCK)
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PROTODERMIS_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.INGOT_PROTODERMIS)
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PROTODERMIS_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.INGOT_PROTODERMIS)
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PROTODERMIS_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.INGOT_PROTODERMIS)
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PROTODERMIS_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.INGOT_PROTODERMIS)
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NUGGET_PROTODERMIS.get(), 9)
                .requires(ModItems.INGOT_PROTODERMIS.get())
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.INGOT_PROTODERMIS.get(), 9)
                .requires(ModBlocks.PROTODERMIS_BLOCK.get())
                .unlockedBy("has_protodermis_ingot", has(ModItems.INGOT_PROTODERMIS.get())).save(pRecipeOutput, "kanohicraft:protodermis_ingot2");
//comment


        oreSmelting(pRecipeOutput, PROTODERMIS_SMELTABLES, RecipeCategory.MISC, ModItems.INGOT_PROTODERMIS.get(), 0.25f, 200, "protodermis_ingot");
        oreBlasting(pRecipeOutput, PROTODERMIS_SMELTABLES, RecipeCategory.MISC, ModItems.INGOT_PROTODERMIS.get(), 0.25f, 100, "protodermis_ingot");


        planksFromLog(pRecipeOutput, ModBlocks.VUATA_MACA_PLANKS.get(), ModTags.Items.VUATA_MACA_LOGS, 4);

        woodFromLogs(pRecipeOutput, ModBlocks.VUATA_MACA_WOOD.get(), ModBlocks.VUATA_MACA_LOG.get());
        woodFromLogs(pRecipeOutput, ModBlocks.VUATA_MACA_STRIPPED_WOOD.get(), ModBlocks.VUATA_MACA_STRIPPED_LOG.get());


        stairBuilder(ModBlocks.VUATA_MACA_STAIRS.get(), Ingredient.of(ModBlocks.VUATA_MACA_PLANKS.get())).group("vuata_maca")
                .unlockedBy("has_vuata_maca_log", has(ModBlocks.VUATA_MACA_LOG.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VUATA_MACA_SLAB.get(), ModBlocks.VUATA_MACA_PLANKS.get());

        pressurePlate(pRecipeOutput, ModBlocks.VUATA_MACA_PRESSURE_PLATE.get(), ModBlocks.VUATA_MACA_PLANKS.get());

        buttonBuilder(ModBlocks.VUATA_MACA_BUTTON.get(), Ingredient.of(ModBlocks.VUATA_MACA_PLANKS.get())).group("vuata_maca")
                .unlockedBy("has_vuata_maca_log", has(ModBlocks.VUATA_MACA_LOG.get())).save(pRecipeOutput);

        fenceBuilder(ModBlocks.VUATA_MACA_FENCE.get(), Ingredient.of(ModBlocks.VUATA_MACA_PLANKS.get())).group("vuata_maca")
                .unlockedBy("has_vuata_maca_log", has(ModBlocks.VUATA_MACA_LOG.get())).save(pRecipeOutput);

        fenceGateBuilder(ModBlocks.VUATA_MACA_FENCE_GATE.get(), Ingredient.of(ModBlocks.VUATA_MACA_PLANKS.get())).group("vuata_maca")
                .unlockedBy("has_vuata_maca_log", has(ModBlocks.VUATA_MACA_LOG.get())).save(pRecipeOutput);

        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VUATA_MACA_WALL.get(), ModBlocks.VUATA_MACA_PLANKS.get());


        doorBuilder(ModBlocks.VUATA_MACA_DOOR.get(), Ingredient.of(ModBlocks.VUATA_MACA_PLANKS.get())).group("vuata_maca")
                .unlockedBy("has_vuata_maca_log", has(ModBlocks.VUATA_MACA_LOG.get())).save(pRecipeOutput);


        trapdoorBuilder(ModBlocks.VUATA_MACA_TRAPDOOR.get(), Ingredient.of(ModBlocks.VUATA_MACA_PLANKS.get())).group("vuata_maca")
                .unlockedBy("has_vuata_maca_log", has(ModBlocks.VUATA_MACA_LOG.get())).save(pRecipeOutput);


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