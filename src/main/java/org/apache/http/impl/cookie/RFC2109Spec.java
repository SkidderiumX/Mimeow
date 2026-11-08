/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookiePathComparator;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.impl.cookie.BasicCommentHandler;
import org.apache.http.impl.cookie.BasicExpiresHandler;
import org.apache.http.impl.cookie.BasicMaxAgeHandler;
import org.apache.http.impl.cookie.BasicPathHandler;
import org.apache.http.impl.cookie.BasicSecureHandler;
import org.apache.http.impl.cookie.CookieSpecBase;
import org.apache.http.impl.cookie.RFC2109DomainHandler;
import org.apache.http.impl.cookie.RFC2109VersionHandler;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@NotThreadSafe
public class RFC2109Spec
extends CookieSpecBase {
    private static final CookiePathComparator PATH_COMPARATOR = new CookiePathComparator();
    private static final String[] DATE_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};
    private final String[] datepatterns;
    private final boolean oneHeader;

    public RFC2109Spec(String[] stringArray, boolean bl) {
        this.datepatterns = stringArray != null ? (String[])stringArray.clone() : DATE_PATTERNS;
        this.oneHeader = bl;
        this.registerAttribHandler("version", new RFC2109VersionHandler());
        this.registerAttribHandler("path", new BasicPathHandler());
        this.registerAttribHandler("domain", new RFC2109DomainHandler());
        this.registerAttribHandler("max-age", new BasicMaxAgeHandler());
        this.registerAttribHandler("secure", new BasicSecureHandler());
        this.registerAttribHandler("comment", new BasicCommentHandler());
        this.registerAttribHandler("expires", new BasicExpiresHandler(this.datepatterns));
    }

    public RFC2109Spec() {
        this(null, false);
    }

    @Override
    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (!header.getName().equalsIgnoreCase("Set-Cookie")) {
            throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
        }
        HeaderElement[] headerElementArray = header.getElements();
        return this.parse(headerElementArray, cookieOrigin);
    }

    @Override
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        String string = cookie.getName();
        if (string.indexOf(32) != -1) {
            throw new CookieRestrictionViolationException("Cookie name may not contain blanks");
        }
        if (string.startsWith("$")) {
            throw new CookieRestrictionViolationException("Cookie name may not start with $");
        }
        super.validate(cookie, cookieOrigin);
    }

    @Override
    public List<Header> formatCookies(List<Cookie> list) {
        List<Cookie> list2;
        Args.notEmpty(list, "List of cookies");
        if (list.size() > 1) {
            list2 = new ArrayList<Cookie>(list);
            Collections.sort(list2, PATH_COMPARATOR);
        } else {
            list2 = list;
        }
        if (this.oneHeader) {
            return this.doFormatOneHeader(list2);
        }
        return this.doFormatManyHeaders(list2);
    }

    private List<Header> doFormatOneHeader(List<Cookie> list) {
        int n = Integer.MAX_VALUE;
        for (Cookie object2 : list) {
            if (object2.getVersion() >= n) continue;
            n = object2.getVersion();
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(40 * list.size());
        charArrayBuffer.append("Cookie");
        charArrayBuffer.append(": ");
        charArrayBuffer.append("$Version=");
        charArrayBuffer.append(Integer.toString(n));
        for (Cookie cookie : list) {
            charArrayBuffer.append("; ");
            Cookie cookie2 = cookie;
            this.formatCookieAsVer(charArrayBuffer, cookie2, n);
        }
        ArrayList<Header> arrayList = new ArrayList<Header>(1);
        arrayList.add(new BufferedHeader(charArrayBuffer));
        return arrayList;
    }

    private List<Header> doFormatManyHeaders(List<Cookie> list) {
        ArrayList<Header> arrayList = new ArrayList<Header>(list.size());
        for (Cookie cookie : list) {
            int n = cookie.getVersion();
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(40);
            charArrayBuffer.append("Cookie: ");
            charArrayBuffer.append("$Version=");
            charArrayBuffer.append(Integer.toString(n));
            charArrayBuffer.append("; ");
            this.formatCookieAsVer(charArrayBuffer, cookie, n);
            arrayList.add(new BufferedHeader(charArrayBuffer));
        }
        return arrayList;
    }

    protected void formatParamAsVer(CharArrayBuffer charArrayBuffer, String string, String string2, int n) {
        charArrayBuffer.append(string);
        charArrayBuffer.append("=");
        if (string2 != null) {
            if (n > 0) {
                charArrayBuffer.append('\"');
                charArrayBuffer.append(string2);
                charArrayBuffer.append('\"');
            } else {
                charArrayBuffer.append(string2);
            }
        }
    }

    protected void formatCookieAsVer(CharArrayBuffer charArrayBuffer, Cookie cookie, int n) {
        this.formatParamAsVer(charArrayBuffer, cookie.getName(), cookie.getValue(), n);
        if (cookie.getPath() != null && cookie instanceof ClientCookie && ((ClientCookie)cookie).containsAttribute("path")) {
            charArrayBuffer.append("; ");
            this.formatParamAsVer(charArrayBuffer, "$Path", cookie.getPath(), n);
        }
        if (cookie.getDomain() != null && cookie instanceof ClientCookie && ((ClientCookie)cookie).containsAttribute("domain")) {
            charArrayBuffer.append("; ");
            this.formatParamAsVer(charArrayBuffer, "$Domain", cookie.getDomain(), n);
        }
    }

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public Header getVersionHeader() {
        return null;
    }

    public String toString() {
        return "rfc2109";
    }
}

