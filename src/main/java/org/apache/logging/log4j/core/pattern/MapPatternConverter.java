/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.util.Map;
import java.util.TreeSet;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.message.MapMessage;

@Plugin(name="MapPatternConverter", category="Converter")
@ConverterKeys(value={"K", "map", "MAP"})
public class MapPatternConverter
extends LogEventPatternConverter {
    private final String key;

    private MapPatternConverter(String[] stringArray) {
        super(stringArray != null && stringArray.length > 0 ? "MAP{" + stringArray[0] + "}" : "MAP", "map");
        this.key = stringArray != null && stringArray.length > 0 ? stringArray[0] : null;
    }

    public static MapPatternConverter newInstance(String[] stringArray) {
        return new MapPatternConverter(stringArray);
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        if (!(logEvent.getMessage() instanceof MapMessage)) {
            return;
        }
        MapMessage mapMessage = (MapMessage)logEvent.getMessage();
        Map<String, String> map = mapMessage.getData();
        if (this.key == null) {
            if (map.size() == 0) {
                stringBuilder.append("{}");
                return;
            }
            StringBuilder stringBuilder2 = new StringBuilder("{");
            TreeSet<String> treeSet = new TreeSet<String>(map.keySet());
            for (String string : treeSet) {
                if (stringBuilder2.length() > 1) {
                    stringBuilder2.append(", ");
                }
                stringBuilder2.append(string).append("=").append(map.get(string));
            }
            stringBuilder2.append("}");
            stringBuilder.append((CharSequence)stringBuilder2);
        } else {
            String string = map.get(this.key);
            if (string != null) {
                stringBuilder.append(string);
            }
        }
    }
}

