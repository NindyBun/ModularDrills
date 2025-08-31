package com.nindybun.modulardrills.registries;

import com.nindybun.modulardrills.ModularDrills;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RegComp {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, ModularDrills.MODID);

    public static final Supplier<DataComponentType<ItemStack>> DRILL_HEAD = COMPONENTS.register("drill-head", () ->
        DataComponentType.<ItemStack>builder().persistent(ItemStack.CODEC).networkSynchronized(ItemStack.STREAM_CODEC).cacheEncoding().build()
    );
}
