/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.utils;

public class VelocityUtil {
    public static short toLegacyVelocity(double d) {
        return (short)Math.max(-32768L, Math.min(32767L, Math.round(d * 8000.0)));
    }
}

