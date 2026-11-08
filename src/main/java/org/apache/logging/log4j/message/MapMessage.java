/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.logging.log4j.message.MultiformatMessage;
import org.apache.logging.log4j.util.EnglishEnums;

public class MapMessage
implements MultiformatMessage {
    private static final long serialVersionUID = -5031471831131487120L;
    private final SortedMap<String, String> data;

    public MapMessage() {
        this.data = new TreeMap<String, String>();
    }

    public MapMessage(Map<String, String> map) {
        this.data = map instanceof SortedMap ? (SortedMap<Object, Object>)map : new TreeMap<String, String>(map);
    }

    @Override
    public String[] getFormats() {
        String[] stringArray = new String[MapFormat.values().length];
        int n = 0;
        for (MapFormat mapFormat : MapFormat.values()) {
            stringArray[n++] = mapFormat.name();
        }
        return stringArray;
    }

    @Override
    public Object[] getParameters() {
        return this.data.values().toArray();
    }

    @Override
    public String getFormat() {
        return "";
    }

    public Map<String, String> getData() {
        return Collections.unmodifiableMap(this.data);
    }

    public void clear() {
        this.data.clear();
    }

    public void put(String string, String string2) {
        if (string2 == null) {
            throw new IllegalArgumentException("No value provided for key " + string);
        }
        this.validate(string, string2);
        this.data.put(string, string2);
    }

    protected void validate(String string, String string2) {
    }

    public void putAll(Map<String, String> map) {
        this.data.putAll(map);
    }

    public String get(String string) {
        return (String)this.data.get(string);
    }

    public String remove(String string) {
        return (String)this.data.remove(string);
    }

    public String asString() {
        return this.asString((MapFormat)null);
    }

    public String asString(String string) {
        try {
            return this.asString(EnglishEnums.valueOf(MapFormat.class, string));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return this.asString();
        }
    }

    private String asString(MapFormat mapFormat) {
        StringBuilder stringBuilder = new StringBuilder();
        if (mapFormat == null) {
            this.appendMap(stringBuilder);
        } else {
            switch (mapFormat) {
                case XML: {
                    this.asXML(stringBuilder);
                    break;
                }
                case JSON: {
                    this.asJSON(stringBuilder);
                    break;
                }
                case JAVA: {
                    this.asJava(stringBuilder);
                    break;
                }
                default: {
                    this.appendMap(stringBuilder);
                }
            }
        }
        return stringBuilder.toString();
    }

    public void asXML(StringBuilder stringBuilder) {
        stringBuilder.append("<Map>\n");
        for (Map.Entry<String, String> entry : this.data.entrySet()) {
            stringBuilder.append("  <Entry key=\"").append(entry.getKey()).append("\">").append(entry.getValue()).append("</Entry>\n");
        }
        stringBuilder.append("</Map>");
    }

    @Override
    public String getFormattedMessage() {
        return this.asString();
    }

    @Override
    public String getFormattedMessage(String[] stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            return this.asString();
        }
        for (String string : stringArray) {
            for (MapFormat mapFormat : MapFormat.values()) {
                if (!mapFormat.name().equalsIgnoreCase(string)) continue;
                return this.asString(mapFormat);
            }
        }
        return this.asString();
    }

    protected void appendMap(StringBuilder stringBuilder) {
        boolean bl = true;
        for (Map.Entry<String, String> entry : this.data.entrySet()) {
            if (!bl) {
                stringBuilder.append(" ");
            }
            bl = false;
            stringBuilder.append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
    }

    protected void asJSON(StringBuilder stringBuilder) {
        boolean bl = true;
        stringBuilder.append("{");
        for (Map.Entry<String, String> entry : this.data.entrySet()) {
            if (!bl) {
                stringBuilder.append(", ");
            }
            bl = false;
            stringBuilder.append("\"").append(entry.getKey()).append("\":");
            stringBuilder.append("\"").append(entry.getValue()).append("\"");
        }
        stringBuilder.append("}");
    }

    protected void asJava(StringBuilder stringBuilder) {
        boolean bl = true;
        stringBuilder.append("{");
        for (Map.Entry<String, String> entry : this.data.entrySet()) {
            if (!bl) {
                stringBuilder.append(", ");
            }
            bl = false;
            stringBuilder.append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        stringBuilder.append("}");
    }

    public MapMessage newInstance(Map<String, String> map) {
        return new MapMessage(map);
    }

    public String toString() {
        return this.asString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        MapMessage mapMessage = (MapMessage)object;
        return this.data.equals(mapMessage.data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @Override
    public Throwable getThrowable() {
        return null;
    }

    public static enum MapFormat {
        XML,
        JSON,
        JAVA;

    }
}

