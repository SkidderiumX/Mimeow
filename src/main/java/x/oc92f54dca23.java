/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.sun.jna.platform.win32.Crypt32Util;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Locale;
import x.oc59f0ab164a;
import x.oc69da1aa7f5;
import x.oc8e502b72ab;

public class oc92f54dca23
implements oc59f0ab164a {
    private final oc8e502b72ab \u0576 = new oc8e502b72ab(false);
    public static boolean \u0523;

    @Override
    public String z$2d18fe1ddtiun(String string) {
        String string2;
        block4: {
            boolean bl;
            block6: {
                block5: {
                    byte[] byArray = Crypt32Util.cryptProtectData(string.getBytes(StandardCharsets.UTF_8));
                    boolean bl2 = false;
                    string2 = Base64.getEncoder().encodeToString(byArray);
                    if (!bl2) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
        return string2;
    }

    @Override
    public String z$3gaj86hkfeiuj(String string) throws Exception {
        try {
            byte[] byArray = Base64.getDecoder().decode(string);
            return new String(Crypt32Util.cryptUnprotectData(byArray), StandardCharsets.UTF_8);
        }
        catch (Throwable throwable) {
            return this.\u0576.\u01c6(string);
        }
    }

    @Override
    public String z$3f9e4c95piano() {
        return "windows-dpapi-user";
    }

    public static boolean \u01f3() {
        return System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("win");
    }
}

