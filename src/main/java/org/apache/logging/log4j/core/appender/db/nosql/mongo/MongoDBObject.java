/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.nosql.mongo;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import java.util.Collections;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLObject;

public class MongoDBObject
implements NoSQLObject<BasicDBObject> {
    private final BasicDBObject mongoObject = new BasicDBObject();

    @Override
    public void set(String string, Object object) {
        this.mongoObject.append(string, object);
    }

    @Override
    public void set(String string, NoSQLObject<BasicDBObject> noSQLObject) {
        this.mongoObject.append(string, (Object)noSQLObject.unwrap());
    }

    @Override
    public void set(String string, Object[] objectArray) {
        BasicDBList basicDBList = new BasicDBList();
        Collections.addAll(basicDBList, objectArray);
        this.mongoObject.append(string, (Object)basicDBList);
    }

    @Override
    public void set(String string, NoSQLObject<BasicDBObject>[] noSQLObjectArray) {
        BasicDBList basicDBList = new BasicDBList();
        for (NoSQLObject<BasicDBObject> noSQLObject : noSQLObjectArray) {
            basicDBList.add((Object)noSQLObject.unwrap());
        }
        this.mongoObject.append(string, (Object)basicDBList);
    }

    @Override
    public BasicDBObject unwrap() {
        return this.mongoObject;
    }
}

