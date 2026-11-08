/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import org.apache.http.annotation.Immutable;
import org.apache.http.impl.client.DefaultRedirectStrategy;

@Immutable
public class LaxRedirectStrategy
extends DefaultRedirectStrategy {
    private static final String[] REDIRECT_METHODS = new String[]{"GET", "POST", "HEAD"};

    protected boolean isRedirectable(String string) {
        for (String string2 : REDIRECT_METHODS) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return true;
        }
        return false;
    }
}

