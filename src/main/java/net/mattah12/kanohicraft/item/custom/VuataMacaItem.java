package net.mattah12.kanohicraft.item.custom;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class VuataMacaItem extends Item {

    private int burnTime = 0;
    public float saturationModifier = 0F;

    public VuataMacaItem(Properties properties, int burnTime, float saturationModifier) {
        super(properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }

    public static final FoodProperties VUATA_MACA = new FoodProperties.Builder().nutrition(2).saturationModifier(6F).fast().build();

}

