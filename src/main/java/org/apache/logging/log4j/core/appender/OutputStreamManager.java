/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.AbstractManager;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;

public class OutputStreamManager
extends AbstractManager {
    private volatile OutputStream os;
    private final byte[] footer;
    private final byte[] header;

    protected OutputStreamManager(OutputStream outputStream2, String string, Layout<?> layout) {
        super(string);
        this.os = outputStream2;
        if (layout != null) {
            this.footer = layout.getFooter();
            this.header = layout.getHeader();
            if (this.header != null) {
                try {
                    this.os.write(this.header, 0, this.header.length);
                }
                catch (IOException iOException) {
                    LOGGER.error("Unable to write header", (Throwable)iOException);
                }
            }
        } else {
            this.footer = null;
            this.header = null;
        }
    }

    public static <T> OutputStreamManager getManager(String string, T t, ManagerFactory<? extends OutputStreamManager, T> managerFactory) {
        return AbstractManager.getManager(string, managerFactory, t);
    }

    @Override
    public void releaseSub() {
        if (this.footer != null) {
            this.write(this.footer);
        }
        this.close();
    }

    public boolean isOpen() {
        return this.getCount() > 0;
    }

    protected OutputStream getOutputStream() {
        return this.os;
    }

    protected void setOutputStream(OutputStream outputStream2) {
        if (this.header != null) {
            try {
                outputStream2.write(this.header, 0, this.header.length);
                this.os = outputStream2;
            }
            catch (IOException iOException) {
                LOGGER.error("Unable to write header", (Throwable)iOException);
            }
        } else {
            this.os = outputStream2;
        }
    }

    protected synchronized void write(byte[] byArray, int n, int n2) {
        try {
            this.os.write(byArray, n, n2);
        }
        catch (IOException iOException) {
            String string = "Error writing to stream " + this.getName();
            throw new AppenderLoggingException(string, iOException);
        }
    }

    protected void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
    }

    protected synchronized void close() {
        OutputStream outputStream2 = this.os;
        if (outputStream2 == System.out || outputStream2 == System.err) {
            return;
        }
        try {
            outputStream2.close();
        }
        catch (IOException iOException) {
            LOGGER.error("Unable to close stream " + this.getName() + ". " + iOException);
        }
    }

    public synchronized void flush() {
        try {
            this.os.flush();
        }
        catch (IOException iOException) {
            String string = "Error flushing stream " + this.getName();
            throw new AppenderLoggingException(string, iOException);
        }
    }
}

