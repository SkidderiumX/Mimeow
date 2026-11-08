/*
 * Decompiled with CFR 0.152.
 */
package x;

import org.lwjgl.opengl.GL11;
import x.oca41080eed8;

public class oc410fad187d
implements oca41080eed8 {
    oc410fad187d() {
    }

    @Override
    public void z$73x5qqydaaar() {
        GL11.glPushAttrib(0x7829058C ^ 0x7826FA73);
    }

    @Override
    public void z$3d6hjeg7c8mtf() {
        GL11.glPushClientAttrib(0xAA742EF9 ^ 0xAA742EFA);
    }

    @Override
    public void z$1emhea3cbblse() {
        GL11.glPopClientAttrib();
    }

    @Override
    public void z$g7u1h2mhac5x() {
        GL11.glPopAttrib();
    }
}

