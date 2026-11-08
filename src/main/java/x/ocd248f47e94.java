/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.EnumFacing;

public class ocd248f47e94 {
    static final int[] \u03bd = new int[EnumFacing.values().length];

    static {
        try {
            ocd248f47e94.\u03bd[EnumFacing.UP.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ocd248f47e94.\u03bd[EnumFacing.DOWN.ordinal()] = 0x1C590097 ^ 0x1C590095;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ocd248f47e94.\u03bd[EnumFacing.NORTH.ordinal()] = 0x1C590096 ^ 0x1C590095;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ocd248f47e94.\u03bd[EnumFacing.SOUTH.ordinal()] = 0x1C590091 ^ 0x1C590095;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ocd248f47e94.\u03bd[EnumFacing.EAST.ordinal()] = 0x1C590090 ^ 0x1C590095;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ocd248f47e94.\u03bd[EnumFacing.WEST.ordinal()] = 0x1C590093 ^ 0x1C590095;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

