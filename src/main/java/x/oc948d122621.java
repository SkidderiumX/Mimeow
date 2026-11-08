/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C0DPacketCloseWindow;
import x.ocb5eb238adf;
import x.occ0b63c0426;

public class oc948d122621
extends ocb5eb238adf {
    public int \u04f1;
    public static int \u0145;

    public oc948d122621(int n) {
        this(new C0DPacketCloseWindow(n));
    }

    public oc948d122621(C0DPacketCloseWindow c0DPacketCloseWindow) {
        super(c0DPacketCloseWindow);
        this.\u04f1 = c0DPacketCloseWindow == null ? 0 : c0DPacketCloseWindow.getWindowId();
    }

    public C0DPacketCloseWindow z$3uoime2rixgf9() {
        C0DPacketCloseWindow c0DPacketCloseWindow;
        block6: {
            block5: {
                oc948d122621 oc948d1226212;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc948d1226212 = this;
                    if (n != 0) break block4;
                    if (!(oc948d1226212.\u03e3 instanceof C0DPacketCloseWindow)) break block5;
                    oc948d1226212 = this;
                }
                c0DPacketCloseWindow = (C0DPacketCloseWindow)oc948d1226212.\u03e3;
                break block6;
            }
            c0DPacketCloseWindow = null;
        }
        return c0DPacketCloseWindow;
    }
}

