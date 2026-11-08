/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.extensions.compactnotation;

import com.viaversion.viaversion.libs.snakeyaml.LoaderOptions;
import com.viaversion.viaversion.libs.snakeyaml.extensions.compactnotation.CompactConstructor;

public class PackageCompactConstructor
extends CompactConstructor {
    private final String packageName;

    public PackageCompactConstructor(String string) {
        super(new LoaderOptions());
        this.packageName = string;
    }

    @Override
    protected Class<?> getClassForName(String string) throws ClassNotFoundException {
        if (string.indexOf(46) < 0) {
            try {
                Class<?> clazz = Class.forName(this.packageName + "." + string);
                return clazz;
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
        }
        return super.getClassForName(string);
    }
}

