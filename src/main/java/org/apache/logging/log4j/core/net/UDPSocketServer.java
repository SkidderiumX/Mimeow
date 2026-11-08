/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.AbstractServer;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.XMLConfiguration;
import org.apache.logging.log4j.core.config.XMLConfigurationFactory;

public class UDPSocketServer
extends AbstractServer
implements Runnable {
    private final Logger logger;
    private static final int MAX_PORT = 65534;
    private volatile boolean isActive = true;
    private final DatagramSocket server;
    private final int maxBufferSize = 67584;

    public UDPSocketServer(int n) throws IOException {
        this.server = new DatagramSocket(n);
        this.logger = LogManager.getLogger(this.getClass().getName() + '.' + n);
    }

    public static void main(String[] stringArray) throws Exception {
        String string;
        if (stringArray.length < 1 || stringArray.length > 2) {
            System.err.println("Incorrect number of arguments");
            UDPSocketServer.printUsage();
            return;
        }
        int n = Integer.parseInt(stringArray[0]);
        if (n <= 0 || n >= 65534) {
            System.err.println("Invalid port number");
            UDPSocketServer.printUsage();
            return;
        }
        if (stringArray.length == 2 && stringArray[1].length() > 0) {
            ConfigurationFactory.setConfigurationFactory(new ServerConfigurationFactory(stringArray[1]));
        }
        UDPSocketServer uDPSocketServer = new UDPSocketServer(n);
        Thread thread2 = new Thread(uDPSocketServer);
        thread2.start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (!((string = bufferedReader.readLine()) == null || string.equalsIgnoreCase("Quit") || string.equalsIgnoreCase("Stop") || string.equalsIgnoreCase("Exit"))) {
        }
        uDPSocketServer.shutdown();
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
                byte[] byArray = new byte[67584];
                DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length);
                this.server.receive(datagramPacket);
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength()));
                LogEvent logEvent = (LogEvent)objectInputStream.readObject();
                if (logEvent == null) continue;
                this.log(logEvent);
            }
            catch (OptionalDataException optionalDataException) {
                this.logger.error("OptionalDataException eof=" + optionalDataException.eof + " length=" + optionalDataException.length, (Throwable)optionalDataException);
            }
            catch (ClassNotFoundException classNotFoundException) {
                this.logger.error("Unable to locate LogEvent class", (Throwable)classNotFoundException);
            }
            catch (EOFException eOFException) {
                this.logger.info("EOF encountered");
            }
            catch (IOException iOException) {
                this.logger.error("Exception encountered on accept. Ignoring. Stack Trace :", (Throwable)iOException);
            }
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
}

