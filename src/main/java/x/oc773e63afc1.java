/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.EnumFacing;

public class oc773e63afc1 {
    static final int[] \u056a = new int[EnumFacing.values().length];

    static {
        try {
            oc773e63afc1.\u056a[EnumFacing.EAST.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc773e63afc1.\u056a[EnumFacing.WEST.ordinal()] = 0x8EE12152 ^ 0x8EE12150;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc773e63afc1.\u056a[EnumFacing.SOUTH.ordinal()] = 0x8EE12153 ^ 0x8EE12150;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc773e63afc1.\u056a[EnumFacing.NORTH.ordinal()] = 0x8EE12154 ^ 0x8EE12150;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc773e63afc1.\u056a[EnumFacing.UP.ordinal()] = 0x8EE12155 ^ 0x8EE12150;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

