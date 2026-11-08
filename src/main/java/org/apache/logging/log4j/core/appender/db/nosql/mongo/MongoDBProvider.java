/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.nosql.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLProvider;
import org.apache.logging.log4j.core.appender.db.nosql.mongo.MongoDBConnection;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.NameUtil;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="MongoDb", category="Core", printObject=true)
public class MongoDBProvider
implements NoSQLProvider<MongoDBConnection> {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private final String collectionName;
    private final DB database;
    private final String description;
    private final WriteConcern writeConcern;

    private MongoDBProvider(DB dB, WriteConcern writeConcern, String string, String string2) {
        this.database = dB;
        this.writeConcern = writeConcern;
        this.collectionName = string;
        this.description = "mongoDb{ " + string2 + " }";
    }

    @Override
    public MongoDBConnection getConnection() {
        return new MongoDBConnection(this.database, this.writeConcern, this.collectionName);
    }

    @Override
    public String toString() {
        return this.description;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @PluginFactory
    public static MongoDBProvider createNoSQLProvider(@PluginAttribute(value="collectionName") String string, @PluginAttribute(value="writeConcernConstant") String string2, @PluginAttribute(value="writeConcernConstantClass") String string3, @PluginAttribute(value="databaseName") String string4, @PluginAttribute(value="server") String string5, @PluginAttribute(value="port") String string6, @PluginAttribute(value="username") String string7, @PluginAttribute(value="password") String string8, @PluginAttribute(value="factoryClassName") String string9, @PluginAttribute(value="factoryMethodName") String string10) {
        String string11;
        DB dB;
        Object object;
        GenericDeclaration genericDeclaration;
        WriteConcern writeConcern;
        if (string9 != null && string9.length() > 0 && string10 != null && string10.length() > 0) {
            try {
                block27: {
                    writeConcern = Class.forName(string9);
                    genericDeclaration = writeConcern.getMethod(string10, new Class[0]);
                    object = ((Method)genericDeclaration).invoke(null, new Object[0]);
                    if (object instanceof DB) {
                        dB = (DB)object;
                    } else {
                        if (object instanceof MongoClient) {
                            if (string4 != null && string4.length() > 0) {
                                dB = ((MongoClient)object).getDB(string4);
                                break block27;
                            } else {
                                LOGGER.error("The factory method [{}.{}()] returned a MongoClient so the database name is required.", string9, string10);
                                return null;
                            }
                        }
                        if (object == null) {
                            LOGGER.error("The factory method [{}.{}()] returned null.", string9, string10);
                            return null;
                        }
                        LOGGER.error("The factory method [{}.{}()] returned an unsupported type [{}].", string9, string10, object.getClass().getName());
                        return null;
                    }
                }
                string11 = "database=" + dB.getName();
                List list = dB.getMongo().getAllAddress();
                if (list.size() == 1) {
                    string11 = string11 + ", server=" + ((ServerAddress)list.get(0)).getHost() + ", port=" + ((ServerAddress)list.get(0)).getPort();
                }
                string11 = string11 + ", servers=[";
                for (ServerAddress serverAddress : list) {
                    string11 = string11 + " { " + serverAddress.getHost() + ", " + serverAddress.getPort() + " } ";
                }
                string11 = string11 + "]";
            }
            catch (ClassNotFoundException classNotFoundException) {
                LOGGER.error("The factory class [{}] could not be loaded.", string9, classNotFoundException);
                return null;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                LOGGER.error("The factory class [{}] does not have a no-arg method named [{}].", string9, string10, noSuchMethodException);
                return null;
            }
            catch (Exception exception) {
                LOGGER.error("The factory method [{}.{}()] could not be invoked.", string9, string10, exception);
                return null;
            }
        } else if (string4 != null && string4.length() > 0) {
            string11 = "database=" + string4;
            try {
                if (string5 != null && string5.length() > 0) {
                    int n = AbstractAppender.parseInt(string6, 0);
                    string11 = string11 + ", server=" + string5;
                    if (n > 0) {
                        string11 = string11 + ", port=" + n;
                        dB = new MongoClient(string5, n).getDB(string4);
                    }
                    dB = new MongoClient(string5).getDB(string4);
                }
                dB = new MongoClient().getDB(string4);
            }
            catch (Exception exception) {
                LOGGER.error("Failed to obtain a database instance from the MongoClient at server [{}] and port [{}].", string5, string6);
                return null;
            }
        } else {
            LOGGER.error("No factory method was provided so the database name is required.");
            return null;
        }
        if (!dB.isAuthenticated()) {
            if (string7 != null && string7.length() > 0 && string8 != null && string8.length() > 0) {
                string11 = string11 + ", username=" + string7 + ", passwordHash=" + NameUtil.md5(string8 + MongoDBProvider.class.getName());
                MongoDBConnection.authenticate(dB, string7, string8);
            } else {
                LOGGER.error("The database is not already authenticated so you must supply a username and password for the MongoDB provider.");
                return null;
            }
        }
        if (string2 != null && string2.length() > 0) {
            if (string3 != null && string3.length() > 0) {
                try {
                    genericDeclaration = Class.forName(string3);
                    object = ((Class)genericDeclaration).getField(string2);
                    writeConcern = (WriteConcern)((Field)object).get(null);
                    return new MongoDBProvider(dB, writeConcern, string, string11);
                }
                catch (Exception exception) {
                    LOGGER.error("Write concern constant [{}.{}] not found, using default.", string3, string2);
                    writeConcern = WriteConcern.ACKNOWLEDGED;
                    return new MongoDBProvider(dB, writeConcern, string, string11);
                }
            }
            writeConcern = WriteConcern.valueOf((String)string2);
            if (writeConcern != null) return new MongoDBProvider(dB, writeConcern, string, string11);
            LOGGER.warn("Write concern constant [{}] not found, using default.", string2);
            writeConcern = WriteConcern.ACKNOWLEDGED;
            return new MongoDBProvider(dB, writeConcern, string, string11);
        }
        writeConcern = WriteConcern.ACKNOWLEDGED;
        return new MongoDBProvider(dB, writeConcern, string, string11);
    }
}

