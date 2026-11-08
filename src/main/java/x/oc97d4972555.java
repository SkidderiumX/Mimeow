/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Collection;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S3EPacketTeams;
import x.oc053077e19a;

public class oc97d4972555
extends oc053077e19a {
    public String \u0243;
    public String \u0228;
    public String \u01e5;
    public String \u0479;
    public String \u0175;
    public Collection<String> \u0138;
    public int \u0231;
    public int \u011a;
    public int \u02e3;
    public static int \u0585;

    public oc97d4972555(S3EPacketTeams s3EPacketTeams) {
        super(s3EPacketTeams);
    }

    public oc97d4972555(Packet<?> packet, String string, String string2, String string3, String string4, String string5, Collection<String> collection, int n, int n2, int n3) {
        super(packet);
        this.\u0243 = string;
        this.\u0228 = string2;
        this.\u01e5 = string3;
        this.\u0479 = string4;
        this.\u0175 = string5;
        this.\u0138 = collection;
        this.\u0231 = n;
        this.\u011a = n2;
        this.\u02e3 = n3;
    }
}

