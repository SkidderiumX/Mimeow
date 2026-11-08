/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.HttpTransportMetrics;

@NotThreadSafe
public class HttpConnectionMetricsImpl
implements HttpConnectionMetrics {
    public static final String REQUEST_COUNT = "http.request-count";
    public static final String RESPONSE_COUNT = "http.response-count";
    public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
    public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
    private final HttpTransportMetrics inTransportMetric;
    private final HttpTransportMetrics outTransportMetric;
    private long requestCount = 0L;
    private long responseCount = 0L;
    private Map<String, Object> metricsCache;

    public HttpConnectionMetricsImpl(HttpTransportMetrics httpTransportMetrics, HttpTransportMetrics httpTransportMetrics2) {
        this.inTransportMetric = httpTransportMetrics;
        this.outTransportMetric = httpTransportMetrics2;
    }

    public long getReceivedBytesCount() {
        if (this.inTransportMetric != null) {
            return this.inTransportMetric.getBytesTransferred();
        }
        return -1L;
    }

    public long getSentBytesCount() {
        if (this.outTransportMetric != null) {
            return this.outTransportMetric.getBytesTransferred();
        }
        return -1L;
    }

    public long getRequestCount() {
        return this.requestCount;
    }

    public void incrementRequestCount() {
        ++this.requestCount;
    }

    public long getResponseCount() {
        return this.responseCount;
    }

    public void incrementResponseCount() {
        ++this.responseCount;
    }

    public Object getMetric(String string) {
        Object object = null;
        if (this.metricsCache != null) {
            object = this.metricsCache.get(string);
        }
        if (object == null) {
            if (REQUEST_COUNT.equals(string)) {
                object = this.requestCount;
            } else if (RESPONSE_COUNT.equals(string)) {
                object = this.responseCount;
            } else {
                if (RECEIVED_BYTES_COUNT.equals(string)) {
                    if (this.inTransportMetric != null) {
                        return this.inTransportMetric.getBytesTransferred();
                    }
                    return null;
                }
                if (SENT_BYTES_COUNT.equals(string)) {
                    if (this.outTransportMetric != null) {
                        return this.outTransportMetric.getBytesTransferred();
                    }
                    return null;
                }
            }
        }
        return object;
    }

    public void setMetric(String string, Object object) {
        if (this.metricsCache == null) {
            this.metricsCache = new HashMap<String, Object>();
        }
        this.metricsCache.put(string, object);
    }

    public void reset() {
        if (this.outTransportMetric != null) {
            this.outTransportMetric.reset();
        }
        if (this.inTransportMetric != null) {
            this.inTransportMetric.reset();
        }
        this.requestCount = 0L;
        this.responseCount = 0L;
        this.metricsCache = null;
    }
}

