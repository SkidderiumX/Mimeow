/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Event;
import net.java.games.input.Keyboard;
import net.java.games.input.OSXControllers;
import net.java.games.input.OSXHIDDevice;
import net.java.games.input.OSXHIDQueue;
import net.java.games.input.Rumbler;

public class OSXKeyboard
extends Keyboard {
    private final Controller.PortType port;
    private final OSXHIDQueue queue;

    protected OSXKeyboard(OSXHIDDevice oSXHIDDevice, OSXHIDQueue oSXHIDQueue, Component[] componentArray, Controller[] controllerArray, Rumbler[] rumblerArray) {
        super(oSXHIDDevice.getProductName(), componentArray, controllerArray, rumblerArray);
        this.queue = oSXHIDQueue;
        this.port = oSXHIDDevice.getPortType();
    }

    protected final boolean getNextDeviceEvent(Event event) throws IOException {
        return OSXControllers.getNextDeviceEvent(event, this.queue);
    }

    protected final void setDeviceEventQueueSize(int n) throws IOException {
        this.queue.setQueueDepth(n);
    }

    public final Controller.PortType getPortType() {
        return this.port;
    }
}

