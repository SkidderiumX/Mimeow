/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.opengl.GL11;
import x.oc1378bc114d;
import x.oc6a43806f12;
import x.oc8e5a0b9bfa;
import x.ocbd4917c4b1;

public class oca06105b17f {
    private static final float \u00f3 = 0.5f;
    private static final int \u0104 = -14540254;
    private static final int \u0288 = -14013910;
    private static final int \u04c7 = -12961222;
    private static final int \u04bb = -11184896;
    private static final int q = -2142596894;
    private static final int \u0406 = -3092272;
    private static final Field \u041e;
    private static final Field \u04e3;
    private static final Field \u0578;
    private static final Field \u01ac;
    private static final Field \u01ad;
    private static final Field \u013b;
    private static int \u0227;
    private final GuiTextField \u043b;
    private final String \u03d6;
    private final float \u049c;
    private boolean \u00ef;
    private long \u02b2;
    private boolean \u0207;

    public oca06105b17f(String string, int n) {
        this(string, n, 0.5f);
    }

    public oca06105b17f(String string, int n, float f) {
        this.\u03d6 = string == null ? "" : string;
        this.\u049c = f;
        this.\u043b = new GuiTextField(\u0227++, Minecraft.getMinecraft().fontRendererObj, 0, 0, 0x273E5759 ^ 0x273E573D, 0x273E5729 ^ 0x273E573D);
        this.\u043b.setMaxStringLength(n);
        this.\u043b.setEnableBackgroundDrawing(false);
        this.\u043b.setCanLoseFocus(true);
    }

    public void \u01e0(float f, float f2, float f3, float f4) {
        float f5 = f + 2.0f;
        float f6 = Math.max(0.0f, f3 - f - 4.0f);
        float f7 = f4 - 1.0f;
        float f8 = Math.max(0.0f, f7 - f2);
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        String string = this.\u043b.getText();
        int n = Math.max(0, Math.min(oca06105b17f.\u0467(this.\u043b, \u041e, 0), string.length()));
        String string2 = this.\u03d0(string, n, f6, oc1378bc114d2);
        String string3 = this.\u00ef ? oca06105b17f.\u017a(string2.length()) : string2;
        int n2 = oca06105b17f.\u0467(this.\u043b, \u04e3, string.length());
        int n3 = oca06105b17f.\u0467(this.\u043b, \u0578, n2);
        int n4 = n;
        int n5 = n4 + string3.length();
        float f9 = this.\u0149(f2, f8, oc1378bc114d2);
        int n6 = oca06105b17f.\u0578(this.\u043b, \u013b, true) ? oca06105b17f.\u0467(this.\u043b, \u01ac, 0xE29878BE ^ 0xE278985E) : oca06105b17f.\u0467(this.\u043b, \u01ad, 0xE208E82E ^ 0xE278985E);
        ocbd4917c4b1.\u0109(f, f2, f3, f7, this.\u04b2() ? 0x1D52B274 ^ 0xE278985E : 0x1D5ABA7C ^ 0xE278985E);
        ocbd4917c4b1.\u03d8(f, f2, f3, f7, 1.0f, this.\u04b2() ? 0x1D2DCD5E ^ 0xE278985E : 0x1D42A264 ^ 0xE278985E);
        if (!string3.isEmpty()) {
            this.\u0245(f5, f2, f7, oc1378bc114d2, string3, n2, n3, n4, n5);
            this.\u02b3(string3, f5, f9, n6, oc1378bc114d2);
        } else if (!this.\u043b.isFocused() && !this.\u03d6.isEmpty()) {
            this.\u02b3("\u00a77" + this.\u03d6, f5, f9, 0xE2D232F4 ^ 0xE278985E, oc1378bc114d2);
        }
        if (this.\u043b.isFocused() && this.\u0207) {
            this.\u0234(f5, f2, f7, oc1378bc114d2, string3, n2, n4, n5);
        }
    }

    public void \u01d9() {
        if (System.currentTimeMillis() - this.\u02b2 >= (0xF1730ACF6BAD487L ^ 0xF1730ACF6BAD573L)) {
            this.\u02b2 = System.currentTimeMillis();
            this.\u0207 = !this.\u0207;
        }
        this.\u043b.updateCursorCounter();
    }

    public boolean \u0438(int n, int n2, float f, float f2, float f3, float f4) {
        return (float)n >= f && (float)n <= f3 && (float)n2 >= f2 && (float)n2 <= f4;
    }

    public boolean \u04e7(char c, int n) {
        return this.\u043b.textboxKeyTyped(c, n);
    }

    public String Q() {
        return this.\u043b.getText();
    }

    public void \u03f1(String string) {
        this.\u043b.setText(string == null ? "" : string);
    }

    public void \u0432(boolean bl) {
        this.\u00ef = bl;
    }

    public boolean \u04b2() {
        return this.\u043b.isFocused();
    }

    public void B(boolean bl) {
        this.\u043b.setFocused(bl);
        if (bl) {
            this.\u0207 = true;
            this.\u02b2 = System.currentTimeMillis();
        }
    }

