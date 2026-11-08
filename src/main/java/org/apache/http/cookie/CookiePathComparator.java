/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.cookie;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Immutable
public class CookiePathComparator
implements Serializable,
Comparator<Cookie> {
    private static final long serialVersionUID = 7523645369616405818L;

    private String normalizePath(Cookie cookie) {
        String string = cookie.getPath();
        if (string == null) {
            string = "/";
        }
        if (!string.endsWith("/")) {
            string = string + '/';
        }
        return string;
    }

    @Override
    public int compare(Cookie cookie, Cookie cookie2) {
        String string;
        String string2 = this.normalizePath(cookie);
        if (string2.equals(string = this.normalizePath(cookie2))) {
            return 0;
        }
        if (string2.startsWith(string)) {
            return -1;
        }
        if (string.startsWith(string2)) {
            return 1;
        }
        return 0;
    }
}

