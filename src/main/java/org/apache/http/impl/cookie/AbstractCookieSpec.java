/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@NotThreadSafe
public abstract class AbstractCookieSpec
implements CookieSpec {
    private final Map<String, CookieAttributeHandler> attribHandlerMap = new HashMap<String, CookieAttributeHandler>(10);

    public void registerAttribHandler(String string, CookieAttributeHandler cookieAttributeHandler) {
        Args.notNull(string, "Attribute name");
        Args.notNull(cookieAttributeHandler, "Attribute handler");
        this.attribHandlerMap.put(string, cookieAttributeHandler);
    }

    protected CookieAttributeHandler findAttribHandler(String string) {
        return this.attribHandlerMap.get(string);
    }

    protected CookieAttributeHandler getAttribHandler(String string) {
        CookieAttributeHandler cookieAttributeHandler = this.findAttribHandler(string);
        if (cookieAttributeHandler == null) {
            throw new IllegalStateException("Handler not registered for " + string + " attribute.");
        }
        return cookieAttributeHandler;
    }

    protected Collection<CookieAttributeHandler> getAttribHandlers() {
        return this.attribHandlerMap.values();
    }
}

