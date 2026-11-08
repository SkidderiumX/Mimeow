/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import x.oc2cf3d80e17;
import x.oc69da1aa7f5;
import x.oc97fc249870;
import x.oca4f99d2d44;
import x.oce4cea752dd;

public class oc80438d6cc7 {
    private static final List<oce4cea752dd> \u045f = Collections.unmodifiableList(Arrays.stream(oce4cea752dd.values()).filter(oce4cea752dd2 -> oce4cea752dd2 != oce4cea752dd.\u04a2).collect(Collectors.toList()));
    private static final List<oce4cea752dd> \u014a = Collections.unmodifiableList(\u045f.stream().filter(oce4cea752dd2 -> oce4cea752dd2 != oce4cea752dd.\u051d && oce4cea752dd2 != oce4cea752dd.\u00aa && oce4cea752dd2 != oce4cea752dd.\u057c && oce4cea752dd2 != oce4cea752dd.\u04b6 && oce4cea752dd2 != oce4cea752dd.\u04a9).collect(Collectors.toList()));

    private oc80438d6cc7() {
    }

    public static List<oce4cea752dd> \u0287() {
        return \u045f;
    }

    public static List<oce4cea752dd> \u050a() {
        return \u014a;
    }

    public static String \u0537(oce4cea752dd oce4cea752dd2) {
        return Arrays.stream(oce4cea752dd2.name().split("_")).map(string -> string.substring(0, 1).toUpperCase(Locale.ROOT) + string.substring(1)).collect(Collectors.joining(" "));
    }

    private static oce4cea752dd \u044d(oc69da1aa7f5 oc69da1aa7f52) {
        if (oc69da1aa7f52.\u044a() == oce4cea752dd.\u04b6) {
            if (oc69da1aa7f52 instanceof oca4f99d2d44) {
                return oce4cea752dd.\u0201;
            }
            return oc69da1aa7f52 instanceof oc97fc249870 ? oce4cea752dd.\u014e : oce4cea752dd.\u0437;
        }
        return oc69da1aa7f52.\u044a() == oce4cea752dd.\u04a9 ? oce4cea752dd.\u0437 : oc69da1aa7f52.\u044a();
    }

    public static List<oc69da1aa7f5> \u0128(oce4cea752dd oce4cea752dd2) {
        return oc2cf3d80e17.\u013c == null || !\u014a.contains((Object)oce4cea752dd2) ? Collections.emptyList() : oc2cf3d80e17.\u013c.\u057f().stream().filter(oc69da1aa7f52 -> oc80438d6cc7.\u044d(oc69da1aa7f52) == oce4cea752dd2).collect(Collectors.toList());
    }
}

