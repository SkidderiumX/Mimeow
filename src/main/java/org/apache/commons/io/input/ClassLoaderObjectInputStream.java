/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;
import java.lang.reflect.Proxy;

public class ClassLoaderObjectInputStream
extends ObjectInputStream {
    private final ClassLoader classLoader;

    public ClassLoaderObjectInputStream(ClassLoader classLoader, InputStream inputStream2) throws IOException, StreamCorruptedException {
        super(inputStream2);
        this.classLoader = classLoader;
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        Class<?> clazz = Class.forName(objectStreamClass.getName(), false, this.classLoader);
        if (clazz != null) {
            return clazz;
        }
        return super.resolveClass(objectStreamClass);
    }

    @Override
    protected Class<?> resolveProxyClass(String[] stringArray) throws IOException, ClassNotFoundException {
        Class[] classArray = new Class[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            classArray[i] = Class.forName(stringArray[i], false, this.classLoader);
        }
        try {
            return Proxy.getProxyClass(this.classLoader, classArray);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return super.resolveProxyClass(stringArray);
        }
    }
}

