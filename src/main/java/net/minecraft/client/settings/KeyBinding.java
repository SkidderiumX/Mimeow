/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.settings;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.IntHashMap;

public class KeyBinding
implements Comparable<KeyBinding> {
    private static final List<KeyBinding> keybindArray = Lists.newArrayList();
    private static final IntHashMap<KeyBinding> hash = new IntHashMap();
    private static final Set<String> keybindSet = Sets.newHashSet();
    private final String keyDescription;
    private final int keyCodeDefault;
    private final String keyCategory;
    private int keyCode;
    private boolean pressed;
    private int pressTime;

    public static void onTick(int n) {
        KeyBinding keyBinding;
        if (n != 0 && (keyBinding = hash.lookup(n)) != null) {
            ++keyBinding.pressTime;
        }
    }

    public static void setKeyBindState(int n, boolean bl) {
        KeyBinding keyBinding;
        if (n != 0 && (keyBinding = hash.lookup(n)) != null) {
            keyBinding.pressed = bl;
        }
    }

    public static void unPressAllKeys() {
        for (KeyBinding keyBinding : keybindArray) {
            keyBinding.unpressKey();
        }
    }

    public static void resetKeyBindingArrayAndHash() {
        hash.clearMap();
        for (KeyBinding keyBinding : keybindArray) {
            hash.addKey(keyBinding.keyCode, keyBinding);
        }
    }

    public static Set<String> getKeybinds() {
        return keybindSet;
    }

    public KeyBinding(String string, int n, String string2) {
        this.keyDescription = string;
        this.keyCode = n;
        this.keyCodeDefault = n;
        this.keyCategory = string2;
        keybindArray.add(this);
        hash.addKey(n, this);
        keybindSet.add(string2);
    }

    public boolean isKeyDown() {
        return this.pressed;
    }

    public String getKeyCategory() {
        return this.keyCategory;
    }

    public boolean isPressed() {
        if (this.pressTime == 0) {
            return false;
        }
        --this.pressTime;
        return true;
    }

    public void setPressTime(int n) {
        this.pressTime = n;
    }

    public void setPressed(boolean bl) {
        this.pressed = bl;
    }

    public void incrementPressTime() {
        ++this.pressTime;
    }

    private void unpressKey() {
        this.pressTime = 0;
        this.pressed = false;
    }

    public String getKeyDescription() {
        return this.keyDescription;
    }

    public int getKeyCodeDefault() {
        return this.keyCodeDefault;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public void setKeyCode(int n) {
        this.keyCode = n;
    }

    @Override
    public int compareTo(KeyBinding keyBinding) {
        int n = I18n.format(this.keyCategory, new Object[0]).compareTo(I18n.format(keyBinding.keyCategory, new Object[0]));
        if (n == 0) {
            n = I18n.format(this.keyDescription, new Object[0]).compareTo(I18n.format(keyBinding.keyDescription, new Object[0]));
        }
        return n;
    }
}

