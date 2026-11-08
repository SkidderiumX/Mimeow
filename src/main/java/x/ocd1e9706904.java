/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.IntFunction;
import x.oc220ace68b4;
import x.oc69da1aa7f5;

public class ocd1e9706904 {
    private static volatile IntFunction<String> C = oc220ace68b4::b;
    private static volatile BooleanSupplier \u03c9 = () -> false;

    public static int \u0572(oc69da1aa7f5 oc69da1aa7f52) {
        return 0;
    }

    public static String \u01cc(oc69da1aa7f5 oc69da1aa7f52) {
        return oc69da1aa7f52 != null && oc69da1aa7f52.\u056e != null ? oc69da1aa7f52.\u056e : "";
    }

    public static String \u04ef(int n) {
        return C.apply(n);
    }

    public static IntFunction<String> \u0163(IntFunction<String> intFunction) {
        IntFunction<String> intFunction2 = C;
        C = Objects.requireNonNull(intFunction);
        return intFunction2;
    }

    public static boolean \u0463() {
        return \u03c9.getAsBoolean();
    }

    public static void \u054e(BooleanSupplier booleanSupplier) {
        \u03c9 = Objects.requireNonNull(booleanSupplier);
    }

    private ocd1e9706904() {
    }
}

