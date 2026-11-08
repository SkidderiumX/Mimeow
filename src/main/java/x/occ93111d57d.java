/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Locale;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import x.ocb5eb238adf;
import x.ocbf5a535fb8;
import x.occ0b63c0426;

public class occ93111d57d
extends ocb5eb238adf {
    public final String \u048f;
    public final ocbf5a535fb8 \u011a;
    public static boolean \u0166;

    public occ93111d57d(ocbf5a535fb8 ocbf5a535fb82, String string, String string2) {
        this(new C07PacketPlayerDigging(occ93111d57d.\u0403(string), ocbf5a535fb82 == null ? BlockPos.ORIGIN : ocbf5a535fb8.\u020e(ocbf5a535fb82), occ93111d57d.\u0188(string2)));
    }

    public occ93111d57d(C07PacketPlayerDigging c07PacketPlayerDigging) {
        super(c07PacketPlayerDigging);
        this.\u048f = c07PacketPlayerDigging.getStatus() == null ? null : c07PacketPlayerDigging.getStatus().name();
        this.\u011a = ocbf5a535fb8.\u03e1(c07PacketPlayerDigging.getPosition());
    }

    public C07PacketPlayerDigging z$3uoime2rixgf9() {
        C07PacketPlayerDigging c07PacketPlayerDigging;
        block6: {
            block5: {
                occ93111d57d occ93111d57d2;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    occ93111d57d2 = this;
                    if (n != 0) break block4;
                    if (!(occ93111d57d2.\u03e3 instanceof C07PacketPlayerDigging)) break block5;
                    occ93111d57d2 = this;
                }
                c07PacketPlayerDigging = (C07PacketPlayerDigging)occ93111d57d2.\u03e3;
                break block6;
            }
            c07PacketPlayerDigging = null;
        }
        return c07PacketPlayerDigging;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static C07PacketPlayerDigging.Action \u0403(String string) {
        int n = occ0b63c0426.\u039f;
        try {
            String string2;
            String string3 = string;
            if (n == 0) {
                if (string3 == null) {
                    string2 = "RELEASE_USE_ITEM";
                    return C07PacketPlayerDigging.Action.valueOf(string2);
                }
                string3 = string;
            }
            string2 = string3.toUpperCase(Locale.ROOT);
            return C07PacketPlayerDigging.Action.valueOf(string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return C07PacketPlayerDigging.Action.RELEASE_USE_ITEM;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static EnumFacing \u0188(String string) {
        int n = occ0b63c0426.\u039f;
        try {
            String string2;
            String string3 = string;
            if (n == 0) {
                if (string3 == null) {
                    string2 = "DOWN";
                    return EnumFacing.valueOf(string2);
                }
                string3 = string;
            }
            string2 = string3.toUpperCase(Locale.ROOT);
            return EnumFacing.valueOf(string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return EnumFacing.DOWN;
        }
    }
}

