/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.rolling.helper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import org.apache.logging.log4j.core.appender.rolling.helper.AbstractAction;

public class GZCompressAction
extends AbstractAction {
    private static final int BUF_SIZE = 8102;
    private final File source;
    private final File destination;
    private final boolean deleteSource;

    public GZCompressAction(File file, File file2, boolean bl) {
        if (file == null) {
            throw new NullPointerException("source");
        }
        if (file2 == null) {
            throw new NullPointerException("destination");
        }
        this.source = file;
        this.destination = file2;
        this.deleteSource = bl;
    }

    @Override
    public boolean execute() throws IOException {
        return GZCompressAction.execute(this.source, this.destination, this.deleteSource);
    }

    public static boolean execute(File file, File file2, boolean bl) throws IOException {
        if (file.exists()) {
            int n;
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(gZIPOutputStream);
            byte[] byArray = new byte[8102];
            while ((n = fileInputStream.read(byArray)) != -1) {
                bufferedOutputStream.write(byArray, 0, n);
            }
            bufferedOutputStream.close();
            fileInputStream.close();
            if (bl && !file.delete()) {
                LOGGER.warn("Unable to delete " + file.toString() + '.');
            }
            return true;
        }
        return false;
    }

    @Override
    protected void reportException(Exception exception) {
        LOGGER.warn("Exception during compression of '" + this.source.toString() + "'.", (Throwable)exception);
    }
}

