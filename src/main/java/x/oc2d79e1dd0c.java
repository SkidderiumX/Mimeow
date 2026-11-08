/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Set;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import x.oc053077e19a;
import x.ocbf5a535fb8;

public class oc2d79e1dd0c
extends oc053077e19a {
    public ocbf5a535fb8 \u0118;
    public float \u037d;
    public float \u03e9;
    public Set<String> \u03de;
    public static boolean \u00fb;

    public oc2d79e1dd0c(S08PacketPlayerPosLook s08PacketPlayerPosLook) {
        super(s08PacketPlayerPosLook);
    }

    public oc2d79e1dd0c(ocbf5a535fb8 ocbf5a535fb82, float f, float f2, Set<String> set) {
        super(null);
        this.\u0118 = ocbf5a535fb82;
        this.\u037d = f;
        this.\u03e9 = f2;
        this.\u03de = set;
    }
}

