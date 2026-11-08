/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import java.util.Map;
import org.apache.logging.log4j.message.MapMessage;
import org.apache.logging.log4j.message.StructuredDataId;
import org.apache.logging.log4j.util.EnglishEnums;

public class StructuredDataMessage
extends MapMessage {
    private static final long serialVersionUID = 1703221292892071920L;
    private static final int MAX_LENGTH = 32;
    private static final int HASHVAL = 31;
    private StructuredDataId id;
    private String message;
    private String type;

    public StructuredDataMessage(String string, String string2, String string3) {
        this.id = new StructuredDataId(string, null, null);
        this.message = string2;
        this.type = string3;
    }

    public StructuredDataMessage(String string, String string2, String string3, Map<String, String> map) {
        super(map);
        this.id = new StructuredDataId(string, null, null);
        this.message = string2;
        this.type = string3;
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String string, String string2) {
        this.id = structuredDataId;
        this.message = string;
        this.type = string2;
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String string, String string2, Map<String, String> map) {
        super(map);
        this.id = structuredDataId;
        this.message = string;
        this.type = string2;
    }

    private StructuredDataMessage(StructuredDataMessage structuredDataMessage, Map<String, String> map) {
        super(map);
        this.id = structuredDataMessage.id;
        this.message = structuredDataMessage.message;
        this.type = structuredDataMessage.type;
    }

    protected StructuredDataMessage() {
    }

    @Override
    public String[] getFormats() {
        String[] stringArray = new String[Format.values().length];
        int n = 0;
        for (Format format : Format.values()) {
            stringArray[n++] = format.name();
        }
        return stringArray;
    }

    public StructuredDataId getId() {
        return this.id;
    }

    protected void setId(String string) {
        this.id = new StructuredDataId(string, null, null);
    }

    protected void setId(StructuredDataId structuredDataId) {
        this.id = structuredDataId;
    }

    public String getType() {
        return this.type;
    }

    protected void setType(String string) {
        if (string.length() > 32) {
            throw new IllegalArgumentException("structured data type exceeds maximum length of 32 characters: " + string);
        }
        this.type = string;
    }

    @Override
    public String getFormat() {
        return this.message;
    }

    protected void setMessageFormat(String string) {
        this.message = string;
    }

    @Override
    protected void validate(String string, String string2) {
        this.validateKey(string);
    }

    private void validateKey(String string) {
        char[] cArray;
        if (string.length() > 32) {
            throw new IllegalArgumentException("Structured data keys are limited to 32 characters. key: " + string);
        }
        for (char c : cArray = string.toCharArray()) {
            if (c >= '!' && c <= '~' && c != '=' && c != ']' && c != '\"') continue;
            throw new IllegalArgumentException("Structured data keys must contain printable US ASCII charactersand may not contain a space, =, ], or \"");
        }
    }

    @Override
    public String asString() {
        return this.asString(Format.FULL, null);
    }

    @Override
    public String asString(String string) {
        try {
            return this.asString(EnglishEnums.valueOf(Format.class, string), null);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return this.asString();
        }
    }

    public final String asString(Format format, StructuredDataId structuredDataId) {
        String string;
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = Format.FULL.equals((Object)format);
        if (bl) {
            object = this.getType();
            if (object == null) {
                return stringBuilder.toString();
            }
            stringBuilder.append(this.getType()).append(" ");
        }
        if ((object = (object = this.getId()) != null ? ((StructuredDataId)object).makeId(structuredDataId) : structuredDataId) == null || ((StructuredDataId)object).getName() == null) {
            return stringBuilder.toString();
        }
        stringBuilder.append("[");
        stringBuilder.append(object);
        stringBuilder.append(" ");
        this.appendMap(stringBuilder);
        stringBuilder.append("]");
        if (bl && (string = this.getFormat()) != null) {
            stringBuilder.append(" ").append(string);
        }
        return stringBuilder.toString();
    }

    @Override
    public String getFormattedMessage() {
        return this.asString(Format.FULL, null);
    }

    @Override
    public String getFormattedMessage(String[] stringArray) {
        if (stringArray != null && stringArray.length > 0) {
            for (String string : stringArray) {
                if (Format.XML.name().equalsIgnoreCase(string)) {
                    return this.asXML();
                }
                if (!Format.FULL.name().equalsIgnoreCase(string)) continue;
                return this.asString(Format.FULL, null);
            }
            return this.asString(null, null);
        }
        return this.asString(Format.FULL, null);
    }

    private String asXML() {
        StringBuilder stringBuilder = new StringBuilder();
        StructuredDataId structuredDataId = this.getId();
        if (structuredDataId == null || structuredDataId.getName() == null || this.type == null) {
            return stringBuilder.toString();
        }
        stringBuilder.append("<StructuredData>\n");
        stringBuilder.append("<type>").append(this.type).append("</type>\n");
        stringBuilder.append("<id>").append(structuredDataId).append("</id>\n");
        super.asXML(stringBuilder);
        stringBuilder.append("</StructuredData>\n");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return this.asString(null, null);
    }

    @Override
    public MapMessage newInstance(Map<String, String> map) {
        return new StructuredDataMessage(this, map);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        StructuredDataMessage structuredDataMessage = (StructuredDataMessage)object;
        if (!super.equals(object)) {
            return false;
        }
        if (this.type != null ? !this.type.equals(structuredDataMessage.type) : structuredDataMessage.type != null) {
            return false;
        }
        if (this.id != null ? !this.id.equals(structuredDataMessage.id) : structuredDataMessage.id != null) {
            return false;
        }
        return !(this.message != null ? !this.message.equals(structuredDataMessage.message) : structuredDataMessage.message != null);
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + (this.type != null ? this.type.hashCode() : 0);
        n = 31 * n + (this.id != null ? this.id.hashCode() : 0);
        n = 31 * n + (this.message != null ? this.message.hashCode() : 0);
        return n;
    }

    public static enum Format {
        XML,
        FULL;

    }
}

