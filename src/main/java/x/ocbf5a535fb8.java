/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import x.occ0b63c0426;

public class ocbf5a535fb8 {
    public double \u03ba;
    public double \u0418;
    public double \u03e0;
    public static int \u0498;

    public ocbf5a535fb8(double d, double d2, double d3) {
        this.\u03ba = d;
        this.\u0418 = d2;
        this.\u03e0 = d3;
    }

    public ocbf5a535fb8(Vec3 vec3) {
        this(vec3 == null ? 0.0 : vec3.xCoord, vec3 == null ? 0.0 : vec3.yCoord, vec3 == null ? 0.0 : vec3.zCoord);
    }

    public ocbf5a535fb8(BlockPos blockPos) {
        this(blockPos == null ? 0.0 : (double)blockPos.getX(), blockPos == null ? 0.0 : (double)blockPos.getY(), blockPos == null ? 0.0 : (double)blockPos.getZ());
    }

    public ocbf5a535fb8 \u0538(double d, double d2, double d3) {
        return new ocbf5a535fb8(this.\u03ba + d, this.\u0418 + d2, this.\u03e0 + d3);
    }

    public double \u043a(ocbf5a535fb8 ocbf5a535fb82) {
        double d;
        block6: {
            ocbf5a535fb8 ocbf5a535fb83;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    ocbf5a535fb83 = ocbf5a535fb82;
                    if (n != 0) break block4;
                    if (ocbf5a535fb83 != null) break block5;
                    d = Double.POSITIVE_INFINITY;
                    break block6;
                }
                ocbf5a535fb83 = this;
            }
            d = Math.sqrt(ocbf5a535fb83.\u00e8(ocbf5a535fb82));
        }
        return d;
    }

    public double \u00e8(ocbf5a535fb8 ocbf5a535fb82) {
        ocbf5a535fb8 ocbf5a535fb83;
        block4: {
            block5: {
                int n = occ0b63c0426.\u039f;
                ocbf5a535fb83 = ocbf5a535fb82;
                if (n != 0) break block4;
                if (ocbf5a535fb83 != null) break block5;
                return Double.POSITIVE_INFINITY;
            }
            ocbf5a535fb83 = this;
        }
        double d = ocbf5a535fb83.\u03ba - ocbf5a535fb82.\u03ba;
        double d2 = this.\u0418 - ocbf5a535fb82.\u0418;
        double d3 = this.\u03e0 - ocbf5a535fb82.\u03e0;
        return d * d + d2 * d2 + d3 * d3;
    }

    Vec3 \u0459() {
        return new Vec3(this.\u03ba, this.\u0418, this.\u03e0);
    }

    public static ocbf5a535fb8 \u00c9(Vec3 vec3) {
        ocbf5a535fb8 ocbf5a535fb82 = vec3 == null ? null : new ocbf5a535fb8(vec3.xCoord, vec3.yCoord, vec3.zCoord);
        return ocbf5a535fb82;
    }

    public static ocbf5a535fb8 \u03e1(BlockPos blockPos) {
        ocbf5a535fb8 ocbf5a535fb82 = blockPos == null ? null : new ocbf5a535fb8(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        return ocbf5a535fb82;
    }

    public static ocbf5a535fb8 \u00e8(BlockPos blockPos) {
        return ocbf5a535fb8.\u03e1(blockPos);
    }

    public static BlockPos \u020e(ocbf5a535fb8 ocbf5a535fb82) {
        BlockPos blockPos = ocbf5a535fb82 == null ? null : new BlockPos(ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0);
        return blockPos;
    }

    public static Vec3 \u03e8(ocbf5a535fb8 ocbf5a535fb82) {
        Vec3 vec3;
        block6: {
            ocbf5a535fb8 ocbf5a535fb83;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    ocbf5a535fb83 = ocbf5a535fb82;
                    if (n != 0) break block4;
                    if (ocbf5a535fb83 != null) break block5;
                    vec3 = null;
                    break block6;
                }
                ocbf5a535fb83 = ocbf5a535fb82;
            }
            vec3 = ocbf5a535fb83.\u0459();
        }
        return vec3;
    }

    public ocbf5a535fb8 \u0396(ocbf5a535fb8 ocbf5a535fb82) {
        ocbf5a535fb8 ocbf5a535fb83;
        block6: {
            ocbf5a535fb8 ocbf5a535fb84;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    ocbf5a535fb84 = ocbf5a535fb82;
                    if (n != 0) break block4;
                    if (ocbf5a535fb84 != null) break block5;
                    ocbf5a535fb83 = this;
                    break block6;
                }
                ocbf5a535fb84 = this;
            }
            ocbf5a535fb83 = ocbf5a535fb84.\u0538(ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0);
        }
        return ocbf5a535fb83;
    }

    public ocbf5a535fb8 \u03fb(ocbf5a535fb8 ocbf5a535fb82) {
        return this.\u0396(ocbf5a535fb82);
    }

    public ocbf5a535fb8 \u012d(double d, double d2, double d3) {
        return this.\u0538(d, d2, d3);
    }

    public double \u054a() {
        return this.\u03ba;
    }

    public double \u04a2() {
        return this.\u0418;
    }

    public double \u0241() {
        return this.\u03e0;
    }

    public boolean \u0490(ocbf5a535fb8 ocbf5a535fb82) {
        boolean bl;
        block16: {
            block13: {
                ocbf5a535fb8 ocbf5a535fb83;
                int n;
                block15: {
                    ocbf5a535fb8 ocbf5a535fb84;
                    double d;
                    block14: {
                        ocbf5a535fb8 ocbf5a535fb85;
                        block12: {
                            n = occ0b63c0426.\u039f;
                            ocbf5a535fb85 = ocbf5a535fb82;
                            if (n != 0) break block12;
                            if (ocbf5a535fb85 == null) break block13;
                            ocbf5a535fb85 = this;
                        }
                        d = ocbf5a535fb85.\u03ba;
                        ocbf5a535fb84 = ocbf5a535fb82;
                        if (n != 0) break block14;
                        if (d != ocbf5a535fb84.\u03ba) break block13;
                        ocbf5a535fb83 = this;
                        if (n != 0) break block15;
                        d = ocbf5a535fb83.\u0418;
                        ocbf5a535fb84 = ocbf5a535fb82;
                    }
                    if (d != ocbf5a535fb84.\u0418) break block13;
                    ocbf5a535fb83 = this;
                }
                double d = ocbf5a535fb83.\u03e0 - ocbf5a535fb82.\u03e0;
                bl = d == 0.0 ? 0 : (d > 0.0 ? 1 : -1);
                if (n != 0) break block16;
                if (bl) break block13;
                bl = true;
                break block16;
            }
            bl = false;
        }
        return bl;
    }

    public ocbf5a535fb8 \u01e9() {
        return new ocbf5a535fb8(Math.floor(this.\u03ba), Math.floor(this.\u0418), Math.floor(this.\u03e0));
    }

    public ocbf5a535fb8 \u04c6() {
        return new ocbf5a535fb8(Math.ceil(this.\u03ba), Math.ceil(this.\u0418), Math.ceil(this.\u03e0));
    }

    public ocbf5a535fb8 \u049c() {
        return new ocbf5a535fb8(-this.\u03ba, -this.\u0418, -this.\u03e0);
    }

    public boolean equals(Object object) {
        int n;
        block19: {
            block17: {
                ocbf5a535fb8 ocbf5a535fb82;
                ocbf5a535fb8 ocbf5a535fb83;
                int n2;
                block18: {
                    ocbf5a535fb8 ocbf5a535fb84;
                    double d;
                    block16: {
                        Object object2;
                        block14: {
                            block15: {
                                n2 = occ0b63c0426.\u039f;
                                object2 = object;
                                if (n2 != 0) break block14;
                                if (object2 instanceof ocbf5a535fb8) break block15;
                                return false;
                            }
                            object2 = object;
                        }
                        ocbf5a535fb83 = (ocbf5a535fb8)object2;
                        d = this.\u03ba;
                        ocbf5a535fb84 = ocbf5a535fb83;
                        if (n2 != 0) break block16;
                        if (Double.compare(d, ocbf5a535fb84.\u03ba) != 0) break block17;
                        ocbf5a535fb82 = this;
                        if (n2 != 0) break block18;
                        d = ocbf5a535fb82.\u0418;
                        ocbf5a535fb84 = ocbf5a535fb83;
                    }
                    if (Double.compare(d, ocbf5a535fb84.\u0418) != 0) break block17;
                    ocbf5a535fb82 = this;
                }
                n = Double.compare(ocbf5a535fb82.\u03e0, ocbf5a535fb83.\u03e0);
                if (n2 != 0) break block19;
                if (n != 0) break block17;
                n = 1;
                break block19;
            }
            n = 0;
        }
        return n != 0;
    }

    public int hashCode() {
        long l = Double.doubleToLongBits(this.\u03ba);
        l = (0x2A3BCA8DA829475FL ^ 0x2A3BCA8DA8294740L) * l + Double.doubleToLongBits(this.\u0418);
        l = (0x2A3BCA8DA829475FL ^ 0x2A3BCA8DA8294740L) * l + Double.doubleToLongBits(this.\u03e0);
        return (int)(l ^ l >>> (0x863D2409 ^ 0x863D2429));
    }

    public String toString() {
        double d = this.\u03e0;
        double d2 = this.\u0418;
        double d3 = this.\u03ba;
        return "Vec3{" + d3 + ", " + d2 + ", " + d + "}";
    }
}

