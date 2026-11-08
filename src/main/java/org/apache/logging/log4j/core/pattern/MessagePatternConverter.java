/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MultiformatMessage;

@Plugin(name="MessagePatternConverter", category="Converter")
@ConverterKeys(value={"m", "msg", "message"})
public class MessagePatternConverter
extends LogEventPatternConverter {
    private final String[] formats;
    private final Configuration config;

    private MessagePatternConverter(Configuration configuration, String[] stringArray) {
        super("Message", "message");
        this.formats = stringArray;
        this.config = configuration;
    }

    public static MessagePatternConverter newInstance(Configuration configuration, String[] stringArray) {
        return new MessagePatternConverter(configuration, stringArray);
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        Message message = logEvent.getMessage();
        if (message != null) {
            String string = message instanceof MultiformatMessage ? ((MultiformatMessage)message).getFormattedMessage(this.formats) : message.getFormattedMessage();
            if (string != null) {
                stringBuilder.append(this.config != null && string.contains("${") ? this.config.getStrSubstitutor().replace(logEvent, string) : string);
            } else {
                stringBuilder.append("null");
            }
        }
    }
}

