/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import x.oc110d7f376c;
import x.oc66fa4f2195;
import x.oc75d51ec7eb;
import x.oc7ab2161b9f;
import x.oc8ce2882092;
import x.oc9755810e45;
import x.oc9adb807c19;
import x.ocadfd5cc157;
import x.ocbab3c9954b;
import x.oce79181588d;
import x.ocfbf6a7fb78;

public class oc2f61179d2b {
    private static final Minecraft \u03a1 = Minecraft.getMinecraft();
    public static int \u0121;

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST)
    public void \u03b7(oce79181588d oce79181588d2) {
        block14: {
            Minecraft minecraft;
            Runnable runnable2;
            block12: {
                block13: {
                    oce79181588d oce79181588d3;
                    int n;
                    block10: {
                        block11: {
                            n = oc75d51ec7eb.\u03e9;
                            oce79181588d3 = oce79181588d2;
                            if (n != 0) break block10;
                            if (!oce79181588d3.isCanceled()) break block11;
                            return;
                        }
                        oce79181588d3 = oce79181588d2;
                    }
                    runnable2 = () -> {
                        if (!oce79181588d3.isCanceled()) {
                            ocfbf6a7fb78.\u0101().\u03e2(oce79181588d3);
                        }
                    };
                    minecraft = \u03a1;
                    if (n != 0) break block12;
                    if (!minecraft.isCallingFromMinecraftThread()) break block13;
                    runnable2.run();
                    if (n == 0) break block14;
                }
                minecraft = \u03a1;
            }
            minecraft.addScheduledTask(runnable2);
        }
    }

    @oc66fa4f2195
    public void \u03bc(oc9adb807c19 oc9adb807c192) {
        int n;
        ocfbf6a7fb78 ocfbf6a7fb782;
        block11: {
            int n2;
            block12: {
                int n3;
                block10: {
                    n3 = oc75d51ec7eb.\u03e9;
                    if (oc9adb807c192.\u04b0 == oc110d7f376c.END && oc7ab2161b9f.\u00d0()) break block10;
                    return;
                }
                ocfbf6a7fb782 = ocfbf6a7fb78.\u0101();
                n2 = ocfbf6a7fb782.\u01bd();
                if (n3 != 0) break block11;
                if (n2 != 0) break block12;
                return;
            }
            n2 = n = 0;
        }
        if (oc9755810e45.\u0492 != null) {
            n = Math.max(n, oc9755810e45.\u0492.\u01ae());
        }
        if (n > 0) {
            ocfbf6a7fb782.\u04a9(n);
        }
    }

    @oc66fa4f2195
    public void \u03c1(ocbab3c9954b ocbab3c9954b2) {
        ocfbf6a7fb78.\u0101().\u012f();
    }

    @oc66fa4f2195
    public void \u0136(ocadfd5cc157 ocadfd5cc1572) {
        block7: {
            ocfbf6a7fb78 ocfbf6a7fb782;
            block8: {
                int n = oc75d51ec7eb.\u03e9;
                if (ocadfd5cc1572.\u0426 != oc2f61179d2b.\u03a1.thePlayer) {
                    return;
                }
                ocfbf6a7fb782 = ocfbf6a7fb78.\u0101();
                if (n != 0) break block7;
                if (ocfbf6a7fb782.\u01bd()) break block8;
                return;
            }
            ocfbf6a7fb782.\u012f();
            ocfbf6a7fb782.\u00c4();
        }
    }
}

