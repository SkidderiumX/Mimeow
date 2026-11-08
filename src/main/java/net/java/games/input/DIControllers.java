/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component;
import net.java.games.input.DIComponent;
import net.java.games.input.DIDeviceObject;
import net.java.games.input.DIDeviceObjectData;
import net.java.games.input.Event;
import net.java.games.input.IDirectInputDevice;

public class DIControllers {
    private static final DIDeviceObjectData di_event = new DIDeviceObjectData();

    DIControllers() {
    }

    public static final synchronized boolean getNextDeviceEvent(Event event, IDirectInputDevice iDirectInputDevice) throws IOException {
        if (!iDirectInputDevice.getNextEvent(di_event)) {
            return false;
        }
        DIDeviceObject dIDeviceObject = iDirectInputDevice.mapEvent(di_event);
        DIComponent dIComponent = iDirectInputDevice.mapObject(dIDeviceObject);
        if (dIComponent == null) {
            return false;
        }
        int n = dIDeviceObject.isRelative() ? dIDeviceObject.getRelativeEventValue(di_event.getData()) : di_event.getData();
        event.set(dIComponent, dIComponent.getDeviceObject().convertValue(n), di_event.getNanos());
        return true;
    }

    public static final float poll(Component component, DIDeviceObject dIDeviceObject) throws IOException {
        int n = dIDeviceObject.getDevice().getPollData(dIDeviceObject);
        float f = dIDeviceObject.isRelative() ? (float)dIDeviceObject.getRelativePollValue(n) : (float)n;
        return dIDeviceObject.convertValue(f);
    }
}

