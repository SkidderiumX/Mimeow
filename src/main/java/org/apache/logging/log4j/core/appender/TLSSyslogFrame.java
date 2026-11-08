/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

public class TLSSyslogFrame {
    public static final char SPACE = ' ';
    private String message;
    private int messageLengthInBytes;

    public TLSSyslogFrame(String string) {
        this.setMessage(string);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String string) {
        this.message = string;
        this.setLengthInBytes();
    }

    private void setLengthInBytes() {
        this.messageLengthInBytes = this.message.length();
    }

    public byte[] getBytes() {
        String string = this.toString();
        return string.getBytes();
    }

    public String toString() {
        String string = Integer.toString(this.messageLengthInBytes);
        return string + ' ' + this.message;
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public boolean equals(TLSSyslogFrame tLSSyslogFrame) {
        return this.isLengthEquals(tLSSyslogFrame) && this.isMessageEquals(tLSSyslogFrame);
    }

    private boolean isLengthEquals(TLSSyslogFrame tLSSyslogFrame) {
        return this.messageLengthInBytes == tLSSyslogFrame.messageLengthInBytes;
    }

    private boolean isMessageEquals(TLSSyslogFrame tLSSyslogFrame) {
        return this.message.equals(tLSSyslogFrame.message);
    }
}

