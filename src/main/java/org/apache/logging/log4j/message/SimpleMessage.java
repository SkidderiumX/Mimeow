/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import org.apache.logging.log4j.message.Message;

public class SimpleMessage
implements Message {
    private static final long serialVersionUID = -8398002534962715992L;
    private final String message;

    public SimpleMessage() {
        this(null);
    }

    public SimpleMessage(String string) {
        this.message = string;
    }

    @Override
    public String getFormattedMessage() {
        return this.message;
    }

    @Override
    public String getFormat() {
        return this.message;
    }

    @Override
    public Object[] getParameters() {
        return null;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        SimpleMessage simpleMessage = (SimpleMessage)object;
        return !(this.message == null ? simpleMessage.message != null : !this.message.equals(simpleMessage.message));
    }

    public int hashCode() {
        return this.message != null ? this.message.hashCode() : 0;
    }

    public String toString() {
        return "SimpleMessage[message=" + this.message + "]";
    }

    @Override
    public Throwable getThrowable() {
        return null;
    }
}

