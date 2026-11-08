/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.client.methods;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@NotThreadSafe
public class HttpOptions
extends HttpRequestBase {
    public static final String METHOD_NAME = "OPTIONS";

    public HttpOptions() {
    }

    public HttpOptions(URI uRI) {
        this.setURI(uRI);
    }

    public HttpOptions(String string) {
        this.setURI(URI.create(string));
    }

    @Override
    public String getMethod() {
        return METHOD_NAME;
    }

    public Set<String> getAllowedMethods(HttpResponse httpResponse) {
        Args.notNull(httpResponse, "HTTP response");
        HeaderIterator headerIterator = httpResponse.headerIterator("Allow");
        HashSet<String> hashSet = new HashSet<String>();
        while (headerIterator.hasNext()) {
            HeaderElement[] headerElementArray;
            Header header = headerIterator.nextHeader();
            for (HeaderElement headerElement : headerElementArray = header.getElements()) {
                hashSet.add(headerElement.getName());
            }
        }
        return hashSet;
    }
}

