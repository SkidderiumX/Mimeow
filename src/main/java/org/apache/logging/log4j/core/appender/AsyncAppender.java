/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.AppenderControl;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationException;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAliases;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;

@Plugin(name="Async", category="Core", elementType="appender", printObject=true)
public class AsyncAppender
extends AbstractAppender {
    private static final int DEFAULT_QUEUE_SIZE = 128;
    private static final String SHUTDOWN = "Shutdown";
    private final BlockingQueue<Serializable> queue;
    private final boolean blocking;
    private final Configuration config;
    private final AppenderRef[] appenderRefs;
    private final String errorRef;
    private final boolean includeLocation;
    private AppenderControl errorAppender;
    private AsyncThread thread;
    private static final AtomicLong threadSequence = new AtomicLong(1L);

    private AsyncAppender(String string, Filter filter, AppenderRef[] appenderRefArray, String string2, int n, boolean bl, boolean bl2, Configuration configuration, boolean bl3) {
        super(string, filter, null, bl2);
        this.queue = new ArrayBlockingQueue<Serializable>(n);
        this.blocking = bl;
        this.config = configuration;
        this.appenderRefs = appenderRefArray;
        this.errorRef = string2;
        this.includeLocation = bl3;
    }

    @Override
    public void start() {
        Map<String, Appender> map = this.config.getAppenders();
        ArrayList<AppenderControl> arrayList = new ArrayList<AppenderControl>();
        for (AppenderRef appenderRef : this.appenderRefs) {
            if (map.containsKey(appenderRef.getRef())) {
                arrayList.add(new AppenderControl(map.get(appenderRef.getRef()), appenderRef.getLevel(), appenderRef.getFilter()));
                continue;
            }
            LOGGER.error("No appender named {} was configured", appenderRef);
        }
        if (this.errorRef != null) {
            if (map.containsKey(this.errorRef)) {
                this.errorAppender = new AppenderControl(map.get(this.errorRef), null, null);
            } else {
                LOGGER.error("Unable to set up error Appender. No appender named {} was configured", this.errorRef);
            }
        }
        if (arrayList.size() > 0) {
            this.thread = new AsyncThread(arrayList, this.queue);
            this.thread.setName("AsyncAppender-" + this.getName());
        } else if (this.errorRef == null) {
            throw new ConfigurationException("No appenders are available for AsyncAppender " + this.getName());
        }
        this.thread.start();
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        this.thread.shutdown();
        try {
            this.thread.join();
        }
        catch (InterruptedException interruptedException) {
            LOGGER.warn("Interrupted while stopping AsyncAppender {}", this.getName());
        }
    }

    @Override
    public void append(LogEvent logEvent) {
        if (!this.isStarted()) {
            throw new IllegalStateException("AsyncAppender " + this.getName() + " is not active");
        }
        if (logEvent instanceof Log4jLogEvent) {
            boolean bl = false;
            if (this.blocking) {
                try {
                    this.queue.put(Log4jLogEvent.serialize((Log4jLogEvent)logEvent, this.includeLocation));
                    bl = true;
                }
                catch (InterruptedException interruptedException) {
                    LOGGER.warn("Interrupted while waiting for a free slot in the AsyncAppender LogEvent-queue {}", this.getName());
                }
            } else {
                bl = this.queue.offer(Log4jLogEvent.serialize((Log4jLogEvent)logEvent, this.includeLocation));
                if (!bl) {
                    this.error("Appender " + this.getName() + " is unable to write primary appenders. queue is full");
                }
            }
            if (!bl && this.errorAppender != null) {
                this.errorAppender.callAppender(logEvent);
            }
        }
    }

    @PluginFactory
    public static AsyncAppender createAppender(@PluginElement(value="AppenderRef") AppenderRef[] appenderRefArray, @PluginAttribute(value="errorRef") @PluginAliases(value={"error-ref"}) String string, @PluginAttribute(value="blocking") String string2, @PluginAttribute(value="bufferSize") String string3, @PluginAttribute(value="name") String string4, @PluginAttribute(value="includeLocation") String string5, @PluginElement(value="Filter") Filter filter, @PluginConfiguration Configuration configuration, @PluginAttribute(value="ignoreExceptions") String string6) {
        if (string4 == null) {
            LOGGER.error("No name provided for AsyncAppender");
            return null;
        }
        if (appenderRefArray == null) {
            LOGGER.error("No appender references provided to AsyncAppender {}", string4);
        }
        boolean bl = Booleans.parseBoolean(string2, true);
        int n = AbstractAppender.parseInt(string3, 128);
        boolean bl2 = Boolean.parseBoolean(string5);
        boolean bl3 = Booleans.parseBoolean(string6, true);
        return new AsyncAppender(string4, filter, appenderRefArray, string, n, bl, bl3, configuration, bl2);
    }

    private class AsyncThread
    extends Thread {
        private volatile boolean shutdown = false;
        private final List<AppenderControl> appenders;
        private final BlockingQueue<Serializable> queue;

        public AsyncThread(List<AppenderControl> list, BlockingQueue<Serializable> blockingQueue) {
            this.appenders = list;
            this.queue = blockingQueue;
            this.setDaemon(true);
            this.setName("AsyncAppenderThread" + threadSequence.getAndIncrement());
        }

        @Override
        public void run() {
            Log4jLogEvent log4jLogEvent;
            Serializable serializable;
            while (!this.shutdown) {
                try {
                    serializable = this.queue.take();
                    if (serializable != null && serializable instanceof String && AsyncAppender.SHUTDOWN.equals(serializable.toString())) {
                        this.shutdown = true;
                    }
                }
                catch (InterruptedException interruptedException) {}
                continue;
                log4jLogEvent = Log4jLogEvent.deserialize(serializable);
                log4jLogEvent.setEndOfBatch(this.queue.isEmpty());
                boolean bl = false;
                for (AppenderControl appenderControl : this.appenders) {
                    try {
                        appenderControl.callAppender(log4jLogEvent);
                        bl = true;
                    }
                    catch (Exception exception) {}
                }
                if (bl || AsyncAppender.this.errorAppender == null) continue;
                try {
                    AsyncAppender.this.errorAppender.callAppender(log4jLogEvent);
                }
                catch (Exception exception) {}
            }
            while (!this.queue.isEmpty()) {
                try {
                    serializable = this.queue.take();
                    if (!(serializable instanceof Log4jLogEvent)) continue;
                    log4jLogEvent = Log4jLogEvent.deserialize(serializable);
                    log4jLogEvent.setEndOfBatch(this.queue.isEmpty());
                    for (AppenderControl appenderControl : this.appenders) {
                        appenderControl.callAppender(log4jLogEvent);
                    }
                }
                catch (InterruptedException interruptedException) {
                }
            }
        }

        public void shutdown() {
            this.shutdown = true;
            if (this.queue.isEmpty()) {
                this.queue.offer((Serializable)((Object)AsyncAppender.SHUTDOWN));
            }
        }
    }
}

