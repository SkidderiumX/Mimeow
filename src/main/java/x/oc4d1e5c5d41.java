/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.net.URI;
import x.oc95a52a4046;

public class oc4d1e5c5d41 {
    public static boolean \u022a;

    public static void \u04d3(URI uRI) {
        try {
            Class<?> clazz = Class.forName("java.awt.Desktop");
            Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            clazz.getMethod("browse", URI.class).invoke(object, uRI);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void \u0109(String string) {
        oc95a52a4046.\u016e(string);
    }
}

