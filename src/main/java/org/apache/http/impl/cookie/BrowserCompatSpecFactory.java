/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
public class BrowserCompatSpecFactory
implements CookieSpecFactory,
CookieSpecProvider {
    private final String[] datepatterns;
    private final SecurityLevel securityLevel;

    public BrowserCompatSpecFactory(String[] stringArray, SecurityLevel securityLevel) {
        this.datepatterns = stringArray;
        this.securityLevel = securityLevel;
    }

    public BrowserCompatSpecFactory(String[] stringArray) {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecFactory() {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams != null) {
            String[] stringArray = null;
            Collection collection = (Collection)httpParams.getParameter("http.protocol.cookie-datepatterns");
            if (collection != null) {
                stringArray = new String[collection.size()];
                stringArray = collection.toArray(stringArray);
            }
            return new BrowserCompatSpec(stringArray, this.securityLevel);
        }
        return new BrowserCompatSpec(null, this.securityLevel);
    }

    public CookieSpec create(HttpContext httpContext) {
        return new BrowserCompatSpec(this.datepatterns);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum SecurityLevel {
        SECURITYLEVEL_DEFAULT,
        SECURITYLEVEL_IE_MEDIUM;

    }
}

