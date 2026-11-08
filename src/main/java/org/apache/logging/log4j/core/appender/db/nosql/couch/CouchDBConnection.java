/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.nosql.couch;

import java.util.Map;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLConnection;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLObject;
import org.apache.logging.log4j.core.appender.db.nosql.couch.CouchDBObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

public class CouchDBConnection
implements NoSQLConnection<Map<String, Object>, CouchDBObject> {
    private final CouchDbClient client;
    private boolean closed = false;

    public CouchDBConnection(CouchDbClient couchDbClient) {
        this.client = couchDbClient;
    }

    @Override
    public CouchDBObject createObject() {
        return new CouchDBObject();
    }

    public CouchDBObject[] createList(int n) {
        return new CouchDBObject[n];
    }

    @Override
    public void insertObject(NoSQLObject<Map<String, Object>> noSQLObject) {
        try {
            Response response = this.client.save(noSQLObject.unwrap());
            if (response.getError() != null && response.getError().length() > 0) {
                throw new AppenderLoggingException("Failed to write log event to CouchDB due to error: " + response.getError() + ".");
            }
        }
        catch (Exception exception) {
            throw new AppenderLoggingException("Failed to write log event to CouchDB due to error: " + exception.getMessage(), exception);
        }
    }

    @Override
    public synchronized void close() {
        this.closed = true;
        this.client.shutdown();
    }

    @Override
    public synchronized boolean isClosed() {
        return this.closed;
    }
}

