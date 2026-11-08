/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.util.plugins.Plugins;

public class DefaultControllerEnvironment
extends ControllerEnvironment {
    static String libPath;
    private static Logger log;
    private ArrayList controllers;
    private Collection loadedPlugins = new ArrayList();

    static void loadLibrary(final String string) {
        AccessController.doPrivileged(new PrivilegedAction(){

            public final Object run() {
                String string2 = System.getProperty("net.java.games.input.librarypath");
                if (string2 != null) {
                    System.load(string2 + File.separator + System.mapLibraryName(string));
                } else {
                    System.loadLibrary(string);
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

    public Controller[] getControllers() {
        Object object;
        Object object2;
        if (this.controllers == null) {
            this.controllers = new ArrayList();
            AccessController.doPrivileged(new PrivilegedAction(){

                public Object run() {
                    DefaultControllerEnvironment.this.scanControllers();
                    return null;
                }
            });
            object2 = DefaultControllerEnvironment.getPrivilegedProperty("jinput.plugins", "") + " " + DefaultControllerEnvironment.getPrivilegedProperty("net.java.games.input.plugins", "");
            if (!DefaultControllerEnvironment.getPrivilegedProperty("jinput.useDefaultPlugin", "true").toLowerCase().trim().equals("false") && !DefaultControllerEnvironment.getPrivilegedProperty("net.java.games.input.useDefaultPlugin", "true").toLowerCase().trim().equals("false")) {
                object = DefaultControllerEnvironment.getPrivilegedProperty("os.name", "").trim();
                if (((String)object).equals("Linux")) {
                    object2 = (String)object2 + " net.java.games.input.LinuxEnvironmentPlugin";
                } else if (((String)object).equals("Mac OS X")) {
                    object2 = (String)object2 + " net.java.games.input.OSXEnvironmentPlugin";
                } else if (((String)object).equals("Windows XP") || ((String)object).equals("Windows Vista") || ((String)object).equals("Windows 7")) {
                    object2 = (String)object2 + " net.java.games.input.DirectAndRawInputEnvironmentPlugin";
                } else if (((String)object).equals("Windows 98") || ((String)object).equals("Windows 2000")) {
                    object2 = (String)object2 + " net.java.games.input.DirectInputEnvironmentPlugin";
                } else if (((String)object).startsWith("Windows")) {
                    log.warning("Found unknown Windows version: " + (String)object);
                    log.info("Attempting to use default windows plug-in.");
                    object2 = (String)object2 + " net.java.games.input.DirectAndRawInputEnvironmentPlugin";
                } else {
                    log.info("Trying to use default plugin, OS name " + (String)object + " not recognised");
                }
            }
            object = new StringTokenizer((String)object2, " \t\n\r\f,;:");
            while (((StringTokenizer)object).hasMoreTokens()) {
                String string = ((StringTokenizer)object).nextToken();
                try {
                    if (this.loadedPlugins.contains(string)) continue;
                    log.info("Loading: " + string);
                    Class<?> clazz = Class.forName(string);
                    ControllerEnvironment controllerEnvironment = (ControllerEnvironment)clazz.newInstance();
                    if (controllerEnvironment.isSupported()) {
                        this.addControllers(controllerEnvironment.getControllers());
                        this.loadedPlugins.add(controllerEnvironment.getClass().getName());
                        continue;
                    }
                    DefaultControllerEnvironment.logln(clazz.getName() + " is not supported");
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
        object2 = new Controller[this.controllers.size()];
        object = this.controllers.iterator();
        int n = 0;
        while (object.hasNext()) {
            object2[n] = (Controller)object.next();
            ++n;
        }
        return object2;
    }

    private void scanControllers() {
        String string = DefaultControllerEnvironment.getPrivilegedProperty("jinput.controllerPluginPath");
        if (string == null) {
            string = "controller";
        }
        this.scanControllersAt(DefaultControllerEnvironment.getPrivilegedProperty("java.home") + File.separator + "lib" + File.separator + string);
        this.scanControllersAt(DefaultControllerEnvironment.getPrivilegedProperty("user.dir") + File.separator + string);
    }

    private void scanControllersAt(String string) {
        File file = new File(string);
        if (!file.exists()) {
            return;
        }
        try {
            Plugins plugins = new Plugins(file);
            Class[] classArray = plugins.getExtends(ControllerEnvironment.class);
            for (int i = 0; i < classArray.length; ++i) {
                try {
                    ControllerEnvironment.logln("ControllerEnvironment " + classArray[i].getName() + " loaded by " + classArray[i].getClassLoader());
                    ControllerEnvironment controllerEnvironment = (ControllerEnvironment)classArray[i].newInstance();
                    if (controllerEnvironment.isSupported()) {
                        this.addControllers(controllerEnvironment.getControllers());
                        this.loadedPlugins.add(controllerEnvironment.getClass().getName());
                        continue;
                    }
                    DefaultControllerEnvironment.logln(classArray[i].getName() + " is not supported");
                    continue;
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void addControllers(Controller[] controllerArray) {
        for (int i = 0; i < controllerArray.length; ++i) {
            this.controllers.add(controllerArray[i]);
        }
    }

    public boolean isSupported() {
        return true;
    }

    static {
        log = Logger.getLogger(DefaultControllerEnvironment.class.getName());
    }
}

