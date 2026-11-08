/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.status;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.message.Message;

public class StatusData
implements Serializable {
    private static final long serialVersionUID = -4341916115118014017L;
    private final long timestamp = System.currentTimeMillis();
    private final StackTraceElement caller;
    private final Level level;
    private final Message msg;
    private final Throwable throwable;

    public StatusData(StackTraceElement stackTraceElement, Level level, Message message, Throwable throwable) {
        this.caller = stackTraceElement;
        this.level = level;
        this.msg = message;
        this.throwable = throwable;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public StackTraceElement getStackTraceElement() {
        return this.caller;
    }

    public Level getLevel() {
        return this.level;
    }

    public Message getMessage() {
        return this.msg;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public String getFormattedStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        stringBuilder.append(simpleDateFormat.format(new Date(this.timestamp)));
        stringBuilder.append(" ");
        stringBuilder.append(this.level.toString());
        stringBuilder.append(" ");
        stringBuilder.append(this.msg.getFormattedMessage());
        Object[] objectArray = this.msg.getParameters();
        Throwable throwable = this.throwable == null && objectArray != null && objectArray[objectArray.length - 1] instanceof Throwable ? (Throwable)objectArray[objectArray.length - 1] : this.throwable;
        if (throwable != null) {
            stringBuilder.append(" ");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            throwable.printStackTrace(new PrintStream(byteArrayOutputStream));
            stringBuilder.append(byteArrayOutputStream.toString());
        }
        return stringBuilder.toString();
    }
}

