/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.config;

import net.minecraft.world.World;

public enum Weather {
    CLEAR,
    RAIN,
    THUNDER;


    public static Weather getWeather(World world2, float f) {
        float f2 = world2.getThunderStrength(f);
        if (f2 > 0.5f) {
            return THUNDER;
        }
        float f3 = world2.getRainStrength(f);
        return f3 > 0.5f ? RAIN : CLEAR;
    }
}

