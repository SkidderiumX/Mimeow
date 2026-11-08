/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.helpers;

public class Booleans {
    public static boolean parseBoolean(String string, boolean bl) {
        return "true".equalsIgnoreCase(string) || bl && !"false".equalsIgnoreCase(string);
    }
}

