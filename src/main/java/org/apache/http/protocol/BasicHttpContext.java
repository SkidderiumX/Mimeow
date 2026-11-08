/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@ThreadSafe
public class BasicHttpContext
implements HttpContext {
    private final HttpContext parentContext;
    private final Map<String, Object> map = new ConcurrentHashMap<String, Object>();

    public BasicHttpContext() {
        this(null);
    }

    public BasicHttpContext(HttpContext httpContext) {
        this.parentContext = httpContext;
    }

    public Object getAttribute(String string) {
        Args.notNull(string, "Id");
        Object object = this.map.get(string);
        if (object == null && this.parentContext != null) {
            object = this.parentContext.getAttribute(string);
        }
        return object;
    }

    public void setAttribute(String string, Object object) {
        Args.notNull(string, "Id");
        if (object != null) {
            this.map.put(string, object);
        } else {
            this.map.remove(string);
        }
    }

    public Object removeAttribute(String string) {
        Args.notNull(string, "Id");
        return this.map.remove(string);
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }
}

