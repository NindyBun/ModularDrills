package com.nindybun.modulardrills.records;

import com.mojang.serialization.Codec;
import com.mojang.serialization.RecordBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

public record DrillHeadRecord(ItemStack stack) {
    public static final Codec<DrillHeadRecord> CODEC = RecordCodecBuilder.create(instance -> instance.group(
              ItemStack.CODEC.fieldOf("drill-head").forGetter(DrillHeadRecord::stack)
      ).apply(instance, DrillHeadRecord::new));
    
    public static final StreamCodec<RegistryFriendlyByteBuf, DrillHeadRecord> STREAM_CODEC = StreamCodec.composite(
            ItemStack.STREAM_CODEC,
            DrillHeadRecord::stack,
            DrillHeadRecord::new
    );
}
