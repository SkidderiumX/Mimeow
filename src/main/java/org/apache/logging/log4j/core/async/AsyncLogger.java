/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.async;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.Util;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.async.DaemonThreadFactory;
import org.apache.logging.log4j.core.async.RingBufferLogEvent;
import org.apache.logging.log4j.core.async.RingBufferLogEventHandler;
import org.apache.logging.log4j.core.async.RingBufferLogEventTranslator;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.helpers.Clock;
import org.apache.logging.log4j.core.helpers.ClockFactory;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.status.StatusLogger;

public class AsyncLogger
extends Logger {
    private static final int HALF_A_SECOND = 500;
    private static final int MAX_DRAIN_ATTEMPTS_BEFORE_SHUTDOWN = 20;
    private static final int RINGBUFFER_MIN_SIZE = 128;
    private static final int RINGBUFFER_DEFAULT_SIZE = 262144;
    private static final StatusLogger LOGGER = StatusLogger.getLogger();
    private static volatile Disruptor<RingBufferLogEvent> disruptor;
    private static Clock clock;
    private static ExecutorService executor;
    private final ThreadLocal<Info> threadlocalInfo = new ThreadLocal();

    private static int calculateRingBufferSize() {
        int n = 262144;
        String string = System.getProperty("AsyncLogger.RingBufferSize", String.valueOf(n));
        try {
            int n2 = Integer.parseInt(string);
            if (n2 < 128) {
                n2 = 128;
                LOGGER.warn("Invalid RingBufferSize {}, using minimum size {}.", string, 128);
            }
            n = n2;
        }
        catch (Exception exception) {
            LOGGER.warn("Invalid RingBufferSize {}, using default size {}.", string, n);
        }
        return Util.ceilingNextPowerOfTwo((int)n);
    }

    private static WaitStrategy createWaitStrategy() {
        String string = System.getProperty("AsyncLogger.WaitStrategy");
        LOGGER.debug("property AsyncLogger.WaitStrategy={}", string);
        if ("Sleep".equals(string)) {
            LOGGER.debug("disruptor event handler uses SleepingWaitStrategy");
            return new SleepingWaitStrategy();
        }
        if ("Yield".equals(string)) {
            LOGGER.debug("disruptor event handler uses YieldingWaitStrategy");
            return new YieldingWaitStrategy();
        }
        if ("Block".equals(string)) {
            LOGGER.debug("disruptor event handler uses BlockingWaitStrategy");
            return new BlockingWaitStrategy();
        }
        LOGGER.debug("disruptor event handler uses SleepingWaitStrategy");
        return new SleepingWaitStrategy();
    }

    private static ExceptionHandler getExceptionHandler() {
        String string = System.getProperty("AsyncLogger.ExceptionHandler");
        if (string == null) {
            LOGGER.debug("No AsyncLogger.ExceptionHandler specified");
            return null;
        }
        try {
            Class<?> clazz = Class.forName(string);
            ExceptionHandler exceptionHandler = (ExceptionHandler)clazz.newInstance();
            LOGGER.debug("AsyncLogger.ExceptionHandler=" + exceptionHandler);
            return exceptionHandler;
        }
        catch (Exception exception) {
            LOGGER.debug("AsyncLogger.ExceptionHandler not set: error creating " + string + ": ", (Throwable)exception);
            return null;
        }
    }

    public AsyncLogger(LoggerContext loggerContext, String string, MessageFactory messageFactory) {
        super(loggerContext, string, messageFactory);
    }

    @Override
    public void log(Marker marker, String string, Level level, Message message, Throwable throwable) {
        Info info = this.threadlocalInfo.get();
        if (info == null) {
            info = new Info();
            info.translator = new RingBufferLogEventTranslator();
            info.cachedThreadName = Thread.currentThread().getName();
            this.threadlocalInfo.set(info);
        }
        boolean bl = this.config.loggerConfig.isIncludeLocation();
        info.translator.setValues(this, this.getName(), marker, string, level, message, throwable, ThreadContext.getImmutableContext(), ThreadContext.getImmutableStack(), info.cachedThreadName, bl ? this.location(string) : null, clock.currentTimeMillis());
        disruptor.publishEvent((EventTranslator)info.translator);
    }

    private StackTraceElement location(String string) {
        return Log4jLogEvent.calcLocation(string);
    }

    public void actualAsyncLog(RingBufferLogEvent ringBufferLogEvent) {
        Map<Property, Boolean> map = this.config.loggerConfig.getProperties();
        ringBufferLogEvent.mergePropertiesIntoContextMap(map, this.config.config.getStrSubstitutor());
        this.config.logEvent(ringBufferLogEvent);
    }

    public static void stop() {
        Disruptor<RingBufferLogEvent> disruptor = AsyncLogger.disruptor;
        AsyncLogger.disruptor = null;
        disruptor.shutdown();
        RingBuffer ringBuffer = disruptor.getRingBuffer();
        for (int i = 0; i < 20 && !ringBuffer.hasAvailableCapacity(ringBuffer.getBufferSize()); ++i) {
            try {
                Thread.sleep(500L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
        executor.shutdown();
    }

    static {
        clock = ClockFactory.getClock();
        executor = Executors.newSingleThreadExecutor(new DaemonThreadFactory("AsyncLogger-"));
        int n = AsyncLogger.calculateRingBufferSize();
        WaitStrategy waitStrategy = AsyncLogger.createWaitStrategy();
        disruptor = new Disruptor((EventFactory)RingBufferLogEvent.FACTORY, n, (Executor)executor, ProducerType.MULTI, waitStrategy);
        RingBufferLogEventHandler[] ringBufferLogEventHandlerArray = new RingBufferLogEventHandler[]{new RingBufferLogEventHandler()};
        disruptor.handleExceptionsWith(AsyncLogger.getExceptionHandler());
        disruptor.handleEventsWith((EventHandler[])ringBufferLogEventHandlerArray);
        LOGGER.debug("Starting AsyncLogger disruptor with ringbuffer size {}...", disruptor.getRingBuffer().getBufferSize());
        disruptor.start();
    }

    private static class Info {
        private RingBufferLogEventTranslator translator;
        private String cachedThreadName;

        private Info() {
        }
    }
}

