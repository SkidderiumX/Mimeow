/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.regex.Pattern;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFormatMessage;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.message.StringFormattedMessage;

public class FormattedMessage
implements Message {
    private static final long serialVersionUID = -665975803997290697L;
    private static final int HASHVAL = 31;
    private static final String FORMAT_SPECIFIER = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";
    private static final Pattern MSG_PATTERN = Pattern.compile("%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])");
    private String messagePattern;
    private transient Object[] argArray;
    private String[] stringArgs;
    private transient String formattedMessage;
    private final Throwable throwable;
    private Message message;

    public FormattedMessage(String string, Object[] objectArray, Throwable throwable) {
        this.messagePattern = string;
        this.argArray = objectArray;
        this.throwable = throwable;
    }

    public FormattedMessage(String string, Object[] objectArray) {
        this.messagePattern = string;
        this.argArray = objectArray;
        this.throwable = null;
    }

    public FormattedMessage(String string, Object object) {
        this.messagePattern = string;
        this.argArray = new Object[]{object};
        this.throwable = null;
    }

    public FormattedMessage(String string, Object object, Object object2) {
        this(string, new Object[]{object, object2});
    }

    @Override
    public String getFormattedMessage() {
        if (this.formattedMessage == null) {
            if (this.message == null) {
                this.message = this.getMessage(this.messagePattern, this.argArray, this.throwable);
            }
            this.formattedMessage = this.message.getFormattedMessage();
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

    protected Message getMessage(String string, Object[] objectArray, Throwable throwable) {
        try {
            MessageFormat messageFormat = new MessageFormat(string);
            Format[] formatArray = messageFormat.getFormats();
            if (formatArray != null && formatArray.length > 0) {
                return new MessageFormatMessage(string, objectArray);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (MSG_PATTERN.matcher(string).find()) {
                return new StringFormattedMessage(string, objectArray);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return new ParameterizedMessage(string, objectArray, throwable);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        FormattedMessage formattedMessage = (FormattedMessage)object;
        if (this.messagePattern != null ? !this.messagePattern.equals(formattedMessage.messagePattern) : formattedMessage.messagePattern != null) {
            return false;
        }
        return Arrays.equals(this.stringArgs, formattedMessage.stringArgs);
    }

    public int hashCode() {
        int n = this.messagePattern != null ? this.messagePattern.hashCode() : 0;
        n = 31 * n + (this.stringArgs != null ? Arrays.hashCode(this.stringArgs) : 0);
        return n;
    }

    public String toString() {
        return "FormattedMessage[messagePattern=" + this.messagePattern + ", args=" + Arrays.toString(this.argArray) + "]";
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
        if (this.throwable != null) {
            return this.throwable;
        }
        if (this.message == null) {
            this.message = this.getMessage(this.messagePattern, this.argArray, this.throwable);
        }
        return this.message.getThrowable();
    }
}

