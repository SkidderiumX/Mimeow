/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.StringTokenizer;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.util.Args;

@Immutable
public class RFC2965PortAttributeHandler
implements CookieAttributeHandler {
    private static int[] parsePortAttribute(String string) throws MalformedCookieException {
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
        int[] nArray = new int[stringTokenizer.countTokens()];
        try {
            int n = 0;
            while (stringTokenizer.hasMoreTokens()) {
                nArray[n] = Integer.parseInt(stringTokenizer.nextToken().trim());
                if (nArray[n] < 0) {
                    throw new MalformedCookieException("Invalid Port attribute.");
                }
                ++n;
            }
        }
        catch (NumberFormatException numberFormatException) {
            throw new MalformedCookieException("Invalid Port attribute: " + numberFormatException.getMessage());
        }
        return nArray;
    }

    private static boolean portMatch(int n, int[] nArray) {
        boolean bl = false;
        for (int n2 : nArray) {
            if (n != n2) continue;
            bl = true;
            break;
        }
        return bl;
    }

    public void parse(SetCookie setCookie, String string) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (setCookie instanceof SetCookie2) {
            SetCookie2 setCookie2 = (SetCookie2)setCookie;
            if (string != null && string.trim().length() > 0) {
                int[] nArray = RFC2965PortAttributeHandler.parsePortAttribute(string);
                setCookie2.setPorts(nArray);
            }
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        int n = cookieOrigin.getPort();
        if (cookie instanceof ClientCookie && ((ClientCookie)cookie).containsAttribute("port") && !RFC2965PortAttributeHandler.portMatch(n, cookie.getPorts())) {
            throw new CookieRestrictionViolationException("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
        }
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        int n = cookieOrigin.getPort();
        if (cookie instanceof ClientCookie && ((ClientCookie)cookie).containsAttribute("port")) {
            if (cookie.getPorts() == null) {
                return false;
            }
            if (!RFC2965PortAttributeHandler.portMatch(n, cookie.getPorts())) {
                return false;
            }
        }
        return true;
    }
}

