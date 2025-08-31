package com.nindybun.modulardrills.helpers;


import com.nindybun.modulardrills.ModularDrills;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class Utilities {
    public static MutableComponent createTranslatable(String id, String name) {
        return Component.translatable(addModID(id, name));
    }

    public static String addModID(String id, String name) {
        return id + "." + ModularDrills.MODID + "." + name;
    }
}
