/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.Display;
import x.oc4e871be632;
import x.oc95a52a4046;

public class oca4e1585b34
implements oc4e871be632 {
    private oca4e1585b34() {
    }

    @Override
    public String z$qwjgoq304pul() {
        if (!oca4e1585b34.\u02a5()) {
            return null;
        }
        return GLFW.glfwGetClipboardString(Display.getWindow());
    }

    @Override
    public boolean z$1w9fm5zod4yek(String string) {
        boolean bl;
        block4: {
            block5: {
                int n = oc95a52a4046.\u03bd;
                bl = oca4e1585b34.\u02a5();
                if (n != 0) break block4;
                if (bl) break block5;
                return false;
            }
            GLFW.glfwSetClipboardString(Display.getWindow(), string);
            bl = true;
        }
        return bl;
    }

    private static boolean \u02a5() {
        boolean bl;
        block9: {
            block7: {
                int n;
                block8: {
                    Minecraft minecraft;
                    block6: {
                        Minecraft minecraft2 = Minecraft.getMinecraft();
                        n = oc95a52a4046.\u03bd;
                        minecraft = minecraft2;
                        if (n != 0) break block6;
                        if (minecraft == null) break block7;
                        minecraft = minecraft2;
                    }
                    bl = minecraft.isCallingFromMinecraftThread();
                    if (n != 0) break block8;
                    if (!bl) break block7;
                    bl = Display.isCreated();
                }
                if (n != 0) break block9;
                if (!bl) break block7;
                bl = true;
                break block9;
            }
            bl = false;
        }
        return bl;
    }
}

