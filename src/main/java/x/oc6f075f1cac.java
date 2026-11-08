/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C0EPacketClickWindow;
import x.ocb5eb238adf;
import x.occ0b63c0426;
import x.occ2ace216f9;

public class oc6f075f1cac
extends ocb5eb238adf {
    public int \u01de;
    public int \u014c;
    public int \u0231;
    public int \u00c6;
    public short \u0185;
    public occ2ace216f9 \u0546;
    public static boolean \u0421;

    public oc6f075f1cac(int n, int n2, int n3, int n4, occ2ace216f9 occ2ace216f92) {
        this(new C0EPacketClickWindow(n, n2, n3, n4, occ2ace216f92 == null ? null : occ2ace216f92.W(), 0));
    }

    public oc6f075f1cac(C0EPacketClickWindow c0EPacketClickWindow) {
        super(c0EPacketClickWindow);
        this.\u01de = c0EPacketClickWindow == null ? 0 : c0EPacketClickWindow.getWindowId();
        this.\u014c = c0EPacketClickWindow == null ? 0 : c0EPacketClickWindow.getSlotId();
        this.\u0231 = c0EPacketClickWindow == null ? 0 : c0EPacketClickWindow.getUsedButton();
        this.\u00c6 = c0EPacketClickWindow == null ? 0 : c0EPacketClickWindow.getMode();
        this.\u0185 = c0EPacketClickWindow == null ? (short)0 : c0EPacketClickWindow.getActionNumber();
        this.\u0546 = c0EPacketClickWindow == null ? null : occ2ace216f9.\u0256(c0EPacketClickWindow.getClickedItem());
    }

    public C0EPacketClickWindow z$3uoime2rixgf9() {
        C0EPacketClickWindow c0EPacketClickWindow;
        block6: {
            block5: {
                oc6f075f1cac oc6f075f1cac2;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc6f075f1cac2 = this;
                    if (n != 0) break block4;
                    if (!(oc6f075f1cac2.\u03e3 instanceof C0EPacketClickWindow)) break block5;
                    oc6f075f1cac2 = this;
                }
                c0EPacketClickWindow = (C0EPacketClickWindow)oc6f075f1cac2.\u03e3;
                break block6;
            }
            c0EPacketClickWindow = null;
        }
        return c0EPacketClickWindow;
    }
}

