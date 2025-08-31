package com.nindybun.modulardrills;

import com.nindybun.modulardrills.data.Generator;
import com.nindybun.modulardrills.registries.RegComp;
import com.nindybun.modulardrills.registries.RegItems;
import com.nindybun.modulardrills.registries.RegTabs;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.Minecraft;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(ModularDrills.MODID)
public class ModularDrills {
    public static final String MODID = "modulardrills";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ModularDrills(IEventBus modEventBus, ModContainer modContainer) {
        RegComp.COMPONENTS.register(modEventBus);
        RegItems.ITEMS.register(modEventBus);
        RegTabs.TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(Generator::gatherData);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = ModularDrills.MODID, value = Dist.CLIENT)
    static class ClientModEvents {
        @SubscribeEvent
        static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ItemProperties.register(RegItems.MODULAR_DRILL.get(), ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "drill-head"), (i, l, e, d) -> {
                    float ii = 0f;
                    if (i.has(RegComp.DRILL_HEAD.get())) {
                        if (i.get(RegComp.DRILL_HEAD.get()).getItem().getDefaultInstance().equals(RegItems.IRON_DRILL_HEAD.get().getDefaultInstance())) {
                            return 1f;
                        } else if (i.get(RegComp.DRILL_HEAD.get()).getItem().getDefaultInstance().equals(RegItems.DIAMOND_DRILL_HEAD.get().getDefaultInstance())) {
                            return 2f;
                        } else if (i.get(RegComp.DRILL_HEAD.get()).getItem().getDefaultInstance().equals(RegItems.NETHERITE_DRILL_HEAD.get().getDefaultInstance())) {
                            return 3f;
                        }
                    }
                    return ii;
                });
            });
        }
    }
}
