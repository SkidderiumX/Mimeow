/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.jdbc;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseManager;
import org.apache.logging.log4j.core.appender.db.jdbc.ColumnConfig;
import org.apache.logging.log4j.core.appender.db.jdbc.ConnectionSource;
import org.apache.logging.log4j.core.helpers.Closer;
import org.apache.logging.log4j.core.layout.PatternLayout;

public class JDBCDatabaseManager
extends AbstractDatabaseManager {
    private static final JDBCDatabaseManagerFactory FACTORY = new JDBCDatabaseManagerFactory();
    private final List<Column> columns;
    private final ConnectionSource connectionSource;
    private final String sqlStatement;
    private Connection connection;
    private PreparedStatement statement;

    private JDBCDatabaseManager(String string, int n, ConnectionSource connectionSource, String string2, List<Column> list) {
        super(string, n);
        this.connectionSource = connectionSource;
        this.sqlStatement = string2;
        this.columns = list;
    }

    @Override
    protected void connectInternal() throws SQLException {
        this.connection = this.connectionSource.getConnection();
        this.statement = this.connection.prepareStatement(this.sqlStatement);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void disconnectInternal() throws SQLException {
        try {
            Closer.close(this.statement);
        }
        finally {
            Closer.close(this.connection);
        }
    }

    @Override
    protected void writeInternal(LogEvent logEvent) {
        StringReader stringReader = null;
        try {
            if (!this.isConnected() || this.connection == null || this.connection.isClosed()) {
                throw new AppenderLoggingException("Cannot write logging event; JDBC manager not connected to the database.");
            }
            int n = 1;
            for (Column column : this.columns) {
                if (column.isEventTimestamp) {
                    this.statement.setTimestamp(n++, new Timestamp(logEvent.getMillis()));
                    continue;
                }
                if (column.isClob) {
                    stringReader = new StringReader(column.layout.toSerializable(logEvent));
                    if (column.isUnicode) {
                        this.statement.setNClob(n++, stringReader);
                        continue;
                    }
                    this.statement.setClob(n++, stringReader);
                    continue;
                }
                if (column.isUnicode) {
                    this.statement.setNString(n++, column.layout.toSerializable(logEvent));
                    continue;
                }
                this.statement.setString(n++, column.layout.toSerializable(logEvent));
            }
            if (this.statement.executeUpdate() == 0) {
                throw new AppenderLoggingException("No records inserted in database table for log event in JDBC manager.");
            }
        }
        catch (SQLException sQLException) {
            throw new AppenderLoggingException("Failed to insert record for log event in JDBC manager: " + sQLException.getMessage(), sQLException);
        }
        finally {
            Closer.closeSilent(stringReader);
        }
    }

    public static JDBCDatabaseManager getJDBCDatabaseManager(String string, int n, ConnectionSource connectionSource, String string2, ColumnConfig[] columnConfigArray) {
        return AbstractDatabaseManager.getManager(string, new FactoryData(n, connectionSource, string2, columnConfigArray), FACTORY);
    }

    private static final class Column {
        private final PatternLayout layout;
        private final boolean isEventTimestamp;
        private final boolean isUnicode;
        private final boolean isClob;

        private Column(PatternLayout patternLayout, boolean bl, boolean bl2, boolean bl3) {
            this.layout = patternLayout;
            this.isEventTimestamp = bl;
            this.isUnicode = bl2;
            this.isClob = bl3;
        }
    }

    private static final class JDBCDatabaseManagerFactory
    implements ManagerFactory<JDBCDatabaseManager, FactoryData> {
        private JDBCDatabaseManagerFactory() {
        }

        @Override
        public JDBCDatabaseManager createManager(String string, FactoryData factoryData) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            ArrayList<Column> arrayList = new ArrayList<Column>();
            int n = 0;
            for (ColumnConfig columnConfig : factoryData.columnConfigs) {
                if (n++ > 0) {
                    stringBuilder.append(',');
                    stringBuilder2.append(',');
                }
                stringBuilder.append(columnConfig.getColumnName());
                if (columnConfig.getLiteralValue() != null) {
                    stringBuilder2.append(columnConfig.getLiteralValue());
                    continue;
                }
                arrayList.add(new Column(columnConfig.getLayout(), columnConfig.isEventTimestamp(), columnConfig.isUnicode(), columnConfig.isClob()));
                stringBuilder2.append('?');
            }
            String string2 = "INSERT INTO " + factoryData.tableName + " (" + stringBuilder + ") VALUES (" + stringBuilder2 + ")";
            return new JDBCDatabaseManager(string, factoryData.getBufferSize(), factoryData.connectionSource, string2, arrayList);
        }
    }

    private static final class FactoryData
    extends AbstractDatabaseManager.AbstractFactoryData {
        private final ColumnConfig[] columnConfigs;
        private final ConnectionSource connectionSource;
        private final String tableName;

        protected FactoryData(int n, ConnectionSource connectionSource, String string, ColumnConfig[] columnConfigArray) {
            super(n);
            this.connectionSource = connectionSource;
            this.tableName = string;
            this.columnConfigs = columnConfigArray;
        }
    }
}

