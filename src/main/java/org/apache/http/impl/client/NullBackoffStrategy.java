/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.ConnectionBackoffStrategy;

public class NullBackoffStrategy
implements ConnectionBackoffStrategy {
    public boolean shouldBackoff(Throwable throwable) {
        return false;
    }

    public boolean shouldBackoff(HttpResponse httpResponse) {
        return false;
    }
}

