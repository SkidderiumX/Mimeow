/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S04PacketEntityEquipment;
import net.minecraft.network.play.server.S0APacketUseBed;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
import net.minecraft.network.play.server.S0DPacketCollectItem;
import net.minecraft.network.play.server.S0EPacketSpawnObject;
import net.minecraft.network.play.server.S0FPacketSpawnMob;
import net.minecraft.network.play.server.S10PacketSpawnPainting;
import net.minecraft.network.play.server.S11PacketSpawnExperienceOrb;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S13PacketDestroyEntities;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.S18PacketEntityTeleport;
import net.minecraft.network.play.server.S19PacketEntityHeadLook;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import net.minecraft.network.play.server.S1BPacketEntityAttach;
import net.minecraft.network.play.server.S1CPacketEntityMetadata;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S1EPacketRemoveEntityEffect;
import net.minecraft.network.play.server.S2CPacketSpawnGlobalEntity;
import net.minecraft.util.Timer;
import x.oc75d51ec7eb;
import x.ocd6ae010123;

public class oc93ebf33b8e {
    private static final oc93ebf33b8e \u0476 = new oc93ebf33b8e();
    private final Queue<Packet<?>> \u02e4 = new ConcurrentLinkedQueue();
    private final Queue<Packet<?>> \u0124 = new ConcurrentLinkedQueue();
    private boolean \u0290;
    private long \u046e;
    private double \u02b3;
    private static final long \u02a7 = 50000000L;
    private static final int f = 10;
    public static boolean \u0534;

    public static oc93ebf33b8e \u0195() {
        return \u0476;
    }

    public boolean \u0229() {
        return this.\u0290;
    }

    public void \u0475() {
        block4: {
            oc93ebf33b8e oc93ebf33b8e2;
            block5: {
                int n = oc75d51ec7eb.\u03e9;
                oc93ebf33b8e2 = this;
                if (n != 0) break block4;
                if (!oc93ebf33b8e2.\u0290) break block5;
                return;
            }
            this.\u0290 = true;
            this.\u046e = System.nanoTime();
            oc93ebf33b8e2 = this;
        }
        oc93ebf33b8e2.\u02b3 = 0.0;
    }

    public void \u0193() {
        oc93ebf33b8e oc93ebf33b8e2;
        block4: {
            block5: {
                int n = oc75d51ec7eb.\u03e9;
                oc93ebf33b8e2 = this;
                if (n != 0) break block4;
                if (oc93ebf33b8e2.\u0290) break block5;
                return;
            }
            this.\u0290 = false;
            oc93ebf33b8e2 = this;
        }
        oc93ebf33b8e2.\u044b();
    }

    public void \u0504() {
        this.\u0290 = false;
        this.\u02e4.clear();
        this.\u0124.clear();
        this.\u02b3 = 0.0;
    }

