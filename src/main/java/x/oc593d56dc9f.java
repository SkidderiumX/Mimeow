/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import x.oc499a9670c8;
import x.oc804fdd8d75;
import x.oced349c95c3;

public class oc593d56dc9f
extends oced349c95c3 {
    private oc593d56dc9f(String string2) {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    String z$2nxpapaw3t84h(JsonElement jsonElement) throws IOException {
        String string;
        String string2;
        block24: {
            JsonElement jsonElement2;
            int n;
            long l;
            block23: {
                JsonElement jsonElement3;
                JsonArray jsonArray;
                block22: {
                    block21: {
                        JsonElement jsonElement4;
                        block19: {
                            block20: {
                                long l2 = 0x2BC61A1B2660F467L ^ 0x2BC634062163C6C0L;
                                l = l2 ^ (0x2BC62FE988BE9227L ^ 0x2BC634062163C6C0L);
                                n = oc804fdd8d75.\u0186;
                                jsonElement4 = jsonElement;
                                if (n != 0) break block19;
                                if (jsonElement4.isJsonObject()) break block20;
                                throw new IOException("Random User API returned an invalid response");
                            }
                            jsonElement4 = jsonElement;
                        }
                        jsonArray = jsonElement4.getAsJsonObject().getAsJsonArray("results");
                        jsonElement3 = jsonArray;
                        if (n != 0) break block21;
                        if (jsonElement3 == null) throw new IOException("Random User API returned no users");
                        jsonElement3 = jsonArray;
                    }
                    if (n != 0) break block22;
                    if (jsonElement3.size() == 0) throw new IOException("Random User API returned no users");
                    jsonElement2 = jsonArray;
                    if (n != 0) break block23;
                    jsonElement3 = ((JsonArray)jsonElement2).get(0);
                }
                if (!jsonElement3.isJsonObject()) {
                    throw new IOException("Random User API returned no users");
                }
                jsonElement2 = jsonArray.get(0);
            }
            JsonObject jsonObject = jsonElement2.getAsJsonObject().getAsJsonObject("name");
            string2 = oc499a9670c8.\u0157(l, jsonObject, "first") + oc499a9670c8.\u0157(l, jsonObject, "last");
            string = string2;
            if (n != 0) return string;
            if (!string.isEmpty()) break block24;
            throw new IOException("Random User API returned an empty name");
        }
        string = string2;
        return string;
    }
}

