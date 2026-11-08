/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.Packet;
import x.oc02a3730b27;
import x.oc33e2bcdd33;
import x.oc35c0bb4ef9;
import x.ocdab58ca6e4;

public class ocb6bbd41fe6
implements oc35c0bb4ef9 {
    ocb6bbd41fe6() {
    }

    @Override
    public int z$5j5sh7l32w6l(Object object, boolean bl, long l, int n) {
        oc33e2bcdd33 oc33e2bcdd332;
        block5: {
            int n2;
            block4: {
                boolean bl2 = ocdab58ca6e4.\u02e3;
                n2 = object instanceof Packet;
                if (bl2) break block4;
                if (n2 != 0) break block5;
                n2 = 0;
            }
            return n2;
        }
        oc33e2bcdd33 oc33e2bcdd333 = oc33e2bcdd332;
        oc33e2bcdd33 oc33e2bcdd334 = oc33e2bcdd332;
        int n3 = bl ? 0xC0E6C69C ^ 0xC0E6C69F : 0xC0E6C69D ^ 0xC0E6C69F;
        oc33e2bcdd333(n3);
        oc33e2bcdd33 oc33e2bcdd335 = oc33e2bcdd334;
        oc33e2bcdd335.\u0509 = (Packet)object;
        oc33e2bcdd335.\u0440 = l;
        oc33e2bcdd335.\u01e7 = n;
        oc02a3730b27.\u0167(oc33e2bcdd335);
        return oc33e2bcdd335.\u04b9;
    }
}

