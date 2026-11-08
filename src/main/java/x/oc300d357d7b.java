/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Field;

public class oc300d357d7b {
    final Field \u0399;
    final Object \u0165;
    final Object \u0573;

    oc300d357d7b(Field field, Object object) throws IllegalAccessException {
        this.\u0399 = field;
        this.\u0165 = object;
        this.\u0573 = field.get(object);
    }

    void \u00e2() throws IllegalAccessException {
        this.\u0399.set(this.\u0165, this.\u0573);
    }
}

