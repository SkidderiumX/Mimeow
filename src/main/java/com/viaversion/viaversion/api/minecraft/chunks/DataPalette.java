/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.chunks;

import com.viaversion.viaversion.util.CompactArrayUtil;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

public interface DataPalette {
    public int index(int var1, int var2, int var3);

    public int idAt(int var1);

    default public int idAt(int n, int n2, int n3) {
        return this.idAt(this.index(n, n2, n3));
    }

    public void setIdAt(int var1, int var2);

    default public void setIdAt(int n, int n2, int n3, int n4) {
        this.setIdAt(this.index(n, n2, n3), n4);
    }

    public int idByIndex(int var1);

    public void setIdByIndex(int var1, int var2);

    public int paletteIndexAt(int var1);

    public void setPaletteIndexAt(int var1, int var2);

    default public void replaceIds(IntUnaryOperator intUnaryOperator) {
        for (int i = 0; i < this.size(); ++i) {
            int n = this.idByIndex(i);
            int n2 = intUnaryOperator.applyAsInt(n);
            if (n2 == n) continue;
            this.setIdByIndex(i, n2);
        }
    }

    public void addId(int var1);

    default public void replaceId(int n, int n2) {
        for (int i = 0; i < this.size(); ++i) {
            if (this.idByIndex(i) != n) continue;
            this.setIdByIndex(i, n2);
        }
    }

    public void forEachMatchingCoordinate(IntPredicate var1, IntConsumer var2);

    default public long[] createPackedValues(int n, int n2, boolean bl) {
        return CompactArrayUtil.createCompactArrayWithPadding(n, n2, bl ? this::idAt : this::paletteIndexAt);
    }

    public int size();

    public void clear();
}

