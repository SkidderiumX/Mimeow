/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.client;

import java.io.Closeable;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.BackoffManager;
import org.apache.http.client.ConnectionBackoffStrategy;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.RequestAcceptEncoding;
import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.http.client.protocol.RequestAuthCache;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.http.client.protocol.RequestExpectContinue;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.apache.http.client.protocol.ResponseProcessCookies;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.auth.DigestSchemeFactory;
import org.apache.http.impl.auth.KerberosSchemeFactory;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.DefaultUserTokenHandler;
import org.apache.http.impl.client.InternalHttpClient;
import org.apache.http.impl.client.NoopUserTokenHandler;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;
import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.apache.http.impl.client.TargetAuthenticationStrategy;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.DefaultRoutePlanner;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.impl.cookie.IgnoreSpecFactory;
import org.apache.http.impl.cookie.NetscapeDraftSpecFactory;
import org.apache.http.impl.cookie.RFC2109SpecFactory;
import org.apache.http.impl.cookie.RFC2965SpecFactory;
import org.apache.http.impl.execchain.BackoffStrategyExec;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.impl.execchain.MainClientExec;
import org.apache.http.impl.execchain.ProtocolExec;
import org.apache.http.impl.execchain.RedirectExec;
import org.apache.http.impl.execchain.RetryExec;
import org.apache.http.impl.execchain.ServiceUnavailableRetryExec;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpProcessorBuilder;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.TextUtils;
import org.apache.http.util.VersionInfo;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@NotThreadSafe
public class HttpClientBuilder {
    private HttpRequestExecutor requestExec;
    private X509HostnameVerifier hostnameVerifier;
    private LayeredConnectionSocketFactory sslSocketFactory;
    private SSLContext sslcontext;
    private HttpClientConnectionManager connManager;
    private SchemePortResolver schemePortResolver;
    private ConnectionReuseStrategy reuseStrategy;
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    private AuthenticationStrategy targetAuthStrategy;
    private AuthenticationStrategy proxyAuthStrategy;
    private UserTokenHandler userTokenHandler;
    private HttpProcessor httpprocessor;
    private LinkedList<HttpRequestInterceptor> requestFirst;
    private LinkedList<HttpRequestInterceptor> requestLast;
    private LinkedList<HttpResponseInterceptor> responseFirst;
    private LinkedList<HttpResponseInterceptor> responseLast;
    private HttpRequestRetryHandler retryHandler;
    private HttpRoutePlanner routePlanner;
    private RedirectStrategy redirectStrategy;
    private ConnectionBackoffStrategy connectionBackoffStrategy;
    private BackoffManager backoffManager;
    private ServiceUnavailableRetryStrategy serviceUnavailStrategy;
    private Lookup<AuthSchemeProvider> authSchemeRegistry;
    private Lookup<CookieSpecProvider> cookieSpecRegistry;
    private CookieStore cookieStore;
    private CredentialsProvider credentialsProvider;
    private String userAgent;
    private HttpHost proxy;
    private Collection<? extends Header> defaultHeaders;
    private SocketConfig defaultSocketConfig;
    private ConnectionConfig defaultConnectionConfig;
    private RequestConfig defaultRequestConfig;
    private boolean systemProperties;
    private boolean redirectHandlingDisabled;
    private boolean automaticRetriesDisabled;
    private boolean contentCompressionDisabled;
    private boolean cookieManagementDisabled;
    private boolean authCachingDisabled;
    private boolean connectionStateDisabled;
    private int maxConnTotal = 0;
    private int maxConnPerRoute = 0;
    private List<Closeable> closeables;
    static final String DEFAULT_USER_AGENT;

    public static HttpClientBuilder create() {
        return new HttpClientBuilder();
    }

    protected HttpClientBuilder() {
    }

    public final HttpClientBuilder setRequestExecutor(HttpRequestExecutor httpRequestExecutor) {
        this.requestExec = httpRequestExecutor;
        return this;
    }

