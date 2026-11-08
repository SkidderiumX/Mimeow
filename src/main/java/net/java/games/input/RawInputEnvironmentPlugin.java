/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.RawDevice;
import net.java.games.input.RawDeviceInfo;
import net.java.games.input.RawInputEventQueue;
import net.java.games.input.SetupAPIDevice;
import net.java.games.util.plugins.Plugin;

public class RawInputEnvironmentPlugin
extends ControllerEnvironment
implements Plugin {
    private static boolean supported = false;
    private final Controller[] controllers;

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

    public RawInputEnvironmentPlugin() {
        Controller[] controllerArray = new Controller[]{};
        if (this.isSupported()) {
            try {
                RawInputEventQueue rawInputEventQueue = new RawInputEventQueue();
                controllerArray = this.enumControllers(rawInputEventQueue);
            }
            catch (IOException iOException) {
                RawInputEnvironmentPlugin.logln("Failed to enumerate devices: " + iOException.getMessage());
            }
        }
        this.controllers = controllerArray;
    }

    public final Controller[] getControllers() {
        return this.controllers;
    }

    private static final SetupAPIDevice lookupSetupAPIDevice(String string, List list) {
        string = string.replaceAll("#", "\\\\").toUpperCase();
        for (int i = 0; i < list.size(); ++i) {
            SetupAPIDevice setupAPIDevice = (SetupAPIDevice)list.get(i);
            if (string.indexOf(setupAPIDevice.getInstanceId().toUpperCase()) == -1) continue;
            return setupAPIDevice;
        }
        return null;
    }

    private static final void createControllersFromDevices(RawInputEventQueue rawInputEventQueue, List list, List list2, List list3) throws IOException {
        ArrayList<RawDevice> arrayList = new ArrayList<RawDevice>();
        for (int i = 0; i < list2.size(); ++i) {
            RawDeviceInfo rawDeviceInfo;
            Controller controller;
            RawDevice rawDevice = (RawDevice)list2.get(i);
            SetupAPIDevice setupAPIDevice = RawInputEnvironmentPlugin.lookupSetupAPIDevice(rawDevice.getName(), list3);
            if (setupAPIDevice == null || (controller = (rawDeviceInfo = rawDevice.getInfo()).createControllerFromDevice(rawDevice, setupAPIDevice)) == null) continue;
            list.add(controller);
            arrayList.add(rawDevice);
        }
        rawInputEventQueue.start(arrayList);
    }

    private static final native void enumerateDevices(RawInputEventQueue var0, List var1) throws IOException;

    private final Controller[] enumControllers(RawInputEventQueue rawInputEventQueue) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        RawInputEnvironmentPlugin.enumerateDevices(rawInputEventQueue, arrayList2);
        List list = RawInputEnvironmentPlugin.enumSetupAPIDevices();
        RawInputEnvironmentPlugin.createControllersFromDevices(rawInputEventQueue, arrayList, arrayList2, list);
        Controller[] controllerArray = new Controller[arrayList.size()];
        arrayList.toArray(controllerArray);
        return controllerArray;
    }

    public boolean isSupported() {
        return supported;
    }

    private static final List enumSetupAPIDevices() throws IOException {
        ArrayList arrayList = new ArrayList();
        RawInputEnvironmentPlugin.nEnumSetupAPIDevices(RawInputEnvironmentPlugin.getKeyboardClassGUID(), arrayList);
        RawInputEnvironmentPlugin.nEnumSetupAPIDevices(RawInputEnvironmentPlugin.getMouseClassGUID(), arrayList);
        return arrayList;
    }

    private static final native void nEnumSetupAPIDevices(byte[] var0, List var1) throws IOException;

    private static final native byte[] getKeyboardClassGUID();

    private static final native byte[] getMouseClassGUID();

    static {
        String string = RawInputEnvironmentPlugin.getPrivilegedProperty("os.name", "").trim();
        if (string.startsWith("Windows")) {
            supported = true;
            if ("x86".equals(RawInputEnvironmentPlugin.getPrivilegedProperty("os.arch"))) {
                RawInputEnvironmentPlugin.loadLibrary("jinput-raw");
            } else {
                RawInputEnvironmentPlugin.loadLibrary("jinput-raw_64");
            }
        }
    }
}

