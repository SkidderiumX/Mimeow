/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.renderer.GlStateManager;

public class oc606e718ce9 {
    private oc606e718ce9() {
    }

    static void \u018b() {
        GlStateManager.resetColor();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(0x5E7A9C16 ^ 0x5E7A9E12, 0.1f);
        GlStateManager.enableDepth();
        GlStateManager.depthMask(true);
        GlStateManager.shadeModel(0x5E7A8312 ^ 0x5E7A9E12);
    }
}

