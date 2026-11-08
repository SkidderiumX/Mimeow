/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x.oc2f60cd9d1e;
import x.oc6bda5bfdb7;
import x.oc93821aed5f;

public class oc3d1d10e2c1 {
    @NotNull
    private final Set<oc2f60cd9d1e> \u039e;
    @NotNull
    private final oc93821aed5f \u0502;
    @Nullable
    private final oc6bda5bfdb7 \u0457;
    private final boolean \u04f2;
    public static boolean \u02b2;

    public oc3d1d10e2c1(@NotNull Set<oc2f60cd9d1e> set, @NotNull oc93821aed5f oc93821aed5f2) {
        this(set, oc93821aed5f2, null, true);
    }

    public oc3d1d10e2c1(@NotNull Set<oc2f60cd9d1e> set, @NotNull oc93821aed5f oc93821aed5f2, @Nullable oc6bda5bfdb7 oc6bda5bfdb72) {
        this(set, oc93821aed5f2, oc6bda5bfdb72, true);
    }

    public oc3d1d10e2c1(@NotNull Set<oc2f60cd9d1e> set, @NotNull oc93821aed5f oc93821aed5f2, @Nullable oc6bda5bfdb7 oc6bda5bfdb72, boolean bl) {
        this.\u039e = set;
        this.\u0502 = oc93821aed5f2;
        this.\u0457 = oc6bda5bfdb72;
        this.\u04f2 = bl;
    }

    @NotNull
    public Set<oc2f60cd9d1e> \u015a() {
        return this.\u039e;
    }

    @NotNull
    public oc93821aed5f \u0220() {
        return this.\u0502;
    }

    @Nullable
    public oc6bda5bfdb7 \u0417() {
        return this.\u0457;
    }

    public boolean \u025c() {
        return this.\u04f2;
    }
}

