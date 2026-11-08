/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieIdentityComparator;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@ThreadSafe
public class BasicCookieStore
implements CookieStore,
Serializable {
    private static final long serialVersionUID = -7581093305228232025L;
    @GuardedBy(value="this")
    private final TreeSet<Cookie> cookies = new TreeSet<Cookie>(new CookieIdentityComparator());

    @Override
    public synchronized void addCookie(Cookie cookie) {
        if (cookie != null) {
            this.cookies.remove(cookie);
            if (!cookie.isExpired(new Date())) {
                this.cookies.add(cookie);
            }
        }
    }

    public synchronized void addCookies(Cookie[] cookieArray) {
        if (cookieArray != null) {
            for (Cookie cookie : cookieArray) {
                this.addCookie(cookie);
            }
        }
    }

    @Override
    public synchronized List<Cookie> getCookies() {
        return new ArrayList<Cookie>(this.cookies);
    }

    @Override
    public synchronized boolean clearExpired(Date date) {
        if (date == null) {
            return false;
        }
        boolean bl = false;
        Iterator<Cookie> iterator2 = this.cookies.iterator();
        while (iterator2.hasNext()) {
            if (!iterator2.next().isExpired(date)) continue;
            iterator2.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public synchronized void clear() {
        this.cookies.clear();
    }

    public synchronized String toString() {
        return this.cookies.toString();
    }
}