    private static String \u017a(int n) {
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            stringBuilder.append((char)(0xA68B6ED4 ^ 0xA68B4EF6));
        }
        return stringBuilder.toString();
    }

    private String \u03d0(String string, int n, float f, oc1378bc114d oc1378bc114d2) {
        if (string == null || string.isEmpty() || f <= 0.0f) {
            return "";
        }
        float f2 = f / this.\u049c;
        String string2 = string.substring(n);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string2.length(); ++i) {
            char c = string2.charAt(i);
            String string3 = stringBuilder.toString() + c;
            if ((float)oc1378bc114d2.z$toz8pt08w0nc(string3) > f2) break;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private void \u0245(float f, float f2, float f3, oc1378bc114d oc1378bc114d2, String string, int n, int n2, int n3, int n4) {
        int n5;
        int n6 = Math.min(n, n2);
        if (n6 == (n5 = Math.max(n, n2)) || n5 <= n3 || n6 >= n4) {
            return;
        }
        int n7 = Math.max(0, n6 - n3);
        int n8 = Math.min(string.length(), n5 - n3);
        float f4 = f + (float)oc1378bc114d2.z$toz8pt08w0nc(string.substring(0, n7)) * this.\u049c;
        float f5 = f + (float)oc1378bc114d2.z$toz8pt08w0nc(string.substring(0, n8)) * this.\u049c;
        if (f5 > f4) {
            ocbd4917c4b1.\u0109(f4, f2 + 1.0f, f5, f3 - 1.0f, 0x8F74EDF6 ^ 0xF3E7D14);
        }
    }

    private void \u0234(float f, float f2, float f3, oc1378bc114d oc1378bc114d2, String string, int n, int n2, int n3) {
        float f4 = n <= n2 ? f : (n >= n3 ? f + (float)oc1378bc114d2.z$toz8pt08w0nc(string) * this.\u049c : f + (float)oc1378bc114d2.z$toz8pt08w0nc(string.substring(0, n - n2)) * this.\u049c);
        ocbd4917c4b1.\u0109(f4, f2 + 2.0f, f4 + 1.0f, f3 - 2.0f, 0xD7CF2BCC ^ 0x281FFB1C);
    }

    private float \u0149(float f, float f2, oc1378bc114d oc1378bc114d2) {
        float f3 = Math.max(1.0f, (float)(oc1378bc114d2.z$w1h9nvoglpkn() - oc1378bc114d2.z$g5bxucc1j700()) * this.\u049c);
        return f + (f2 - f3) / 2.0f - (float)oc1378bc114d2.z$g5bxucc1j700() * this.\u049c;
    }

    private void \u02b3(String string, float f, float f2, int n, oc1378bc114d oc1378bc114d2) {
        GL11.glPushMatrix();
        GL11.glScaled(this.\u049c, this.\u049c, this.\u049c);
        oc1378bc114d2.z$ao2ykh4tuw6w(string, f / this.\u049c, f2 / this.\u049c, n, false);
        GL11.glPopMatrix();
    }

    private static int \u0467(GuiTextField guiTextField, Field field, int n) {
        try {
            return field.getInt(guiTextField);
        }
        catch (IllegalAccessException illegalAccessException) {
            return n;
        }
    }

    private static boolean \u0578(GuiTextField guiTextField, Field field, boolean bl) {
        try {
            return field.getBoolean(guiTextField);
        }
        catch (IllegalAccessException illegalAccessException) {
            return bl;
        }
    }

    static {
        String[] stringArray = new String[0x7D331F8C ^ 0x7D331F8E];
        stringArray[0] = "lineScrollOffset";
        stringArray[1] = "field_146225_q";
        \u041e = oc8e5a0b9bfa.\u020a(GuiTextField.class, stringArray);
        String[] stringArray2 = new String[0x7D331F8C ^ 0x7D331F8E];
        stringArray2[0] = "cursorPosition";
        stringArray2[1] = "field_146224_r";
        \u04e3 = oc8e5a0b9bfa.\u020a(GuiTextField.class, stringArray2);
        String[] stringArray3 = new String[0x7D331F8C ^ 0x7D331F8E];
        stringArray3[0] = "selectionEnd";
        stringArray3[1] = "field_146223_s";
        \u0578 = oc8e5a0b9bfa.\u020a(GuiTextField.class, stringArray3);
        String[] stringArray4 = new String[0x7D331F8C ^ 0x7D331F8E];
        stringArray4[0] = "enabledColor";
        stringArray4[1] = "field_146222_t";
        \u01ac = oc8e5a0b9bfa.\u020a(GuiTextField.class, stringArray4);
        String[] stringArray5 = new String[0x7D331F8C ^ 0x7D331F8E];
        stringArray5[0] = "disabledColor";
        stringArray5[1] = "field_146221_u";
        \u01ad = oc8e5a0b9bfa.\u020a(GuiTextField.class, stringArray5);
        String[] stringArray6 = new String[0x7D331F8C ^ 0x7D331F8E];
        stringArray6[0] = "isEnabled";
        stringArray6[1] = "field_146226_p";
        \u013b = oc8e5a0b9bfa.\u020a(GuiTextField.class, stringArray6);
    }
}

