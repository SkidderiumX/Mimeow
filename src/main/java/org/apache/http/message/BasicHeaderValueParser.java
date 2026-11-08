/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.message;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.HeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicHeaderValueParser
implements HeaderValueParser {
    @Deprecated
    public static final BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
    public static final BasicHeaderValueParser INSTANCE = new BasicHeaderValueParser();
    private static final char PARAM_DELIMITER = ';';
    private static final char ELEM_DELIMITER = ',';
    private static final char[] ALL_DELIMITERS = new char[]{';', ','};

    public static HeaderElement[] parseElements(String string, HeaderValueParser headerValueParser) throws ParseException {
        Args.notNull(string, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(string.length());
        charArrayBuffer.append(string);
        ParserCursor parserCursor = new ParserCursor(0, string.length());
        return (headerValueParser != null ? headerValueParser : INSTANCE).parseElements(charArrayBuffer, parserCursor);
    }

    public HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        ArrayList<HeaderElement> arrayList = new ArrayList<HeaderElement>();
        while (!parserCursor.atEnd()) {
            HeaderElement headerElement = this.parseHeaderElement(charArrayBuffer, parserCursor);
            if (headerElement.getName().length() == 0 && headerElement.getValue() == null) continue;
            arrayList.add(headerElement);
        }
        return arrayList.toArray(new HeaderElement[arrayList.size()]);
    }

    public static HeaderElement parseHeaderElement(String string, HeaderValueParser headerValueParser) throws ParseException {
        Args.notNull(string, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(string.length());
        charArrayBuffer.append(string);
        ParserCursor parserCursor = new ParserCursor(0, string.length());
        return (headerValueParser != null ? headerValueParser : INSTANCE).parseHeaderElement(charArrayBuffer, parserCursor);
    }

    public HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        char c;
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        NameValuePair nameValuePair = this.parseNameValuePair(charArrayBuffer, parserCursor);
        NameValuePair[] nameValuePairArray = null;
        if (!parserCursor.atEnd() && (c = charArrayBuffer.charAt(parserCursor.getPos() - 1)) != ',') {
            nameValuePairArray = this.parseParameters(charArrayBuffer, parserCursor);
        }
        return this.createHeaderElement(nameValuePair.getName(), nameValuePair.getValue(), nameValuePairArray);
    }

    protected HeaderElement createHeaderElement(String string, String string2, NameValuePair[] nameValuePairArray) {
        return new BasicHeaderElement(string, string2, nameValuePairArray);
    }

    public static NameValuePair[] parseParameters(String string, HeaderValueParser headerValueParser) throws ParseException {
        Args.notNull(string, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(string.length());
        charArrayBuffer.append(string);
        ParserCursor parserCursor = new ParserCursor(0, string.length());
        return (headerValueParser != null ? headerValueParser : INSTANCE).parseParameters(charArrayBuffer, parserCursor);
    }

    public NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        char c;
        int n;
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int n2 = parserCursor.getUpperBound();
        for (n = parserCursor.getPos(); n < n2 && HTTP.isWhitespace(c = charArrayBuffer.charAt(n)); ++n) {
        }
        parserCursor.updatePos(n);
        if (parserCursor.atEnd()) {
            return new NameValuePair[0];
        }
        ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
        while (!parserCursor.atEnd()) {
            NameValuePair nameValuePair = this.parseNameValuePair(charArrayBuffer, parserCursor);
            arrayList.add(nameValuePair);
            char c2 = charArrayBuffer.charAt(parserCursor.getPos() - 1);
            if (c2 != ',') continue;
            break;
        }
        return arrayList.toArray(new NameValuePair[arrayList.size()]);
    }

    public static NameValuePair parseNameValuePair(String string, HeaderValueParser headerValueParser) throws ParseException {
        Args.notNull(string, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(string.length());
        charArrayBuffer.append(string);
        ParserCursor parserCursor = new ParserCursor(0, string.length());
        return (headerValueParser != null ? headerValueParser : INSTANCE).parseNameValuePair(charArrayBuffer, parserCursor);
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        return this.parseNameValuePair(charArrayBuffer, parserCursor, ALL_DELIMITERS);
    }

    private static boolean isOneOf(char c, char[] cArray) {
        if (cArray != null) {
            for (char c2 : cArray) {
                if (c != c2) continue;
                return true;
            }
        }
        return false;
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, char[] cArray) {
        int n;
        String string;
        char c;
        int n2;
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        boolean bl = false;
        int n3 = parserCursor.getPos();
        int n4 = parserCursor.getUpperBound();
        for (n2 = parserCursor.getPos(); n2 < n4 && (c = charArrayBuffer.charAt(n2)) != '='; ++n2) {
            if (!BasicHeaderValueParser.isOneOf(c, cArray)) continue;
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
            return this.createNameValuePair(string, null);
        }
        int n5 = n2;
        boolean bl2 = false;
        boolean bl3 = false;
        while (n2 < n4) {
            n = charArrayBuffer.charAt(n2);
            if (n == 34 && !bl3) {
                boolean bl4 = bl2 = !bl2;
            }
            if (!bl2 && !bl3 && BasicHeaderValueParser.isOneOf((char)n, cArray)) {
                bl = true;
                break;
            }
            bl3 = bl3 ? false : bl2 && n == 92;
            ++n2;
        }
        n = n2;
        while (n5 < n && HTTP.isWhitespace(charArrayBuffer.charAt(n5))) {
            ++n5;
        }
        while (n > n5 && HTTP.isWhitespace(charArrayBuffer.charAt(n - 1))) {
            --n;
        }
        if (n - n5 >= 2 && charArrayBuffer.charAt(n5) == '\"' && charArrayBuffer.charAt(n - 1) == '\"') {
            ++n5;
            --n;
        }
        String string2 = charArrayBuffer.substring(n5, n);
        if (bl) {
            ++n2;
        }
        parserCursor.updatePos(n2);
        return this.createNameValuePair(string, string2);
    }

    protected NameValuePair createNameValuePair(String string, String string2) {
        return new BasicNameValuePair(string, string2);
    }
}

