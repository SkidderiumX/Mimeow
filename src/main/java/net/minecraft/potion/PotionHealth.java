/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.potion;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionHealth
extends Potion {
    public PotionHealth(int n, ResourceLocation resourceLocation, boolean bl, int n2) {
        super(n, resourceLocation, bl, n2);
    }

    @Override
    public boolean isInstant() {
        return true;
    }

    @Override
    public boolean isReady(int n, int n2) {
        return n >= 1;
    }
}

