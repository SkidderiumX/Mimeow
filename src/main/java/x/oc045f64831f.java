/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Locale;
import net.minecraft.network.play.client.C16PacketClientStatus;
import x.ocb5eb238adf;
import x.occ0b63c0426;

public class oc045f64831f
extends ocb5eb238adf {
    public String \u0114;
    public static boolean \u019a;

    public oc045f64831f(String string) {
        this(new C16PacketClientStatus(oc045f64831f.\u0101(string)));
    }

    public oc045f64831f(C16PacketClientStatus c16PacketClientStatus) {
        super(c16PacketClientStatus);
        this.\u0114 = c16PacketClientStatus == null || c16PacketClientStatus.getStatus() == null ? null : c16PacketClientStatus.getStatus().name();
    }

    public C16PacketClientStatus z$3uoime2rixgf9() {
        C16PacketClientStatus c16PacketClientStatus;
        block6: {
            block5: {
                oc045f64831f oc045f64831f2;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc045f64831f2 = this;
                    if (n != 0) break block4;
                    if (!(oc045f64831f2.\u03e3 instanceof C16PacketClientStatus)) break block5;
                    oc045f64831f2 = this;
                }
                c16PacketClientStatus = (C16PacketClientStatus)oc045f64831f2.\u03e3;
                break block6;
            }
            c16PacketClientStatus = null;
        }
        return c16PacketClientStatus;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static C16PacketClientStatus.EnumState \u0101(String string) {
        int n = occ0b63c0426.\u039f;
        try {
            String string2;
            String string3 = string;
            if (n == 0) {
                if (string3 == null) {
                    string2 = "REQUEST_STATS";
                    return C16PacketClientStatus.EnumState.valueOf(string2);
                }
                string3 = string;
            }
            string2 = string3.toUpperCase(Locale.ROOT);
            return C16PacketClientStatus.EnumState.valueOf(string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return C16PacketClientStatus.EnumState.REQUEST_STATS;
        }
    }
}

