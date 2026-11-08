/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class NetscapeDraftHeaderParser {
    public static final NetscapeDraftHeaderParser DEFAULT = new NetscapeDraftHeaderParser();

    public HeaderElement parseHeader(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        NameValuePair nameValuePair = this.parseNameValuePair(charArrayBuffer, parserCursor);
        ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
        while (!parserCursor.atEnd()) {
            NameValuePair nameValuePair2 = this.parseNameValuePair(charArrayBuffer, parserCursor);
            arrayList.add(nameValuePair2);
        }
        return new BasicHeaderElement(nameValuePair.getName(), nameValuePair.getValue(), arrayList.toArray(new NameValuePair[arrayList.size()]));
    }

    private NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        int n;
        char c;
        int n2;
        boolean bl = false;
        int n3 = parserCursor.getPos();
        int n4 = parserCursor.getUpperBound();
        String string = null;
        for (n2 = parserCursor.getPos(); n2 < n4 && (c = charArrayBuffer.charAt(n2)) != '='; ++n2) {
            if (c != ';') continue;
            bl = true;
            break;
        }
        if (n2 == n4) {
            bl = true;
            string = charArrayBuffer.substringTrimmed(n3, n4);
        } else {
            string = charArrayBuffer.substringTrimmed(n3, n2);
            ++n2;
        }
        if (bl) {
            parserCursor.updatePos(n2);
            return new BasicNameValuePair(string, null);
        }
        String string2 = null;
        int n5 = n2;
        while (n2 < n4) {
            n = charArrayBuffer.charAt(n2);
            if (n == 59) {
                bl = true;
                break;
            }
            ++n2;
        }
        n = n2;
        while (n5 < n && HTTP.isWhitespace(charArrayBuffer.charAt(n5))) {
            ++n5;
        }
        while (n > n5 && HTTP.isWhitespace(charArrayBuffer.charAt(n - 1))) {
            --n;
        }
        string2 = charArrayBuffer.substring(n5, n);
        if (bl) {
            ++n2;
        }
        parserCursor.updatePos(n2);
        return new BasicNameValuePair(string, string2);
    }
}

