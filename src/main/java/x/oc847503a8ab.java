/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import x.oc1a421bd3db;
import x.oc791986a759;

public class oc847503a8ab {
    final oc1a421bd3db \u00df;
    final Vec3 \u0123;
    final float \u03a8;
    final float \u028c;
    final oc791986a759 \u028f;
    final long \u0476;

    oc847503a8ab(oc1a421bd3db oc1a421bd3db2, Vec3 vec3, float f, float f2, oc791986a759 oc791986a7592, long l) {
        this.\u00df = oc1a421bd3db2;
        this.\u0123 = vec3;
        this.\u03a8 = f;
        this.\u028c = f2;
        this.\u028f = oc791986a7592;
        this.\u0476 = l;
    }

    MovingObjectPosition \u03a7() {
        return new MovingObjectPosition(this.\u0123, this.\u00df.\u0553, this.\u00df.\u029a);
    }
}

