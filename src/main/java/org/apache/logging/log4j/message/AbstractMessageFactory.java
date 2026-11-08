/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.message.ObjectMessage;
import org.apache.logging.log4j.message.SimpleMessage;

public abstract class AbstractMessageFactory
implements MessageFactory {
    @Override
    public Message newMessage(Object object) {
        return new ObjectMessage(object);
    }

    @Override
    public Message newMessage(String string) {
        return new SimpleMessage(string);
    }

    @Override
    public abstract Message newMessage(String var1, Object ... var2);
}

