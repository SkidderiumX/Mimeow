/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.cookie.NetscapeDraftSpec;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
public class NetscapeDraftSpecFactory
implements CookieSpecFactory,
CookieSpecProvider {
    private final String[] datepatterns;

    public NetscapeDraftSpecFactory(String[] stringArray) {
        this.datepatterns = stringArray;
    }

    public NetscapeDraftSpecFactory() {
        this(null);
    }

    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams != null) {
            String[] stringArray = null;
            Collection collection = (Collection)httpParams.getParameter("http.protocol.cookie-datepatterns");
            if (collection != null) {
                stringArray = new String[collection.size()];
                stringArray = collection.toArray(stringArray);
            }
            return new NetscapeDraftSpec(stringArray);
        }
        return new NetscapeDraftSpec();
    }

    public CookieSpec create(HttpContext httpContext) {
        return new NetscapeDraftSpec(this.datepatterns);
    }
}

