/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.status.StatusLogger;

public class MessageFormatMessage
implements Message {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final long serialVersionUID = -665975803997290697L;
    private static final int HASHVAL = 31;
    private String messagePattern;
    private transient Object[] argArray;
    private String[] stringArgs;
    private transient String formattedMessage;
    private transient Throwable throwable;

    public MessageFormatMessage(String string, Object ... objectArray) {
        this.messagePattern = string;
        this.argArray = objectArray;
        if (objectArray != null && objectArray.length > 0 && objectArray[objectArray.length - 1] instanceof Throwable) {
            this.throwable = (Throwable)objectArray[objectArray.length - 1];
        }
    }

    @Override
    public String getFormattedMessage() {
        if (this.formattedMessage == null) {
            this.formattedMessage = this.formatMessage(this.messagePattern, this.argArray);
        }
        return this.formattedMessage;
    }

    @Override
    public String getFormat() {
        return this.messagePattern;
    }

    @Override
    public Object[] getParameters() {
        if (this.argArray != null) {
            return this.argArray;
        }
        return this.stringArgs;
    }

    protected String formatMessage(String string, Object ... objectArray) {
        try {
            return MessageFormat.format(string, objectArray);
        }
        catch (IllegalFormatException illegalFormatException) {
            LOGGER.error("Unable to format msg: " + string, (Throwable)illegalFormatException);
            return string;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        MessageFormatMessage messageFormatMessage = (MessageFormatMessage)object;
        if (this.messagePattern != null ? !this.messagePattern.equals(messageFormatMessage.messagePattern) : messageFormatMessage.messagePattern != null) {
            return false;
        }
        return Arrays.equals(this.stringArgs, messageFormatMessage.stringArgs);
    }

    public int hashCode() {
        int n = this.messagePattern != null ? this.messagePattern.hashCode() : 0;
        n = 31 * n + (this.stringArgs != null ? Arrays.hashCode(this.stringArgs) : 0);
        return n;
    }

    public String toString() {
        return "StringFormatMessage[messagePattern=" + this.messagePattern + ", args=" + Arrays.toString(this.argArray) + "]";
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        this.getFormattedMessage();
        objectOutputStream.writeUTF(this.formattedMessage);
        objectOutputStream.writeUTF(this.messagePattern);
        objectOutputStream.writeInt(this.argArray.length);
        this.stringArgs = new String[this.argArray.length];
        int n = 0;
        for (Object object : this.argArray) {
            this.stringArgs[n] = object.toString();
            ++n;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.formattedMessage = objectInputStream.readUTF();
        this.messagePattern = objectInputStream.readUTF();
        int n = objectInputStream.readInt();
        this.stringArgs = new String[n];
        for (int i = 0; i < n; ++i) {
            this.stringArgs[i] = objectInputStream.readUTF();
        }
    }

    @Override
    public Throwable getThrowable() {
        return this.throwable;
    }
}

