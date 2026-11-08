/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.DummyWindow;
import net.java.games.input.WinTabContext;
import net.java.games.util.plugins.Plugin;

public class WinTabEnvironmentPlugin
extends ControllerEnvironment
implements Plugin {
    private static boolean supported = false;
    private final Controller[] controllers;
    private final List active_devices = new ArrayList();
    private final WinTabContext winTabContext;

    static void loadLibrary(final String string) {
        AccessController.doPrivileged(new PrivilegedAction(){

            public final Object run() {
                try {
                    String string2 = System.getProperty("net.java.games.input.librarypath");
                    if (string2 != null) {
                        System.load(string2 + File.separator + System.mapLibraryName(string));
                    } else {
                        System.loadLibrary(string);
                    }
                }
                catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                    unsatisfiedLinkError.printStackTrace();
                    supported = false;
                }
                return null;
            }
        });
    }

    static String getPrivilegedProperty(final String string) {
        return (String)AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                return System.getProperty(string);
            }
        });
    }

    static String getPrivilegedProperty(final String string, final String string2) {
        return (String)AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                return System.getProperty(string, string2);
            }
        });
    }

    public WinTabEnvironmentPlugin() {
        if (this.isSupported()) {
            DummyWindow dummyWindow = null;
            WinTabContext winTabContext = null;
            Controller[] controllerArray = new Controller[]{};
            try {
                dummyWindow = new DummyWindow();
                winTabContext = new WinTabContext(dummyWindow);
                try {
                    winTabContext.open();
                    controllerArray = winTabContext.getControllers();
                }
                catch (Exception exception) {
                    dummyWindow.destroy();
                    throw exception;
                }
            }
            catch (Exception exception) {
                WinTabEnvironmentPlugin.logln("Failed to enumerate devices: " + exception.getMessage());
                exception.printStackTrace();
            }
            this.controllers = controllerArray;
            this.winTabContext = winTabContext;
            AccessController.doPrivileged(new PrivilegedAction(){

                public final Object run() {
                    Runtime.getRuntime().addShutdownHook(new ShutdownHook());
                    return null;
                }
            });
        } else {
            this.winTabContext = null;
            this.controllers = new Controller[0];
        }
    }

    public boolean isSupported() {
        return supported;
    }

    public Controller[] getControllers() {
        return this.controllers;
    }

    static {
        String string = WinTabEnvironmentPlugin.getPrivilegedProperty("os.name", "").trim();
        if (string.startsWith("Windows")) {
            supported = true;
            WinTabEnvironmentPlugin.loadLibrary("jinput-wintab");
        }
    }

    private final class ShutdownHook
    extends Thread {
        private ShutdownHook() {
        }

        public final void run() {
            for (int i = 0; i < WinTabEnvironmentPlugin.this.active_devices.size(); ++i) {
            }
            WinTabEnvironmentPlugin.this.winTabContext.close();
        }
    }
}

