/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.helpers;

public class Strings {
    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !Strings.isEmpty(charSequence);
    }
}

