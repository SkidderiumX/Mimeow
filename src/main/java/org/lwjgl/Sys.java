/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import org.lwjgl.Version;

public class Sys {
    public static long getTime() {
        return System.nanoTime();
    }

    public static long getTimerResolution() {
        return 1000000000L;
    }

    public static boolean openURL(String string) {
        try {
            Class<?> clazz = Class.forName("javax.jnlp.ServiceManager");
            Method method = AccessController.doPrivileged(() -> clazz.getMethod("lookup", String.class));
            Object object = method.invoke(clazz, "javax.jnlp.BasicService");
            Class<?> clazz2 = Class.forName("javax.jnlp.BasicService");
            Method method2 = AccessController.doPrivileged(() -> clazz2.getMethod("showDocument", URL.class));
            try {
                return (Boolean)method2.invoke(object, new URL(string));
            }
            catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace(System.err);
                return false;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public static String getVersion() {
        return Version.getVersion();
    }
}

