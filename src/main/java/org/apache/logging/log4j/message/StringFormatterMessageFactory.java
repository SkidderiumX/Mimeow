/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import org.apache.logging.log4j.message.AbstractMessageFactory;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.StringFormattedMessage;

public class StringFormatterMessageFactory
extends AbstractMessageFactory {
    public static final StringFormatterMessageFactory INSTANCE = new StringFormatterMessageFactory();

    @Override
    public Message newMessage(String string, Object ... objectArray) {
        return new StringFormattedMessage(string, objectArray);
    }
}

