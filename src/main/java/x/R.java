/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.network.play.client.C18PacketSpectate;
import net.minecraft.network.play.client.C19PacketResourcePackStatus;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S13PacketDestroyEntities;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.S18PacketEntityTeleport;
import net.minecraft.network.play.server.S19PacketEntityHeadLook;
import net.minecraft.network.play.server.S1CPacketEntityMetadata;
import net.minecraft.network.play.server.S20PacketEntityProperties;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;
import x.oc75d51ec7eb;

public enum R {
    h(new Class[]{C0FPacketConfirmTransaction.class, S1CPacketEntityMetadata.class}),
    \u0184(new Class[]{S12PacketEntityVelocity.class, S27PacketExplosion.class}),
    \u0497(new Class[]{S08PacketPlayerPosLook.class, S39PacketPlayerAbilities.class, S09PacketHeldItemChange.class}),
    \u0296(new Class[]{S13PacketDestroyEntities.class, S14PacketEntity.class, S14PacketEntity.S16PacketEntityLook.class, S14PacketEntity.S15PacketEntityRelMove.class, S14PacketEntity.S17PacketEntityLookMove.class, S18PacketEntityTeleport.class, S20PacketEntityProperties.class, S19PacketEntityHeadLook.class}),
    \u0247(new Class[]{C02PacketUseEntity.class, C0DPacketCloseWindow.class, C0EPacketClickWindow.class, C0CPacketInput.class, C0BPacketEntityAction.class, C08PacketPlayerBlockPlacement.class, C07PacketPlayerDigging.class, C09PacketHeldItemChange.class, C13PacketPlayerAbilities.class, C15PacketClientSettings.class, C16PacketClientStatus.class, C17PacketCustomPayload.class, C18PacketSpectate.class, C19PacketResourcePackStatus.class, C0APacketAnimation.class}),
    \u00d3(new Class[]{C03PacketPlayer.class, C03PacketPlayer.C04PacketPlayerPosition.class, C03PacketPlayer.C05PacketPlayerLook.class, C03PacketPlayer.C06PacketPlayerPosLook.class});
    private static final R[] $VALUES_REF;






    private final Class<?>[] I;
    private boolean \u041c;
    private static final R[] \u0106;
    public static boolean \u0181;



    private R(Class<?>[] classArray) {
        this.I = classArray;
    }

    public boolean \u04fc() {
        return this.\u041c;
    }

    public void \u0139(boolean bl) {
        this.\u041c = bl;
    }

    public boolean \u03f3(Class<?> clazz) {
        boolean bl;
        block8: {
            Class<?>[] classArray = this.I;
            int n = classArray.length;
            int n2 = oc75d51ec7eb.\u03e9;
            int n3 = 0;
            while (n3 < n) {
                block7: {
                    block9: {
                        Class<?> clazz2 = classArray[n3];
                        if (n2 != 0) break block7;
                        bl = clazz2.isAssignableFrom(clazz);
                        if (n2 != 0) break block8;
                        if (!bl) break block9;
                        return true;
                    }
                    ++n3;
                }
                if (n2 == 0) continue;
            }
            bl = false;
        }
        return bl;
    }

    private static R[] \u0555() {
        R[] rArray = new R[0x2E37D0A ^ 0x2E37D0C];
        rArray[0] = h;
        rArray[1] = \u0184;
        rArray[0x2E37D0E ^ 0x2E37D0C] = \u0497;
        rArray[0x2E37D0F ^ 0x2E37D0C] = \u0296;
        rArray[0x2E37D08 ^ 0x2E37D0C] = \u0247;
        rArray[0x2E37D09 ^ 0x2E37D0C] = \u00d3;
        return rArray;
    }


    static {
        \u0106 = R.\u0555();
    }
}

