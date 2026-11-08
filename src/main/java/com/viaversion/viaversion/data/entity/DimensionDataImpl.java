/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.data.entity;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viaversion.api.data.entity.DimensionData;

public class DimensionDataImpl
implements DimensionData {
    private final int id;
    private final int minY;
    private final int height;

    public DimensionDataImpl(int n, int n2, int n3) {
        this.id = n;
        this.minY = n2;
        this.height = n3;
    }

    public DimensionDataImpl(int n, CompoundTag compoundTag) {
        this.id = n;
        NumberTag numberTag = compoundTag.getNumberTag("height");
        if (numberTag == null) {
            throw new IllegalArgumentException("height missing in dimension data: " + String.valueOf(compoundTag));
        }
        this.height = numberTag.asInt();
        NumberTag numberTag2 = compoundTag.getNumberTag("min_y");
        if (numberTag2 == null) {
            throw new IllegalArgumentException("min_y missing in dimension data: " + String.valueOf(compoundTag));
        }
        this.minY = numberTag2.asInt();
    }

    public static DimensionData withDefaultsFor(String string, int n) {
        return switch (string) {
            case "overworld", "overworld_caves" -> new DimensionDataImpl(n, -64, 384);
            case "the_nether", "the_end" -> new DimensionDataImpl(n, 0, 256);
            default -> throw new IllegalArgumentException("Missing registry data for unknown dimension: " + string);
        };
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public int minY() {
        return this.minY;
    }

    @Override
    public int height() {
        return this.height;
    }

    public String toString() {
        return "DimensionDataImpl{id=" + this.id + ", minY=" + this.minY + ", height=" + this.height + "}";
    }
}

