/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Event;
import net.java.games.input.OSXComponent;
import net.java.games.input.OSXEvent;
import net.java.games.input.OSXHIDElement;
import net.java.games.input.OSXHIDQueue;

public class OSXControllers {
    private static final OSXEvent osx_event = new OSXEvent();

    OSXControllers() {
    }

    public static final synchronized float poll(OSXHIDElement oSXHIDElement) throws IOException {
        oSXHIDElement.getElementValue(osx_event);
        return oSXHIDElement.convertValue(osx_event.getValue());
    }

    public static final synchronized boolean getNextDeviceEvent(Event event, OSXHIDQueue oSXHIDQueue) throws IOException {
        if (oSXHIDQueue.getNextEvent(osx_event)) {
            OSXComponent oSXComponent = oSXHIDQueue.mapEvent(osx_event);
            event.set(oSXComponent, oSXComponent.getElement().convertValue(osx_event.getValue()), osx_event.getNanos());
            return true;
        }
        return false;
    }
}

