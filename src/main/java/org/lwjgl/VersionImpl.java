/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl;

import org.lwjgl.Version;

public class VersionImpl {
    VersionImpl() {
    }

    static String find() {
        Package package_ = Version.class.getPackage();
        String string = package_.getSpecificationVersion();
        String string2 = package_.getImplementationVersion();
        if (string != null && string2 != null) {
            return Version.createImplementation(string, string2);
        }
        String string3 = Version.findImplementationFromManifest();
        if (string3 != null) {
            return string3;
        }
        return "-snapshot";
    }
}

