/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.ssl;

import org.apache.http.annotation.Immutable;
import org.apache.http.conn.ssl.AbstractVerifier;

@Immutable
public class AllowAllHostnameVerifier
extends AbstractVerifier {
    public final void verify(String string, String[] stringArray, String[] stringArray2) {
    }

    public final String toString() {
        return "ALLOW_ALL";
    }
}

