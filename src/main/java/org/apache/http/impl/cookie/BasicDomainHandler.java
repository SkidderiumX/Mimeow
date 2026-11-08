/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
public class BasicDomainHandler
implements CookieAttributeHandler {
    public void parse(SetCookie setCookie, String string) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (string == null) {
            throw new MalformedCookieException("Missing value for domain attribute");
        }
        if (string.trim().length() == 0) {
            throw new MalformedCookieException("Blank value for domain attribute");
        }
        setCookie.setDomain(string);
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String string = cookieOrigin.getHost();
        String string2 = cookie.getDomain();
        if (string2 == null) {
            throw new CookieRestrictionViolationException("Cookie domain may not be null");
        }
        if (string.contains(".")) {
            if (!string.endsWith(string2)) {
                if (string2.startsWith(".")) {
                    string2 = string2.substring(1, string2.length());
                }
                if (!string.equals(string2)) {
                    throw new CookieRestrictionViolationException("Illegal domain attribute \"" + string2 + "\". Domain of origin: \"" + string + "\"");
                }
            }
        } else if (!string.equals(string2)) {
            throw new CookieRestrictionViolationException("Illegal domain attribute \"" + string2 + "\". Domain of origin: \"" + string + "\"");
        }
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String string = cookieOrigin.getHost();
        String string2 = cookie.getDomain();
        if (string2 == null) {
            return false;
        }
        if (string.equals(string2)) {
            return true;
        }
        if (!string2.startsWith(".")) {
            string2 = '.' + string2;
        }
        return string.endsWith(string2) || string.equals(string2.substring(1));
    }
}

