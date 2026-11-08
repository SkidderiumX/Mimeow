/*
 * Decompiled with CFR 0.152.
 */
package org.slf4j.helpers;

public class Slf4jEnvUtil {
    public static String slf4jVersion() {
        Package package_ = Slf4jEnvUtil.class.getPackage();
        if (package_ == null) {
            return null;
        }
        String string = package_.getImplementationVersion();
        return string;
    }
}

