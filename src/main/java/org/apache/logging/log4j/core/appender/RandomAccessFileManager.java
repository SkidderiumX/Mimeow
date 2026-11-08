/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.AbstractManager;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.OutputStreamManager;

public class RandomAccessFileManager
extends OutputStreamManager {
    static final int DEFAULT_BUFFER_SIZE = 262144;
    private static final RandomAccessFileManagerFactory FACTORY = new RandomAccessFileManagerFactory();
    private final boolean isImmediateFlush;
    private final String advertiseURI;
    private final RandomAccessFile randomAccessFile;
    private final ByteBuffer buffer;
    private final ThreadLocal<Boolean> isEndOfBatch = new ThreadLocal();

    protected RandomAccessFileManager(RandomAccessFile randomAccessFile, String string, OutputStream outputStream2, boolean bl, String string2, Layout<? extends Serializable> layout) {
        super(outputStream2, string, layout);
        this.isImmediateFlush = bl;
        this.randomAccessFile = randomAccessFile;
        this.advertiseURI = string2;
        this.isEndOfBatch.set(Boolean.FALSE);
        this.buffer = ByteBuffer.allocate(262144);
    }

    public static RandomAccessFileManager getFileManager(String string, boolean bl, boolean bl2, String string2, Layout<? extends Serializable> layout) {
        return (RandomAccessFileManager)RandomAccessFileManager.getManager(string, new FactoryData(bl, bl2, string2, layout), FACTORY);
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

    public String getFileName() {
        return this.getName();
    }

    @Override
    public Map<String, String> getContentFormat() {
        HashMap<String, String> hashMap = new HashMap<String, String>(super.getContentFormat());
        hashMap.put("fileURI", this.advertiseURI);
        return hashMap;
    }

    private static class RandomAccessFileManagerFactory
    implements ManagerFactory<RandomAccessFileManager, FactoryData> {
        private RandomAccessFileManagerFactory() {
        }

        @Override
        public RandomAccessFileManager createManager(String string, FactoryData factoryData) {
            File file = new File(string);
            File file2 = file.getParentFile();
            if (null != file2 && !file2.exists()) {
                file2.mkdirs();
            }
            if (!factoryData.append) {
                file.delete();
            }
            DummyOutputStream dummyOutputStream = new DummyOutputStream();
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(string, "rw");
                if (factoryData.append) {
                    randomAccessFile.seek(randomAccessFile.length());
                } else {
                    randomAccessFile.setLength(0L);
                }
                return new RandomAccessFileManager(randomAccessFile, string, dummyOutputStream, factoryData.immediateFlush, factoryData.advertiseURI, factoryData.layout);
            }
            catch (Exception exception) {
                AbstractManager.LOGGER.error("RandomAccessFileManager (" + string + ") " + exception);
                return null;
            }
        }
    }

    private static class FactoryData {
        private final boolean append;
        private final boolean immediateFlush;
        private final String advertiseURI;
        private final Layout<? extends Serializable> layout;

        public FactoryData(boolean bl, boolean bl2, String string, Layout<? extends Serializable> layout) {
            this.append = bl;
            this.immediateFlush = bl2;
            this.advertiseURI = string;
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
}

