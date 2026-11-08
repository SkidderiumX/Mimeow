/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S40PacketDisconnect;
import x.oc75d51ec7eb;

public class oc1b38068efb {
    private static final String[] \u026e;
    private static final Class<?>[] \u0527;
    public static int \u040b;

    private oc1b38068efb() {
    }

    public static boolean \u03ad(String string) {
        boolean bl;
        block11: {
            int n = oc75d51ec7eb.\u03e9;
            if (string == null) {
                return false;
            }
            String[] stringArray = \u026e;
            int n2 = stringArray.length;
            int n3 = 0;
            while (n3 < n2) {
                block10: {
                    block12: {
                        String string2 = stringArray[n3];
                        if (n != 0) break block10;
                        bl = string.contains(string2);
                        if (n != 0) break block11;
                        if (!bl) break block12;
                        return true;
                    }
                    ++n3;
                }
                if (n == 0) continue;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u0462(Packet<?> packet) {
        boolean bl;
        block6: {
            block5: {
                Packet<?> packet2;
                int n;
                block4: {
                    n = oc75d51ec7eb.\u03e9;
                    packet2 = packet;
                    if (n != 0) break block4;
                    if (packet2 == null) break block5;
                    packet2 = packet;
                }
                bl = oc1b38068efb.u(packet2.getClass());
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    static boolean u(Class<?> clazz) {
        return oc1b38068efb.\u03d1(clazz, \u0527);
    }

    public static boolean \u0532(Packet<?> packet) {
        return packet instanceof S08PacketPlayerPosLook;
    }

    private static boolean \u03d1(Class<?> clazz, Class<?>[] classArray) {
        boolean bl;
        block11: {
            int n = oc75d51ec7eb.\u03e9;
            if (clazz == null) {
                return false;
            }
            Class<?>[] classArray2 = classArray;
            int n2 = classArray2.length;
            int n3 = 0;
            while (n3 < n2) {
                block10: {
                    block12: {
                        Class<?> clazz2 = classArray2[n3];
                        if (n != 0) break block10;
                        bl = clazz2.isAssignableFrom(clazz);
                        if (n != 0) break block11;
                        if (!bl) break block12;
                        return true;
                    }
                    ++n3;
                }
                if (n == 0) continue;
            }
            bl = false;
        }
        return bl;
    }

    static {
        String[] stringArray = new String[0xDCB1F6AC ^ 0xDCB1F6AE];
        stringArray[0] = "game.player.hurt";
        stringArray[1] = "game.player.die";
        \u026e = stringArray;
        Class[] classArray = new Class[0xDCB1F6AD ^ 0xDCB1F6AE];
        classArray[0] = S01PacketJoinGame.class;
        classArray[1] = S07PacketRespawn.class;
        classArray[0xDCB1F6AC ^ 0xDCB1F6AE] = S40PacketDisconnect.class;
        \u0527 = classArray;
    }
}

