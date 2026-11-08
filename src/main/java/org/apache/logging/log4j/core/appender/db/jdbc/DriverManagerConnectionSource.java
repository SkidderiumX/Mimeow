/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.db.jdbc.ConnectionSource;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.NameUtil;
import org.apache.logging.log4j.core.helpers.Strings;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="DriverManager", category="Core", elementType="connectionSource", printObject=true)
public class DriverManagerConnectionSource
implements ConnectionSource {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private final String databasePassword;
    private final String databaseUrl;
    private final String databaseUsername;
    private final String description;

    private DriverManagerConnectionSource(String string, String string2, String string3) {
        this.databaseUrl = string;
        this.databaseUsername = string2;
        this.databasePassword = string3;
        this.description = "driverManager{ url=" + this.databaseUrl + ", username=" + this.databaseUsername + ", passwordHash=" + NameUtil.md5(this.databasePassword + this.getClass().getName()) + " }";
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (this.databaseUsername == null) {
            return DriverManager.getConnection(this.databaseUrl);
        }
        return DriverManager.getConnection(this.databaseUrl, this.databaseUsername, this.databasePassword);
    }

    @Override
    public String toString() {
        return this.description;
    }

    @PluginFactory
    public static DriverManagerConnectionSource createConnectionSource(@PluginAttribute(value="url") String string, @PluginAttribute(value="username") String string2, @PluginAttribute(value="password") String string3) {
        Driver driver;
        if (Strings.isEmpty(string)) {
            LOGGER.error("No JDBC URL specified for the database.");
            return null;
        }
        try {
            driver = DriverManager.getDriver(string);
        }
        catch (SQLException sQLException) {
            LOGGER.error("No matching driver found for database URL [" + string + "].", (Throwable)sQLException);
            return null;
        }
        if (driver == null) {
            LOGGER.error("No matching driver found for database URL [" + string + "].");
            return null;
        }
        if (string2 == null || string2.trim().isEmpty()) {
            string2 = null;
            string3 = null;
        }
        return new DriverManagerConnectionSource(string, string2, string3);
    }
}

