/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import net.java.games.input.AbstractComponent;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Event;
import net.java.games.input.Keyboard;
import net.java.games.input.RawDevice;
import net.java.games.input.RawIdentifierMap;
import net.java.games.input.RawKeyboardEvent;
import net.java.games.input.Rumbler;

public class RawKeyboard
extends Keyboard {
    private final RawKeyboardEvent raw_event = new RawKeyboardEvent();
    private final RawDevice device;

    protected RawKeyboard(String string, RawDevice rawDevice, Controller[] controllerArray, Rumbler[] rumblerArray) throws IOException {
        super(string, RawKeyboard.createKeyboardComponents(rawDevice), controllerArray, rumblerArray);
        this.device = rawDevice;
    }

    private static final Component[] createKeyboardComponents(RawDevice rawDevice) {
        ArrayList<Key> arrayList = new ArrayList<Key>();
        Field[] fieldArray = RawIdentifierMap.class.getFields();
        for (int i = 0; i < fieldArray.length; ++i) {
            Field field = fieldArray[i];
            try {
                int n;
                Component.Identifier.Key key;
                if (!Modifier.isStatic(field.getModifiers()) || field.getType() != Integer.TYPE || (key = RawIdentifierMap.mapVKey(n = field.getInt(null))) == Component.Identifier.Key.UNKNOWN) continue;
                arrayList.add(new Key(rawDevice, n, key));
                continue;
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException(illegalAccessException);
            }
        }
        return arrayList.toArray(new Component[0]);
    }

    protected final synchronized boolean getNextDeviceEvent(Event event) throws IOException {
        Component component;
        while (true) {
            if (!this.device.getNextKeyboardEvent(this.raw_event)) {
                return false;
            }
            int n = this.raw_event.getVKey();
            Component.Identifier.Key key = RawIdentifierMap.mapVKey(n);
            component = this.getComponent(key);
            if (component == null) continue;
            int n2 = this.raw_event.getMessage();
            if (n2 == 256 || n2 == 260) {
                event.set(component, 1.0f, this.raw_event.getNanos());
                return true;
            }
            if (n2 == 257 || n2 == 261) break;
        }
        event.set(component, 0.0f, this.raw_event.getNanos());
        return true;
    }

    public final void pollDevice() throws IOException {
        this.device.pollKeyboard();
    }

    protected final void setDeviceEventQueueSize(int n) throws IOException {
        this.device.setBufferSize(n);
    }

    public static final class Key
    extends AbstractComponent {
        private final RawDevice device;
        private final int vkey_code;

        public Key(RawDevice rawDevice, int n, Component.Identifier.Key key) {
            super(key.getName(), key);
            this.device = rawDevice;
            this.vkey_code = n;
        }

        protected final float poll() throws IOException {
            return this.device.isKeyDown(this.vkey_code) ? 1.0f : 0.0f;
        }

        public final boolean isAnalog() {
            return false;
        }

        public final boolean isRelative() {
            return false;
        }
    }
}

