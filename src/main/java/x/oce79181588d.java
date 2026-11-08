/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.Packet;
import x.oc384197ee54;
import x.oc68d6b191af;

@oc384197ee54
public class oce79181588d
extends oc68d6b191af {
    private Packet<?> \u0441;
    private boolean \u0124;
    public static int \u022d;

    public oce79181588d(Packet<?> packet) {
        this.\u0441 = packet;
    }

    public Packet<?> \u04a0() {
        return this.\u0441;
    }

    public void \u0461() {
        this.\u0124 = true;
    }

    public boolean \u0146() {
        return this.\u0124;
    }
}

