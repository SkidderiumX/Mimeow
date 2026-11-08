/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db;

import java.util.ArrayList;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractManager;
import org.apache.logging.log4j.core.appender.ManagerFactory;

public abstract class AbstractDatabaseManager
extends AbstractManager {
    private final ArrayList<LogEvent> buffer;
    private final int bufferSize;
    private boolean connected = false;

    protected AbstractDatabaseManager(String string, int n) {
        super(string);
        this.bufferSize = n;
        this.buffer = new ArrayList(n + 1);
    }

    protected abstract void connectInternal() throws Exception;

    public final synchronized void connect() {
        if (!this.isConnected()) {
            try {
                this.connectInternal();
                this.connected = true;
            }
            catch (Exception exception) {
                LOGGER.error("Could not connect to database using logging manager [{}].", this.getName(), exception);
            }
        }
    }

    protected abstract void disconnectInternal() throws Exception;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final synchronized void disconnect() {
        this.flush();
        if (this.isConnected()) {
            try {
                this.disconnectInternal();
            }
            catch (Exception exception) {
                LOGGER.warn("Error while disconnecting from database using logging manager [{}].", this.getName(), exception);
            }
            finally {
                this.connected = false;
            }
        }
    }

    public final boolean isConnected() {
        return this.connected;
    }

    protected abstract void writeInternal(LogEvent var1);

    public final synchronized void flush() {
        if (this.isConnected() && this.buffer.size() > 0) {
            for (LogEvent logEvent : this.buffer) {
                this.writeInternal(logEvent);
            }
            this.buffer.clear();
        }
    }

    public final synchronized void write(LogEvent logEvent) {
        if (this.bufferSize > 0) {
            this.buffer.add(logEvent);
            if (this.buffer.size() >= this.bufferSize || logEvent.isEndOfBatch()) {
                this.flush();
            }
        } else {
            this.writeInternal(logEvent);
        }
    }

    @Override
    public final void releaseSub() {
        this.disconnect();
    }

    public final String toString() {
        return this.getName();
    }

    protected static <M extends AbstractDatabaseManager, T extends AbstractFactoryData> M getManager(String string, T t, ManagerFactory<M, T> managerFactory) {
        return (M)((AbstractDatabaseManager)AbstractManager.getManager(string, managerFactory, t));
    }

    protected static abstract class AbstractFactoryData {
        private final int bufferSize;

        protected AbstractFactoryData(int n) {
            this.bufferSize = n;
        }

        public int getBufferSize() {
            return this.bufferSize;
        }
    }
}

