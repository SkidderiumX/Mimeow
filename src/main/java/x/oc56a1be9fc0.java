/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.EnumFacing;

public class oc56a1be9fc0 {
    static final int[] \u03ee = new int[EnumFacing.Axis.values().length];

    static {
        try {
            oc56a1be9fc0.\u03ee[EnumFacing.Axis.X.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc56a1be9fc0.\u03ee[EnumFacing.Axis.Y.ordinal()] = 0xC17126E8 ^ 0xC17126EA;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc56a1be9fc0.\u03ee[EnumFacing.Axis.Z.ordinal()] = 0xC17126E9 ^ 0xC17126EA;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

