/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.rolling.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import org.apache.logging.log4j.core.appender.rolling.helper.AbstractAction;

public class FileRenameAction
extends AbstractAction {
    private final File source;
    private final File destination;
    private final boolean renameEmptyFiles;

    public FileRenameAction(File file, File file2, boolean bl) {
        this.source = file;
        this.destination = file2;
        this.renameEmptyFiles = bl;
    }

    @Override
    public boolean execute() {
        return FileRenameAction.execute(this.source, this.destination, this.renameEmptyFiles);
    }

    public static boolean execute(File file, File file2, boolean bl) {
        if (bl || file.length() > 0L) {
            File file3 = file2.getParentFile();
            if (file3 != null && !file3.exists() && !file3.mkdirs()) {
                LOGGER.error("Unable to create directory {}", file3.getAbsolutePath());
                return false;
            }
            try {
                if (!file.renameTo(file2)) {
                    try {
                        FileRenameAction.copyFile(file, file2);
                        return file.delete();
                    }
                    catch (IOException iOException) {
                        LOGGER.error("Unable to rename file {} to {} - {}", file.getAbsolutePath(), file2.getAbsolutePath(), iOException.getMessage());
                    }
                }
                return true;
            }
            catch (Exception exception) {
                try {
                    FileRenameAction.copyFile(file, file2);
                    return file.delete();
                }
                catch (IOException iOException) {
                    LOGGER.error("Unable to rename file {} to {} - {}", file.getAbsolutePath(), file2.getAbsolutePath(), iOException.getMessage());
                }
            }
        } else {
            try {
                file.delete();
            }
            catch (Exception exception) {
                LOGGER.error("Unable to delete empty file " + file.getAbsolutePath());
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void copyFile(File file, File file2) throws IOException {
        if (!file2.exists()) {
            file2.createNewFile();
        }
        AbstractInterruptibleChannel abstractInterruptibleChannel = null;
        AbstractInterruptibleChannel abstractInterruptibleChannel2 = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);
            abstractInterruptibleChannel = fileInputStream.getChannel();
            abstractInterruptibleChannel2 = fileOutputStream.getChannel();
            ((FileChannel)abstractInterruptibleChannel2).transferFrom((ReadableByteChannel)((Object)abstractInterruptibleChannel), 0L, ((FileChannel)abstractInterruptibleChannel).size());
        }
        finally {
            if (abstractInterruptibleChannel != null) {
                abstractInterruptibleChannel.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (abstractInterruptibleChannel2 != null) {
                abstractInterruptibleChannel2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}

