package net.lenni0451.commons.httpclient.executor;

import net.lenni0451.commons.httpclient.*;
import java.lang.reflect.*;

public enum ExecutorType
{
    AUTO {
        public RequestExecutor initExecutor(final HttpClient httpClient) {
            for (int i = values().length - 1; i >= 0; --i) {
                final ExecutorType other = values()[i];
                if (!ExecutorType$1.AUTO.equals(other)) {
                    if (other.isAvailable()) {
                        final RequestExecutor executor = other.makeExecutor(httpClient);
                        if (executor != null) {
                            return executor;
                        }
                    }
                }
            }
            throw new IllegalStateException("Failed to find a suitable executor. This should never happen. Please report this to the developer.");
        }
    }, 
    URL_CONNECTION {
        public RequestExecutor initExecutor(final HttpClient httpClient) {
            return new URLConnectionExecutor(httpClient);
        }
    }, 
    REACTOR_NETTY {
        private Constructor<?> constructor;
        
        @Override
        protected void init() throws Throwable {
            Class.forName("reactor.netty.http.client.HttpClient");
            this.constructor = Class.forName("net.lenni0451.commons.httpclient.executor.extra.ReactorNettyExecutor").getDeclaredConstructor(HttpClient.class);
        }
        
        @Override
        protected RequestExecutor initExecutor(final HttpClient httpClient) throws Throwable {
            return (RequestExecutor)this.constructor.newInstance(httpClient);
        }
    }, 
    HTTP_CLIENT {
        private Constructor<?> constructor;
        
        @Override
        protected void init() throws Throwable {
            Class.forName("java.net.http.HttpClient");
            this.constructor = Class.forName("net.lenni0451.commons.httpclient.executor.HttpClientExecutor").getDeclaredConstructor(HttpClient.class);
        }
        
        @Override
        protected RequestExecutor initExecutor(final HttpClient httpClient) throws Throwable {
            return (RequestExecutor)this.constructor.newInstance(httpClient);
        }
    };
    
    private boolean available;
    
    private ExecutorType() {
        try {
            this.init();
            this.available = true;
        }
        catch (final Throwable t) {
            this.available = false;
        }
    }
    
    public final boolean isAvailable() {
        return this.available;
    }
    
    public final RequestExecutor makeExecutor(final HttpClient httpClient) {
        try {
            return this.initExecutor(httpClient);
        }
        catch (final Throwable t) {
            return null;
        }
    }
    
    protected void init() throws Throwable {
    }
    
    protected abstract RequestExecutor initExecutor(final HttpClient p0) throws Throwable;
}
