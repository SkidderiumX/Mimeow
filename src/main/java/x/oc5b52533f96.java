/*
 * Decompiled with CFR 0.152.
 */
package x;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x.oc69da1aa7f5;
import x.oc93821aed5f;

public class oc5b52533f96
extends oc93821aed5f {
    @NotNull
    private final oc69da1aa7f5 \u0125;
    @Nullable
    private final oc93821aed5f \u044d;
    private boolean \u0452 = false;
    public static boolean \u0499;

    public oc5b52533f96(@NotNull oc69da1aa7f5 oc69da1aa7f52, @Nullable oc93821aed5f oc93821aed5f2) {
        this.\u0125 = oc69da1aa7f52;
        this.\u044d = oc93821aed5f2;
        if (!oc69da1aa7f52.z$3rzb3dil7uydr()) {
            this.\u0452 = true;
        }
    }

    public oc5b52533f96(@NotNull oc69da1aa7f5 oc69da1aa7f52) {
        this(oc69da1aa7f52, null);
    }

    @Override
    protected boolean z$3j6encvc02s81() {
        boolean bl;
        int n;
        block23: {
            block22: {
                oc93821aed5f oc93821aed5f2;
                block21: {
                    oc93821aed5f oc93821aed5f3;
                    block19: {
                        block20: {
                            block17: {
                                block18: {
                                    n = oc93821aed5f.\u053f;
                                    oc93821aed5f3 = this;
                                    if (n != 0) break block17;
                                    if (oc93821aed5f3.\u0125.z$3rzb3dil7uydr()) break block18;
                                    this.\u0452 = true;
                                }
                                oc93821aed5f3 = this;
                            }
                            if (n != 0) break block19;
                            if (!oc93821aed5f3.\u0452) break block20;
                            return true;
                        }
                        oc93821aed5f2 = this;
                        if (n != 0) break block21;
                        oc93821aed5f3 = ((oc5b52533f96)oc93821aed5f2).\u044d;
                    }
                    if (oc93821aed5f3 == null) break block22;
                    oc93821aed5f2 = this.\u044d;
                }
                bl = oc93821aed5f2.\u0259();
                if (n != 0) break block23;
                if (!bl) break block22;
                bl = true;
                break block23;
            }
            bl = false;
        }
        if (false) {
            oc93821aed5f.\u053f = ++n;
        }
        return bl;
    }
}

