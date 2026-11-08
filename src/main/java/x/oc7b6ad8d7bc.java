/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class oc7b6ad8d7bc {
    private static final Map<String, Object> \u0540 = new ConcurrentHashMap<String, Object>();
    public static int n;

    public void \u0431(String string) {
        \u0540.put(string, Boolean.TRUE);
    }

    public void \u03c1(String string, Object object) {
        \u0540.put(string, object);
    }

    public Object \u0295(String string) {
        return \u0540.get(string);
    }

    public boolean n(String string) {
        return \u0540.containsKey(string);
    }

    public void \u00e6(String string) {
        \u0540.remove(string);
    }

    public void \u053b() {
        \u0540.clear();
    }
}

