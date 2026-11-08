/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;

@Immutable
public class RFC2965CommentUrlAttributeHandler
implements CookieAttributeHandler {
    public void parse(SetCookie setCookie, String string) throws MalformedCookieException {
        if (setCookie instanceof SetCookie2) {
            SetCookie2 setCookie2 = (SetCookie2)setCookie;
            setCookie2.setCommentURL(string);
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        return true;
    }
}

