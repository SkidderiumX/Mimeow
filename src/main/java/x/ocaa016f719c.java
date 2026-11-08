/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import x.oc668fce0dbf;
import x.oc84f20a0bc5;
import x.oca9cc61aada;

public class ocaa016f719c
extends oca9cc61aada {
    private ocaa016f719c() {
        super("Mode", 0, oc668fce0dbf.\u04c2);
    }

    @Override
    public void z$3ktkzjg2sjswq(JsonObject jsonObject) {
        block37: {
            JsonObject jsonObject2;
            block40: {
                double d;
                block39: {
                    double d2;
                    int n;
                    block38: {
                        double d3;
                        Double d4;
                        block36: {
                            block34: {
                                block35: {
                                    Double d5;
                                    block32: {
                                        block33: {
                                            d4 = ocaa016f719c.\u0440(jsonObject);
                                            super.z$3ktkzjg2sjswq(jsonObject);
                                            n = oc84f20a0bc5.\u0117;
                                            d5 = d4;
                                            if (n != 0) break block32;
                                            if (d5 != null) break block33;
                                            return;
                                        }
                                        d5 = d4;
                                    }
                                    d2 = d5;
                                    if (n != 0) break block34;
                                    if (!(d2 >= 1.5)) break block35;
                                    d2 = d4;
                                    if (n != 0) break block34;
                                    if (!(d2 < 2.5)) break block35;
                                    d3 = (double)ocaa016f719c.\u03c3(jsonObject);
                                    if (n != 0) break block36;
                                    if (d3 != false) break block35;
                                    this.\u021e(1.0);
                                    if (n == 0) break block37;
                                }
                                d2 = d4;
                            }
                            if (n != 0) break block38;
                            double d6 = d2 - 0.5;
                            d3 = d6 == 0.0 ? 0 : (d6 > 0.0 ? 1 : -1);
                        }
                        if (d3 < 0) break block37;
                        d2 = d4;
                    }
                    double d7 = d2 - 1.5;
                    d = d7 == 0.0 ? 0 : (d7 < 0.0 ? -1 : 1);
                    if (n != 0) break block39;
                    if (d >= 0) break block37;
                    jsonObject2 = jsonObject;
                    if (n != 0) break block40;
                    d = (double)ocaa016f719c.\u03c3(jsonObject2);
                }
                if (d != false) break block37;
                jsonObject2 = jsonObject;
            }
            if (ocaa016f719c.\u0196(jsonObject2)) {
                this.\u021e(0.0);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static Double \u0440(JsonObject jsonObject) {
        int n = oc84f20a0bc5.\u0117;
        if (jsonObject == null) {
            return null;
        }
        String[] stringArray = new String[0x8AD668F4 ^ 0x8AD668F6];
        stringArray[0] = "Mode";
        stringArray[1] = "setting.mode";
        String[] stringArray2 = stringArray;
        int n2 = stringArray2.length;
        int n3 = 0;
        do {
            if (n3 >= n2) return null;
            String string = stringArray2[n3];
            JsonElement jsonElement2 = jsonObject.get(string);
            if (n != 0) continue;
            if (jsonElement2 != null) {
                JsonElement jsonElement = jsonElement2;
                if (n != 0) return jsonElement.getAsDouble();
                if (jsonElement.isJsonPrimitive()) {
                    try {
                        jsonElement = jsonElement2;
                        return jsonElement.getAsDouble();
                    }
                    catch (RuntimeException runtimeException) {
                        // empty catch block
                    }
                }
            }
            ++n3;
        } while (n == 0);
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean \u03c3(JsonObject jsonObject) {
        JsonObject jsonObject2;
        int n;
        block38: {
            JsonObject jsonObject3;
            block39: {
                block37: {
                    JsonElement jsonElement;
                    block35: {
                        block36: {
                            JsonObject jsonObject4;
                            block33: {
                                block34: {
                                    n = oc84f20a0bc5.\u0117;
                                    jsonObject4 = jsonObject;
                                    if (n != 0) break block33;
                                    if (jsonObject4 != null) break block34;
                                    return false;
                                }
                                jsonObject4 = jsonObject;
                            }
                            boolean bl = jsonObject4.has("setting.telly2SameY");
                            if (n != 0) return bl;
                            if (bl) return true;
                            jsonElement = jsonObject;
                            if (n != 0) break block35;
                            if (!jsonElement.has("Telly2.SameY")) break block36;
                            return true;
                        }
                        jsonElement = jsonObject.get("portableSettings");
                    }
                    jsonObject3 = jsonElement;
                    jsonObject2 = jsonObject3;
                    if (n != 0) break block37;
                    if (jsonObject2 == null) return false;
                    jsonObject2 = jsonObject3;
                }
                if (n != 0) break block38;
                if (jsonObject2.isJsonArray()) break block39;
                return false;
            }
            jsonObject2 = jsonObject3;
        }
        Iterator<JsonElement> iterator2 = jsonObject2.getAsJsonArray().iterator();
        while (iterator2.hasNext()) {
            block44: {
                JsonElement jsonElement;
                block45: {
                    JsonElement jsonElement2;
                    block43: {
                        JsonElement jsonElement3;
                        block41: {
                            JsonElement jsonElement4;
                            block42: {
                                block40: {
                                    jsonElement4 = iterator2.next();
                                    jsonElement3 = jsonElement4;
                                    if (n != 0) break block40;
                                    if (jsonElement3 == null) continue;
                                    jsonElement3 = jsonElement4;
                                }
                                if (n != 0) break block41;
                                if (jsonElement3.isJsonObject()) break block42;
                                if (n == 0) continue;
                            }
                            jsonElement3 = jsonElement4.getAsJsonObject().get("name");
                        }
                        jsonElement2 = jsonElement3;
                        jsonElement = jsonElement2;
                        if (n != 0) break block43;
                        if (jsonElement == null) break block44;
                        jsonElement = jsonElement2;
                    }
                    if (n != 0) break block45;
                    if (!jsonElement.isJsonPrimitive()) break block44;
                    jsonElement = jsonElement2;
                }
                boolean bl = jsonElement.getAsString().equalsIgnoreCase("Telly2.SameY");
                if (n != 0) return bl;
                if (!bl) break block44;
                return true;
            }
            if (n != 0) return false;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean \u0196(JsonObject jsonObject) {
        JsonElement jsonElement;
        Object object;
        int n;
        block38: {
            JsonElement jsonElement2;
            block39: {
                block37: {
                    JsonObject jsonObject2;
                    block34: {
                        block35: {
                            block32: {
                                block33: {
                                    n = oc84f20a0bc5.\u0117;
                                    jsonObject2 = jsonObject;
                                    if (n != 0) break block32;
                                    if (jsonObject2 != null) break block33;
                                    return false;
                                }
                                jsonObject2 = jsonObject;
                            }
                            if (n != 0) break block34;
                            if (!jsonObject2.has("setting.tellyYaw")) break block35;
                            return true;
                        }
                        jsonObject2 = jsonObject;
                    }
                    for (Map.Entry<String, JsonElement> entry : jsonObject2.entrySet()) {
                        block36: {
                            object = entry.getKey();
                            boolean bl = ((String)object).regionMatches(true, 0, "GodBridge.", 0, "GodBridge.".length());
                            if (n != 0) return bl;
                            if (!bl) break block36;
                            return true;
                        }
                        if (n == 0) continue;
                    }
                    jsonElement2 = jsonObject.get("portableSettings");
                    jsonElement = jsonElement2;
                    if (n != 0) break block37;
                    if (jsonElement == null) return false;
                    jsonElement = jsonElement2;
                }
                if (n != 0) break block38;
                if (jsonElement.isJsonArray()) break block39;
                return false;
            }
            jsonElement = jsonElement2;
        }
        Iterator<JsonElement> iterator2 = jsonElement.getAsJsonArray().iterator();
        while (iterator2.hasNext()) {
            block44: {
                Object object2;
                block45: {
                    Object object3;
                    block43: {
                        Object object4;
                        block41: {
                            block42: {
                                block40: {
                                    object = iterator2.next();
                                    object4 = object;
                                    if (n != 0) break block40;
                                    if (object4 == null) continue;
                                    object4 = object;
                                }
                                if (n != 0) break block41;
                                if (((JsonElement)object4).isJsonObject()) break block42;
                                if (n == 0) continue;
                            }
                            object4 = ((JsonElement)object).getAsJsonObject().get("name");
                        }
                        object3 = object4;
                        object2 = object3;
                        if (n != 0) break block43;
                        if (object2 == null) break block44;
                        object2 = object3;
                    }
                    if (n != 0) break block45;
                    if (!((JsonElement)object2).isJsonPrimitive()) break block44;
                    object2 = object3;
                }
                boolean bl = ((JsonElement)object2).getAsString().regionMatches(true, 0, "GodBridge.", 0, "GodBridge.".length());
                if (n != 0) return bl;
                if (!bl) break block44;
                return true;
            }
            if (n != 0) return false;
        }
        return false;
    }
}

