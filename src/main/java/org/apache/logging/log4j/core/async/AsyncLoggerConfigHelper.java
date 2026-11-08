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
import com.lmax.disruptor.Sequence;
import com.lmax.disruptor.SequenceReportingEventHandler;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.Util;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.async.AsyncLoggerConfig;
import org.apache.logging.log4j.core.async.DaemonThreadFactory;
import org.apache.logging.log4j.status.StatusLogger;

public class AsyncLoggerConfigHelper {
    private static final int MAX_DRAIN_ATTEMPTS_BEFORE_SHUTDOWN = 20;
    private static final int HALF_A_SECOND = 500;
    private static final int RINGBUFFER_MIN_SIZE = 128;
    private static final int RINGBUFFER_DEFAULT_SIZE = 262144;
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static ThreadFactory threadFactory = new DaemonThreadFactory("AsyncLoggerConfig-");
    private static volatile Disruptor<Log4jEventWrapper> disruptor;
    private static ExecutorService executor;
    private static volatile int count;
    private static final EventFactory<Log4jEventWrapper> FACTORY;
    private final EventTranslator<Log4jEventWrapper> translator = new EventTranslator<Log4jEventWrapper>(){

        public void translateTo(Log4jEventWrapper log4jEventWrapper, long l) {
            log4jEventWrapper.event = (LogEvent)AsyncLoggerConfigHelper.this.currentLogEvent.get();
            log4jEventWrapper.loggerConfig = AsyncLoggerConfigHelper.this.asyncLoggerConfig;
        }
    };
    private final ThreadLocal<LogEvent> currentLogEvent = new ThreadLocal();
    private final AsyncLoggerConfig asyncLoggerConfig;

    public AsyncLoggerConfigHelper(AsyncLoggerConfig asyncLoggerConfig) {
        this.asyncLoggerConfig = asyncLoggerConfig;
        AsyncLoggerConfigHelper.claim();
    }

    private static synchronized void initDisruptor() {
        if (disruptor != null) {
            LOGGER.trace("AsyncLoggerConfigHelper not starting new disruptor, using existing object. Ref count is {}.", count);
            return;
        }
        LOGGER.trace("AsyncLoggerConfigHelper creating new disruptor. Ref count is {}.", count);
        int n = AsyncLoggerConfigHelper.calculateRingBufferSize();
        WaitStrategy waitStrategy = AsyncLoggerConfigHelper.createWaitStrategy();
        executor = Executors.newSingleThreadExecutor(threadFactory);
        disruptor = new Disruptor(FACTORY, n, (Executor)executor, ProducerType.MULTI, waitStrategy);
        Log4jEventWrapperHandler[] log4jEventWrapperHandlerArray = new Log4jEventWrapperHandler[]{new Log4jEventWrapperHandler()};
        ExceptionHandler exceptionHandler = AsyncLoggerConfigHelper.getExceptionHandler();
        disruptor.handleExceptionsWith(exceptionHandler);
        disruptor.handleEventsWith((EventHandler[])log4jEventWrapperHandlerArray);
        LOGGER.debug("Starting AsyncLoggerConfig disruptor with ringbuffer size={}, waitStrategy={}, exceptionHandler={}...", disruptor.getRingBuffer().getBufferSize(), waitStrategy.getClass().getSimpleName(), exceptionHandler);
        disruptor.start();
    }

    private static WaitStrategy createWaitStrategy() {
        String string = System.getProperty("AsyncLoggerConfig.WaitStrategy");
        LOGGER.debug("property AsyncLoggerConfig.WaitStrategy={}", string);
        if ("Sleep".equals(string)) {
            return new SleepingWaitStrategy();
        }
        if ("Yield".equals(string)) {
            return new YieldingWaitStrategy();
        }
        if ("Block".equals(string)) {
            return new BlockingWaitStrategy();
        }
        return new SleepingWaitStrategy();
    }

    private static int calculateRingBufferSize() {
        int n = 262144;
        String string = System.getProperty("AsyncLoggerConfig.RingBufferSize", String.valueOf(n));
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

    private static ExceptionHandler getExceptionHandler() {
        String string = System.getProperty("AsyncLoggerConfig.ExceptionHandler");
        if (string == null) {
            return null;
        }
        try {
            Class<?> clazz = Class.forName(string);
            ExceptionHandler exceptionHandler = (ExceptionHandler)clazz.newInstance();
            return exceptionHandler;
        }
        catch (Exception exception) {
            LOGGER.debug("AsyncLoggerConfig.ExceptionHandler not set: error creating " + string + ": ", (Throwable)exception);
            return null;
        }
    }

    static synchronized void claim() {
        ++count;
        AsyncLoggerConfigHelper.initDisruptor();
    }

    static synchronized void release() {
        if (--count > 0) {
            LOGGER.trace("AsyncLoggerConfigHelper: not shutting down disruptor: ref count is {}.", count);
            return;
        }
        Disruptor<Log4jEventWrapper> disruptor = AsyncLoggerConfigHelper.disruptor;
        if (disruptor == null) {
            LOGGER.trace("AsyncLoggerConfigHelper: disruptor already shut down: ref count is {}.", count);
            return;
        }
        LOGGER.trace("AsyncLoggerConfigHelper: shutting down disruptor: ref count is {}.", count);
        AsyncLoggerConfigHelper.disruptor = null;
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
        executor = null;
    }

    public void callAppendersFromAnotherThread(LogEvent logEvent) {
        this.currentLogEvent.set(logEvent);
        disruptor.publishEvent(this.translator);
    }

    static {
        count = 0;
        FACTORY = new EventFactory<Log4jEventWrapper>(){

            public Log4jEventWrapper newInstance() {
                return new Log4jEventWrapper();
            }
        };
    }

    private static class Log4jEventWrapperHandler
    implements SequenceReportingEventHandler<Log4jEventWrapper> {
        private static final int NOTIFY_PROGRESS_THRESHOLD = 50;
        private Sequence sequenceCallback;
        private int counter;

        private Log4jEventWrapperHandler() {
        }

        public void setSequenceCallback(Sequence sequence2) {
            this.sequenceCallback = sequence2;
        }

        public void onEvent(Log4jEventWrapper log4jEventWrapper, long l, boolean bl) throws Exception {
            log4jEventWrapper.event.setEndOfBatch(bl);
            log4jEventWrapper.loggerConfig.asyncCallAppenders(log4jEventWrapper.event);
            log4jEventWrapper.clear();
            if (++this.counter > 50) {
                this.sequenceCallback.set(l);
                this.counter = 0;
            }
        }
    }

    private static class Log4jEventWrapper {
        private AsyncLoggerConfig loggerConfig;
        private LogEvent event;

        private Log4jEventWrapper() {
        }

        public void clear() {
            this.loggerConfig = null;
            this.event = null;
        }
    }
}

