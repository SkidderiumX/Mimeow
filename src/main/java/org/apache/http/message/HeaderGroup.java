/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicListHeaderIterator;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class HeaderGroup
implements Cloneable,
Serializable {
    private static final long serialVersionUID = 2608834160639271617L;
    private final List<Header> headers = new ArrayList<Header>(16);

    public void clear() {
        this.headers.clear();
    }

    public void addHeader(Header header) {
        if (header == null) {
            return;
        }
        this.headers.add(header);
    }

    public void removeHeader(Header header) {
        if (header == null) {
            return;
        }
        this.headers.remove(header);
    }

    public void updateHeader(Header header) {
        if (header == null) {
            return;
        }
        for (int i = 0; i < this.headers.size(); ++i) {
            Header header2 = this.headers.get(i);
            if (!header2.getName().equalsIgnoreCase(header.getName())) continue;
            this.headers.set(i, header);
            return;
        }
        this.headers.add(header);
    }

    public void setHeaders(Header[] headerArray) {
        this.clear();
        if (headerArray == null) {
            return;
        }
        Collections.addAll(this.headers, headerArray);
    }

    public Header getCondensedHeader(String string) {
        Header[] headerArray = this.getHeaders(string);
        if (headerArray.length == 0) {
            return null;
        }
        if (headerArray.length == 1) {
            return headerArray[0];
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
        charArrayBuffer.append(headerArray[0].getValue());
        for (int i = 1; i < headerArray.length; ++i) {
            charArrayBuffer.append(", ");
            charArrayBuffer.append(headerArray[i].getValue());
        }
        return new BasicHeader(string.toLowerCase(Locale.ENGLISH), charArrayBuffer.toString());
    }

    public Header[] getHeaders(String string) {
        ArrayList<Header> arrayList = new ArrayList<Header>();
        for (int i = 0; i < this.headers.size(); ++i) {
            Header header = this.headers.get(i);
            if (!header.getName().equalsIgnoreCase(string)) continue;
            arrayList.add(header);
        }
        return arrayList.toArray(new Header[arrayList.size()]);
    }

    public Header getFirstHeader(String string) {
        for (int i = 0; i < this.headers.size(); ++i) {
            Header header = this.headers.get(i);
            if (!header.getName().equalsIgnoreCase(string)) continue;
            return header;
        }
        return null;
    }

    public Header getLastHeader(String string) {
        for (int i = this.headers.size() - 1; i >= 0; --i) {
            Header header = this.headers.get(i);
            if (!header.getName().equalsIgnoreCase(string)) continue;
            return header;
        }
        return null;
    }

    public Header[] getAllHeaders() {
        return this.headers.toArray(new Header[this.headers.size()]);
    }

    public boolean containsHeader(String string) {
        for (int i = 0; i < this.headers.size(); ++i) {
            Header header = this.headers.get(i);
            if (!header.getName().equalsIgnoreCase(string)) continue;
            return true;
        }
        return false;
    }

    public HeaderIterator iterator() {
        return new BasicListHeaderIterator(this.headers, null);
    }

    public HeaderIterator iterator(String string) {
        return new BasicListHeaderIterator(this.headers, string);
    }

    public HeaderGroup copy() {
        HeaderGroup headerGroup = new HeaderGroup();
        headerGroup.headers.addAll(this.headers);
        return headerGroup;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return this.headers.toString();
    }
}

