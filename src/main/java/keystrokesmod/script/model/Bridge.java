/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import java.util.HashMap;
import java.util.Map;

public class Bridge {
    private static final Map<String, Object> map = new HashMap<String, Object>();

    public void add(String string, Object object) {
        map.put(string, object);
    }

    public void add(String string) {
        map.put(string, null);
    }

    public void remove(String string) {
        map.remove(string);
    }

    public boolean has(String string) {
        return map.containsKey(string);
    }

    public Object get(String string) {
        if (!map.containsKey(string)) {
            return null;
        }
        return map.getOrDefault(string, null);
    }

    public void clear() {
        map.clear();
    }
}

