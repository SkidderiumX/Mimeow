/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.impl.cookie.BasicCommentHandler;
import org.apache.http.impl.cookie.BasicDomainHandler;
import org.apache.http.impl.cookie.BasicExpiresHandler;
import org.apache.http.impl.cookie.BasicMaxAgeHandler;
import org.apache.http.impl.cookie.BasicPathHandler;
import org.apache.http.impl.cookie.BasicSecureHandler;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatVersionAttributeHandler;
import org.apache.http.impl.cookie.CookieSpecBase;
import org.apache.http.impl.cookie.NetscapeDraftHeaderParser;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@NotThreadSafe
public class BrowserCompatSpec
extends CookieSpecBase {
    private static final String[] DEFAULT_DATE_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};
    private final String[] datepatterns;

    public BrowserCompatSpec(String[] stringArray, BrowserCompatSpecFactory.SecurityLevel securityLevel) {
        this.datepatterns = stringArray != null ? (String[])stringArray.clone() : DEFAULT_DATE_PATTERNS;
        switch (securityLevel) {
            case SECURITYLEVEL_DEFAULT: {
                this.registerAttribHandler("path", new BasicPathHandler());
                break;
            }
            case SECURITYLEVEL_IE_MEDIUM: {
                this.registerAttribHandler("path", new BasicPathHandler(){

                    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
                    }
                });
                break;
            }
            default: {
                throw new RuntimeException("Unknown security level");
            }
        }
        this.registerAttribHandler("domain", new BasicDomainHandler());
        this.registerAttribHandler("max-age", new BasicMaxAgeHandler());
        this.registerAttribHandler("secure", new BasicSecureHandler());
        this.registerAttribHandler("comment", new BasicCommentHandler());
        this.registerAttribHandler("expires", new BasicExpiresHandler(this.datepatterns));
        this.registerAttribHandler("version", new BrowserCompatVersionAttributeHandler());
    }

    public BrowserCompatSpec(String[] stringArray) {
        this(stringArray, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpec() {
        this(null, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    @Override
    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        String string = header.getName();
        if (!string.equalsIgnoreCase("Set-Cookie")) {
            throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
        }
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
                String string2 = header.getValue();
                if (string2 == null) {
                    throw new MalformedCookieException("Header value is null");
                }
                charArrayBuffer = new CharArrayBuffer(string2.length());
                charArrayBuffer.append(string2);
                parserCursor = new ParserCursor(0, charArrayBuffer.length());
            }
            headerElementArray = new HeaderElement[]{netscapeDraftHeaderParser.parseHeader(charArrayBuffer, parserCursor)};
        }
        return this.parse(headerElementArray, cookieOrigin);
    }

    private static boolean isQuoteEnclosed(String string) {
        return string != null && string.startsWith("\"") && string.endsWith("\"");
    }

    @Override
    public List<Header> formatCookies(List<Cookie> list) {
        Args.notEmpty(list, "List of cookies");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(20 * list.size());
        charArrayBuffer.append("Cookie");
        charArrayBuffer.append(": ");
        for (int i = 0; i < list.size(); ++i) {
            Cookie cookie = list.get(i);
            if (i > 0) {
                charArrayBuffer.append("; ");
            }
            String string = cookie.getName();
            String string2 = cookie.getValue();
            if (cookie.getVersion() > 0 && !BrowserCompatSpec.isQuoteEnclosed(string2)) {
                BasicHeaderValueFormatter.INSTANCE.formatHeaderElement(charArrayBuffer, new BasicHeaderElement(string, string2), false);
                continue;
            }
            charArrayBuffer.append(string);
            charArrayBuffer.append("=");
            if (string2 == null) continue;
            charArrayBuffer.append(string2);
        }
        ArrayList<Header> arrayList = new ArrayList<Header>(1);
        arrayList.add(new BufferedHeader(charArrayBuffer));
        return arrayList;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public Header getVersionHeader() {
        return null;
    }

    public String toString() {
        return "compatibility";
    }
}

