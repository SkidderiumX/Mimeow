/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.JettyNpnSslEngine;
import io.netty.handler.ssl.SslContext;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSessionContext;

public abstract class JdkSslContext
extends SslContext {
    private static final InternalLogger logger;
    static final String PROTOCOL = "TLS";
    static final String[] PROTOCOLS;
    static final List<String> DEFAULT_CIPHERS;
    private final String[] cipherSuites;
    private final List<String> unmodifiableCipherSuites;

    private static void addIfSupported(String[] stringArray, List<String> list, String ... stringArray2) {
        block0: for (String string : stringArray2) {
            for (String string2 : stringArray) {
                if (!string.equals(string2)) continue;
                list.add(string2);
                continue block0;
            }
        }
    }

    JdkSslContext(Iterable<String> iterable) {
        this.cipherSuites = JdkSslContext.toCipherSuiteArray(iterable);
        this.unmodifiableCipherSuites = Collections.unmodifiableList(Arrays.asList(this.cipherSuites));
    }

    public abstract SSLContext context();

    public final SSLSessionContext sessionContext() {
        if (this.isServer()) {
            return this.context().getServerSessionContext();
        }
        return this.context().getClientSessionContext();
    }

    @Override
    public final List<String> cipherSuites() {
        return this.unmodifiableCipherSuites;
    }

    @Override
    public final long sessionCacheSize() {
        return this.sessionContext().getSessionCacheSize();
    }

    @Override
    public final long sessionTimeout() {
        return this.sessionContext().getSessionTimeout();
    }

    @Override
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        SSLEngine sSLEngine = this.context().createSSLEngine();
        sSLEngine.setEnabledCipherSuites(this.cipherSuites);
        sSLEngine.setEnabledProtocols(PROTOCOLS);
        sSLEngine.setUseClientMode(this.isClient());
        return this.wrapEngine(sSLEngine);
    }

    @Override
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String string, int n) {
        SSLEngine sSLEngine = this.context().createSSLEngine(string, n);
        sSLEngine.setEnabledCipherSuites(this.cipherSuites);
        sSLEngine.setEnabledProtocols(PROTOCOLS);
        sSLEngine.setUseClientMode(this.isClient());
        return this.wrapEngine(sSLEngine);
    }

    private SSLEngine wrapEngine(SSLEngine sSLEngine) {
        if (this.nextProtocols().isEmpty()) {
            return sSLEngine;
        }
        return new JettyNpnSslEngine(sSLEngine, this.nextProtocols(), this.isServer());
    }

    private static String[] toCipherSuiteArray(Iterable<String> iterable) {
        if (iterable == null) {
            return DEFAULT_CIPHERS.toArray(new String[DEFAULT_CIPHERS.size()]);
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string : iterable) {
            if (string == null) break;
            arrayList.add(string);
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    static {
        SSLContext sSLContext;
        logger = InternalLoggerFactory.getInstance(JdkSslContext.class);
        try {
            sSLContext = SSLContext.getInstance(PROTOCOL);
            sSLContext.init(null, null, null);
        }
        catch (Exception exception) {
            throw new Error("failed to initialize the default SSL context", exception);
        }
        SSLEngine sSLEngine = sSLContext.createSSLEngine();
        String[] stringArray = sSLEngine.getSupportedProtocols();
        ArrayList<String> arrayList = new ArrayList<String>();
        JdkSslContext.addIfSupported(stringArray, arrayList, "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3");
        PROTOCOLS = !arrayList.isEmpty() ? arrayList.toArray(new String[arrayList.size()]) : sSLEngine.getEnabledProtocols();
        String[] stringArray2 = sSLEngine.getSupportedCipherSuites();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        JdkSslContext.addIfSupported(stringArray2, arrayList2, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_RC4_128_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_GCM_SHA256", "SSL_RSA_WITH_RC4_128_SHA", "SSL_RSA_WITH_RC4_128_MD5", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "SSL_RSA_WITH_DES_CBC_SHA");
        DEFAULT_CIPHERS = !arrayList2.isEmpty() ? Collections.unmodifiableList(arrayList2) : Collections.unmodifiableList(Arrays.asList(sSLEngine.getEnabledCipherSuites()));
        if (logger.isDebugEnabled()) {
            logger.debug("Default protocols (JDK): {} ", (Object)Arrays.asList(PROTOCOLS));
            logger.debug("Default cipher suites (JDK): {}", (Object)DEFAULT_CIPHERS);
        }
    }
}

