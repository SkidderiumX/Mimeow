/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu;

import org.lwjgl.util.glu.Util;

public class Registry
extends Util {
    private static final String versionString = "1.3";
    private static final String extensionString = "GLU_EXT_nurbs_tessellator GLU_EXT_object_space_tess ";

    public static String gluGetString(int n) {
        if (n == 100800) {
            return versionString;
        }
        if (n == 100801) {
            return extensionString;
        }
        return null;
    }

    public static boolean gluCheckExtension(String string, String string2) {
        if (string2 == null || string == null) {
            return false;
        }
        return string2.indexOf(string) != -1;
    }
}

