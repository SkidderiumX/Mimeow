/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import org.checkerframework.checker.nullness.qual.Nullable;

public record SoundEvent(String identifier, @Nullable Float fixedRange) {
    private static final Holder<SoundEvent> UNKNOWN = Holder.of(new SoundEvent("viaversion:unknown", Float.valueOf(0.0f)));

    public SoundEvent withIdentifier(String string) {
        return new SoundEvent(string, this.fixedRange);
    }

    public static @Nullable Holder<SoundEvent> rewriteHolder(@Nullable Holder<SoundEvent> holder, Int2IntFunction int2IntFunction) {
        if (holder == null) {
            return null;
        }
        return holder.updateId(int2IntFunction, () -> UNKNOWN);
    }
}

