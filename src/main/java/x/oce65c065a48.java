/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C0APacketAnimation;
import x.ocb5eb238adf;
import x.occ0b63c0426;

public class oce65c065a48
extends ocb5eb238adf {
    public static boolean \u01f5;

    public oce65c065a48() {
        this(new C0APacketAnimation());
    }

    public oce65c065a48(C0APacketAnimation c0APacketAnimation) {
        super(c0APacketAnimation);
    }

    public C0APacketAnimation z$3uoime2rixgf9() {
        C0APacketAnimation c0APacketAnimation;
        block6: {
            block5: {
                oce65c065a48 oce65c065a482;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oce65c065a482 = this;
                    if (n != 0) break block4;
                    if (!(oce65c065a482.\u03e3 instanceof C0APacketAnimation)) break block5;
                    oce65c065a482 = this;
                }
                c0APacketAnimation = (C0APacketAnimation)oce65c065a482.\u03e3;
                break block6;
            }
            c0APacketAnimation = null;
        }
        return c0APacketAnimation;
    }
}

