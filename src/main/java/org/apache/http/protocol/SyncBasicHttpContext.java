/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.protocol;

import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class SyncBasicHttpContext
extends BasicHttpContext {
    public SyncBasicHttpContext(HttpContext httpContext) {
        super(httpContext);
    }

    public SyncBasicHttpContext() {
    }

    public synchronized Object getAttribute(String string) {
        return super.getAttribute(string);
    }

    public synchronized void setAttribute(String string, Object object) {
        super.setAttribute(string, object);
    }

    public synchronized Object removeAttribute(String string) {
        return super.removeAttribute(string);
    }

    public synchronized void clear() {
        super.clear();
    }
}

