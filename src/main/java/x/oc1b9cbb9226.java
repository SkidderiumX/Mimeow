/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import x.ocb5eb238adf;
import x.occ0b63c0426;

public class oc1b9cbb9226
extends ocb5eb238adf {
    public final String \u0411;
    public int \u0545;
    public static int \u010f;

    public oc1b9cbb9226(String string, int n) {
        this(Minecraft.getMinecraft().thePlayer == null ? null : new C0BPacketEntityAction(Minecraft.getMinecraft().thePlayer, oc1b9cbb9226.\u017f(string), n));
    }

    public oc1b9cbb9226(C0BPacketEntityAction c0BPacketEntityAction) {
        super(c0BPacketEntityAction);
        this.\u0411 = c0BPacketEntityAction.getAction() == null ? null : c0BPacketEntityAction.getAction().name();
    }

    public C0BPacketEntityAction z$3uoime2rixgf9() {
        C0BPacketEntityAction c0BPacketEntityAction;
        block6: {
            block5: {
                oc1b9cbb9226 oc1b9cbb92262;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc1b9cbb92262 = this;
                    if (n != 0) break block4;
                    if (!(oc1b9cbb92262.\u03e3 instanceof C0BPacketEntityAction)) break block5;
                    oc1b9cbb92262 = this;
                }
                c0BPacketEntityAction = (C0BPacketEntityAction)oc1b9cbb92262.\u03e3;
                break block6;
            }
            c0BPacketEntityAction = null;
        }
        return c0BPacketEntityAction;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static C0BPacketEntityAction.Action \u017f(String string) {
        int n = occ0b63c0426.\u039f;
        try {
            String string2;
            String string3 = string;
            if (n == 0) {
                if (string3 == null) {
                    string2 = "START_SPRINTING";
                    return C0BPacketEntityAction.Action.valueOf(string2);
                }
                string3 = string;
            }
            string2 = string3.toUpperCase(Locale.ROOT);
            return C0BPacketEntityAction.Action.valueOf(string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return C0BPacketEntityAction.Action.START_SPRINTING;
        }
    }
}

