/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class oc9e31e3c157<T> {
    private final Map<T, T> \u04dd = new ConcurrentHashMap<T, T>();
    public static int \u04e8;

    public T \u0442(T t) {
        if (t == null) {
            return null;
        }
        T t2 = this.\u04dd.putIfAbsent(t, t);
        T t3 = t2 != null ? t2 : t;
        return t3;
    }

    public void \u0168() {
        this.\u04dd.clear();
    }

    public int \u0129() {
        return this.\u04dd.size();
    }
}

