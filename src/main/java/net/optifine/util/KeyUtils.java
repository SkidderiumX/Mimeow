/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import java.util.Arrays;
import java.util.HashSet;
import net.minecraft.client.settings.KeyBinding;

public class KeyUtils {
    public static void fixKeyConflicts(KeyBinding[] keyBindingArray, KeyBinding[] keyBindingArray2) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < keyBindingArray2.length; ++i) {
            KeyBinding keyBinding = keyBindingArray2[i];
            hashSet.add(keyBinding.getKeyCode());
        }
        HashSet<KeyBinding> hashSet2 = new HashSet<KeyBinding>(Arrays.asList(keyBindingArray));
        hashSet2.removeAll(Arrays.asList(keyBindingArray2));
        for (KeyBinding keyBinding : hashSet2) {
            Integer n = keyBinding.getKeyCode();
            if (!hashSet.contains(n)) continue;
            keyBinding.setKeyCode(0);
        }
    }
}

