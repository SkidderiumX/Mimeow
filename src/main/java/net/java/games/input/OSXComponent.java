/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import java.io.IOException;
import net.java.games.input.AbstractComponent;
import net.java.games.input.Component;
import net.java.games.input.OSXControllers;
import net.java.games.input.OSXHIDElement;

public class OSXComponent
extends AbstractComponent {
    private final OSXHIDElement element;

    public OSXComponent(Component.Identifier identifier, OSXHIDElement oSXHIDElement) {
        super(identifier.getName(), identifier);
        this.element = oSXHIDElement;
    }

    public final boolean isRelative() {
        return this.element.isRelative();
    }

    public boolean isAnalog() {
        return this.element.isAnalog();
    }

    public final OSXHIDElement getElement() {
        return this.element;
    }

    protected float poll() throws IOException {
        return OSXControllers.poll(this.element);
    }
}

