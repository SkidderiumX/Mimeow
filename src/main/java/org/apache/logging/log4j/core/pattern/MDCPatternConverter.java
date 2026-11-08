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

@Plugin(name="MDCPatternConverter", category="Converter")
@ConverterKeys(value={"X", "mdc", "MDC"})
public class MDCPatternConverter
extends LogEventPatternConverter {
    private final String key;

    private MDCPatternConverter(String[] stringArray) {
        super(stringArray != null && stringArray.length > 0 ? "MDC{" + stringArray[0] + "}" : "MDC", "mdc");
        this.key = stringArray != null && stringArray.length > 0 ? stringArray[0] : null;
    }

    public static MDCPatternConverter newInstance(String[] stringArray) {
        return new MDCPatternConverter(stringArray);
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        String string;
        Map<String, String> map = logEvent.getContextMap();
        if (this.key == null) {
            if (map == null || map.size() == 0) {
                stringBuilder.append("{}");
                return;
            }
            StringBuilder stringBuilder2 = new StringBuilder("{");
            TreeSet<String> treeSet = new TreeSet<String>(map.keySet());
            for (String string2 : treeSet) {
                if (stringBuilder2.length() > 1) {
                    stringBuilder2.append(", ");
                }
                stringBuilder2.append(string2).append("=").append(map.get(string2));
            }
            stringBuilder2.append("}");
            stringBuilder.append((CharSequence)stringBuilder2);
        } else if (map != null && (string = map.get(this.key)) != null) {
            stringBuilder.append((Object)string);
        }
    }
}

