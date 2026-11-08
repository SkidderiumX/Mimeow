/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import x.N;
import x.oca9cc61aada;
import x.occc831eff22;

public class oc6af36febc3
extends N {
    private final String \u041f;
    private final int \u0115;
    private final List<String> \u041b = new ArrayList<String>();
    public occc831eff22 \u0377;
    public static boolean \u054f;

    public oc6af36febc3(String string, String string2, int n) {
        this(null, string, string2, n);
    }

    public oc6af36febc3(occc831eff22 occc831eff222, String string, String string2, int n) {
        super(string);
        this.\u0377 = occc831eff222;
        this.\u041f = string2 == null ? "" : string2;
        this.\u0115 = Math.max(1, n);
    }

    public String \u0215() {
        return this.\u041f;
    }

    public int \u0107() {
        return this.\u0115;
    }

    public List<String> \u010e() {
        return Collections.unmodifiableList(this.\u041b);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean \u0536(String string) {
        String string2;
        int n;
        block15: {
            String string3;
            block14: {
                n = oca9cc61aada.\u01f7;
                string3 = string;
                if (n != 0) break block14;
                if (string3 == null) return false;
                string2 = string;
                if (n != 0) break block15;
                string3 = string2.trim();
            }
            if (string3.isEmpty()) {
                return false;
            }
            string2 = string.trim();
        }
        String string4 = string2;
        for (String string5 : this.\u041b) {
            block16: {
                if (n != 0) return true;
                boolean bl = string5.equalsIgnoreCase(string4);
                if (n != 0) return bl;
                if (!bl) break block16;
                return false;
            }
            if (n == 0) continue;
        }
        this.\u041b.add(string4);
        return true;
    }

    public boolean \u012d(String string) {
        return this.\u041b.removeIf(string2 -> string2.equalsIgnoreCase(string));
    }

    public void \u016f() {
        this.\u041b.clear();
    }

    public JsonArray \u012d() {
        JsonArray jsonArray;
        block4: {
            JsonArray jsonArray2 = new JsonArray();
            Iterator<String> iterator2 = this.\u041b.iterator();
            int n = oca9cc61aada.\u01f7;
            while (iterator2.hasNext()) {
                String string = iterator2.next();
                jsonArray = jsonArray2;
                if (n == 0) {
                    jsonArray.add(new JsonPrimitive(string));
                    if (n == 0) continue;
                    break;
                }
                break block4;
            }
            jsonArray = jsonArray2;
        }
        return jsonArray;
    }

    public void \u00fb(JsonArray jsonArray) {
        JsonArray jsonArray2;
        int n;
        block15: {
            block16: {
                this.\u041b.clear();
                n = oca9cc61aada.\u01f7;
                jsonArray2 = jsonArray;
                if (n != 0) break block15;
                if (jsonArray2 != null) break block16;
                return;
            }
            jsonArray2 = jsonArray;
        }
        for (JsonElement jsonElement : jsonArray2) {
            block18: {
                String string;
                String string2;
                block19: {
                    JsonElement jsonElement2;
                    block17: {
                        jsonElement2 = jsonElement;
                        if (n != 0) break block17;
                        if (!jsonElement2.isJsonPrimitive()) break block18;
                        jsonElement2 = jsonElement;
                    }
                    string2 = jsonElement2.getAsString();
                    string = string2;
                    if (n != 0) break block19;
                    if (string == null) break block18;
                    string = string2.trim();
                }
                boolean bl = string.isEmpty();
                if (n != 0 || bl) break block18;
                bl = this.\u041b.add(string2.trim());
            }
            if (n == 0) continue;
        }
    }

    @Override
    public String z$3lm3x0je4b2zv() {
        Object object;
        block6: {
            oc6af36febc3 oc6af36febc32;
            block4: {
                block5: {
                    int n = oca9cc61aada.\u01f7;
                    oc6af36febc32 = this;
                    if (n != 0) break block4;
                    if (oc6af36febc32.\u0377 != null) break block5;
                    object = this.z$18nrktuqeiysv();
                    break block6;
                }
                oc6af36febc32 = this;
            }
            object = oc6af36febc32.\u0377.z$18nrktuqeiysv() + "." + this.z$18nrktuqeiysv();
        }
        return object;
    }

    @Override
    public void z$3ktkzjg2sjswq(JsonObject jsonObject) {
        block11: {
            JsonElement jsonElement;
            String string;
            block10: {
                int n = oca9cc61aada.\u01f7;
                if (jsonObject == null) {
                    return;
                }
                string = this.z$3lm3x0je4b2zv();
                jsonElement = jsonObject;
                if (n != 0) break block10;
                if (!jsonElement.has(string)) break block11;
                jsonElement = jsonObject.get(string);
            }
            if (jsonElement.isJsonArray()) {
                this.\u00fb(jsonObject.getAsJsonArray(string));
            }
        }
    }
}

