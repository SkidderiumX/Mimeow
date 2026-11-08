/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x.oc6d9efd226f;
import x.occ995d8031c;

public class oc0723d1b697 {
    private final String \u00de;
    private final oc6d9efd226f \u039d;
    private final List<occ995d8031c> \u0463;
    private final Integer \u0193;
    private final boolean \u0502;
    private final boolean \u024a;
    public static int \u0133;

    private oc0723d1b697(String string, oc6d9efd226f oc6d9efd226f2, List<occ995d8031c> list, Integer n, boolean bl, boolean bl2) {
        this.\u00de = string;
        this.\u039d = oc6d9efd226f2;
        this.\u0463 = Collections.unmodifiableList(new ArrayList<occ995d8031c>(list));
        this.\u0193 = n;
        this.\u0502 = bl;
        this.\u024a = bl2;
    }

    private static oc0723d1b697 \u0441() {
        return new oc0723d1b697("Checking for Miau updates...", null, Collections.emptyList(), null, true, false);
    }

    static oc0723d1b697 \u02a7() {
        return new oc0723d1b697("Unable to check for Miau updates.", null, Collections.emptyList(), null, false, true);
    }

    public String \u0254() {
        return this.\u00de;
    }

    public oc6d9efd226f \u023a() {
        return this.\u039d;
    }

    public List<occ995d8031c> \u0118() {
        return this.\u0463;
    }

    public Integer \u016b() {
        return this.\u0193;
    }

    public boolean \u03fa() {
        return this.\u0502;
    }

    public boolean \u0287() {
        return this.\u024a;
    }
}

