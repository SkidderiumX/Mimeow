/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.status.StatusLogger;

public abstract class AbstractManager {
    protected static final Logger LOGGER = StatusLogger.getLogger();
    private static final Map<String, AbstractManager> MAP = new HashMap<String, AbstractManager>();
    private static final Lock LOCK = new ReentrantLock();
    protected int count;
    private final String name;

    protected AbstractManager(String string) {
        this.name = string;
        LOGGER.debug("Starting {} {}", this.getClass().getSimpleName(), string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static <M extends AbstractManager, T> M getManager(String string, ManagerFactory<M, T> managerFactory, T t) {
        LOCK.lock();
        try {
            AbstractManager abstractManager = MAP.get(string);
            if (abstractManager == null) {
                abstractManager = (AbstractManager)managerFactory.createManager(string, t);
                if (abstractManager == null) {
                    throw new IllegalStateException("Unable to create a manager");
                }
                MAP.put(string, abstractManager);
            }
            ++abstractManager.count;
            AbstractManager abstractManager2 = abstractManager;
            return (M)abstractManager2;
        }
        finally {
            LOCK.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean hasManager(String string) {
        LOCK.lock();
        try {
            boolean bl = MAP.containsKey(string);
            return bl;
        }
        finally {
            LOCK.unlock();
        }
    }

    protected void releaseSub() {
    }

    protected int getCount() {
        return this.count;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void release() {
        LOCK.lock();
        try {
            --this.count;
            if (this.count <= 0) {
                MAP.remove(this.name);
                LOGGER.debug("Shutting down {} {}", this.getClass().getSimpleName(), this.getName());
                this.releaseSub();
            }
        }
        finally {
            LOCK.unlock();
        }
    }

    public String getName() {
        return this.name;
    }

    public Map<String, String> getContentFormat() {
        return new HashMap<String, String>();
    }
}

