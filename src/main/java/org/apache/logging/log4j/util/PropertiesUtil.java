/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.ProviderUtil;

public class PropertiesUtil {
    private static final PropertiesUtil LOG4J_PROPERTIES = new PropertiesUtil("log4j2.component.properties");
    private static final Logger LOGGER = StatusLogger.getLogger();
    private final Properties props;

    public PropertiesUtil(Properties properties) {
        this.props = properties;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static Properties loadClose(InputStream inputStream2, Object object) {
        Properties properties = new Properties();
        if (null != inputStream2) {
            try {
                properties.load(inputStream2);
            }
            catch (IOException iOException) {
                LOGGER.error("Unable to read " + object, (Throwable)iOException);
            }
            finally {
                try {
                    inputStream2.close();
                }
                catch (IOException iOException) {
                    LOGGER.error("Unable to close " + object, (Throwable)iOException);
                }
            }
        }
        return properties;
    }

    public PropertiesUtil(String string) {
        ClassLoader classLoader = ProviderUtil.findClassLoader();
        InputStream inputStream2 = classLoader.getResourceAsStream(string);
        this.props = PropertiesUtil.loadClose(inputStream2, string);
    }

    public static PropertiesUtil getProperties() {
        return LOG4J_PROPERTIES;
    }

    public String getStringProperty(String string) {
        String string2 = null;
        try {
            string2 = System.getProperty(string);
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        return string2 == null ? this.props.getProperty(string) : string2;
    }

    public int getIntegerProperty(String string, int n) {
        String string2 = null;
        try {
            string2 = System.getProperty(string);
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        if (string2 == null) {
            string2 = this.props.getProperty(string);
        }
        if (string2 != null) {
            try {
                return Integer.parseInt(string2);
            }
            catch (Exception exception) {
                return n;
            }
        }
        return n;
    }

    public long getLongProperty(String string, long l) {
        String string2 = null;
        try {
            string2 = System.getProperty(string);
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        if (string2 == null) {
            string2 = this.props.getProperty(string);
        }
        if (string2 != null) {
            try {
                return Long.parseLong(string2);
            }
            catch (Exception exception) {
                return l;
            }
        }
        return l;
    }

    public String getStringProperty(String string, String string2) {
        String string3 = this.getStringProperty(string);
        return string3 == null ? string2 : string3;
    }

    public boolean getBooleanProperty(String string) {
        return this.getBooleanProperty(string, false);
    }

    public boolean getBooleanProperty(String string, boolean bl) {
        String string2 = this.getStringProperty(string);
        return string2 == null ? bl : "true".equalsIgnoreCase(string2);
    }

    public static Properties getSystemProperties() {
        try {
            return new Properties(System.getProperties());
        }
        catch (SecurityException securityException) {
            StatusLogger.getLogger().error("Unable to access system properties.");
            return new Properties();
        }
    }
}

