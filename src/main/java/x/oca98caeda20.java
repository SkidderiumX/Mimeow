/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import x.W;
import x.oc1378bc114d;
import x.oc255ab955c3;

public class oca98caeda20 {
    private static int \u04fd;
    private final GuiTextField \u0136;
    private final String \u03d7;
    private boolean \u0292;

    oca98caeda20(String string, int n) {
        this.\u03d7 = string == null ? "" : string;
        this.\u0136 = new GuiTextField(\u04fd++, Minecraft.getMinecraft().fontRendererObj, 0, 0, 0xC26743F3 ^ 0xC2674383, 0xC267438D ^ 0xC2674383);
        this.\u0136.setMaxStringLength(Math.max(1, n));
        this.\u0136.setEnableBackgroundDrawing(false);
        this.\u0136.setCanLoseFocus(true);
    }

    void \u01da(float f, float f2, float f3) {
        int n;
        Object object;
        W.\u02e0(f, f2, f3, 14.0f, 3.0f, this.\u0136.isFocused() ? 0xF50C41E1 ^ 0xA2C61C1 : 0xF53578D8 ^ 0xA2C61C1);
        int n2 = this.\u0136.isFocused() ? oc255ab955c3.\u01ea((double)f + (double)f3 * 0.5, (double)f2 + 7.0) : 0xF51F52F2 ^ 0xA2C61C1;
        W.\u02e0(f, f2 + 12.0f, f3, 2.0f, 1.0f, n2);
        Object object2 = this.\u0136.getText();
        if (this.\u0292 && !((String)object2).isEmpty()) {
            object = new StringBuilder();
            for (n = 0; n < ((String)object2).length(); ++n) {
                ((StringBuilder)object).append((char)(0xA2C41E3 ^ 0xA2C61C1));
            }
            object2 = ((StringBuilder)object).toString();
        }
        if (((String)object2).isEmpty() && !this.\u0136.isFocused()) {
            object2 = this.\u03d7;
        }
        object = oc255ab955c3.\u0117();
        object2 = oca98caeda20.\u0275((String)object2, Math.max(0, (int)f3 - (0xA2C61C4 ^ 0xA2C61C1)));
        int n3 = n = this.\u0136.getText().isEmpty() && !this.\u0136.isFocused() ? 0xF5B2FF5F ^ 0xA2C61C1 : -1;
        if (this.\u0136.isFocused() && System.currentTimeMillis() / (0xCD45E799BE412383L ^ 0xCD45E799BE412277L) % (0xCD45E799BE412275L ^ 0xCD45E799BE412277L) == 0L) {
            object2 = (String)object2 + "_";
        }
        object.z$ao2ykh4tuw6w((String)object2, f + 3.0f, f2 + 3.0f, n, false);
        this.\u0136.updateCursorCounter();
    }

    boolean \u01dd(char c, int n) {
        if (!this.\u0136.isFocused()) {
            return false;
        }
        if (n == 1) {
            this.\u0136.setFocused(false);
            return true;
        }
        return this.\u0136.textboxKeyTyped(c, n);
    }

    void \u04cc() {
        this.\u0136.setFocused(true);
        this.\u0136.setCursorPositionEnd();
    }

    void \u02e1() {
        this.\u0136.setFocused(false);
    }

    boolean \u0175() {
        return this.\u0136.isFocused();
    }

    String \u01af() {
        return this.\u0136.getText();
    }

    void \u039d(String string) {
        this.\u0136.setText(string == null ? "" : string);
    }

    void \u00fd(boolean bl) {
        this.\u0292 = bl;
    }

    private static String \u0275(String string, int n) {
        int n2;
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.\u0117();
        if (oc1378bc114d2.z$toz8pt08w0nc(string) <= n) {
            return string;
        }
        for (n2 = 0; n2 < string.length() && oc1378bc114d2.z$toz8pt08w0nc(string.substring(n2)) > n; ++n2) {
        }
        return string.substring(n2);
    }
}

