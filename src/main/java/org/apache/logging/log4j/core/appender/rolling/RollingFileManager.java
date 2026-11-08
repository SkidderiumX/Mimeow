/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.rolling;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.concurrent.Semaphore;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.FileManager;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.rolling.PatternProcessor;
import org.apache.logging.log4j.core.appender.rolling.RolloverDescription;
import org.apache.logging.log4j.core.appender.rolling.RolloverStrategy;
import org.apache.logging.log4j.core.appender.rolling.TriggeringPolicy;
import org.apache.logging.log4j.core.appender.rolling.helper.AbstractAction;
import org.apache.logging.log4j.core.appender.rolling.helper.Action;

public class RollingFileManager
extends FileManager {
    private static RollingFileManagerFactory factory = new RollingFileManagerFactory();
    private long size;
    private long initialTime;
    private final PatternProcessor patternProcessor;
    private final Semaphore semaphore = new Semaphore(1);
    private final TriggeringPolicy policy;
    private final RolloverStrategy strategy;

    protected RollingFileManager(String string, String string2, OutputStream outputStream2, boolean bl, long l, long l2, TriggeringPolicy triggeringPolicy, RolloverStrategy rolloverStrategy, String string3, Layout<? extends Serializable> layout) {
        super(string, outputStream2, bl, false, string3, layout);
        this.size = l;
        this.initialTime = l2;
        this.policy = triggeringPolicy;
        this.strategy = rolloverStrategy;
        this.patternProcessor = new PatternProcessor(string2);
        triggeringPolicy.initialize(this);
    }

    public static RollingFileManager getFileManager(String string, String string2, boolean bl, boolean bl2, TriggeringPolicy triggeringPolicy, RolloverStrategy rolloverStrategy, String string3, Layout<? extends Serializable> layout) {
        return (RollingFileManager)RollingFileManager.getManager(string, new FactoryData(string2, bl, bl2, triggeringPolicy, rolloverStrategy, string3, layout), factory);
    }

    @Override
    protected synchronized void write(byte[] byArray, int n, int n2) {
        this.size += (long)n2;
        super.write(byArray, n, n2);
    }

    public long getFileSize() {
        return this.size;
    }

    public long getFileTime() {
        return this.initialTime;
    }

    public synchronized void checkRollover(LogEvent logEvent) {
        if (this.policy.isTriggeringEvent(logEvent) && this.rollover(this.strategy)) {
            try {
                this.size = 0L;
                this.initialTime = System.currentTimeMillis();
                this.createFileAfterRollover();
            }
            catch (IOException iOException) {
                LOGGER.error("FileManager (" + this.getFileName() + ") " + iOException);
            }
        }
    }

    protected void createFileAfterRollover() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(this.getFileName(), this.isAppend());
        this.setOutputStream(fileOutputStream);
    }

    public PatternProcessor getPatternProcessor() {
        return this.patternProcessor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean rollover(RolloverStrategy rolloverStrategy) {
        try {
            this.semaphore.acquire();
        }
        catch (InterruptedException interruptedException) {
            LOGGER.error("Thread interrupted while attempting to check rollover", (Throwable)interruptedException);
            return false;
        }
        boolean bl = false;
        Thread thread2 = null;
        try {
            RolloverDescription rolloverDescription = rolloverStrategy.rollover(this);
            if (rolloverDescription != null) {
                this.close();
                if (rolloverDescription.getSynchronous() != null) {
                    try {
                        bl = rolloverDescription.getSynchronous().execute();
                    }
                    catch (Exception exception) {
                        LOGGER.error("Error in synchronous task", (Throwable)exception);
                    }
                }
                if (bl && rolloverDescription.getAsynchronous() != null) {
                    thread2 = new Thread(new AsyncAction(rolloverDescription.getAsynchronous(), this));
                    thread2.start();
                }
                boolean bl2 = true;
                return bl2;
            }
            boolean bl3 = false;
            return bl3;
        }
        finally {
            if (thread2 == null) {
                this.semaphore.release();
            }
        }
    }

    private static class RollingFileManagerFactory
    implements ManagerFactory<RollingFileManager, FactoryData> {
        private RollingFileManagerFactory() {
        }

        @Override
        public RollingFileManager createManager(String string, FactoryData factoryData) {
            File file = new File(string);
            File file2 = file.getParentFile();
            if (null != file2 && !file2.exists()) {
                file2.mkdirs();
            }
            try {
                file.createNewFile();
            }
            catch (IOException iOException) {
                LOGGER.error("Unable to create file " + string, (Throwable)iOException);
                return null;
            }
            long l = factoryData.append ? file.length() : 0L;
            long l2 = file.lastModified();
            try {
                OutputStream outputStream2 = new FileOutputStream(string, factoryData.append);
                if (factoryData.bufferedIO) {
                    outputStream2 = new BufferedOutputStream(outputStream2);
                }
                return new RollingFileManager(string, factoryData.pattern, outputStream2, factoryData.append, l, l2, factoryData.policy, factoryData.strategy, factoryData.advertiseURI, factoryData.layout);
            }
            catch (FileNotFoundException fileNotFoundException) {
                LOGGER.error("FileManager (" + string + ") " + fileNotFoundException);
                return null;
            }
        }
    }

    private static class FactoryData {
        private final String pattern;
        private final boolean append;
        private final boolean bufferedIO;
        private final TriggeringPolicy policy;
        private final RolloverStrategy strategy;
        private final String advertiseURI;
        private final Layout<? extends Serializable> layout;

        public FactoryData(String string, boolean bl, boolean bl2, TriggeringPolicy triggeringPolicy, RolloverStrategy rolloverStrategy, String string2, Layout<? extends Serializable> layout) {
            this.pattern = string;
            this.append = bl;
            this.bufferedIO = bl2;
            this.policy = triggeringPolicy;
            this.strategy = rolloverStrategy;
            this.advertiseURI = string2;
            this.layout = layout;
        }
    }

    private static class AsyncAction
    extends AbstractAction {
        private final Action action;
        private final RollingFileManager manager;

        public AsyncAction(Action action, RollingFileManager rollingFileManager) {
            this.action = action;
            this.manager = rollingFileManager;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean execute() throws IOException {
            try {
                boolean bl = this.action.execute();
                return bl;
            }
            finally {
                this.manager.semaphore.release();
            }
        }

        @Override
        public void close() {
            this.action.close();
        }

        @Override
        public boolean isComplete() {
            return this.action.isComplete();
        }
    }
}

