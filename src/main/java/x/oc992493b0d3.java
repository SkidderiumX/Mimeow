/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.Display;
import x.oc1b46ea259e;

public class oc992493b0d3 {
    public static int \u04e0;

    private oc992493b0d3() {
    }

    public static boolean \u02a2() {
        boolean bl = oc1b46ea259e.\u01e7;
        try {
            boolean bl2;
            block14: {
                block11: {
                    block13: {
                        block12: {
                            block10: {
                                bl2 = Display.isCreated();
                                if (bl) break block10;
                                if (!bl2) break block11;
                                bl2 = OpenGlHelper.isReducedRenderMode();
                            }
                            if (bl) break block12;
                            if (bl2) break block11;
                            bl2 = OpenGlHelper.areShadersSupported();
                        }
                        if (bl) break block13;
                        if (!bl2) break block11;
                        bl2 = OpenGlHelper.isFramebufferEnabled();
                    }
                    if (bl) break block14;
                    if (!bl2) break block11;
                    bl2 = true;
                    break block14;
                }
                bl2 = false;
            }
            return bl2;
        }
        catch (LinkageError | RuntimeException throwable) {
            return false;
        }
    }
}

