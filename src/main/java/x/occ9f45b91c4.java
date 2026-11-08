/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import x.oc75d51ec7eb;
import x.occc82079da8;

public class occ9f45b91c4 {
    private static final Field \u0277;
    private static final String[] \u0457;
    public static int \u0428;

    private occ9f45b91c4() {
    }

    private static String[] \u01a1() {
        String[] stringArray;
        InputStream inputStream2 = occ9f45b91c4.class.getResourceAsStream("/assets/slinkysemantic/KeyNames.json");
        if (inputStream2 == null) {
            throw new IllegalStateException("Missing recovered key labels");
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2, "UTF-8");
        try {
            JsonArray jsonArray = new JsonParser().parse(inputStreamReader).getAsJsonArray();
            String[] stringArray2 = new String[jsonArray.size()];
            for (int i = 0; i < stringArray2.length; ++i) {
                stringArray2[i] = jsonArray.get(i).getAsString();
            }
            stringArray = stringArray2;
        }
        catch (Throwable throwable) {
            try {
                try {
                    ((Reader)inputStreamReader).close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
        }
        ((Reader)inputStreamReader).close();
        return stringArray;
    }

    public static String \u04f0(int n) {
        int n2 = n - 1;
        String string = Integer.compareUnsigned(n2, 0xB93AC332 ^ 0xB93AC354) > 0 ? \u0457[0] : \u0457[n];
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u0283(KeyBinding keyBinding) {
        int n;
        block12: {
            int n2;
            int n3;
            int n4;
            block10: {
                block11: {
                    n4 = keyBinding.getKeyCode();
                    n3 = oc75d51ec7eb.\u03e9;
                    n = n4;
                    if (n3 != 0) break block10;
                    if (n >= 0) break block11;
                    n2 = Mouse.isButtonDown(n4 + (0x8ADA93A7 ^ 0x8ADA93C3));
                    return n2 != 0;
                }
                n = n4;
            }
            if (n3 != 0) break block12;
            if (n > (0x8ADA92C3 ^ 0x8ADA93C3)) return 0 != 0;
            n2 = n4;
            if (n3 != 0) return n2 != 0;
            n = Keyboard.isKeyDown(n2) ? 1 : 0;
        }
        if (n == 0) return 0 != 0;
        return 1 != 0;
    }

    public static void \u010e(KeyBinding keyBinding) {
        occ9f45b91c4.L(keyBinding, occ9f45b91c4.\u0283(keyBinding));
    }

    public static void L(KeyBinding keyBinding, boolean bl) {
        try {
            \u0277.setBoolean(keyBinding, bl);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException("Cannot set key pressed state", illegalAccessException);
        }
    }

    static {
        String[] stringArray = new String[0xCFA67BB1 ^ 0xCFA67BB3];
        stringArray[0] = "pressed";
        stringArray[1] = "field_74513_e";
        \u0277 = occc82079da8.\u00d0(KeyBinding.class, stringArray);
        \u0457 = occ9f45b91c4.\u01a1();
    }
}

