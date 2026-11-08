/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.signature.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import java.util.function.Consumer;

@FunctionalInterface
public interface DataConsumer
extends Consumer<byte[]> {
    @Override
    default public void accept(UUID uUID) {
        byte[] byArray = new byte[16];
        ByteBuffer.wrap(byArray).order(ByteOrder.BIG_ENDIAN).putLong(uUID.getMostSignificantBits()).putLong(uUID.getLeastSignificantBits());
        this.accept(byArray);
    }
}

