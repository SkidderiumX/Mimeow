/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x.N;
import x.oca9cc61aada;
import x.occc831eff22;

public class oc10354c7bb8
extends N {
    private final List<String> \u012f = new ArrayList<String>();
    private final String[] \u01ff;
    public occc831eff22 \u0150;
    public static int \u01bc;

    public oc10354c7bb8(String string) {
        this(string, new String[0]);
    }

    public oc10354c7bb8(String string, String ... stringArray) {
        super(string);
        this.\u01ff = stringArray != null ? stringArray : new String[]{};
    }

    public oc10354c7bb8(occc831eff22 occc831eff222, String string) {
        this(occc831eff222, string, new String[0]);
    }

    public oc10354c7bb8(occc831eff22 occc831eff222, String string, String ... stringArray) {
        super(string);
        this.\u0150 = occc831eff222;
        this.\u01ff = stringArray != null ? stringArray : new String[]{};
    }

    public void \u051f(String string) {
        block5: {
            String string2;
            List<String> list;
            block4: {
                int n = oca9cc61aada.\u01f7;
                list = this.\u012f;
                string2 = string;
                if (n != 0) break block4;
                if (list.contains(string2)) break block5;
                list = this.\u012f;
                string2 = string;
            }
            list.add(string2);
        }
    }

    public void \u0535(String string) {
        this.\u012f.remove(string);
    }

    public List<String> \u0478() {
        return this.\u012f;
    }

    public boolean \u0462(String string) {
        boolean bl;
        block9: {
            block8: {
                int n;
                block7: {
                    boolean bl2;
                    block6: {
                        n = oca9cc61aada.\u01f7;
                        bl2 = this.\u012f.contains(string);
                        if (n != 0) break block6;
                        if (!bl2) break block7;
                        bl2 = true;
                    }
                    return bl2;
                }
                String string2 = oc10354c7bb8.\u02b0(string);
                if (string2 == null) break block8;
                bl = this.\u012f.contains(string2 + ":*");
                if (n != 0) break block9;
                if (!bl) break block8;
                bl = true;
                break block9;
            }
            bl = false;
        }
        return bl;
    }

    @Override
    public String z$3lm3x0je4b2zv() {
        Object object;
        block6: {
            oc10354c7bb8 oc10354c7bb82;
            block4: {
                block5: {
                    int n = oca9cc61aada.\u01f7;
                    oc10354c7bb82 = this;
                    if (n != 0) break block4;
                    if (oc10354c7bb82.\u0150 != null) break block5;
                    object = this.z$18nrktuqeiysv();
                    break block6;
                }
                oc10354c7bb82 = this;
            }
            object = oc10354c7bb82.\u0150.z$18nrktuqeiysv() + "." + this.z$18nrktuqeiysv();
        }
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String \u02b0(String string) {
        int n;
        block21: {
            String[] stringArray;
            block22: {
                String string2;
                int n2;
                block19: {
                    block20: {
                        block17: {
                            block18: {
                                block16: {
                                    n2 = oca9cc61aada.\u01f7;
                                    string2 = string;
                                    if (n2 != 0) break block16;
                                    if (string2 == null) return null;
                                    string2 = string;
                                }
                                if (n2 != 0) break block17;
                                if (!string2.isEmpty()) break block18;
                                return null;
                            }
                            string2 = string;
                        }
                        if (n2 != 0) break block19;
                        if (!string2.endsWith(":*")) break block20;
                        return string.substring(0, string.length() - (0x618107AA ^ 0x618107A8));
                    }
                    string2 = string;
                }
                stringArray = string2.split(":");
                n = stringArray.length;
                if (n2 != 0) break block21;
                if (n < (0x618107AB ^ 0x618107A8)) break block22;
                return stringArray[0] + ":" + stringArray[1];
            }
            n = stringArray.length;
        }
        if (n != (0x618107AA ^ 0x618107A8)) return null;
        return string;
    }

    @Override
    public void z$3ktkzjg2sjswq(JsonObject jsonObject) {
        block19: {
            Object object;
            int n;
            block18: {
                Object object2;
                String string;
                block20: {
                    JsonObject jsonObject2;
                    block15: {
                        block16: {
                            string = null;
                            n = oca9cc61aada.\u01f7;
                            jsonObject2 = jsonObject;
                            if (n != 0) break block15;
                            if (!jsonObject2.has(this.z$3lm3x0je4b2zv())) break block16;
                            string = this.z$3lm3x0je4b2zv();
                            break block20;
                        }
                        jsonObject2 = jsonObject;
                    }
                    if (jsonObject2.has(this.z$18nrktuqeiysv())) {
                        string = this.z$18nrktuqeiysv();
                    } else {
                        object2 = this.\u01ff;
                        int n2 = ((String[])object2).length;
                        int n3 = 0;
                        while (n3 < n2) {
                            block17: {
                                String string2 = object2[n3];
                                if (n != 0) continue;
                                if (!jsonObject.has(string2)) break block17;
                                string = string2;
                                break;
                            }
                            ++n3;
                        }
                    }
                }
                if (string == null) {
                    return;
                }
                this.\u012f.clear();
                object2 = jsonObject.get(string);
                object = object2;
                if (n != 0) break block18;
                if (!((JsonElement)object).isJsonArray()) break block19;
                object = object2;
            }
            for (JsonElement jsonElement : ((JsonElement)object).getAsJsonArray()) {
                this.\u012f.add(jsonElement.getAsString());
                if (n == 0) continue;
            }
        }
    }

    public JsonArray z$tvwb8ctrx7ou() {
        JsonArray jsonArray;
        block4: {
            JsonArray jsonArray2 = new JsonArray();
            Iterator<String> iterator2 = this.\u012f.iterator();
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

    protected String[] \u03f2() {
        return this.\u01ff;
    }
}

