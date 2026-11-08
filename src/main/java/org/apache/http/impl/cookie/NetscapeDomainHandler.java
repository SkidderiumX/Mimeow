/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.impl.cookie.BasicDomainHandler;
import org.apache.http.util.Args;

@Immutable
public class NetscapeDomainHandler
extends BasicDomainHandler {
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        super.validate(cookie, cookieOrigin);
        String string = cookieOrigin.getHost();
        String string2 = cookie.getDomain();
        if (string.contains(".")) {
            int n = new StringTokenizer(string2, ".").countTokens();
            if (NetscapeDomainHandler.isSpecialDomain(string2)) {
                if (n < 2) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + string2 + "\" violates the Netscape cookie specification for " + "special domains");
                }
            } else if (n < 3) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + string2 + "\" violates the Netscape cookie specification");
            }
        }
    }

    private static boolean isSpecialDomain(String string) {
        String string2 = string.toUpperCase(Locale.ENGLISH);
        return string2.endsWith(".COM") || string2.endsWith(".EDU") || string2.endsWith(".NET") || string2.endsWith(".GOV") || string2.endsWith(".MIL") || string2.endsWith(".ORG") || string2.endsWith(".INT");
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String string = cookieOrigin.getHost();
        String string2 = cookie.getDomain();
        if (string2 == null) {
            return false;
        }
        return string.endsWith(string2);
    }
}