    public final HttpClientBuilder setHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.hostnameVerifier = x509HostnameVerifier;
        return this;
    }

    public final HttpClientBuilder setSslcontext(SSLContext sSLContext) {
        this.sslcontext = sSLContext;
        return this;
    }

    public final HttpClientBuilder setSSLSocketFactory(LayeredConnectionSocketFactory layeredConnectionSocketFactory) {
        this.sslSocketFactory = layeredConnectionSocketFactory;
        return this;
    }

    public final HttpClientBuilder setMaxConnTotal(int n) {
        this.maxConnTotal = n;
        return this;
    }

    public final HttpClientBuilder setMaxConnPerRoute(int n) {
        this.maxConnPerRoute = n;
        return this;
    }

    public final HttpClientBuilder setDefaultSocketConfig(SocketConfig socketConfig) {
        this.defaultSocketConfig = socketConfig;
        return this;
    }

    public final HttpClientBuilder setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
        this.defaultConnectionConfig = connectionConfig;
        return this;
    }

    public final HttpClientBuilder setConnectionManager(HttpClientConnectionManager httpClientConnectionManager) {
        this.connManager = httpClientConnectionManager;
        return this;
    }

    public final HttpClientBuilder setConnectionReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        this.reuseStrategy = connectionReuseStrategy;
        return this;
    }

    public final HttpClientBuilder setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        return this;
    }

    public final HttpClientBuilder setTargetAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.targetAuthStrategy = authenticationStrategy;
        return this;
    }

    public final HttpClientBuilder setProxyAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.proxyAuthStrategy = authenticationStrategy;
        return this;
    }

    public final HttpClientBuilder setUserTokenHandler(UserTokenHandler userTokenHandler) {
        this.userTokenHandler = userTokenHandler;
        return this;
    }

    public final HttpClientBuilder disableConnectionState() {
        this.connectionStateDisabled = true;
        return this;
    }

    public final HttpClientBuilder setSchemePortResolver(SchemePortResolver schemePortResolver) {
        this.schemePortResolver = schemePortResolver;
        return this;
    }

    public final HttpClientBuilder setUserAgent(String string) {
        this.userAgent = string;
        return this;
    }

    public final HttpClientBuilder setDefaultHeaders(Collection<? extends Header> collection) {
        this.defaultHeaders = collection;
        return this;
    }

    public final HttpClientBuilder addInterceptorFirst(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        if (this.responseFirst == null) {
            this.responseFirst = new LinkedList();
        }
        this.responseFirst.addFirst(httpResponseInterceptor);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        if (this.responseLast == null) {
            this.responseLast = new LinkedList();
        }
        this.responseLast.addLast(httpResponseInterceptor);
        return this;
    }

    public final HttpClientBuilder addInterceptorFirst(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        if (this.requestFirst == null) {
            this.requestFirst = new LinkedList();
        }
        this.requestFirst.addFirst(httpRequestInterceptor);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        if (this.requestLast == null) {
            this.requestLast = new LinkedList();
        }
        this.requestLast.addLast(httpRequestInterceptor);
        return this;
    }

    public final HttpClientBuilder disableCookieManagement() {
        this.cookieManagementDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableContentCompression() {
        this.contentCompressionDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableAuthCaching() {
        this.authCachingDisabled = true;
        return this;
    }

    public final HttpClientBuilder setHttpProcessor(HttpProcessor httpProcessor) {
        this.httpprocessor = httpProcessor;
        return this;
    }

    public final HttpClientBuilder setRetryHandler(HttpRequestRetryHandler httpRequestRetryHandler) {
        this.retryHandler = httpRequestRetryHandler;
        return this;
    }

    public final HttpClientBuilder disableAutomaticRetries() {
        this.automaticRetriesDisabled = true;
        return this;
    }

    public final HttpClientBuilder setProxy(HttpHost httpHost) {
        this.proxy = httpHost;
        return this;
    }

    public final HttpClientBuilder setRoutePlanner(HttpRoutePlanner httpRoutePlanner) {
        this.routePlanner = httpRoutePlanner;
        return this;
    }

    public final HttpClientBuilder setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
        return this;
    }

    public final HttpClientBuilder disableRedirectHandling() {
        this.redirectHandlingDisabled = true;
        return this;
    }

    public final HttpClientBuilder setConnectionBackoffStrategy(ConnectionBackoffStrategy connectionBackoffStrategy) {
        this.connectionBackoffStrategy = connectionBackoffStrategy;
        return this;
    }

    public final HttpClientBuilder setBackoffManager(BackoffManager backoffManager) {
        this.backoffManager = backoffManager;
        return this;
    }

    public final HttpClientBuilder setServiceUnavailableRetryStrategy(ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this.serviceUnavailStrategy = serviceUnavailableRetryStrategy;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
        return this;
    }

    public final HttpClientBuilder setDefaultCredentialsProvider(CredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
        return this;
    }

    public final HttpClientBuilder setDefaultAuthSchemeRegistry(Lookup<AuthSchemeProvider> lookup) {
        this.authSchemeRegistry = lookup;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieSpecRegistry(Lookup<CookieSpecProvider> lookup) {
        this.cookieSpecRegistry = lookup;
        return this;
    }

    public final HttpClientBuilder setDefaultRequestConfig(RequestConfig requestConfig) {
        this.defaultRequestConfig = requestConfig;
        return this;
    }

    public final HttpClientBuilder useSystemProperties() {
        this.systemProperties = true;
        return this;
    }

    protected ClientExecChain decorateMainExec(ClientExecChain clientExecChain) {
        return clientExecChain;
    }

    protected ClientExecChain decorateProtocolExec(ClientExecChain clientExecChain) {
        return clientExecChain;
    }

    protected void addCloseable(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        if (this.closeables == null) {
            this.closeables = new ArrayList<Closeable>();
        }
        this.closeables.add(closeable);
    }

    private static String[] split(String string) {
        if (TextUtils.isBlank(string)) {
            return null;
        }
        return string.split(" *, *");
    }

    public CloseableHttpClient build() {
        CredentialsProvider credentialsProvider;
        CookieStore cookieStore;
        Lookup<CookieSpecProvider> lookup;
        Lookup<AuthSchemeProvider> lookup2;
        Object object2;
        Object object3;
        UserTokenHandler userTokenHandler;
        AuthenticationStrategy authenticationStrategy;
        Object object4;
        Object object5;
        Object object6;
        Object object7;
        HttpRequestExecutor httpRequestExecutor = this.requestExec;
        if (httpRequestExecutor == null) {
            httpRequestExecutor = new HttpRequestExecutor();
        }
        if ((object7 = this.connManager) == null) {
            object6 = this.sslSocketFactory;
            if (object6 == null) {
                object5 = this.systemProperties ? HttpClientBuilder.split(System.getProperty("https.protocols")) : null;
                object4 = this.systemProperties ? HttpClientBuilder.split(System.getProperty("https.cipherSuites")) : null;
                X509HostnameVerifier x509HostnameVerifier = this.hostnameVerifier;
                if (x509HostnameVerifier == null) {
                    x509HostnameVerifier = SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
                }
                object6 = this.sslcontext != null ? new SSLConnectionSocketFactory(this.sslcontext, (String[])object5, (String[])object4, x509HostnameVerifier) : (this.systemProperties ? new SSLConnectionSocketFactory((SSLSocketFactory)SSLSocketFactory.getDefault(), (String[])object5, (String[])object4, x509HostnameVerifier) : new SSLConnectionSocketFactory(SSLContexts.createDefault(), x509HostnameVerifier));
            }
            object5 = new PoolingHttpClientConnectionManager(RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", (PlainConnectionSocketFactory)object6).build());
            if (this.defaultSocketConfig != null) {
                ((PoolingHttpClientConnectionManager)object5).setDefaultSocketConfig(this.defaultSocketConfig);
            }
            if (this.defaultConnectionConfig != null) {
                ((PoolingHttpClientConnectionManager)object5).setDefaultConnectionConfig(this.defaultConnectionConfig);
            }
            if (this.systemProperties && "true".equalsIgnoreCase((String)(object4 = System.getProperty("http.keepAlive", "true")))) {
                object4 = System.getProperty("http.maxConnections", "5");
                int n = Integer.parseInt((String)object4);
                ((PoolingHttpClientConnectionManager)object5).setDefaultMaxPerRoute(n);
                ((PoolingHttpClientConnectionManager)object5).setMaxTotal(2 * n);
            }
            if (this.maxConnTotal > 0) {
                ((PoolingHttpClientConnectionManager)object5).setMaxTotal(this.maxConnTotal);
            }
            if (this.maxConnPerRoute > 0) {
                ((PoolingHttpClientConnectionManager)object5).setDefaultMaxPerRoute(this.maxConnPerRoute);
            }
            object7 = object5;
        }
        if ((object6 = this.reuseStrategy) == null) {
            object6 = this.systemProperties ? ("true".equalsIgnoreCase((String)(object5 = System.getProperty("http.keepAlive", "true"))) ? DefaultConnectionReuseStrategy.INSTANCE : NoConnectionReuseStrategy.INSTANCE) : DefaultConnectionReuseStrategy.INSTANCE;
        }
        if ((object5 = this.keepAliveStrategy) == null) {
            object5 = DefaultConnectionKeepAliveStrategy.INSTANCE;
        }
        if ((object4 = this.targetAuthStrategy) == null) {
            object4 = TargetAuthenticationStrategy.INSTANCE;
        }
        if ((authenticationStrategy = this.proxyAuthStrategy) == null) {
            authenticationStrategy = ProxyAuthenticationStrategy.INSTANCE;
        }
        if ((userTokenHandler = this.userTokenHandler) == null) {
            userTokenHandler = !this.connectionStateDisabled ? DefaultUserTokenHandler.INSTANCE : NoopUserTokenHandler.INSTANCE;
        }
        ClientExecChain clientExecChain = new MainClientExec(httpRequestExecutor, (HttpClientConnectionManager)object7, (ConnectionReuseStrategy)object6, (ConnectionKeepAliveStrategy)object5, (AuthenticationStrategy)object4, authenticationStrategy, userTokenHandler);
        clientExecChain = this.decorateMainExec(clientExecChain);
        HttpProcessor httpProcessor = this.httpprocessor;
        if (httpProcessor == null) {
            object3 = this.userAgent;
            if (object3 == null) {
                if (this.systemProperties) {
                    object3 = System.getProperty("http.agent");
                }
                if (object3 == null) {
                    object3 = DEFAULT_USER_AGENT;
                }
            }
            object2 = HttpProcessorBuilder.create();
            if (this.requestFirst != null) {
                for (HttpRequestInterceptor object8 : this.requestFirst) {
                    ((HttpProcessorBuilder)object2).addFirst(object8);
                }
            }
            if (this.responseFirst != null) {
                for (HttpResponseInterceptor httpResponseInterceptor : this.responseFirst) {
                    ((HttpProcessorBuilder)object2).addFirst(httpResponseInterceptor);
                }
            }
            ((HttpProcessorBuilder)object2).addAll(new RequestDefaultHeaders(this.defaultHeaders), new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent((String)object3), new RequestExpectContinue());
            if (!this.cookieManagementDisabled) {
                ((HttpProcessorBuilder)object2).add(new RequestAddCookies());
            }
            if (!this.contentCompressionDisabled) {
                ((HttpProcessorBuilder)object2).add(new RequestAcceptEncoding());
            }
            if (!this.authCachingDisabled) {
                ((HttpProcessorBuilder)object2).add(new RequestAuthCache());
            }
            if (!this.cookieManagementDisabled) {
                ((HttpProcessorBuilder)object2).add(new ResponseProcessCookies());
            }
            if (!this.contentCompressionDisabled) {
                ((HttpProcessorBuilder)object2).add(new ResponseContentEncoding());
            }
            if (this.requestLast != null) {
                for (HttpRequestInterceptor httpRequestInterceptor : this.requestLast) {
                    ((HttpProcessorBuilder)object2).addLast(httpRequestInterceptor);
                }
            }
            if (this.responseLast != null) {
                for (HttpResponseInterceptor httpResponseInterceptor : this.responseLast) {
                    ((HttpProcessorBuilder)object2).addLast(httpResponseInterceptor);
                }
            }
            httpProcessor = ((HttpProcessorBuilder)object2).build();
        }
        clientExecChain = new ProtocolExec(clientExecChain, httpProcessor);
        clientExecChain = this.decorateProtocolExec(clientExecChain);
        if (!this.automaticRetriesDisabled) {
            object3 = this.retryHandler;
            if (object3 == null) {
                object3 = DefaultHttpRequestRetryHandler.INSTANCE;
            }
            clientExecChain = new RetryExec(clientExecChain, (HttpRequestRetryHandler)object3);
        }
        if ((object3 = this.routePlanner) == null) {
            object2 = this.schemePortResolver;
            if (object2 == null) {
                object2 = DefaultSchemePortResolver.INSTANCE;
            }
            object3 = this.proxy != null ? new DefaultProxyRoutePlanner(this.proxy, (SchemePortResolver)object2) : (this.systemProperties ? new SystemDefaultRoutePlanner((SchemePortResolver)object2, ProxySelector.getDefault()) : new DefaultRoutePlanner((SchemePortResolver)object2));
        }
        if (!this.redirectHandlingDisabled) {
            object2 = this.redirectStrategy;
            if (object2 == null) {
                object2 = DefaultRedirectStrategy.INSTANCE;
            }
            clientExecChain = new RedirectExec(clientExecChain, (HttpRoutePlanner)object3, (RedirectStrategy)object2);
        }
        if ((object2 = this.serviceUnavailStrategy) != null) {
            clientExecChain = new ServiceUnavailableRetryExec(clientExecChain, (ServiceUnavailableRetryStrategy)object2);
        }
        Iterator iterator2 = this.backoffManager;
        ConnectionBackoffStrategy connectionBackoffStrategy = this.connectionBackoffStrategy;
        if (iterator2 != null && connectionBackoffStrategy != null) {
            clientExecChain = new BackoffStrategyExec(clientExecChain, connectionBackoffStrategy, (BackoffManager)((Object)iterator2));
        }
        if ((lookup2 = this.authSchemeRegistry) == null) {
            lookup2 = RegistryBuilder.create().register("Basic", new BasicSchemeFactory()).register("Digest", (BasicSchemeFactory)((Object)new DigestSchemeFactory())).register("NTLM", (BasicSchemeFactory)((Object)new NTLMSchemeFactory())).register("negotiate", (BasicSchemeFactory)((Object)new SPNegoSchemeFactory())).register("Kerberos", (BasicSchemeFactory)((Object)new KerberosSchemeFactory())).build();
        }
        if ((lookup = this.cookieSpecRegistry) == null) {
            lookup = RegistryBuilder.create().register("best-match", new BestMatchSpecFactory()).register("standard", (BestMatchSpecFactory)((Object)new RFC2965SpecFactory())).register("compatibility", (BestMatchSpecFactory)((Object)new BrowserCompatSpecFactory())).register("netscape", (BestMatchSpecFactory)((Object)new NetscapeDraftSpecFactory())).register("ignoreCookies", (BestMatchSpecFactory)((Object)new IgnoreSpecFactory())).register("rfc2109", (BestMatchSpecFactory)((Object)new RFC2109SpecFactory())).register("rfc2965", (BestMatchSpecFactory)((Object)new RFC2965SpecFactory())).build();
        }
        if ((cookieStore = this.cookieStore) == null) {
            cookieStore = new BasicCookieStore();
        }
        if ((credentialsProvider = this.credentialsProvider) == null) {
            credentialsProvider = this.systemProperties ? new SystemDefaultCredentialsProvider() : new BasicCredentialsProvider();
        }
        return new InternalHttpClient(clientExecChain, (HttpClientConnectionManager)object7, (HttpRoutePlanner)object3, lookup, lookup2, cookieStore, credentialsProvider, this.defaultRequestConfig != null ? this.defaultRequestConfig : RequestConfig.DEFAULT, (List<Closeable>)(this.closeables != null ? new ArrayList<Closeable>(this.closeables) : null));
    }

    static {
        VersionInfo versionInfo = VersionInfo.loadVersionInfo("org.apache.http.client", HttpClientBuilder.class.getClassLoader());
        String string = versionInfo != null ? versionInfo.getRelease() : "UNAVAILABLE";
        DEFAULT_USER_AGENT = "Apache-HttpClient/" + string + " (java 1.5)";
    }
}

