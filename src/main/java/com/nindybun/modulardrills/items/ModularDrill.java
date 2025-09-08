package com.nindybun.modulardrills.items;

import com.nindybun.modulardrills.registries.RegComp;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class ModularDrill extends Item {
    /*
    * Drill Parts
    * - Drill head (mining hardness and durability)
    * - Engine (fuel engine, electric engine)
    *   - Advanced Engine (+15% efficiency)
    * - Cooling pipe/fan (cooling rate)
    * - Gearbox (torque, speed)
    */
    /*
    * Drill Modifiers
    * - enchantments
    */
    public ModularDrill() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 1800;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        player.startUsingItem(usedHand);
        return InteractionResultHolder.success(stack);
    }
}
