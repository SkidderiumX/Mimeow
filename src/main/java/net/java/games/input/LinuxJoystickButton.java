/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import java.io.IOException;
import net.java.games.input.AbstractComponent;
import net.java.games.input.Component;

public class LinuxJoystickButton
extends AbstractComponent {
    private float value;

    public LinuxJoystickButton(Component.Identifier identifier) {
        super(identifier.getName(), identifier);
    }

    public final boolean isRelative() {
        return false;
    }

    final void setValue(float f) {
        this.value = f;
    }

    protected final float poll() throws IOException {
        return this.value;
    }
}

