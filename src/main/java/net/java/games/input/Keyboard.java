/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import net.java.games.input.AbstractController;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Rumbler;

public abstract class Keyboard
extends AbstractController {
    protected Keyboard(String string, Component[] componentArray, Controller[] controllerArray, Rumbler[] rumblerArray) {
        super(string, componentArray, controllerArray, rumblerArray);
    }

    public Controller.Type getType() {
        return Controller.Type.KEYBOARD;
    }

    public final boolean isKeyDown(Component.Identifier.Key key) {
        Component component = this.getComponent(key);
        if (component == null) {
            return false;
        }
        return component.getPollData() != 0.0f;
    }
}

