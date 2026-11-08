/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.ssl;

import io.netty.handler.ssl.JettyNpnSslSession;
import java.nio.ByteBuffer;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import org.eclipse.jetty.npn.NextProtoNego;

public class JettyNpnSslEngine
extends SSLEngine {
    private static boolean available;
    private final SSLEngine engine;
    private final JettyNpnSslSession session;

    static boolean isAvailable() {
        JettyNpnSslEngine.updateAvailability();
        return available;
    }

    private static void updateAvailability() {
        if (available) {
            return;
        }
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader().getParent();
            if (classLoader == null) {
                classLoader = ClassLoader.getSystemClassLoader();
            }
            Class.forName("sun.security.ssl.NextProtoNegoExtension", true, classLoader);
            available = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    JettyNpnSslEngine(SSLEngine sSLEngine, final List<String> list, boolean bl) {
        assert (!list.isEmpty());
        this.engine = sSLEngine;
        this.session = new JettyNpnSslSession(sSLEngine);
        if (bl) {
            NextProtoNego.put((SSLEngine)sSLEngine, (NextProtoNego.Provider)new NextProtoNego.ServerProvider(){

                public void unsupported() {
                    JettyNpnSslEngine.this.getSession().setApplicationProtocol((String)list.get(list.size() - 1));
                }

                public List<String> protocols() {
                    return list;
                }

                public void protocolSelected(String string) {
                    JettyNpnSslEngine.this.getSession().setApplicationProtocol(string);
                }
            });
        } else {
            final String[] stringArray = list.toArray(new String[list.size()]);
            final String string = stringArray[stringArray.length - 1];
            NextProtoNego.put((SSLEngine)sSLEngine, (NextProtoNego.Provider)new NextProtoNego.ClientProvider(){

                public boolean supports() {
                    return true;
                }

                public void unsupported() {
                    JettyNpnSslEngine.this.session.setApplicationProtocol(null);
                }

                public String selectProtocol(List<String> list) {
                    for (String string2 : stringArray) {
                        if (!list.contains(string2)) continue;
                        return string2;
                    }
                    return string;
                }
            });
        }
    }

    @Override
    public JettyNpnSslSession getSession() {
        return this.session;
    }

    @Override
    public void closeInbound() throws SSLException {
        NextProtoNego.remove((SSLEngine)this.engine);
        this.engine.closeInbound();
    }

    @Override
    public void closeOutbound() {
        NextProtoNego.remove((SSLEngine)this.engine);
        this.engine.closeOutbound();
    }

    @Override
    public String getPeerHost() {
        return this.engine.getPeerHost();
    }

    @Override
    public int getPeerPort() {
        return this.engine.getPeerPort();
    }

    @Override
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.engine.wrap(byteBuffer, byteBuffer2);
    }

    @Override
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArray, ByteBuffer byteBuffer) throws SSLException {
        return this.engine.wrap(byteBufferArray, byteBuffer);
    }

    @Override
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArray, int n, int n2, ByteBuffer byteBuffer) throws SSLException {
        return this.engine.wrap(byteBufferArray, n, n2, byteBuffer);
    }

    @Override
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBuffer2);
    }

    @Override
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArray) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBufferArray);
    }

    @Override
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArray, int n, int n2) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBufferArray, n, n2);
    }

    @Override
    public Runnable getDelegatedTask() {
        return this.engine.getDelegatedTask();
    }

    @Override
    public boolean isInboundDone() {
        return this.engine.isInboundDone();
    }

    @Override
    public boolean isOutboundDone() {
        return this.engine.isOutboundDone();
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return this.engine.getSupportedCipherSuites();
    }

    @Override
    public String[] getEnabledCipherSuites() {
        return this.engine.getEnabledCipherSuites();
    }

    @Override
    public void setEnabledCipherSuites(String[] stringArray) {
        this.engine.setEnabledCipherSuites(stringArray);
    }

    @Override
    public String[] getSupportedProtocols() {
        return this.engine.getSupportedProtocols();
    }

    @Override
    public String[] getEnabledProtocols() {
        return this.engine.getEnabledProtocols();
    }

    @Override
    public void setEnabledProtocols(String[] stringArray) {
        this.engine.setEnabledProtocols(stringArray);
    }

    @Override
    public SSLSession getHandshakeSession() {
        return this.engine.getHandshakeSession();
    }

    @Override
    public void beginHandshake() throws SSLException {
        this.engine.beginHandshake();
    }

    @Override
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return this.engine.getHandshakeStatus();
    }

    @Override
    public void setUseClientMode(boolean bl) {
        this.engine.setUseClientMode(bl);
    }

    @Override
    public boolean getUseClientMode() {
        return this.engine.getUseClientMode();
    }

    @Override
    public void setNeedClientAuth(boolean bl) {
        this.engine.setNeedClientAuth(bl);
    }

    @Override
    public boolean getNeedClientAuth() {
        return this.engine.getNeedClientAuth();
    }

    @Override
    public void setWantClientAuth(boolean bl) {
        this.engine.setWantClientAuth(bl);
    }

    @Override
    public boolean getWantClientAuth() {
        return this.engine.getWantClientAuth();
    }

    @Override
    public void setEnableSessionCreation(boolean bl) {
        this.engine.setEnableSessionCreation(bl);
    }

    @Override
    public boolean getEnableSessionCreation() {
        return this.engine.getEnableSessionCreation();
    }

    @Override
    public SSLParameters getSSLParameters() {
        return this.engine.getSSLParameters();
    }

    @Override
    public void setSSLParameters(SSLParameters sSLParameters) {
        this.engine.setSSLParameters(sSLParameters);
    }
}

