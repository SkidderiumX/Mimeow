/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import x.H;
import x.N;
import x.oc25aa89b91f;
import x.oc2cf3d80e17;
import x.oc2f60cd9d1e;
import x.oc2f61de30bc;
import x.oc3d1d10e2c1;
import x.oc479681b341;
import x.oc5b52533f96;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oca9cc61aada;
import x.ocbab3c9954b;
import x.ocd6ae010123;
import x.ocd84af7ddf8;
import x.oce4cea752dd;

public class S
extends oc69da1aa7f5 {
    private static final String[] \u0419;
    private final oca9cc61aada \u0189;
    private final oca9cc61aada \u04a4;
    private final oca9cc61aada \u0402;
    private boolean \u0490;
    private boolean \u0263;
    private double[] \u0202;
    private oc3d1d10e2c1 \u019c;
    public static int \u04eb;

    public S() {
        super("AntiVoid", oce4cea752dd.\u0495);
        this.\u0105("Tries to recover your position when falling into void.");
        this.\u0189 = new oca9cc61aada("Mode", 0, \u0419);
        this.\u028c(this.\u0189);
        this.\u04a4 = new oca9cc61aada("Distance", " blocks", 5.0, 0.0, 16.0, 0.1);
        this.\u028c(this.\u04a4);
        this.\u0402 = new oca9cc61aada("Min fall distance", 3.0, 0.0, 10.0, 1.0);
        this.\u028c(this.\u0402);
        this.z$2u87utkr1isxg();
    }

    @Override
    public String getInfo() {
        return \u0419[(int)this.\u0189.\u04c1()];
    }

    @Override
    public void onEnable() {
        this.\u00f1();
    }

    @Override
    public void onDisable() {
        this.\u049d();
        this.\u0490 = false;
        this.\u0263 = false;
    }

    @Override
    public void z$2u87utkr1isxg() {
        block14: {
            boolean bl;
            block16: {
                block15: {
                    boolean bl2;
                    oca9cc61aada oca9cc61aada2;
                    boolean bl3;
                    boolean bl4;
                    block12: {
                        block13: {
                            int n;
                            block10: {
                                block11: {
                                    bl4 = false;
                                    n = (int)this.\u0189.\u04c1();
                                    if (bl4) break block10;
                                    if (n != 1) break block11;
                                    n = 1;
                                    break block10;
                                }
                                n = 0;
                            }
                            bl3 = n;
                            oca9cc61aada2 = this.\u04a4;
                            bl2 = bl3;
                            if (bl4) break block12;
                            if (bl2) break block13;
                            bl2 = true;
                            break block12;
                        }
                        bl2 = false;
                    }
                    oca9cc61aada2.\u0209(bl2, this);
                    this.\u0402.\u0209(bl3, this);
                    if (!false) break block14;
                    if (!bl4) break block15;
                    bl = false;
                    break block16;
                }
                bl = true;
            }
            oc69da1aa7f5.\u02b8 = bl;
        }
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        this.z$2u87utkr1isxg();
    }

    @Override
    public void z$3tl278wzjcayb(N n) {
        this.z$2u87utkr1isxg();
    }

    @oc66fa4f2195
    public void \u023b(oc2f61de30bc oc2f61de30bc2) {
        block61: {
            S s;
            block62: {
                double d;
                block63: {
                    boolean bl;
                    block59: {
                        block60: {
                            block57: {
                                block58: {
                                    block55: {
                                        block56: {
                                            boolean bl2;
                                            block54: {
                                                block53: {
                                                    block52: {
                                                        block51: {
                                                            S s2;
                                                            int n;
                                                            block49: {
                                                                block50: {
                                                                    bl = false;
                                                                    n = oc7ab2161b9f.\u00d0();
                                                                    if (bl) break block49;
                                                                    if (n != 0) break block50;
                                                                    this.\u00f1();
                                                                    return;
                                                                }
                                                                s2 = this;
                                                                if (bl) break block51;
                                                                n = (int)s2.\u0189.\u04c1();
                                                            }
                                                            if (n == 1) {
                                                                this.\u00f1();
                                                                return;
                                                            }
                                                            s2 = this;
                                                        }
                                                        bl2 = oc69da1aa7f5.\u0151.thePlayer.capabilities.allowFlying;
                                                        if (bl) break block52;
                                                        if (bl2) break block53;
                                                        bl2 = this.\u050d(oc69da1aa7f5.\u0151.thePlayer.getEntityBoundingBox().expand(-1.0E-6, 0.0, -1.0E-6));
                                                    }
                                                    if (bl) break block54;
                                                    if (!bl2) break block53;
                                                    bl2 = true;
                                                    break block54;
                                                }
                                                bl2 = false;
                                            }
                                            s2.\u0490 = bl2;
                                            s = this;
                                            if (bl) break block55;
                                            if (s.\u0490) break block56;
                                            this.\u049d();
                                        }
                                        s = this;
                                    }
                                    if (bl) break block57;
                                    if (s.\u0202 == null) break block58;
                                    s = this;
                                    if (bl) break block57;
                                    if (!s.\u050d(this.\u0141())) break block58;
                                    this.\u049d();
                                }
                                s = this;
                            }
                            if (bl) break block59;
                            if (s.\u0263) break block60;
                            s = this;
                            if (bl) break block59;
                            if (!s.\u0490) break block60;
                            if (H.\u0257) break block60;
                            this.\u00d2();
                        }
                        s = this;
                    }
                    if (bl) break block61;
                    if (s.\u019c == null) break block62;
                    s = this;
                    if (bl) break block61;
                    if (s.\u0202 == null) break block62;
                    d = oc69da1aa7f5.\u0151.thePlayer.posY;
                    if (bl) break block63;
                    if (!(d < this.\u0202[1] - this.\u04a4.\u04c1())) break block62;
                    d = this.\u0202[1] - ThreadLocalRandom.current().nextDouble(10.0, 20.0);
                }
                double d2 = d;
                ocd6ae010123.\u0115(new C03PacketPlayer.C04PacketPlayerPosition(this.\u0202[0], d2, this.\u0202[0x23E8ED37 ^ 0x23E8ED35], false));
                this.\u049d();
            }
            s = this;
        }
        s.\u0263 = this.\u0490;
    }

    @oc66fa4f2195
    public void \u0371(oc25aa89b91f oc25aa89b91f2) {
        block14: {
            int n;
            block16: {
                boolean bl;
                block15: {
                    block13: {
                        bl = false;
                        n = (int)this.\u0189.\u04c1();
                        if (bl) break block13;
                        if (n != 1) break block14;
                        n = oc7ab2161b9f.\u00d0() ? 1 : 0;
                    }
                    if (bl) break block15;
                    if (n == 0) break block14;
                    n = ocd84af7ddf8.\u0153() ? 1 : 0;
                }
                if (bl) break block16;
                if (n == 0) break block14;
                double d = (double)oc69da1aa7f5.\u0151.thePlayer.fallDistance - this.\u0402.\u04c1();
                n = d == 0.0 ? 0 : (d > 0.0 ? 1 : -1);
            }
            if (n >= 0) {
                ocd6ae010123.\u0116(new C03PacketPlayer.C04PacketPlayerPosition());
            }
        }
    }

    @oc66fa4f2195
    public void \u0194(oc479681b341 oc479681b3412) {
        block16: {
            ItemStack itemStack;
            block15: {
                boolean bl;
                block17: {
                    block14: {
                        int n;
                        block13: {
                            bl = false;
                            n = (int)this.\u0189.\u04c1();
                            if (bl) break block13;
                            if (n == 1) break block14;
                            n = oc7ab2161b9f.\u00d0() ? 1 : 0;
                        }
                        if (n != 0) break block17;
                    }
                    return;
                }
                ItemStack itemStack2 = oc69da1aa7f5.\u0151.thePlayer.getHeldItem();
                itemStack = itemStack2;
                if (bl) break block15;
                if (itemStack == null) break block16;
                itemStack = itemStack2;
            }
            if (itemStack.getItem() instanceof ItemEnderPearl) {
                this.\u049d();
            }
        }
    }

    @oc66fa4f2195
    public void \u0532(ocbab3c9954b ocbab3c9954b2) {
        this.\u00f1();
    }

    private void \u00d2() {
        block4: {
            block5: {
                boolean bl = false;
                this.\u049d();
                if (bl) break block4;
                if (oc2cf3d80e17.\u0230 != null) break block5;
                return;
            }
            double[] dArray = new double[0xBE196046 ^ 0xBE196045];
            dArray[0] = oc69da1aa7f5.\u0151.thePlayer.prevPosX;
            dArray[1] = oc69da1aa7f5.\u0151.thePlayer.prevPosY;
            dArray[0xBE196047 ^ 0xBE196045] = oc69da1aa7f5.\u0151.thePlayer.prevPosZ;
            this.\u0202 = dArray;
            this.\u019c = new oc3d1d10e2c1(oc2f60cd9d1e.\u054d, new oc5b52533f96(this));
            oc2cf3d80e17.\u0230.\u0295(this.\u019c);
        }
    }

    private void \u049d() {
        block4: {
            S s;
            block5: {
                boolean bl = false;
                s = this;
                if (bl) break block4;
                if (s.\u019c == null) break block5;
                this.\u019c.\u0220().\u00e5();
                this.\u019c = null;
            }
            s = this;
        }
        s.\u0202 = null;
    }

    private void \u00f1() {
        this.\u049d();
        this.\u0490 = false;
        this.\u0263 = false;
    }

    private AxisAlignedBB \u0141() {
        double d = (double)oc69da1aa7f5.\u0151.thePlayer.width / 2.0;
        return new AxisAlignedBB(this.\u0202[0] - d, this.\u0202[1], this.\u0202[0x882268C ^ 0x882268E] - d, this.\u0202[0] + d, this.\u0202[1] + (double)oc69da1aa7f5.\u0151.thePlayer.height, this.\u0202[0x882268C ^ 0x882268E] + d);
    }

    private boolean \u050d(AxisAlignedBB axisAlignedBB) {
        int n;
        block25: {
            int n2;
            int n3;
            boolean bl;
            block23: {
                block24: {
                    int n4;
                    block21: {
                        block22: {
                            boolean bl2;
                            block19: {
                                block20: {
                                    bl = false;
                                    bl2 = oc69da1aa7f5.\u0151.thePlayer.isInWater();
                                    if (bl) break block19;
                                    if (bl2) break block20;
                                    n4 = oc69da1aa7f5.\u0151.thePlayer.isInLava();
                                    if (bl) break block21;
                                    if (n4 == 0) break block22;
                                }
                                bl2 = false;
                            }
                            return bl2;
                        }
                        n4 = MathHelper.floor_double(axisAlignedBB.minY);
                    }
                    n3 = n4;
                    n2 = n3;
                    if (bl) break block23;
                    if (n2 >= 0) break block24;
                    return true;
                }
                n2 = MathHelper.floor_double(axisAlignedBB.minX);
            }
            int n5 = n2;
            int n6 = MathHelper.floor_double(axisAlignedBB.maxX + 1.0);
            int n7 = MathHelper.floor_double(axisAlignedBB.minZ);
            int n8 = MathHelper.floor_double(axisAlignedBB.maxZ + 1.0);
            int n9 = n5;
            while (n9 < n6) {
                block26: {
                    n = n7;
                    if (bl) break block25;
                    int n10 = n;
                    while (n10 < n8) {
                        block27: {
                            if (bl) break block26;
                            int n11 = n3;
                            while (n11 >= 0) {
                                block28: {
                                    block29: {
                                        BlockPos blockPos = new BlockPos(n9, n11, n10);
                                        if (bl) break block27;
                                        if (bl) break block28;
                                        if (oc69da1aa7f5.\u0151.theWorld.getBlockState(blockPos).getBlock().isReplaceable(oc69da1aa7f5.\u0151.theWorld, blockPos)) break block29;
                                        return false;
                                    }
                                    --n11;
                                }
                                if (!bl) continue;
                            }
                            ++n10;
                        }
                        if (!bl) continue;
                    }
                    ++n9;
                }
                if (!bl) continue;
            }
            n = 1;
        }
        return n != 0;
    }

    static {
        String[] stringArray = new String[0xDB5B9AF9 ^ 0xDB5B9AFB];
        stringArray[0] = "Blink";
        stringArray[1] = "Packet";
        \u0419 = stringArray;
    }
}

