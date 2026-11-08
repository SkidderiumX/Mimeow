/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.rolling.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.logging.log4j.core.appender.rolling.helper.AbstractAction;

public class ZipCompressAction
extends AbstractAction {
    private static final int BUF_SIZE = 8102;
    private final File source;
    private final File destination;
    private final boolean deleteSource;
    private final int level;

    public ZipCompressAction(File file, File file2, boolean bl, int n) {
        if (file == null) {
            throw new NullPointerException("source");
        }
        if (file2 == null) {
            throw new NullPointerException("destination");
        }
        this.source = file;
        this.destination = file2;
        this.deleteSource = bl;
        this.level = n;
    }

    @Override
    public boolean execute() throws IOException {
        return ZipCompressAction.execute(this.source, this.destination, this.deleteSource, this.level);
    }

    public static boolean execute(File file, File file2, boolean bl, int n) throws IOException {
        if (file.exists()) {
            int n2;
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            zipOutputStream.setLevel(n);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            byte[] byArray = new byte[8102];
            while ((n2 = fileInputStream.read(byArray)) != -1) {
                zipOutputStream.write(byArray, 0, n2);
            }
            zipOutputStream.close();
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

