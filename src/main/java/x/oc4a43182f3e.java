/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.culling.ICamera;
import x.oc4e1b577a95;

public class oc4a43182f3e {
    public static ICamera \u0272;
    public static boolean \u03e1;

    public static boolean \u0496(EntityFX entityFX) {
        block8: {
            block7: {
                boolean bl;
                block6: {
                    boolean bl2 = \u03e1;
                    bl = oc4e1b577a95.\u03a4();
                    if (bl2) break block6;
                    if (bl) break block7;
                    bl = true;
                }
                return bl;
            }
            if (\u0272 != null && entityFX != null) break block8;
            return true;
        }
        return \u0272.isBoundingBoxInFrustum(entityFX.getEntityBoundingBox());
    }
}

