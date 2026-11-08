/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import x.oc33f9a73cbd;

public class ocf30607050c
implements oc33f9a73cbd {
    ocf30607050c() {
    }

    @Override
    public void z$2s7347vx00vmh(int[] nArray) {
        GlStateManager.tryBlendFuncSeparate(nArray[0], nArray[1], nArray[0x45259234 ^ 0x45259236], nArray[0x45259235 ^ 0x45259236]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void z$1chj8mtkruq7y(int n, List<float[]> list) {
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.shadeModel(0x368F91F7 ^ 0x368F8CF6);
        GL11.glBegin(n);
        try {
            for (float[] fArray : list) {
                GlStateManager.color(fArray[0x368F8CF4 ^ 0x368F8CF6], fArray[0x368F8CF5 ^ 0x368F8CF6], fArray[0x368F8CF2 ^ 0x368F8CF6], fArray[0x368F8CF3 ^ 0x368F8CF6]);
                GL11.glVertex2f(fArray[0], fArray[1]);
            }
        }
        finally {
            GL11.glEnd();
        }
    }
}

