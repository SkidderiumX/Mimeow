/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.TailerListener;

public class Tailer
implements Runnable {
    private static final int DEFAULT_DELAY_MILLIS = 1000;
    private static final String RAF_MODE = "r";
    private static final int DEFAULT_BUFSIZE = 4096;
    private final byte[] inbuf;
    private final File file;
    private final long delayMillis;
    private final boolean end;
    private final TailerListener listener;
    private final boolean reOpen;
    private volatile boolean run = true;

    public Tailer(File file, TailerListener tailerListener) {
        this(file, tailerListener, 1000L);
    }

    public Tailer(File file, TailerListener tailerListener, long l) {
        this(file, tailerListener, l, false);
    }

    public Tailer(File file, TailerListener tailerListener, long l, boolean bl) {
        this(file, tailerListener, l, bl, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long l, boolean bl, boolean bl2) {
        this(file, tailerListener, l, bl, bl2, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long l, boolean bl, int n) {
        this(file, tailerListener, l, bl, false, n);
    }

    public Tailer(File file, TailerListener tailerListener, long l, boolean bl, boolean bl2, int n) {
        this.file = file;
        this.delayMillis = l;
        this.end = bl;
        this.inbuf = new byte[n];
        this.listener = tailerListener;
        tailerListener.init(this);
        this.reOpen = bl2;
    }

    public static Tailer create(File file, TailerListener tailerListener, long l, boolean bl, int n) {
        Tailer tailer = new Tailer(file, tailerListener, l, bl, n);
        Thread thread2 = new Thread(tailer);
        thread2.setDaemon(true);
        thread2.start();
        return tailer;
    }

    public static Tailer create(File file, TailerListener tailerListener, long l, boolean bl, boolean bl2, int n) {
        Tailer tailer = new Tailer(file, tailerListener, l, bl, bl2, n);
        Thread thread2 = new Thread(tailer);
        thread2.setDaemon(true);
        thread2.start();
        return tailer;
    }

    public static Tailer create(File file, TailerListener tailerListener, long l, boolean bl) {
        return Tailer.create(file, tailerListener, l, bl, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long l, boolean bl, boolean bl2) {
        return Tailer.create(file, tailerListener, l, bl, bl2, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long l) {
        return Tailer.create(file, tailerListener, l, false);
    }

    public static Tailer create(File file, TailerListener tailerListener) {
        return Tailer.create(file, tailerListener, 1000L, false);
    }

    public File getFile() {
        return this.file;
    }

    public long getDelay() {
        return this.delayMillis;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        RandomAccessFile randomAccessFile = null;
        try {
            long l = 0L;
            long l2 = 0L;
            while (this.run && randomAccessFile == null) {
                try {
                    randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                }
                catch (FileNotFoundException fileNotFoundException) {
                    this.listener.fileNotFound();
                }
                if (randomAccessFile == null) {
                    try {
                        Thread.sleep(this.delayMillis);
                    }
                    catch (InterruptedException interruptedException) {}
                    continue;
                }
                l2 = this.end ? this.file.length() : 0L;
                l = System.currentTimeMillis();
                randomAccessFile.seek(l2);
            }
            while (this.run) {
                boolean bl = FileUtils.isFileNewer(this.file, l);
                long l3 = this.file.length();
                if (l3 < l2) {
                    this.listener.fileRotated();
                    try {
                        RandomAccessFile randomAccessFile2 = randomAccessFile;
                        randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                        l2 = 0L;
                        IOUtils.closeQuietly(randomAccessFile2);
                    }
                    catch (FileNotFoundException fileNotFoundException) {
                        this.listener.fileNotFound();
                    }
                    continue;
                }
                if (l3 > l2) {
                    l2 = this.readLines(randomAccessFile);
                    l = System.currentTimeMillis();
                } else if (bl) {
                    l2 = 0L;
                    randomAccessFile.seek(l2);
                    l2 = this.readLines(randomAccessFile);
                    l = System.currentTimeMillis();
                }
                if (this.reOpen) {
                    IOUtils.closeQuietly(randomAccessFile);
                }
                try {
                    Thread.sleep(this.delayMillis);
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                if (!this.run || !this.reOpen) continue;
                randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                randomAccessFile.seek(l2);
            }
        }
        catch (Exception exception) {
            this.listener.handle(exception);
        }
        finally {
            IOUtils.closeQuietly(randomAccessFile);
        }
    }

    public void stop() {
        this.run = false;
    }

    private long readLines(RandomAccessFile randomAccessFile) throws IOException {
        int n;
        long l;
        StringBuilder stringBuilder = new StringBuilder();
        long l2 = l = randomAccessFile.getFilePointer();
        boolean bl = false;
        while (this.run && (n = randomAccessFile.read(this.inbuf)) != -1) {
            block5: for (int i = 0; i < n; ++i) {
                byte by = this.inbuf[i];
                switch (by) {
                    case 10: {
                        bl = false;
                        this.listener.handle(stringBuilder.toString());
                        stringBuilder.setLength(0);
                        l2 = l + (long)i + 1L;
                        continue block5;
                    }
                    case 13: {
                        if (bl) {
                            stringBuilder.append('\r');
                        }
                        bl = true;
                        continue block5;
                    }
                    default: {
                        if (bl) {
                            bl = false;
                            this.listener.handle(stringBuilder.toString());
                            stringBuilder.setLength(0);
                            l2 = l + (long)i + 1L;
                        }
                        stringBuilder.append((char)by);
                    }
                }
            }
            l = randomAccessFile.getFilePointer();
        }
        randomAccessFile.seek(l2);
        return l2;
    }
}

