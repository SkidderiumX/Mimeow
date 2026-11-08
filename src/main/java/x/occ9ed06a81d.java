/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import x.oc1e36b6c903;
import x.oc64151e84ee;
import x.oc75d51ec7eb;
import x.oc7ab2161b9f;
import x.oc8ccd9c3f55;
import x.ocda171fe5d8;

public class occ9ed06a81d
implements ocda171fe5d8 {
    private static final Gson \u0122 = new GsonBuilder().setPrettyPrinting().create();
    private final File \u019b;
    private final LinkedHashMap<String, String> \u013c = new LinkedHashMap();
    private final LinkedHashMap<String, String> \u0451 = new LinkedHashMap();
    public static int \u00ed;

    public occ9ed06a81d() {
        File file = oc8ccd9c3f55.\u057a(ocda171fe5d8.\u01d4.mcDataDir);
        this.\u019b = new File(file, "players.json");
        File file2 = new File(oc8ccd9c3f55.\u03b6(ocda171fe5d8.\u01d4.mcDataDir), "players.json");
        try {
            oc8ccd9c3f55.\u03e1(file2, this.\u019b);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void \u0434() {
        block13: {
            int n;
            block16: {
                occ9ed06a81d occ9ed06a81d2;
                block15: {
                    this.\u013c.clear();
                    n = oc75d51ec7eb.\u03e9;
                    occ9ed06a81d2 = this;
                    if (n != 0) break block15;
                    occ9ed06a81d2.\u0451.clear();
                    if (this.\u019b.exists()) break block16;
                    occ9ed06a81d2 = this;
                }
                occ9ed06a81d2.\u0506();
                return;
            }
            try {
                JsonObject jsonObject;
                FileReader fileReader;
                block14: {
                    fileReader = new FileReader(this.\u019b);
                    jsonObject = new JsonParser().parse(fileReader).getAsJsonObject();
                    if (n != 0) break block13;
                    if (jsonObject != null) break block14;
                    this.\u0506();
                    fileReader.close();
                    return;
                }
                try {
                    this.\u0398(jsonObject.get("friends"), this.\u013c);
                    this.\u0398(jsonObject.get("enemies"), this.\u0451);
                }
                finally {
                    fileReader.close();
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        this.\u0506();
    }

    public boolean \u02b4(String string) {
        return this.o(oc64151e84ee.\u0190, string);
    }

    public boolean \u0105(String string) {
        return this.o(oc64151e84ee.\u020d, string);
    }

    public boolean \u0372(String string) {
        return this.\u0265(oc64151e84ee.\u0190, string);
    }

    public boolean \u04eb(String string) {
        return this.\u0265(oc64151e84ee.\u020d, string);
    }

    public void \u0542() {
        this.\u00ec(oc64151e84ee.\u0190);
    }

    public void \u01d3() {
        this.\u00ec(oc64151e84ee.\u020d);
    }

    public boolean o(oc64151e84ee oc64151e84ee2, String string) {
        boolean bl;
        block32: {
            boolean bl2;
            block30: {
                String string2;
                LinkedHashMap<String, String> linkedHashMap;
                String string3;
                block31: {
                    boolean bl3;
                    boolean bl4;
                    int n;
                    block28: {
                        block29: {
                            boolean bl5;
                            LinkedHashMap<String, String> linkedHashMap2;
                            block26: {
                                block27: {
                                    block25: {
                                        boolean bl6;
                                        block24: {
                                            string3 = this.\u046b(string);
                                            n = oc75d51ec7eb.\u03e9;
                                            bl6 = string3.isEmpty();
                                            if (n != 0) break block24;
                                            if (!bl6) break block25;
                                            bl6 = false;
                                        }
                                        return bl6;
                                    }
                                    LinkedHashMap<String, String> linkedHashMap3 = oc64151e84ee2 == oc64151e84ee.\u0190 ? this.\u013c : this.\u0451;
                                    linkedHashMap = linkedHashMap3;
                                    LinkedHashMap<String, String> linkedHashMap4 = oc64151e84ee2 == oc64151e84ee.\u0190 ? this.\u0451 : this.\u013c;
                                    linkedHashMap2 = linkedHashMap4;
                                    string2 = this.\u057b(string, string3);
                                    bl5 = linkedHashMap.containsKey(string3);
                                    if (n != 0) break block26;
                                    if (bl5) break block27;
                                    bl5 = true;
                                    break block26;
                                }
                                bl5 = false;
                            }
                            bl2 = bl5;
                            boolean bl7 = linkedHashMap2.remove(string3) != null;
                            bl4 = bl7;
                            bl3 = string2.equals(linkedHashMap.get(string3));
                            if (n != 0) break block28;
                            if (bl3) break block29;
                            bl3 = true;
                            break block28;
                        }
                        bl3 = false;
                    }
                    boolean bl8 = bl3;
                    if (n != 0) break block30;
                    if (bl2) break block31;
                    bl = bl4;
                    if (n != 0) break block32;
                    if (bl) break block31;
                    bl = bl8;
                    if (n != 0) break block32;
                    if (bl) break block31;
                    return false;
                }
                linkedHashMap.put(string3, string2);
                this.\u0404();
            }
            bl = bl2;
        }
        return bl;
    }

    public boolean \u0265(oc64151e84ee oc64151e84ee2, String string) {
        block10: {
            block11: {
                int n;
                String string2;
                block9: {
                    boolean bl;
                    block8: {
                        string2 = this.\u046b(string);
                        n = oc75d51ec7eb.\u03e9;
                        bl = string2.isEmpty();
                        if (n != 0) break block8;
                        if (!bl) break block9;
                        bl = false;
                    }
                    return bl;
                }
                LinkedHashMap<String, String> linkedHashMap = oc64151e84ee2 == oc64151e84ee.\u0190 ? this.\u013c : this.\u0451;
                LinkedHashMap<String, String> linkedHashMap2 = linkedHashMap;
                if (n != 0) break block10;
                if (linkedHashMap2.remove(string2) != null) break block11;
                return false;
            }
            this.\u0404();
        }
        return true;
    }

    public void \u00ec(oc64151e84ee oc64151e84ee2) {
        block6: {
            LinkedHashMap<String, String> linkedHashMap;
            block7: {
                int n = oc75d51ec7eb.\u03e9;
                LinkedHashMap<String, String> linkedHashMap2 = oc64151e84ee2 == oc64151e84ee.\u0190 ? this.\u013c : this.\u0451;
                linkedHashMap = linkedHashMap2;
                if (n != 0) break block6;
                if (!linkedHashMap.isEmpty()) break block7;
                return;
            }
            linkedHashMap.clear();
            this.\u0404();
        }
    }

    public boolean \u03e6(String string) {
        return this.\u0447(this.\u013c, string);
    }

    public boolean \u04fc(String string) {
        return this.\u0447(this.\u0451, string);
    }

    public int \u0196(oc64151e84ee oc64151e84ee2) {
        return this.D(oc64151e84ee2).size();
    }

    public List<oc1e36b6c903> \u02a3(oc64151e84ee oc64151e84ee2) {
        ArrayList<oc1e36b6c903> arrayList;
        block4: {
            LinkedHashMap<String, String> linkedHashMap = this.D(oc64151e84ee2);
            ArrayList<oc1e36b6c903> arrayList2 = new ArrayList<oc1e36b6c903>(linkedHashMap.size());
            Iterator<Map.Entry<String, String>> iterator2 = linkedHashMap.entrySet().iterator();
            int n = oc75d51ec7eb.\u03e9;
            while (iterator2.hasNext()) {
                Map.Entry<String, String> entry = iterator2.next();
                arrayList = arrayList2;
                if (n == 0) {
                    arrayList.add(new oc1e36b6c903(entry.getKey(), entry.getValue()));
                    if (n == 0) continue;
                    break;
                }
                break block4;
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public void \u0228(String string) {
        boolean bl;
        boolean bl2;
        block13: {
            block15: {
                block14: {
                    boolean bl3;
                    int n;
                    String string2;
                    block11: {
                        block12: {
                            string2 = this.\u046b(string);
                            n = oc75d51ec7eb.\u03e9;
                            bl3 = string2.isEmpty();
                            if (n != 0) break block11;
                            if (!bl3) break block12;
                            return;
                        }
                        bl3 = this.\u0260(this.\u013c, string2, string);
                    }
                    bl2 = bl3;
                    bl = this.\u0260(this.\u0451, string2, string);
                    if (n != 0) break block13;
                    if (bl) break block14;
                    bl = bl2;
                    if (n != 0) break block13;
                    if (!bl) break block15;
                }
                bl = true;
                break block13;
            }
            bl = false;
        }
        bl2 = bl;
        if (bl2) {
            this.\u0404();
        }
    }

    private boolean \u0260(LinkedHashMap<String, String> linkedHashMap, String string, String string2) {
        block8: {
            String string3;
            block9: {
                int n;
                block7: {
                    boolean bl;
                    block6: {
                        n = oc75d51ec7eb.\u03e9;
                        bl = linkedHashMap.containsKey(string);
                        if (n != 0) break block6;
                        if (bl) break block7;
                        bl = false;
                    }
                    return bl;
                }
                string3 = this.\u057b(string2, string);
                if (n != 0) break block8;
                if (!string3.equals(linkedHashMap.get(string))) break block9;
                return false;
            }
            linkedHashMap.put(string, string3);
        }
        return true;
    }

    private void \u0404() {
        this.\u0466();
        this.\u0506();
    }

    private void \u0506() {
        oc7ab2161b9f.\u041e.clear();
        oc7ab2161b9f.\u041e.addAll(this.\u013c.keySet());
        oc7ab2161b9f.\u00f5.clear();
        oc7ab2161b9f.\u00f5.addAll(this.\u0451.keySet());
    }

    private void \u0466() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("friends", this.\u0553(this.\u013c));
        jsonObject.add("enemies", this.\u0553(this.\u0451));
        try (FileWriter fileWriter = new FileWriter(this.\u019b);){
            \u0122.toJson((JsonElement)jsonObject, (Appendable)fileWriter);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void \u0398(JsonElement jsonElement, LinkedHashMap<String, String> linkedHashMap) {
        JsonElement jsonElement2;
        int n;
        block34: {
            block35: {
                block33: {
                    n = oc75d51ec7eb.\u03e9;
                    jsonElement2 = jsonElement;
                    if (n != 0) break block33;
                    if (jsonElement2 == null) return;
                    jsonElement2 = jsonElement;
                }
                if (n != 0) break block34;
                if (jsonElement2.isJsonArray()) break block35;
                return;
            }
            jsonElement2 = jsonElement;
        }
        JsonArray jsonArray = jsonElement2.getAsJsonArray();
        for (JsonElement jsonElement3 : jsonArray) {
            block48: {
                String string;
                String string2;
                block50: {
                    block47: {
                        Object object;
                        block46: {
                            String string3;
                            Object object2;
                            block49: {
                                block45: {
                                    Object object3;
                                    block44: {
                                        JsonElement jsonElement4;
                                        block42: {
                                            block43: {
                                                block39: {
                                                    block40: {
                                                        block41: {
                                                            block37: {
                                                                block38: {
                                                                    block36: {
                                                                        jsonElement4 = jsonElement3;
                                                                        if (n != 0) break block36;
                                                                        if (jsonElement4 == null) continue;
                                                                        jsonElement4 = jsonElement3;
                                                                    }
                                                                    if (n != 0) break block37;
                                                                    if (!jsonElement4.isJsonNull()) break block38;
                                                                    if (n == 0) continue;
                                                                }
                                                                jsonElement4 = jsonElement3;
                                                            }
                                                            if (n != 0) break block39;
                                                            if (!jsonElement4.isJsonPrimitive()) break block40;
                                                            object2 = jsonElement3.getAsString();
                                                            string2 = this.\u046b((String)object2);
                                                            if (n != 0) break block41;
                                                            if (string2.isEmpty()) continue;
                                                            linkedHashMap.put(string2, this.\u057b((String)object2, string2));
                                                        }
                                                        if (n == 0) continue;
                                                    }
                                                    jsonElement4 = jsonElement3;
                                                }
                                                if (n != 0) break block42;
                                                if (jsonElement4.isJsonObject()) break block43;
                                                if (n == 0) continue;
                                            }
                                            jsonElement4 = jsonElement3;
                                        }
                                        object2 = jsonElement4.getAsJsonObject();
                                        object3 = object2;
                                        if (n != 0) break block44;
                                        if (!((JsonObject)object3).has("key")) break block45;
                                        object3 = ((JsonObject)object2).get("key");
                                    }
                                    string3 = ((JsonElement)object3).getAsString();
                                    break block49;
                                }
                                string3 = "";
                            }
                            string2 = string3;
                            object = object2;
                            if (n != 0) break block46;
                            if (!((JsonObject)object).has("displayName")) break block47;
                            object = ((JsonObject)object2).get("displayName");
                        }
                        string = ((JsonElement)object).getAsString();
                        break block50;
                    }
                    string = string2;
                }
                String string4 = string;
                String string5 = this.\u046b(string2);
                String string6 = string5;
                if (n != 0 || string6.isEmpty()) break block48;
                string6 = linkedHashMap.put(string5, this.\u057b(string4, string5));
            }
            if (n == 0) continue;
        }
    }

    private JsonArray \u0553(LinkedHashMap<String, String> linkedHashMap) {
        JsonArray jsonArray;
        block4: {
            JsonArray jsonArray2 = new JsonArray();
            Iterator<Map.Entry<String, String>> iterator2 = linkedHashMap.entrySet().iterator();
            int n = oc75d51ec7eb.\u03e9;
            while (iterator2.hasNext()) {
                Map.Entry<String, String> entry = iterator2.next();
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("key", entry.getKey());
                jsonObject.addProperty("displayName", entry.getValue());
                jsonArray = jsonArray2;
                if (n == 0) {
                    jsonArray.add(jsonObject);
                    if (n == 0) continue;
                    break;
                }
                break block4;
            }
            jsonArray = jsonArray2;
        }
        return jsonArray;
    }

    private LinkedHashMap<String, String> D(oc64151e84ee oc64151e84ee2) {
        LinkedHashMap<String, String> linkedHashMap = oc64151e84ee2 == oc64151e84ee.\u0190 ? this.\u013c : this.\u0451;
        return linkedHashMap;
    }

    private boolean \u0447(LinkedHashMap<String, String> linkedHashMap, String string) {
        boolean bl;
        block5: {
            block4: {
                String string2 = this.\u046b(string);
                if (string2.isEmpty() || !linkedHashMap.containsKey(string2)) break block4;
                bl = true;
                break block5;
            }
            bl = false;
        }
        return bl;
    }

    private String \u046b(String string) {
        String string2 = string == null ? "" : string.trim().toLowerCase(Locale.ROOT);
        return string2;
    }

    private String \u057b(String string, String string2) {
        String string3;
        block11: {
            String string4;
            block12: {
                String string5;
                int n;
                block10: {
                    String string6;
                    block8: {
                        block9: {
                            n = oc75d51ec7eb.\u03e9;
                            string6 = string;
                            if (n != 0) break block8;
                            if (string6 != null) break block9;
                            string5 = "";
                            break block10;
                        }
                        string6 = string;
                    }
                    string5 = string6.trim();
                }
                string4 = string5;
                string3 = string4;
                if (n != 0) break block11;
                if (!string3.isEmpty()) break block12;
                string3 = string2;
                break block11;
            }
            string3 = string4;
        }
        return string3;
    }
}

