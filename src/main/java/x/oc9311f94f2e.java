/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import x.oc69da1aa7f5;
import x.oc80438d6cc7;
import x.ocd9db3ede42;
import x.oce4cea752dd;

public class oc9311f94f2e {
    public static final int \u0258 = oce4cea752dd.\u051d.ordinal();
    private static final List<oce4cea752dd> \u0186 = Stream.concat(oc80438d6cc7.\u050a().stream(), Stream.of(oce4cea752dd.\u051d)).toList();
    public static final String[] \u049d = (String[])Stream.concat(\u0186.stream().map(oc80438d6cc7::\u0537), Stream.of("Unload")).toArray(String[]::new);

    public static int \u03bc(int n) {
        return \u0186.get(n).ordinal();
    }

    public static int \u0419(int n) {
        oce4cea752dd[] oce4cea752ddArray = oce4cea752dd.values();
        int n2 = n >= 0 && n < oce4cea752ddArray.length ? \u0186.indexOf((Object)oce4cea752ddArray[n]) : -1;
        return n2 < 0 ? \u0186.indexOf((Object)oce4cea752dd.\u04a6) : n2;
    }

    public static int \u0146(float f) {
        return Math.max(1, Math.min(0x1EFEC1A0 ^ 0x1EFEC1A6, (int)(f / 120.0f)));
    }

    public static int \u00ba(float f) {
        return (\u049d.length + oc9311f94f2e.\u0146(f) - 1) / oc9311f94f2e.\u0146(f);
    }

    public static ocd9db3ede42 \u0244(ocd9db3ede42 ocd9db3ede422, int n) {
        int n2 = oc9311f94f2e.\u0146(ocd9db3ede422.\u0423);
        float f = ocd9db3ede422.\u0423 / (float)n2;
        float f2 = ocd9db3ede422.\u0462 / (float)oc9311f94f2e.\u00ba(ocd9db3ede422.\u0423);
        return new ocd9db3ede42(ocd9db3ede422.\u00c8 + (float)(n % n2) * f, ocd9db3ede422.\u0151 + (float)(n / n2) * f2, f, f2);
    }

    public static List<oc69da1aa7f5> \u00c0(int n) {
        oce4cea752dd[] oce4cea752ddArray = oce4cea752dd.values();
        return n >= 0 && n < oce4cea752ddArray.length && \u0186.contains((Object)oce4cea752ddArray[n]) ? oc80438d6cc7.\u0128(oce4cea752ddArray[n]) : Collections.emptyList();
    }

    public static String \u0264(oc69da1aa7f5 oc69da1aa7f52) {
        return oc69da1aa7f52 == null ? "" : oc69da1aa7f52.\u01de();
    }

    private oc9311f94f2e() {
    }
}

