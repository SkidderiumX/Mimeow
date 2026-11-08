/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.OutputStreamManager;
import org.apache.logging.log4j.core.helpers.Strings;
import org.apache.logging.log4j.core.net.AbstractSocketManager;

public class TCPSocketManager
extends AbstractSocketManager {
    public static final int DEFAULT_RECONNECTION_DELAY = 30000;
    private static final int DEFAULT_PORT = 4560;
    private static final TCPSocketManagerFactory FACTORY = new TCPSocketManagerFactory();
    private final int reconnectionDelay;
    private Reconnector connector = null;
    private Socket socket;
    private final boolean retry;
    private final boolean immediateFail;

    public TCPSocketManager(String string, OutputStream outputStream2, Socket socket, InetAddress inetAddress, String string2, int n, int n2, boolean bl, Layout<? extends Serializable> layout) {
        super(string, outputStream2, inetAddress, string2, n, layout);
        this.reconnectionDelay = n2;
        this.socket = socket;
        this.immediateFail = bl;
        boolean bl2 = this.retry = n2 > 0;
        if (socket == null) {
            this.connector = new Reconnector(this);
            this.connector.setDaemon(true);
            this.connector.setPriority(1);
            this.connector.start();
        }
    }

    public static TCPSocketManager getSocketManager(String string, int n, int n2, boolean bl, Layout<? extends Serializable> layout) {
        if (Strings.isEmpty(string)) {
            throw new IllegalArgumentException("A host name is required");
        }
        if (n <= 0) {
            n = 4560;
        }
        if (n2 == 0) {
            n2 = 30000;
        }
        return (TCPSocketManager)TCPSocketManager.getManager("TCP:" + string + ":" + n, new FactoryData(string, n, n2, bl, layout), FACTORY);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void write(byte[] byArray, int n, int n2) {
        if (this.socket == null) {
            if (this.connector != null && !this.immediateFail) {
                this.connector.latch();
            }
            if (this.socket == null) {
                String string = "Error writing to " + this.getName() + " socket not available";
                throw new AppenderLoggingException(string);
            }
        }
        TCPSocketManager tCPSocketManager = this;
        synchronized (tCPSocketManager) {
            try {
                this.getOutputStream().write(byArray, n, n2);
            }
            catch (IOException iOException) {
                if (this.retry && this.connector == null) {
                    this.connector = new Reconnector(this);
                    this.connector.setDaemon(true);
                    this.connector.setPriority(1);
                    this.connector.start();
                }
                String string = "Error writing to " + this.getName();
                throw new AppenderLoggingException(string, iOException);
            }
        }
    }

    @Override
    protected synchronized void close() {
        super.close();
        if (this.connector != null) {
            this.connector.shutdown();
            this.connector.interrupt();
            this.connector = null;
        }
    }

    @Override
    public Map<String, String> getContentFormat() {
        HashMap<String, String> hashMap = new HashMap<String, String>(super.getContentFormat());
        hashMap.put("protocol", "tcp");
        hashMap.put("direction", "out");
        return hashMap;
    }

    protected Socket createSocket(InetAddress inetAddress, int n) throws IOException {
        return this.createSocket(inetAddress.getHostName(), n);
    }

    protected Socket createSocket(String string, int n) throws IOException {
        return new Socket(string, n);
    }

    protected static class TCPSocketManagerFactory
    implements ManagerFactory<TCPSocketManager, FactoryData> {
        protected TCPSocketManagerFactory() {
        }

        @Override
        public TCPSocketManager createManager(String string, FactoryData factoryData) {
            InetAddress inetAddress;
            try {
                inetAddress = InetAddress.getByName(factoryData.host);
            }
            catch (UnknownHostException unknownHostException) {
                LOGGER.error("Could not find address of " + factoryData.host, (Throwable)unknownHostException);
                return null;
            }
            try {
                Socket socket = new Socket(factoryData.host, factoryData.port);
                OutputStream outputStream2 = socket.getOutputStream();
                return new TCPSocketManager(string, outputStream2, socket, inetAddress, factoryData.host, factoryData.port, factoryData.delay, factoryData.immediateFail, factoryData.layout);
            }
            catch (IOException iOException) {
                LOGGER.error("TCPSocketManager (" + string + ") " + iOException);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (factoryData.delay == 0) {
                    return null;
                }
                return new TCPSocketManager(string, byteArrayOutputStream, null, inetAddress, factoryData.host, factoryData.port, factoryData.delay, factoryData.immediateFail, factoryData.layout);
            }
        }
    }

    private static class FactoryData {
        private final String host;
        private final int port;
        private final int delay;
        private final boolean immediateFail;
        private final Layout<? extends Serializable> layout;

        public FactoryData(String string, int n, int n2, boolean bl, Layout<? extends Serializable> layout) {
            this.host = string;
            this.port = n;
            this.delay = n2;
            this.immediateFail = bl;
            this.layout = layout;
        }
    }

    private class Reconnector
    extends Thread {
        private final CountDownLatch latch = new CountDownLatch(1);
        private boolean shutdown = false;
        private final Object owner;

        public Reconnector(OutputStreamManager outputStreamManager) {
            this.owner = outputStreamManager;
        }

        public void latch() {
            try {
                this.latch.await();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }

        public void shutdown() {
            this.shutdown = true;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void run() {
            while (!this.shutdown) {
                try {
                    Reconnector.sleep(TCPSocketManager.this.reconnectionDelay);
                    Socket socket = TCPSocketManager.this.createSocket(TCPSocketManager.this.address, TCPSocketManager.this.port);
                    OutputStream outputStream2 = socket.getOutputStream();
                    Object object = this.owner;
                    synchronized (object) {
                        try {
                            TCPSocketManager.this.getOutputStream().close();
                        }
                        catch (IOException iOException) {
                            // empty catch block
                        }
                        TCPSocketManager.this.setOutputStream(outputStream2);
                        TCPSocketManager.this.socket = socket;
                        TCPSocketManager.this.connector = null;
                        this.shutdown = true;
                    }
                    LOGGER.debug("Connection to " + TCPSocketManager.this.host + ":" + TCPSocketManager.this.port + " reestablished.");
                }
                catch (InterruptedException interruptedException) {
                    LOGGER.debug("Reconnection interrupted.");
                }
                catch (ConnectException connectException) {
                    LOGGER.debug(TCPSocketManager.this.host + ":" + TCPSocketManager.this.port + " refused connection");
                }
                catch (IOException iOException) {
                    LOGGER.debug("Unable to reconnect to " + TCPSocketManager.this.host + ":" + TCPSocketManager.this.port);
                }
                finally {
                    this.latch.countDown();
                }
            }
        }
    }
}

