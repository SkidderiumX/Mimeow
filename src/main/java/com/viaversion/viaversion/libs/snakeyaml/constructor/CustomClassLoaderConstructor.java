/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.constructor;

import com.viaversion.viaversion.libs.snakeyaml.LoaderOptions;
import com.viaversion.viaversion.libs.snakeyaml.constructor.Constructor;

public class CustomClassLoaderConstructor
extends Constructor {
    private final ClassLoader loader;

    public CustomClassLoaderConstructor(ClassLoader classLoader, LoaderOptions loaderOptions) {
        this(Object.class, classLoader, loaderOptions);
    }

    public CustomClassLoaderConstructor(Class<? extends Object> clazz, ClassLoader classLoader, LoaderOptions loaderOptions) {
        super(clazz, loaderOptions);
        if (classLoader == null) {
            throw new NullPointerException("Loader must be provided.");
        }
        this.loader = classLoader;
    }

    @Override
    protected Class<?> getClassForName(String string) throws ClassNotFoundException {
        return Class.forName(string, true, this.loader);
    }
}

