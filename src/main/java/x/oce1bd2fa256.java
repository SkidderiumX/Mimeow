/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonObject;
import java.util.Collections;
import java.util.List;
import x.N;
import x.oc1e36b6c903;
import x.oc2cf3d80e17;
import x.oc64151e84ee;
import x.oca9cc61aada;
import x.occ9ed06a81d;
import x.occc831eff22;

public class oce1bd2fa256
extends N {
    private final oc64151e84ee \u0222;
    private final String \u0123;
    private final int \u0536;
    public occc831eff22 \u01f3;
    public static boolean \u03d6;

    public oce1bd2fa256(occc831eff22 occc831eff222, String string, oc64151e84ee oc64151e84ee2, String string2, int n) {
        super(string);
        this.\u01f3 = occc831eff222;
        this.\u0222 = oc64151e84ee2;
        this.\u0123 = string2 == null ? "" : string2;
        this.\u0536 = Math.max(1, n);
    }

    public oc64151e84ee \u0287() {
        return this.\u0222;
    }

    public String \u01fa() {
        return this.\u0123;
    }

    public int \u028d() {
        return this.\u0536;
    }

    public boolean \u044c(String string) {
        boolean bl;
        block6: {
            block5: {
                occ9ed06a81d occ9ed06a81d2;
                int n;
                block4: {
                    n = oca9cc61aada.\u01f7;
                    occ9ed06a81d2 = oc2cf3d80e17.\u022c;
                    if (n != 0) break block4;
                    if (occ9ed06a81d2 == null) break block5;
                    occ9ed06a81d2 = oc2cf3d80e17.\u022c;
                }
                bl = occ9ed06a81d2.o(this.\u0222, string);
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u056c(String string) {
        boolean bl;
        block6: {
            block5: {
                occ9ed06a81d occ9ed06a81d2;
                int n;
                block4: {
                    n = oca9cc61aada.\u01f7;
                    occ9ed06a81d2 = oc2cf3d80e17.\u022c;
                    if (n != 0) break block4;
                    if (occ9ed06a81d2 == null) break block5;
                    occ9ed06a81d2 = oc2cf3d80e17.\u022c;
                }
                bl = occ9ed06a81d2.\u0265(this.\u0222, string);
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public void \u039c() {
        block3: {
            occ9ed06a81d occ9ed06a81d2;
            block2: {
                int n = oca9cc61aada.\u01f7;
                occ9ed06a81d2 = oc2cf3d80e17.\u022c;
                if (n != 0) break block2;
                if (occ9ed06a81d2 == null) break block3;
                occ9ed06a81d2 = oc2cf3d80e17.\u022c;
            }
            occ9ed06a81d2.\u00ec(this.\u0222);
        }
    }

    public List<oc1e36b6c903> \u01b8() {
        occ9ed06a81d occ9ed06a81d2;
        block4: {
            block5: {
                int n = oca9cc61aada.\u01f7;
                occ9ed06a81d2 = oc2cf3d80e17.\u022c;
                if (n != 0) break block4;
                if (occ9ed06a81d2 != null) break block5;
                return Collections.emptyList();
            }
            occ9ed06a81d2 = oc2cf3d80e17.\u022c;
        }
        return occ9ed06a81d2.\u02a3(this.\u0222);
    }

    @Override
    public String z$3lm3x0je4b2zv() {
        Object object;
        block6: {
            oce1bd2fa256 oce1bd2fa2562;
            block4: {
                block5: {
                    int n = oca9cc61aada.\u01f7;
                    oce1bd2fa2562 = this;
                    if (n != 0) break block4;
                    if (oce1bd2fa2562.\u01f3 != null) break block5;
                    object = this.z$18nrktuqeiysv();
                    break block6;
                }
                oce1bd2fa2562 = this;
            }
            object = oce1bd2fa2562.\u01f3.z$18nrktuqeiysv() + "." + this.z$18nrktuqeiysv();
        }
        return object;
    }

    @Override
    public void z$3ktkzjg2sjswq(JsonObject jsonObject) {
    }
}

