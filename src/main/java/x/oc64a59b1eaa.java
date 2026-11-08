/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc62a465bc97;
import x.oc98904eb9e7;

public class oc64a59b1eaa {
    public float \u0196;
    public double \u00d6;

    public boolean \u00d6(boolean bl, double d) {
        double d2 = (float)(d - this.\u00d6);
        if (d2 > oc98904eb9e7.\u0442(0x9B81B66D ^ 0x9B95BA2D)) {
            this.\u0196 = bl ? 1.0f : 0.0f;
        } else if (bl) {
            if (oc98904eb9e7.\u0132(0x9B81B67D ^ 0x9B95BA2D) > this.\u0196) {
                this.\u0196 = oc62a465bc97.\u0517((float)((double)this.\u0196 + d2 / oc98904eb9e7.\u0442(0x9B81B66D ^ 0x9B95BA2D)), oc98904eb9e7.\u0132(0x9B81B67D ^ 0x9B95BA2D));
            }
        } else if (this.\u0196 > 0.0f) {
            this.\u0196 = oc62a465bc97.\u057f((float)((double)this.\u0196 + d2 / oc98904eb9e7.\u0442(0x9B81B665 ^ 0x9B95BA2D)), 0.0f);
        }
        this.\u00d6 = d;
        return bl;
    }

    public float \u03b9() {
        return oc62a465bc97.\u0181(this.\u0196);
    }
}

