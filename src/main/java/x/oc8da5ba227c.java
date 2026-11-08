/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x.oc2f60cd9d1e;
import x.oc3d1d10e2c1;
import x.oc66fa4f2195;
import x.oc8ce2882092;
import x.oc9d4393f3ce;
import x.oca92b9fb920;
import x.ocacfd09d720;
import x.ocb67361fd4e;
import x.ocbab3c9954b;
import x.ocbbcd2a57ff;
import x.oce79181588d;
import x.ocf6b0e5bf86;

public class oc8da5ba227c
extends ocacfd09d720 {
    @NotNull
    private final ocbbcd2a57ff \u00c5 = new ocbbcd2a57ff(this);
    @NotNull
    private final Set<Packet<?>> \u0201 = Collections.newSetFromMap(Collections.synchronizedMap(new IdentityHashMap()));
    @Nullable
    private volatile Vec3 \u0580;
    public static boolean \u00e5;

    public void \u0295(@NotNull oc3d1d10e2c1 oc3d1d10e2c12) {
        this.\u00c5.\u01de(oc3d1d10e2c12);
    }

    public int \u0546(@NotNull oc2f60cd9d1e oc2f60cd9d1e2, @NotNull oc3d1d10e2c1 oc3d1d10e2c12) {
        return this.\u00c5.\u02a1(oc2f60cd9d1e2, oc3d1d10e2c12);
    }

    public boolean \u0292(@NotNull oc2f60cd9d1e oc2f60cd9d1e2, @NotNull oc3d1d10e2c1 oc3d1d10e2c12) {
        return this.\u00c5.\u0285(oc2f60cd9d1e2, oc3d1d10e2c12);
    }

    public void \u0144(@NotNull oc2f60cd9d1e oc2f60cd9d1e2, @NotNull oc3d1d10e2c1 oc3d1d10e2c12, long l) {
        this.\u00c5.\u0420(oc2f60cd9d1e2, oc3d1d10e2c12, l);
    }

    public void \u026d(@NotNull oc3d1d10e2c1 oc3d1d10e2c12) {
        this.\u00c5.\u0396(oc3d1d10e2c12);
    }

    public int \u0248() {
        return this.\u00c5.\u0446(oc2f60cd9d1e.\u00fb);
    }

    @Nullable
    public Vec3 \u0257() {
        return this.\u0580;
    }

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST)
    public void \u03bc(@NotNull oc9d4393f3ce oc9d4393f3ce2) {
        oc8da5ba227c oc8da5ba227c2;
        Packet<?> packet;
        block22: {
            boolean bl;
            block20: {
                int n;
                block21: {
                    block18: {
                        block19: {
                            block16: {
                                boolean bl2;
                                block17: {
                                    n = ocacfd09d720.\u03d3;
                                    if (Minecraft.getMinecraft().getNetHandler() == null) {
                                        this.\u00c5.\u04c6();
                                        this.\u03ba();
                                        return;
                                    }
                                    packet = oc9d4393f3ce2.\u025f();
                                    bl2 = this.\u047a(packet);
                                    bl = oc9d4393f3ce2.isCanceled();
                                    if (n != 0) break block16;
                                    if (!bl) break block17;
                                    return;
                                }
                                bl = bl2;
                            }
                            if (n != 0) break block18;
                            if (!bl) break block19;
                            this.\u0544(packet);
                            return;
                        }
                        bl = ocb67361fd4e.\u0424(packet);
                    }
                    if (n != 0) break block20;
                    if (!bl) break block21;
                    return;
                }
                oc8da5ba227c2 = this;
                if (n != 0) break block22;
                bl = oc8da5ba227c2.\u00c5.\u04d9(packet, oc2f60cd9d1e.\u00fb);
            }
            if (bl) {
                oc9d4393f3ce2.setCanceled(true);
                return;
            }
            oc8da5ba227c2 = this;
        }
        oc8da5ba227c2.\u0544(packet);
    }

    @oc66fa4f2195
    public void \u038f(@NotNull oce79181588d oce79181588d2) {
        boolean bl;
        block16: {
            Packet<?> packet;
            block17: {
                int n;
                block14: {
                    block15: {
                        block12: {
                            boolean bl2;
                            block13: {
                                n = ocacfd09d720.\u03d3;
                                if (Minecraft.getMinecraft().getNetHandler() == null) {
                                    this.\u00c5.\u04c6();
                                    this.\u03ba();
                                    return;
                                }
                                packet = oce79181588d2.\u04a0();
                                bl2 = this.\u047a(packet);
                                bl = oce79181588d2.isCanceled();
                                if (n != 0) break block12;
                                if (!bl) break block13;
                                return;
                            }
                            bl = bl2;
                        }
                        if (n != 0) break block14;
                        if (!bl) break block15;
                        return;
                    }
                    bl = ocb67361fd4e.\u0424(packet);
                }
                if (n != 0) break block16;
                if (!bl) break block17;
                return;
            }
            bl = this.\u00c5.\u04d9(packet, oc2f60cd9d1e.\u01b8);
        }
        if (bl) {
            oce79181588d2.setCanceled(true);
        }
    }

    @oc66fa4f2195
    public void \u01e7(@NotNull ocf6b0e5bf86 ocf6b0e5bf862) {
        if (Minecraft.getMinecraft().getNetHandler() == null) {
            this.\u00c5.\u04c6();
            this.\u03ba();
            return;
        }
        this.\u00c5.\u04d9(null, null);
    }

    @oc66fa4f2195
    public void \u0537(@NotNull ocbab3c9954b ocbab3c9954b2) {
        this.\u00c5.\u04c6();
        this.\u0201.clear();
        this.\u03ba();
        oca92b9fb920.O();
    }

    @Override
    public void z$3oshsjajatpc8(@NotNull Packet<?> packet) {
        this.\u0201.add(packet);
    }

    private boolean \u047a(@NotNull Packet<?> packet) {
        return this.\u0201.remove(packet);
    }

    private void \u0544(@NotNull Packet<?> packet) {
        block10: {
            C03PacketPlayer c03PacketPlayer;
            block11: {
                Packet<?> packet2;
                int n;
                block8: {
                    block9: {
                        n = ocacfd09d720.\u03d3;
                        packet2 = packet;
                        if (n != 0) break block8;
                        if (packet2 instanceof C03PacketPlayer) break block9;
                        return;
                    }
                    packet2 = packet;
                }
                c03PacketPlayer = (C03PacketPlayer)packet2;
                if (n != 0) break block10;
                if (c03PacketPlayer.isMoving()) break block11;
                return;
            }
            this.\u0580 = new Vec3(c03PacketPlayer.getPositionX(), c03PacketPlayer.getPositionY(), c03PacketPlayer.getPositionZ());
        }
    }

    private void \u03ba() {
        this.\u0580 = null;
    }
}

