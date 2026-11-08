/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.mojang.authlib.GameProfile;
import x.oc75d51ec7eb;

public class ocbff50020a5 {
    private final GameProfile \u0160;
    private final long \u016e;

    private ocbff50020a5(GameProfile gameProfile, long l) {
        this.\u0160 = gameProfile;
        this.\u016e = l;
    }

    private boolean \u0443(long l) {
        long l2;
        block2: {
            block3: {
                int n = oc75d51ec7eb.\u03e9;
                long l3 = l - this.\u016e;
                l2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                if (n != 0) break block2;
                if (l2 < 0) break block3;
                l2 = 1;
                break block2;
            }
            l2 = 0;
        }
        return (boolean)l2;
    }
}

