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

public class oc0bf85e4d32
extends oced349c95c3 {
    private oc0bf85e4d32(String string2) {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    String z$2nxpapaw3t84h(JsonElement jsonElement) throws IOException {
        String string;
        Object object;
        block28: {
            int n;
            block26: {
                block27: {
                    JsonElement jsonElement2;
                    long l;
                    block25: {
                        JsonElement jsonElement3;
                        JsonArray jsonArray;
                        block24: {
                            block23: {
                                JsonElement jsonElement4;
                                block21: {
                                    block22: {
                                        long l2 = 0xB48FF67357FD3044L ^ 0xB48FD86E50FE02E3L;
                                        l = l2 ^ (0xB48FC381F9235604L ^ 0xB48FD86E50FE02E3L);
                                        n = oc804fdd8d75.\u0186;
                                        jsonElement4 = jsonElement;
                                        if (n != 0) break block21;
                                        if (jsonElement4.isJsonObject()) break block22;
                                        throw new IOException("Random API returned an invalid response");
                                    }
                                    jsonElement4 = jsonElement;
                                }
                                jsonArray = jsonElement4.getAsJsonObject().getAsJsonArray("data");
                                jsonElement3 = jsonArray;
                                if (n != 0) break block23;
                                if (jsonElement3 == null) throw new IOException("Random API returned no names");
                                jsonElement3 = jsonArray;
                            }
                            if (n != 0) break block24;
                            if (jsonElement3.size() == 0) throw new IOException("Random API returned no names");
                            jsonElement2 = jsonArray;
                            if (n != 0) break block25;
                            jsonElement3 = ((JsonArray)jsonElement2).get(0);
                        }
                        if (!jsonElement3.isJsonObject()) {
                            throw new IOException("Random API returned no names");
                        }
                        jsonElement2 = jsonArray.get(0);
                    }
                    JsonObject jsonObject = jsonElement2.getAsJsonObject();
                    object = oc499a9670c8.\u0157(l, jsonObject, "firstName") + oc499a9670c8.\u0157(l, jsonObject, "lastName");
                    string = object;
                    if (n != 0) break block26;
                    if (!string.isEmpty()) break block27;
                    object = oc499a9670c8.\u0157(l, jsonObject, "fullName");
                }
                string = object;
            }
            if (n != 0) return string;
            if (!string.isEmpty()) break block28;
            throw new IOException("Random API returned an empty name");
        }
        string = object;
        return string;
    }
}

