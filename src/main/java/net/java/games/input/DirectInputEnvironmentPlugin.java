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
import net.java.games.input.AbstractController;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.DIAbstractController;
import net.java.games.input.DIComponent;
import net.java.games.input.DIDeviceObject;
import net.java.games.input.DIIdentifierMap;
import net.java.games.input.DIKeyboard;
import net.java.games.input.DIMouse;
import net.java.games.input.DummyWindow;
import net.java.games.input.IDirectInput;
import net.java.games.input.IDirectInputDevice;
import net.java.games.input.Keyboard;
import net.java.games.input.Mouse;
import net.java.games.util.plugins.Plugin;

public class DirectInputEnvironmentPlugin
extends ControllerEnvironment
implements Plugin {
    private static boolean supported = false;
    private final Controller[] controllers;
    private final List active_devices = new ArrayList();
    private final DummyWindow window;

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

    public DirectInputEnvironmentPlugin() {
        DummyWindow dummyWindow = null;
        Controller[] controllerArray = new Controller[]{};
        if (this.isSupported()) {
            try {
                dummyWindow = new DummyWindow();
                try {
                    controllerArray = this.enumControllers(dummyWindow);
                }
                catch (IOException iOException) {
                    dummyWindow.destroy();
                    throw iOException;
                }
            }
            catch (IOException iOException) {
                DirectInputEnvironmentPlugin.logln("Failed to enumerate devices: " + iOException.getMessage());
            }
            this.window = dummyWindow;
            this.controllers = controllerArray;
            AccessController.doPrivileged(new PrivilegedAction(){

                public final Object run() {
                    Runtime.getRuntime().addShutdownHook(new ShutdownHook());
                    return null;
                }
            });
        } else {
            this.window = null;
            this.controllers = controllerArray;
        }
    }

    public final Controller[] getControllers() {
        return this.controllers;
    }

    private final Component[] createComponents(IDirectInputDevice iDirectInputDevice, boolean bl) {
        List list = iDirectInputDevice.getObjects();
        ArrayList<DIComponent> arrayList = new ArrayList<DIComponent>();
        for (int i = 0; i < list.size(); ++i) {
            DIDeviceObject dIDeviceObject = (DIDeviceObject)list.get(i);
            Component.Identifier identifier = dIDeviceObject.getIdentifier();
            if (identifier == null) continue;
            if (bl && identifier instanceof Component.Identifier.Button) {
                identifier = DIIdentifierMap.mapMouseButtonIdentifier((Component.Identifier.Button)identifier);
            }
            DIComponent dIComponent = new DIComponent(identifier, dIDeviceObject);
            arrayList.add(dIComponent);
            iDirectInputDevice.registerComponent(dIDeviceObject, dIComponent);
        }
        Component[] componentArray = new Component[arrayList.size()];
        arrayList.toArray(componentArray);
        return componentArray;
    }

    private final Mouse createMouseFromDevice(IDirectInputDevice iDirectInputDevice) {
        Component[] componentArray = this.createComponents(iDirectInputDevice, true);
        DIMouse dIMouse = new DIMouse(iDirectInputDevice, componentArray, new Controller[0], iDirectInputDevice.getRumblers());
        if (dIMouse.getX() != null && dIMouse.getY() != null && dIMouse.getPrimaryButton() != null) {
            return dIMouse;
        }
        return null;
    }

    private final AbstractController createControllerFromDevice(IDirectInputDevice iDirectInputDevice, Controller.Type type) {
        Component[] componentArray = this.createComponents(iDirectInputDevice, false);
        DIAbstractController dIAbstractController = new DIAbstractController(iDirectInputDevice, componentArray, new Controller[0], iDirectInputDevice.getRumblers(), type);
        return dIAbstractController;
    }

    private final Keyboard createKeyboardFromDevice(IDirectInputDevice iDirectInputDevice) {
        Component[] componentArray = this.createComponents(iDirectInputDevice, false);
        return new DIKeyboard(iDirectInputDevice, componentArray, new Controller[0], iDirectInputDevice.getRumblers());
    }

    private final Controller createControllerFromDevice(IDirectInputDevice iDirectInputDevice) {
        switch (iDirectInputDevice.getType()) {
            case 18: {
                return this.createMouseFromDevice(iDirectInputDevice);
            }
            case 19: {
                return this.createKeyboardFromDevice(iDirectInputDevice);
            }
            case 21: {
                return this.createControllerFromDevice(iDirectInputDevice, Controller.Type.GAMEPAD);
            }
            case 22: {
                return this.createControllerFromDevice(iDirectInputDevice, Controller.Type.WHEEL);
            }
            case 20: 
            case 23: 
            case 24: {
                return this.createControllerFromDevice(iDirectInputDevice, Controller.Type.STICK);
            }
        }
        return this.createControllerFromDevice(iDirectInputDevice, Controller.Type.UNKNOWN);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Controller[] enumControllers(DummyWindow dummyWindow) throws IOException {
        Controller[] controllerArray;
        ArrayList<Controller> arrayList = new ArrayList<Controller>();
        IDirectInput iDirectInput = new IDirectInput(dummyWindow);
        try {
            controllerArray = iDirectInput.getDevices();
            for (int i = 0; i < controllerArray.size(); ++i) {
                IDirectInputDevice iDirectInputDevice = (IDirectInputDevice)controllerArray.get(i);
                Controller controller = this.createControllerFromDevice(iDirectInputDevice);
                if (controller != null) {
                    arrayList.add(controller);
                    this.active_devices.add(iDirectInputDevice);
                    continue;
                }
                iDirectInputDevice.release();
            }
        }
        finally {
            iDirectInput.release();
        }
        controllerArray = new Controller[arrayList.size()];
        arrayList.toArray(controllerArray);
        return controllerArray;
    }

    public boolean isSupported() {
        return supported;
    }

    static {
        String string = DirectInputEnvironmentPlugin.getPrivilegedProperty("os.name", "").trim();
        if (string.startsWith("Windows")) {
            supported = true;
            if ("x86".equals(DirectInputEnvironmentPlugin.getPrivilegedProperty("os.arch"))) {
                DirectInputEnvironmentPlugin.loadLibrary("jinput-dx8");
            } else {
                DirectInputEnvironmentPlugin.loadLibrary("jinput-dx8_64");
            }
        }
    }

    private final class ShutdownHook
    extends Thread {
        private ShutdownHook() {
        }

        public final void run() {
            for (int i = 0; i < DirectInputEnvironmentPlugin.this.active_devices.size(); ++i) {
                IDirectInputDevice iDirectInputDevice = (IDirectInputDevice)DirectInputEnvironmentPlugin.this.active_devices.get(i);
                iDirectInputDevice.release();
            }
        }
    }
}

