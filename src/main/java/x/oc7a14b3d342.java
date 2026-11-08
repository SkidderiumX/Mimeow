/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import x.oc51f4f13c5a;
import x.oc6bed6d7740;
import x.ocbb1bc27172;
import x.oce7be97fef5;

public class oc7a14b3d342 {
    private static final String \u00df = "https://api.spotify.com/v1";
    private final oce7be97fef5 \u0561;
    public static boolean \u00f1;

    public oc7a14b3d342(oce7be97fef5 oce7be97fef52) {
        this.\u0561 = oce7be97fef52;
    }

    public oc51f4f13c5a \u04d9(String string) throws IOException {
        return this.\u0396("GET", "/me/player/currently-playing", string, "");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ocbb1bc27172 \u0397(oc51f4f13c5a oc51f4f13c5a2) {
        String string;
        String string2;
        String string3;
        JsonObject jsonObject;
        JsonObject jsonObject2;
        JsonObject jsonObject3;
        block47: {
            block46: {
                JsonObject jsonObject4;
                block45: {
                    String string4;
                    block43: {
                        int n;
                        block44: {
                            block41: {
                                block42: {
                                    JsonObject jsonObject5;
                                    block39: {
                                        block40: {
                                            JsonObject jsonObject6;
                                            block38: {
                                                String string5;
                                                block37: {
                                                    oc51f4f13c5a oc51f4f13c5a3;
                                                    block36: {
                                                        n = ocbb1bc27172.\u050d;
                                                        oc51f4f13c5a3 = oc51f4f13c5a2;
                                                        if (n != 0) break block36;
                                                        if (oc51f4f13c5a3.\u0463() == (0x3A2B9945 ^ 0x3A2B9989)) return ocbb1bc27172.\u00e4;
                                                        oc51f4f13c5a3 = oc51f4f13c5a2;
                                                    }
                                                    if (oc51f4f13c5a3.\u02a4().isEmpty()) {
                                                        return ocbb1bc27172.\u00e4;
                                                    }
                                                    jsonObject3 = new JsonParser().parse(oc51f4f13c5a2.\u02a4()).getAsJsonObject();
                                                    jsonObject6 = jsonObject3;
                                                    string5 = "item";
                                                    if (n != 0) break block37;
                                                    if (!jsonObject6.has(string5)) return ocbb1bc27172.\u00e4;
                                                    jsonObject6 = jsonObject3;
                                                    if (n != 0) break block38;
                                                    string5 = "item";
                                                }
                                                if (jsonObject6.get(string5).isJsonNull()) {
                                                    return ocbb1bc27172.\u00e4;
                                                }
                                                jsonObject6 = jsonObject3.getAsJsonObject("item");
                                            }
                                            jsonObject2 = jsonObject6;
                                            jsonObject5 = jsonObject2;
                                            if (n != 0) break block39;
                                            if (!jsonObject5.has("album")) break block40;
                                            jsonObject5 = jsonObject2.getAsJsonObject("album");
                                            break block39;
                                        }
                                        jsonObject5 = new JsonObject();
                                    }
                                    jsonObject = jsonObject5;
                                    string3 = "";
                                    string2 = "";
                                    jsonObject4 = jsonObject2;
                                    if (n != 0) break block41;
                                    if (!jsonObject4.has("artists")) break block42;
                                    jsonObject4 = jsonObject2;
                                    if (n != 0) break block41;
                                    if (jsonObject4.getAsJsonArray("artists").size() <= 0) break block42;
                                    string3 = oc7a14b3d342.\u027a(jsonObject2.getAsJsonArray("artists").get(0).getAsJsonObject(), "name");
                                }
                                jsonObject4 = jsonObject;
                            }
                            string4 = "images";
                            if (n != 0) break block43;
                            if (!jsonObject4.has(string4)) break block44;
                            jsonObject4 = jsonObject;
                            string4 = "images";
                            if (n != 0) break block43;
                            if (jsonObject4.getAsJsonArray(string4).size() <= 0) break block44;
                            string2 = oc7a14b3d342.\u027a(jsonObject.getAsJsonArray("images").get(0).getAsJsonObject(), "url");
                        }
                        jsonObject4 = jsonObject2;
                        if (n != 0) break block45;
                        string4 = "external_urls";
                    }
                    if (!jsonObject4.has(string4)) break block46;
                    jsonObject4 = jsonObject2.getAsJsonObject("external_urls");
                }
                string = oc7a14b3d342.\u027a(jsonObject4, "spotify");
                break block47;
            }
            string = "";
        }
        String string6 = string;
        return new ocbb1bc27172(oc7a14b3d342.\u045d(jsonObject3, "is_playing"), oc7a14b3d342.\u027a(jsonObject2, "name"), string3, oc7a14b3d342.\u027a(jsonObject, "name"), string2, oc7a14b3d342.\u027a(jsonObject2, "id"), "", string6, oc7a14b3d342.\u045d(jsonObject2, "explicit"), false, "off", oc7a14b3d342.\u049a(jsonObject3, "progress_ms"), oc7a14b3d342.\u049a(jsonObject2, "duration_ms"), System.currentTimeMillis());
    }

    public oc51f4f13c5a \u03cd(String string) throws IOException {
        return this.\u0396("PUT", "/me/player/pause", string, "");
    }

    public oc51f4f13c5a \u00ba(String string) throws IOException {
        return this.\u0396("PUT", "/me/player/play", string, "");
    }

    public oc51f4f13c5a \u04db(String string) throws IOException {
        return this.\u0396("POST", "/me/player/next", string, "");
    }

    public oc51f4f13c5a \u0510(String string) throws IOException {
        return this.\u0396("POST", "/me/player/previous", string, "");
    }

    public oc51f4f13c5a \u01b6(String string, int n) throws IOException {
        return this.\u0396("PUT", "/me/player/volume?volume_percent=" + Math.max(0, Math.min(0x20391D30 ^ 0x20391D54, n)), string, "");
    }

    private oc51f4f13c5a \u0396(String string, String string2, String string3, String string4) throws IOException {
        return this.\u0561.z$1ahjbl7dqoxur(oc6bed6d7740.\u0289(string, "https://api.spotify.com/v1" + string2).\u01ce("Authorization", "Bearer " + string3).\u01ce("Content-Type", "application/json").\u024f(string4).\u0290());
    }

    private static String \u027a(JsonObject jsonObject, String string) {
        String string2;
        block14: {
            block11: {
                String string3;
                JsonObject jsonObject2;
                block13: {
                    JsonElement jsonElement;
                    block12: {
                        int n;
                        block10: {
                            n = ocbb1bc27172.\u050d;
                            jsonElement = jsonObject;
                            if (n != 0) break block10;
                            if (jsonElement == null) break block11;
                            jsonElement = jsonObject;
                        }
                        if (n != 0) break block12;
                        if (!jsonElement.has(string)) break block11;
                        jsonObject2 = jsonObject;
                        string3 = string;
                        if (n != 0) break block13;
                        jsonElement = jsonObject2.get(string3);
                    }
                    if (jsonElement.isJsonNull()) break block11;
                    jsonObject2 = jsonObject;
                    string3 = string;
                }
                string2 = jsonObject2.get(string3).getAsString();
                break block14;
            }
            string2 = "";
        }
        return string2;
    }

    private static boolean \u045d(JsonObject jsonObject, String string) {
        boolean bl;
        block16: {
            block13: {
                String string2;
                JsonObject jsonObject2;
                int n;
                block15: {
                    JsonElement jsonElement;
                    block14: {
                        block12: {
                            n = ocbb1bc27172.\u050d;
                            jsonElement = jsonObject;
                            if (n != 0) break block12;
                            if (jsonElement == null) break block13;
                            jsonElement = jsonObject;
                        }
                        if (n != 0) break block14;
                        if (!jsonElement.has(string)) break block13;
                        jsonObject2 = jsonObject;
                        string2 = string;
                        if (n != 0) break block15;
                        jsonElement = jsonObject2.get(string2);
                    }
                    if (jsonElement.isJsonNull()) break block13;
                    jsonObject2 = jsonObject;
                    string2 = string;
                }
                bl = jsonObject2.get(string2).getAsBoolean();
                if (n != 0) break block16;
                if (!bl) break block13;
                bl = true;
                break block16;
            }
            bl = false;
        }
        return bl;
    }

    private static long \u049a(JsonObject jsonObject, String string) {
        long l;
        block14: {
            block11: {
                JsonElement jsonElement;
                block13: {
                    String string2;
                    block12: {
                        int n;
                        block10: {
                            n = ocbb1bc27172.\u050d;
                            jsonElement = jsonObject;
                            if (n != 0) break block10;
                            if (jsonElement == null) break block11;
                            jsonElement = jsonObject;
                        }
                        string2 = string;
                        if (n != 0) break block12;
                        if (!jsonElement.has(string2)) break block11;
                        jsonElement = jsonObject;
                        if (n != 0) break block13;
                        string2 = string;
                    }
                    if (jsonElement.get(string2).isJsonNull()) break block11;
                    jsonElement = jsonObject.get(string);
                }
                l = jsonElement.getAsLong();
                break block14;
            }
            l = 0L;
        }
        return l;
    }
}

