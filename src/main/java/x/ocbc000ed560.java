/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Locale;
import net.minecraft.entity.item.EntityTNTPrimed;

public class ocbc000ed560 {
    private final EntityTNTPrimed \u050c;
    private final float \u03cd;
    private final String \u0253;

    private ocbc000ed560(EntityTNTPrimed entityTNTPrimed, float f) {
        this.\u050c = entityTNTPrimed;
        this.\u03cd = f;
        this.\u0253 = String.format(Locale.ROOT, "Damage: %.1f", Float.valueOf(f));
    }
}

