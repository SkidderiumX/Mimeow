/*
 * Decompiled with CFR 0.152.
 */
package x;

import org.lwjgl.input.Mouse;
import x.oc6111f05032;
import x.oc75d51ec7eb;

public class oc5d43ea95a2 {
    public static int \u00d4;

    private oc5d43ea95a2() {
    }

    public static int \u04c9(int n) {
        int n2;
        block4: {
            block5: {
                int n3 = oc75d51ec7eb.\u03e9;
                n2 = n;
                if (n3 != 0) break block4;
                if (n2 != (0x784DF16F ^ 0x87B20EF2)) break block5;
                n2 = 1;
                break block4;
            }
            n2 = 0;
        }
        return n2;
    }

    public static boolean \u042b(oc6111f05032 oc6111f050322) {
        return Mouse.isButtonDown(oc5d43ea95a2.\u04c9(oc6111f050322.\u0128().gameSettings.keyBindAttack.getKeyCode()));
    }
}

