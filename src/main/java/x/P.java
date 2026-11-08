/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.EnumFacing;

public class P {
    static final int[] \u038c = new int[EnumFacing.values().length];

    static {
        try {
            P.\u038c[EnumFacing.UP.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            P.\u038c[EnumFacing.DOWN.ordinal()] = 0xF067EDAB ^ 0xF067EDA9;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            P.\u038c[EnumFacing.NORTH.ordinal()] = 0xF067EDAA ^ 0xF067EDA9;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            P.\u038c[EnumFacing.SOUTH.ordinal()] = 0xF067EDAD ^ 0xF067EDA9;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            P.\u038c[EnumFacing.EAST.ordinal()] = 0xF067EDAC ^ 0xF067EDA9;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            P.\u038c[EnumFacing.WEST.ordinal()] = 0xF067EDAF ^ 0xF067EDA9;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

