/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.status.StatusLogger;

public class DatagramOutputStream
extends OutputStream {
    protected static final Logger LOGGER = StatusLogger.getLogger();
    private static final int SHIFT_1 = 8;
    private static final int SHIFT_2 = 16;
    private static final int SHIFT_3 = 24;
    private DatagramSocket ds;
    private final InetAddress address;
    private final int port;
    private byte[] data;
    private final byte[] header;
    private final byte[] footer;

    public DatagramOutputStream(String string, int n, byte[] byArray, byte[] byArray2) {
        this.port = n;
        this.header = byArray;
        this.footer = byArray2;
        try {
            this.address = InetAddress.getByName(string);
        }
        catch (UnknownHostException unknownHostException) {
            String string2 = "Could not find host " + string;
            LOGGER.error(string2, (Throwable)unknownHostException);
            throw new AppenderLoggingException(string2, unknownHostException);
        }
        try {
            this.ds = new DatagramSocket();
        }
        catch (SocketException socketException) {
            String string3 = "Could not instantiate DatagramSocket to " + string;
            LOGGER.error(string3, (Throwable)socketException);
            throw new AppenderLoggingException(string3, socketException);
        }
    }

    @Override
    public synchronized void write(byte[] byArray, int n, int n2) throws IOException {
        this.copy(byArray, n, n2);
    }

    @Override
    public synchronized void write(int n) throws IOException {
        this.copy(new byte[]{(byte)(n >>> 24), (byte)(n >>> 16), (byte)(n >>> 8), (byte)n}, 0, 4);
    }

    @Override
    public synchronized void write(byte[] byArray) throws IOException {
        this.copy(byArray, 0, byArray.length);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void flush() throws IOException {
        try {
            if (this.data != null && this.ds != null && this.address != null) {
                if (this.footer != null) {
                    this.copy(this.footer, 0, this.footer.length);
                }
                DatagramPacket datagramPacket = new DatagramPacket(this.data, this.data.length, this.address, this.port);
                this.ds.send(datagramPacket);
            }
        }
        finally {
            this.data = null;
            if (this.header != null) {
                this.copy(this.header, 0, this.header.length);
            }
        }
    }

    @Override
    public synchronized void close() throws IOException {
        if (this.ds != null) {
            if (this.data != null) {
                this.flush();
            }
            this.ds.close();
            this.ds = null;
        }
    }

    private void copy(byte[] byArray, int n, int n2) {
        int n3 = this.data == null ? 0 : this.data.length;
        byte[] byArray2 = new byte[n2 + n3];
        if (this.data != null) {
            System.arraycopy(this.data, 0, byArray2, 0, this.data.length);
        }
        System.arraycopy(byArray, n, byArray2, n3, n2);
        this.data = byArray2;
    }
}

