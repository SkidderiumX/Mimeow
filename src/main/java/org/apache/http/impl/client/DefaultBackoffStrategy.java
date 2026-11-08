/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ConnectionBackoffStrategy;

public class DefaultBackoffStrategy
implements ConnectionBackoffStrategy {
    public boolean shouldBackoff(Throwable throwable) {
        return throwable instanceof SocketTimeoutException || throwable instanceof ConnectException;
    }

    public boolean shouldBackoff(HttpResponse httpResponse) {
        return httpResponse.getStatusLine().getStatusCode() == 503;
    }
}

