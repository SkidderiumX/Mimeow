/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.IImageBuffer;
import x.occ87a73ee8b;
import x.oce6044968f8;

public class oc13d895a089
implements IImageBuffer {
    final long val$generation;
    final occ87a73ee8b this$0;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc13d895a089(occ87a73ee8b occ87a73ee8b2, long l) {
        this.this$0 = occ87a73ee8b2;
        this.val$generation = l;
    }

    @Override
    public BufferedImage parseUserSkin(BufferedImage bufferedImage) {
        block5: {
            block4: {
                boolean bl = oce6044968f8.\u0452;
                oc13d895a089 oc13d895a0892 = this;
                if (bl) break block4;
                if (oc13d895a0892.val$generation != this.this$0.\u01ac) break block5;
                oc13d895a0892 = this;
            }
            oc13d895a0892.this$0.\u042b = true;
        }
        return bufferedImage;
    }

    @Override
    public void skinAvailable() {
    }
}

