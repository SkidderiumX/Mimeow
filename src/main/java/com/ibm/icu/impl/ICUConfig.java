/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUData;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.MissingResourceException;
import java.util.Properties;

public class ICUConfig {
    public static final String CONFIG_PROPS_FILE = "/com/ibm/icu/ICUConfig.properties";
    private static final Properties CONFIG_PROPS = new Properties();

    public static String get(String string) {
        return ICUConfig.get(string, null);
    }

    public static String get(String string, String string2) {
        String string3 = null;
        final String string4 = string;
        if (System.getSecurityManager() != null) {
            try {
                string3 = AccessController.doPrivileged(new PrivilegedAction<String>(){

                    @Override
                    public String run() {
                        return System.getProperty(string4);
                    }
                });
            }
            catch (AccessControlException accessControlException) {}
        } else {
            string3 = System.getProperty(string);
        }
        if (string3 == null) {
            string3 = CONFIG_PROPS.getProperty(string, string2);
        }
        return string3;
    }

    static {
        try {
            InputStream inputStream2 = ICUData.getStream(CONFIG_PROPS_FILE);
            if (inputStream2 != null) {
                CONFIG_PROPS.load(inputStream2);
            }
        }
        catch (MissingResourceException missingResourceException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

