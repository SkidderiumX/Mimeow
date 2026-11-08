/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.client.C01PacketChatMessage;
import x.ocb5eb238adf;
import x.occ0b63c0426;

public class oc71be897b21
extends ocb5eb238adf {
    public String \u0141;
    public static int \u0240;

    public oc71be897b21(String string) {
        this(new C01PacketChatMessage(string));
    }

    public oc71be897b21(C01PacketChatMessage c01PacketChatMessage) {
        super(c01PacketChatMessage);
        this.\u0141 = c01PacketChatMessage == null ? null : c01PacketChatMessage.getMessage();
    }

    public C01PacketChatMessage z$3uoime2rixgf9() {
        C01PacketChatMessage c01PacketChatMessage;
        block6: {
            block5: {
                oc71be897b21 oc71be897b212;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc71be897b212 = this;
                    if (n != 0) break block4;
                    if (!(oc71be897b212.\u03e3 instanceof C01PacketChatMessage)) break block5;
                    oc71be897b212 = this;
                }
                c01PacketChatMessage = (C01PacketChatMessage)oc71be897b212.\u03e3;
                break block6;
            }
            c01PacketChatMessage = null;
        }
        return c01PacketChatMessage;
    }
}

