/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.cookie.RFC2109Spec;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
public class RFC2109SpecFactory
implements CookieSpecFactory,
CookieSpecProvider {
    private final String[] datepatterns;
    private final boolean oneHeader;

    public RFC2109SpecFactory(String[] stringArray, boolean bl) {
        this.datepatterns = stringArray;
        this.oneHeader = bl;
    }

    public RFC2109SpecFactory() {
        this(null, false);
    }

    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams != null) {
            String[] stringArray = null;
            Collection collection = (Collection)httpParams.getParameter("http.protocol.cookie-datepatterns");
            if (collection != null) {
                stringArray = new String[collection.size()];
                stringArray = collection.toArray(stringArray);
            }
            boolean bl = httpParams.getBooleanParameter("http.protocol.single-cookie-header", false);
            return new RFC2109Spec(stringArray, bl);
        }
        return new RFC2109Spec();
    }

    public CookieSpec create(HttpContext httpContext) {
        return new RFC2109Spec(this.datepatterns, this.oneHeader);
    }
}

