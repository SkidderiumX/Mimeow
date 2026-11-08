/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.util.plugins;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
public class PluginLoader
extends URLClassLoader {

    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        }
        catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }

    static final boolean DEBUG = false;
    File parentDir;
    boolean localDLLs = true;
    static /* synthetic */ Class class$net$java$games$util$plugins$Plugin;

    public PluginLoader(File file) throws MalformedURLException {
        super(new URL[]{file.toURL()}, Thread.currentThread().getContextClassLoader());
        this.parentDir = file.getParentFile();
        if (System.getProperty("net.java.games.util.plugins.nolocalnative") != null) {
            this.localDLLs = false;
        }
    }

    protected String findLibrary(String string) {
        if (this.localDLLs) {
            String string2 = this.parentDir.getPath() + File.separator + System.mapLibraryName(string);
            return string2;
        }
        return super.findLibrary(string);
    }

    public boolean attemptPluginDefine(Class clazz) {
        return !clazz.isInterface() && this.classImplementsPlugin(clazz);
    }

    private boolean classImplementsPlugin(Class clazz) {
        int n;
        if (clazz == null) {
            return false;
        }
        Class<?>[] classArray = clazz.getInterfaces();
        for (n = 0; n < classArray.length; ++n) {
            if (classArray[n] != (class$net$java$games$util$plugins$Plugin == null ? PluginLoader.class$("net.java.games.util.plugins.Plugin") : class$net$java$games$util$plugins$Plugin)) continue;
            return true;
        }
        for (n = 0; n < classArray.length; ++n) {
            if (!this.classImplementsPlugin(classArray[n])) continue;
            return true;
        }
        return this.classImplementsPlugin(clazz.getSuperclass());
    }
}

