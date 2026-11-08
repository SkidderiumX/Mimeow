/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.impl.cookie.NetscapeDraftHeaderParser;
import org.apache.http.impl.cookie.RFC2109Spec;
import org.apache.http.impl.cookie.RFC2965Spec;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@NotThreadSafe
public class BestMatchSpec
implements CookieSpec {
    private final String[] datepatterns;
    private final boolean oneHeader;
    private RFC2965Spec strict;
    private RFC2109Spec obsoleteStrict;
    private BrowserCompatSpec compat;

    public BestMatchSpec(String[] stringArray, boolean bl) {
        this.datepatterns = stringArray == null ? null : (String[])stringArray.clone();
        this.oneHeader = bl;
    }

    public BestMatchSpec() {
        this(null, false);
    }

    private RFC2965Spec getStrict() {
        if (this.strict == null) {
            this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
        }
        return this.strict;
    }

    private RFC2109Spec getObsoleteStrict() {
        if (this.obsoleteStrict == null) {
            this.obsoleteStrict = new RFC2109Spec(this.datepatterns, this.oneHeader);
        }
        return this.obsoleteStrict;
    }

    private BrowserCompatSpec getCompat() {
        if (this.compat == null) {
            this.compat = new BrowserCompatSpec(this.datepatterns);
        }
        return this.compat;
    }

    @Override
    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        HeaderElement[] headerElementArray = header.getElements();
        boolean bl = false;
        boolean bl2 = false;
        for (HeaderElement object : headerElementArray) {
            if (object.getParameterByName("version") != null) {
                bl = true;
            }
            if (object.getParameterByName("expires") == null) continue;
            bl2 = true;
        }
        if (bl2 || !bl) {
            ParserCursor parserCursor;
            CharArrayBuffer charArrayBuffer;
            NetscapeDraftHeaderParser netscapeDraftHeaderParser = NetscapeDraftHeaderParser.DEFAULT;
            if (header instanceof FormattedHeader) {
                charArrayBuffer = ((FormattedHeader)header).getBuffer();
                parserCursor = new ParserCursor(((FormattedHeader)header).getValuePos(), charArrayBuffer.length());
            } else {
                String string = header.getValue();
                if (string == null) {
                    throw new MalformedCookieException("Header value is null");
                }
                charArrayBuffer = new CharArrayBuffer(string.length());
                charArrayBuffer.append(string);
                parserCursor = new ParserCursor(0, charArrayBuffer.length());
            }
            headerElementArray = new HeaderElement[]{netscapeDraftHeaderParser.parseHeader(charArrayBuffer, parserCursor)};
            return this.getCompat().parse(headerElementArray, cookieOrigin);
        }
        if ("Set-Cookie2".equals(header.getName())) {
            return this.getStrict().parse(headerElementArray, cookieOrigin);
        }
        return this.getObsoleteStrict().parse(headerElementArray, cookieOrigin);
    }

    @Override
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (cookie.getVersion() > 0) {
            if (cookie instanceof SetCookie2) {
                this.getStrict().validate(cookie, cookieOrigin);
            } else {
                this.getObsoleteStrict().validate(cookie, cookieOrigin);
            }
        } else {
            this.getCompat().validate(cookie, cookieOrigin);
        }
    }

    @Override
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (cookie.getVersion() > 0) {
            if (cookie instanceof SetCookie2) {
                return this.getStrict().match(cookie, cookieOrigin);
            }
            return this.getObsoleteStrict().match(cookie, cookieOrigin);
        }
        return this.getCompat().match(cookie, cookieOrigin);
    }

    @Override
    public List<Header> formatCookies(List<Cookie> list) {
        Args.notNull(list, "List of cookies");
        int n = Integer.MAX_VALUE;
        boolean bl = true;
        for (Cookie cookie : list) {
            if (!(cookie instanceof SetCookie2)) {
                bl = false;
            }
            if (cookie.getVersion() >= n) continue;
            n = cookie.getVersion();
        }
        if (n > 0) {
            if (bl) {
                return this.getStrict().formatCookies(list);
            }
            return this.getObsoleteStrict().formatCookies(list);
        }
        return this.getCompat().formatCookies(list);
    }

    @Override
    public int getVersion() {
        return this.getStrict().getVersion();
    }

    @Override
    public Header getVersionHeader() {
        return this.getStrict().getVersionHeader();
    }

    public String toString() {
        return "best-match";
    }
}

