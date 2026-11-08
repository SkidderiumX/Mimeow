/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.impl.cookie.AbstractCookieAttributeHandler;
import org.apache.http.util.Args;

@Immutable
public class BasicExpiresHandler
extends AbstractCookieAttributeHandler {
    private final String[] datepatterns;

    public BasicExpiresHandler(String[] stringArray) {
        Args.notNull(stringArray, "Array of date patterns");
        this.datepatterns = stringArray;
    }

    public void parse(SetCookie setCookie, String string) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (string == null) {
            throw new MalformedCookieException("Missing value for expires attribute");
        }
        Date date = DateUtils.parseDate(string, this.datepatterns);
        if (date == null) {
            throw new MalformedCookieException("Unable to parse expires attribute: " + string);
        }
        setCookie.setExpiryDate(date);
    }
}

