/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.Packet;

public class ocd1e93e6984
extends Record {
    private final Packet<?> \u015d;
    private final long \u028f;

    private ocd1e93e6984(Packet<?> packet, long l) {
        this.\u015d = packet;
        this.\u028f = l;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ocd1e93e6984.class, "\u015d;\u028f", "\u015d", "\u028f"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ocd1e93e6984.class, "\u015d;\u028f", "\u015d", "\u028f"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ocd1e93e6984.class, "\u015d;\u028f", "\u015d", "\u028f"}, this, object);
    }

    public Packet<?> \u015c() {
        return this.\u015d;
    }

    public long \u028f() {
        return this.\u028f;
    }
}

