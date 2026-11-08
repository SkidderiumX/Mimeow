/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockWeb;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import x.oc205fefdaba;
import x.oc25aa89b91f;
import x.oc278c6c6c7f;
import x.oc2f61de30bc;
import x.oc4ac72a2961;
import x.oc69da1aa7f5;
import x.oc9d4393f3ce;
import x.oca9cc61aada;
import x.ocbab3c9954b;
import x.occ2f8dff8d8;
import x.ocd6ae010123;
import x.ocdb9d3f5f92;
import x.oce79181588d;

public class oce0f81dea63
extends oc4ac72a2961 {
    private static final int \u0156 = 500;
    private final oca9cc61aada \u0574;
    private final oca9cc61aada \u04b9;
    private final occ2f8dff8d8 \u03f0;
    private final oc278c6c6c7f \u04ca = new oc278c6c6c7f();
    private double \u0553;
    private boolean \u04bc;
    private int \u028a;
    public static boolean \u01a9;

    public oce0f81dea63(ocdb9d3f5f92 ocdb9d3f5f922) {
        super("Miniblox", ocdb9d3f5f922);
        this.\u0574 = new oca9cc61aada("Silent Ticks", 7.0, 1.0, 15.0, 1.0);
        ocdb9d3f5f922.\u028c(this.\u0574);
        this.\u04b9 = new oca9cc61aada("Teleport Delay", 20.0, 10.0, 25.0, 1.0);
        ocdb9d3f5f922.\u028c(this.\u04b9);
        this.\u03f0 = new occ2f8dff8d8("Silent Accept Teleports", true);
        ocdb9d3f5f922.\u028c(this.\u03f0);
        this.\u0171(false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void z$lg1k3tz4etot() {
        block15: {
            oce0f81dea63 oce0f81dea632;
            boolean bl;
            block13: {
                block14: {
                    block12: {
                        bl = oc4ac72a2961.\u01fe;
                        oce0f81dea632 = this;
                        if (bl) break block12;
                        if (oce0f81dea632.\u03a3.thePlayer == null) return;
                        oce0f81dea632 = this;
                    }
                    if (bl) break block13;
                    if (oce0f81dea632.\u03a3.theWorld != null) break block14;
                    return;
                }
                oce0f81dea632 = this;
            }
            BlockPos blockPos = oce0f81dea632.\u046d(0x2503DC35 ^ 0x2503DDC1);
            if (bl) return;
            if (blockPos == null) break block15;
            this.\u04bc = true;
            this.\u028a = this.\u03a3.thePlayer.ticksExisted;
            this.\u037a(blockPos);
        }
        this.\u0553 = 0.0;
    }

    @Override
    public void z$38kb8b9ql2ia2() {
        this.\u04ca.\u0148();
    }

    @Override
    public void z$3hx9xwukabx4k() {
        this.\u0171(this.\u03f2.\u00e6(this));
    }

    @Override
    public void z$3k8mdtemx7z2b(oc205fefdaba oc205fefdaba2) {
        oc205fefdaba2.setCanceled(true);
    }

    @Override
    public void z$2d31hhf4p6ldv(oc2f61de30bc oc2f61de30bc2) {
        this.\u04ca.\u0552(0x48D636FCB681F461L ^ 0x48D636FCB681F789L, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void z$gcybqtfqaji6(oc25aa89b91f oc25aa89b91f2) {
        double d;
        double d2;
        block32: {
            boolean bl;
            block31: {
                oce0f81dea63 oce0f81dea632;
                int n;
                block30: {
                    int n2;
                    block29: {
                        int n3;
                        block28: {
                            bl = oc4ac72a2961.\u01fe;
                            oce0f81dea63 oce0f81dea633 = this;
                            if (!bl) {
                                if (oce0f81dea633.\u03a3.thePlayer == null) return;
                                oce0f81dea633 = this;
                            }
                            if (!bl) {
                                if (oce0f81dea633.\u03a3.theWorld == null) {
                                    return;
                                }
                                oce0f81dea633 = this;
                            }
                            n = oce0f81dea633.\u03a3.thePlayer.ticksExisted;
                            int n4 = (int)this.\u04b9.\u04c1();
                            oce0f81dea63 oce0f81dea634 = this;
                            if (!bl) {
                                if (oce0f81dea634.\u04bc && n - this.\u028a >= n4) {
                                    this.\u04bc = false;
                                }
                                oce0f81dea634 = this;
                            }
                            double d3 = Math.toRadians(oce0f81dea634.\u03a3.thePlayer.rotationYaw);
                            d2 = Math.sin(d3);
                            d = Math.cos(d3);
                            n3 = this.\u03a3.thePlayer.capabilities.allowFlying;
                            if (bl) break block28;
                            if (n3 != 0) {
                                this.\u028a = n;
                            }
                            n2 = n;
                            if (bl) break block29;
                            n3 = n2 % n4;
                        }
                        if (n3 != 0) return;
                        oce0f81dea632 = this;
                        if (bl) break block30;
                        n2 = oce0f81dea632.\u03a3.thePlayer.capabilities.allowFlying ? 1 : 0;
                    }
                    if (n2 != 0) {
                        return;
                    }
                    oce0f81dea632 = this;
                }
                BlockPos blockPos = oce0f81dea632.\u046d(0x89A0844F ^ 0x89A085BB);
                if (bl) break block31;
                if (blockPos == null) break block32;
                this.\u04bc = true;
                this.\u028a = n;
                this.\u037a(blockPos);
            }
            if (!bl) return;
        }
        ocd6ae010123.\u0115(new C03PacketPlayer.C04PacketPlayerPosition(d2 * 9.5, this.\u03a3.thePlayer.posY, d * 9.5, this.\u03a3.thePlayer.onGround));
    }

    @Override
    public void z$1ea7s7sj3pbka(oc9d4393f3ce oc9d4393f3ce2) {
        this.\u04ca.\u0533(oc9d4393f3ce2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void z$clicwfc40ajs(oce79181588d oce79181588d2) {
        oce0f81dea63 oce0f81dea632;
        block34: {
            boolean bl;
            block33: {
                int n;
                block30: {
                    block32: {
                        block31: {
                            oce0f81dea63 oce0f81dea633;
                            block28: {
                                block29: {
                                    block27: {
                                        bl = oc4ac72a2961.\u01fe;
                                        oce0f81dea633 = this;
                                        if (bl) break block27;
                                        oce0f81dea633.\u04ca.\u041e(oce79181588d2);
                                        if (!(oce79181588d2.\u04a0() instanceof S08PacketPlayerPosLook)) return;
                                        oce0f81dea633 = this;
                                    }
                                    if (bl) break block28;
                                    if (oce0f81dea633.\u03a3.thePlayer != null) break block29;
                                    return;
                                }
                                oce0f81dea633 = this;
                            }
                            n = oce0f81dea633.\u03a3.thePlayer.ticksExisted - this.\u028a;
                            if (bl) break block30;
                            if (n <= (int)this.\u0574.\u04c1()) break block31;
                            oce0f81dea632 = this;
                            if (bl) break block32;
                            if (oce0f81dea632.\u03a3.thePlayer.capabilities.allowFlying) break block31;
                            oce79181588d2.setCanceled(true);
                        }
                        oce0f81dea632 = this;
                    }
                    if (bl) break block33;
                    oce0f81dea632.\u0553 = this.\u0240();
                }
                if (n <= 0) return;
                oce0f81dea632 = this;
            }
            if (bl) break block34;
            if (oce0f81dea632.\u03a3.thePlayer.capabilities.allowFlying) return;
            oce0f81dea632 = this;
        }
        if (!oce0f81dea632.\u03f0.\u01ed()) {
            return;
        }
        oce79181588d2.setCanceled(true);
        S08PacketPlayerPosLook s08PacketPlayerPosLook = (S08PacketPlayerPosLook)oce79181588d2.\u04a0();
        C03PacketPlayer.C06PacketPlayerPosLook c06PacketPlayerPosLook = new C03PacketPlayer.C06PacketPlayerPosLook(s08PacketPlayerPosLook.getX(), s08PacketPlayerPosLook.getY(), s08PacketPlayerPosLook.getZ(), s08PacketPlayerPosLook.getYaw(), s08PacketPlayerPosLook.getPitch(), this.\u03a3.thePlayer.onGround);
        ocd6ae010123.\u0115(c06PacketPlayerPosLook);
        ocd6ae010123.\u0115(new C03PacketPlayer.C06PacketPlayerPosLook(s08PacketPlayerPosLook.getX(), s08PacketPlayerPosLook.getY(), s08PacketPlayerPosLook.getZ(), s08PacketPlayerPosLook.getYaw(), s08PacketPlayerPosLook.getPitch(), this.\u03a3.thePlayer.onGround));
    }

    @Override
    public void z$wf8ltemaqp1d(ocbab3c9954b ocbab3c9954b2) {
        block4: {
            boolean bl;
            block6: {
                block5: {
                    this.\u04ca.\u0255();
                    this.\u04bc = false;
                    this.\u028a = 0;
                    boolean bl2 = oc4ac72a2961.\u01fe;
                    this.\u0553 = 0.0;
                    if (!bl2) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
    }

    private void \u037a(BlockPos blockPos) {
        ocd6ae010123.\u0115(new C03PacketPlayer.C04PacketPlayerPosition((double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5, this.\u03a3.thePlayer.onGround));
        ocd6ae010123.\u0115(new C03PacketPlayer.C04PacketPlayerPosition(this.\u03a3.thePlayer.posX + this.\u03a3.thePlayer.motionX, this.\u03a3.thePlayer.posY + this.\u03a3.thePlayer.motionY, this.\u03a3.thePlayer.posZ + this.\u03a3.thePlayer.motionZ, this.\u03a3.thePlayer.onGround));
    }

    private BlockPos \u046d(int n) {
        double d = this.\u03a3.thePlayer.posX;
        double d2 = this.\u03a3.thePlayer.posZ;
        int n2 = MathHelper.floor_double(this.\u03a3.thePlayer.posY);
        double d3 = Double.MAX_VALUE;
        boolean bl = oc4ac72a2961.\u01fe;
        BlockPos blockPos = null;
        int n3 = -n;
        while (n3 <= n) {
            block22: {
                int n4 = -n;
                while (n4 <= n) {
                    block23: {
                        block24: {
                            Block block;
                            BlockPos blockPos2;
                            block27: {
                                Block block2;
                                block26: {
                                    block25: {
                                        blockPos2 = new BlockPos(MathHelper.floor_double(d) + n3, n2, MathHelper.floor_double(d2) + n4);
                                        if (bl) break block22;
                                        block2 = this.\u03a3.theWorld.getBlockState(blockPos2).getBlock();
                                        if (bl) break block23;
                                        if (!block2.getMaterial().isSolid()) break block24;
                                        block = block2;
                                        if (bl) break block25;
                                        if (!block.isFullBlock()) break block24;
                                        block = block2;
                                    }
                                    if (bl) break block26;
                                    if (block instanceof BlockLeaves) break block24;
                                    block = block2;
                                }
                                if (bl) break block27;
                                if (block instanceof BlockSnow) break block24;
                                block = block2;
                            }
                            if (block instanceof BlockWeb && !bl) break block24;
                            double d4 = this.\u03a3.thePlayer.getDistance((double)blockPos2.getX() + 0.5, blockPos2.getY(), (double)blockPos2.getZ() + 0.5);
                            if (bl) break block23;
                            if (!(d4 < d3)) break block24;
                            d3 = d4;
                            blockPos = blockPos2;
                        }
                        ++n4;
                    }
                    if (!bl) continue;
                }
                ++n3;
            }
            if (!bl) continue;
        }
        return blockPos;
    }

    private double \u0240() {
        return this.\u0135(0.2873);
    }

    private double \u0135(double d) {
        if (this.\u03a3.thePlayer.isPotionActive(Potion.moveSpeed)) {
            d *= 1.0 + 0.2 * (double)(this.\u03a3.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);
        }
        return d;
    }

    private void \u0171(boolean bl) {
        this.\u0574.\u0209(bl, this.\u03f2);
        this.\u04b9.\u0209(bl, this.\u03f2);
        this.\u03f0.\u0209(bl, this.\u03f2);
    }
}

