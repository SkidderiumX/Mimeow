/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.nosql.couch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.core.appender.db.nosql.NoSQLObject;

public class CouchDBObject
implements NoSQLObject<Map<String, Object>> {
    private final Map<String, Object> map = new HashMap<String, Object>();

    @Override
    public void set(String string, Object object) {
        this.map.put(string, object);
    }

    @Override
    public void set(String string, NoSQLObject<Map<String, Object>> noSQLObject) {
        this.map.put(string, noSQLObject.unwrap());
    }

    @Override
    public void set(String string, Object[] objectArray) {
        this.map.put(string, Arrays.asList(objectArray));
    }

    @Override
    public void set(String string, NoSQLObject<Map<String, Object>>[] noSQLObjectArray) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
        for (NoSQLObject<Map<String, Object>> noSQLObject : noSQLObjectArray) {
            arrayList.add(noSQLObject.unwrap());
        }
        this.map.put(string, arrayList);
    }

    @Override
    public Map<String, Object> unwrap() {
        return this.map;
    }
}

