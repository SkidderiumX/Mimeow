/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.nosql;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseAppender;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLDatabaseManager;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLProvider;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;

@Plugin(name="NoSql", category="Core", elementType="appender", printObject=true)
public class NoSQLAppender
extends AbstractDatabaseAppender<NoSQLDatabaseManager<?>> {
    private final String description = this.getName() + "{ manager=" + this.getManager() + " }";

    private NoSQLAppender(String string, Filter filter, boolean bl, NoSQLDatabaseManager<?> noSQLDatabaseManager) {
        super(string, filter, bl, noSQLDatabaseManager);
    }

    @Override
    public String toString() {
        return this.description;
    }

    @PluginFactory
    public static NoSQLAppender createAppender(@PluginAttribute(value="name") String string, @PluginAttribute(value="ignoreExceptions") String string2, @PluginElement(value="Filter") Filter filter, @PluginAttribute(value="bufferSize") String string3, @PluginElement(value="NoSqlProvider") NoSQLProvider<?> noSQLProvider) {
        if (noSQLProvider == null) {
            LOGGER.error("NoSQL provider not specified for appender [{}].", string);
            return null;
        }
        int n = AbstractAppender.parseInt(string3, 0);
        boolean bl = Booleans.parseBoolean(string2, true);
        String string4 = "noSqlManager{ description=" + string + ", bufferSize=" + n + ", provider=" + noSQLProvider + " }";
        NoSQLDatabaseManager<?> noSQLDatabaseManager = NoSQLDatabaseManager.getNoSQLDatabaseManager(string4, n, noSQLProvider);
        if (noSQLDatabaseManager == null) {
            return null;
        }
        return new NoSQLAppender(string, filter, bl, noSQLDatabaseManager);
    }
}

