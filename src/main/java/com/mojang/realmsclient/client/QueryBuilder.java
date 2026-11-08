/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class QueryBuilder {
    private Map<String, String> queryParams = new HashMap<String, String>();

    public static QueryBuilder of(String string, String string2) {
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.queryParams.put(string, string2);
        return queryBuilder;
    }

    public static QueryBuilder empty() {
        return new QueryBuilder();
    }

    public QueryBuilder m844b01cbab(String string, String string2) {
        this.queryParams.put(string, string2);
        return this;
    }

    public QueryBuilder m005f514678(Object object, Object object2) {
        this.queryParams.put(String.valueOf(object), String.valueOf(object2));
        return this;
    }

    public String toQueryString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator2 = this.queryParams.keySet().iterator();
        if (!iterator2.hasNext()) {
            return null;
        }
        String string = iterator2.next();
        stringBuilder.append(string).append("=").append(this.encodeString(this.queryParams.get(string)));
        while (iterator2.hasNext()) {
            String string2 = iterator2.next();
            stringBuilder.append("&").append(string2).append("=").append(this.encodeString(this.queryParams.get(string2)));
        }
        return stringBuilder.toString();
    }

    private String encodeString(String string) {
        try {
            return URLEncoder.encode(string, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return string;
        }
    }
}

