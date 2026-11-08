/*
 * Decompiled with CFR 0.152.
 */
package x;

import org.lwjgl.input.Keyboard;

public class occ573e1fe6c {
    private static final int[] \u03ed = occ573e1fe6c.\u00f5();

    private occ573e1fe6c() {
    }

    private static int[] \u00f5() {
        int n;
        int n2;
        int[] nArray = new int[0xF1875DE0 ^ 0xF1875D88];
        for (n2 = 1; n2 <= (0xF1875D8D ^ 0xF1875D88); ++n2) {
            nArray[n2] = n2 - (0xF1875DED ^ 0xF1875D88);
        }
        for (n2 = 0; n2 < (0xF1875D82 ^ 0xF1875D88); ++n2) {
            nArray[(0xF1875D8E ^ 0xF1875D88) + n2] = Keyboard.getKeyIndex(Integer.toString(n2));
            nArray[(0xF1875D98 ^ 0xF1875D88) + n2] = Keyboard.getKeyIndex("NUMPAD" + n2);
        }
        for (n2 = 0; n2 < (0xF1875D92 ^ 0xF1875D88); ++n2) {
            nArray[(0xF1875D92 ^ 0xF1875D88) + n2] = Keyboard.getKeyIndex(Character.toString((char)((0xF1875DC9 ^ 0xF1875D88) + n2)));
        }
        String[] stringArray = new String[0xF1875D83 ^ 0xF1875D88];
        stringArray[0] = "SEMICOLON";
        stringArray[1] = "EQUALS";
        stringArray[0xF1875D8A ^ 0xF1875D88] = "COMMA";
        stringArray[0xF1875D8B ^ 0xF1875D88] = "MINUS";
        stringArray[0xF1875D8C ^ 0xF1875D88] = "PERIOD";
        stringArray[0xF1875D8D ^ 0xF1875D88] = "SLASH";
        stringArray[0xF1875D8E ^ 0xF1875D88] = "GRAVE";
        stringArray[0xF1875D8F ^ 0xF1875D88] = "LBRACKET";
        stringArray[0xF1875D80 ^ 0xF1875D88] = "BACKSLASH";
        stringArray[0xF1875D81 ^ 0xF1875D88] = "RBRACKET";
        stringArray[0xF1875D82 ^ 0xF1875D88] = "APOSTROPHE";
        String[] stringArray2 = stringArray;
        for (int i = 0; i < stringArray2.length; ++i) {
            nArray[(0xF1875DBC ^ 0xF1875D88) + i] = Keyboard.getKeyIndex(stringArray2[i]);
        }
        String[] stringArray3 = new String[0xF1875D8C ^ 0xF1875D88];
        stringArray3[0] = "LEFT";
        stringArray3[1] = "UP";
        stringArray3[0xF1875D8A ^ 0xF1875D88] = "RIGHT";
        stringArray3[0xF1875D8B ^ 0xF1875D88] = "DOWN";
        String[] stringArray4 = stringArray3;
        for (n = 0; n < stringArray4.length; ++n) {
            nArray[(0xF1875DB7 ^ 0xF1875D88) + n] = Keyboard.getKeyIndex(stringArray4[n]);
        }
        for (n = 1; n <= (0xF1875D98 ^ 0xF1875D88); ++n) {
            nArray[(0xF1875DCA ^ 0xF1875D88) + n] = Keyboard.getKeyIndex("F" + n);
        }
        String[] stringArray5 = new String[0xF1875D9D ^ 0xF1875D88];
        stringArray5[0] = "BACK";
        stringArray5[1] = "TAB";
        stringArray5[0xF1875D8A ^ 0xF1875D88] = "RETURN";
        stringArray5[0xF1875D8B ^ 0xF1875D88] = "CAPITAL";
        stringArray5[0xF1875D8C ^ 0xF1875D88] = "ESCAPE";
        stringArray5[0xF1875D8D ^ 0xF1875D88] = "SPACE";
        stringArray5[0xF1875D8E ^ 0xF1875D88] = "PRIOR";
        stringArray5[0xF1875D8F ^ 0xF1875D88] = "NEXT";
        stringArray5[0xF1875D80 ^ 0xF1875D88] = "END";
        stringArray5[0xF1875D81 ^ 0xF1875D88] = "HOME";
        stringArray5[0xF1875D82 ^ 0xF1875D88] = "SYSRQ";
        stringArray5[0xF1875D83 ^ 0xF1875D88] = "INSERT";
        stringArray5[0xF1875D84 ^ 0xF1875D88] = "DELETE";
        stringArray5[0xF1875D85 ^ 0xF1875D88] = "NUMLOCK";
        stringArray5[0xF1875D86 ^ 0xF1875D88] = "SCROLL";
        stringArray5[0xF1875D87 ^ 0xF1875D88] = "LSHIFT";
        stringArray5[0xF1875D98 ^ 0xF1875D88] = "RSHIFT";
        stringArray5[0xF1875D99 ^ 0xF1875D88] = "LCONTROL";
        stringArray5[0xF1875D9A ^ 0xF1875D88] = "RCONTROL";
        stringArray5[0xF1875D9B ^ 0xF1875D88] = "LMENU";
        stringArray5[0xF1875D9C ^ 0xF1875D88] = "RMENU";
        String[] stringArray6 = stringArray5;
        for (int i = 0; i < stringArray6.length; ++i) {
            nArray[(0xF1875DDB ^ 0xF1875D88) + i] = Keyboard.getKeyIndex(stringArray6[i]);
        }
        return nArray;
    }

    public static boolean \u0129(int n) {
        return n > 0 && n < \u03ed.length && \u03ed[n] != 0;
    }

    public static int \u025b(int n) {
        return occ573e1fe6c.\u0129(n) ? \u03ed[n] : 0;
    }

    public static int \u0548(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == (0xE4B54EC3 ^ 0xE4B54E5F)) {
            return 0xE4B54E0A ^ 0xE4B54E5F;
        }
        for (int i = 0xE4B54E59 ^ 0xE4B54E5F; i < \u03ed.length; ++i) {
            if (\u03ed[i] != n) continue;
            return i;
        }
        return 0;
    }

    public static int \u01a1(int n) {
        return n >= 0 && n < (0x35477183 ^ 0x35477186) ? n + 1 : 0;
    }

    public static int \u0430(int n) {
        return n != 1 && n != (0xB357627B ^ 0xB357622C) ? n : 0;
    }
}

