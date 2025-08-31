package com.nindybun.modulardrills.data;

import com.nindybun.modulardrills.ModularDrills;
import com.nindybun.modulardrills.helpers.Utilities;
import com.nindybun.modulardrills.registries.RegItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Objects;

public class LangGen extends LanguageProvider {
    public LangGen(PackOutput output, String locale) {
        super(output, ModularDrills.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add(Utilities.addModID("tab", "creative_tab"), "Modular Drills");
        add(RegItems.IRON_DRILL_HEAD.get(), "Iron Drill Head");
        add(RegItems.DIAMOND_DRILL_HEAD.get(), "Diamond Drill Head");
        add(RegItems.NETHERITE_DRILL_HEAD.get(), "Netherite Drill Head");
        add(RegItems.DRILL_BODY.get(), "Drill Body");
        add(RegItems.MODULAR_DRILL.get(), "Modular Drill");


    }
}
