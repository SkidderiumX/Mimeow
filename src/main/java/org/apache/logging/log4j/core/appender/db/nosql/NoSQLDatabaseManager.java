/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.nosql;

import java.util.Date;
import java.util.Map;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseManager;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLConnection;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLObject;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLProvider;

public class NoSQLDatabaseManager<W>
extends AbstractDatabaseManager {
    private static final NoSQLDatabaseManagerFactory FACTORY = new NoSQLDatabaseManagerFactory();
    private final NoSQLProvider<NoSQLConnection<W, ? extends NoSQLObject<W>>> provider;
    private NoSQLConnection<W, ? extends NoSQLObject<W>> connection;

    private NoSQLDatabaseManager(String string, int n, NoSQLProvider<NoSQLConnection<W, ? extends NoSQLObject<W>>> noSQLProvider) {
        super(string, n);
        this.provider = noSQLProvider;
    }

    @Override
    protected void connectInternal() {
        this.connection = this.provider.getConnection();
    }

    @Override
    protected void disconnectInternal() {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }
    }

    @Override
    protected void writeInternal(LogEvent logEvent) {
        Object object;
        Object object2;
        Object object3;
        if (!this.isConnected() || this.connection == null || this.connection.isClosed()) {
            throw new AppenderLoggingException("Cannot write logging event; NoSQL manager not connected to the database.");
        }
        NoSQLObject<W> noSQLObject = this.connection.createObject();
        noSQLObject.set("level", (Object)logEvent.getLevel());
        noSQLObject.set("loggerName", logEvent.getLoggerName());
        noSQLObject.set("message", logEvent.getMessage() == null ? null : logEvent.getMessage().getFormattedMessage());
        StackTraceElement stackTraceElement = logEvent.getSource();
        if (stackTraceElement == null) {
            noSQLObject.set("source", (Object)null);
        } else {
            noSQLObject.set("source", this.convertStackTraceElement(stackTraceElement));
        }
        Marker marker = logEvent.getMarker();
        if (marker == null) {
            noSQLObject.set("marker", (Object)null);
        } else {
            object2 = object3 = this.connection.createObject();
            object2.set("name", marker.getName());
            while (marker.getParent() != null) {
                marker = marker.getParent();
                object = this.connection.createObject();
                object.set("name", marker.getName());
                object2.set("parent", object);
                object2 = object;
            }
            noSQLObject.set("marker", (NoSQLObject<W>)object3);
        }
        noSQLObject.set("threadName", logEvent.getThreadName());
        noSQLObject.set("millis", logEvent.getMillis());
        noSQLObject.set("date", new Date(logEvent.getMillis()));
        object3 = logEvent.getThrown();
        if (object3 == null) {
            noSQLObject.set("thrown", (Object)null);
        } else {
            object = object2 = this.connection.createObject();
            object.set("type", object3.getClass().getName());
            object.set("message", ((Throwable)object3).getMessage());
            object.set("stackTrace", this.convertStackTrace(((Throwable)object3).getStackTrace()));
            while (((Throwable)object3).getCause() != null) {
                object3 = ((Throwable)object3).getCause();
                NoSQLObject<W> noSQLObject2 = this.connection.createObject();
                noSQLObject2.set("type", object3.getClass().getName());
                noSQLObject2.set("message", ((Throwable)object3).getMessage());
                noSQLObject2.set("stackTrace", this.convertStackTrace(((Throwable)object3).getStackTrace()));
                object.set("cause", noSQLObject2);
                object = noSQLObject2;
            }
            noSQLObject.set("thrown", (NoSQLObject<W>)object2);
        }
        object2 = logEvent.getContextMap();
        if (object2 == null) {
            noSQLObject.set("contextMap", (Object)null);
        } else {
            object = this.connection.createObject();
            for (Map.Entry entry : object2.entrySet()) {
                object.set((String)entry.getKey(), entry.getValue());
            }
            noSQLObject.set("contextMap", (NoSQLObject<W>)object);
        }
        object = logEvent.getContextStack();
        if (object == null) {
            noSQLObject.set("contextStack", (Object)null);
        } else {
            noSQLObject.set("contextStack", object.asList().toArray());
        }
        this.connection.insertObject(noSQLObject);
    }

    private NoSQLObject<W>[] convertStackTrace(StackTraceElement[] stackTraceElementArray) {
        NoSQLObject[] noSQLObjectArray = this.connection.createList(stackTraceElementArray.length);
        for (int i = 0; i < stackTraceElementArray.length; ++i) {
            noSQLObjectArray[i] = this.convertStackTraceElement(stackTraceElementArray[i]);
        }
        return noSQLObjectArray;
    }

    private NoSQLObject<W> convertStackTraceElement(StackTraceElement stackTraceElement) {
        NoSQLObject<W> noSQLObject = this.connection.createObject();
        noSQLObject.set("className", stackTraceElement.getClassName());
        noSQLObject.set("methodName", stackTraceElement.getMethodName());
        noSQLObject.set("fileName", stackTraceElement.getFileName());
        noSQLObject.set("lineNumber", stackTraceElement.getLineNumber());
        return noSQLObject;
    }

    public static NoSQLDatabaseManager<?> getNoSQLDatabaseManager(String string, int n, NoSQLProvider<?> noSQLProvider) {
        return (NoSQLDatabaseManager)AbstractDatabaseManager.getManager(string, new FactoryData(n, noSQLProvider), FACTORY);
    }

    private static final class NoSQLDatabaseManagerFactory
    implements ManagerFactory<NoSQLDatabaseManager<?>, FactoryData> {
        private NoSQLDatabaseManagerFactory() {
        }

        @Override
        public NoSQLDatabaseManager<?> createManager(String string, FactoryData factoryData) {
            return new NoSQLDatabaseManager(string, factoryData.getBufferSize(), factoryData.provider);
        }
    }

    private static final class FactoryData
    extends AbstractDatabaseManager.AbstractFactoryData {
        private final NoSQLProvider<?> provider;

        protected FactoryData(int n, NoSQLProvider<?> noSQLProvider) {
            super(n);
            this.provider = noSQLProvider;
        }
    }
}

