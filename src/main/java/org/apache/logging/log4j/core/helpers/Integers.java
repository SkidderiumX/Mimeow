/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.helpers;

import org.apache.logging.log4j.core.helpers.Strings;

public class Integers {
    public static int parseInt(String string, int n) {
        return Strings.isEmpty(string) ? n : Integer.parseInt(string);
    }

    public static int parseInt(String string) {
        return Integers.parseInt(string, 0);
    }
}

