/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import java.util.ResourceBundle;
import org.apache.logging.log4j.message.AbstractMessageFactory;
import org.apache.logging.log4j.message.LocalizedMessage;
import org.apache.logging.log4j.message.Message;

public class LocalizedMessageFactory
extends AbstractMessageFactory {
    private final ResourceBundle bundle;
    private final String bundleId;

    public LocalizedMessageFactory(ResourceBundle resourceBundle) {
        this.bundle = resourceBundle;
        this.bundleId = null;
    }

    public LocalizedMessageFactory(String string) {
        this.bundle = null;
        this.bundleId = string;
    }

    @Override
    public Message newMessage(String string, Object ... objectArray) {
        if (this.bundle == null) {
            return new LocalizedMessage(this.bundleId, string, objectArray);
        }
        return new LocalizedMessage(this.bundle, string, objectArray);
    }
}

