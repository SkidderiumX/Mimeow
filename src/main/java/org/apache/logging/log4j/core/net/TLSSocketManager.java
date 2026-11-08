/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.helpers.Strings;
import org.apache.logging.log4j.core.net.TCPSocketManager;
import org.apache.logging.log4j.core.net.ssl.SSLConfiguration;

public class TLSSocketManager
extends TCPSocketManager {
    public static final int DEFAULT_PORT = 6514;
    private static final TLSSocketManagerFactory FACTORY = new TLSSocketManagerFactory();
    private SSLConfiguration sslConfig;

    public TLSSocketManager(String string, OutputStream outputStream2, Socket socket, SSLConfiguration sSLConfiguration, InetAddress inetAddress, String string2, int n, int n2, boolean bl, Layout layout) {
        super(string, outputStream2, socket, inetAddress, string2, n, n2, bl, layout);
        this.sslConfig = sSLConfiguration;
    }

    public static TLSSocketManager getSocketManager(SSLConfiguration sSLConfiguration, String string, int n, int n2, boolean bl, Layout layout) {
        if (Strings.isEmpty(string)) {
            throw new IllegalArgumentException("A host name is required");
        }
        if (n <= 0) {
            n = 6514;
        }
        if (n2 == 0) {
            n2 = 30000;
        }
        return (TLSSocketManager)TLSSocketManager.getManager("TLS:" + string + ":" + n, new TLSFactoryData(sSLConfiguration, string, n, n2, bl, layout), FACTORY);
    }

    @Override
    protected Socket createSocket(String string, int n) throws IOException {
        SSLSocketFactory sSLSocketFactory = TLSSocketManager.createSSLSocketFactory(this.sslConfig);
        return sSLSocketFactory.createSocket(string, n);
    }

    private static SSLSocketFactory createSSLSocketFactory(SSLConfiguration sSLConfiguration) {
        SSLSocketFactory sSLSocketFactory = sSLConfiguration != null ? sSLConfiguration.getSSLSocketFactory() : (SSLSocketFactory)SSLSocketFactory.getDefault();
        return sSLSocketFactory;
    }

    private static class TLSSocketManagerFactory
    implements ManagerFactory<TLSSocketManager, TLSFactoryData> {
        private TLSSocketManagerFactory() {
        }

        @Override
        public TLSSocketManager createManager(String string, TLSFactoryData tLSFactoryData) {
            InetAddress inetAddress = null;
            OutputStream outputStream2 = null;
            Socket socket = null;
            try {
                inetAddress = this.resolveAddress(tLSFactoryData.host);
                socket = this.createSocket(tLSFactoryData);
                outputStream2 = socket.getOutputStream();
                this.checkDelay(tLSFactoryData.delay, outputStream2);
            }
            catch (IOException iOException) {
                LOGGER.error("TLSSocketManager (" + string + ") " + iOException);
                outputStream2 = new ByteArrayOutputStream();
            }
            catch (TLSSocketManagerFactoryException tLSSocketManagerFactoryException) {
                return null;
            }
            return this.createManager(string, outputStream2, socket, tLSFactoryData.sslConfig, inetAddress, tLSFactoryData.host, tLSFactoryData.port, tLSFactoryData.delay, tLSFactoryData.immediateFail, tLSFactoryData.layout);
        }

        private InetAddress resolveAddress(String string) throws TLSSocketManagerFactoryException {
            InetAddress inetAddress;
            try {
                inetAddress = InetAddress.getByName(string);
            }
            catch (UnknownHostException unknownHostException) {
                LOGGER.error("Could not find address of " + string, (Throwable)unknownHostException);
                throw new TLSSocketManagerFactoryException();
            }
            return inetAddress;
        }

        private void checkDelay(int n, OutputStream outputStream2) throws TLSSocketManagerFactoryException {
            if (n == 0 && outputStream2 == null) {
                throw new TLSSocketManagerFactoryException();
            }
        }

        private Socket createSocket(TLSFactoryData tLSFactoryData) throws IOException {
            SSLSocketFactory sSLSocketFactory = TLSSocketManager.createSSLSocketFactory(tLSFactoryData.sslConfig);
            SSLSocket sSLSocket = (SSLSocket)sSLSocketFactory.createSocket(tLSFactoryData.host, tLSFactoryData.port);
            return sSLSocket;
        }

        private TLSSocketManager createManager(String string, OutputStream outputStream2, Socket socket, SSLConfiguration sSLConfiguration, InetAddress inetAddress, String string2, int n, int n2, boolean bl, Layout layout) {
            return new TLSSocketManager(string, outputStream2, socket, sSLConfiguration, inetAddress, string2, n, n2, bl, layout);
        }

        private class TLSSocketManagerFactoryException
        extends Exception {
            private TLSSocketManagerFactoryException() {
            }
        }
    }

    private static class TLSFactoryData {
        protected SSLConfiguration sslConfig;
        private final String host;
        private final int port;
        private final int delay;
        private final boolean immediateFail;
        private final Layout layout;

        public TLSFactoryData(SSLConfiguration sSLConfiguration, String string, int n, int n2, boolean bl, Layout layout) {
            this.host = string;
            this.port = n;
            this.delay = n2;
            this.immediateFail = bl;
            this.layout = layout;
            this.sslConfig = sSLConfiguration;
        }
    }
}

