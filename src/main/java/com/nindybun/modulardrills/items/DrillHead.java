package com.nindybun.modulardrills.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DrillHead extends Item {
    public DrillHead(int durability) {
        super(new Properties().stacksTo(1).durability(durability));
    }


}
