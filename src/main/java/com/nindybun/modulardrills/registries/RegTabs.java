package com.nindybun.modulardrills.registries;

import com.nindybun.modulardrills.ModularDrills;
import com.nindybun.modulardrills.helpers.Utilities;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, ModularDrills.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = TABS.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Utilities.createTranslatable("tab", "creative_tab"))
            .icon(() -> RegItems.IRON_DRILL_HEAD.get().getDefaultInstance())
            .displayItems(((itemDisplayParameters, output) -> {
                RegItems.ITEMS.getEntries().forEach(itemDeferredHolder -> output.accept(itemDeferredHolder.get()));
            }))
            .build());
}
