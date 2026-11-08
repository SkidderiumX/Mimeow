/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.config;

import net.minecraft.src.Config;
import net.optifine.config.RangeInt;

public class RangeListInt {
    private RangeInt[] ranges = new RangeInt[0];

    public RangeListInt() {
    }

    public RangeListInt(RangeInt rangeInt) {
        this.addRange(rangeInt);
    }

    public void addRange(RangeInt rangeInt) {
        this.ranges = (RangeInt[])Config.addObjectToArray(this.ranges, rangeInt);
    }

    public boolean isInRange(int n) {
        for (int i = 0; i < this.ranges.length; ++i) {
            RangeInt rangeInt = this.ranges[i];
            if (!rangeInt.isInRange(n)) continue;
            return true;
        }
        return false;
    }

    public int getCountRanges() {
        return this.ranges.length;
    }

    public RangeInt getRange(int n) {
        return this.ranges[n];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i = 0; i < this.ranges.length; ++i) {
            RangeInt rangeInt = this.ranges[i];
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(rangeInt.toString());
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

