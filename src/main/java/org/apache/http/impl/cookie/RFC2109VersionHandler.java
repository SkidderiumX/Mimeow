/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.impl.cookie.AbstractCookieAttributeHandler;
import org.apache.http.util.Args;

@Immutable
public class RFC2109VersionHandler
extends AbstractCookieAttributeHandler {
    public void parse(SetCookie setCookie, String string) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (string == null) {
            throw new MalformedCookieException("Missing value for version attribute");
        }
        if (string.trim().length() == 0) {
            throw new MalformedCookieException("Blank value for version attribute");
        }
        try {
            setCookie.setVersion(Integer.parseInt(string));
        }
        catch (NumberFormatException numberFormatException) {
            throw new MalformedCookieException("Invalid version: " + numberFormatException.getMessage());
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        if (cookie.getVersion() < 0) {
            throw new CookieRestrictionViolationException("Cookie version may not be negative");
        }
    }
}

