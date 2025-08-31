package com.nindybun.modulardrills.registries;

import com.nindybun.modulardrills.ModularDrills;
import com.nindybun.modulardrills.items.DrillHead;
import com.nindybun.modulardrills.items.ModularDrill;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, ModularDrills.MODID);

    public static final DeferredHolder<Item, DrillHead> IRON_DRILL_HEAD = ITEMS.register("drill-head-iron", () -> new DrillHead(Tiers.IRON.getUses()));
    public static final DeferredHolder<Item, DrillHead> DIAMOND_DRILL_HEAD = ITEMS.register("drill-head-diamond", () -> new DrillHead(Tiers.DIAMOND.getUses()));
    public static final DeferredHolder<Item, DrillHead> NETHERITE_DRILL_HEAD = ITEMS.register("drill-head-netherite", () -> new DrillHead(Tiers.NETHERITE.getUses()));
    public static final DeferredHolder<Item, Item> DRILL_BODY = ITEMS.register("drill-body", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, ModularDrill> MODULAR_DRILL = ITEMS.register("modular-drill", ModularDrill::new);

}
