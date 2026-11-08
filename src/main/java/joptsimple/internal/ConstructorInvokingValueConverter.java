/*
 * Decompiled with CFR 0.152.
 */
package joptsimple.internal;

import java.lang.reflect.Constructor;
import joptsimple.ValueConverter;
import joptsimple.internal.Reflection;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ConstructorInvokingValueConverter<V>
implements ValueConverter<V> {
    private final Constructor<V> ctor;

    ConstructorInvokingValueConverter(Constructor<V> constructor) {
        this.ctor = constructor;
    }

    @Override
    public V convert(String string) {
        return Reflection.instantiate(this.ctor, string);
    }

    @Override
    public Class<V> valueType() {
        return this.ctor.getDeclaringClass();
    }

    @Override
    public String valuePattern() {
        return null;
    }
}

