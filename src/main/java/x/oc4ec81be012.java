/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import x.oc1378bc114d;
import x.oca077e2210f;

public class oc4ec81be012
implements Supplier<oc1378bc114d> {
    final float val$scale;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc4ec81be012(float f) {
        this.val$scale = f;
    }

    @Override
    public oc1378bc114d get() {
        return new oca077e2210f(Minecraft.getMinecraft().fontRendererObj, this.val$scale);
    }
}

