/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.AbstractServer;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.XMLConfiguration;
import org.apache.logging.log4j.core.config.XMLConfigurationFactory;

public class SocketServer
extends AbstractServer
implements Runnable {
    private final Logger logger;
    private static final int MAX_PORT = 65534;
    private volatile boolean isActive = true;
    private final ServerSocket server;
    private final ConcurrentMap<Long, SocketHandler> handlers = new ConcurrentHashMap<Long, SocketHandler>();

    public SocketServer(int n) throws IOException {
        this.server = new ServerSocket(n);
        this.logger = LogManager.getLogger(this.getClass().getName() + '.' + n);
    }

    public static void main(String[] stringArray) throws Exception {
        String string;
        if (stringArray.length < 1 || stringArray.length > 2) {
            System.err.println("Incorrect number of arguments");
            SocketServer.printUsage();
            return;
        }
        int n = Integer.parseInt(stringArray[0]);
        if (n <= 0 || n >= 65534) {
            System.err.println("Invalid port number");
            SocketServer.printUsage();
            return;
        }
        if (stringArray.length == 2 && stringArray[1].length() > 0) {
            ConfigurationFactory.setConfigurationFactory(new ServerConfigurationFactory(stringArray[1]));
        }
        SocketServer socketServer = new SocketServer(n);
        Thread thread2 = new Thread(socketServer);
        thread2.start();
        Charset charset = Charset.defaultCharset();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, charset));
        while (!((string = bufferedReader.readLine()) == null || string.equalsIgnoreCase("Quit") || string.equalsIgnoreCase("Stop") || string.equalsIgnoreCase("Exit"))) {
        }
        socketServer.shutdown();
        thread2.join();
    }

    private static void printUsage() {
        System.out.println("Usage: ServerSocket port configFilePath");
    }

    public void shutdown() {
        this.isActive = false;
        Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        while (this.isActive) {
            try {
                Socket socket = this.server.accept();
                socket.setSoLinger(true, 0);
                SocketHandler object = new SocketHandler(socket);
                this.handlers.put(object.getId(), object);
                object.start();
            }
            catch (IOException iOException) {
                System.out.println("Exception encountered on accept. Ignoring. Stack Trace :");
                iOException.printStackTrace();
            }
        }
        for (Map.Entry entry : this.handlers.entrySet()) {
            SocketHandler socketHandler = (SocketHandler)entry.getValue();
            socketHandler.shutdown();
            try {
                socketHandler.join();
            }
            catch (InterruptedException interruptedException) {}
        }
    }

    private static class ServerConfigurationFactory
    extends XMLConfigurationFactory {
        private final String path;

        public ServerConfigurationFactory(String string) {
            this.path = string;
        }

        @Override
        public Configuration getConfiguration(String string, URI uRI) {
            if (this.path != null && this.path.length() > 0) {
                Object object;
                File file = null;
                ConfigurationFactory.ConfigurationSource configurationSource = null;
                try {
                    file = new File(this.path);
                    object = new FileInputStream(file);
                    configurationSource = new ConfigurationFactory.ConfigurationSource((InputStream)object, file);
                }
                catch (FileNotFoundException fileNotFoundException) {
                    // empty catch block
                }
                if (configurationSource == null) {
                    try {
                        object = new URL(this.path);
                        configurationSource = new ConfigurationFactory.ConfigurationSource(((URL)object).openStream(), this.path);
                    }
                    catch (MalformedURLException malformedURLException) {
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                }
                try {
                    if (configurationSource != null) {
                        return new XMLConfiguration(configurationSource);
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                System.err.println("Unable to process configuration at " + this.path + ", using default.");
            }
            return super.getConfiguration(string, uRI);
        }
    }

    private class SocketHandler
    extends Thread {
        private final ObjectInputStream ois;
        private boolean shutdown = false;

        public SocketHandler(Socket socket) throws IOException {
            this.ois = new ObjectInputStream(socket.getInputStream());
        }

        public void shutdown() {
            this.shutdown = true;
            this.interrupt();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void run() {
            boolean bl = false;
            try {
                try {
                    while (!this.shutdown) {
                        LogEvent logEvent = (LogEvent)this.ois.readObject();
                        if (logEvent == null) continue;
                        SocketServer.this.log(logEvent);
                    }
                }
                catch (EOFException eOFException) {
                    bl = true;
                }
                catch (OptionalDataException optionalDataException) {
                    SocketServer.this.logger.error("OptionalDataException eof=" + optionalDataException.eof + " length=" + optionalDataException.length, (Throwable)optionalDataException);
                }
                catch (ClassNotFoundException classNotFoundException) {
                    SocketServer.this.logger.error("Unable to locate LogEvent class", (Throwable)classNotFoundException);
                }
                catch (IOException iOException) {
                    SocketServer.this.logger.error("IOException encountered while reading from socket", (Throwable)iOException);
                }
                if (!bl) {
                    try {
                        this.ois.close();
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            }
            finally {
                SocketServer.this.handlers.remove(this.getId());
            }
        }
    }
}

