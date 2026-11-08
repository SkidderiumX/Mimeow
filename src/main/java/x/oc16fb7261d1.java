/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import x.oc56a1be9fc0;
import x.oc75d51ec7eb;

public class oc16fb7261d1 {
    public static final oc16fb7261d1 \u04a3 = new oc16fb7261d1(0.0, 0.0, 0.0);
    public double \u0210;
    public double \u04a1;
    public double \u04d5;
    public static int \u0152;

    public oc16fb7261d1(double d, double d2, double d3) {
        this.\u0210 = d;
        this.\u04a1 = d2;
        this.\u04d5 = d3;
    }

    public oc16fb7261d1(@NotNull Vec3 vec3) {
        this(vec3.xCoord, vec3.yCoord, vec3.zCoord);
    }

    public oc16fb7261d1(@NotNull Entity entity) {
        this(entity.posX, entity.posY, entity.posZ);
    }

    public oc16fb7261d1(@NotNull BlockPos blockPos) {
        this((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5);
    }

    public boolean \u0140(oc16fb7261d1 oc16fb7261d12) {
        boolean bl;
        block19: {
            block17: {
                oc16fb7261d1 oc16fb7261d13;
                int n;
                block18: {
                    double d;
                    block16: {
                        oc16fb7261d1 oc16fb7261d14;
                        block14: {
                            block15: {
                                n = oc75d51ec7eb.\u03e9;
                                oc16fb7261d14 = this;
                                if (n != 0) break block14;
                                if (oc16fb7261d14 != oc16fb7261d12) break block15;
                                return true;
                            }
                            oc16fb7261d14 = this;
                        }
                        d = oc16fb7261d14.\u0210;
                        if (n != 0) break block16;
                        if (d != oc16fb7261d12.\u0210) break block17;
                        oc16fb7261d13 = this;
                        if (n != 0) break block18;
                        d = oc16fb7261d13.\u04a1;
                    }
                    if (d != oc16fb7261d12.\u04a1) break block17;
                    oc16fb7261d13 = this;
                }
                double d = oc16fb7261d13.\u04d5 - oc16fb7261d12.\u04d5;
                bl = d == 0.0 ? 0 : (d > 0.0 ? 1 : -1);
                if (n != 0) break block19;
                if (bl) break block17;
                bl = true;
                break block19;
            }
            bl = false;
        }
        return bl;
    }

    public oc16fb7261d1 j(double d, double d2, double d3) {
        return new oc16fb7261d1(this.\u0210 + d, this.\u04a1 + d2, this.\u04d5 + d3);
    }

    public static oc16fb7261d1 \u03aa(BlockPos blockPos) {
        if (blockPos == null) {
            return null;
        }
        return new oc16fb7261d1(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    public double \u04ba(@NotNull oc16fb7261d1 oc16fb7261d12) {
        double d = this.\u0210 - oc16fb7261d12.\u0210;
        double d2 = this.\u04a1 - oc16fb7261d12.\u04a1;
        double d3 = this.\u04d5 - oc16fb7261d12.\u04d5;
        return MathHelper.sqrt_double(d * d + d2 * d2 + d3 * d3);
    }

    public double \u0520(@NotNull Vec3 vec3) {
        double d = this.\u0210 - vec3.xCoord;
        double d2 = this.\u04a1 - vec3.yCoord;
        double d3 = this.\u04d5 - vec3.zCoord;
        return MathHelper.sqrt_double(d * d + d2 * d2 + d3 * d3);
    }

    public double x(@NotNull Entity entity) {
        double d = this.\u0210 - entity.posX;
        double d2 = this.\u04a1 - entity.posY;
        double d3 = this.\u04d5 - entity.posZ;
        return MathHelper.sqrt_double(d * d + d2 * d2 + d3 * d3);
    }

    public double \u0523(@NotNull oc16fb7261d1 oc16fb7261d12) {
        double d = this.\u0210 - oc16fb7261d12.\u0210;
        double d2 = this.\u04a1 - oc16fb7261d12.\u04a1;
        double d3 = this.\u04d5 - oc16fb7261d12.\u04d5;
        return d * d + d2 * d2 + d3 * d3;
    }

    public double \u013b() {
        return this.\u0210;
    }

    public double \u049c() {
        return this.\u04a1;
    }

    public double \u00e5() {
        return this.\u04d5;
    }

    public oc16fb7261d1 \u010e(@NotNull oc16fb7261d1 oc16fb7261d12) {
        return this.\u0537(oc16fb7261d12.\u013b(), oc16fb7261d12.\u049c(), oc16fb7261d12.\u00e5());
    }

    public oc16fb7261d1 \u0537(double d, double d2, double d3) {
        return new oc16fb7261d1(this.\u013b() + d, this.\u049c() + d2, this.\u00e5() + d3);
    }

    public oc16fb7261d1 \u04e2(@NotNull oc16fb7261d1 oc16fb7261d12) {
        return this.\u010e(new oc16fb7261d1(-oc16fb7261d12.\u013b(), -oc16fb7261d12.\u049c(), -oc16fb7261d12.\u00e5()));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public double \u046b(@NotNull EnumFacing.Axis axis) {
        switch (oc56a1be9fc0.\u03ee[axis.ordinal()]) {
            case 1: {
                return this.\u013b();
            }
            case 2: {
                return this.\u049c();
            }
            case 3: {
                return this.\u00e5();
            }
        }
        return 0.0;
    }

    @Contract(value="-> new")
    public Vec3 Q() {
        return new Vec3(this.\u0210, this.\u04a1, this.\u04d5);
    }

    public String toString() {
        double d = this.\u04d5;
        double d2 = this.\u04a1;
        double d3 = this.\u0210;
        return "BacktrackVector{x=" + d3 + ", y=" + d2 + ", z=" + d + "}";
    }
}

