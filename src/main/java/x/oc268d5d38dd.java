/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Pattern;
import x.oc380d0f830c;
import x.oc69da1aa7f5;
import x.oc6d9efd226f;
import x.ocab1e1d632b;
import x.ocace50a692b;

public class oc268d5d38dd {
    public static final int \u0162 = 20;
    static final int \u0402 = 65536;
    private static final int \u018b = 0x200000;
    private static final Pattern \u0242 = Pattern.compile("^[a-f0-9]{32}$");
    private static final Pattern \u0174 = Pattern.compile("^[A-Za-z0-9_-]{1,512}$");
    public static boolean \u018c;

    public ocab1e1d632b \u0494(String string) throws IOException {
        String string2;
        block2: {
            Object object;
            block3: {
                String string3 = oc268d5d38dd.a(string);
                int n = oc6d9efd226f.\u03a5;
                object = "changelogs/client?limit=20";
                string2 = string3;
                if (n != 0) break block2;
                if (string2 == null) break block3;
                object = (String)object + "&cursor=" + oc380d0f830c.\u0453(string3);
            }
            string2 = oc380d0f830c.\u0139((String)object);
        }
        return oc268d5d38dd.\u04df(string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static ocab1e1d632b \u04df(String string) throws IOException {
        JsonElement jsonElement;
        int n;
        JsonObject jsonObject;
        block26: {
            JsonElement jsonElement2;
            block27: {
                block25: {
                    jsonObject = oc268d5d38dd.\u025c(string);
                    n = oc6d9efd226f.\u03a5;
                    if (!"success".equals(oc268d5d38dd.\u0370(jsonObject, "status", 0xA36940DC ^ 0xA36940FC))) {
                        throw oc268d5d38dd.\u016e();
                    }
                    jsonElement2 = jsonObject.get("changelogs");
                    jsonElement = jsonElement2;
                    if (n != 0) break block25;
                    if (jsonElement == null) throw oc268d5d38dd.\u016e();
                    jsonElement = jsonElement2;
                }
                if (n != 0) break block26;
                if (jsonElement.isJsonArray()) break block27;
                throw oc268d5d38dd.\u016e();
            }
            jsonElement = jsonElement2;
        }
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        if (jsonArray.size() > (0xA36940E8 ^ 0xA36940FC)) {
            throw oc268d5d38dd.\u016e();
        }
        ArrayList<oc6d9efd226f> arrayList = new ArrayList<oc6d9efd226f>();
        HashSet<String> hashSet = new HashSet<String>();
        for (JsonElement jsonElement3 : jsonArray) {
            block30: {
                oc6d9efd226f oc6d9efd226f2;
                block31: {
                    JsonElement jsonElement4;
                    block28: {
                        block29: {
                            if (n != 0) return new ocab1e1d632b(arrayList, oc268d5d38dd.O(jsonObject.get("nextCursor")));
                            jsonElement4 = jsonElement3;
                            if (n != 0) break block28;
                            if (jsonElement4.isJsonObject()) break block29;
                            throw oc268d5d38dd.\u016e();
                        }
                        jsonElement4 = jsonElement3;
                    }
                    oc6d9efd226f2 = oc268d5d38dd.\u046b(jsonElement4.getAsJsonObject());
                    if (n != 0) break block30;
                    if (hashSet.add(oc6d9efd226f2.\u03b1())) break block31;
                    throw oc268d5d38dd.\u016e();
                }
                arrayList.add(oc6d9efd226f2);
            }
            if (n == 0) continue;
            boolean bl = !false;
            oc69da1aa7f5.\u04ac = bl;
            break;
        }
        Collections.sort(arrayList, new ocace50a692b());
        return new ocab1e1d632b(arrayList, oc268d5d38dd.O(jsonObject.get("nextCursor")));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static oc6d9efd226f \u046b(JsonObject jsonObject) throws IOException {
        long l;
        String string;
        String string2;
        String string3;
        String string4;
        block42: {
            block43: {
                block41: {
                    int n;
                    block40: {
                        block38: {
                            block39: {
                                String string5;
                                block36: {
                                    block37: {
                                        block30: {
                                            block31: {
                                                String string6;
                                                block34: {
                                                    block35: {
                                                        block33: {
                                                            block32: {
                                                                block28: {
                                                                    block29: {
                                                                        string4 = oc268d5d38dd.\u0370(jsonObject, "releaseId", 0x301D6E0C ^ 0x301D6E2C);
                                                                        n = oc6d9efd226f.\u03a5;
                                                                        if (!\u0242.matcher(string4).matches()) {
                                                                            throw oc268d5d38dd.\u016e();
                                                                        }
                                                                        string3 = oc268d5d38dd.\u0564(jsonObject, "displayName", 0x301D6E6C ^ 0x301D6E2C);
                                                                        string2 = oc268d5d38dd.\u0564(jsonObject, "version", 0x301D6E6C ^ 0x301D6E2C);
                                                                        string6 = string3;
                                                                        if (n != 0) break block28;
                                                                        if (string6 == null) break block29;
                                                                        string5 = string3;
                                                                        if (n != 0) break block30;
                                                                        if (!string5.isEmpty()) break block31;
                                                                    }
                                                                    string6 = string2;
                                                                }
                                                                if (n != 0) break block32;
                                                                if (string6 == null) break block33;
                                                                string6 = string2;
                                                            }
                                                            if (n != 0) break block34;
                                                            if (!string6.isEmpty()) break block35;
                                                        }
                                                        throw oc268d5d38dd.\u016e();
                                                    }
                                                    string6 = string2;
                                                }
                                                string3 = string6;
                                            }
                                            string5 = string2;
                                        }
                                        if (n != 0) break block36;
                                        if (string5 == null) break block37;
                                        string = string2;
                                        if (n != 0) break block38;
                                        if (!string.isEmpty()) break block39;
                                    }
                                    string5 = string3;
                                }
                                string2 = string5;
                            }
                            string = string3;
                        }
                        if (n != 0) break block40;
                        if (oc268d5d38dd.\u0189(string)) break block41;
                        string = string2;
                    }
                    if (n != 0) break block42;
                    if (!oc268d5d38dd.\u0189(string)) break block43;
                }
                throw oc268d5d38dd.\u016e();
            }
            string = oc268d5d38dd.\u0370(jsonObject, "publishedAt", 0x301D6E6C ^ 0x301D6E2C);
        }
        String string7 = string;
        try {
            l = Instant.parse(string7).toEpochMilli();
        }
        catch (DateTimeParseException dateTimeParseException) {
            throw oc268d5d38dd.\u016e();
        }
        String string8 = oc268d5d38dd.\u03fe(jsonObject, "notes", 0x301C6E2C ^ 0x301D6E2C, false);
        return new oc6d9efd226f(string4, string3, string2, string7, l, string8, oc268d5d38dd.\u0278(jsonObject, "current"));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static JsonObject \u025c(String string) throws IOException {
        int n;
        block14: {
            block13: {
                String string2;
                block12: {
                    n = oc6d9efd226f.\u03a5;
                    string2 = string;
                    if (n != 0) break block12;
                    if (string2 == null) break block13;
                    string2 = string;
                }
                if (string2.length() <= (0x70A52E84 ^ 0x70852E84)) break block14;
            }
            throw oc268d5d38dd.\u016e();
        }
        try {
            JsonElement jsonElement2;
            JsonElement jsonElement = jsonElement2 = new JsonParser().parse(string);
            if (n == 0) {
                if (!jsonElement.isJsonObject()) {
                    throw oc268d5d38dd.\u016e();
                }
                jsonElement = jsonElement2;
            }
            return jsonElement.getAsJsonObject();
        }
        catch (IOException iOException) {
            throw iOException;
        }
        catch (Exception exception) {
            throw oc268d5d38dd.\u016e();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String O(JsonElement jsonElement) throws IOException {
        JsonElement jsonElement2;
        block18: {
            int n;
            block17: {
                block15: {
                    block16: {
                        block14: {
                            n = oc6d9efd226f.\u03a5;
                            jsonElement2 = jsonElement;
                            if (n != 0) break block14;
                            if (jsonElement2 == null) return null;
                            jsonElement2 = jsonElement;
                        }
                        if (n != 0) break block15;
                        if (!jsonElement2.isJsonNull()) break block16;
                        return null;
                    }
                    jsonElement2 = jsonElement;
                }
                if (n != 0) break block17;
                if (!jsonElement2.isJsonPrimitive()) throw oc268d5d38dd.\u016e();
                jsonElement2 = jsonElement;
            }
            if (n != 0) return oc268d5d38dd.a(jsonElement2.getAsString());
            if (jsonElement2.getAsJsonPrimitive().isString()) break block18;
            throw oc268d5d38dd.\u016e();
        }
        jsonElement2 = jsonElement;
        return oc268d5d38dd.a(jsonElement2.getAsString());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String a(String string) throws IOException {
        boolean bl;
        String string2;
        block12: {
            String string3;
            int n;
            block10: {
                block11: {
                    n = oc6d9efd226f.\u03a5;
                    string3 = string;
                    if (n != 0) break block10;
                    if (string3 != null) break block11;
                    return null;
                }
                string3 = string.trim();
            }
            string2 = string3;
            bl = string2.isEmpty();
            if (n != 0) break block12;
            if (bl) throw oc268d5d38dd.\u016e();
            bl = \u0174.matcher(string2).matches();
        }
        if (bl) return string2;
        throw oc268d5d38dd.\u016e();
    }

    private static String \u0370(JsonObject jsonObject, String string, int n) throws IOException {
        return oc268d5d38dd.\u03fe(jsonObject, string, n, true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String \u03fe(JsonObject jsonObject, String string, int n, boolean bl) throws IOException {
        String string2;
        String string3;
        block12: {
            boolean bl2;
            block11: {
                string3 = oc268d5d38dd.\u0564(jsonObject, string, n);
                int n2 = oc6d9efd226f.\u03a5;
                if (string3 == null) throw oc268d5d38dd.\u016e();
                bl2 = bl;
                if (n2 != 0) break block11;
                if (!bl2) break block12;
                string2 = string3;
                if (n2 != 0) return string2;
                bl2 = string2.isEmpty();
            }
            if (bl2) {
                throw oc268d5d38dd.\u016e();
            }
        }
        string2 = string3;
        return string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String \u0564(JsonObject jsonObject, String string, int n) throws IOException {
        String string2;
        String string3;
        block24: {
            JsonElement jsonElement;
            int n2;
            block22: {
                JsonElement jsonElement2;
                block23: {
                    block21: {
                        block19: {
                            block20: {
                                block18: {
                                    jsonElement2 = jsonObject.get(string);
                                    n2 = oc6d9efd226f.\u03a5;
                                    jsonElement = jsonElement2;
                                    if (n2 != 0) break block18;
                                    if (jsonElement == null) return null;
                                    jsonElement = jsonElement2;
                                }
                                if (n2 != 0) break block19;
                                if (!jsonElement.isJsonNull()) break block20;
                                return null;
                            }
                            jsonElement = jsonElement2;
                        }
                        if (n2 != 0) break block21;
                        if (!jsonElement.isJsonPrimitive()) throw oc268d5d38dd.\u016e();
                        jsonElement = jsonElement2;
                    }
                    if (n2 != 0) break block22;
                    if (jsonElement.getAsJsonPrimitive().isString()) break block23;
                    throw oc268d5d38dd.\u016e();
                }
                jsonElement = jsonElement2;
            }
            string3 = jsonElement.getAsString().trim();
            string2 = string3;
            if (n2 != 0) return string2;
            if (string2.length() <= n) break block24;
            throw oc268d5d38dd.\u016e();
        }
        string2 = string3;
        return string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean \u0278(JsonObject jsonObject, String string) throws IOException {
        JsonPrimitive jsonPrimitive;
        JsonPrimitive jsonPrimitive2;
        block19: {
            JsonElement jsonElement;
            int n;
            block17: {
                JsonElement jsonElement2;
                block18: {
                    block15: {
                        block16: {
                            block14: {
                                jsonElement2 = jsonObject.get(string);
                                n = oc6d9efd226f.\u03a5;
                                jsonElement = jsonElement2;
                                if (n != 0) break block14;
                                if (jsonElement == null) return false;
                                jsonElement = jsonElement2;
                            }
                            if (n != 0) break block15;
                            if (!jsonElement.isJsonNull()) break block16;
                            return false;
                        }
                        jsonElement = jsonElement2;
                    }
                    if (n != 0) break block17;
                    if (jsonElement.isJsonPrimitive()) break block18;
                    throw oc268d5d38dd.\u016e();
                }
                jsonElement = jsonElement2;
            }
            jsonPrimitive2 = jsonElement.getAsJsonPrimitive();
            jsonPrimitive = jsonPrimitive2;
            if (n != 0) return jsonPrimitive.getAsBoolean();
            if (jsonPrimitive.isBoolean()) break block19;
            throw oc268d5d38dd.\u016e();
        }
        jsonPrimitive = jsonPrimitive2;
        return jsonPrimitive.getAsBoolean();
    }

    private static boolean \u0189(String string) {
        char c;
        block8: {
            int n = 0;
            int n2 = oc6d9efd226f.\u03a5;
            while (n < string.length()) {
                block7: {
                    block9: {
                        char c2 = string.charAt(n);
                        if (n2 != 0) break block7;
                        c = c2;
                        if (n2 != 0) break block8;
                        if (!Character.isISOControl(c)) break block9;
                        return true;
                    }
                    ++n;
                }
                if (n2 == 0) continue;
            }
            c = '\u0000';
        }
        return c != '\u0000';
    }

    private static IOException \u016e() {
        return new IOException("The changelog service returned an invalid response");
    }
}

