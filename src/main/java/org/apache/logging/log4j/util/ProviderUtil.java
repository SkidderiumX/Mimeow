/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.util;

import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.Provider;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

public class ProviderUtil {
    private static final String PROVIDER_RESOURCE = "META-INF/log4j-provider.properties";
    private static final String API_VERSION = "Log4jAPIVersion";
    private static final String[] COMPATIBLE_API_VERSIONS = new String[]{"2.0.0"};
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final List<Provider> PROVIDERS = new ArrayList<Provider>();

    private ProviderUtil() {
    }

    public static Iterator<Provider> getProviders() {
        return PROVIDERS.iterator();
    }

    public static boolean hasProviders() {
        return PROVIDERS.size() > 0;
    }

    public static ClassLoader findClassLoader() {
        ClassLoader classLoader = System.getSecurityManager() == null ? Thread.currentThread().getContextClassLoader() : AccessController.doPrivileged(new PrivilegedAction<ClassLoader>(){

            @Override
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
        if (classLoader == null) {
            classLoader = ProviderUtil.class.getClassLoader();
        }
        return classLoader;
    }

    private static boolean validVersion(String string) {
        for (String string2 : COMPATIBLE_API_VERSIONS) {
            if (!string.startsWith(string2)) continue;
            return true;
        }
        return false;
    }

    static {
        ClassLoader classLoader = ProviderUtil.findClassLoader();
        Enumeration<URL> enumeration = null;
        try {
            enumeration = classLoader.getResources(PROVIDER_RESOURCE);
        }
        catch (IOException iOException) {
            LOGGER.fatal("Unable to locate META-INF/log4j-provider.properties", (Throwable)iOException);
        }
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                URL uRL = enumeration.nextElement();
                try {
                    Properties properties = PropertiesUtil.loadClose(uRL.openStream(), uRL);
                    if (!ProviderUtil.validVersion(properties.getProperty(API_VERSION))) continue;
                    PROVIDERS.add(new Provider(properties, uRL));
                }
                catch (IOException iOException) {
                    LOGGER.error("Unable to open " + uRL.toString(), (Throwable)iOException);
                }
            }
        }
    }
}

