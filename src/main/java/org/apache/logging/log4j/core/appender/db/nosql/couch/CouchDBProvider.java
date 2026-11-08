/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.nosql.couch;

import java.lang.reflect.Method;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLProvider;
import org.apache.logging.log4j.core.appender.db.nosql.couch.CouchDBConnection;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.NameUtil;
import org.apache.logging.log4j.core.helpers.Strings;
import org.apache.logging.log4j.status.StatusLogger;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

@Plugin(name="CouchDb", category="Core", printObject=true)
public class CouchDBProvider
implements NoSQLProvider<CouchDBConnection> {
    private static final int HTTP = 80;
    private static final int HTTPS = 443;
    private static final Logger LOGGER = StatusLogger.getLogger();
    private final CouchDbClient client;
    private final String description;

    private CouchDBProvider(CouchDbClient couchDbClient, String string) {
        this.client = couchDbClient;
        this.description = "couchDb{ " + string + " }";
    }

    @Override
    public CouchDBConnection getConnection() {
        return new CouchDBConnection(this.client);
    }

    @Override
    public String toString() {
        return this.description;
    }

    @PluginFactory
    public static CouchDBProvider createNoSQLProvider(@PluginAttribute(value="databaseName") String string, @PluginAttribute(value="protocol") String string2, @PluginAttribute(value="server") String string3, @PluginAttribute(value="port") String string4, @PluginAttribute(value="username") String string5, @PluginAttribute(value="password") String string6, @PluginAttribute(value="factoryClassName") String string7, @PluginAttribute(value="factoryMethodName") String string8) {
        String string9;
        CouchDbClient couchDbClient;
        if (string7 != null && string7.length() > 0 && string8 != null && string8.length() > 0) {
            try {
                Class<?> clazz = Class.forName(string7);
                Method method = clazz.getMethod(string8, new Class[0]);
                Object object = method.invoke(null, new Object[0]);
                if (object instanceof CouchDbClient) {
                    couchDbClient = (CouchDbClient)object;
                    string9 = "uri=" + couchDbClient.getDBUri();
                }
                if (object instanceof CouchDbProperties) {
                    CouchDbProperties couchDbProperties = (CouchDbProperties)object;
                    couchDbClient = new CouchDbClient(couchDbProperties);
                    string9 = "uri=" + couchDbClient.getDBUri() + ", username=" + couchDbProperties.getUsername() + ", passwordHash=" + NameUtil.md5(string6 + CouchDBProvider.class.getName()) + ", maxConnections=" + couchDbProperties.getMaxConnections() + ", connectionTimeout=" + couchDbProperties.getConnectionTimeout() + ", socketTimeout=" + couchDbProperties.getSocketTimeout();
                }
                if (object == null) {
                    LOGGER.error("The factory method [{}.{}()] returned null.", string7, string8);
                    return null;
                }
                LOGGER.error("The factory method [{}.{}()] returned an unsupported type [{}].", string7, string8, object.getClass().getName());
                return null;
            }
            catch (ClassNotFoundException classNotFoundException) {
                LOGGER.error("The factory class [{}] could not be loaded.", string7, classNotFoundException);
                return null;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                LOGGER.error("The factory class [{}] does not have a no-arg method named [{}].", string7, string8, noSuchMethodException);
                return null;
            }
            catch (Exception exception) {
                LOGGER.error("The factory method [{}.{}()] could not be invoked.", string7, string8, exception);
                return null;
            }
        } else if (string != null && string.length() > 0) {
            if (string2 != null && string2.length() > 0) {
                if (!(string2 = string2.toLowerCase()).equals("http") && !string2.equals("https")) {
                    LOGGER.error("Only protocols [http] and [https] are supported, [{}] specified.", string2);
                    return null;
                }
            } else {
                string2 = "http";
                LOGGER.warn("No protocol specified, using default port [http].");
            }
            int n = AbstractAppender.parseInt(string4, string2.equals("https") ? 443 : 80);
            if (Strings.isEmpty(string3)) {
                string3 = "localhost";
                LOGGER.warn("No server specified, using default server localhost.");
            }
            if (Strings.isEmpty(string5) || Strings.isEmpty(string6)) {
                LOGGER.error("You must provide a username and password for the CouchDB provider.");
                return null;
            }
            couchDbClient = new CouchDbClient(string, false, string2, string3, n, string5, string6);
            string9 = "uri=" + couchDbClient.getDBUri() + ", username=" + string5 + ", passwordHash=" + NameUtil.md5(string6 + CouchDBProvider.class.getName());
        } else {
            LOGGER.error("No factory method was provided so the database name is required.");
            return null;
        }
        return new CouchDBProvider(couchDbClient, string9);
    }
}

