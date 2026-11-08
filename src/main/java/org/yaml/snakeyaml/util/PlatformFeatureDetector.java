/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.util;

public class PlatformFeatureDetector {
    private Boolean isRunningOnAndroid = null;

    public boolean isIntrospectionAvailable() {
        if (this.isRunningOnAndroid()) {
            return false;
        }
        try {
            Class.forName("java.beans.Introspector");
            return true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    public boolean isRunningOnAndroid() {
        if (this.isRunningOnAndroid == null) {
            String string = System.getProperty("java.runtime.name");
            this.isRunningOnAndroid = string != null && string.startsWith("Android Runtime");
        }
        return this.isRunningOnAndroid;
    }
}

