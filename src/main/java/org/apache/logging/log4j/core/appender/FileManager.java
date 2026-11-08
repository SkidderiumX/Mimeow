/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.AbstractManager;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.OutputStreamManager;

public class FileManager
extends OutputStreamManager {
    private static final FileManagerFactory FACTORY = new FileManagerFactory();
    private final boolean isAppend;
    private final boolean isLocking;
    private final String advertiseURI;

    protected FileManager(String string, OutputStream outputStream2, boolean bl, boolean bl2, String string2, Layout<? extends Serializable> layout) {
        super(outputStream2, string, layout);
        this.isAppend = bl;
        this.isLocking = bl2;
        this.advertiseURI = string2;
    }

    public static FileManager getFileManager(String string, boolean bl, boolean bl2, boolean bl3, String string2, Layout<? extends Serializable> layout) {
        if (bl2 && bl3) {
            bl2 = false;
        }
        return (FileManager)FileManager.getManager(string, new FactoryData(bl, bl2, bl3, string2, layout), FACTORY);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected synchronized void write(byte[] byArray, int n, int n2) {
        block6: {
            if (this.isLocking) {
                FileChannel fileChannel = ((FileOutputStream)this.getOutputStream()).getChannel();
                try {
                    FileLock fileLock = fileChannel.lock(0L, Long.MAX_VALUE, false);
                    try {
                        super.write(byArray, n, n2);
                        break block6;
                    }
                    finally {
                        fileLock.release();
                    }
                }
                catch (IOException iOException) {
                    throw new AppenderLoggingException("Unable to obtain lock on " + this.getName(), iOException);
                }
            }
            super.write(byArray, n, n2);
        }
    }

    public String getFileName() {
        return this.getName();
    }

    public boolean isAppend() {
        return this.isAppend;
    }

    public boolean isLocking() {
        return this.isLocking;
    }

    @Override
    public Map<String, String> getContentFormat() {
        HashMap<String, String> hashMap = new HashMap<String, String>(super.getContentFormat());
        hashMap.put("fileURI", this.advertiseURI);
        return hashMap;
    }

    private static class FileManagerFactory
    implements ManagerFactory<FileManager, FactoryData> {
        private FileManagerFactory() {
        }

        @Override
        public FileManager createManager(String string, FactoryData factoryData) {
            File file = new File(string);
            File file2 = file.getParentFile();
            if (null != file2 && !file2.exists()) {
                file2.mkdirs();
            }
            try {
                OutputStream outputStream2 = new FileOutputStream(string, factoryData.append);
                if (factoryData.bufferedIO) {
                    outputStream2 = new BufferedOutputStream(outputStream2);
                }
                return new FileManager(string, outputStream2, factoryData.append, factoryData.locking, factoryData.advertiseURI, factoryData.layout);
            }
            catch (FileNotFoundException fileNotFoundException) {
                AbstractManager.LOGGER.error("FileManager (" + string + ") " + fileNotFoundException);
                return null;
            }
        }
    }

    private static class FactoryData {
        private final boolean append;
        private final boolean locking;
        private final boolean bufferedIO;
        private final String advertiseURI;
        private final Layout<? extends Serializable> layout;

        public FactoryData(boolean bl, boolean bl2, boolean bl3, String string, Layout<? extends Serializable> layout) {
            this.append = bl;
            this.locking = bl2;
            this.bufferedIO = bl3;
            this.advertiseURI = string;
            this.layout = layout;
        }
    }
}

