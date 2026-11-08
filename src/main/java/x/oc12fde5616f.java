/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import x.occ0b63c0426;

public class oc12fde5616f {
    private final JsonElement \u053a;
    public static boolean \u0550;

    public oc12fde5616f(String string) {
        this(new JsonParser().parse(string));
    }

    private oc12fde5616f(JsonElement jsonElement) {
        this.\u053a = jsonElement;
    }

    public oc12fde5616f \u015d() {
        oc12fde5616f oc12fde5616f2;
        block4: {
            block5: {
                int n = occ0b63c0426.\u039f;
                oc12fde5616f2 = this;
                if (n != 0) break block4;
                if (oc12fde5616f2.\u053a.isJsonObject()) break block5;
                throw new IllegalStateException("Not a JSON object");
            }
            oc12fde5616f2 = this;
        }
        return oc12fde5616f2;
    }

    public Map<String, oc12fde5616f> \u00f1() {
        LinkedHashMap<String, oc12fde5616f> linkedHashMap;
        block4: {
            LinkedHashMap<String, oc12fde5616f> linkedHashMap2 = new LinkedHashMap<String, oc12fde5616f>();
            JsonObject jsonObject = this.\u053a.getAsJsonObject();
            Iterator<Map.Entry<String, JsonElement>> iterator2 = jsonObject.entrySet().iterator();
            int n = occ0b63c0426.\u039f;
            while (iterator2.hasNext()) {
                Map.Entry<String, JsonElement> entry = iterator2.next();
                linkedHashMap = linkedHashMap2;
                if (n == 0) {
                    linkedHashMap.put(entry.getKey(), new oc12fde5616f(entry.getValue()));
                    if (n == 0) continue;
                    break;
                }
                break block4;
            }
            linkedHashMap = linkedHashMap2;
        }
        return linkedHashMap;
    }

    public List<oc12fde5616f> \u027e(String string) {
        ArrayList<oc12fde5616f> arrayList;
        block8: {
            ArrayList<oc12fde5616f> arrayList2;
            block7: {
                JsonArray jsonArray;
                int n;
                block6: {
                    JsonArray jsonArray2 = this.\u053a.getAsJsonObject().getAsJsonArray(string);
                    n = occ0b63c0426.\u039f;
                    arrayList2 = new ArrayList<oc12fde5616f>();
                    jsonArray = jsonArray2;
                    if (n != 0) break block6;
                    if (jsonArray == null) break block7;
                    jsonArray = jsonArray2;
                }
                for (JsonElement jsonElement : jsonArray) {
                    arrayList = arrayList2;
                    if (n == 0) {
                        arrayList.add(new oc12fde5616f(jsonElement));
                        if (n == 0) continue;
                        break;
                    }
                    break block8;
                }
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String \u0582(String string, String string2) {
        String string3;
        JsonElement jsonElement;
        block7: {
            JsonElement jsonElement2;
            block8: {
                block6: {
                    int n;
                    block5: {
                        jsonElement2 = this.\u053a.getAsJsonObject().get(string);
                        n = occ0b63c0426.\u039f;
                        jsonElement = jsonElement2;
                        if (n != 0) break block5;
                        if (jsonElement == null) break block6;
                        jsonElement = jsonElement2;
                    }
                    if (n != 0) break block7;
                    if (!jsonElement.isJsonNull()) break block8;
                }
                string3 = string2;
                return string3;
            }
            jsonElement = jsonElement2;
        }
        string3 = jsonElement.getAsString();
        return string3;
    }
}

