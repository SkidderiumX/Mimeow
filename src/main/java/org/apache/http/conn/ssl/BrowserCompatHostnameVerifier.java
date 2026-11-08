/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.conn.ssl;

import javax.net.ssl.SSLException;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.ssl.AbstractVerifier;

@Immutable
public class BrowserCompatHostnameVerifier
extends AbstractVerifier {
    public final void verify(String string, String[] stringArray, String[] stringArray2) throws SSLException {
        this.verify(string, stringArray, stringArray2, false);
    }

    boolean validCountryWildcard(String string) {
        return true;
    }

    public final String toString() {
        return "BROWSER_COMPATIBLE";
    }
}

