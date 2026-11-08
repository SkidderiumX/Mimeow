/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import x.oc0e4b758d9a;
import x.oc0f63871c3b;
import x.oc66fa4f2195;
import x.oc7ab2161b9f;
import x.oc86de9e2892;
import x.oc8ce2882092;
import x.oc9755810e45;
import x.oc9d4393f3ce;
import x.ocadfd5cc157;
import x.ocbab3c9954b;
import x.ocbb165642ef;
import x.ocdd342096f8;
import x.oce79181588d;

public class oc5e549848f3 {
    private static final List<ocdd342096f8> \u01b2 = new ArrayList<ocdd342096f8>();
    static boolean \u02a2;
    public static int \u0130;

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST)
    public void \u037d(oc0e4b758d9a oc0e4b758d9a2) {
        \u02a2 = ocbb165642ef.\u02a8().\u0178();
    }

    static void \u044d(ocdd342096f8 ocdd342096f82) {
        block5: {
            List<ocdd342096f8> list;
            block4: {
                int n = \u0130;
                list = \u01b2;
                if (n != 0) break block4;
                if (list.contains(ocdd342096f82)) break block5;
                list = \u01b2;
            }
            list.add(ocdd342096f82);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u00f0(oc86de9e2892 oc86de9e28922) {
        block7: {
            int n = \u0130;
            if (!oc7ab2161b9f.\u00d0()) {
                return;
            }
            for (ocdd342096f8 ocdd342096f82 : \u01b2) {
                if (n == 0) {
                    ocdd342096f82.Z();
                    if (n == 0) continue;
                    break;
                }
                break block7;
            }
            \u01b2.clear();
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u01f7(oc9d4393f3ce oc9d4393f3ce2) {
        oc0f63871c3b.\u0167(oc9d4393f3ce2.\u025f());
    }

    public static boolean \u038f(Packet<?> packet) {
        boolean bl;
        block10: {
            block9: {
                block8: {
                    oc0f63871c3b.\u0459(packet);
                    ocdd342096f8 ocdd342096f82 = oc9755810e45.\u00ff;
                    if (!(packet instanceof C09PacketHeldItemChange) || ocdd342096f82 == null) break block8;
                    if (!ocdd342096f82.z$3rzb3dil7uydr()) break block8;
                    if (!ocdd342096f82.\u0220()) break block9;
                }
                bl = true;
                break block10;
            }
            bl = false;
        }
        return bl;
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u0481(oce79181588d oce79181588d2) {
        if (!oc7ab2161b9f.\u00d0()) {
            return;
        }
        oc0f63871c3b.\u03f5(oce79181588d2.\u04a0());
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u045e(ocadfd5cc157 ocadfd5cc1572) {
        if (ocadfd5cc1572.\u0426 == Minecraft.getMinecraft().thePlayer) {
            oc5e549848f3.\u043d();
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u0182(ocbab3c9954b ocbab3c9954b2) {
        oc5e549848f3.\u043d();
    }

    public static void \u043d() {
        ocdd342096f8.\u042f();
        \u02a2 = false;
        oc0f63871c3b.\u0167(new C03PacketPlayer());
        oc0f63871c3b.\u0459(new C03PacketPlayer());
        oc0f63871c3b.\u0525();
        oc0f63871c3b.\u00fb = 0;
        oc0f63871c3b.\u03e6 = 0;
        oc0f63871c3b.\u04c3 = 0;
        oc0f63871c3b.\u010b = 0;
        \u01b2.clear();
    }
}

