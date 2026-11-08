/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.MathHelper;
import x.oc791986a759;
import x.oc847503a8ab;
import x.oc84f20a0bc5;
import x.ocbce5ea28a3;

public class occ00ef6c188 {
    final oc847503a8ab \u0178;
    final C08PacketPlayerBlockPlacement \u03c8;
    final long \u028a;
    final boolean \u0501;
    final long \u0143;

    private occ00ef6c188(oc847503a8ab oc847503a8ab2, C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement, long l, boolean bl, long l2) {
        this.\u0178 = oc847503a8ab2;
        this.\u03c8 = c08PacketPlayerBlockPlacement;
        this.\u028a = l;
        this.\u0501 = bl;
        this.\u0143 = l2;
    }

    static occ00ef6c188 P(oc847503a8ab oc847503a8ab2, C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement, long l) {
        return new occ00ef6c188(oc847503a8ab2, c08PacketPlayerBlockPlacement, l, false, 0x9A5F773605F16E9DL ^ 0xE5A088C9FA0E9162L);
    }

    occ00ef6c188 \u053e(long l) {
        return new occ00ef6c188(this.\u0178, this.\u03c8, this.\u028a, true, l);
    }

    boolean \u057e(oc791986a759 oc791986a7592, float f) {
        float f2;
        block16: {
            block15: {
                float f3;
                float f4;
                int n;
                block14: {
                    block13: {
                        boolean bl;
                        block12: {
                            block11: {
                                oc791986a759 oc791986a7593;
                                block10: {
                                    n = oc84f20a0bc5.\u0117;
                                    oc791986a7593 = oc791986a7592;
                                    if (n != 0) break block10;
                                    if (oc791986a7593 == null) break block11;
                                    oc791986a7593 = oc791986a7592;
                                }
                                bl = oc791986a7593.\u0155;
                                if (n != 0) break block12;
                                if (bl) break block13;
                            }
                            bl = false;
                        }
                        return bl;
                    }
                    f4 = Math.max(1.0E-4f, ocbce5ea28a3.\u046b(f) * 0.51f);
                    f3 = MathHelper.wrapAngleTo180_float(oc791986a7592.\u0386 - this.\u0178.\u03a8);
                    if (n != 0) break block14;
                    if (!(Math.abs(f3) <= f4)) break block15;
                    f3 = Math.abs(oc791986a7592.\u0163 - this.\u0178.\u028c);
                }
                float f5 = f3 - f4;
                f2 = f5 == 0.0f ? 0 : (f5 < 0.0f ? -1 : 1);
                if (n != 0) break block16;
                if (f2 > 0) break block15;
                f2 = 1.0f;
                break block16;
            }
            f2 = 0.0f;
        }
        return (boolean)f2;
    }
}

