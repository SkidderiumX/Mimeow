/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import x.MouseEvent;
import x.N;
import x.oc0e4b758d9a;
import x.oc163a7c5afc;
import x.oc1ee7f471be;
import x.oc25aa89b91f;
import x.oc2f61de30bc;
import x.oc4dc4dd9f31;
import x.oc52918cda9d;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc746a23b244;
import x.oc75d51ec7eb;
import x.oc7ab2161b9f;
import x.oc84f20a0bc5;
import x.oc86de9e2892;
import x.oc8edd24b1ed;
import x.oc9755810e45;
import x.oc9d4393f3ce;
import x.oca9cc61aada;
import x.ocadfd5cc157;
import x.occ2f8dff8d8;
import x.occb1ed1ed8f;
import x.occc831eff22;
import x.ocd199f3873b;
import x.oce4cea752dd;
import x.oce79181588d;
import x.ocf923d5a814;

public class oc02ef9f5e73
extends oc69da1aa7f5 {
    private static final String[] C;
    private static final EnumFacing[] \u04f9;
    private final oca9cc61aada \u0580;
    private final occc831eff22 \u01a8;
    private final occ2f8dff8d8 \u0202;
    private final occ2f8dff8d8 S;
    private final oc163a7c5afc \u0275;
    private ocd199f3873b \u04c9;
    private int \u03df = -1;
    public static int \u0153;

    public oc02ef9f5e73() {
        super("BridgeAssist", oce4cea752dd.\u0437);
        this.\u0105("Help you bridge automatically.");
        this.\u0580 = new oca9cc61aada("Mode", 0, C);
        this.\u028c(this.\u0580);
        this.\u01a8 = new occc831eff22("Conditions");
        this.\u028c(this.\u01a8);
        this.\u0202 = new occ2f8dff8d8(this.\u01a8, "Looking down", false);
        this.\u028c(this.\u0202);
        this.S = new occ2f8dff8d8(this.\u01a8, "Not moving forward", false);
        this.\u028c(this.S);
        this.\u0275 = new oc163a7c5afc(this);
        this.\u050e();
        this.\u026e = true;
    }

    @Override
    public void onEnable() {
        this.y();
    }

    @Override
    public void onDisable() {
        block5: {
            block4: {
                int n = oc84f20a0bc5.\u0117;
                oc02ef9f5e73 oc02ef9f5e732 = this;
                if (n != 0) break block4;
                if (oc02ef9f5e732.\u04c9 == null) break block5;
                this.\u04c9.\u00d1();
                oc02ef9f5e732 = this;
            }
            oc02ef9f5e732.\u04c9 = null;
        }
    }

    @Override
    public void z$2u87utkr1isxg() {
        this.y();
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        if (oca9cc61aada2 == this.\u0580) {
            this.y();
        }
    }

    @Override
    public void z$3tl278wzjcayb(N n) {
        if (n == this.\u0580) {
            this.y();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195
    public void \u03ea(oc86de9e2892 oc86de9e28922) {
        float f;
        oc1ee7f471be oc1ee7f471be2;
        float f2;
        block61: {
            block59: {
                oc86de9e2892 oc86de9e28923;
                block58: {
                    float f3;
                    int n;
                    block60: {
                        block57: {
                            oc86de9e2892 oc86de9e28924;
                            block56: {
                                block55: {
                                    int n2;
                                    block54: {
                                        block53: {
                                            occ2f8dff8d8 occ2f8dff8d82;
                                            block51: {
                                                block52: {
                                                    boolean bl;
                                                    block49: {
                                                        block50: {
                                                            ItemStack itemStack;
                                                            block48: {
                                                                block47: {
                                                                    oc8edd24b1ed oc8edd24b1ed2;
                                                                    block46: {
                                                                        Minecraft minecraft;
                                                                        block45: {
                                                                            block44: {
                                                                                n = oc84f20a0bc5.\u0117;
                                                                                ocd199f3873b ocd199f3873b2 = this.\u038c();
                                                                                if (n != 0) return;
                                                                                if (ocd199f3873b2 == null) break block44;
                                                                                ocd199f3873b2.\u02a7(oc86de9e28922);
                                                                                return;
                                                                            }
                                                                            if (!oc7ab2161b9f.\u00d0()) return;
                                                                            minecraft = oc69da1aa7f5.\u0151;
                                                                            if (n != 0) break block45;
                                                                            if (minecraft.currentScreen != null) return;
                                                                            minecraft = oc69da1aa7f5.\u0151;
                                                                        }
                                                                        if (minecraft.thePlayer.capabilities.isFlying) {
                                                                            return;
                                                                        }
                                                                        oc8edd24b1ed2 = oc9755810e45.\u03d4;
                                                                        if (n != 0) break block46;
                                                                        if (oc8edd24b1ed2 == null) break block47;
                                                                        oc8edd24b1ed2 = oc9755810e45.\u03d4;
                                                                    }
                                                                    if (oc8edd24b1ed2.\u03c6()) {
                                                                        return;
                                                                    }
                                                                }
                                                                ItemStack itemStack2 = oc69da1aa7f5.\u0151.thePlayer.getHeldItem();
                                                                itemStack = itemStack2;
                                                                if (n != 0) break block48;
                                                                if (itemStack == null) return;
                                                                itemStack = itemStack2;
                                                            }
                                                            bl = itemStack.getItem() instanceof ItemBlock;
                                                            if (n != 0) break block49;
                                                            if (bl) break block50;
                                                            return;
                                                        }
                                                        occ2f8dff8d82 = this.\u0202;
                                                        if (n != 0) break block51;
                                                        bl = occ2f8dff8d82.\u01ed();
                                                    }
                                                    if (!bl) break block52;
                                                    float f4 = oc69da1aa7f5.\u0151.thePlayer.rotationPitch - 70.0f;
                                                    n2 = f4 == 0.0f ? 0 : (f4 < 0.0f ? -1 : 1);
                                                    if (n != 0) break block53;
                                                    if (n2 >= 0) break block52;
                                                    return;
                                                }
                                                occ2f8dff8d82 = this.S;
                                            }
                                            n2 = occ2f8dff8d82.\u01ed();
                                        }
                                        if (n != 0) break block54;
                                        if (n2 == 0) break block55;
                                        float f5 = oc69da1aa7f5.\u0151.thePlayer.movementInput.moveForward - 0.0f;
                                        n2 = f5 == 0.0f ? 0 : (f5 > 0.0f ? 1 : -1);
                                    }
                                    if (n2 > 0) {
                                        return;
                                    }
                                }
                                oc86de9e28924 = oc86de9e28922;
                                if (n != 0) break block56;
                                if (oc86de9e28924.\u0177 == null) break block57;
                                oc86de9e28924 = oc86de9e28922;
                            }
                            f3 = oc86de9e28924.\u0177.floatValue();
                            break block60;
                        }
                        f3 = oc75d51ec7eb.d[1];
                    }
                    f2 = f3;
                    double d = oc69da1aa7f5.\u0151.playerController.getBlockReachDistance();
                    oc1ee7f471be2 = this.\u04dc(f2, d);
                    if (oc1ee7f471be2 == null) {
                        return;
                    }
                    oc86de9e28923 = oc86de9e28922;
                    if (n != 0) break block58;
                    if (oc86de9e28923.\u04dc == null) break block59;
                    oc86de9e28923 = oc86de9e28922;
                }
                f = oc86de9e28923.\u04dc.floatValue();
                break block61;
            }
            f = oc75d51ec7eb.d[0];
        }
        float f6 = f;
        float[] fArray = oc75d51ec7eb.\u0139(f6, f2, oc1ee7f471be2.\u050e, oc1ee7f471be2.\u04fa, 0xFF9DB4A0 ^ 0xFF9DB4AF, 20.0f);
        oc86de9e28922.t(Float.valueOf(fArray[0]));
        oc86de9e28922.U(Float.valueOf(fArray[1]));
    }

    @oc66fa4f2195
    public void \u0291(oc2f61de30bc oc2f61de30bc2) {
        block3: {
            ocd199f3873b ocd199f3873b2;
            block2: {
                ocd199f3873b ocd199f3873b3 = this.\u038c();
                int n = oc84f20a0bc5.\u0117;
                ocd199f3873b2 = ocd199f3873b3;
                if (n != 0) break block2;
                if (ocd199f3873b2 == null) break block3;
                ocd199f3873b2 = ocd199f3873b3;
            }
            ocd199f3873b2.\u03c0(oc2f61de30bc2);
        }
    }

    @oc66fa4f2195
    public void \u050d(oc52918cda9d oc52918cda9d2) {
        block3: {
            ocd199f3873b ocd199f3873b2;
            block2: {
                ocd199f3873b ocd199f3873b3 = this.\u038c();
                int n = oc84f20a0bc5.\u0117;
                ocd199f3873b2 = ocd199f3873b3;
                if (n != 0) break block2;
                if (ocd199f3873b2 == null) break block3;
                ocd199f3873b2 = ocd199f3873b3;
            }
            ocd199f3873b2.\u027f(oc52918cda9d2);
        }
    }

    @oc66fa4f2195
    public void \u01a5(oc25aa89b91f oc25aa89b91f2) {
        block3: {
            ocd199f3873b ocd199f3873b2;
            block2: {
                ocd199f3873b ocd199f3873b3 = this.\u038c();
                int n = oc84f20a0bc5.\u0117;
                ocd199f3873b2 = ocd199f3873b3;
                if (n != 0) break block2;
                if (ocd199f3873b2 == null) break block3;
                ocd199f3873b2 = ocd199f3873b3;
            }
            ocd199f3873b2.\u0209(oc25aa89b91f2);
        }
    }

    @oc66fa4f2195
    public void \u0526(oc0e4b758d9a oc0e4b758d9a2) {
        block3: {
            ocd199f3873b ocd199f3873b2;
            block2: {
                ocd199f3873b ocd199f3873b3 = this.\u038c();
                int n = oc84f20a0bc5.\u0117;
                ocd199f3873b2 = ocd199f3873b3;
                if (n != 0) break block2;
                if (ocd199f3873b2 == null) break block3;
                ocd199f3873b2 = ocd199f3873b3;
            }
            ocd199f3873b2.\u03d1(oc0e4b758d9a2);
        }
    }

    @oc66fa4f2195
    public void \u0168(oc9d4393f3ce oc9d4393f3ce2) {
        block3: {
            ocd199f3873b ocd199f3873b2;
            block2: {
                ocd199f3873b ocd199f3873b3 = this.\u038c();
                int n = oc84f20a0bc5.\u0117;
                ocd199f3873b2 = ocd199f3873b3;
                if (n != 0) break block2;
                if (ocd199f3873b2 == null) break block3;
                ocd199f3873b2 = ocd199f3873b3;
            }
            ocd199f3873b2.\u0498(oc9d4393f3ce2);
        }
    }

    @oc66fa4f2195
    public void \u0287(oce79181588d oce79181588d2) {
        block3: {
            ocd199f3873b ocd199f3873b2;
            block2: {
                ocd199f3873b ocd199f3873b3 = this.\u038c();
                int n = oc84f20a0bc5.\u0117;
                ocd199f3873b2 = ocd199f3873b3;
                if (n != 0) break block2;
                if (ocd199f3873b2 == null) break block3;
                ocd199f3873b2 = ocd199f3873b3;
            }
            ocd199f3873b2.\u010b(oce79181588d2);
        }
    }

    @oc66fa4f2195
    public void \u04b9(oc746a23b244 oc746a23b2442) {
        block3: {
            ocd199f3873b ocd199f3873b2;
            block2: {
                ocd199f3873b ocd199f3873b3 = this.\u038c();
                int n = oc84f20a0bc5.\u0117;
                ocd199f3873b2 = ocd199f3873b3;
                if (n != 0) break block2;
                if (ocd199f3873b2 == null) break block3;
                ocd199f3873b2 = ocd199f3873b3;
            }
            ocd199f3873b2.\u045e(oc746a23b2442);
        }
    }

    @oc66fa4f2195
    public void \u0250(ocf923d5a814 ocf923d5a8142) {
        block3: {
            ocd199f3873b ocd199f3873b2;
            block2: {
                ocd199f3873b ocd199f3873b3 = this.\u038c();
                int n = oc84f20a0bc5.\u0117;
                ocd199f3873b2 = ocd199f3873b3;
                if (n != 0) break block2;
                if (ocd199f3873b2 == null) break block3;
                ocd199f3873b2 = ocd199f3873b3;
            }
            ocd199f3873b2.\u0145(ocf923d5a8142);
        }
    }

    @oc66fa4f2195
    public void \u00ba(ocadfd5cc157 ocadfd5cc1572) {
        block3: {
            ocd199f3873b ocd199f3873b2;
            block2: {
                ocd199f3873b ocd199f3873b3 = this.\u038c();
                int n = oc84f20a0bc5.\u0117;
                ocd199f3873b2 = ocd199f3873b3;
                if (n != 0) break block2;
                if (ocd199f3873b2 == null) break block3;
                ocd199f3873b2 = ocd199f3873b3;
            }
            ocd199f3873b2.\u0238(ocadfd5cc1572);
        }
    }

    @oc66fa4f2195
    public void \u00c6(MouseEvent mouseEvent) {
        block3: {
            ocd199f3873b ocd199f3873b2;
            block2: {
                ocd199f3873b ocd199f3873b3 = this.\u038c();
                int n = oc84f20a0bc5.\u0117;
                ocd199f3873b2 = ocd199f3873b3;
                if (n != 0) break block2;
                if (ocd199f3873b2 == null) break block3;
                ocd199f3873b2 = ocd199f3873b3;
            }
            ocd199f3873b2.\u0297(mouseEvent);
        }
    }

    private ocd199f3873b \u038c() {
        this.y();
        return this.\u04c9;
    }

    private void y() {
        block22: {
            oc02ef9f5e73 oc02ef9f5e732;
            block23: {
                int n;
                block21: {
                    oc02ef9f5e73 oc02ef9f5e733;
                    block20: {
                        ocd199f3873b ocd199f3873b2;
                        oc163a7c5afc oc163a7c5afc2;
                        block18: {
                            block19: {
                                this.\u050e();
                                oc163a7c5afc2 = null;
                                int n2 = (int)this.\u0580.\u04c1();
                                n = oc84f20a0bc5.\u0117;
                                if (n2 == 1) {
                                    oc163a7c5afc2 = this.\u0275;
                                }
                                ocd199f3873b2 = oc163a7c5afc2;
                                if (n != 0) break block18;
                                if (ocd199f3873b2 != this.\u04c9) break block19;
                                return;
                            }
                            oc02ef9f5e733 = this;
                            if (n != 0) break block20;
                            ocd199f3873b2 = oc02ef9f5e733.\u04c9;
                        }
                        if (ocd199f3873b2 != null) {
                            this.\u04c9.\u00d1();
                        }
                        oc02ef9f5e732 = this;
                        if (n != 0) break block21;
                        oc02ef9f5e732.\u04c9 = oc163a7c5afc2;
                        oc02ef9f5e733 = this;
                    }
                    if (oc02ef9f5e733.\u04c9 == null) break block22;
                    oc02ef9f5e732 = this;
                }
                if (n != 0) break block23;
                if (!oc02ef9f5e732.z$3rzb3dil7uydr()) break block22;
                oc02ef9f5e732 = this;
            }
            oc02ef9f5e732.\u04c9.\u01ef();
        }
    }

    private void \u050e() {
        int n;
        oc163a7c5afc oc163a7c5afc2;
        int n2;
        block14: {
            block15: {
                int n3;
                int n4;
                block12: {
                    block13: {
                        block10: {
                            block11: {
                                n2 = (int)this.\u0580.\u04c1();
                                n4 = oc84f20a0bc5.\u0117;
                                n3 = n2;
                                if (n4 != 0) break block10;
                                if (n3 != this.\u03df) break block11;
                                return;
                            }
                            n3 = n2;
                        }
                        if (n4 != 0) break block12;
                        if (n3 != 0) break block13;
                        n3 = 1;
                        break block12;
                    }
                    n3 = 0;
                }
                int n5 = n3;
                this.\u0202.\u04c0 = n5;
                this.S.\u04c0 = n5;
                this.\u01a8.\u0209(n5 != 0, this);
                oc163a7c5afc2 = this.\u0275;
                n = n2;
                if (n4 != 0) break block14;
                if (n != 1) break block15;
                n = 1;
                break block14;
            }
            n = 0;
        }
        oc163a7c5afc2.\u019b(n != 0);
        this.\u03df = n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private oc1ee7f471be \u04dc(float f, double d) {
        float f2;
        float f3;
        Object object;
        BlockPos blockPos;
        float f4;
        block36: {
            float f5;
            ArrayList<oc4dc4dd9f31> arrayList;
            int n;
            block34: {
                f4 = oc69da1aa7f5.\u0151.thePlayer.rotationYaw;
                AxisAlignedBB axisAlignedBB = oc69da1aa7f5.\u0151.thePlayer.getEntityBoundingBox();
                int n2 = MathHelper.floor_double(axisAlignedBB.minY) - 1;
                int n3 = MathHelper.floor_double(axisAlignedBB.minX);
                int n4 = MathHelper.floor_double(axisAlignedBB.maxX);
                int n5 = MathHelper.floor_double(axisAlignedBB.minZ);
                n = oc84f20a0bc5.\u0117;
                int n6 = MathHelper.floor_double(axisAlignedBB.maxZ);
                arrayList = new ArrayList<oc4dc4dd9f31>();
                int n7 = n3;
                while (n7 <= n4) {
                    block35: {
                        if (n != 0) break block34;
                        int n8 = n5;
                        while (n8 <= n6) {
                            blockPos = new BlockPos(n7, n2, n8);
                            if (n == 0) {
                                if (!occb1ed1ed8f.\u024d(blockPos)) {
                                    object = \u04f9;
                                    int n9 = ((EnumFacing[])object).length;
                                    int n10 = 0;
                                    while (n10 < n9) {
                                        EnumFacing enumFacing = object[n10];
                                        if (n == 0) {
                                            if (n == 0) {
                                                if (occb1ed1ed8f.\u024d(blockPos.offset(enumFacing))) {
                                                    arrayList.add(new oc4dc4dd9f31(blockPos, enumFacing));
                                                }
                                                ++n10;
                                            }
                                            if (n == 0) continue;
                                        }
                                        break;
                                    }
                                } else {
                                    ++n8;
                                }
                                if (n == 0) continue;
                            }
                            break block35;
                        }
                        ++n7;
                    }
                    if (n == 0) continue;
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
            }
            float f6 = Float.MAX_VALUE;
            f3 = Float.NaN;
            blockPos = null;
            object = null;
            float f7 = 0.2f;
            for (float f8 = 60.0f; f8 <= 90.0f; f8 += Math.max(0.4f, Math.min(1.8f, f5))) {
                float f9;
                float f10;
                block37: {
                    MovingObjectPosition movingObjectPosition;
                    f2 = Math.min(f8, 90.0f);
                    if (n != 0) break block36;
                    float f11 = f2;
                    MovingObjectPosition movingObjectPosition2 = movingObjectPosition = oc75d51ec7eb.\u046d(d, f4, f11);
                    block19: while (true) {
                        if (n == 0) {
                            if (movingObjectPosition2 == null) break;
                            movingObjectPosition2 = movingObjectPosition;
                        }
                        EnumFacing enumFacing = movingObjectPosition2.sideHit;
                        if (n == 0) {
                            if (enumFacing == EnumFacing.UP) break;
                            enumFacing = movingObjectPosition.sideHit;
                        }
                        if (enumFacing == EnumFacing.DOWN) break;
                        for (oc4dc4dd9f31 oc4dc4dd9f312 : arrayList) {
                            block39: {
                                MovingObjectPosition movingObjectPosition3;
                                block38: {
                                    MovingObjectPosition movingObjectPosition4 = movingObjectPosition;
                                    if (n != 0) continue block19;
                                    if (n != 0) break block38;
                                    if (!movingObjectPosition4.getBlockPos().equals(oc4dc4dd9f312.\u016c)) break block39;
                                    movingObjectPosition3 = movingObjectPosition;
                                }
                                if (movingObjectPosition3.sideHit == oc4dc4dd9f312.J) {
                                    f10 = f11;
                                    f9 = f;
                                    if (n == 0) {
                                        float f12 = Math.abs(f10 - f9);
                                        if (!(f12 < f6)) break block19;
                                        f6 = f12;
                                        f3 = f11;
                                        blockPos = oc4dc4dd9f312.\u016c;
                                        object = oc4dc4dd9f312.J;
                                        if (n == 0) break block19;
                                    }
                                    break block37;
                                }
                            }
                            if (n == 0) continue;
                        }
                        break;
                    }
                    f10 = 1.0f;
                    f9 = (float)(Math.random() * 2.0 - 1.0) * (0.3f + f7 * 0.4f);
                }
                f5 = f10 + f9;
                if (n == 0) continue;
            }
            if (blockPos == null) return null;
            if (object == null) return null;
            f2 = f3;
        }
        if (Float.isNaN(f2)) return null;
        oc1ee7f471be oc1ee7f471be2 = new oc1ee7f471be(f4, f3, blockPos, (EnumFacing)object);
        return oc1ee7f471be2;
    }

    static {
        String[] stringArray = new String[0x2E66F13D ^ 0x2E66F13F];
        stringArray[0] = "Silent";
        stringArray[1] = "Telly";
        C = stringArray;
        EnumFacing[] enumFacingArray = new EnumFacing[0x2E66F13B ^ 0x2E66F13F];
        enumFacingArray[0] = EnumFacing.NORTH;
        enumFacingArray[1] = EnumFacing.SOUTH;
        enumFacingArray[0x2E66F13D ^ 0x2E66F13F] = EnumFacing.EAST;
        enumFacingArray[0x2E66F13C ^ 0x2E66F13F] = EnumFacing.WEST;
        \u04f9 = enumFacingArray;
    }
}

