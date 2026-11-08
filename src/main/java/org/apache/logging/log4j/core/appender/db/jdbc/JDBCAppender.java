/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.jdbc;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseAppender;
import org.apache.logging.log4j.core.appender.db.jdbc.ColumnConfig;
import org.apache.logging.log4j.core.appender.db.jdbc.ConnectionSource;
import org.apache.logging.log4j.core.appender.db.jdbc.JDBCDatabaseManager;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;

@Plugin(name="JDBC", category="Core", elementType="appender", printObject=true)
public class JDBCAppender
extends AbstractDatabaseAppender<JDBCDatabaseManager> {
    private final String description = this.getName() + "{ manager=" + this.getManager() + " }";

    private JDBCAppender(String string, Filter filter, boolean bl, JDBCDatabaseManager jDBCDatabaseManager) {
        super(string, filter, bl, jDBCDatabaseManager);
    }

    @Override
    public String toString() {
        return this.description;
    }

    @PluginFactory
    public static JDBCAppender createAppender(@PluginAttribute(value="name") String string, @PluginAttribute(value="ignoreExceptions") String string2, @PluginElement(value="Filter") Filter filter, @PluginElement(value="ConnectionSource") ConnectionSource connectionSource, @PluginAttribute(value="bufferSize") String string3, @PluginAttribute(value="tableName") String string4, @PluginElement(value="ColumnConfigs") ColumnConfig[] columnConfigArray) {
        int n = AbstractAppender.parseInt(string3, 0);
        boolean bl = Booleans.parseBoolean(string2, true);
        StringBuilder stringBuilder = new StringBuilder("jdbcManager{ description=").append(string).append(", bufferSize=").append(n).append(", connectionSource=").append(((Object)connectionSource).toString()).append(", tableName=").append(string4).append(", columns=[ ");
        int n2 = 0;
        for (ColumnConfig columnConfig : columnConfigArray) {
            if (n2++ > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(columnConfig.toString());
        }
        stringBuilder.append(" ] }");
        JDBCDatabaseManager jDBCDatabaseManager = JDBCDatabaseManager.getJDBCDatabaseManager(stringBuilder.toString(), n, connectionSource, string4, columnConfigArray);
        if (jDBCDatabaseManager == null) {
            return null;
        }
        return new JDBCAppender(string, filter, bl, jDBCDatabaseManager);
    }
}

