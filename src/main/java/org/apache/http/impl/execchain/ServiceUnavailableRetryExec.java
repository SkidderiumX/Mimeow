/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.execchain;

import java.io.IOException;
import java.io.InterruptedIOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.util.Args;

@Immutable
public class ServiceUnavailableRetryExec
implements ClientExecChain {
    private final Log log = LogFactory.getLog(this.getClass());
    private final ClientExecChain requestExecutor;
    private final ServiceUnavailableRetryStrategy retryStrategy;

    public ServiceUnavailableRetryExec(ClientExecChain clientExecChain, ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        Args.notNull(clientExecChain, "HTTP request executor");
        Args.notNull(serviceUnavailableRetryStrategy, "Retry strategy");
        this.requestExecutor = clientExecChain;
        this.retryStrategy = serviceUnavailableRetryStrategy;
    }

    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        Header[] headerArray = httpRequestWrapper.getAllHeaders();
        int n = 1;
        while (true) {
            CloseableHttpResponse closeableHttpResponse = this.requestExecutor.execute(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
            try {
                if (this.retryStrategy.retryRequest(closeableHttpResponse, n, httpClientContext)) {
                    closeableHttpResponse.close();
                    long l = this.retryStrategy.getRetryInterval();
                    if (l > 0L) {
                        try {
                            this.log.trace("Wait for " + l);
                            Thread.sleep(l);
                        }
                        catch (InterruptedException interruptedException) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                } else {
                    return closeableHttpResponse;
                }
                httpRequestWrapper.setHeaders(headerArray);
            }
            catch (RuntimeException runtimeException) {
                closeableHttpResponse.close();
                throw runtimeException;
            }
            ++n;
        }
    }
}

