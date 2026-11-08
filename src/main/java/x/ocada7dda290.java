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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import x.N;
import x.oca9cc61aada;
import x.occc831eff22;

public class ocada7dda290
extends N {
    private final String[] \u04a0;
    private final Set<String> \u0388 = new LinkedHashSet<String>();
    public occc831eff22 \u0467;
    public static boolean y;

    public ocada7dda290(String string, String[] stringArray, String ... stringArray2) {
        this(null, string, stringArray, stringArray2);
    }

    public ocada7dda290(occc831eff22 occc831eff222, String string, String[] stringArray, String ... stringArray2) {
        super(string);
        this.\u0467 = occc831eff222;
        String[] stringArray3 = this.\u04a0 = stringArray == null ? new String[]{} : (String[])stringArray.clone();
        if (stringArray2 != null) {
            for (String string2 : stringArray2) {
                this.\u03fe(string2, true);
            }
        }
    }

    public String[] \u01e5() {
        return (String[])this.\u04a0.clone();
    }

    public List<String> \u0507() {
        return Collections.unmodifiableList(new ArrayList<String>(this.\u0388));
    }

    public int \u0133() {
        return this.\u0388.size();
    }

    public boolean \u01e9(String string) {
        boolean bl;
        block5: {
            block4: {
                String string2 = this.\u0427(string);
                int n = oca9cc61aada.\u01f7;
                if (string2 == null) break block4;
                bl = this.\u0388.contains(string2);
                if (n != 0) break block5;
                if (!bl) break block4;
                bl = true;
                break block5;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u03fe(String string, boolean bl) {
        String string2 = this.\u0427(string);
        if (string2 == null) {
            return false;
        }
        boolean bl2 = bl ? this.\u0388.add(string2) : this.\u0388.remove(string2);
        return bl2;
    }

    public boolean \u0465(String string) {
        Set<String> set;
        String string2;
        block7: {
            block8: {
                string2 = this.\u0427(string);
                int n = oca9cc61aada.\u01f7;
                if (string2 == null) {
                    return false;
                }
                set = this.\u0388;
                if (n != 0) break block7;
                if (!set.remove(string2)) break block8;
                return true;
            }
            set = this.\u0388;
        }
        set.add(string2);
        return true;
    }

    public void \u0183() {
        this.\u0388.clear();
    }

    public void \u041b() {
        this.\u0388.clear();
        Collections.addAll(this.\u0388, this.\u04a0);
    }

    public void \u0526(String string) {
        block4: {
            String string2;
            block5: {
                int n = oca9cc61aada.\u01f7;
                string2 = this.\u0427(string);
                if (n != 0) break block4;
                if (string2 != null) break block5;
                return;
            }
            this.\u0388.clear();
            this.\u0388.add(string2);
        }
    }

    public JsonArray \u03f3() {
        JsonArray jsonArray;
        block4: {
            JsonArray jsonArray2 = new JsonArray();
            Iterator<String> iterator2 = this.\u0388.iterator();
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

    @Override
    public String z$3lm3x0je4b2zv() {
        Object object;
        block6: {
            ocada7dda290 ocada7dda2902;
            block4: {
                block5: {
                    int n = oca9cc61aada.\u01f7;
                    ocada7dda2902 = this;
                    if (n != 0) break block4;
                    if (ocada7dda2902.\u0467 != null) break block5;
                    object = this.z$18nrktuqeiysv();
                    break block6;
                }
                ocada7dda2902 = this;
            }
            object = ocada7dda2902.\u0467.z$18nrktuqeiysv() + "." + this.z$18nrktuqeiysv();
        }
        return object;
    }

    @Override
    public void z$3ktkzjg2sjswq(JsonObject jsonObject) {
        JsonPrimitive jsonPrimitive;
        int n;
        block40: {
            JsonPrimitive jsonPrimitive2;
            block41: {
                block43: {
                    int n2;
                    int n3;
                    block42: {
                        JsonElement jsonElement;
                        block38: {
                            JsonElement jsonElement2;
                            block39: {
                                block35: {
                                    block36: {
                                        String string;
                                        block34: {
                                            ocada7dda290 ocada7dda2902;
                                            JsonObject jsonObject2;
                                            block32: {
                                                block33: {
                                                    block30: {
                                                        block31: {
                                                            n = oca9cc61aada.\u01f7;
                                                            jsonObject2 = jsonObject;
                                                            if (n != 0) break block30;
                                                            if (jsonObject2 != null) break block31;
                                                            return;
                                                        }
                                                        jsonObject2 = jsonObject;
                                                    }
                                                    ocada7dda2902 = this;
                                                    if (n != 0) break block32;
                                                    if (!jsonObject2.has(ocada7dda2902.z$3lm3x0je4b2zv())) break block33;
                                                    string = this.z$3lm3x0je4b2zv();
                                                    break block34;
                                                }
                                                jsonObject2 = jsonObject;
                                                ocada7dda2902 = this;
                                            }
                                            string = jsonObject2.has(ocada7dda2902.z$18nrktuqeiysv()) ? this.z$18nrktuqeiysv() : null;
                                        }
                                        String string2 = string;
                                        if (string2 == null) {
                                            return;
                                        }
                                        jsonElement2 = jsonObject.get(string2);
                                        jsonElement = jsonElement2;
                                        if (n != 0) break block35;
                                        if (!jsonElement.isJsonArray()) break block36;
                                        this.\u0388.clear();
                                        for (JsonElement jsonElement3 : jsonElement2.getAsJsonArray()) {
                                            block37: {
                                                boolean bl = jsonElement3.isJsonPrimitive();
                                                if (n != 0 || !bl) break block37;
                                                bl = this.\u03fe(jsonElement3.getAsString(), true);
                                            }
                                            if (n == 0) continue;
                                        }
                                        return;
                                    }
                                    jsonElement = jsonElement2;
                                }
                                if (n != 0) break block38;
                                if (jsonElement.isJsonPrimitive()) break block39;
                                return;
                            }
                            jsonElement = jsonElement2;
                        }
                        jsonPrimitive2 = jsonElement.getAsJsonPrimitive();
                        jsonPrimitive = jsonPrimitive2;
                        if (n != 0) break block40;
                        if (!jsonPrimitive.isNumber()) break block41;
                        n3 = jsonPrimitive2.getAsInt();
                        n2 = n3;
                        if (n != 0) break block42;
                        if (n2 < 0) break block43;
                        n2 = n3;
                    }
                    if (n2 < this.\u04a0.length) {
                        this.\u0526(this.\u04a0[n3]);
                    }
                }
                return;
            }
            jsonPrimitive = jsonPrimitive2;
        }
        String[] stringArray = jsonPrimitive.getAsString().split(",");
        this.\u0388.clear();
        for (String string : stringArray) {
            this.\u03fe(string.trim(), true);
            if (n == 0) continue;
        }
    }

    private String \u0427(String string) {
        if (string == null) {
            return null;
        }
        for (String string2 : this.\u04a0) {
            if (!string2.equalsIgnoreCase(string.trim())) continue;
            return string2;
        }
        return null;
    }
}

