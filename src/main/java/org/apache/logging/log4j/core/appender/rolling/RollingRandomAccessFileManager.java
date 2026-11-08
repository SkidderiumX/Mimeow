/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.rolling;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.RolloverStrategy;
import org.apache.logging.log4j.core.appender.rolling.TriggeringPolicy;

public class RollingRandomAccessFileManager
extends RollingFileManager {
    static final int DEFAULT_BUFFER_SIZE = 262144;
    private static final RollingRandomAccessFileManagerFactory FACTORY = new RollingRandomAccessFileManagerFactory();
    private final boolean isImmediateFlush;
    private RandomAccessFile randomAccessFile;
    private final ByteBuffer buffer;
    private final ThreadLocal<Boolean> isEndOfBatch = new ThreadLocal();

    public RollingRandomAccessFileManager(RandomAccessFile randomAccessFile, String string, String string2, OutputStream outputStream2, boolean bl, boolean bl2, long l, long l2, TriggeringPolicy triggeringPolicy, RolloverStrategy rolloverStrategy, String string3, Layout<? extends Serializable> layout) {
        super(string, string2, outputStream2, bl, l, l2, triggeringPolicy, rolloverStrategy, string3, layout);
        this.isImmediateFlush = bl2;
        this.randomAccessFile = randomAccessFile;
        this.isEndOfBatch.set(Boolean.FALSE);
        this.buffer = ByteBuffer.allocate(262144);
    }

    public static RollingRandomAccessFileManager getRollingRandomAccessFileManager(String string, String string2, boolean bl, boolean bl2, TriggeringPolicy triggeringPolicy, RolloverStrategy rolloverStrategy, String string3, Layout<? extends Serializable> layout) {
        return (RollingRandomAccessFileManager)RollingRandomAccessFileManager.getManager(string, new FactoryData(string2, bl, bl2, triggeringPolicy, rolloverStrategy, string3, layout), FACTORY);
    }

    public Boolean isEndOfBatch() {
        return this.isEndOfBatch.get();
    }

    public void setEndOfBatch(boolean bl) {
        this.isEndOfBatch.set(bl);
    }

    @Override
    protected synchronized void write(byte[] byArray, int n, int n2) {
        super.write(byArray, n, n2);
        int n3 = 0;
        do {
            if (n2 > this.buffer.remaining()) {
                this.flush();
            }
            n3 = Math.min(n2, this.buffer.remaining());
            this.buffer.put(byArray, n, n3);
            n += n3;
        } while ((n2 -= n3) > 0);
        if (this.isImmediateFlush || this.isEndOfBatch.get() == Boolean.TRUE) {
            this.flush();
        }
    }

    @Override
    protected void createFileAfterRollover() throws IOException {
        this.randomAccessFile = new RandomAccessFile(this.getFileName(), "rw");
        if (this.isAppend()) {
            this.randomAccessFile.seek(this.randomAccessFile.length());
        }
    }

    @Override
    public synchronized void flush() {
        this.buffer.flip();
        try {
            this.randomAccessFile.write(this.buffer.array(), 0, this.buffer.limit());
        }
        catch (IOException iOException) {
            String string = "Error writing to RandomAccessFile " + this.getName();
            throw new AppenderLoggingException(string, iOException);
        }
        this.buffer.clear();
    }

    @Override
    public synchronized void close() {
        this.flush();
        try {
            this.randomAccessFile.close();
        }
        catch (IOException iOException) {
            LOGGER.error("Unable to close RandomAccessFile " + this.getName() + ". " + iOException);
        }
    }

    private static class FactoryData {
        private final String pattern;
        private final boolean append;
        private final boolean immediateFlush;
        private final TriggeringPolicy policy;
        private final RolloverStrategy strategy;
        private final String advertiseURI;
        private final Layout<? extends Serializable> layout;

        public FactoryData(String string, boolean bl, boolean bl2, TriggeringPolicy triggeringPolicy, RolloverStrategy rolloverStrategy, String string2, Layout<? extends Serializable> layout) {
            this.pattern = string;
            this.append = bl;
            this.immediateFlush = bl2;
            this.policy = triggeringPolicy;
            this.strategy = rolloverStrategy;
            this.advertiseURI = string2;
            this.layout = layout;
        }
    }

    public static class DummyOutputStream
    extends OutputStream {
        DummyOutputStream() {
        }

        @Override
        public void write(int n) throws IOException {
        }

        @Override
        public void write(byte[] byArray, int n, int n2) throws IOException {
        }
    }

    private static class RollingRandomAccessFileManagerFactory
    implements ManagerFactory<RollingRandomAccessFileManager, FactoryData> {
        private RollingRandomAccessFileManagerFactory() {
        }

        @Override
        public RollingRandomAccessFileManager createManager(String string, FactoryData factoryData) {
            File file = new File(string);
            File file2 = file.getParentFile();
            if (null != file2 && !file2.exists()) {
                file2.mkdirs();
            }
            if (!factoryData.append) {
                file.delete();
            }
            long l = factoryData.append ? file.length() : 0L;
            long l2 = file.exists() ? file.lastModified() : System.currentTimeMillis();
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = new RandomAccessFile(string, "rw");
                if (factoryData.append) {
                    long l3 = randomAccessFile.length();
                    LOGGER.trace("RandomAccessFile {} seek to {}", string, l3);
                    randomAccessFile.seek(l3);
                } else {
                    LOGGER.trace("RandomAccessFile {} set length to 0", string);
                    randomAccessFile.setLength(0L);
                }
                return new RollingRandomAccessFileManager(randomAccessFile, string, factoryData.pattern, new DummyOutputStream(), factoryData.append, factoryData.immediateFlush, l, l2, factoryData.policy, factoryData.strategy, factoryData.advertiseURI, factoryData.layout);
            }
            catch (IOException iOException) {
                LOGGER.error("Cannot access RandomAccessFile {}) " + iOException);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    }
                    catch (IOException iOException2) {
                        LOGGER.error("Cannot close RandomAccessFile {}", string, iOException2);
                    }
                }
                return null;
            }
        }
    }
}

