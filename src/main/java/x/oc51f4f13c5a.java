/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class oc51f4f13c5a {
    private final int \u0570;
    private final String \u0433;
    private final Map<String, List<String>> \u01e1;
    public static int \u0405;

    public oc51f4f13c5a(int n, String string, Map<String, List<String>> map) {
        this.\u0570 = n;
        this.\u0433 = string == null ? "" : string;
        this.\u01e1 = map == null ? Collections.emptyMap() : map;
    }

    public int \u0463() {
        return this.\u0570;
    }

    public String \u02a4() {
        return this.\u0433;
    }

    public String \u012f(String string) {
        Iterator<Map.Entry<String, List<String>>> iterator2 = this.\u01e1.entrySet().iterator();
        int n = \u0405;
        while (iterator2.hasNext()) {
            block21: {
                Object object;
                block24: {
                    Object object2;
                    Map.Entry<String, List<String>> entry;
                    block23: {
                        Object object3;
                        block22: {
                            block20: {
                                entry = iterator2.next();
                                object3 = entry;
                                if (n != 0) break block20;
                                if (object3.getKey() == null) break block21;
                                object3 = entry.getKey();
                            }
                            if (n != 0) break block22;
                            if (!((String)object3).equalsIgnoreCase(string)) break block21;
                            object2 = entry;
                            if (n != 0) break block23;
                            object3 = object2.getValue();
                        }
                        if (object3 == null) break block21;
                        object = entry;
                        if (n != 0) break block24;
                        object2 = object.getValue();
                    }
                    if (((List)object2).isEmpty()) break block21;
                    object = entry.getValue().get(0);
                }
                return (String)object;
            }
            if (n == 0) continue;
        }
        String string2 = "";
        if (false) {
            \u0405 = ++n;
        }
        return string2;
    }

    public long \u0115(long l) {
        try {
            return Math.max(0x2AB4CFC1A36B537EL ^ 0x2AB4CFC1A36B5096L, Long.parseLong(this.\u012f("Retry-After").trim()) * (0x2AB4CFC1A36B537EL ^ 0x2AB4CFC1A36B5096L));
        }
        catch (Exception exception) {
            return l;
        }
    }
}

