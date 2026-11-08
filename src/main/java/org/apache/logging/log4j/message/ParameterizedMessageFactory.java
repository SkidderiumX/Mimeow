/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import org.apache.logging.log4j.message.AbstractMessageFactory;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.ParameterizedMessage;

public class ParameterizedMessageFactory
extends AbstractMessageFactory {
    public static final ParameterizedMessageFactory INSTANCE = new ParameterizedMessageFactory();

    @Override
    public Message newMessage(String string, Object ... objectArray) {
        return new ParameterizedMessage(string, objectArray);
    }
}

