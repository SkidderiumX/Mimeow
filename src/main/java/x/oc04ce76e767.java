/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.Packet;
import net.minecraft.util.IThreadListener;
import x.ocb67361fd4e;

public class oc04ce76e767 {
    public static boolean \u025c;

    private oc04ce76e767() {
    }

    public static boolean \u01de(IThreadListener iThreadListener, Packet<?> packet, Runnable runnable2) {
        IThreadListener iThreadListener2;
        block16: {
            block17: {
                boolean bl;
                block15: {
                    block14: {
                        boolean bl2 = false;
                        if (iThreadListener == null || packet == null) break block14;
                        if (runnable2 == null) break block14;
                        bl = ocb67361fd4e.\u022a(packet);
                        if (bl2) break block15;
                        if (bl) break block14;
                        iThreadListener2 = iThreadListener;
                        if (bl2) break block16;
                        if (!iThreadListener2.isCallingFromMinecraftThread()) break block17;
                    }
                    bl = false;
                }
                return bl;
            }
            iThreadListener2 = iThreadListener;
        }
        iThreadListener2.addScheduledTask(runnable2);
        return true;
    }
}

