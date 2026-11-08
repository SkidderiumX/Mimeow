/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.impl.cookie.AbstractCookieAttributeHandler;
import org.apache.http.util.Args;

@Immutable
public class BasicMaxAgeHandler
extends AbstractCookieAttributeHandler {
    public void parse(SetCookie setCookie, String string) throws MalformedCookieException {
        int n;
        Args.notNull(setCookie, "Cookie");
        if (string == null) {
            throw new MalformedCookieException("Missing value for max-age attribute");
        }
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new MalformedCookieException("Invalid max-age attribute: " + string);
        }
        if (n < 0) {
            throw new MalformedCookieException("Negative max-age attribute: " + string);
        }
        setCookie.setExpiryDate(new Date(System.currentTimeMillis() + (long)n * 1000L));
    }
}

