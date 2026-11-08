/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.apache.logging.log4j.Logger;

public class Util {
    public static EnumOS getOSType() {
        String string = System.getProperty("os.name").toLowerCase();
        return string.contains("win") ? EnumOS.WINDOWS : (string.contains("mac") ? EnumOS.OSX : (string.contains("solaris") ? EnumOS.SOLARIS : (string.contains("sunos") ? EnumOS.SOLARIS : (string.contains("linux") ? EnumOS.LINUX : (string.contains("unix") ? EnumOS.LINUX : EnumOS.UNKNOWN)))));
    }

    public static <V> V runTask(FutureTask<V> futureTask, Logger logger) {
        try {
            futureTask.run();
            return futureTask.get();
        }
        catch (ExecutionException executionException) {
            logger.fatal("Error executing task", (Throwable)executionException);
            if (executionException.getCause() instanceof OutOfMemoryError) {
                OutOfMemoryError outOfMemoryError = (OutOfMemoryError)executionException.getCause();
                throw outOfMemoryError;
            }
        }
        catch (InterruptedException interruptedException) {
            logger.fatal("Error executing task", (Throwable)interruptedException);
        }
        return null;
    }

    public static enum EnumOS {
        LINUX,
        SOLARIS,
        WINDOWS,
        OSX,
        UNKNOWN;

    }
}

