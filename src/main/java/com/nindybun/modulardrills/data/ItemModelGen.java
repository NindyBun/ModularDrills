package com.nindybun.modulardrills.data;

import com.nindybun.modulardrills.ModularDrills;
import com.nindybun.modulardrills.registries.RegItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;


public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModularDrills.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        String name = RegItems.IRON_DRILL_HEAD.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "item/drill-head-iron-item"));

        name = RegItems.DIAMOND_DRILL_HEAD.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "item/drill-head-diamond-item"));

        name = RegItems.NETHERITE_DRILL_HEAD.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "item/drill-head-netherite-item"));


        name = RegItems.DRILL_BODY.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "item/drill-body-item"));


        name = RegItems.MODULAR_DRILL.getId().getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "item/drill-body"))
                .override()
                .predicate(ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "drill-head"), 1f)
                .model(withExistingParent(name+"-0", mcLoc("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "item/drill-body-item"))
                        .texture("layer1", ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "item/drill-head-iron")))
                .predicate(ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "drill-head"), 2f)
                .model(withExistingParent(name+"-0", mcLoc("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "item/drill-body-item"))
                        .texture("layer1", ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "item/drill-head-diamond")))
                .predicate(ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "drill-head"), 3f)
                .model(withExistingParent(name+"-0", mcLoc("item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "item/drill-body-item"))
                        .texture("layer1", ResourceLocation.fromNamespaceAndPath(ModularDrills.MODID, "item/drill-head-netherite")))
                .end();

    }

}
