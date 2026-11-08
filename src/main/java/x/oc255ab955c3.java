/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import x.oc1378bc114d;
import x.oc3ebac73392;
import x.ocbd4917c4b1;
import x.ocd2958dac48;

public class oc255ab955c3 {
    static final int \u01d9 = -14079703;
    static final int W = -15132391;
    static final int \u00ec = -15724528;
    static final int \u02e1 = -1776740071;
    static final int \u047d = -1306978023;
    static final int \u037d = -1776740071;
    static final int \u010f = -14277082;
    static final int \u02a3 = -14671840;
    static final int \u03d7 = -15461356;
    static final int \u01bc = -15329770;
    static final int \u04ab = -15658735;
    static final int R = -1;
    static final int \u0258 = -6381922;
    static final int \u0224 = 15;

    private oc255ab955c3() {
    }

    static oc1378bc114d \u024c() {
        return oc3ebac73392.\u00db();
    }

    static oc1378bc114d B() {
        return oc3ebac73392.\u038c();
    }

    static oc1378bc114d \u0117() {
        return oc3ebac73392.\u04c0();
    }

    static boolean \u050e(float f, float f2, float f3, float f4, int n, int n2) {
        return (float)n >= f && (float)n <= f + f3 && (float)n2 >= f2 && (float)n2 <= f2 + f4;
    }

    static int \u0544(int n, int n2, oc1378bc114d oc1378bc114d2) {
        return n + Math.max(1, (n2 - oc1378bc114d2.z$1tqmx4tpnr6lq()) / (0x71758949 ^ 0x7175894B));
    }

    static void \u04df(float f, float f2, float f3, int n, int n2) {
        if (oc255ab955c3.\u050e(f, f2, f3, 15.0f, n, n2)) {
            Gui.drawRect((int)f, (int)f2, (int)(f + f3), (int)(f2 + 15.0f), 0x137DEB19 ^ 0x8564F200);
        }
    }

    static int \u01ea(double d, double d2) {
        return ocd2958dac48.\u02b0(d, d2);
    }

    static int \u0515(int n, int n2) {
        return Math.max(0, Math.min(0x77D6DA6C ^ 0x77D6DA93, n2)) << (0x77D6DA8B ^ 0x77D6DA93) | n & (0x7729256C ^ 0x77D6DA93);
    }

    static int \u0432(int n) {
        return (n & 1) == 0 ? 0x1068027A ^ 0xEF4E245C : 0x106E047C ^ 0xEF4E245C;
    }

    static int \u0269(int n) {
        return (n & 1) == 0 ? 0xD41EDFE3 ^ 0x2B08C9F5 : 0xD419D8E4 ^ 0x2B08C9F5;
    }

    static void \u0392(int n) {
        float f = (float)(n >>> (0xF97AD0B6 ^ 0xF97AD0AE) & (0xF97AD051 ^ 0xF97AD0AE)) / 255.0f;
        float f2 = (float)(n >>> (0xF97AD0BE ^ 0xF97AD0AE) & (0xF97AD051 ^ 0xF97AD0AE)) / 255.0f;
        float f3 = (float)(n >>> (0xF97AD0A6 ^ 0xF97AD0AE) & (0xF97AD051 ^ 0xF97AD0AE)) / 255.0f;
        float f4 = (float)(n & (0xF97AD051 ^ 0xF97AD0AE)) / 255.0f;
        GlStateManager.color(f2, f3, f4, f);
    }

    static boolean \u01ca(String string, float f, float f2, int n, int n2, int n3) {
        ResourceLocation resourceLocation = ocbd4917c4b1.\u02b8("/assets/idle.miau/textures/gui/miau/" + string + ".png");
        if (resourceLocation == null) {
            return false;
        }
        boolean bl = GL11.glIsEnabled(0x2328ADBA ^ 0x2328A6CB);
        boolean bl2 = GL11.glIsEnabled(0x2328AD29 ^ 0x2328A6CB);
        boolean bl3 = GL11.glGetBoolean(0x2328ADB9 ^ 0x2328A6CB);
        ocbd4917c4b1.\u0510();
        Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation);
        oc255ab955c3.\u0392(n3);
        Gui.drawModalRectWithCustomSizedTexture((int)f, (int)f2, 0.0f, 0.0f, n, n2, n, n2);
        ocbd4917c4b1.\u04fe(bl, bl2, bl3);
        return true;
    }

    static String \u026f(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        String string2 = string.replace((char)(0x1C4FA07D ^ 0x1C4FA022), (char)(0x1C4FA002 ^ 0x1C4FA022));
        return Character.toUpperCase(string2.charAt(0)) + string2.substring(1);
    }

    static String \u0516(String string, oc1378bc114d oc1378bc114d2, int n) {
        String string2;
        if (string == null || n <= 0) {
            return "";
        }
        if (oc1378bc114d2.z$toz8pt08w0nc(string) <= n) {
            return string;
        }
        String string3 = "...";
        int n2 = Math.max(0, n - oc1378bc114d2.z$toz8pt08w0nc(string3));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length() && oc1378bc114d2.z$toz8pt08w0nc(string2 = stringBuilder.toString() + string.charAt(i)) <= n2; ++i) {
            stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.append(string3).toString();
    }
}

