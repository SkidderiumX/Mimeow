/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc69da1aa7f5;
import x.ocbde1165e4e;
import x.ocf4a88a1fa1;

public class ocee33618a8d
implements ocf4a88a1fa1 {
    private final String \u041a;
    private final boolean \u027d;
    private boolean \u00d5;
    public static int \u0278;

    public ocee33618a8d(String string, boolean bl) {
        this.\u041a = string;
        this.\u027d = bl;
    }

    public String \u00f1() {
        return this.\u041a;
    }

    public String toString() {
        String string;
        block4: {
            boolean bl;
            block6: {
                block5: {
                    int n = \u0278;
                    Object[] objectArray = new Object[0x7A07BB8C ^ 0x7A07BB8F];
                    objectArray[0] = this.getClass().getSimpleName();
                    objectArray[1] = this.\u041a;
                    objectArray[0x7A07BB8D ^ 0x7A07BB8F] = this.\u027d;
                    string = String.format("CallbackInfo[TYPE=%s,NAME=%s,CANCELLABLE=%s]", objectArray);
                    if (n == 0) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
        return string;
    }

    @Override
    public final boolean z$la6zx49zlpil() {
        return this.\u027d;
    }

    @Override
    public final boolean z$24lpjeeur71n9() {
        return this.\u00d5;
    }

    @Override
    public void z$2vp8d6bhwkrey() throws ocbde1165e4e {
        if (!this.\u027d) {
            throw new ocbde1165e4e("The call " + this.\u041a + " is not cancellable.");
        }
        this.\u00d5 = true;
    }
}

