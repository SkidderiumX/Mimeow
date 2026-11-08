/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import x.ocbb1bc27172;

public class oc0efa069b1c {
    private final Map<String, String> \u02a7 = new HashMap<String, String>();

    oc0efa069b1c(String string) {
        if (string != null) {
            for (String string2 : string.split("&")) {
                String[] stringArray = string2.split("=", 0x9C60C21 ^ 0x9C60C23);
                try {
                    this.\u02a7.put(URLDecoder.decode(stringArray[0], "UTF-8"), stringArray.length > 1 ? URLDecoder.decode(stringArray[1], "UTF-8") : "");
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }

    String \u0453(String string) {
        String string2;
        block2: {
            String string3;
            block3: {
                string3 = this.\u02a7.get(string);
                int n = ocbb1bc27172.\u050d;
                string2 = string3;
                if (n != 0) break block2;
                if (string2 != null) break block3;
                string2 = "";
                break block2;
            }
            string2 = string3;
        }
        return string2;
    }
}