    public boolean \u01e2(Packet<?> packet) {
        block12: {
            boolean bl;
            block13: {
                int n;
                block10: {
                    block11: {
                        n = oc75d51ec7eb.\u03e9;
                        bl = this.\u0290;
                        if (n != 0) break block10;
                        if (bl) break block11;
                        return false;
                    }
                    bl = oc93ebf33b8e.\u0263(packet);
                }
                if (n != 0) break block12;
                if (!bl) break block13;
                this.\u02e4.add(packet);
                if (n == 0) break block12;
            }
            bl = this.\u0124.add(packet);
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void \u0148() {
        int n;
        Minecraft minecraft;
        block21: {
            Minecraft minecraft2;
            int n2;
            block20: {
                n2 = oc75d51ec7eb.\u03e9;
                if (!this.\u0290) {
                    return;
                }
                minecraft = Minecraft.getMinecraft();
                minecraft2 = minecraft;
                if (n2 != 0) break block20;
                if (minecraft2.theWorld == null) return;
                minecraft2 = minecraft;
            }
            if (minecraft2.thePlayer == null) {
                return;
            }
            this.\u04d7();
            long l = System.nanoTime();
            long l2 = l - this.\u046e;
            this.\u046e = l;
            this.\u02b3 += (double)l2;
            int n3 = 0;
            while (this.\u02b3 >= 5.0E7) {
                n = n3++;
                if (n2 != 0 || n2 != 0) break block21;
                if (n >= (0x188F7A3 ^ 0x188F7A9)) break;
                this.\u02b3 -= 5.0E7;
                this.\u0154(minecraft);
                if (n2 == 0) continue;
                break;
            }
            n = n3;
        }
        if (n >= (0x188F7A3 ^ 0x188F7A9)) {
            this.\u02b3 = 0.0;
        }
        float f = (float)(this.\u02b3 / 5.0E7);
        Timer timer = minecraft.getTimer();
        timer.renderPartialTicks = f;
        this.\u0412(minecraft.thePlayer);
    }

    private void \u0412(EntityPlayerSP entityPlayerSP) {
        entityPlayerSP.lastTickPosX = entityPlayerSP.posX;
        entityPlayerSP.lastTickPosY = entityPlayerSP.posY;
        entityPlayerSP.lastTickPosZ = entityPlayerSP.posZ;
        entityPlayerSP.prevRotationYaw = entityPlayerSP.rotationYaw;
        entityPlayerSP.prevRotationPitch = entityPlayerSP.rotationPitch;
        entityPlayerSP.prevRotationYawHead = entityPlayerSP.rotationYawHead;
        entityPlayerSP.prevRenderYawOffset = entityPlayerSP.renderYawOffset;
        entityPlayerSP.prevLimbSwingAmount = entityPlayerSP.limbSwingAmount;
        entityPlayerSP.prevSwingProgress = entityPlayerSP.swingProgress;
        entityPlayerSP.prevCameraPitch = entityPlayerSP.cameraPitch;
    }

    public void \u044b() {
        block4: {
            Packet<?> packet;
            this.\u04d7();
            int n = oc75d51ec7eb.\u03e9;
            while ((packet = this.\u0124.poll()) != null) {
                if (n == 0) {
                    ocd6ae010123.\u00c5(packet);
                    if (n == 0) continue;
                    break;
                }
                break block4;
            }
            this.\u02b3 = 0.0;
        }
    }

    private void \u04d7() {
        Packet<?> packet;
        int n = oc75d51ec7eb.\u03e9;
        while ((packet = this.\u02e4.poll()) != null) {
            ocd6ae010123.\u00c5(packet);
            if (n == 0) continue;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u0154(Minecraft minecraft) {
        Entity entity2;
        Minecraft minecraft2;
        int n;
        EntityPlayerSP entityPlayerSP;
        block26: {
            entityPlayerSP = minecraft.thePlayer;
            n = oc75d51ec7eb.\u03e9;
            for (int i = 0; i < minecraft.theWorld.weatherEffects.size(); ++i) {
                minecraft2 = minecraft;
                if (n != 0) break block26;
                entity2 = (Entity)minecraft2.theWorld.weatherEffects.get(i);
                try {
                    ++entity2.ticksExisted;
                    entity2.onUpdate();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                Entity entity = entity2;
                if (n != 0 || !entity.isDead) continue;
                entity = minecraft.theWorld.weatherEffects.remove(i--);
                if (n == 0) continue;
            }
            minecraft2 = minecraft;
        }
        Iterator iterator2 = minecraft2.theWorld.loadedEntityList.iterator();
        while (iterator2.hasNext()) {
            block29: {
                block30: {
                    Entity entity;
                    Entity entity3;
                    block28: {
                        Entity entity4;
                        block27: {
                            entity4 = entity2 = (Entity)iterator2.next();
                            if (n == 0) {
                                if (entity4 == null) continue;
                                entity4 = entity2;
                            }
                            if (n == 0) {
                                if (entity4.isDead) continue;
                                entity4 = entity2;
                            }
                            if (n != 0) break block27;
                            if (entity4 == entityPlayerSP) continue;
                            entity3 = entity2;
                            if (n != 0) break block28;
                            entity4 = entity3.ridingEntity;
                        }
                        if (entity4 == null) break block29;
                        entity = entity2;
                        if (n != 0) break block30;
                        entity3 = entity.ridingEntity;
                    }
                    if (!entity3.isDead) {
                        entity = entity2;
                        if (n == 0) {
                            if (entity.ridingEntity.riddenByEntity == entity2 && n == 0) continue;
                        }
                    } else {
                        entity2.ridingEntity.riddenByEntity = null;
                        entity = entity2;
                    }
                }
                entity.ridingEntity = null;
            }
            try {
                minecraft.theWorld.updateEntityWithOptionalForce(entity2, true);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            if (n == 0) continue;
        }
    }

    private static boolean \u0263(Packet<?> packet) {
        boolean bl;
        block78: {
            block80: {
                block79: {
                    int n = oc75d51ec7eb.\u03e9;
                    bl = packet instanceof S0CPacketSpawnPlayer;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S0FPacketSpawnMob;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S0EPacketSpawnObject;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S10PacketSpawnPainting;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S11PacketSpawnExperienceOrb;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S2CPacketSpawnGlobalEntity;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S12PacketEntityVelocity;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S13PacketDestroyEntities;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S14PacketEntity;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S18PacketEntityTeleport;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S19PacketEntityHeadLook;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S0BPacketAnimation;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S0APacketUseBed;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S1BPacketEntityAttach;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S1CPacketEntityMetadata;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S04PacketEntityEquipment;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S1DPacketEntityEffect;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S1EPacketRemoveEntityEffect;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S19PacketEntityStatus;
                    if (n != 0) break block78;
                    if (bl) break block79;
                    bl = packet instanceof S0DPacketCollectItem;
                    if (n != 0) break block78;
                    if (!bl) break block80;
                }
                bl = true;
                break block78;
            }
            bl = false;
        }
        return bl;
    }
}

