/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.db.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.core.helpers.Strings;

@Converter(autoApply=false)
public class MarkerAttributeConverter
implements AttributeConverter<Marker, String> {
    public String convertToDatabaseColumn(Marker marker) {
        if (marker == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(marker.getName());
        int n = 0;
        boolean bl = false;
        for (Marker marker2 = marker.getParent(); marker2 != null; marker2 = marker2.getParent()) {
            ++n;
            bl = true;
            stringBuilder.append("[ ").append(marker2.getName());
        }
        for (int i = 0; i < n; ++i) {
            stringBuilder.append(" ]");
        }
        if (bl) {
            stringBuilder.append(" ]");
        }
        return stringBuilder.toString();
    }

    public Marker convertToEntityAttribute(String string) {
        if (Strings.isEmpty(string)) {
            return null;
        }
        int n = string.indexOf("[");
        return n < 1 ? MarkerManager.getMarker(string) : MarkerManager.getMarker(string.substring(0, n));
    }
}

