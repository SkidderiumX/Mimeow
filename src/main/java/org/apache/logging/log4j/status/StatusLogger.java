/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.status.StatusData;
import org.apache.logging.log4j.status.StatusListener;
import org.apache.logging.log4j.util.PropertiesUtil;

public class StatusLogger
extends AbstractLogger {
    public static final String MAX_STATUS_ENTRIES = "log4j2.status.entries";
    private static final String NOT_AVAIL = "?";
    private static final PropertiesUtil PROPS = new PropertiesUtil("log4j2.StatusLogger.properties");
    private static final int MAX_ENTRIES = PROPS.getIntegerProperty("log4j2.status.entries", 200);
    private static final String DEFAULT_STATUS_LEVEL = PROPS.getStringProperty("log4j2.StatusLogger.level");
    private static final StatusLogger STATUS_LOGGER = new StatusLogger();
    private final SimpleLogger logger;
    private final CopyOnWriteArrayList<StatusListener> listeners = new CopyOnWriteArrayList();
    private final ReentrantReadWriteLock listenersLock = new ReentrantReadWriteLock();
    private final Queue<StatusData> messages = new BoundedQueue<StatusData>(MAX_ENTRIES);
    private final ReentrantLock msgLock = new ReentrantLock();
    private int listenersLevel;

    private StatusLogger() {
        this.logger = new SimpleLogger("StatusLogger", Level.ERROR, false, true, false, false, "", null, PROPS, System.err);
        this.listenersLevel = Level.toLevel(DEFAULT_STATUS_LEVEL, Level.WARN).intLevel();
    }

    public static StatusLogger getLogger() {
        return STATUS_LOGGER;
    }

    public Level getLevel() {
        return this.logger.getLevel();
    }

    public void setLevel(Level level) {
        this.logger.setLevel(level);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerListener(StatusListener statusListener) {
        this.listenersLock.writeLock().lock();
        try {
            this.listeners.add(statusListener);
            Level level = statusListener.getStatusLevel();
            if (this.listenersLevel < level.intLevel()) {
                this.listenersLevel = level.intLevel();
            }
        }
        finally {
            this.listenersLock.writeLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(StatusListener statusListener) {
        this.listenersLock.writeLock().lock();
        try {
            this.listeners.remove(statusListener);
            int n = Level.toLevel(DEFAULT_STATUS_LEVEL, Level.WARN).intLevel();
            for (StatusListener statusListener2 : this.listeners) {
                int n2 = statusListener2.getStatusLevel().intLevel();
                if (n >= n2) continue;
                n = n2;
            }
            this.listenersLevel = n;
        }
        finally {
            this.listenersLock.writeLock().unlock();
        }
    }

    public Iterator<StatusListener> getListeners() {
        return this.listeners.iterator();
    }

    public void reset() {
        this.listeners.clear();
        this.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List<StatusData> getStatusData() {
        this.msgLock.lock();
        try {
            ArrayList<StatusData> arrayList = new ArrayList<StatusData>(this.messages);
            return arrayList;
        }
        finally {
            this.msgLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear() {
        this.msgLock.lock();
        try {
            this.messages.clear();
        }
        finally {
            this.msgLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void log(Marker marker, String string, Level level, Message message, Throwable throwable) {
        StackTraceElement stackTraceElement = null;
        if (string != null) {
            stackTraceElement = this.getStackTraceElement(string, Thread.currentThread().getStackTrace());
        }
        StatusData statusData = new StatusData(stackTraceElement, level, message, throwable);
        this.msgLock.lock();
        try {
            this.messages.add(statusData);
        }
        finally {
            this.msgLock.unlock();
        }
        if (this.listeners.size() > 0) {
            for (StatusListener statusListener : this.listeners) {
                if (!statusData.getLevel().isAtLeastAsSpecificAs(statusListener.getStatusLevel())) continue;
                statusListener.log(statusData);
            }
        } else {
            this.logger.log(marker, string, level, message, throwable);
        }
    }

    private StackTraceElement getStackTraceElement(String string, StackTraceElement[] stackTraceElementArray) {
        if (string == null) {
            return null;
        }
        boolean bl = false;
        for (StackTraceElement stackTraceElement : stackTraceElementArray) {
            if (bl) {
                return stackTraceElement;
            }
            String string2 = stackTraceElement.getClassName();
            if (string.equals(string2)) {
                bl = true;
                continue;
            }
            if (NOT_AVAIL.equals(string2)) break;
        }
        return null;
    }

    @Override
    protected boolean isEnabled(Level level, Marker marker, String string) {
        return this.isEnabled(level, marker);
    }

    @Override
    protected boolean isEnabled(Level level, Marker marker, String string, Throwable throwable) {
        return this.isEnabled(level, marker);
    }

    @Override
    protected boolean isEnabled(Level level, Marker marker, String string, Object ... objectArray) {
        return this.isEnabled(level, marker);
    }

    @Override
    protected boolean isEnabled(Level level, Marker marker, Object object, Throwable throwable) {
        return this.isEnabled(level, marker);
    }

    @Override
    protected boolean isEnabled(Level level, Marker marker, Message message, Throwable throwable) {
        return this.isEnabled(level, marker);
    }

    @Override
    public boolean isEnabled(Level level, Marker marker) {
        if (this.listeners.size() > 0) {
            return this.listenersLevel >= level.intLevel();
        }
        switch (level) {
            case FATAL: {
                return this.logger.isFatalEnabled(marker);
            }
            case TRACE: {
                return this.logger.isTraceEnabled(marker);
            }
            case DEBUG: {
                return this.logger.isDebugEnabled(marker);
            }
            case INFO: {
                return this.logger.isInfoEnabled(marker);
            }
            case WARN: {
                return this.logger.isWarnEnabled(marker);
            }
            case ERROR: {
                return this.logger.isErrorEnabled(marker);
            }
        }
        return false;
    }

    private class BoundedQueue<E>
    extends ConcurrentLinkedQueue<E> {
        private static final long serialVersionUID = -3945953719763255337L;
        private final int size;

        public BoundedQueue(int n) {
            this.size = n;
        }

        @Override
        public boolean add(E e) {
            while (StatusLogger.this.messages.size() > this.size) {
                StatusLogger.this.messages.poll();
            }
            return super.add(e);
        }
    }
}

