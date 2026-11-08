/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import java.util.Arrays;

public class HolderSetImpl {
    HolderSetImpl() {
    }

    public record Ids(int[] ids) implements HolderSet
    {
        @Override
        public boolean hasTagKey() {
            return false;
        }

        @Override
        public String tagKey() {
            throw new IllegalArgumentException("This holder set has direct ids");
        }

        @Override
        public boolean hasIds() {
            return true;
        }

        @Override
        public HolderSet rewrite(Int2IntFunction int2IntFunction) {
            int[] nArray = new int[this.ids.length];
            int n = 0;
            for (int n2 : this.ids) {
                int n3 = int2IntFunction.applyAsInt(n2);
                if (n3 == -1) continue;
                nArray[n++] = n3;
            }
            return new Ids(n == this.ids.length ? nArray : Arrays.copyOf(nArray, n));
        }

        @Override
        public String toString() {
            return "Ids{ids=" + Arrays.toString(this.ids) + "}";
        }
    }

    public record Tag(String tagKey) implements HolderSet
    {
        @Override
        public boolean hasTagKey() {
            return true;
        }

        @Override
        public int[] ids() {
            throw new IllegalArgumentException("This holder set has a tag key");
        }

        @Override
        public boolean hasIds() {
            return false;
        }

        @Override
        public HolderSet rewrite(Int2IntFunction int2IntFunction) {
            return this;
        }
    }
}

