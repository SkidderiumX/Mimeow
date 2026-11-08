/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import x.oc5b5c244014;
import x.oc75d51ec7eb;

public class ocac553a4d9a {
    private static final Map<String, Integer> j = new LinkedHashMap<String, Integer>();
    private static final Map<Integer, String> \u03e4 = new LinkedHashMap<Integer, String>();
    public static int \u046d;

    private ocac553a4d9a() {
    }

    public static int \u0104(String string) {
        int n;
        block6: {
            Integer n2;
            block4: {
                Integer n3;
                block5: {
                    n3 = j.get(string);
                    int n4 = oc75d51ec7eb.\u03e9;
                    n2 = n3;
                    if (n4 != 0) break block4;
                    if (n2 != null) break block5;
                    n = -1;
                    break block6;
                }
                n2 = n3;
            }
            n = n2;
        }
        return n;
    }

    public static String \u0515(int n) {
        return \u03e4.get(n);
    }

    public static boolean \u0183(List<String> list, int n) {
        int n2;
        block9: {
            Iterator<String> iterator2 = list.iterator();
            int n3 = oc75d51ec7eb.\u03e9;
            while (iterator2.hasNext()) {
                block11: {
                    int n4;
                    block12: {
                        block10: {
                            String string = iterator2.next();
                            n2 = ocac553a4d9a.\u0104(string);
                            if (n3 != 0) break block9;
                            int n5 = n2;
                            n4 = n5;
                            if (n3 != 0) break block10;
                            if (n4 == -1) break block11;
                            n4 = n5;
                        }
                        if (n3 != 0) break block12;
                        if (n4 != n) break block11;
                        n4 = 1;
                    }
                    return n4 != 0;
                }
                if (n3 == 0) continue;
            }
            n2 = 0;
        }
        return n2 != 0;
    }

    public static List<String> \u016e(List<String> list) {
        Object object;
        block10: {
            TreeSet<Integer> treeSet = new TreeSet<Integer>(new oc5b5c244014());
            Object object2 = list.iterator();
            int n = oc75d51ec7eb.\u03e9;
            while (object2.hasNext()) {
                block9: {
                    String string = object2.next();
                    int n2 = ocac553a4d9a.\u0104(string);
                    int n3 = n2;
                    if (n != 0 || n3 == -1) break block9;
                    n3 = treeSet.add(n2) ? 1 : 0;
                }
                if (n == 0) continue;
            }
            object2 = new ArrayList();
            for (Integer n4 : treeSet) {
                object = object2;
                if (n == 0) {
                    object.add(ocac553a4d9a.\u0515(n4));
                    if (n == 0) continue;
                    break;
                }
                break block10;
            }
            object = Collections.unmodifiableList(object2);
        }
        return object;
    }

    static {
        try (InputStreamReader inputStreamReader = new InputStreamReader(ocac553a4d9a.class.getResourceAsStream("/assets/slinkysemantic/ItemCatalog.json"), "UTF-8");){
            for (JsonElement jsonElement : new JsonParser().parse(inputStreamReader).getAsJsonArray()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String string = jsonObject.get("name").getAsString();
                int n = jsonObject.get("id").getAsInt();
                j.put(string, n);
                \u03e4.put(n, string);
            }
            if (j.size() != (0xD2007DC9 ^ 0xD2007C48)) {
                throw new IllegalStateException("Incomplete recovered item catalog");
            }
        }
        catch (IOException iOException) {
            throw new ExceptionInInitializerError(iOException);
        }
    }
}

