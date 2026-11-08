/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.OutputStreamManager;

public abstract class AbstractOutputStreamAppender
extends AbstractAppender {
    protected final boolean immediateFlush;
    private volatile OutputStreamManager manager;
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = this.rwLock.readLock();
    private final Lock writeLock = this.rwLock.writeLock();

    protected AbstractOutputStreamAppender(String string, Layout<? extends Serializable> layout, Filter filter, boolean bl, boolean bl2, OutputStreamManager outputStreamManager) {
        super(string, filter, layout, bl);
        this.manager = outputStreamManager;
        this.immediateFlush = bl2;
    }

    protected OutputStreamManager getManager() {
        return this.manager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void replaceManager(OutputStreamManager outputStreamManager) {
        this.writeLock.lock();
        try {
            OutputStreamManager outputStreamManager2 = this.manager;
            this.manager = outputStreamManager;
            outputStreamManager2.release();
        }
        finally {
            this.writeLock.unlock();
        }
    }

    @Override
    public void start() {
        if (this.getLayout() == null) {
            LOGGER.error("No layout set for the appender named [" + this.getName() + "].");
        }
        if (this.manager == null) {
            LOGGER.error("No OutputStreamManager set for the appender named [" + this.getName() + "].");
        }
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        this.manager.release();
    }

    @Override
    public void append(LogEvent logEvent) {
        this.readLock.lock();
        try {
            byte[] byArray = this.getLayout().toByteArray(logEvent);
            if (byArray.length > 0) {
                this.manager.write(byArray);
                if (this.immediateFlush || logEvent.isEndOfBatch()) {
                    this.manager.flush();
                }
            }
        }
        catch (AppenderLoggingException appenderLoggingException) {
            this.error("Unable to write to stream " + this.manager.getName() + " for appender " + this.getName());
            throw appenderLoggingException;
        }
        finally {
            this.readLock.unlock();
        }
    }
}

