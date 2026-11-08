/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import x.oc2cf3d80e17;
import x.oc75d51ec7eb;
import x.ocda171fe5d8;

public class ocd6ae010123
implements ocda171fe5d8 {
    private static final Set<Packet<?>> \u02a1 = Collections.newSetFromMap(Collections.synchronizedMap(new IdentityHashMap()));
    private static final Set<Packet<?>> z = Collections.newSetFromMap(Collections.synchronizedMap(new IdentityHashMap()));
    public static boolean \u012c;

    public static boolean \u0129(Packet<?> packet) {
        return \u02a1.remove(packet);
    }

    public static boolean \u04ca(Packet<?> packet) {
        return z.remove(packet);
    }

    public static void \u02b3() {
        \u02a1.clear();
        z.clear();
    }

    public static void \u0116(Packet<?> packet) {
        block6: {
            Minecraft minecraft;
            block7: {
                int n = oc75d51ec7eb.\u03e9;
                if (packet == null) break block6;
                minecraft = ocda171fe5d8.\u01d4;
                if (n != 0) break block7;
                if (minecraft.getNetHandler() == null) break block6;
                minecraft = ocda171fe5d8.\u01d4;
            }
            minecraft.getNetHandler().getNetworkManager().sendPacket(packet);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void \u0115(Packet packet) {
        if (packet == null) return;
        if (packet.getClass().getSimpleName().startsWith("S")) return;
        if (oc2cf3d80e17.\u0425 == null) return;
        if (oc2cf3d80e17.\u0425.thePlayer == null) {
            return;
        }
        \u02a1.add(packet);
        try {
            oc2cf3d80e17.\u0425.thePlayer.sendQueue.addToSendQueue(packet);
            return;
        }
        catch (RuntimeException runtimeException) {
            \u02a1.remove(packet);
            throw runtimeException;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void \u00c5(Packet packet) {
        int n = oc75d51ec7eb.\u03e9;
        if (packet == null) return;
        Minecraft minecraft = oc2cf3d80e17.\u0425;
        if (n == 0) {
            if (minecraft == null) return;
            minecraft = oc2cf3d80e17.\u0425;
        }
        if (minecraft.getNetHandler() == null) {
            return;
        }
        try {
            packet.processPacket(oc2cf3d80e17.\u0425.getNetHandler());
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void \u046f(Packet<?> packet) {
        Minecraft minecraft;
        block5: {
            block6: {
                block4: {
                    int n = oc75d51ec7eb.\u03e9;
                    if (packet == null) break block4;
                    minecraft = oc2cf3d80e17.\u0425;
                    if (n != 0) break block5;
                    if (minecraft != null) break block6;
                }
                return;
            }
            z.add(packet);
            minecraft = oc2cf3d80e17.\u0425;
        }
        minecraft.addScheduledTask(() -> {
            try {
                ocd6ae010123.\u00c5(packet);
            }
            finally {
                z.remove(packet);
            }
        });
    }

    public static void \u01ad() {
        ocda171fe5d8.\u01d4.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
    }
}

