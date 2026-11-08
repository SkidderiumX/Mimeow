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
import org.apache.http.util.TextUtils;

@Immutable
public class BasicPathHandler
implements CookieAttributeHandler {
    public void parse(SetCookie setCookie, String string) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        setCookie.setPath(!TextUtils.isBlank(string) ? string : "/");
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        if (!this.match(cookie, cookieOrigin)) {
            throw new CookieRestrictionViolationException("Illegal path attribute \"" + cookie.getPath() + "\". Path of origin: \"" + cookieOrigin.getPath() + "\"");
        }
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        boolean bl;
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String string = cookieOrigin.getPath();
        String string2 = cookie.getPath();
        if (string2 == null) {
            string2 = "/";
        }
        if (string2.length() > 1 && string2.endsWith("/")) {
            string2 = string2.substring(0, string2.length() - 1);
        }
        if ((bl = string.startsWith(string2)) && string.length() != string2.length() && !string2.endsWith("/")) {
            bl = string.charAt(string2.length()) == '/';
        }
        return bl;
    }
}

