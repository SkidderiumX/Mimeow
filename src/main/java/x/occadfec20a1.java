/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.world.EnumDifficulty;

public class occadfec20a1 {
    static final int[] \u029f = new int[EnumDifficulty.values().length];

    static {
        try {
            occadfec20a1.\u029f[EnumDifficulty.PEACEFUL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            occadfec20a1.\u029f[EnumDifficulty.EASY.ordinal()] = 0x34EB2BE7 ^ 0x34EB2BE5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            occadfec20a1.\u029f[EnumDifficulty.HARD.ordinal()] = 0x34EB2BE6 ^ 0x34EB2BE5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

