/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import net.java.games.input.Controller;

public class ControllerEvent {
    private Controller controller;

    public ControllerEvent(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }
}

