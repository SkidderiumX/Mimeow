/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.utils;

import org.apache.http.annotation.Immutable;
import org.apache.http.client.utils.Idn;
import org.apache.http.client.utils.JdkIdn;
import org.apache.http.client.utils.Rfc3492Idn;

@Immutable
public class Punycode {
    private static final Idn impl;

    public static String toUnicode(String string) {
        return impl.toUnicode(string);
    }

    static {
        Idn idn;
        try {
            idn = new JdkIdn();
        }
        catch (Exception exception) {
            idn = new Rfc3492Idn();
        }
        impl = idn;
    }
}

