/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.client.utils.Punycode;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class PublicSuffixFilter
implements CookieAttributeHandler {
    private final CookieAttributeHandler wrapped;
    private Set<String> exceptions;
    private Set<String> suffixes;

    public PublicSuffixFilter(CookieAttributeHandler cookieAttributeHandler) {
        this.wrapped = cookieAttributeHandler;
    }

    public void setPublicSuffixes(Collection<String> collection) {
        this.suffixes = new HashSet<String>(collection);
    }

    public void setExceptions(Collection<String> collection) {
        this.exceptions = new HashSet<String>(collection);
    }

    @Override
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        if (this.isForPublicSuffix(cookie)) {
            return false;
        }
        return this.wrapped.match(cookie, cookieOrigin);
    }

    @Override
    public void parse(SetCookie setCookie, String string) throws MalformedCookieException {
        this.wrapped.parse(setCookie, string);
    }

    @Override
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        this.wrapped.validate(cookie, cookieOrigin);
    }

    private boolean isForPublicSuffix(Cookie cookie) {
        int n;
        String string = cookie.getDomain();
        if (string.startsWith(".")) {
            string = string.substring(1);
        }
        string = Punycode.toUnicode(string);
        if (this.exceptions != null && this.exceptions.contains(string)) {
            return false;
        }
        if (this.suffixes == null) {
            return false;
        }
        do {
            if (this.suffixes.contains(string)) {
                return true;
            }
            if (!string.startsWith("*.")) continue;
            string = string.substring(2);
        } while ((n = string.indexOf(46)) != -1 && (string = "*" + string.substring(n)).length() > 0);
        return false;
    }
}

