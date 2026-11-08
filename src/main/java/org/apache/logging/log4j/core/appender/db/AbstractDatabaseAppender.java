/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.logging.log4j.LoggingException;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.AbstractManager;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseManager;

public abstract class AbstractDatabaseAppender<T extends AbstractDatabaseManager>
extends AbstractAppender {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = this.lock.readLock();
    private final Lock writeLock = this.lock.writeLock();
    private T manager;

    protected AbstractDatabaseAppender(String string, Filter filter, boolean bl, T t) {
        super(string, filter, null, bl);
        this.manager = t;
    }

    public final Layout<LogEvent> getLayout() {
        return null;
    }

    public final T getManager() {
        return this.manager;
    }

    @Override
    public final void start() {
        if (this.getManager() == null) {
            LOGGER.error("No AbstractDatabaseManager set for the appender named [{}].", this.getName());
        }
        super.start();
        if (this.getManager() != null) {
            ((AbstractDatabaseManager)this.getManager()).connect();
        }
    }

    @Override
    public final void stop() {
        super.stop();
        if (this.getManager() != null) {
            ((AbstractManager)this.getManager()).release();
        }
    }

    @Override
    public final void append(LogEvent logEvent) {
        this.readLock.lock();
        try {
            ((AbstractDatabaseManager)this.getManager()).write(logEvent);
        }
        catch (LoggingException loggingException) {
            LOGGER.error("Unable to write to database [{}] for appender [{}].", ((AbstractManager)this.getManager()).getName(), this.getName(), loggingException);
            throw loggingException;
        }
        catch (Exception exception) {
            LOGGER.error("Unable to write to database [{}] for appender [{}].", ((AbstractManager)this.getManager()).getName(), this.getName(), exception);
            throw new AppenderLoggingException("Unable to write to database in appender: " + exception.getMessage(), exception);
        }
        finally {
            this.readLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final void replaceManager(T t) {
        this.writeLock.lock();
        try {
            T t2 = this.getManager();
            if (!((AbstractDatabaseManager)t).isConnected()) {
                ((AbstractDatabaseManager)t).connect();
            }
            this.manager = t;
            ((AbstractManager)t2).release();
        }
        finally {
            this.writeLock.unlock();
        }
    }
}

