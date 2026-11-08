/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.nosql.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLConnection;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLObject;
import org.apache.logging.log4j.core.appender.db.nosql.mongo.MongoDBObject;
import org.apache.logging.log4j.status.StatusLogger;
import org.bson.BSON;
import org.bson.Transformer;

public class MongoDBConnection
implements NoSQLConnection<BasicDBObject, MongoDBObject> {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private final DBCollection collection;
    private final Mongo mongo;
    private final WriteConcern writeConcern;

    public MongoDBConnection(DB dB, WriteConcern writeConcern, String string) {
        this.mongo = dB.getMongo();
        this.collection = dB.getCollection(string);
        this.writeConcern = writeConcern;
    }

    @Override
    public MongoDBObject createObject() {
        return new MongoDBObject();
    }

    public MongoDBObject[] createList(int n) {
        return new MongoDBObject[n];
    }

    @Override
    public void insertObject(NoSQLObject<BasicDBObject> noSQLObject) {
        try {
            WriteResult writeResult = this.collection.insert((DBObject)noSQLObject.unwrap(), this.writeConcern);
            if (writeResult.getError() != null && writeResult.getError().length() > 0) {
                throw new AppenderLoggingException("Failed to write log event to MongoDB due to error: " + writeResult.getError() + ".");
            }
        }
        catch (MongoException mongoException) {
            throw new AppenderLoggingException("Failed to write log event to MongoDB due to error: " + mongoException.getMessage(), mongoException);
        }
    }

    @Override
    public void close() {
        this.mongo.close();
    }

    @Override
    public boolean isClosed() {
        return !this.mongo.getConnector().isOpen();
    }

    static void authenticate(DB dB, String string, String string2) {
        try {
            if (!dB.authenticate(string, string2.toCharArray())) {
                LOGGER.error("Failed to authenticate against MongoDB server. Unknown error.");
            }
        }
        catch (MongoException mongoException) {
            LOGGER.error("Failed to authenticate against MongoDB: " + mongoException.getMessage(), (Throwable)mongoException);
        }
        catch (IllegalStateException illegalStateException) {
            LOGGER.error("Factory-supplied MongoDB database connection already authenticated with differentcredentials but lost connection.");
        }
    }

    static {
        BSON.addDecodingHook(Level.class, (Transformer)new Transformer(){

            public Object transform(Object object) {
                if (object instanceof Level) {
                    return ((Level)((Object)object)).name();
                }
                return object;
            }
        });
    }
}

