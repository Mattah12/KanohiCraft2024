package net.mattah12.kanohicraft.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VuataMacaItem extends Item {

    private int burnTime = 0;
    //public float saturationModifier = 0F;

    public VuataMacaItem(Properties properties, int burnTime, float saturationModifier) {
        super(properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }

    public static final FoodProperties VUATA_MACA = new FoodProperties.Builder().nutrition(2).saturationModifier(6F).fast().build();


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.kanohicraft.vuata_maca.tooltip.1"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}

